package d.a.a.q.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import d.a.a.q.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements d, a.InterfaceC0529a, j {

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.s.k.a f41231c;

    /* renamed from: d  reason: collision with root package name */
    public final String f41232d;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.q.b.a<Integer, Integer> f41234f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.q.b.a<Integer, Integer> f41235g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public d.a.a.q.b.a<ColorFilter, ColorFilter> f41236h;
    public final d.a.a.f i;

    /* renamed from: a  reason: collision with root package name */
    public final Path f41229a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final Paint f41230b = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f41233e = new ArrayList();

    public f(d.a.a.f fVar, d.a.a.s.k.a aVar, d.a.a.s.j.i iVar) {
        this.f41231c = aVar;
        this.f41232d = iVar.d();
        this.i = fVar;
        if (iVar.b() != null && iVar.e() != null) {
            this.f41229a.setFillType(iVar.c());
            d.a.a.q.b.a<Integer, Integer> a2 = iVar.b().a();
            this.f41234f = a2;
            a2.a(this);
            aVar.h(this.f41234f);
            d.a.a.q.b.a<Integer, Integer> a3 = iVar.e().a();
            this.f41235g = a3;
            a3.a(this);
            aVar.h(this.f41235g);
            return;
        }
        this.f41234f = null;
        this.f41235g = null;
    }

    @Override // d.a.a.q.b.a.InterfaceC0529a
    public void a() {
        this.i.invalidateSelf();
    }

    @Override // d.a.a.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i = 0; i < list2.size(); i++) {
            b bVar = list2.get(i);
            if (bVar instanceof l) {
                this.f41233e.add((l) bVar);
            }
        }
    }

    @Override // d.a.a.q.a.d
    public void c(RectF rectF, Matrix matrix) {
        this.f41229a.reset();
        for (int i = 0; i < this.f41233e.size(); i++) {
            this.f41229a.addPath(this.f41233e.get(i).getPath(), matrix);
        }
        this.f41229a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // d.a.a.s.f
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        if (t == d.a.a.j.f41180a) {
            this.f41234f.m(cVar);
        } else if (t == d.a.a.j.f41183d) {
            this.f41235g.m(cVar);
        } else if (t == d.a.a.j.x) {
            if (cVar == null) {
                this.f41236h = null;
                return;
            }
            d.a.a.q.b.p pVar = new d.a.a.q.b.p(cVar);
            this.f41236h = pVar;
            pVar.a(this);
            this.f41231c.h(this.f41236h);
        }
    }

    @Override // d.a.a.s.f
    public void e(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2) {
        d.a.a.v.e.l(eVar, i, list, eVar2, this);
    }

    @Override // d.a.a.q.a.d
    public void g(Canvas canvas, Matrix matrix, int i) {
        d.a.a.c.a("FillContent#draw");
        this.f41230b.setColor(this.f41234f.h().intValue());
        this.f41230b.setAlpha(d.a.a.v.e.c((int) ((((i / 255.0f) * this.f41235g.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        d.a.a.q.b.a<ColorFilter, ColorFilter> aVar = this.f41236h;
        if (aVar != null) {
            this.f41230b.setColorFilter(aVar.h());
        }
        this.f41229a.reset();
        for (int i2 = 0; i2 < this.f41233e.size(); i2++) {
            this.f41229a.addPath(this.f41233e.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.f41229a, this.f41230b);
        d.a.a.c.c("FillContent#draw");
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41232d;
    }
}
