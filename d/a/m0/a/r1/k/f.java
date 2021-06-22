package d.a.m0.a.r1.k;

import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class f implements e {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48256c = k.f46983a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f48257d;

    /* renamed from: a  reason: collision with root package name */
    public volatile d f48258a;

    /* renamed from: b  reason: collision with root package name */
    public volatile d.a.m0.a.r1.o.a f48259b;

    public f() {
        k();
    }

    public static f j() {
        if (f48257d == null) {
            synchronized (f.class) {
                if (f48257d == null) {
                    f48257d = new f();
                }
            }
        }
        return f48257d;
    }

    @Override // d.a.m0.a.r1.k.e
    public void b(long j) {
        if (m()) {
            if (f48256c) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.f48258a.b(j);
            this.f48259b.b(j);
        }
    }

    @Override // d.a.m0.a.r1.k.e
    public void c(long j) {
        if (m()) {
            if (f48256c) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.f48258a.c(j);
            this.f48259b.c(j);
            o(j);
        }
    }

    public d i() {
        return this.f48258a;
    }

    public final void k() {
        if (this.f48258a == null) {
            this.f48258a = new b();
        }
        if (this.f48259b == null) {
            this.f48259b = new d.a.m0.a.r1.o.c();
        }
    }

    public final boolean l() {
        if (f48256c) {
            return true;
        }
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null) {
            return false;
        }
        String appId = Q.getAppId();
        return (TextUtils.isEmpty(appId) || d.a.m0.a.v.a.b(appId) == 0) ? false : true;
    }

    public boolean m() {
        return l();
    }

    public d.a.m0.a.r1.o.a n() {
        return this.f48259b;
    }

    public final void o(long j) {
        d.a.m0.a.q2.d.f48018i.d(Long.valueOf(j));
    }
}
