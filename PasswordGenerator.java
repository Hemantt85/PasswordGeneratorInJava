import java.util.*;

public class PasswordGenerator {
    
    // Method to generate random password
    public static String generatePassword(int length) {
        // Characters set
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String symbols = "!@#$%^&*()-_=+<>?";
        
        String allChars = upper + lower + digits + symbols;
        Random random = new Random();
        
        // StringBuilder to build password
        StringBuilder password = new StringBuilder();
        
        // Ensure at least one from each category
        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(symbols.charAt(random.nextInt(symbols.length())));
        
        // Remaining characters
        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }
        
        // Shuffle for randomness
        List<Character> passList = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            passList.add(c);
        }
        Collections.shuffle(passList);
        
        // Convert back to String
        StringBuilder finalPass = new StringBuilder();
        for (char c : passList) {
            finalPass.append(c);
        }
        
        return finalPass.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password length: ");
        int length = sc.nextInt();
        
        if (length < 4) {
            System.out.println("Password length should be at least 4!");
        } else {
            String password = generatePassword(length);
            System.out.println("Generated Password: " + password);
        }
        
        sc.close();
    }
}
