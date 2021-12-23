/*
* This program prints out
* the Magic Sqaures.
*
* @author  Malcolm Tompkins
* @version 1.0
* @since   2021-12-22
*/

/**
* MagicNumber Class.
*/
final class MagicNumber {
    /** The middle left index. */
    public static final int THREE = 3;
    /** The center index. */
    public static final int FOUR = 4;
    /** The middle right index. */
    public static final int FIVE = 5;
    /** The lower left index. */
    public static final int SIX = 6;
    /** The lower center index. */
    public static final int SEVEN = 7;
    /** The lower right index. */
    public static final int EIGHT = 8;
    /** The maximum number for magicNumbers. */
    public static final int NINE = 9;
    /** The maximum number for magicNumbers. */
    public static final int MAGICNUM = 15;

    /**
    * MagicNumber Constructor.
    *
    * @throws IllegalStateException throws Exception
    */
    private MagicNumber() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }
    /**
    * Function that generates the magic square through recursion.
    *
    * @param square first instance of square
    * @param currentSquare square made into the magic square
    * @param index index of the recursive call
    */

    public static void genSquare(final int[] square, final int[] currentSquare,
                                 final int index) {
        // generate the magic sqaure
        for (int counter = 0; counter < square.length; counter++) {
            if (currentSquare[counter] == 0) {
                // incriment to the next step
                square[index] = counter + 1;
                currentSquare[counter] = 1;

                // only fill in spots that have not yet been filled in
                if (index < square.length - 1) {
                    genSquare(square, currentSquare, index + 1);
                } else if (isMagic(square)) {
                    // checks if square is magic after spots are filled
                    printMagicSquare(square);
                }
                currentSquare[counter] = 0;
            }
        }
    }

    /**
    * Function that checks if a given square is a magic square.
    *
    * @param preSquare given square
    *
    * @return true or false if preSquare is a magic square or not
    */
    public static boolean isMagic(final int[] preSquare) {
        // returns true or false for whether or not array is a magic square
        final int row1 = preSquare[0] + preSquare[1] + preSquare[2];
        final int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
        final int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
        final int col1 = preSquare[0] + preSquare[THREE] + preSquare[SIX];
        final int col2 = preSquare[1] + preSquare[FOUR] + preSquare[SEVEN];
        final int col3 = preSquare[2] + preSquare[FIVE] + preSquare[EIGHT];
        final int diag1 = preSquare[0] + preSquare[FOUR] + preSquare[EIGHT];
        final int diag2 = preSquare[2] + preSquare[FOUR] + preSquare[SIX];

        return row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM
               && col1 == MAGICNUM && col2 == MAGICNUM
               && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM;
    }

    /**
    * Function that prints the magic square.
    *
    * @param outputSquare The final instance of the magic square
    */
    public static void printMagicSquare(final int[] outputSquare) {
        // prints inputted array in a magic square format
        final String squareBorder = "*****";
        final String newLine = "\n";
        final String whiteSpace = " ";
        System.out.println(newLine + squareBorder);
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + whiteSpace);
            } else {
                System.out.print(outputSquare[count] + whiteSpace);
            }
        }
        System.out.println(newLine + squareBorder);
    }

    /**
    * Main function().
    *
    * @param args Unused parameter
    */
    public static void main(final String[] args) {
        // main stub, get user input here
        final int[] magicSquare = {1, 2, THREE, FOUR, FIVE,
            SIX, SEVEN, EIGHT, NINE};
        final int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare(magicSquare, extraArray, 0);
    }
}
