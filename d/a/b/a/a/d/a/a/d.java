package d.a.b.a.a.d.a.a;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f41938a;

    public static byte[] a() {
        byte[] bArr = f41938a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f41935a).modPow(new BigInteger(c.f41936b), new BigInteger(c.f41937c)).toByteArray();
        f41938a = byteArray;
        return byteArray;
    }
}
