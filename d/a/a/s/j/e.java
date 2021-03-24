package d.a.a.s.j;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes.dex */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41377a;

    /* renamed from: b  reason: collision with root package name */
    public final GradientType f41378b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.s.i.c f41379c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.s.i.d f41380d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.s.i.f f41381e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.s.i.f f41382f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.s.i.b f41383g;

    /* renamed from: h  reason: collision with root package name */
    public final ShapeStroke.LineCapType f41384h;
    public final ShapeStroke.LineJoinType i;
    public final float j;
    public final List<d.a.a.s.i.b> k;
    @Nullable
    public final d.a.a.s.i.b l;

    public e(String str, GradientType gradientType, d.a.a.s.i.c cVar, d.a.a.s.i.d dVar, d.a.a.s.i.f fVar, d.a.a.s.i.f fVar2, d.a.a.s.i.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f2, List<d.a.a.s.i.b> list, @Nullable d.a.a.s.i.b bVar2) {
        this.f41377a = str;
        this.f41378b = gradientType;
        this.f41379c = cVar;
        this.f41380d = dVar;
        this.f41381e = fVar;
        this.f41382f = fVar2;
        this.f41383g = bVar;
        this.f41384h = lineCapType;
        this.i = lineJoinType;
        this.j = f2;
        this.k = list;
        this.l = bVar2;
    }

    @Override // d.a.a.s.j.b
    public d.a.a.q.a.b a(d.a.a.f fVar, d.a.a.s.k.a aVar) {
        return new d.a.a.q.a.h(fVar, aVar, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.f41384h;
    }

    @Nullable
    public d.a.a.s.i.b c() {
        return this.l;
    }

    public d.a.a.s.i.f d() {
        return this.f41382f;
    }

    public d.a.a.s.i.c e() {
        return this.f41379c;
    }

    public GradientType f() {
        return this.f41378b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.i;
    }

    public List<d.a.a.s.i.b> h() {
        return this.k;
    }

    public float i() {
        return this.j;
    }

    public String j() {
        return this.f41377a;
    }

    public d.a.a.s.i.d k() {
        return this.f41380d;
    }

    public d.a.a.s.i.f l() {
        return this.f41381e;
    }

    public d.a.a.s.i.b m() {
        return this.f41383g;
    }
}
