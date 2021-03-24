package d.b.j.d.c;

import java.math.BigInteger;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f63724a;

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f63725b;

    public static byte[] a() {
        byte[] bArr = f63724a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f63719a).modPow(new BigInteger(a.f63720b), new BigInteger(a.f63723e)).toByteArray();
        f63724a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f63725b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f63721c).modPow(new BigInteger(a.f63722d), new BigInteger(a.f63723e)).toByteArray();
        f63725b = byteArray;
        return byteArray;
    }
}
