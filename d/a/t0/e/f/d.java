package d.a.t0.e.f;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public Context f68397a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68398b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68399c;

    /* renamed from: d  reason: collision with root package name */
    public String f68400d;

    /* renamed from: e  reason: collision with root package name */
    public String f68401e;

    /* renamed from: f  reason: collision with root package name */
    public String f68402f;

    /* renamed from: g  reason: collision with root package name */
    public int f68403g = -200;

    public d(Context context) {
        if (context != null) {
            this.f68397a = context.getApplicationContext();
        }
    }

    @Override // d.a.t0.e.f.c
    public void a(int i2) {
        this.f68403g = i2;
    }

    @Override // d.a.t0.e.f.c
    public void b(String str) {
        this.f68402f = str;
    }

    @Override // d.a.t0.e.f.c
    public boolean c() {
        return this.f68398b;
    }

    @Override // d.a.t0.e.f.c
    public void e(boolean z) {
        this.f68399c = z;
    }

    @Override // d.a.t0.e.f.c
    public void f(String str) {
        this.f68401e = str;
    }

    @Override // d.a.t0.e.f.c
    public void g(String str) {
        this.f68400d = str;
    }

    @Override // d.a.t0.e.f.c
    public String getAAID() {
        return this.f68401e;
    }

    @Override // d.a.t0.e.f.c
    public String getOAID() {
        return this.f68400d;
    }

    @Override // d.a.t0.e.f.c
    public int getStatusCode() {
        return this.f68403g;
    }

    @Override // d.a.t0.e.f.c
    public String getVAID() {
        return this.f68402f;
    }

    @Override // d.a.t0.e.f.c
    public boolean h() {
        return this.f68399c;
    }

    @Override // d.a.t0.e.f.c
    public void i(boolean z) {
        this.f68398b = z;
    }
}
