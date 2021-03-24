package d.b.i0.c3.m0;

import com.baidu.tieba.tbadkCore.location.LocationData;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static b f53506d;

    /* renamed from: a  reason: collision with root package name */
    public long f53507a;

    /* renamed from: b  reason: collision with root package name */
    public LocationData f53508b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53509c = d.b.h0.r.d0.b.i().g("no_longer_show_address", false);

    public static b a() {
        if (f53506d == null) {
            synchronized (b.class) {
                if (f53506d == null) {
                    f53506d = new b();
                }
            }
        }
        return f53506d;
    }

    public LocationData b() {
        return this.f53508b;
    }

    public long c() {
        return this.f53507a;
    }

    public boolean d() {
        return this.f53509c;
    }

    public void e(LocationData locationData) {
        this.f53508b = locationData;
    }

    public void f(boolean z) {
        this.f53509c = z;
    }

    public void g(long j) {
        this.f53507a = j;
    }
}
