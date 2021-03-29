package d.a.a.s.i;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import d.a.a.q.b.o;
/* loaded from: classes.dex */
public class l implements d.a.a.s.j.b {

    /* renamed from: a  reason: collision with root package name */
    public final e f41357a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f41358b;

    /* renamed from: c  reason: collision with root package name */
    public final g f41359c;

    /* renamed from: d  reason: collision with root package name */
    public final b f41360d;

    /* renamed from: e  reason: collision with root package name */
    public final d f41361e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final b f41362f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final b f41363g;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    @Override // d.a.a.s.j.b
    @Nullable
    public d.a.a.q.a.b a(d.a.a.f fVar, d.a.a.s.k.a aVar) {
        return null;
    }

    public o b() {
        return new o(this);
    }

    public e c() {
        return this.f41357a;
    }

    @Nullable
    public b d() {
        return this.f41363g;
    }

    public d e() {
        return this.f41361e;
    }

    public m<PointF, PointF> f() {
        return this.f41358b;
    }

    public b g() {
        return this.f41360d;
    }

    public g h() {
        return this.f41359c;
    }

    @Nullable
    public b i() {
        return this.f41362f;
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.f41357a = eVar;
        this.f41358b = mVar;
        this.f41359c = gVar;
        this.f41360d = bVar;
        this.f41361e = dVar;
        this.f41362f = bVar2;
        this.f41363g = bVar3;
    }
}
