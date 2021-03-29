package d.b.j.d.c;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f63725a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f63726b;

    public static byte[] a() {
        byte[] bArr = f63725a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f63720a).modPow(new BigInteger(a.f63721b), new BigInteger(a.f63724e)).toByteArray();
        f63725a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f63726b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f63722c).modPow(new BigInteger(a.f63723d), new BigInteger(a.f63724e)).toByteArray();
        f63726b = byteArray;
        return byteArray;
    }
}
