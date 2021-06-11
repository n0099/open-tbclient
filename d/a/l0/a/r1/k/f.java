package d.a.l0.a.r1.k;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class f implements e {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48148c = k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f48149d;

    /* renamed from: a  reason: collision with root package name */
    public volatile d f48150a;

    /* renamed from: b  reason: collision with root package name */
    public volatile d.a.l0.a.r1.o.a f48151b;

    public f() {
        k();
    }

    public static f j() {
        if (f48149d == null) {
            synchronized (f.class) {
                if (f48149d == null) {
                    f48149d = new f();
                }
            }
        }
        return f48149d;
    }

    @Override // d.a.l0.a.r1.k.e
    public void b(long j) {
        if (m()) {
            if (f48148c) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.f48150a.b(j);
            this.f48151b.b(j);
        }
    }

    @Override // d.a.l0.a.r1.k.e
    public void c(long j) {
        if (m()) {
            if (f48148c) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.f48150a.c(j);
            this.f48151b.c(j);
            o(j);
        }
    }

    public d i() {
        return this.f48150a;
    }

    public final void k() {
        if (this.f48150a == null) {
            this.f48150a = new b();
        }
        if (this.f48151b == null) {
            this.f48151b = new d.a.l0.a.r1.o.c();
        }
    }

    public final boolean l() {
        if (f48148c) {
            return true;
        }
        d.a.l0.a.a2.e Q = d.a.l0.a.a2.e.Q();
        if (Q == null) {
            return false;
        }
        String appId = Q.getAppId();
        return (TextUtils.isEmpty(appId) || d.a.l0.a.v.a.b(appId) == 0) ? false : true;
    }

    public boolean m() {
        return l();
    }

    public d.a.l0.a.r1.o.a n() {
        return this.f48151b;
    }

    public final void o(long j) {
        d.a.l0.a.q2.d.f47910i.d(Long.valueOf(j));
    }
}
