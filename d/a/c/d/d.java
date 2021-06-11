package d.a.c.d;

import com.baidu.adp.gif.NSGif;
/* loaded from: classes.dex */
public class d implements a {
    @Override // d.a.c.d.a
    public d.a.c.k.d.a a(byte[] bArr, int i2, int i3) {
        NSGif f2 = NSGif.f(bArr, i2, i3);
        if (f2 == null) {
            return null;
        }
        return new d.a.c.k.d.a(f2);
    }

    @Override // d.a.c.d.a
    public d.a.c.k.d.a get(String str) {
        NSGif e2 = NSGif.e(str);
        if (e2 == null) {
            return null;
        }
        return new d.a.c.k.d.a(e2);
    }
}
