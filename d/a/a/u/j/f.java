package d.a.a.u.j;

import android.graphics.PointF;
import d.a.a.s.b.o;
import d.a.a.u.i.m;
/* loaded from: classes.dex */
public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41692a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f41693b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.i.f f41694c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.u.i.b f41695d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f41696e;

    public f(String str, m<PointF, PointF> mVar, d.a.a.u.i.f fVar, d.a.a.u.i.b bVar, boolean z) {
        this.f41692a = str;
        this.f41693b = mVar;
        this.f41694c = fVar;
        this.f41695d = bVar;
        this.f41696e = z;
    }

    @Override // d.a.a.u.j.b
    public d.a.a.s.b.c a(d.a.a.f fVar, d.a.a.u.k.a aVar) {
        return new o(fVar, aVar, this);
    }

    public d.a.a.u.i.b b() {
        return this.f41695d;
    }

    public String c() {
        return this.f41692a;
    }

    public m<PointF, PointF> d() {
        return this.f41693b;
    }

    public d.a.a.u.i.f e() {
        return this.f41694c;
    }

    public boolean f() {
        return this.f41696e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f41693b + ", size=" + this.f41694c + '}';
    }
}
