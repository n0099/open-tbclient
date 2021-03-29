package d.a.a.s.j;

import d.a.a.q.a.p;
/* loaded from: classes.dex */
public class k implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41404a;

    /* renamed from: b  reason: collision with root package name */
    public final int f41405b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.s.i.h f41406c;

    public k(String str, int i, d.a.a.s.i.h hVar) {
        this.f41404a = str;
        this.f41405b = i;
        this.f41406c = hVar;
    }

    @Override // d.a.a.s.j.b
    public d.a.a.q.a.b a(d.a.a.f fVar, d.a.a.s.k.a aVar) {
        return new p(fVar, aVar, this);
    }

    public String b() {
        return this.f41404a;
    }

    public d.a.a.s.i.h c() {
        return this.f41406c;
    }

    public String toString() {
        return "ShapePath{name=" + this.f41404a + ", index=" + this.f41405b + '}';
    }
}
