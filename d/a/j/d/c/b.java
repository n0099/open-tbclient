package d.a.j.d.c;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f40189a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f40190b;

    public static byte[] a() {
        byte[] bArr = f40189a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f40184a).modPow(new BigInteger(a.f40185b), new BigInteger(a.f40188e)).toByteArray();
        f40189a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f40190b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f40186c).modPow(new BigInteger(a.f40187d), new BigInteger(a.f40188e)).toByteArray();
        f40190b = byteArray;
        return byteArray;
    }
}
