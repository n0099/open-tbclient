package d.b.g0.a.j1.l;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class f implements e {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45308d = k.f45443a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile f f45309e;

    /* renamed from: b  reason: collision with root package name */
    public volatile d f45310b;

    /* renamed from: c  reason: collision with root package name */
    public volatile d.b.g0.a.j1.o.a f45311c;

    public f() {
        i();
    }

    public static f h() {
        if (f45309e == null) {
            synchronized (f.class) {
                if (f45309e == null) {
                    f45309e = new f();
                }
            }
        }
        return f45309e;
    }

    @Override // d.b.g0.a.j1.l.e
    public void b(long j) {
        if (k()) {
            if (f45308d) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.f45310b.b(j);
            this.f45311c.b(j);
        }
    }

    @Override // d.b.g0.a.j1.l.e
    public void e(long j) {
        if (k()) {
            if (f45308d) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.f45310b.e(j);
            this.f45311c.e(j);
            m(j);
        }
    }

    public final void i() {
        if (this.f45310b == null) {
            this.f45310b = new b();
        }
        if (this.f45311c == null) {
            this.f45311c = new d.b.g0.a.j1.o.c();
        }
    }

    public final boolean j() {
        if (f45308d) {
            return true;
        }
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null) {
            return false;
        }
        String appId = O.getAppId();
        return (TextUtils.isEmpty(appId) || d.b.g0.a.u.a.b(appId) == 0) ? false : true;
    }

    public boolean k() {
        return j();
    }

    public d.b.g0.a.j1.o.a l() {
        return this.f45311c;
    }

    public final void m(long j) {
        d.b.g0.a.f2.d.i.d(Long.valueOf(j));
    }
}
