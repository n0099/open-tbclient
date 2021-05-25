package d.a.n0.e3.m0;

import com.baidu.tieba.tbadkCore.location.LocationData;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static b f54133d;

    /* renamed from: a  reason: collision with root package name */
    public long f54134a;

    /* renamed from: b  reason: collision with root package name */
    public LocationData f54135b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54136c = d.a.m0.r.d0.b.j().g("no_longer_show_address", false);

    public static b a() {
        if (f54133d == null) {
            synchronized (b.class) {
                if (f54133d == null) {
                    f54133d = new b();
                }
            }
        }
        return f54133d;
    }

    public LocationData b() {
        return this.f54135b;
    }

    public long c() {
        return this.f54134a;
    }

    public boolean d() {
        return this.f54136c;
    }

    public void e(LocationData locationData) {
        this.f54135b = locationData;
    }

    public void f(boolean z) {
        this.f54136c = z;
    }

    public void g(long j) {
        this.f54134a = j;
    }
}
