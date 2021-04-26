package d.a.b.a.a.d.a.a;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f39285a;

    public static byte[] a() {
        byte[] bArr = f39285a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f39282a).modPow(new BigInteger(c.f39283b), new BigInteger(c.f39284c)).toByteArray();
        f39285a = byteArray;
        return byteArray;
    }
}
