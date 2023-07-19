package org.example.ReciprocalCycles;

import java.util.HashMap;

public class ReciprocalCycles {

    public static int reciprocalCycles(int number) {
        int result = 0;
        int resultDigits = 0;
        int resultDigits2 = 0;
        int numberRecyprocalCycle = 0;

        for (int counter = 2; counter <= number; counter++) {
            numberRecyprocalCycle = fractionToDecimal(1, counter);

            resultDigits2 = howManyDigitsHasNumber(numberRecyprocalCycle);

            if (resultDigits < resultDigits2){
                resultDigits = resultDigits2;
                result = numberRecyprocalCycle;
            }
        }


        return result;
    }

    private static int howManyDigitsHasNumber(int number) {
        int digits = 0;
        int temp = number;

        while (temp > 0){
            digits++;
            temp /= 10;
        }
        return digits;
    }


    // This function returns repeating
    // sequence of a fraction. If
    // repeating sequence doesn't
    // exist, then returns empty String
    public static int fractionToDecimal(int numr, int denr)
    {
        // Initialize result
        int res = 0;

        // Create a map to store already
        // seen remainders. Remainder is
        // used as key and its position in
        // result is stored as value.
        // Note that we need position for
        // cases like 1/6.  In this case,
        // the recurring sequence doesn't
        // start from first remainder.
        HashMap<Integer, Integer> mp = new HashMap<>();

        // Find first remainder
        int rem = numr % denr;

        // Keep finding remainder until
        //  either remainder becomes 0 or repeats
        while ((rem != 0) && (!mp.containsKey(rem)))
        {
            // Store this remainder
            mp.put(rem, howManyDigitsHasNumber(res));
            
            // Multiply remainder with 10
            rem = rem * 10;

            // Append rem / denr to result
            int res_part = rem / denr;
            res = (res * 10) + res_part;

            // Update remainder
            rem = rem % denr;
        }

        if (mp.containsKey(rem))
            return res;
        else
            return 0;
    }

}
