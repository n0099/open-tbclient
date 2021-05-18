package d.r.b.a.a.j.d.g;
/* loaded from: classes7.dex */
public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.j.d.f.a f68090a;

    /* renamed from: b  reason: collision with root package name */
    public Object f68091b;

    /* renamed from: c  reason: collision with root package name */
    public final int f68092c;

    /* renamed from: d  reason: collision with root package name */
    public final String f68093d;

    /* renamed from: e  reason: collision with root package name */
    public final int f68094e;

    /* renamed from: f  reason: collision with root package name */
    public final String f68095f;

    public c(int i2, String str, int i3, String str2) {
        this.f68092c = i2;
        this.f68093d = str;
        this.f68094e = i3;
        this.f68095f = str2;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public boolean a() {
        return this.f68094e == 1;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public Object b() {
        return this.f68091b;
    }

    public final int c() {
        return this.f68092c;
    }

    public String d() {
        return this.f68093d;
    }

    public final void e(Object obj) {
        this.f68091b = obj;
    }

    public final void f(d.r.b.a.a.j.d.f.a aVar) {
        this.f68090a = aVar;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public String getMessage() {
        return this.f68095f;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public d.r.b.a.a.j.d.f.a getRequest() {
        return this.f68090a;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public int getResponseCode() {
        return this.f68094e;
    }
}
