package d.b.j0.d2.k.e;

import d.b.c.e.d.l;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    public static k f54604c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.e.d.l<byte[]> f54605a = null;

    /* renamed from: b  reason: collision with root package name */
    public d.b.c.e.d.l<byte[]> f54606b = null;

    public k() {
        c();
    }

    public static synchronized k b() {
        k kVar;
        synchronized (k.class) {
            if (f54604c == null) {
                f54604c = new k();
            }
            kVar = f54604c;
        }
        return kVar;
    }

    public byte[] a(String str, boolean z) {
        l.b<byte[]> h2;
        byte[] bArr;
        if (z) {
            d.b.c.e.d.l<byte[]> lVar = this.f54605a;
            if (lVar != null && str != null) {
                h2 = lVar.h(str);
            }
            h2 = null;
        } else {
            d.b.c.e.d.l<byte[]> lVar2 = this.f54606b;
            if (lVar2 != null && str != null) {
                h2 = lVar2.h(str);
            }
            h2 = null;
        }
        if (h2 == null || (bArr = h2.f42439b) == null) {
            return null;
        }
        return bArr;
    }

    public final void c() {
        if (this.f54605a == null) {
            this.f54605a = d.b.i0.r.r.a.f().d("tb.pb_mark");
        }
        if (this.f54606b == null) {
            this.f54606b = d.b.i0.r.r.a.f().d("tb.pb_normal");
        }
    }

    public void d(String str, boolean z) {
        if (z) {
            d.b.c.e.d.l<byte[]> lVar = this.f54605a;
            if (lVar == null || str == null) {
                return;
            }
            lVar.i(str, new byte[0], 0L);
            return;
        }
        d.b.c.e.d.l<byte[]> lVar2 = this.f54606b;
        if (lVar2 == null || str == null) {
            return;
        }
        lVar2.i(str, new byte[0], 0L);
    }

    public void e(String str, boolean z, byte[] bArr) {
        if (str != null) {
            c();
            if (z) {
                this.f54605a.e(str, bArr, 604800000L);
            } else {
                this.f54606b.e(str, bArr, 86400000L);
            }
        }
    }

    public void f(String str, byte[] bArr) {
        if (bArr == null || str == null) {
            return;
        }
        c();
        this.f54605a.e(str, bArr, 2592000000L);
    }
}
