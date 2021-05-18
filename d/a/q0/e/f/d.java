package d.a.q0.e.f;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public Context f64500a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64501b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64502c;

    /* renamed from: d  reason: collision with root package name */
    public String f64503d;

    /* renamed from: e  reason: collision with root package name */
    public String f64504e;

    /* renamed from: f  reason: collision with root package name */
    public String f64505f;

    /* renamed from: g  reason: collision with root package name */
    public int f64506g = -200;

    public d(Context context) {
        if (context != null) {
            this.f64500a = context.getApplicationContext();
        }
    }

    @Override // d.a.q0.e.f.c
    public void a(int i2) {
        this.f64506g = i2;
    }

    @Override // d.a.q0.e.f.c
    public void b(String str) {
        this.f64505f = str;
    }

    @Override // d.a.q0.e.f.c
    public boolean c() {
        return this.f64501b;
    }

    @Override // d.a.q0.e.f.c
    public void e(boolean z) {
        this.f64502c = z;
    }

    @Override // d.a.q0.e.f.c
    public void f(String str) {
        this.f64504e = str;
    }

    @Override // d.a.q0.e.f.c
    public void g(String str) {
        this.f64503d = str;
    }

    @Override // d.a.q0.e.f.c
    public String getAAID() {
        return this.f64504e;
    }

    @Override // d.a.q0.e.f.c
    public String getOAID() {
        return this.f64503d;
    }

    @Override // d.a.q0.e.f.c
    public int getStatusCode() {
        return this.f64506g;
    }

    @Override // d.a.q0.e.f.c
    public String getVAID() {
        return this.f64505f;
    }

    @Override // d.a.q0.e.f.c
    public boolean h() {
        return this.f64502c;
    }

    @Override // d.a.q0.e.f.c
    public void i(boolean z) {
        this.f64501b = z;
    }
}
