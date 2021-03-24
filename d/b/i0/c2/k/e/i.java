package d.b.i0.c2.k.e;

import d.b.b.e.d.l;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public static i f52697c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.e.d.l<byte[]> f52698a = null;

    /* renamed from: b  reason: collision with root package name */
    public d.b.b.e.d.l<byte[]> f52699b = null;

    public i() {
        c();
    }

    public static synchronized i b() {
        i iVar;
        synchronized (i.class) {
            if (f52697c == null) {
                f52697c = new i();
            }
            iVar = f52697c;
        }
        return iVar;
    }

    public byte[] a(String str, boolean z) {
        l.b<byte[]> h2;
        byte[] bArr;
        if (z) {
            d.b.b.e.d.l<byte[]> lVar = this.f52698a;
            if (lVar != null && str != null) {
                h2 = lVar.h(str);
            }
            h2 = null;
        } else {
            d.b.b.e.d.l<byte[]> lVar2 = this.f52699b;
            if (lVar2 != null && str != null) {
                h2 = lVar2.h(str);
            }
            h2 = null;
        }
        if (h2 == null || (bArr = h2.f41701b) == null) {
            return null;
        }
        return bArr;
    }

    public final void c() {
        if (this.f52698a == null) {
            this.f52698a = d.b.h0.r.r.a.f().d("tb.pb_mark");
        }
        if (this.f52699b == null) {
            this.f52699b = d.b.h0.r.r.a.f().d("tb.pb_normal");
        }
    }

    public void d(String str, boolean z) {
        if (z) {
            d.b.b.e.d.l<byte[]> lVar = this.f52698a;
            if (lVar == null || str == null) {
                return;
            }
            lVar.i(str, new byte[0], 0L);
            return;
        }
        d.b.b.e.d.l<byte[]> lVar2 = this.f52699b;
        if (lVar2 == null || str == null) {
            return;
        }
        lVar2.i(str, new byte[0], 0L);
    }

    public void e(String str, boolean z, byte[] bArr) {
        if (str != null) {
            c();
            if (z) {
                this.f52698a.e(str, bArr, 604800000L);
            } else {
                this.f52699b.e(str, bArr, 86400000L);
            }
        }
    }

    public void f(String str, byte[] bArr) {
        if (bArr == null || str == null) {
            return;
        }
        c();
        this.f52698a.e(str, bArr, 2592000000L);
    }
}
