package main

import "time"
import "fmt"

func main() {
  var Ball int
  table := make(chan int)
  for i := 0; i < 100; i++ {
    go player(table, i)
  }

  Ball = 1
  table <- Ball

  time.Sleep(3 * time.Second)
  <-table
}

func player(table chan int, playerNumber int) {
  for {
    ball := <-table
    fmt.Println("player : ", playerNumber, "ball : ", ball)
    ball++
    time.Sleep(100 * time.Millisecond)
    table <- ball
  }
}
