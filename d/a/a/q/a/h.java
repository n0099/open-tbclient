package d.a.a.q.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
/* loaded from: classes.dex */
public class h extends a {
    public final String o;
    public final LongSparseArray<LinearGradient> p;
    public final LongSparseArray<RadialGradient> q;
    public final RectF r;
    public final GradientType s;
    public final int t;
    public final d.a.a.q.b.a<d.a.a.s.j.c, d.a.a.s.j.c> u;
    public final d.a.a.q.b.a<PointF, PointF> v;
    public final d.a.a.q.b.a<PointF, PointF> w;

    public h(d.a.a.f fVar, d.a.a.s.k.a aVar, d.a.a.s.j.e eVar) {
        super(fVar, aVar, eVar.b().toPaintCap(), eVar.g().toPaintJoin(), eVar.i(), eVar.k(), eVar.m(), eVar.h(), eVar.c());
        this.p = new LongSparseArray<>();
        this.q = new LongSparseArray<>();
        this.r = new RectF();
        this.o = eVar.j();
        this.s = eVar.f();
        this.t = (int) (fVar.l().d() / 32.0f);
        d.a.a.q.b.a<d.a.a.s.j.c, d.a.a.s.j.c> a2 = eVar.e().a();
        this.u = a2;
        a2.a(this);
        aVar.h(this.u);
        d.a.a.q.b.a<PointF, PointF> a3 = eVar.l().a();
        this.v = a3;
        a3.a(this);
        aVar.h(this.v);
        d.a.a.q.b.a<PointF, PointF> a4 = eVar.d().a();
        this.w = a4;
        a4.a(this);
        aVar.h(this.w);
    }

    @Override // d.a.a.q.a.a, d.a.a.q.a.d
    public void g(Canvas canvas, Matrix matrix, int i) {
        c(this.r, matrix);
        if (this.s == GradientType.Linear) {
            this.i.setShader(j());
        } else {
            this.i.setShader(k());
        }
        super.g(canvas, matrix, i);
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.o;
    }

    public final int i() {
        int round = Math.round(this.v.f() * this.t);
        int round2 = Math.round(this.w.f() * this.t);
        int round3 = Math.round(this.u.f() * this.t);
        int i = round != 0 ? PayBeanFactory.BEAN_ID_WIDTHDRAW * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    public final LinearGradient j() {
        long i = i();
        LinearGradient linearGradient = this.p.get(i);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h2 = this.v.h();
        PointF h3 = this.w.h();
        d.a.a.s.j.c h4 = this.u.h();
        int[] a2 = h4.a();
        float[] b2 = h4.b();
        RectF rectF = this.r;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + h2.x);
        RectF rectF2 = this.r;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + h2.y);
        RectF rectF3 = this.r;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + h3.x);
        RectF rectF4 = this.r;
        LinearGradient linearGradient2 = new LinearGradient(width, height, width2, (int) (rectF4.top + (rectF4.height() / 2.0f) + h3.y), a2, b2, Shader.TileMode.CLAMP);
        this.p.put(i, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient k() {
        long i = i();
        RadialGradient radialGradient = this.q.get(i);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h2 = this.v.h();
        PointF h3 = this.w.h();
        d.a.a.s.j.c h4 = this.u.h();
        int[] a2 = h4.a();
        float[] b2 = h4.b();
        RectF rectF = this.r;
        int width = (int) (rectF.left + (rectF.width() / 2.0f) + h2.x);
        RectF rectF2 = this.r;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f) + h2.y);
        RectF rectF3 = this.r;
        int width2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + h3.x);
        RectF rectF4 = this.r;
        RadialGradient radialGradient2 = new RadialGradient(width, height, (float) Math.hypot(width2 - width, ((int) ((rectF4.top + (rectF4.height() / 2.0f)) + h3.y)) - height), a2, b2, Shader.TileMode.CLAMP);
        this.q.put(i, radialGradient2);
        return radialGradient2;
    }
}
