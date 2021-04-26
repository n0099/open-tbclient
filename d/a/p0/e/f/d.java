package d.a.p0.e.f;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public Context f63503a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63504b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63505c;

    /* renamed from: d  reason: collision with root package name */
    public String f63506d;

    /* renamed from: e  reason: collision with root package name */
    public String f63507e;

    /* renamed from: f  reason: collision with root package name */
    public String f63508f;

    /* renamed from: g  reason: collision with root package name */
    public int f63509g = -200;

    public d(Context context) {
        if (context != null) {
            this.f63503a = context.getApplicationContext();
        }
    }

    @Override // d.a.p0.e.f.c
    public void a(int i2) {
        this.f63509g = i2;
    }

    @Override // d.a.p0.e.f.c
    public void b(String str) {
        this.f63508f = str;
    }

    @Override // d.a.p0.e.f.c
    public boolean c() {
        return this.f63504b;
    }

    @Override // d.a.p0.e.f.c
    public void e(boolean z) {
        this.f63505c = z;
    }

    @Override // d.a.p0.e.f.c
    public void f(String str) {
        this.f63507e = str;
    }

    @Override // d.a.p0.e.f.c
    public void g(String str) {
        this.f63506d = str;
    }

    @Override // d.a.p0.e.f.c
    public String getAAID() {
        return this.f63507e;
    }

    @Override // d.a.p0.e.f.c
    public String getOAID() {
        return this.f63506d;
    }

    @Override // d.a.p0.e.f.c
    public int getStatusCode() {
        return this.f63509g;
    }

    @Override // d.a.p0.e.f.c
    public String getVAID() {
        return this.f63508f;
    }

    @Override // d.a.p0.e.f.c
    public boolean h() {
        return this.f63505c;
    }

    @Override // d.a.p0.e.f.c
    public void i(boolean z) {
        this.f63504b = z;
    }
}
