package d.a.a.u.j;

import d.a.a.s.b.q;
/* loaded from: classes.dex */
public class k implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41809a;

    /* renamed from: b  reason: collision with root package name */
    public final int f41810b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.i.h f41811c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f41812d;

    public k(String str, int i, d.a.a.u.i.h hVar, boolean z) {
        this.f41809a = str;
        this.f41810b = i;
        this.f41811c = hVar;
        this.f41812d = z;
    }

    @Override // d.a.a.u.j.b
    public d.a.a.s.b.c a(d.a.a.f fVar, d.a.a.u.k.a aVar) {
        return new q(fVar, aVar, this);
    }

    public String b() {
        return this.f41809a;
    }

    public d.a.a.u.i.h c() {
        return this.f41811c;
    }

    public boolean d() {
        return this.f41812d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f41809a + ", index=" + this.f41810b + '}';
    }
}
