#include <stdio.h>

#define TYPE_OF(X) _Generic( (X), int: "int", float: "float", const int:"const int")

int main() {
  int a;
  float b;
  const int c;
  printf("%s\n", TYPE_OF(a));
  printf("%s\n", TYPE_OF(b));
  printf("%s\n", TYPE_OF(c));
  //For gcc, c matches int
  //For clang, c matches const int
  //The lvalue conversions of the controlling expressions
  //are still an open issue.

  return 0;
}
