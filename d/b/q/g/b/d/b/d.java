package d.b.q.g.b.d.b;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f64444a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f64445b;

    public static byte[] a() {
        byte[] bArr = f64445b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f64441c).modPow(new BigInteger(c.f64442d), new BigInteger(c.f64443e)).toByteArray();
        f64445b = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f64444a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f64439a).modPow(new BigInteger(c.f64440b), new BigInteger(c.f64443e)).toByteArray();
        f64444a = byteArray;
        return byteArray;
    }
}
