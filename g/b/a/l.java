package g.b.a;
/* loaded from: classes7.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f67614a = new byte[1024];

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f67615b = new int[1024];

    public static void a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i3 + 1024, i2) - i3;
            System.arraycopy(f67614a, 0, bArr, i + i3, min);
            i3 += min;
        }
    }

    public static void b(int[] iArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int min = Math.min(i3 + 1024, i2) - i3;
            System.arraycopy(f67615b, 0, iArr, i + i3, min);
            i3 += min;
        }
    }
}
