package d.b.o0.e.f;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public Context f64925a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64926b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64927c;

    /* renamed from: d  reason: collision with root package name */
    public String f64928d;

    /* renamed from: e  reason: collision with root package name */
    public String f64929e;

    /* renamed from: f  reason: collision with root package name */
    public String f64930f;

    /* renamed from: g  reason: collision with root package name */
    public int f64931g = -200;

    public d(Context context) {
        if (context != null) {
            this.f64925a = context.getApplicationContext();
        }
    }

    @Override // d.b.o0.e.f.c
    public void a(String str) {
        this.f64930f = str;
    }

    @Override // d.b.o0.e.f.c
    public boolean b() {
        return this.f64926b;
    }

    @Override // d.b.o0.e.f.c
    public void c(int i) {
        this.f64931g = i;
    }

    @Override // d.b.o0.e.f.c
    public void e(boolean z) {
        this.f64927c = z;
    }

    @Override // d.b.o0.e.f.c
    public void f(String str) {
        this.f64929e = str;
    }

    @Override // d.b.o0.e.f.c
    public void g(String str) {
        this.f64928d = str;
    }

    @Override // d.b.o0.e.f.c
    public String getAAID() {
        return this.f64929e;
    }

    @Override // d.b.o0.e.f.c
    public String getOAID() {
        return this.f64928d;
    }

    @Override // d.b.o0.e.f.c
    public int getStatusCode() {
        return this.f64931g;
    }

    @Override // d.b.o0.e.f.c
    public String getVAID() {
        return this.f64930f;
    }

    @Override // d.b.o0.e.f.c
    public boolean h() {
        return this.f64927c;
    }

    @Override // d.b.o0.e.f.c
    public void i(boolean z) {
        this.f64926b = z;
    }
}
