package d.a.q.g.b.d.b;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f67908a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f67909b;

    public static byte[] a() {
        byte[] bArr = f67909b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f67905c).modPow(new BigInteger(c.f67906d), new BigInteger(c.f67907e)).toByteArray();
        f67909b = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f67908a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f67903a).modPow(new BigInteger(c.f67904b), new BigInteger(c.f67907e)).toByteArray();
        f67908a = byteArray;
        return byteArray;
    }
}
