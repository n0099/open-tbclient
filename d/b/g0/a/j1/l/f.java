package d.b.g0.a.j1.l;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class f implements e {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f44916d = k.f45051a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile f f44917e;

    /* renamed from: b  reason: collision with root package name */
    public volatile d f44918b;

    /* renamed from: c  reason: collision with root package name */
    public volatile d.b.g0.a.j1.o.a f44919c;

    public f() {
        i();
    }

    public static f h() {
        if (f44917e == null) {
            synchronized (f.class) {
                if (f44917e == null) {
                    f44917e = new f();
                }
            }
        }
        return f44917e;
    }

    @Override // d.b.g0.a.j1.l.e
    public void b(long j) {
        if (k()) {
            if (f44916d) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.f44918b.b(j);
            this.f44919c.b(j);
        }
    }

    @Override // d.b.g0.a.j1.l.e
    public void e(long j) {
        if (k()) {
            if (f44916d) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.f44918b.e(j);
            this.f44919c.e(j);
            m(j);
        }
    }

    public final void i() {
        if (this.f44918b == null) {
            this.f44918b = new b();
        }
        if (this.f44919c == null) {
            this.f44919c = new d.b.g0.a.j1.o.c();
        }
    }

    public final boolean j() {
        if (f44916d) {
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
        return this.f44919c;
    }

    public final void m(long j) {
        d.b.g0.a.f2.d.i.d(Long.valueOf(j));
    }
}
