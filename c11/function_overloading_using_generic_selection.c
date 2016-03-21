#include <stdio.h>

#define square(X) _Generic( (X), int: squarei, float: squaref, double: squared)(X)

float squaref(float x) {
  return x*x;
}

double squared(double x) {
  return x*x;
}

int squarei(int x) {
  return x*x;
}

int main() {
  int a = 3;
  float b = 3.0f;
  double c = 3.0;
  a = square(a);
  b = square(b);
  c = square(c);
  printf("%d %f %f", a, b, c);
  return 0;
}
