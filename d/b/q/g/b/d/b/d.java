package d.b.q.g.b.d.b;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f65402a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f65403b;

    public static byte[] a() {
        byte[] bArr = f65403b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f65399c).modPow(new BigInteger(c.f65400d), new BigInteger(c.f65401e)).toByteArray();
        f65403b = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f65402a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f65397a).modPow(new BigInteger(c.f65398b), new BigInteger(c.f65401e)).toByteArray();
        f65402a = byteArray;
        return byteArray;
    }
}
