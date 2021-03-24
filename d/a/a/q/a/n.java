package d.a.a.q.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.q.b.a;
import java.util.List;
/* loaded from: classes.dex */
public class n implements a.InterfaceC0528a, j, l {

    /* renamed from: a  reason: collision with root package name */
    public final Path f41260a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final RectF f41261b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    public final String f41262c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.f f41263d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.q.b.a<?, PointF> f41264e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.q.b.a<?, PointF> f41265f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.q.b.a<?, Float> f41266g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public r f41267h;
    public boolean i;

    public n(d.a.a.f fVar, d.a.a.s.k.a aVar, d.a.a.s.j.f fVar2) {
        this.f41262c = fVar2.c();
        this.f41263d = fVar;
        this.f41264e = fVar2.d().a();
        this.f41265f = fVar2.e().a();
        this.f41266g = fVar2.b().a();
        aVar.h(this.f41264e);
        aVar.h(this.f41265f);
        aVar.h(this.f41266g);
        this.f41264e.a(this);
        this.f41265f.a(this);
        this.f41266g.a(this);
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
                    this.f41267h = rVar;
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
        this.f41263d.invalidateSelf();
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41262c;
    }

    @Override // d.a.a.q.a.l
    public Path getPath() {
        if (this.i) {
            return this.f41260a;
        }
        this.f41260a.reset();
        PointF h2 = this.f41265f.h();
        float f2 = h2.x / 2.0f;
        float f3 = h2.y / 2.0f;
        d.a.a.q.b.a<?, Float> aVar = this.f41266g;
        float floatValue = aVar == null ? 0.0f : aVar.h().floatValue();
        float min = Math.min(f2, f3);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF h3 = this.f41264e.h();
        this.f41260a.moveTo(h3.x + f2, (h3.y - f3) + floatValue);
        this.f41260a.lineTo(h3.x + f2, (h3.y + f3) - floatValue);
        if (floatValue > 0.0f) {
            RectF rectF = this.f41261b;
            float f4 = h3.x;
            float f5 = floatValue * 2.0f;
            float f6 = h3.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.f41260a.arcTo(this.f41261b, 0.0f, 90.0f, false);
        }
        this.f41260a.lineTo((h3.x - f2) + floatValue, h3.y + f3);
        if (floatValue > 0.0f) {
            RectF rectF2 = this.f41261b;
            float f7 = h3.x;
            float f8 = h3.y;
            float f9 = floatValue * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.f41260a.arcTo(this.f41261b, 90.0f, 90.0f, false);
        }
        this.f41260a.lineTo(h3.x - f2, (h3.y - f3) + floatValue);
        if (floatValue > 0.0f) {
            RectF rectF3 = this.f41261b;
            float f10 = h3.x;
            float f11 = h3.y;
            float f12 = floatValue * 2.0f;
            rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
            this.f41260a.arcTo(this.f41261b, 180.0f, 90.0f, false);
        }
        this.f41260a.lineTo((h3.x + f2) - floatValue, h3.y - f3);
        if (floatValue > 0.0f) {
            RectF rectF4 = this.f41261b;
            float f13 = h3.x;
            float f14 = floatValue * 2.0f;
            float f15 = h3.y;
            rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
            this.f41260a.arcTo(this.f41261b, 270.0f, 90.0f, false);
        }
        this.f41260a.close();
        d.a.a.v.f.b(this.f41260a, this.f41267h);
        this.i = true;
        return this.f41260a;
    }
}
