package d.b.c.d;

import com.baidu.adp.gif.NSGif;
/* loaded from: classes.dex */
public class d implements a {
    @Override // d.b.c.d.a
    public d.b.c.j.d.a a(byte[] bArr, int i, int i2) {
        NSGif f2 = NSGif.f(bArr, i, i2);
        if (f2 == null) {
            return null;
        }
        return new d.b.c.j.d.a(f2);
    }

    @Override // d.b.c.d.a
    public d.b.c.j.d.a get(String str) {
        NSGif e2 = NSGif.e(str);
        if (e2 == null) {
            return null;
        }
        return new d.b.c.j.d.a(e2);
    }
}
