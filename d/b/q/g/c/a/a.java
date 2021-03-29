package d.b.q.g.c.a;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f64446a = "0123456789ABCDEF".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f64447b = "0123456789abcdef".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f64448c = new byte[128];

    static {
        for (int i = 0; i < 10; i++) {
            byte[] bArr = f64448c;
            bArr[i + 48] = (byte) i;
            byte b2 = (byte) (i + 10);
            bArr[i + 65] = b2;
            bArr[i + 97] = b2;
        }
    }

    public static char[] a(byte[] bArr, boolean z) {
        char[] cArr = z ? f64446a : f64447b;
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b2 & 240) >>> 4];
            i = i2 + 1;
            cArr2[i2] = cArr[b2 & 15];
        }
        return cArr2;
    }

    public static String b(byte[] bArr, boolean z) {
        return new String(a(bArr, z));
    }
}
