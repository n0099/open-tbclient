package d.b.p0.e.f;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public Context f65189a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65190b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f65191c;

    /* renamed from: d  reason: collision with root package name */
    public String f65192d;

    /* renamed from: e  reason: collision with root package name */
    public String f65193e;

    /* renamed from: f  reason: collision with root package name */
    public String f65194f;

    /* renamed from: g  reason: collision with root package name */
    public int f65195g = -200;

    public d(Context context) {
        if (context != null) {
            this.f65189a = context.getApplicationContext();
        }
    }

    @Override // d.b.p0.e.f.c
    public void a(String str) {
        this.f65194f = str;
    }

    @Override // d.b.p0.e.f.c
    public boolean b() {
        return this.f65190b;
    }

    @Override // d.b.p0.e.f.c
    public void c(int i) {
        this.f65195g = i;
    }

    @Override // d.b.p0.e.f.c
    public void e(boolean z) {
        this.f65191c = z;
    }

    @Override // d.b.p0.e.f.c
    public void f(String str) {
        this.f65193e = str;
    }

    @Override // d.b.p0.e.f.c
    public void g(String str) {
        this.f65192d = str;
    }

    @Override // d.b.p0.e.f.c
    public String getAAID() {
        return this.f65193e;
    }

    @Override // d.b.p0.e.f.c
    public String getOAID() {
        return this.f65192d;
    }

    @Override // d.b.p0.e.f.c
    public int getStatusCode() {
        return this.f65195g;
    }

    @Override // d.b.p0.e.f.c
    public String getVAID() {
        return this.f65194f;
    }

    @Override // d.b.p0.e.f.c
    public boolean h() {
        return this.f65191c;
    }

    @Override // d.b.p0.e.f.c
    public void i(boolean z) {
        this.f65190b = z;
    }
}
