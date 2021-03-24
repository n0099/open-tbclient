package d.b.o0.e.f;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public Context f64211a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64212b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64213c;

    /* renamed from: d  reason: collision with root package name */
    public String f64214d;

    /* renamed from: e  reason: collision with root package name */
    public String f64215e;

    /* renamed from: f  reason: collision with root package name */
    public String f64216f;

    /* renamed from: g  reason: collision with root package name */
    public int f64217g = -200;

    public d(Context context) {
        if (context != null) {
            this.f64211a = context.getApplicationContext();
        }
    }

    @Override // d.b.o0.e.f.c
    public void a(String str) {
        this.f64216f = str;
    }

    @Override // d.b.o0.e.f.c
    public boolean b() {
        return this.f64212b;
    }

    @Override // d.b.o0.e.f.c
    public void c(int i) {
        this.f64217g = i;
    }

    @Override // d.b.o0.e.f.c
    public void e(boolean z) {
        this.f64213c = z;
    }

    @Override // d.b.o0.e.f.c
    public void f(String str) {
        this.f64215e = str;
    }

    @Override // d.b.o0.e.f.c
    public void g(String str) {
        this.f64214d = str;
    }

    @Override // d.b.o0.e.f.c
    public String getAAID() {
        return this.f64215e;
    }

    @Override // d.b.o0.e.f.c
    public String getOAID() {
        return this.f64214d;
    }

    @Override // d.b.o0.e.f.c
    public int getStatusCode() {
        return this.f64217g;
    }

    @Override // d.b.o0.e.f.c
    public String getVAID() {
        return this.f64216f;
    }

    @Override // d.b.o0.e.f.c
    public boolean h() {
        return this.f64213c;
    }

    @Override // d.b.o0.e.f.c
    public void i(boolean z) {
        this.f64212b = z;
    }
}
