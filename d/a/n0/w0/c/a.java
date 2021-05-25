package d.a.n0.w0.c;

import com.baidu.adp.lib.util.StringUtils;
import d.a.c.e.d.l;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public l<byte[]> f62468a;

    public a() {
        b();
    }

    public byte[] a(String str) {
        l.b<byte[]> bVar;
        byte[] bArr;
        if (str != null) {
            b();
            bVar = this.f62468a.h(str);
        } else {
            bVar = null;
        }
        if (bVar == null || (bArr = bVar.f38542b) == null) {
            return null;
        }
        return bArr;
    }

    public final void b() {
        if (this.f62468a == null) {
            this.f62468a = d.a.m0.r.r.a.f().d("tb.god_square");
        }
    }

    public void c(String str, byte[] bArr) {
        if (StringUtils.isNull(str)) {
            return;
        }
        b();
        this.f62468a.e(str, bArr, 604800000L);
    }
}
