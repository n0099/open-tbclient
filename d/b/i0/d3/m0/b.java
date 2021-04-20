package d.b.i0.d3.m0;

import com.baidu.tieba.tbadkCore.location.LocationData;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static b f54951d;

    /* renamed from: a  reason: collision with root package name */
    public long f54952a;

    /* renamed from: b  reason: collision with root package name */
    public LocationData f54953b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54954c = d.b.h0.r.d0.b.j().g("no_longer_show_address", false);

    public static b a() {
        if (f54951d == null) {
            synchronized (b.class) {
                if (f54951d == null) {
                    f54951d = new b();
                }
            }
        }
        return f54951d;
    }

    public LocationData b() {
        return this.f54953b;
    }

    public long c() {
        return this.f54952a;
    }

    public boolean d() {
        return this.f54954c;
    }

    public void e(LocationData locationData) {
        this.f54953b = locationData;
    }

    public void f(boolean z) {
        this.f54954c = z;
    }

    public void g(long j) {
        this.f54952a = j;
    }
}
