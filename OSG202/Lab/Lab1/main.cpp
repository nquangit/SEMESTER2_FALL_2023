#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main () {
  pid_t pChild;
  printf("The main processID is %d\n", getpid());
  pChild  = fork();
  if (pChild !=0) {
    printf("The parent ID of new is %d\n", getpid());
    printf("The new child ID is %d\n", pChild);
  } else {
    printf("The child Id is %d\n", getpid());
  }
}
