package d.a.a.s.b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
/* loaded from: classes.dex */
public class i extends a {
    public final String o;
    public final boolean p;
    public final LongSparseArray<LinearGradient> q;
    public final LongSparseArray<RadialGradient> r;
    public final RectF s;
    public final GradientType t;
    public final int u;
    public final d.a.a.s.c.a<d.a.a.u.j.c, d.a.a.u.j.c> v;
    public final d.a.a.s.c.a<PointF, PointF> w;
    public final d.a.a.s.c.a<PointF, PointF> x;
    @Nullable
    public d.a.a.s.c.p y;

    public i(d.a.a.f fVar, d.a.a.u.k.a aVar, d.a.a.u.j.e eVar) {
        super(fVar, aVar, eVar.b().toPaintCap(), eVar.g().toPaintJoin(), eVar.i(), eVar.k(), eVar.m(), eVar.h(), eVar.c());
        this.q = new LongSparseArray<>();
        this.r = new LongSparseArray<>();
        this.s = new RectF();
        this.o = eVar.j();
        this.t = eVar.f();
        this.p = eVar.n();
        this.u = (int) (fVar.p().d() / 32.0f);
        d.a.a.s.c.a<d.a.a.u.j.c, d.a.a.u.j.c> a2 = eVar.e().a();
        this.v = a2;
        a2.a(this);
        aVar.i(this.v);
        d.a.a.s.c.a<PointF, PointF> a3 = eVar.l().a();
        this.w = a3;
        a3.a(this);
        aVar.i(this.w);
        d.a.a.s.c.a<PointF, PointF> a4 = eVar.d().a();
        this.x = a4;
        a4.a(this);
        aVar.i(this.x);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.lang.Integer[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.a.a.s.b.a, d.a.a.u.e
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        super.c(t, cVar);
        if (t == d.a.a.k.D) {
            d.a.a.s.c.p pVar = this.y;
            if (pVar != null) {
                this.f41606f.C(pVar);
            }
            if (cVar == null) {
                this.y = null;
                return;
            }
            d.a.a.s.c.p pVar2 = new d.a.a.s.c.p(cVar);
            this.y = pVar2;
            pVar2.a(this);
            this.f41606f.i(this.y);
        }
    }

    @Override // d.a.a.s.b.a, d.a.a.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        Shader l;
        if (this.p) {
            return;
        }
        e(this.s, matrix, false);
        if (this.t == GradientType.LINEAR) {
            l = k();
        } else {
            l = l();
        }
        l.setLocalMatrix(matrix);
        this.i.setShader(l);
        super.g(canvas, matrix, i);
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.o;
    }

    public final int[] i(int[] iArr) {
        d.a.a.s.c.p pVar = this.y;
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

    public final int j() {
        int round = Math.round(this.w.f() * this.u);
        int round2 = Math.round(this.x.f() * this.u);
        int round3 = Math.round(this.v.f() * this.u);
        int i = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    public final LinearGradient k() {
        long j = j();
        LinearGradient linearGradient = this.q.get(j);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h2 = this.w.h();
        PointF h3 = this.x.h();
        d.a.a.u.j.c h4 = this.v.h();
        LinearGradient linearGradient2 = new LinearGradient(h2.x, h2.y, h3.x, h3.y, i(h4.a()), h4.b(), Shader.TileMode.CLAMP);
        this.q.put(j, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient l() {
        float f2;
        float f3;
        long j = j();
        RadialGradient radialGradient = this.r.get(j);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h2 = this.w.h();
        PointF h3 = this.x.h();
        d.a.a.u.j.c h4 = this.v.h();
        int[] i = i(h4.a());
        float[] b2 = h4.b();
        RadialGradient radialGradient2 = new RadialGradient(h2.x, h2.y, (float) Math.hypot(h3.x - f2, h3.y - f3), i, b2, Shader.TileMode.CLAMP);
        this.r.put(j, radialGradient2);
        return radialGradient2;
    }
}
