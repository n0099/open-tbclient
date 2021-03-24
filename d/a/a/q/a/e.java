package d.a.a.q.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.q.b.a;
import java.util.List;
/* loaded from: classes.dex */
public class e implements l, a.InterfaceC0528a, j {

    /* renamed from: a  reason: collision with root package name */
    public final Path f41220a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f41221b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.f f41222c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.q.b.a<?, PointF> f41223d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.q.b.a<?, PointF> f41224e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.s.j.a f41225f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public r f41226g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41227h;

    public e(d.a.a.f fVar, d.a.a.s.k.a aVar, d.a.a.s.j.a aVar2) {
        this.f41221b = aVar2.b();
        this.f41222c = fVar;
        this.f41223d = aVar2.d().a();
        this.f41224e = aVar2.c().a();
        this.f41225f = aVar2;
        aVar.h(this.f41223d);
        aVar.h(this.f41224e);
        this.f41223d.a(this);
        this.f41224e.a(this);
    }

    @Override // d.a.a.q.b.a.InterfaceC0528a
    public void a() {
        f();
    }

    @Override // d.a.a.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.i() == ShapeTrimPath.Type.Simultaneously) {
                    this.f41226g = rVar;
                    rVar.d(this);
                }
            }
        }
    }

    @Override // d.a.a.s.f
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        if (t == d.a.a.j.f41185g) {
            this.f41223d.m(cVar);
        } else if (t == d.a.a.j.f41186h) {
            this.f41224e.m(cVar);
        }
    }

    @Override // d.a.a.s.f
    public void e(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2) {
        d.a.a.v.e.l(eVar, i, list, eVar2, this);
    }

    public final void f() {
        this.f41227h = false;
        this.f41222c.invalidateSelf();
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41221b;
    }

    @Override // d.a.a.q.a.l
    public Path getPath() {
        if (this.f41227h) {
            return this.f41220a;
        }
        this.f41220a.reset();
        PointF h2 = this.f41223d.h();
        float f2 = h2.x / 2.0f;
        float f3 = h2.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = 0.55228f * f3;
        this.f41220a.reset();
        if (this.f41225f.e()) {
            float f6 = -f3;
            this.f41220a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.f41220a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            this.f41220a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f11 = f4 + 0.0f;
            this.f41220a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
            this.f41220a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
        } else {
            float f12 = -f3;
            this.f41220a.moveTo(0.0f, f12);
            float f13 = f4 + 0.0f;
            float f14 = 0.0f - f5;
            this.f41220a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
            float f15 = f5 + 0.0f;
            this.f41220a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
            float f16 = 0.0f - f4;
            float f17 = -f2;
            this.f41220a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
            this.f41220a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
        }
        PointF h3 = this.f41224e.h();
        this.f41220a.offset(h3.x, h3.y);
        this.f41220a.close();
        d.a.a.v.f.b(this.f41220a, this.f41226g);
        this.f41227h = true;
        return this.f41220a;
    }
}
