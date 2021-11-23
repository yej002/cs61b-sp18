public class OffByN implements CharacterComparator {
    public int N;
    public OffByN(int N) {
        this.N = N;
    }

    public boolean equalChars(char x, char y) {
        int diff = Math.abs((int) x - (int) y);
        return (diff == N);
    }
}