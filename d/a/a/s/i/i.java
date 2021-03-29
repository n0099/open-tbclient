package d.a.a.s.i;

import android.graphics.PointF;
/* loaded from: classes.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    public final b f41351a;

    /* renamed from: b  reason: collision with root package name */
    public final b f41352b;

    public i(b bVar, b bVar2) {
        this.f41351a = bVar;
        this.f41352b = bVar2;
    }

    @Override // d.a.a.s.i.m
    public d.a.a.q.b.a<PointF, PointF> a() {
        return new d.a.a.q.b.m(this.f41351a.a(), this.f41352b.a());
    }
}
