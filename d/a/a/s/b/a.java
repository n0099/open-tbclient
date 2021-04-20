package d.a.a.s.b;

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
import d.a.a.s.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a implements a.b, k, e {

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.f f41510e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.u.k.a f41511f;

    /* renamed from: h  reason: collision with root package name */
    public final float[] f41513h;
    public final Paint i;
    public final d.a.a.s.c.a<?, Float> j;
    public final d.a.a.s.c.a<?, Integer> k;
    public final List<d.a.a.s.c.a<?, Float>> l;
    @Nullable
    public final d.a.a.s.c.a<?, Float> m;
    @Nullable
    public d.a.a.s.c.a<ColorFilter, ColorFilter> n;

    /* renamed from: a  reason: collision with root package name */
    public final PathMeasure f41506a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    public final Path f41507b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public final Path f41508c = new Path();

    /* renamed from: d  reason: collision with root package name */
    public final RectF f41509d = new RectF();

    /* renamed from: g  reason: collision with root package name */
    public final List<b> f41512g = new ArrayList();

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final List<m> f41514a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final s f41515b;

        public b(@Nullable s sVar) {
            this.f41514a = new ArrayList();
            this.f41515b = sVar;
        }
    }

    public a(d.a.a.f fVar, d.a.a.u.k.a aVar, Paint.Cap cap, Paint.Join join, float f2, d.a.a.u.i.d dVar, d.a.a.u.i.b bVar, List<d.a.a.u.i.b> list, d.a.a.u.i.b bVar2) {
        d.a.a.s.a aVar2 = new d.a.a.s.a(1);
        this.i = aVar2;
        this.f41510e = fVar;
        this.f41511f = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
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
        this.f41513h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(list.get(i).a());
        }
        aVar.i(this.k);
        aVar.i(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            aVar.i(this.l.get(i2));
        }
        d.a.a.s.c.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar.i(aVar3);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l.get(i3).a(this);
        }
        d.a.a.s.c.a<?, Float> aVar4 = this.m;
        if (aVar4 != null) {
            aVar4.a(this);
        }
    }

    @Override // d.a.a.s.c.a.b
    public void a() {
        this.f41510e.invalidateSelf();
    }

    @Override // d.a.a.s.b.c
    public void b(List<c> list, List<c> list2) {
        s sVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof s) {
                s sVar2 = (s) cVar;
                if (sVar2.i() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    sVar = sVar2;
                }
            }
        }
        if (sVar != null) {
            sVar.c(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof s) {
                s sVar3 = (s) cVar2;
                if (sVar3.i() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f41512g.add(bVar);
                    }
                    bVar = new b(sVar3);
                    sVar3.c(this);
                }
            }
            if (cVar2 instanceof m) {
                if (bVar == null) {
                    bVar = new b(sVar);
                }
                bVar.f41514a.add((m) cVar2);
            }
        }
        if (bVar != null) {
            this.f41512g.add(bVar);
        }
    }

    @Override // d.a.a.u.e
    @CallSuper
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        if (t == d.a.a.k.f41489d) {
            this.k.m(cVar);
        } else if (t == d.a.a.k.o) {
            this.j.m(cVar);
        } else if (t == d.a.a.k.C) {
            d.a.a.s.c.a<ColorFilter, ColorFilter> aVar = this.n;
            if (aVar != null) {
                this.f41511f.C(aVar);
            }
            if (cVar == null) {
                this.n = null;
                return;
            }
            d.a.a.s.c.p pVar = new d.a.a.s.c.p(cVar);
            this.n = pVar;
            pVar.a(this);
            this.f41511f.i(this.n);
        }
    }

    @Override // d.a.a.u.e
    public void d(d.a.a.u.d dVar, int i, List<d.a.a.u.d> list, d.a.a.u.d dVar2) {
        d.a.a.x.g.m(dVar, i, list, dVar2, this);
    }

    @Override // d.a.a.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        d.a.a.c.a("StrokeContent#getBounds");
        this.f41507b.reset();
        for (int i = 0; i < this.f41512g.size(); i++) {
            b bVar = this.f41512g.get(i);
            for (int i2 = 0; i2 < bVar.f41514a.size(); i2++) {
                this.f41507b.addPath(((m) bVar.f41514a.get(i2)).getPath(), matrix);
            }
        }
        this.f41507b.computeBounds(this.f41509d, false);
        float o = ((d.a.a.s.c.c) this.j).o();
        RectF rectF2 = this.f41509d;
        float f2 = o / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f41509d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        d.a.a.c.b("StrokeContent#getBounds");
    }

    public final void f(Matrix matrix) {
        d.a.a.c.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            d.a.a.c.b("StrokeContent#applyDashPattern");
            return;
        }
        float g2 = d.a.a.x.h.g(matrix);
        for (int i = 0; i < this.l.size(); i++) {
            this.f41513h[i] = this.l.get(i).h().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.f41513h;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f41513h;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.f41513h;
            fArr3[i] = fArr3[i] * g2;
        }
        d.a.a.s.c.a<?, Float> aVar = this.m;
        this.i.setPathEffect(new DashPathEffect(this.f41513h, aVar == null ? 0.0f : g2 * aVar.h().floatValue()));
        d.a.a.c.b("StrokeContent#applyDashPattern");
    }

    @Override // d.a.a.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        d.a.a.c.a("StrokeContent#draw");
        if (d.a.a.x.h.h(matrix)) {
            d.a.a.c.b("StrokeContent#draw");
            return;
        }
        this.i.setAlpha(d.a.a.x.g.d((int) ((((i / 255.0f) * ((d.a.a.s.c.e) this.k).o()) / 100.0f) * 255.0f), 0, 255));
        this.i.setStrokeWidth(((d.a.a.s.c.c) this.j).o() * d.a.a.x.h.g(matrix));
        if (this.i.getStrokeWidth() <= 0.0f) {
            d.a.a.c.b("StrokeContent#draw");
            return;
        }
        f(matrix);
        d.a.a.s.c.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.i.setColorFilter(aVar.h());
        }
        for (int i2 = 0; i2 < this.f41512g.size(); i2++) {
            b bVar = this.f41512g.get(i2);
            if (bVar.f41515b != null) {
                h(canvas, bVar, matrix);
            } else {
                d.a.a.c.a("StrokeContent#buildPath");
                this.f41507b.reset();
                for (int size = bVar.f41514a.size() - 1; size >= 0; size--) {
                    this.f41507b.addPath(((m) bVar.f41514a.get(size)).getPath(), matrix);
                }
                d.a.a.c.b("StrokeContent#buildPath");
                d.a.a.c.a("StrokeContent#drawPath");
                canvas.drawPath(this.f41507b, this.i);
                d.a.a.c.b("StrokeContent#drawPath");
            }
        }
        d.a.a.c.b("StrokeContent#draw");
    }

    public final void h(Canvas canvas, b bVar, Matrix matrix) {
        d.a.a.c.a("StrokeContent#applyTrimPath");
        if (bVar.f41515b == null) {
            d.a.a.c.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f41507b.reset();
        for (int size = bVar.f41514a.size() - 1; size >= 0; size--) {
            this.f41507b.addPath(((m) bVar.f41514a.get(size)).getPath(), matrix);
        }
        this.f41506a.setPath(this.f41507b, false);
        float length = this.f41506a.getLength();
        while (this.f41506a.nextContour()) {
            length += this.f41506a.getLength();
        }
        float floatValue = (bVar.f41515b.f().h().floatValue() * length) / 360.0f;
        float floatValue2 = ((bVar.f41515b.h().h().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((bVar.f41515b.d().h().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = bVar.f41514a.size() - 1; size2 >= 0; size2--) {
            this.f41508c.set(((m) bVar.f41514a.get(size2)).getPath());
            this.f41508c.transform(matrix);
            this.f41506a.setPath(this.f41508c, false);
            float length2 = this.f41506a.getLength();
            if (floatValue3 > length) {
                float f3 = floatValue3 - length;
                if (f3 < f2 + length2 && f2 < f3) {
                    d.a.a.x.h.a(this.f41508c, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f41508c, this.i);
                    f2 += length2;
                }
            }
            float f4 = f2 + length2;
            if (f4 >= floatValue2 && f2 <= floatValue3) {
                if (f4 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.f41508c, this.i);
                } else {
                    d.a.a.x.h.a(this.f41508c, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 <= f4 ? (floatValue3 - f2) / length2 : 1.0f, 0.0f);
                    canvas.drawPath(this.f41508c, this.i);
                }
            }
            f2 += length2;
        }
        d.a.a.c.b("StrokeContent#applyTrimPath");
    }
}
