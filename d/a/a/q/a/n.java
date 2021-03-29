package d.a.a.q.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.q.b.a;
import java.util.List;
/* loaded from: classes.dex */
public class n implements a.InterfaceC0529a, j, l {

    /* renamed from: a  reason: collision with root package name */
    public final Path f41261a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final RectF f41262b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    public final String f41263c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.f f41264d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.q.b.a<?, PointF> f41265e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.q.b.a<?, PointF> f41266f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41267g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public r f41268h;
    public boolean i;

    public n(d.a.a.f fVar, d.a.a.s.k.a aVar, d.a.a.s.j.f fVar2) {
        this.f41263c = fVar2.c();
        this.f41264d = fVar;
        this.f41265e = fVar2.d().a();
        this.f41266f = fVar2.e().a();
        this.f41267g = fVar2.b().a();
        aVar.h(this.f41265e);
        aVar.h(this.f41266f);
        aVar.h(this.f41267g);
        this.f41265e.a(this);
        this.f41266f.a(this);
        this.f41267g.a(this);
    }

    @Override // d.a.a.q.b.a.InterfaceC0529a
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
                    this.f41268h = rVar;
                    rVar.d(this);
                }
            }
        }
    }

    @Override // d.a.a.s.f
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
    }

    @Override // d.a.a.s.f
    public void e(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2) {
        d.a.a.v.e.l(eVar, i, list, eVar2, this);
    }

    public final void f() {
        this.i = false;
        this.f41264d.invalidateSelf();
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41263c;
    }

    @Override // d.a.a.q.a.l
    public Path getPath() {
        if (this.i) {
            return this.f41261a;
        }
        this.f41261a.reset();
        PointF h2 = this.f41266f.h();
        float f2 = h2.x / 2.0f;
        float f3 = h2.y / 2.0f;
        d.a.a.q.b.a<?, Float> aVar = this.f41267g;
        float floatValue = aVar == null ? 0.0f : aVar.h().floatValue();
        float min = Math.min(f2, f3);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF h3 = this.f41265e.h();
        this.f41261a.moveTo(h3.x + f2, (h3.y - f3) + floatValue);
        this.f41261a.lineTo(h3.x + f2, (h3.y + f3) - floatValue);
        int i = (floatValue > 0.0f ? 1 : (floatValue == 0.0f ? 0 : -1));
        if (i > 0) {
            RectF rectF = this.f41262b;
            float f4 = h3.x;
            float f5 = floatValue * 2.0f;
            float f6 = h3.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.f41261a.arcTo(this.f41262b, 0.0f, 90.0f, false);
        }
        this.f41261a.lineTo((h3.x - f2) + floatValue, h3.y + f3);
        if (i > 0) {
            RectF rectF2 = this.f41262b;
            float f7 = h3.x;
            float f8 = h3.y;
            float f9 = floatValue * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.f41261a.arcTo(this.f41262b, 90.0f, 90.0f, false);
        }
        this.f41261a.lineTo(h3.x - f2, (h3.y - f3) + floatValue);
        if (i > 0) {
            RectF rectF3 = this.f41262b;
            float f10 = h3.x;
            float f11 = h3.y;
            float f12 = floatValue * 2.0f;
            rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
            this.f41261a.arcTo(this.f41262b, 180.0f, 90.0f, false);
        }
        this.f41261a.lineTo((h3.x + f2) - floatValue, h3.y - f3);
        if (i > 0) {
            RectF rectF4 = this.f41262b;
            float f13 = h3.x;
            float f14 = floatValue * 2.0f;
            float f15 = h3.y;
            rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
            this.f41261a.arcTo(this.f41262b, 270.0f, 90.0f, false);
        }
        this.f41261a.close();
        d.a.a.v.f.b(this.f41261a, this.f41268h);
        this.i = true;
        return this.f41261a;
    }
}
