package d.a.q.g.b.d.b;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f67952a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f67953b;

    public static byte[] a() {
        byte[] bArr = f67953b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f67949c).modPow(new BigInteger(c.f67950d), new BigInteger(c.f67951e)).toByteArray();
        f67953b = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f67952a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f67947a).modPow(new BigInteger(c.f67948b), new BigInteger(c.f67951e)).toByteArray();
        f67952a = byteArray;
        return byteArray;
    }
}
