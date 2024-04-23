public class Main {
    public static void main(String[] args) {
        Integer a = (int) 'Z';
        String binary = "0" + Integer.toBinaryString(a);
        System.out.println(binary);
    }
}
