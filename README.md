# Lab 08 — Method Design and Overloading

| | |
|---|---|
| **Week** | 9 |
| **Textbook** | Liang — **Chapter 6** (Overloading, Stepwise Refinement) |
| **Time budget** | 60 minutes |
| **Points** | 100 |

---

## Learning Objectives

1. Define overloaded methods and explain how the compiler selects among them.
2. Implement Euclid's algorithm with a `while` loop.
3. Decompose an integer digit by digit using `% 10` and `/ 10`.
4. Traverse a string with `charAt` inside a loop.
5. Defend a method against `null` input.

---

## Background

**Overloading** means several methods share one name and are distinguished by their parameter
lists. The choice is made by the **compiler**, from the static type of the argument:

```java
describe(5);      // int literal    -> describe(int)
describe(5.5);    // double literal -> describe(double)
describe("5");    // String literal -> describe(String)
```

Return type alone cannot distinguish overloads — two methods differing only in return type will
not compile.

**Euclid's algorithm.** Repeatedly replace the pair (a, b) with (b, a mod b) until b is 0; the
answer is a.

** How the Algorithm Works


| a | b | a % b |
|---|---|---|
| 48 | 18 | 12 |
| 18 | 12 | 6 |
| 12 | 6 | 0 |
| 6 | 0 | — → answer is 6 |


```java

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


```

**Digit extraction.** `n % 10` yields the last digit; `n / 10` removes it (integer division):

```java
int result = 0;
while (n > 0) {
    result = result * 10 + n % 10;  // shift the result left, then append the extracted digit
    n /= 10;                        // discard the digit just consumed
}
```

`1200` reverses to `21`, because the leading zeros of `0021` are not representable in an `int`.
That is correct behaviour, and the driver checks it.

**Defensive programming.** `text.length()` on a `null` reference throws `NullPointerException`.
Because a library method cannot control who calls it, `countVowels(null)` must return 0 and
`isPalindrome(null)` must return `false`. Check for `null` **first**: `&&` and `||` are
short-circuit operators, so `if (text == null || text.isEmpty())` is safe, while the reverse order
is not.

---

## Instructions

| Step | Method | Requirement |
|---|---|---|
| 1 | `describe(int)` | Returns `int: 5` |
| 2 | `describe(double)` | Returns `double: 5.5` |
| 3 | `describe(String)` | Returns `String: hello` |
| 4 | `gcd(int, int)` | Euclid's algorithm; return 0 if either argument is negative |
| 5 | `reverseDigits(int)` | `1234` → `4321`; `1200` → `21`; `0` → `0`; negative → `-1` |
| 6 | `countVowels(String)` | a, e, i, o, u in either case; `null` → 0 |
| 7 | `isPalindrome(String)` | Case-insensitive; `null` → `false` |
| 8 | `main` | Demonstrate each method |

**On Step 7:** compare the character at index `i` with the character at index `length - 1 - i`,
looping only to `length / 2` — beyond the midpoint you would be re-checking pairs already
verified. A single character is trivially a palindrome.

---

## Commenting Standard (20 points)

```java
// WEAK
while (b != 0) { // loop

// STRONG
// Euclid's algorithm: the gcd of (a, b) equals the gcd of (b, a mod b), and the
// remainder strictly decreases, so the loop is guaranteed to reach b == 0.
while (b != 0) {
```

---

## Compile, Run, and Test

```bash

```

---

## Grading Rubric

| Criterion | Points |
|---|---|
| All 25 checks pass | 60 |
| Line comments explain every statement, including the algorithms | 20 |
| Overloads correct, `null` guarded, loop bounds justified | 10 |
| Committed and pushed on time | 10 |

---

## Submission Checklist

- [ ] `bash tools/run_lab.sh lab08` reports 25 of 25.
- [ ] `countVowels(null)` and `isPalindrome(null)` do not throw.
- [ ] `gcd(12, 0)` returns 12.

```bash
git add . && git commit -m "Lab 08 complete - all 25 checks passing" && git push
```

---

## Stretch Goal

Add `public static boolean isPalindrome(String text, boolean ignorePunctuation)` — a fourth
overload — so that `"A man, a plan, a canal: Panama"` is recognised as a palindrome. Reuse your
existing two-argument logic rather than duplicating it.

---

## Troubleshooting

| Symptom | Cause | Fix |
|---|---|---|
| `reference to describe is ambiguous` | Two overloads have identical parameter lists | Make the parameter types distinct |
| `describe(5)` returns the double version | The `int` overload is missing | Add `describe(int)` |
| `gcd` loops forever | Assignments performed in the wrong order | Save `b` in a temporary before overwriting it |
| `NullPointerException` | Length checked before the `null` test | Test `null` first; `||` short-circuits |
| `reverseDigits(1200)` returns 210 or 0021 | Trailing-zero handling | `21` is correct; leading zeros cannot exist in an `int` |

