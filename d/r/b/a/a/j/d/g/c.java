package d.r.b.a.a.j.d.g;
/* loaded from: classes7.dex */
public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.j.d.f.a f68133a;

    /* renamed from: b  reason: collision with root package name */
    public Object f68134b;

    /* renamed from: c  reason: collision with root package name */
    public final int f68135c;

    /* renamed from: d  reason: collision with root package name */
    public final String f68136d;

    /* renamed from: e  reason: collision with root package name */
    public final int f68137e;

    /* renamed from: f  reason: collision with root package name */
    public final String f68138f;

    public c(int i2, String str, int i3, String str2) {
        this.f68135c = i2;
        this.f68136d = str;
        this.f68137e = i3;
        this.f68138f = str2;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public boolean a() {
        return this.f68137e == 1;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public Object b() {
        return this.f68134b;
    }

    public final int c() {
        return this.f68135c;
    }

    public String d() {
        return this.f68136d;
    }

    public final void e(Object obj) {
        this.f68134b = obj;
    }

    public final void f(d.r.b.a.a.j.d.f.a aVar) {
        this.f68133a = aVar;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public String getMessage() {
        return this.f68138f;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public d.r.b.a.a.j.d.f.a getRequest() {
        return this.f68133a;
    }

    @Override // d.r.b.a.a.j.d.g.a
    public int getResponseCode() {
        return this.f68137e;
    }
}
