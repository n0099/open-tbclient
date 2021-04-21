package d.a.a.u.j;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes.dex */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41779a;

    /* renamed from: b  reason: collision with root package name */
    public final GradientType f41780b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.i.c f41781c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.u.i.d f41782d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.u.i.f f41783e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.u.i.f f41784f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.u.i.b f41785g;

    /* renamed from: h  reason: collision with root package name */
    public final ShapeStroke.LineCapType f41786h;
    public final ShapeStroke.LineJoinType i;
    public final float j;
    public final List<d.a.a.u.i.b> k;
    @Nullable
    public final d.a.a.u.i.b l;
    public final boolean m;

    public e(String str, GradientType gradientType, d.a.a.u.i.c cVar, d.a.a.u.i.d dVar, d.a.a.u.i.f fVar, d.a.a.u.i.f fVar2, d.a.a.u.i.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f2, List<d.a.a.u.i.b> list, @Nullable d.a.a.u.i.b bVar2, boolean z) {
        this.f41779a = str;
        this.f41780b = gradientType;
        this.f41781c = cVar;
        this.f41782d = dVar;
        this.f41783e = fVar;
        this.f41784f = fVar2;
        this.f41785g = bVar;
        this.f41786h = lineCapType;
        this.i = lineJoinType;
        this.j = f2;
        this.k = list;
        this.l = bVar2;
        this.m = z;
    }

    @Override // d.a.a.u.j.b
    public d.a.a.s.b.c a(d.a.a.f fVar, d.a.a.u.k.a aVar) {
        return new d.a.a.s.b.i(fVar, aVar, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.f41786h;
    }

    @Nullable
    public d.a.a.u.i.b c() {
        return this.l;
    }

    public d.a.a.u.i.f d() {
        return this.f41784f;
    }

    public d.a.a.u.i.c e() {
        return this.f41781c;
    }

    public GradientType f() {
        return this.f41780b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.i;
    }

    public List<d.a.a.u.i.b> h() {
        return this.k;
    }

    public float i() {
        return this.j;
    }

    public String j() {
        return this.f41779a;
    }

    public d.a.a.u.i.d k() {
        return this.f41782d;
    }

    public d.a.a.u.i.f l() {
        return this.f41783e;
    }

    public d.a.a.u.i.b m() {
        return this.f41785g;
    }

    public boolean n() {
        return this.m;
    }
}
