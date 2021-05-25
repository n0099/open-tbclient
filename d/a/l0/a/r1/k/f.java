package d.a.l0.a.r1.k;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class f implements e {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44474c = k.f43199a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f44475d;

    /* renamed from: a  reason: collision with root package name */
    public volatile d f44476a;

    /* renamed from: b  reason: collision with root package name */
    public volatile d.a.l0.a.r1.o.a f44477b;

    public f() {
        k();
    }

    public static f j() {
        if (f44475d == null) {
            synchronized (f.class) {
                if (f44475d == null) {
                    f44475d = new f();
                }
            }
        }
        return f44475d;
    }

    @Override // d.a.l0.a.r1.k.e
    public void b(long j) {
        if (m()) {
            if (f44474c) {
                Log.d("StartUpInfoMarker", "aiapp start at - " + j);
            }
            this.f44476a.b(j);
            this.f44477b.b(j);
        }
    }

    @Override // d.a.l0.a.r1.k.e
    public void c(long j) {
        if (m()) {
            if (f44474c) {
                Log.d("StartUpInfoMarker", "aiapp start cost at - " + j);
            }
            this.f44476a.c(j);
            this.f44477b.c(j);
            o(j);
        }
    }

    public d i() {
        return this.f44476a;
    }

    public final void k() {
        if (this.f44476a == null) {
            this.f44476a = new b();
        }
        if (this.f44477b == null) {
            this.f44477b = new d.a.l0.a.r1.o.c();
        }
    }

    public final boolean l() {
        if (f44474c) {
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
        return this.f44477b;
    }

    public final void o(long j) {
        d.a.l0.a.q2.d.f44236i.d(Long.valueOf(j));
    }
}
