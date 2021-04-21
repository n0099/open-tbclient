package d.b.b.a.a.d.a.a;

import java.math.BigInteger;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f42103a;

    public static byte[] a() {
        byte[] bArr = f42103a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(c.f42100a).modPow(new BigInteger(c.f42101b), new BigInteger(c.f42102c)).toByteArray();
        f42103a = byteArray;
        return byteArray;
    }
}
