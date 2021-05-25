package d.a.t0.e.f;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public Context f64679a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64680b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64681c;

    /* renamed from: d  reason: collision with root package name */
    public String f64682d;

    /* renamed from: e  reason: collision with root package name */
    public String f64683e;

    /* renamed from: f  reason: collision with root package name */
    public String f64684f;

    /* renamed from: g  reason: collision with root package name */
    public int f64685g = -200;

    public d(Context context) {
        if (context != null) {
            this.f64679a = context.getApplicationContext();
        }
    }

    @Override // d.a.t0.e.f.c
    public void a(int i2) {
        this.f64685g = i2;
    }

    @Override // d.a.t0.e.f.c
    public void b(String str) {
        this.f64684f = str;
    }

    @Override // d.a.t0.e.f.c
    public boolean c() {
        return this.f64680b;
    }

    @Override // d.a.t0.e.f.c
    public void e(boolean z) {
        this.f64681c = z;
    }

    @Override // d.a.t0.e.f.c
    public void f(String str) {
        this.f64683e = str;
    }

    @Override // d.a.t0.e.f.c
    public void g(String str) {
        this.f64682d = str;
    }

    @Override // d.a.t0.e.f.c
    public String getAAID() {
        return this.f64683e;
    }

    @Override // d.a.t0.e.f.c
    public String getOAID() {
        return this.f64682d;
    }

    @Override // d.a.t0.e.f.c
    public int getStatusCode() {
        return this.f64685g;
    }

    @Override // d.a.t0.e.f.c
    public String getVAID() {
        return this.f64684f;
    }

    @Override // d.a.t0.e.f.c
    public boolean h() {
        return this.f64681c;
    }

    @Override // d.a.t0.e.f.c
    public void i(boolean z) {
        this.f64680b = z;
    }
}
