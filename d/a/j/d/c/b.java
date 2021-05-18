package d.a.j.d.c;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f48525a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f48526b;

    public static byte[] a() {
        byte[] bArr = f48525a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f48520a).modPow(new BigInteger(a.f48521b), new BigInteger(a.f48524e)).toByteArray();
        f48525a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f48526b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f48522c).modPow(new BigInteger(a.f48523d), new BigInteger(a.f48524e)).toByteArray();
        f48526b = byteArray;
        return byteArray;
    }
}
