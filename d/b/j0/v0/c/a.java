package d.b.j0.v0.c;

import com.baidu.adp.lib.util.StringUtils;
import d.b.c.e.d.l;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public l<byte[]> f63408a;

    public a() {
        b();
    }

    public byte[] a(String str) {
        l.b<byte[]> bVar;
        byte[] bArr;
        if (str != null) {
            b();
            bVar = this.f63408a.h(str);
        } else {
            bVar = null;
        }
        if (bVar == null || (bArr = bVar.f42439b) == null) {
            return null;
        }
        return bArr;
    }

    public final void b() {
        if (this.f63408a == null) {
            this.f63408a = d.b.i0.r.r.a.f().d("tb.god_square");
        }
    }

    public void c(String str, byte[] bArr) {
        if (StringUtils.isNull(str)) {
            return;
        }
        b();
        this.f63408a.e(str, bArr, 604800000L);
    }
}
