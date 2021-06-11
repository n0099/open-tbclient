package d.a.j.d.a;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile byte[] f43860a;

    public static byte[] a() {
        if (f43860a == null) {
            synchronized (g.class) {
                if (f43860a == null) {
                    byte[] bArr = new byte[16];
                    System.arraycopy(d.a.j.d.c.b.b(), 0, bArr, 0, 16);
                    c cVar = new c();
                    cVar.a(2, bArr, bArr);
                    f43860a = cVar.b(new byte[]{-71, -100, -115, 26, 39, -124, 14, 14, -31, -46, -56, 1, 25, -127, -99, -107, -54, 51, 46, 14, 68, -68, -19, 28, 66, 19, -113, 5, 25, -11, -123, 50});
                }
            }
        }
        return f43860a;
    }
}
