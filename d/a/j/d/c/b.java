package d.a.j.d.c;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f50304a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f50305b;

    public static byte[] a() {
        byte[] bArr = f50304a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f50299a).modPow(new BigInteger(a.f50300b), new BigInteger(a.f50303e)).toByteArray();
        f50304a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f50305b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f50301c).modPow(new BigInteger(a.f50302d), new BigInteger(a.f50303e)).toByteArray();
        f50305b = byteArray;
        return byteArray;
    }
}
