package g.b.a;
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f71720a = new byte[1024];

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f71721b = new int[1024];

    public static void a(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i3) {
            int min = Math.min(i4 + 1024, i3) - i4;
            System.arraycopy(f71720a, 0, bArr, i2 + i4, min);
            i4 += min;
        }
    }

    public static void b(int[] iArr, int i2, int i3) {
        int i4 = 0;
        while (i4 < i3) {
            int min = Math.min(i4 + 1024, i3) - i4;
            System.arraycopy(f71721b, 0, iArr, i2 + i4, min);
            i4 += min;
        }
    }
}
