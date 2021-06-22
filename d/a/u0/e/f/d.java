package d.a.u0.e.f;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public Context f68501a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68502b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68503c;

    /* renamed from: d  reason: collision with root package name */
    public String f68504d;

    /* renamed from: e  reason: collision with root package name */
    public String f68505e;

    /* renamed from: f  reason: collision with root package name */
    public String f68506f;

    /* renamed from: g  reason: collision with root package name */
    public int f68507g = -200;

    public d(Context context) {
        if (context != null) {
            this.f68501a = context.getApplicationContext();
        }
    }

    @Override // d.a.u0.e.f.c
    public void a(int i2) {
        this.f68507g = i2;
    }

    @Override // d.a.u0.e.f.c
    public void b(String str) {
        this.f68506f = str;
    }

    @Override // d.a.u0.e.f.c
    public boolean c() {
        return this.f68502b;
    }

    @Override // d.a.u0.e.f.c
    public void e(boolean z) {
        this.f68503c = z;
    }

    @Override // d.a.u0.e.f.c
    public void f(String str) {
        this.f68505e = str;
    }

    @Override // d.a.u0.e.f.c
    public void g(String str) {
        this.f68504d = str;
    }

    @Override // d.a.u0.e.f.c
    public String getAAID() {
        return this.f68505e;
    }

    @Override // d.a.u0.e.f.c
    public String getOAID() {
        return this.f68504d;
    }

    @Override // d.a.u0.e.f.c
    public int getStatusCode() {
        return this.f68507g;
    }

    @Override // d.a.u0.e.f.c
    public String getVAID() {
        return this.f68506f;
    }

    @Override // d.a.u0.e.f.c
    public boolean h() {
        return this.f68503c;
    }

    @Override // d.a.u0.e.f.c
    public void i(boolean z) {
        this.f68502b = z;
    }
}
