package d.b.b.a.a.d.a.a;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f41937a;

    public static byte[] a() {
        byte[] bArr = f41937a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f41934a).modPow(new BigInteger(c.f41935b), new BigInteger(c.f41936c)).toByteArray();
        f41937a = byteArray;
        return byteArray;
    }
}
