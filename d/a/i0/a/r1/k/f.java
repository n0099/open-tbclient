package d.a.i0.a.r1.k;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class f implements e {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44298c = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f44299d;

    /* renamed from: a  reason: collision with root package name */
    public volatile d f44300a;

    /* renamed from: b  reason: collision with root package name */
    public volatile d.a.i0.a.r1.o.a f44301b;

    public f() {
        k();
    }

    public static f j() {
        if (f44299d == null) {
            synchronized (f.class) {
                if (f44299d == null) {
                    f44299d = new f();
                }
            }
        }
        return f44299d;
    }

    @Override // d.a.i0.a.r1.k.e
    public void b(long j) {
        if (m()) {
            if (f44298c) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.f44300a.b(j);
            this.f44301b.b(j);
        }
    }

    @Override // d.a.i0.a.r1.k.e
    public void c(long j) {
        if (m()) {
            if (f44298c) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.f44300a.c(j);
            this.f44301b.c(j);
            o(j);
        }
    }

    public d i() {
        return this.f44300a;
    }

    public final void k() {
        if (this.f44300a == null) {
            this.f44300a = new b();
        }
        if (this.f44301b == null) {
            this.f44301b = new d.a.i0.a.r1.o.c();
        }
    }

    public final boolean l() {
        if (f44298c) {
            return true;
        }
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null) {
            return false;
        }
        String appId = Q.getAppId();
        return (TextUtils.isEmpty(appId) || d.a.i0.a.v.a.b(appId) == 0) ? false : true;
    }

    public boolean m() {
        return l();
    }

    public d.a.i0.a.r1.o.a n() {
        return this.f44301b;
    }

    public final void o(long j) {
        d.a.i0.a.q2.d.f44060i.d(Long.valueOf(j));
    }
}
