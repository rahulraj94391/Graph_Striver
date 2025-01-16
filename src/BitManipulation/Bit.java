package BitManipulation;

public class Bit {
    public static void main(String[] args) {

    }
}

class BitUtil {
    public static boolean isSet(int num, int ind) {
        return (num & (1 << ind)) != 0;
    }

    public static int setBit(int num, int ind) {
        return num | (1 << ind);
    }

    public static int unsetBit(int num, int ind) {
        return num & ~(1 << ind);
    }

    public static int toggleBit(int num, int ind) {
        // make 0 to 1 or vice versa
        return num ^ (1 << ind);
    }

    public static int clearRightmostSetBit(int num) {
        // make 0 to 1 or vice versa
        return num & (num - 1);
    }

    public static boolean isPowerOfTwo(int num) {
        return clearRightmostSetBit(num) == 0;
    }


    public static int clearBit(int num, int ind) {
        return num & ~(1 << ind);
    }

    public static int countSetBits(int num) {
        return Integer.bitCount(num);
    }

    public static int reverseBits(int num) {
        return Integer.reverse(num);
    }

    public static int getNumberOfLeadingZeros(int num) {
        // Binary: 1000
        return Integer.numberOfLeadingZeros(num); // Output: 28
    }

    public static int getNumberOfTrailingZeros(int num) {
        // Binary: 1000
        return Integer.numberOfTrailingZeros(num); // Output: 3
    }

    public static int getHighestOneBit(int num) {
        // Binary: 10010
        return Integer.highestOneBit(num); // Output: 16 (Binary: 10000)
    }

    public static int getLowestOneBit(int num) {
        // Binary: 10010
        return Integer.lowestOneBit(num); // Output: 2 (Binary: 10)
    }

    public static int getComplement(int num) {
        return ~num;
    }

    public static int parseBinaryToInteger(String binaryString) {
        return Integer.parseInt(binaryString, 2);
    }

    public static String convertIntegerToBinary(int num) {
        return Integer.toBinaryString(num);
    }

    public static int rotateLeft(int num, int times) {
        return Integer.rotateLeft(num, times);
    }

    public static int rotateRight(int num, int times) {
        return Integer.rotateRight(num, times);
    }

    public static String to32BitBinaryString(int number) {
        return String.format("%32s", Integer.toBinaryString(number)).replace(' ', '0');
    }

    public static int rightShiftK(int number, int times) {
        return (int) (number / Math.pow(2, times));
    }
}

