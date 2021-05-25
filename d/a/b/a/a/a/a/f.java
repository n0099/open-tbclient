package d.a.b.a.a.a.a;

import com.baidu.ad.magic.flute.a.a.n;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public b f38268a;

    public f(byte[] bArr) {
        this.f38268a = a.b(bArr);
    }

    public static byte a(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return (byte) 2;
                }
                throw new n("unexpected value " + i2);
            }
            return (byte) 1;
        }
        return (byte) 0;
    }

    public byte[] b() {
        return this.f38268a.a();
    }
}
