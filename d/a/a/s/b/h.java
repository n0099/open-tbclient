package d.a.a.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
import d.a.a.s.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h implements e, a.b, k {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f41541a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f41542b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.k.a f41543c;

    /* renamed from: d  reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f41544d = new LongSparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f41545e = new LongSparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public final Path f41546f = new Path();

    /* renamed from: g  reason: collision with root package name */
    public final Paint f41547g = new d.a.a.s.a(1);

    /* renamed from: h  reason: collision with root package name */
    public final RectF f41548h = new RectF();
    public final List<m> i = new ArrayList();
    public final GradientType j;
    public final d.a.a.s.c.a<d.a.a.u.j.c, d.a.a.u.j.c> k;
    public final d.a.a.s.c.a<Integer, Integer> l;
    public final d.a.a.s.c.a<PointF, PointF> m;
    public final d.a.a.s.c.a<PointF, PointF> n;
    @Nullable
    public d.a.a.s.c.a<ColorFilter, ColorFilter> o;
    @Nullable
    public d.a.a.s.c.p p;
    public final d.a.a.f q;
    public final int r;

    public h(d.a.a.f fVar, d.a.a.u.k.a aVar, d.a.a.u.j.d dVar) {
        this.f41543c = aVar;
        this.f41541a = dVar.f();
        this.f41542b = dVar.i();
        this.q = fVar;
        this.j = dVar.e();
        this.f41546f.setFillType(dVar.c());
        this.r = (int) (fVar.p().d() / 32.0f);
        d.a.a.s.c.a<d.a.a.u.j.c, d.a.a.u.j.c> a2 = dVar.d().a();
        this.k = a2;
        a2.a(this);
        aVar.i(this.k);
        d.a.a.s.c.a<Integer, Integer> a3 = dVar.g().a();
        this.l = a3;
        a3.a(this);
        aVar.i(this.l);
        d.a.a.s.c.a<PointF, PointF> a4 = dVar.h().a();
        this.m = a4;
        a4.a(this);
        aVar.i(this.m);
        d.a.a.s.c.a<PointF, PointF> a5 = dVar.b().a();
        this.n = a5;
        a5.a(this);
        aVar.i(this.n);
    }

    @Override // d.a.a.s.c.a.b
    public void a() {
        this.q.invalidateSelf();
    }

    @Override // d.a.a.s.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list2.size(); i++) {
            c cVar = list2.get(i);
            if (cVar instanceof m) {
                this.i.add((m) cVar);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.lang.Integer[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.a.a.u.e
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        if (t == d.a.a.k.f41489d) {
            this.l.m(cVar);
        } else if (t == d.a.a.k.C) {
            d.a.a.s.c.a<ColorFilter, ColorFilter> aVar = this.o;
            if (aVar != null) {
                this.f41543c.C(aVar);
            }
            if (cVar == null) {
                this.o = null;
                return;
            }
            d.a.a.s.c.p pVar = new d.a.a.s.c.p(cVar);
            this.o = pVar;
            pVar.a(this);
            this.f41543c.i(this.o);
        } else if (t == d.a.a.k.D) {
            d.a.a.s.c.p pVar2 = this.p;
            if (pVar2 != null) {
                this.f41543c.C(pVar2);
            }
            if (cVar == null) {
                this.p = null;
                return;
            }
            this.f41544d.clear();
            this.f41545e.clear();
            d.a.a.s.c.p pVar3 = new d.a.a.s.c.p(cVar);
            this.p = pVar3;
            pVar3.a(this);
            this.f41543c.i(this.p);
        }
    }

    @Override // d.a.a.u.e
    public void d(d.a.a.u.d dVar, int i, List<d.a.a.u.d> list, d.a.a.u.d dVar2) {
        d.a.a.x.g.m(dVar, i, list, dVar2, this);
    }

    @Override // d.a.a.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.f41546f.reset();
        for (int i = 0; i < this.i.size(); i++) {
            this.f41546f.addPath(this.i.get(i).getPath(), matrix);
        }
        this.f41546f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final int[] f(int[] iArr) {
        d.a.a.s.c.p pVar = this.p;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.h();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    @Override // d.a.a.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        Shader j;
        if (this.f41542b) {
            return;
        }
        d.a.a.c.a("GradientFillContent#draw");
        this.f41546f.reset();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.f41546f.addPath(this.i.get(i2).getPath(), matrix);
        }
        this.f41546f.computeBounds(this.f41548h, false);
        if (this.j == GradientType.LINEAR) {
            j = i();
        } else {
            j = j();
        }
        j.setLocalMatrix(matrix);
        this.f41547g.setShader(j);
        d.a.a.s.c.a<ColorFilter, ColorFilter> aVar = this.o;
        if (aVar != null) {
            this.f41547g.setColorFilter(aVar.h());
        }
        this.f41547g.setAlpha(d.a.a.x.g.d((int) ((((i / 255.0f) * this.l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f41546f, this.f41547g);
        d.a.a.c.b("GradientFillContent#draw");
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.f41541a;
    }

    public final int h() {
        int round = Math.round(this.m.f() * this.r);
        int round2 = Math.round(this.n.f() * this.r);
        int round3 = Math.round(this.k.f() * this.r);
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    public final LinearGradient i() {
        long h2 = h();
        LinearGradient linearGradient = this.f41544d.get(h2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h3 = this.m.h();
        PointF h4 = this.n.h();
        d.a.a.u.j.c h5 = this.k.h();
        LinearGradient linearGradient2 = new LinearGradient(h3.x, h3.y, h4.x, h4.y, f(h5.a()), h5.b(), Shader.TileMode.CLAMP);
        this.f41544d.put(h2, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient j() {
        long h2 = h();
        RadialGradient radialGradient = this.f41545e.get(h2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h3 = this.m.h();
        PointF h4 = this.n.h();
        d.a.a.u.j.c h5 = this.k.h();
        int[] f2 = f(h5.a());
        float[] b2 = h5.b();
        float f3 = h3.x;
        float f4 = h3.y;
        float hypot = (float) Math.hypot(h4.x - f3, h4.y - f4);
        RadialGradient radialGradient2 = new RadialGradient(f3, f4, hypot <= 0.0f ? 0.001f : hypot, f2, b2, Shader.TileMode.CLAMP);
        this.f41545e.put(h2, radialGradient2);
        return radialGradient2;
    }
}
