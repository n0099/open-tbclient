package d.a.b.a.a.d.a.a;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f38285a;

    public static byte[] a() {
        byte[] bArr = f38285a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f38282a).modPow(new BigInteger(c.f38283b), new BigInteger(c.f38284c)).toByteArray();
        f38285a = byteArray;
        return byteArray;
    }
}
