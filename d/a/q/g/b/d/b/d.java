package d.a.q.g.b.d.b;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f64358a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f64359b;

    public static byte[] a() {
        byte[] bArr = f64359b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f64355c).modPow(new BigInteger(c.f64356d), new BigInteger(c.f64357e)).toByteArray();
        f64359b = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f64358a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f64353a).modPow(new BigInteger(c.f64354b), new BigInteger(c.f64357e)).toByteArray();
        f64358a = byteArray;
        return byteArray;
    }
}
