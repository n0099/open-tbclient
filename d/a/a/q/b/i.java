package d.a.a.q.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes.dex */
public class i extends f<PointF> {

    /* renamed from: g  reason: collision with root package name */
    public final PointF f41299g;

    /* renamed from: h  reason: collision with root package name */
    public final float[] f41300h;
    public h i;
    public PathMeasure j;

    public i(List<? extends d.a.a.w.a<PointF>> list) {
        super(list);
        this.f41299g = new PointF();
        this.f41300h = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.a.a.q.b.a
    /* renamed from: n */
    public PointF i(d.a.a.w.a<PointF> aVar, float f2) {
        PointF pointF;
        h hVar = (h) aVar;
        Path e2 = hVar.e();
        if (e2 == null) {
            return aVar.f41451b;
        }
        d.a.a.w.c<A> cVar = this.f41293e;
        if (cVar == 0 || (pointF = (PointF) cVar.b(hVar.f41454e, hVar.f41455f.floatValue(), hVar.f41451b, hVar.f41452c, e(), f2, f())) == null) {
            if (this.i != hVar) {
                this.j = new PathMeasure(e2, false);
                this.i = hVar;
            }
            PathMeasure pathMeasure = this.j;
            pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f41300h, null);
            PointF pointF2 = this.f41299g;
            float[] fArr = this.f41300h;
            pointF2.set(fArr[0], fArr[1]);
            return this.f41299g;
        }
        return pointF;
    }
}
