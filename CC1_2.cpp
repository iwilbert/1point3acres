#include <iostream>
using namespace std;

void swap(char *a, char *b)
{
	char *t = a;
	a = b;
	b = t;
}

void reverse(char* str)
{
    // get the length of the string
    int len;
    for(len = 0; str[len] != '\0'; len++);
    // swap front and end
    for(int i = 0, j = len - 1; i < j; i++, j--)
        swap(str[i], str[j]);
}

int main()
{
    char str[] = "abcdefghijklmnopqrstuvwxyz";
    reverse(str);
    cout << str << endl;
    return 0;
}
