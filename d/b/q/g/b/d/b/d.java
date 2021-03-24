package d.b.q.g.b.d.b;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f64443a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f64444b;

    public static byte[] a() {
        byte[] bArr = f64444b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f64440c).modPow(new BigInteger(c.f64441d), new BigInteger(c.f64442e)).toByteArray();
        f64444b = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f64443a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f64438a).modPow(new BigInteger(c.f64439b), new BigInteger(c.f64442e)).toByteArray();
        f64443a = byteArray;
        return byteArray;
    }
}
