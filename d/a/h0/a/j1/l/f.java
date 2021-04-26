package d.a.h0.a.j1.l;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class f implements e {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f42961d = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile f f42962e;

    /* renamed from: b  reason: collision with root package name */
    public volatile d f42963b;

    /* renamed from: c  reason: collision with root package name */
    public volatile d.a.h0.a.j1.o.a f42964c;

    public f() {
        i();
    }

    public static f h() {
        if (f42962e == null) {
            synchronized (f.class) {
                if (f42962e == null) {
                    f42962e = new f();
                }
            }
        }
        return f42962e;
    }

    @Override // d.a.h0.a.j1.l.e
    public void b(long j) {
        if (k()) {
            if (f42961d) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.f42963b.b(j);
            this.f42964c.b(j);
        }
    }

    @Override // d.a.h0.a.j1.l.e
    public void c(long j) {
        if (k()) {
            if (f42961d) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.f42963b.c(j);
            this.f42964c.c(j);
            m(j);
        }
    }

    public final void i() {
        if (this.f42963b == null) {
            this.f42963b = new b();
        }
        if (this.f42964c == null) {
            this.f42964c = new d.a.h0.a.j1.o.c();
        }
    }

    public final boolean j() {
        if (f42961d) {
            return true;
        }
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            return false;
        }
        String appId = O.getAppId();
        return (TextUtils.isEmpty(appId) || d.a.h0.a.u.a.b(appId) == 0) ? false : true;
    }

    public boolean k() {
        return j();
    }

    public d.a.h0.a.j1.o.a l() {
        return this.f42964c;
    }

    public final void m(long j) {
        d.a.h0.a.f2.d.f42500i.d(Long.valueOf(j));
    }
}
