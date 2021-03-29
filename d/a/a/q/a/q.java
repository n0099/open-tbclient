package d.a.a.q.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes.dex */
public class q extends a {
    public final d.a.a.s.k.a o;
    public final String p;
    public final d.a.a.q.b.a<Integer, Integer> q;
    @Nullable
    public d.a.a.q.b.a<ColorFilter, ColorFilter> r;

    public q(d.a.a.f fVar, d.a.a.s.k.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.b().toPaintCap(), shapeStroke.e().toPaintJoin(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.o = aVar;
        this.p = shapeStroke.h();
        d.a.a.q.b.a<Integer, Integer> a2 = shapeStroke.c().a();
        this.q = a2;
        a2.a(this);
        aVar.h(this.q);
    }

    @Override // d.a.a.q.a.a, d.a.a.s.f
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        super.d(t, cVar);
        if (t == d.a.a.j.f41181b) {
            this.q.m(cVar);
        } else if (t == d.a.a.j.x) {
            if (cVar == null) {
                this.r = null;
                return;
            }
            d.a.a.q.b.p pVar = new d.a.a.q.b.p(cVar);
            this.r = pVar;
            pVar.a(this);
            this.o.h(this.q);
        }
    }

    @Override // d.a.a.q.a.a, d.a.a.q.a.d
    public void g(Canvas canvas, Matrix matrix, int i) {
        this.i.setColor(this.q.h().intValue());
        d.a.a.q.b.a<ColorFilter, ColorFilter> aVar = this.r;
        if (aVar != null) {
            this.i.setColorFilter(aVar.h());
        }
        super.g(canvas, matrix, i);
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.p;
    }
}
