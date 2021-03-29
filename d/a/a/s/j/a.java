package d.a.a.s.j;

import android.graphics.PointF;
import d.a.a.s.i.m;
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41365a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f41366b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.s.i.f f41367c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f41368d;

    public a(String str, m<PointF, PointF> mVar, d.a.a.s.i.f fVar, boolean z) {
        this.f41365a = str;
        this.f41366b = mVar;
        this.f41367c = fVar;
        this.f41368d = z;
    }

    @Override // d.a.a.s.j.b
    public d.a.a.q.a.b a(d.a.a.f fVar, d.a.a.s.k.a aVar) {
        return new d.a.a.q.a.e(fVar, aVar, this);
    }

    public String b() {
        return this.f41365a;
    }

    public m<PointF, PointF> c() {
        return this.f41366b;
    }

    public d.a.a.s.i.f d() {
        return this.f41367c;
    }

    public boolean e() {
        return this.f41368d;
    }
}
