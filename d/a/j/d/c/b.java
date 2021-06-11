package d.a.j.d.c;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f43870a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f43871b;

    public static byte[] a() {
        byte[] bArr = f43870a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f43865a).modPow(new BigInteger(a.f43866b), new BigInteger(a.f43869e)).toByteArray();
        f43870a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f43871b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f43867c).modPow(new BigInteger(a.f43868d), new BigInteger(a.f43869e)).toByteArray();
        f43871b = byteArray;
        return byteArray;
    }
}
