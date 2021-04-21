package d.a.a.u.j;

import android.graphics.PointF;
import d.a.a.u.i.m;
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41764a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f41765b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.i.f f41766c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f41767d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f41768e;

    public a(String str, m<PointF, PointF> mVar, d.a.a.u.i.f fVar, boolean z, boolean z2) {
        this.f41764a = str;
        this.f41765b = mVar;
        this.f41766c = fVar;
        this.f41767d = z;
        this.f41768e = z2;
    }

    @Override // d.a.a.u.j.b
    public d.a.a.s.b.c a(d.a.a.f fVar, d.a.a.u.k.a aVar) {
        return new d.a.a.s.b.f(fVar, aVar, this);
    }

    public String b() {
        return this.f41764a;
    }

    public m<PointF, PointF> c() {
        return this.f41765b;
    }

    public d.a.a.u.i.f d() {
        return this.f41766c;
    }

    public boolean e() {
        return this.f41768e;
    }

    public boolean f() {
        return this.f41767d;
    }
}
