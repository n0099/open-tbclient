package d.b.h0.a.j1.l;

import android.text.TextUtils;
import android.util.Log;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public class f implements e {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45637d = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile f f45638e;

    /* renamed from: b  reason: collision with root package name */
    public volatile d f45639b;

    /* renamed from: c  reason: collision with root package name */
    public volatile d.b.h0.a.j1.o.a f45640c;

    public f() {
        i();
    }

    public static f h() {
        if (f45638e == null) {
            synchronized (f.class) {
                if (f45638e == null) {
                    f45638e = new f();
                }
            }
        }
        return f45638e;
    }

    @Override // d.b.h0.a.j1.l.e
    public void b(long j) {
        if (k()) {
            if (f45637d) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.f45639b.b(j);
            this.f45640c.b(j);
        }
    }

    @Override // d.b.h0.a.j1.l.e
    public void e(long j) {
        if (k()) {
            if (f45637d) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.f45639b.e(j);
            this.f45640c.e(j);
            m(j);
        }
    }

    public final void i() {
        if (this.f45639b == null) {
            this.f45639b = new b();
        }
        if (this.f45640c == null) {
            this.f45640c = new d.b.h0.a.j1.o.c();
        }
    }

    public final boolean j() {
        if (f45637d) {
            return true;
        }
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O == null) {
            return false;
        }
        String appId = O.getAppId();
        return (TextUtils.isEmpty(appId) || d.b.h0.a.u.a.b(appId) == 0) ? false : true;
    }

    public boolean k() {
        return j();
    }

    public d.b.h0.a.j1.o.a l() {
        return this.f45640c;
    }

    public final void m(long j) {
        d.b.h0.a.f2.d.i.d(Long.valueOf(j));
    }
}
