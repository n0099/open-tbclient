package d.a.a.s.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes.dex */
public class i extends f<PointF> {
    public final PointF i;
    public final float[] j;
    public h k;
    public PathMeasure l;

    public i(List<? extends d.a.a.y.a<PointF>> list) {
        super(list);
        this.i = new PointF();
        this.j = new float[2];
        this.l = new PathMeasure();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.a.a.s.c.a
    /* renamed from: o */
    public PointF i(d.a.a.y.a<PointF> aVar, float f2) {
        PointF pointF;
        h hVar = (h) aVar;
        Path j = hVar.j();
        if (j == null) {
            return aVar.f41896b;
        }
        d.a.a.y.c<A> cVar = this.f41694e;
        if (cVar == 0 || (pointF = (PointF) cVar.b(hVar.f41899e, hVar.f41900f.floatValue(), hVar.f41896b, hVar.f41897c, e(), f2, f())) == null) {
            if (this.k != hVar) {
                this.l.setPath(j, false);
                this.k = hVar;
            }
            PathMeasure pathMeasure = this.l;
            pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.j, null);
            PointF pointF2 = this.i;
            float[] fArr = this.j;
            pointF2.set(fArr[0], fArr[1]);
            return this.i;
        }
        return pointF;
    }
}
