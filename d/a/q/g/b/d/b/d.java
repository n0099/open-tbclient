package d.a.q.g.b.d.b;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f63721a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f63722b;

    public static byte[] a() {
        byte[] bArr = f63722b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f63718c).modPow(new BigInteger(c.f63719d), new BigInteger(c.f63720e)).toByteArray();
        f63722b = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f63721a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f63716a).modPow(new BigInteger(c.f63717b), new BigInteger(c.f63720e)).toByteArray();
        f63721a = byteArray;
        return byteArray;
    }
}
