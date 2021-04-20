package d.b.p.g.b.d.b;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f65138a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f65139b;

    public static byte[] a() {
        byte[] bArr = f65139b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f65135c).modPow(new BigInteger(c.f65136d), new BigInteger(c.f65137e)).toByteArray();
        f65139b = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f65138a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f65133a).modPow(new BigInteger(c.f65134b), new BigInteger(c.f65137e)).toByteArray();
        f65138a = byteArray;
        return byteArray;
    }
}
