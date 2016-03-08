package main

import (
  "fmt"
  "net/rpc"
)

type Args struct {
  A, B int
}

type Arith int

func main() {

  client, _ := rpc.DialHTTP("tcp", ":1234")
  args := Args{2, 3}
  var result int

  //Synchronous call
  client.Call("Arith.Multiply", args, &result)
  fmt.Printf("%d*%d=%d\n", args.A, args.B, result)

  args.A = 3
  args.B = 4

  //Asynchronous call
  mulCall := client.Go("Arith.Multiply", args, &result, nil)
  <-mulCall.Done
  fmt.Printf("%d*%d=%d\n", args.A, args.B, result)
}
