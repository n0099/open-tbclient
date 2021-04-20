package d.b.j.d.c;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f64425a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f64426b;

    public static byte[] a() {
        byte[] bArr = f64425a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f64420a).modPow(new BigInteger(a.f64421b), new BigInteger(a.f64424e)).toByteArray();
        f64425a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f64426b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f64422c).modPow(new BigInteger(a.f64423d), new BigInteger(a.f64424e)).toByteArray();
        f64426b = byteArray;
        return byteArray;
    }
}
