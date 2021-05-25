package d.a.q.g.b.d.b;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f64234a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f64235b;

    public static byte[] a() {
        byte[] bArr = f64235b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f64231c).modPow(new BigInteger(c.f64232d), new BigInteger(c.f64233e)).toByteArray();
        f64235b = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f64234a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f64229a).modPow(new BigInteger(c.f64230b), new BigInteger(c.f64233e)).toByteArray();
        f64234a = byteArray;
        return byteArray;
    }
}
