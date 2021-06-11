package d.a.n0.e3.m0;

import com.baidu.tieba.tbadkCore.location.LocationData;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static b f57822d;

    /* renamed from: a  reason: collision with root package name */
    public long f57823a;

    /* renamed from: b  reason: collision with root package name */
    public LocationData f57824b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57825c = d.a.m0.r.d0.b.j().g("no_longer_show_address", false);

    public static b a() {
        if (f57822d == null) {
            synchronized (b.class) {
                if (f57822d == null) {
                    f57822d = new b();
                }
            }
        }
        return f57822d;
    }

    public LocationData b() {
        return this.f57824b;
    }

    public long c() {
        return this.f57823a;
    }

    public boolean d() {
        return this.f57825c;
    }

    public void e(LocationData locationData) {
        this.f57824b = locationData;
    }

    public void f(boolean z) {
        this.f57825c = z;
    }

    public void g(long j) {
        this.f57823a = j;
    }
}
