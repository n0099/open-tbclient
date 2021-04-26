package d.a.q.g.c.a;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f63723a = "0123456789ABCDEF".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f63724b = "0123456789abcdef".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f63725c = new byte[128];

    static {
        for (int i2 = 0; i2 < 10; i2++) {
            byte[] bArr = f63725c;
            bArr[i2 + 48] = (byte) i2;
            byte b2 = (byte) (i2 + 10);
            bArr[i2 + 65] = b2;
            bArr[i2 + 97] = b2;
        }
    }

    public static char[] a(byte[] bArr, boolean z) {
        char[] cArr = z ? f63723a : f63724b;
        char[] cArr2 = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            cArr2[i2] = cArr[(b2 & 240) >>> 4];
            i2 = i3 + 1;
            cArr2[i3] = cArr[b2 & 15];
        }
        return cArr2;
    }

    public static String b(byte[] bArr, boolean z) {
        return new String(a(bArr, z));
    }
}
