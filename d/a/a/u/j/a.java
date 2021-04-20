package d.a.a.u.j;

import android.graphics.PointF;
import d.a.a.u.i.m;
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41669a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f41670b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.i.f f41671c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f41672d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f41673e;

    public a(String str, m<PointF, PointF> mVar, d.a.a.u.i.f fVar, boolean z, boolean z2) {
        this.f41669a = str;
        this.f41670b = mVar;
        this.f41671c = fVar;
        this.f41672d = z;
        this.f41673e = z2;
    }

    @Override // d.a.a.u.j.b
    public d.a.a.s.b.c a(d.a.a.f fVar, d.a.a.u.k.a aVar) {
        return new d.a.a.s.b.f(fVar, aVar, this);
    }

    public String b() {
        return this.f41669a;
    }

    public m<PointF, PointF> c() {
        return this.f41670b;
    }

    public d.a.a.u.i.f d() {
        return this.f41671c;
    }

    public boolean e() {
        return this.f41673e;
    }

    public boolean f() {
        return this.f41672d;
    }
}
