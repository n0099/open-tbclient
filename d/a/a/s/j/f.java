package d.a.a.s.j;

import android.graphics.PointF;
import d.a.a.q.a.n;
import d.a.a.s.i.m;
/* loaded from: classes.dex */
public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41386a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f41387b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.s.i.f f41388c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.s.i.b f41389d;

    public f(String str, m<PointF, PointF> mVar, d.a.a.s.i.f fVar, d.a.a.s.i.b bVar) {
        this.f41386a = str;
        this.f41387b = mVar;
        this.f41388c = fVar;
        this.f41389d = bVar;
    }

    @Override // d.a.a.s.j.b
    public d.a.a.q.a.b a(d.a.a.f fVar, d.a.a.s.k.a aVar) {
        return new n(fVar, aVar, this);
    }

    public d.a.a.s.i.b b() {
        return this.f41389d;
    }

    public String c() {
        return this.f41386a;
    }

    public m<PointF, PointF> d() {
        return this.f41387b;
    }

    public d.a.a.s.i.f e() {
        return this.f41388c;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f41387b + ", size=" + this.f41388c + '}';
    }
}
