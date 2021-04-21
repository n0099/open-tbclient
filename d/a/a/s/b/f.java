package d.a.a.s.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.s.c.a;
import java.util.List;
/* loaded from: classes.dex */
public class f implements m, a.b, k {

    /* renamed from: b  reason: collision with root package name */
    public final String f41621b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.f f41622c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.s.c.a<?, PointF> f41623d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.s.c.a<?, PointF> f41624e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.u.j.a f41625f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41627h;

    /* renamed from: a  reason: collision with root package name */
    public final Path f41620a = new Path();

    /* renamed from: g  reason: collision with root package name */
    public b f41626g = new b();

    public f(d.a.a.f fVar, d.a.a.u.k.a aVar, d.a.a.u.j.a aVar2) {
        this.f41621b = aVar2.b();
        this.f41622c = fVar;
        this.f41623d = aVar2.d().a();
        this.f41624e = aVar2.c().a();
        this.f41625f = aVar2;
        aVar.i(this.f41623d);
        aVar.i(this.f41624e);
        this.f41623d.a(this);
        this.f41624e.a(this);
    }

    @Override // d.a.a.s.c.a.b
    public void a() {
        f();
    }

    @Override // d.a.a.s.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.i() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f41626g.a(sVar);
                    sVar.c(this);
                }
            }
        }
    }

    @Override // d.a.a.u.e
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        if (t == d.a.a.k.f41587g) {
            this.f41623d.m(cVar);
        } else if (t == d.a.a.k.j) {
            this.f41624e.m(cVar);
        }
    }

    @Override // d.a.a.u.e
    public void d(d.a.a.u.d dVar, int i, List<d.a.a.u.d> list, d.a.a.u.d dVar2) {
        d.a.a.x.g.m(dVar, i, list, dVar2, this);
    }

    public final void f() {
        this.f41627h = false;
        this.f41622c.invalidateSelf();
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.f41621b;
    }

    @Override // d.a.a.s.b.m
    public Path getPath() {
        if (this.f41627h) {
            return this.f41620a;
        }
        this.f41620a.reset();
        if (this.f41625f.e()) {
            this.f41627h = true;
            return this.f41620a;
        }
        PointF h2 = this.f41623d.h();
        float f2 = h2.x / 2.0f;
        float f3 = h2.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = 0.55228f * f3;
        this.f41620a.reset();
        if (this.f41625f.f()) {
            float f6 = -f3;
            this.f41620a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.f41620a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            this.f41620a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f11 = f4 + 0.0f;
            this.f41620a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
            this.f41620a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
        } else {
            float f12 = -f3;
            this.f41620a.moveTo(0.0f, f12);
            float f13 = f4 + 0.0f;
            float f14 = 0.0f - f5;
            this.f41620a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
            float f15 = f5 + 0.0f;
            this.f41620a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
            float f16 = 0.0f - f4;
            float f17 = -f2;
            this.f41620a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
            this.f41620a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
        }
        PointF h3 = this.f41624e.h();
        this.f41620a.offset(h3.x, h3.y);
        this.f41620a.close();
        this.f41626g.b(this.f41620a);
        this.f41627h = true;
        return this.f41620a;
    }
}
