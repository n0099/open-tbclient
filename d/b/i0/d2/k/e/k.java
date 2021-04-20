package d.b.i0.d2.k.e;

import d.b.c.e.d.l;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    public static k f54183c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.e.d.l<byte[]> f54184a = null;

    /* renamed from: b  reason: collision with root package name */
    public d.b.c.e.d.l<byte[]> f54185b = null;

    public k() {
        c();
    }

    public static synchronized k b() {
        k kVar;
        synchronized (k.class) {
            if (f54183c == null) {
                f54183c = new k();
            }
            kVar = f54183c;
        }
        return kVar;
    }

    public byte[] a(String str, boolean z) {
        l.b<byte[]> h2;
        byte[] bArr;
        if (z) {
            d.b.c.e.d.l<byte[]> lVar = this.f54184a;
            if (lVar != null && str != null) {
                h2 = lVar.h(str);
            }
            h2 = null;
        } else {
            d.b.c.e.d.l<byte[]> lVar2 = this.f54185b;
            if (lVar2 != null && str != null) {
                h2 = lVar2.h(str);
            }
            h2 = null;
        }
        if (h2 == null || (bArr = h2.f42199b) == null) {
            return null;
        }
        return bArr;
    }

    public final void c() {
        if (this.f54184a == null) {
            this.f54184a = d.b.h0.r.r.a.f().d("tb.pb_mark");
        }
        if (this.f54185b == null) {
            this.f54185b = d.b.h0.r.r.a.f().d("tb.pb_normal");
        }
    }

    public void d(String str, boolean z) {
        if (z) {
            d.b.c.e.d.l<byte[]> lVar = this.f54184a;
            if (lVar == null || str == null) {
                return;
            }
            lVar.i(str, new byte[0], 0L);
            return;
        }
        d.b.c.e.d.l<byte[]> lVar2 = this.f54185b;
        if (lVar2 == null || str == null) {
            return;
        }
        lVar2.i(str, new byte[0], 0L);
    }

    public void e(String str, boolean z, byte[] bArr) {
        if (str != null) {
            c();
            if (z) {
                this.f54184a.e(str, bArr, 604800000L);
            } else {
                this.f54185b.e(str, bArr, 86400000L);
            }
        }
    }

    public void f(String str, byte[] bArr) {
        if (bArr == null || str == null) {
            return;
        }
        c();
        this.f54184a.e(str, bArr, 2592000000L);
    }
}
