package d.b.g0.a.j1.l;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class f implements e {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44915d = k.f45050a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile f f44916e;

    /* renamed from: b  reason: collision with root package name */
    public volatile d f44917b;

    /* renamed from: c  reason: collision with root package name */
    public volatile d.b.g0.a.j1.o.a f44918c;

    public f() {
        i();
    }

    public static f h() {
        if (f44916e == null) {
            synchronized (f.class) {
                if (f44916e == null) {
                    f44916e = new f();
                }
            }
        }
        return f44916e;
    }

    @Override // d.b.g0.a.j1.l.e
    public void b(long j) {
        if (k()) {
            if (f44915d) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.f44917b.b(j);
            this.f44918c.b(j);
        }
    }

    @Override // d.b.g0.a.j1.l.e
    public void e(long j) {
        if (k()) {
            if (f44915d) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.f44917b.e(j);
            this.f44918c.e(j);
            m(j);
        }
    }

    public final void i() {
        if (this.f44917b == null) {
            this.f44917b = new b();
        }
        if (this.f44918c == null) {
            this.f44918c = new d.b.g0.a.j1.o.c();
        }
    }

    public final boolean j() {
        if (f44915d) {
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
        return this.f44918c;
    }

    public final void m(long j) {
        d.b.g0.a.f2.d.i.d(Long.valueOf(j));
    }
}
