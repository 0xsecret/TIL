#include <stdio.h>
#include <pthread.h>
#include <stdatomic.h>

atomic_int acnt;
int cnt;

void* f(void* thr_data) {
  for(int n = 0; n < 1000; ++n) {
    ++cnt;
    ++acnt;
  }
}

int main(void) {
  pthread_t thr[10];
  for(int n = 0; n < 10; ++n) {
    pthread_create(&thr[n], NULL, f, NULL);
  }

  for(int n = 0; n < 10; ++n) {
    pthread_join(thr[n], NULL);
  }

  printf("atomic count : %d\n", acnt);
  printf("non-atomic count : %d\n", cnt);
}
