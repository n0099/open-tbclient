package d.a.b.a.a.d.a.a;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f38530a;

    public static byte[] a() {
        byte[] bArr = f38530a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f38527a).modPow(new BigInteger(c.f38528b), new BigInteger(c.f38529c)).toByteArray();
        f38530a = byteArray;
        return byteArray;
    }
}
