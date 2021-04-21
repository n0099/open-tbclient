package d.a.a.s.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes.dex */
public class r extends a {
    public final d.a.a.u.k.a o;
    public final String p;
    public final boolean q;
    public final d.a.a.s.c.a<Integer, Integer> r;
    @Nullable
    public d.a.a.s.c.a<ColorFilter, ColorFilter> s;

    public r(d.a.a.f fVar, d.a.a.u.k.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.b().toPaintCap(), shapeStroke.e().toPaintJoin(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.o = aVar;
        this.p = shapeStroke.h();
        this.q = shapeStroke.k();
        d.a.a.s.c.a<Integer, Integer> a2 = shapeStroke.c().a();
        this.r = a2;
        a2.a(this);
        aVar.i(this.r);
    }

    @Override // d.a.a.s.b.a, d.a.a.u.e
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        super.c(t, cVar);
        if (t == d.a.a.k.f41582b) {
            this.r.m(cVar);
        } else if (t == d.a.a.k.C) {
            d.a.a.s.c.a<ColorFilter, ColorFilter> aVar = this.s;
            if (aVar != null) {
                this.o.C(aVar);
            }
            if (cVar == null) {
                this.s = null;
                return;
            }
            d.a.a.s.c.p pVar = new d.a.a.s.c.p(cVar);
            this.s = pVar;
            pVar.a(this);
            this.o.i(this.r);
        }
    }

    @Override // d.a.a.s.b.a, d.a.a.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (this.q) {
            return;
        }
        this.i.setColor(((d.a.a.s.c.b) this.r).o());
        d.a.a.s.c.a<ColorFilter, ColorFilter> aVar = this.s;
        if (aVar != null) {
            this.i.setColorFilter(aVar.h());
        }
        super.g(canvas, matrix, i);
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.p;
    }
}
