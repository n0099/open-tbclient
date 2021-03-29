package d.a.a.q.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d.a.a.q.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a implements a.InterfaceC0529a, j, d {

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.f f41207e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.s.k.a f41208f;

    /* renamed from: h  reason: collision with root package name */
    public final float[] f41210h;
    public final Paint i;
    public final d.a.a.q.b.a<?, Float> j;
    public final d.a.a.q.b.a<?, Integer> k;
    public final List<d.a.a.q.b.a<?, Float>> l;
    @Nullable
    public final d.a.a.q.b.a<?, Float> m;
    @Nullable
    public d.a.a.q.b.a<ColorFilter, ColorFilter> n;

    /* renamed from: a  reason: collision with root package name */
    public final PathMeasure f41203a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    public final Path f41204b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public final Path f41205c = new Path();

    /* renamed from: d  reason: collision with root package name */
    public final RectF f41206d = new RectF();

    /* renamed from: g  reason: collision with root package name */
    public final List<b> f41209g = new ArrayList();

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final List<l> f41211a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final r f41212b;

        public b(@Nullable r rVar) {
            this.f41211a = new ArrayList();
            this.f41212b = rVar;
        }
    }

    public a(d.a.a.f fVar, d.a.a.s.k.a aVar, Paint.Cap cap, Paint.Join join, float f2, d.a.a.s.i.d dVar, d.a.a.s.i.b bVar, List<d.a.a.s.i.b> list, d.a.a.s.i.b bVar2) {
        Paint paint = new Paint(1);
        this.i = paint;
        this.f41207e = fVar;
        this.f41208f = aVar;
        paint.setStyle(Paint.Style.STROKE);
        this.i.setStrokeCap(cap);
        this.i.setStrokeJoin(join);
        this.i.setStrokeMiter(f2);
        this.k = dVar.a();
        this.j = bVar.a();
        if (bVar2 == null) {
            this.m = null;
        } else {
            this.m = bVar2.a();
        }
        this.l = new ArrayList(list.size());
        this.f41210h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(list.get(i).a());
        }
        aVar.h(this.k);
        aVar.h(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            aVar.h(this.l.get(i2));
        }
        d.a.a.q.b.a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar.h(aVar2);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l.get(i3).a(this);
        }
        d.a.a.q.b.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a(this);
        }
    }

    @Override // d.a.a.q.b.a.InterfaceC0529a
    public void a() {
        this.f41207e.invalidateSelf();
    }

    @Override // d.a.a.q.a.b
    public void b(List<d.a.a.q.a.b> list, List<d.a.a.q.a.b> list2) {
        r rVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            d.a.a.q.a.b bVar = list.get(size);
            if (bVar instanceof r) {
                r rVar2 = (r) bVar;
                if (rVar2.i() == ShapeTrimPath.Type.Individually) {
                    rVar = rVar2;
                }
            }
        }
        if (rVar != null) {
            rVar.d(this);
        }
        b bVar2 = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            d.a.a.q.a.b bVar3 = list2.get(size2);
            if (bVar3 instanceof r) {
                r rVar3 = (r) bVar3;
                if (rVar3.i() == ShapeTrimPath.Type.Individually) {
                    if (bVar2 != null) {
                        this.f41209g.add(bVar2);
                    }
                    bVar2 = new b(rVar3);
                    rVar3.d(this);
                }
            }
            if (bVar3 instanceof l) {
                if (bVar2 == null) {
                    bVar2 = new b(rVar);
                }
                bVar2.f41211a.add((l) bVar3);
            }
        }
        if (bVar2 != null) {
            this.f41209g.add(bVar2);
        }
    }

    @Override // d.a.a.q.a.d
    public void c(RectF rectF, Matrix matrix) {
        d.a.a.c.a("StrokeContent#getBounds");
        this.f41204b.reset();
        for (int i = 0; i < this.f41209g.size(); i++) {
            b bVar = this.f41209g.get(i);
            for (int i2 = 0; i2 < bVar.f41211a.size(); i2++) {
                this.f41204b.addPath(((l) bVar.f41211a.get(i2)).getPath(), matrix);
            }
        }
        this.f41204b.computeBounds(this.f41206d, false);
        float floatValue = this.j.h().floatValue();
        RectF rectF2 = this.f41206d;
        float f2 = floatValue / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f41206d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        d.a.a.c.c("StrokeContent#getBounds");
    }

    @Override // d.a.a.s.f
    @CallSuper
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        if (t == d.a.a.j.f41183d) {
            this.k.m(cVar);
        } else if (t == d.a.a.j.k) {
            this.j.m(cVar);
        } else if (t == d.a.a.j.x) {
            if (cVar == null) {
                this.n = null;
                return;
            }
            d.a.a.q.b.p pVar = new d.a.a.q.b.p(cVar);
            this.n = pVar;
            pVar.a(this);
            this.f41208f.h(this.n);
        }
    }

    @Override // d.a.a.s.f
    public void e(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2) {
        d.a.a.v.e.l(eVar, i, list, eVar2, this);
    }

    public final void f(Matrix matrix) {
        d.a.a.c.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            d.a.a.c.c("StrokeContent#applyDashPattern");
            return;
        }
        float f2 = d.a.a.v.f.f(matrix);
        for (int i = 0; i < this.l.size(); i++) {
            this.f41210h[i] = this.l.get(i).h().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.f41210h;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f41210h;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.f41210h;
            fArr3[i] = fArr3[i] * f2;
        }
        d.a.a.q.b.a<?, Float> aVar = this.m;
        this.i.setPathEffect(new DashPathEffect(this.f41210h, aVar == null ? 0.0f : aVar.h().floatValue()));
        d.a.a.c.c("StrokeContent#applyDashPattern");
    }

    @Override // d.a.a.q.a.d
    public void g(Canvas canvas, Matrix matrix, int i) {
        d.a.a.c.a("StrokeContent#draw");
        this.i.setAlpha(d.a.a.v.e.c((int) ((((i / 255.0f) * this.k.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        this.i.setStrokeWidth(this.j.h().floatValue() * d.a.a.v.f.f(matrix));
        if (this.i.getStrokeWidth() <= 0.0f) {
            d.a.a.c.c("StrokeContent#draw");
            return;
        }
        f(matrix);
        d.a.a.q.b.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.i.setColorFilter(aVar.h());
        }
        for (int i2 = 0; i2 < this.f41209g.size(); i2++) {
            b bVar = this.f41209g.get(i2);
            if (bVar.f41212b != null) {
                h(canvas, bVar, matrix);
            } else {
                d.a.a.c.a("StrokeContent#buildPath");
                this.f41204b.reset();
                for (int size = bVar.f41211a.size() - 1; size >= 0; size--) {
                    this.f41204b.addPath(((l) bVar.f41211a.get(size)).getPath(), matrix);
                }
                d.a.a.c.c("StrokeContent#buildPath");
                d.a.a.c.a("StrokeContent#drawPath");
                canvas.drawPath(this.f41204b, this.i);
                d.a.a.c.c("StrokeContent#drawPath");
            }
        }
        d.a.a.c.c("StrokeContent#draw");
    }

    public final void h(Canvas canvas, b bVar, Matrix matrix) {
        d.a.a.c.a("StrokeContent#applyTrimPath");
        if (bVar.f41212b == null) {
            d.a.a.c.c("StrokeContent#applyTrimPath");
            return;
        }
        this.f41204b.reset();
        for (int size = bVar.f41211a.size() - 1; size >= 0; size--) {
            this.f41204b.addPath(((l) bVar.f41211a.get(size)).getPath(), matrix);
        }
        this.f41203a.setPath(this.f41204b, false);
        float length = this.f41203a.getLength();
        while (this.f41203a.nextContour()) {
            length += this.f41203a.getLength();
        }
        float floatValue = (bVar.f41212b.f().h().floatValue() * length) / 360.0f;
        float floatValue2 = ((bVar.f41212b.h().h().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((bVar.f41212b.e().h().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = bVar.f41211a.size() - 1; size2 >= 0; size2--) {
            this.f41205c.set(((l) bVar.f41211a.get(size2)).getPath());
            this.f41205c.transform(matrix);
            this.f41203a.setPath(this.f41205c, false);
            float length2 = this.f41203a.getLength();
            if (floatValue3 > length) {
                float f3 = floatValue3 - length;
                if (f3 < f2 + length2 && f2 < f3) {
                    d.a.a.v.f.a(this.f41205c, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f41205c, this.i);
                    f2 += length2;
                }
            }
            float f4 = f2 + length2;
            if (f4 >= floatValue2 && f2 <= floatValue3) {
                if (f4 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.f41205c, this.i);
                } else {
                    d.a.a.v.f.a(this.f41205c, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 <= f4 ? (floatValue3 - f2) / length2 : 1.0f, 0.0f);
                    canvas.drawPath(this.f41205c, this.i);
                }
            }
            f2 += length2;
        }
        d.a.a.c.c("StrokeContent#applyTrimPath");
    }
}
