// Represents algebraic operations as functions.
public class PrimeOps {
	public static void main(String args[]) {
		// Some tests of the class functions
		int[] arr = sieve(50);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	// Returns an array of all prime numbers up to any given number.
	// Assumption: n is nonnegative.
	public static int[] sieve(int n) {

		boolean[] isprime = new boolean[n];
		int x = 0;
		for (int i = 0; (i < n); i++) {
			for (int j = 2; (j < i); j++) {
				if (i == 1) {
					isprime[i] = false;
					break;

				} else if ((i % j) == 0) {
					isprime[i] = false;
					break;
				} else {
					isprime[i] = true;
				}
			}
			if (isprime[i] == true) {
				x++;
			}
		}
		int[] arr = new int[x + 1];
		if (n >= 2) {
			arr[0] = 2;
		}
		int j = 1;
		for (int i = 3; i < n; i++) {
			if (isprime[i] == true) {
				arr[j] = i;
				j++;
			}
		}
		return arr;
	}
}
