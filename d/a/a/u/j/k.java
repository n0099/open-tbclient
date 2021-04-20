package d.a.a.u.j;

import d.a.a.s.b.q;
/* loaded from: classes.dex */
public class k implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41714a;

    /* renamed from: b  reason: collision with root package name */
    public final int f41715b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.i.h f41716c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f41717d;

    public k(String str, int i, d.a.a.u.i.h hVar, boolean z) {
        this.f41714a = str;
        this.f41715b = i;
        this.f41716c = hVar;
        this.f41717d = z;
    }

    @Override // d.a.a.u.j.b
    public d.a.a.s.b.c a(d.a.a.f fVar, d.a.a.u.k.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String b() {
        return this.f41714a;
    }

    public d.a.a.u.i.h c() {
        return this.f41716c;
    }

    public boolean d() {
        return this.f41717d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f41714a + ", index=" + this.f41715b + '}';
    }
}
