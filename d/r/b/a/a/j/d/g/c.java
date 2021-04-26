package d.r.b.a.a.j.d.g;
/* loaded from: classes7.dex */
public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.j.d.f.a f67404a;

    /* renamed from: b  reason: collision with root package name */
    public Object f67405b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67406c;

    /* renamed from: d  reason: collision with root package name */
    public final String f67407d;

    /* renamed from: e  reason: collision with root package name */
    public final int f67408e;

    /* renamed from: f  reason: collision with root package name */
    public final String f67409f;

    public c(int i2, String str, int i3, String str2) {
        this.f67406c = i2;
        this.f67407d = str;
        this.f67408e = i3;
        this.f67409f = str2;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public boolean a() {
        return this.f67408e == 1;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public Object b() {
        return this.f67405b;
    }

    public final int c() {
        return this.f67406c;
    }

    public String d() {
        return this.f67407d;
    }

    public final void e(Object obj) {
        this.f67405b = obj;
    }

    public final void f(d.r.b.a.a.j.d.f.a aVar) {
        this.f67404a = aVar;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public String getMessage() {
        return this.f67409f;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public d.r.b.a.a.j.d.f.a getRequest() {
        return this.f67404a;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public int getResponseCode() {
        return this.f67408e;
    }
}
