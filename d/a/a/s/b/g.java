package d.a.a.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import d.a.a.s.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g implements e, a.b, k {

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.k.a f41535c;

    /* renamed from: d  reason: collision with root package name */
    public final String f41536d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f41537e;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.s.c.a<Integer, Integer> f41539g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.a.s.c.a<Integer, Integer> f41540h;
    @Nullable
    public d.a.a.s.c.a<ColorFilter, ColorFilter> i;
    public final d.a.a.f j;

    /* renamed from: a  reason: collision with root package name */
    public final Path f41533a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final Paint f41534b = new d.a.a.s.a(1);

    /* renamed from: f  reason: collision with root package name */
    public final List<m> f41538f = new ArrayList();

    public g(d.a.a.f fVar, d.a.a.u.k.a aVar, d.a.a.u.j.i iVar) {
        this.f41535c = aVar;
        this.f41536d = iVar.d();
        this.f41537e = iVar.f();
        this.j = fVar;
        if (iVar.b() != null && iVar.e() != null) {
            this.f41533a.setFillType(iVar.c());
            d.a.a.s.c.a<Integer, Integer> a2 = iVar.b().a();
            this.f41539g = a2;
            a2.a(this);
            aVar.i(this.f41539g);
            d.a.a.s.c.a<Integer, Integer> a3 = iVar.e().a();
            this.f41540h = a3;
            a3.a(this);
            aVar.i(this.f41540h);
            return;
        }
        this.f41539g = null;
        this.f41540h = null;
    }

    @Override // d.a.a.s.c.a.b
    public void a() {
        this.j.invalidateSelf();
    }

    @Override // d.a.a.s.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list2.size(); i++) {
            c cVar = list2.get(i);
            if (cVar instanceof m) {
                this.f41538f.add((m) cVar);
            }
        }
    }

    @Override // d.a.a.u.e
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        if (t == d.a.a.k.f41486a) {
            this.f41539g.m(cVar);
        } else if (t == d.a.a.k.f41489d) {
            this.f41540h.m(cVar);
        } else if (t == d.a.a.k.C) {
            d.a.a.s.c.a<ColorFilter, ColorFilter> aVar = this.i;
            if (aVar != null) {
                this.f41535c.C(aVar);
            }
            if (cVar == null) {
                this.i = null;
                return;
            }
            d.a.a.s.c.p pVar = new d.a.a.s.c.p(cVar);
            this.i = pVar;
            pVar.a(this);
            this.f41535c.i(this.i);
        }
    }

    @Override // d.a.a.u.e
    public void d(d.a.a.u.d dVar, int i, List<d.a.a.u.d> list, d.a.a.u.d dVar2) {
        d.a.a.x.g.m(dVar, i, list, dVar2, this);
    }

    @Override // d.a.a.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.f41533a.reset();
        for (int i = 0; i < this.f41538f.size(); i++) {
            this.f41533a.addPath(this.f41538f.get(i).getPath(), matrix);
        }
        this.f41533a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // d.a.a.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (this.f41537e) {
            return;
        }
        d.a.a.c.a("FillContent#draw");
        this.f41534b.setColor(((d.a.a.s.c.b) this.f41539g).o());
        this.f41534b.setAlpha(d.a.a.x.g.d((int) ((((i / 255.0f) * this.f41540h.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        d.a.a.s.c.a<ColorFilter, ColorFilter> aVar = this.i;
        if (aVar != null) {
            this.f41534b.setColorFilter(aVar.h());
        }
        this.f41533a.reset();
        for (int i2 = 0; i2 < this.f41538f.size(); i2++) {
            this.f41533a.addPath(this.f41538f.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.f41533a, this.f41534b);
        d.a.a.c.b("FillContent#draw");
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.f41536d;
    }
}
