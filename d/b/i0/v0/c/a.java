package d.b.i0.v0.c;

import com.baidu.adp.lib.util.StringUtils;
import d.b.c.e.d.l;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public l<byte[]> f62987a;

    public a() {
        b();
    }

    public byte[] a(String str) {
        l.b<byte[]> bVar;
        byte[] bArr;
        if (str != null) {
            b();
            bVar = this.f62987a.h(str);
        } else {
            bVar = null;
        }
        if (bVar == null || (bArr = bVar.f42199b) == null) {
            return null;
        }
        return bArr;
    }

    public final void b() {
        if (this.f62987a == null) {
            this.f62987a = d.b.h0.r.r.a.f().d("tb.god_square");
        }
    }

    public void c(String str, byte[] bArr) {
        if (StringUtils.isNull(str)) {
            return;
        }
        b();
        this.f62987a.e(str, bArr, 604800000L);
    }
}
