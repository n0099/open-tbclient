package d.a.o0.e3.m0;

import com.baidu.tieba.tbadkCore.location.LocationData;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static b f57947d;

    /* renamed from: a  reason: collision with root package name */
    public long f57948a;

    /* renamed from: b  reason: collision with root package name */
    public LocationData f57949b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57950c = d.a.n0.r.d0.b.j().g("no_longer_show_address", false);

    public static b a() {
        if (f57947d == null) {
            synchronized (b.class) {
                if (f57947d == null) {
                    f57947d = new b();
                }
            }
        }
        return f57947d;
    }

    public LocationData b() {
        return this.f57949b;
    }

    public long c() {
        return this.f57948a;
    }

    public boolean d() {
        return this.f57950c;
    }

    public void e(LocationData locationData) {
        this.f57949b = locationData;
    }

    public void f(boolean z) {
        this.f57950c = z;
    }

    public void g(long j) {
        this.f57948a = j;
    }
}
