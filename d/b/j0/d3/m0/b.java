package d.b.j0.d3.m0;

import com.baidu.tieba.tbadkCore.location.LocationData;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static b f55372d;

    /* renamed from: a  reason: collision with root package name */
    public long f55373a;

    /* renamed from: b  reason: collision with root package name */
    public LocationData f55374b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55375c = d.b.i0.r.d0.b.j().g("no_longer_show_address", false);

    public static b a() {
        if (f55372d == null) {
            synchronized (b.class) {
                if (f55372d == null) {
                    f55372d = new b();
                }
            }
        }
        return f55372d;
    }

    public LocationData b() {
        return this.f55374b;
    }

    public long c() {
        return this.f55373a;
    }

    public boolean d() {
        return this.f55375c;
    }

    public void e(LocationData locationData) {
        this.f55374b = locationData;
    }

    public void f(boolean z) {
        this.f55375c = z;
    }

    public void g(long j) {
        this.f55373a = j;
    }
}
