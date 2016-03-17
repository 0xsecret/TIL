package main

import (
  "fmt"
  "sync"
  "time"
)

const (
  WORKERS    = 5
  SUBWORKERS = 3
  TASKS      = 20
  SUBTASKS   = 10
)

func subworker(subtasks chan int, subworkerNum int, workerNum int) {
  for {
    task, ok := <-subtasks
    if !ok {
      return
    }
    time.Sleep(time.Duration(task) * time.Millisecond)
    fmt.Println("worker #", workerNum, "subworker #", subworkerNum, task)
  }
}

func worker(tasks <-chan int, wg *sync.WaitGroup, workerNum int) {
  defer wg.Done()
  for {
    task, ok := <-tasks
    if !ok {
      return
    }
    subtasks := make(chan int)
    for i := 0; i < SUBWORKERS; i++ {
      go subworker(subtasks, i, workerNum)
    }
    for i := 0; i < SUBTASKS; i++ {
      task1 := task * i
      subtasks <- task1
    }
    close(subtasks)
  }
}

func main() {
  var wg sync.WaitGroup
  wg.Add(WORKERS)
  tasks := make(chan int)

  for i := 0; i < WORKERS; i++ {
    go worker(tasks, &wg, i)
  }

  for i := 0; i < TASKS; i++ {
    tasks <- i
  }

  close(tasks)
  wg.Wait()
}
