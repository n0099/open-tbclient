package d.a.a.u.j;

import android.graphics.PointF;
import d.a.a.s.b.o;
import d.a.a.u.i.m;
/* loaded from: classes.dex */
public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41787a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f41788b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.i.f f41789c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.u.i.b f41790d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f41791e;

    public f(String str, m<PointF, PointF> mVar, d.a.a.u.i.f fVar, d.a.a.u.i.b bVar, boolean z) {
        this.f41787a = str;
        this.f41788b = mVar;
        this.f41789c = fVar;
        this.f41790d = bVar;
        this.f41791e = z;
    }

    @Override // d.a.a.u.j.b
    public d.a.a.s.b.c a(d.a.a.f fVar, d.a.a.u.k.a aVar) {
        return new o(fVar, aVar, this);
    }

    public d.a.a.u.i.b b() {
        return this.f41790d;
    }

    public String c() {
        return this.f41787a;
    }

    public m<PointF, PointF> d() {
        return this.f41788b;
    }

    public d.a.a.u.i.f e() {
        return this.f41789c;
    }

    public boolean f() {
        return this.f41791e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f41788b + ", size=" + this.f41789c + '}';
    }
}
