package d.b.i0.c3.m0;

import com.baidu.tieba.tbadkCore.location.LocationData;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static b f53507d;

    /* renamed from: a  reason: collision with root package name */
    public long f53508a;

    /* renamed from: b  reason: collision with root package name */
    public LocationData f53509b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53510c = d.b.h0.r.d0.b.i().g("no_longer_show_address", false);

    public static b a() {
        if (f53507d == null) {
            synchronized (b.class) {
                if (f53507d == null) {
                    f53507d = new b();
                }
            }
        }
        return f53507d;
    }

    public LocationData b() {
        return this.f53509b;
    }

    public long c() {
        return this.f53508a;
    }

    public boolean d() {
        return this.f53510c;
    }

    public void e(LocationData locationData) {
        this.f53509b = locationData;
    }

    public void f(boolean z) {
        this.f53510c = z;
    }

    public void g(long j) {
        this.f53508a = j;
    }
}
