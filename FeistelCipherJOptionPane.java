/*import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FeistelCipherJOptionPane {

    // Feistel function
    private static String feistelFunction(String right, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < right.length(); i++) {
            result.append((char) (right.charAt(i) ^ key.charAt(i)));
        }
        return result.toString();
    }

    // Generate a random key for each round
    private static List<String> generateRoundKeys(int numRounds, int length) {
        List<String> keys = new ArrayList<>();
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < numRounds; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < length; j++) {
                key.append(characters.charAt(random.nextInt(characters.length())));
            }
            keys.add(key.toString());
        }
        return keys;
    }

    // Split text into two halves
    private static String[] splitText(String text) {
        int mid = text.length() / 2;
        String left = text.substring(0, mid);
        String right = text.substring(mid);
        return new String[]{left, right};
    }

    // Feistel Cipher (both encryption and decryption)
    private static String feistelCipher(String text, int numRounds, List<String> keys, String mode) {
        String[] halves = splitText(text);
        String left = halves[0];
        String right = halves[1];

        for (int i = 0; i < numRounds; i++) {
            String roundKey = mode.equals("encrypt") ? keys.get(i) : keys.get(numRounds - 1 - i);
            String tempRight = right;
            right = "";
            for (int j = 0; j < left.length(); j++) {
                right += (char) (left.charAt(j) ^ feistelFunction(tempRight, roundKey).charAt(j));
            }
            left = tempRight;
        }
        return left + right;
    }

    public static void main(String[] args) {
        String mode = JOptionPane.showInputDialog(null, "Enter mode (encrypt/decrypt):").trim().toLowerCase();
        int numRounds = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of rounds:"));

        if (mode.equals("encrypt")) {
            String text = JOptionPane.showInputDialog(null, "Enter plaintext:").trim();
            List<String> keys = generateRoundKeys(numRounds, text.length() / 2);
            String encryptedText = feistelCipher(text, numRounds, keys, mode);
            JOptionPane.showMessageDialog(null, "Encrypted text: " + encryptedText + "\nRound keys: " + keys);
        } else if (mode.equals("decrypt")) {
            String text = JOptionPane.showInputDialog(null, "Enter ciphertext:").trim();
            String keysInput = JOptionPane.showInputDialog(null, "Enter round keys (comma-separated):").trim();
            String[] keysArray = keysInput.split(",");
            List<String> keys = new ArrayList<>();
            for (String key : keysArray) {
                keys.add(key);
            }
            String decryptedText = feistelCipher(text, numRounds, keys, mode);
            JOptionPane.showMessageDialog(null, "Decrypted text: " + decryptedText);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid mode. Please enter 'encrypt' or 'decrypt'.");
        }
    }
}*/

import javax.swing.*;
import java.util.Random;

public class FeistelCipherJOptionPane {

    // Feistel function
    private static String feistelFunction(String right, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < right.length(); i++) {
            result.append((char) (right.charAt(i) ^ key.charAt(i)));
        }
        return result.toString();
    }

    // Generate a random key for each round
    private static String[] generateRoundKeys(int numRounds, int length) {
        String[] keys = new String[numRounds];
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < numRounds; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < length; j++) {
                key.append(characters.charAt(random.nextInt(characters.length())));
            }
            keys[i] = key.toString();
        }
        return keys;
    }

    // Split text into two halves
    private static String[] splitText(String text) {
        int mid = text.length() / 2;
        String left = text.substring(0, mid);
        String right = text.substring(mid);
        return new String[]{left, right};
    }

    // Feistel Cipher (both encryption and decryption)
    private static String feistelCipher(String text, int numRounds, String[] keys, String mode) {
        String[] halves = splitText(text);
        String left = halves[0];
        String right = halves[1];

        for (int i = 0; i < numRounds; i++) {
            String roundKey = mode.equals("encrypt") ? keys[i] : keys[numRounds - 1 - i];
            String tempRight = right;
            right = "";
            for (int j = 0; j < left.length(); j++) {
                right += (char) (left.charAt(j) ^ feistelFunction(tempRight, roundKey).charAt(j));
            }
            left = tempRight;
        }
        return left + right;
    }

    public static void main(String[] args) {
        String mode = JOptionPane.showInputDialog(null, "Enter mode (encrypt/decrypt):").trim().toLowerCase();
        int numRounds = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of rounds:"));

        if (mode.equals("encrypt")) {
            String text = JOptionPane.showInputDialog(null, "Enter plaintext:").trim();
            String[] keys = generateRoundKeys(numRounds, text.length() / 2);
            String encryptedText = feistelCipher(text, numRounds, keys, mode);
            JOptionPane.showMessageDialog(null, "Encrypted text: " + encryptedText + "\nRound keys: " + String.join(",", keys));
        } else if (mode.equals("decrypt")) {
            String text = JOptionPane.showInputDialog(null, "Enter ciphertext:").trim();
            String keysInput = JOptionPane.showInputDialog(null, "Enter round keys (comma-separated):").trim();
            String[] keys = keysInput.split(",");
            String decryptedText = feistelCipher(text, numRounds, keys, mode);
            JOptionPane.showMessageDialog(null, "Decrypted text: " + decryptedText);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid mode. Please enter 'encrypt' or 'decrypt'.");
        }
    }
}
