/**
* @file 	seive_of_eratosthenes.go
* @brief 	Practice a concurrent prime sieve(goroutine, channel)
**/
package main

func GenerateNumber(ch chan<- int) {
	for i := 2; ; i++ {
		ch <- i
	}
}

func Filter(in <-chan int, out chan<- int, prime int) {
	for {
		i := <-in
		if i%prime != 0 {
			out <- i
		}
	}
}

func GetPrime(num int) {
	ch := make(chan int)
	go GenerateNumber(ch)

	for i := 0; i < num; i++ {
		prime := <-ch
		print(prime, "\n")
		ch1 := make(chan int)
		go Filter(ch, ch1, prime)
		ch = ch1
	}
}

func main() {
	GetPrime(1000)
}
