package d.a.j.d.c;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f43973a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f43974b;

    public static byte[] a() {
        byte[] bArr = f43973a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f43968a).modPow(new BigInteger(a.f43969b), new BigInteger(a.f43972e)).toByteArray();
        f43973a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f43974b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f43970c).modPow(new BigInteger(a.f43971d), new BigInteger(a.f43972e)).toByteArray();
        f43974b = byteArray;
        return byteArray;
    }
}
