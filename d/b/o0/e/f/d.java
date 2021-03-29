package d.b.o0.e.f;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public Context f64212a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64213b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64214c;

    /* renamed from: d  reason: collision with root package name */
    public String f64215d;

    /* renamed from: e  reason: collision with root package name */
    public String f64216e;

    /* renamed from: f  reason: collision with root package name */
    public String f64217f;

    /* renamed from: g  reason: collision with root package name */
    public int f64218g = -200;

    public d(Context context) {
        if (context != null) {
            this.f64212a = context.getApplicationContext();
        }
    }

    @Override // d.b.o0.e.f.c
    public void a(String str) {
        this.f64217f = str;
    }

    @Override // d.b.o0.e.f.c
    public boolean b() {
        return this.f64213b;
    }

    @Override // d.b.o0.e.f.c
    public void c(int i) {
        this.f64218g = i;
    }

    @Override // d.b.o0.e.f.c
    public void e(boolean z) {
        this.f64214c = z;
    }

    @Override // d.b.o0.e.f.c
    public void f(String str) {
        this.f64216e = str;
    }

    @Override // d.b.o0.e.f.c
    public void g(String str) {
        this.f64215d = str;
    }

    @Override // d.b.o0.e.f.c
    public String getAAID() {
        return this.f64216e;
    }

    @Override // d.b.o0.e.f.c
    public String getOAID() {
        return this.f64215d;
    }

    @Override // d.b.o0.e.f.c
    public int getStatusCode() {
        return this.f64218g;
    }

    @Override // d.b.o0.e.f.c
    public String getVAID() {
        return this.f64217f;
    }

    @Override // d.b.o0.e.f.c
    public boolean h() {
        return this.f64214c;
    }

    @Override // d.b.o0.e.f.c
    public void i(boolean z) {
        this.f64213b = z;
    }
}
