package d.a.b.a.a.d.a.a;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f42041a;

    public static byte[] a() {
        byte[] bArr = f42041a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f42038a).modPow(new BigInteger(c.f42039b), new BigInteger(c.f42040c)).toByteArray();
        f42041a = byteArray;
        return byteArray;
    }
}
