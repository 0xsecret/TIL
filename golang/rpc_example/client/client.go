package main

import (
  "net"
  "net/http"
  "net/rpc"
)

type Args struct {
  A, B int
}

type Arith int

func (t *Arith) Multiply(args *Args, reply *int) error {
  *reply = args.A * args.B
  return nil
}

func main() {
  arith := new(Arith)
  rpc.Register(arith)
  rpc.HandleHTTP()
  l, _ := net.Listen("tcp", ":1234")
  http.Serve(l, nil)

}
