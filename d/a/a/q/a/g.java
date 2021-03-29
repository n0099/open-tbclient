package d.a.a.q.a;

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
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import d.a.a.q.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g implements d, a.InterfaceC0529a, j {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f41237a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.s.k.a f41238b;

    /* renamed from: c  reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f41239c = new LongSparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f41240d = new LongSparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public final Matrix f41241e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    public final Path f41242f = new Path();

    /* renamed from: g  reason: collision with root package name */
    public final Paint f41243g = new Paint(1);

    /* renamed from: h  reason: collision with root package name */
    public final RectF f41244h = new RectF();
    public final List<l> i = new ArrayList();
    public final GradientType j;
    public final d.a.a.q.b.a<d.a.a.s.j.c, d.a.a.s.j.c> k;
    public final d.a.a.q.b.a<Integer, Integer> l;
    public final d.a.a.q.b.a<PointF, PointF> m;
    public final d.a.a.q.b.a<PointF, PointF> n;
    @Nullable
    public d.a.a.q.b.a<ColorFilter, ColorFilter> o;
    public final d.a.a.f p;
    public final int q;

    public g(d.a.a.f fVar, d.a.a.s.k.a aVar, d.a.a.s.j.d dVar) {
        this.f41238b = aVar;
        this.f41237a = dVar.f();
        this.p = fVar;
        this.j = dVar.e();
        this.f41242f.setFillType(dVar.c());
        this.q = (int) (fVar.l().d() / 32.0f);
        d.a.a.q.b.a<d.a.a.s.j.c, d.a.a.s.j.c> a2 = dVar.d().a();
        this.k = a2;
        a2.a(this);
        aVar.h(this.k);
        d.a.a.q.b.a<Integer, Integer> a3 = dVar.g().a();
        this.l = a3;
        a3.a(this);
        aVar.h(this.l);
        d.a.a.q.b.a<PointF, PointF> a4 = dVar.h().a();
        this.m = a4;
        a4.a(this);
        aVar.h(this.m);
        d.a.a.q.b.a<PointF, PointF> a5 = dVar.b().a();
        this.n = a5;
        a5.a(this);
        aVar.h(this.n);
    }

    @Override // d.a.a.q.b.a.InterfaceC0529a
    public void a() {
        this.p.invalidateSelf();
    }

    @Override // d.a.a.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i = 0; i < list2.size(); i++) {
            b bVar = list2.get(i);
            if (bVar instanceof l) {
                this.i.add((l) bVar);
            }
        }
    }

    @Override // d.a.a.q.a.d
    public void c(RectF rectF, Matrix matrix) {
        this.f41242f.reset();
        for (int i = 0; i < this.i.size(); i++) {
            this.f41242f.addPath(this.i.get(i).getPath(), matrix);
        }
        this.f41242f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // d.a.a.s.f
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        if (t == d.a.a.j.x) {
            if (cVar == null) {
                this.o = null;
                return;
            }
            d.a.a.q.b.p pVar = new d.a.a.q.b.p(cVar);
            this.o = pVar;
            pVar.a(this);
            this.f41238b.h(this.o);
        }
    }

    @Override // d.a.a.s.f
    public void e(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2) {
        d.a.a.v.e.l(eVar, i, list, eVar2, this);
    }

    public final int f() {
        int round = Math.round(this.m.f() * this.q);
        int round2 = Math.round(this.n.f() * this.q);
        int round3 = Math.round(this.k.f() * this.q);
        int i = round != 0 ? PayBeanFactory.BEAN_ID_WIDTHDRAW * round : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    @Override // d.a.a.q.a.d
    public void g(Canvas canvas, Matrix matrix, int i) {
        Shader i2;
        d.a.a.c.a("GradientFillContent#draw");
        this.f41242f.reset();
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            this.f41242f.addPath(this.i.get(i3).getPath(), matrix);
        }
        this.f41242f.computeBounds(this.f41244h, false);
        if (this.j == GradientType.Linear) {
            i2 = h();
        } else {
            i2 = i();
        }
        this.f41241e.set(matrix);
        i2.setLocalMatrix(this.f41241e);
        this.f41243g.setShader(i2);
        d.a.a.q.b.a<ColorFilter, ColorFilter> aVar = this.o;
        if (aVar != null) {
            this.f41243g.setColorFilter(aVar.h());
        }
        this.f41243g.setAlpha(d.a.a.v.e.c((int) ((((i / 255.0f) * this.l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f41242f, this.f41243g);
        d.a.a.c.c("GradientFillContent#draw");
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41237a;
    }

    public final LinearGradient h() {
        long f2 = f();
        LinearGradient linearGradient = this.f41239c.get(f2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF h2 = this.m.h();
        PointF h3 = this.n.h();
        d.a.a.s.j.c h4 = this.k.h();
        LinearGradient linearGradient2 = new LinearGradient(h2.x, h2.y, h3.x, h3.y, h4.a(), h4.b(), Shader.TileMode.CLAMP);
        this.f41239c.put(f2, linearGradient2);
        return linearGradient2;
    }

    public final RadialGradient i() {
        float f2;
        float f3;
        long f4 = f();
        RadialGradient radialGradient = this.f41240d.get(f4);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF h2 = this.m.h();
        PointF h3 = this.n.h();
        d.a.a.s.j.c h4 = this.k.h();
        int[] a2 = h4.a();
        float[] b2 = h4.b();
        RadialGradient radialGradient2 = new RadialGradient(h2.x, h2.y, (float) Math.hypot(h3.x - f2, h3.y - f3), a2, b2, Shader.TileMode.CLAMP);
        this.f41240d.put(f4, radialGradient2);
        return radialGradient2;
    }
}
