package d.a.a.s.j;

import d.a.a.q.a.p;
/* loaded from: classes.dex */
public class k implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41403a;

    /* renamed from: b  reason: collision with root package name */
    public final int f41404b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.s.i.h f41405c;

    public k(String str, int i, d.a.a.s.i.h hVar) {
        this.f41403a = str;
        this.f41404b = i;
        this.f41405c = hVar;
    }

    @Override // d.a.a.s.j.b
    public d.a.a.q.a.b a(d.a.a.f fVar, d.a.a.s.k.a aVar) {
        return new p(fVar, aVar, this);
    }

    public String b() {
        return this.f41403a;
    }

    public d.a.a.s.i.h c() {
        return this.f41405c;
    }

    public String toString() {
        return "ShapePath{name=" + this.f41403a + ", index=" + this.f41404b + '}';
    }
}
