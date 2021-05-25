package d.a.n0.e2.k.e;

import d.a.c.e.d.l;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    public static k f53367c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.d.l<byte[]> f53368a = null;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.e.d.l<byte[]> f53369b = null;

    public k() {
        c();
    }

    public static synchronized k b() {
        k kVar;
        synchronized (k.class) {
            if (f53367c == null) {
                f53367c = new k();
            }
            kVar = f53367c;
        }
        return kVar;
    }

    public byte[] a(String str, boolean z) {
        l.b<byte[]> h2;
        byte[] bArr;
        if (z) {
            d.a.c.e.d.l<byte[]> lVar = this.f53368a;
            if (lVar != null && str != null) {
                h2 = lVar.h(str);
            }
            h2 = null;
        } else {
            d.a.c.e.d.l<byte[]> lVar2 = this.f53369b;
            if (lVar2 != null && str != null) {
                h2 = lVar2.h(str);
            }
            h2 = null;
        }
        if (h2 == null || (bArr = h2.f38542b) == null) {
            return null;
        }
        return bArr;
    }

    public final void c() {
        if (this.f53368a == null) {
            this.f53368a = d.a.m0.r.r.a.f().d("tb.pb_mark");
        }
        if (this.f53369b == null) {
            this.f53369b = d.a.m0.r.r.a.f().d("tb.pb_normal");
        }
    }

    public void d(String str, boolean z) {
        if (z) {
            d.a.c.e.d.l<byte[]> lVar = this.f53368a;
            if (lVar == null || str == null) {
                return;
            }
            lVar.i(str, new byte[0], 0L);
            return;
        }
        d.a.c.e.d.l<byte[]> lVar2 = this.f53369b;
        if (lVar2 == null || str == null) {
            return;
        }
        lVar2.i(str, new byte[0], 0L);
    }

    public void e(String str, boolean z, byte[] bArr) {
        if (str != null) {
            c();
            if (z) {
                this.f53368a.e(str, bArr, 604800000L);
            } else {
                this.f53369b.e(str, bArr, 86400000L);
            }
        }
    }

    public void f(String str, byte[] bArr) {
        if (bArr == null || str == null) {
            return;
        }
        c();
        this.f53368a.e(str, bArr, 2592000000L);
    }
}
