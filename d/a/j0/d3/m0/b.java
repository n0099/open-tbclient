package d.a.j0.d3.m0;

import com.baidu.tieba.tbadkCore.location.LocationData;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static b f53213d;

    /* renamed from: a  reason: collision with root package name */
    public long f53214a;

    /* renamed from: b  reason: collision with root package name */
    public LocationData f53215b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53216c = d.a.i0.r.d0.b.j().g("no_longer_show_address", false);

    public static b a() {
        if (f53213d == null) {
            synchronized (b.class) {
                if (f53213d == null) {
                    f53213d = new b();
                }
            }
        }
        return f53213d;
    }

    public LocationData b() {
        return this.f53215b;
    }

    public long c() {
        return this.f53214a;
    }

    public boolean d() {
        return this.f53216c;
    }

    public void e(LocationData locationData) {
        this.f53215b = locationData;
    }

    public void f(boolean z) {
        this.f53216c = z;
    }

    public void g(long j) {
        this.f53214a = j;
    }
}
