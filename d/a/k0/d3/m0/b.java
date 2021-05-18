package d.a.k0.d3.m0;

import com.baidu.tieba.tbadkCore.location.LocationData;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static b f53920d;

    /* renamed from: a  reason: collision with root package name */
    public long f53921a;

    /* renamed from: b  reason: collision with root package name */
    public LocationData f53922b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53923c = d.a.j0.r.d0.b.j().g("no_longer_show_address", false);

    public static b a() {
        if (f53920d == null) {
            synchronized (b.class) {
                if (f53920d == null) {
                    f53920d = new b();
                }
            }
        }
        return f53920d;
    }

    public LocationData b() {
        return this.f53922b;
    }

    public long c() {
        return this.f53921a;
    }

    public boolean d() {
        return this.f53923c;
    }

    public void e(LocationData locationData) {
        this.f53922b = locationData;
    }

    public void f(boolean z) {
        this.f53923c = z;
    }

    public void g(long j) {
        this.f53921a = j;
    }
}
