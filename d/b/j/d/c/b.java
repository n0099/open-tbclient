package d.b.j.d.c;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f52620a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f52621b;

    public static byte[] a() {
        byte[] bArr = f52620a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f52615a).modPow(new BigInteger(a.f52616b), new BigInteger(a.f52619e)).toByteArray();
        f52620a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f52621b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f52617c).modPow(new BigInteger(a.f52618d), new BigInteger(a.f52619e)).toByteArray();
        f52621b = byteArray;
        return byteArray;
    }
}
