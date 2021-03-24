package d.a.a.q.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes.dex */
public class i extends f<PointF> {

    /* renamed from: g  reason: collision with root package name */
    public final PointF f41298g;

    /* renamed from: h  reason: collision with root package name */
    public final float[] f41299h;
    public h i;
    public PathMeasure j;

    public i(List<? extends d.a.a.w.a<PointF>> list) {
        super(list);
        this.f41298g = new PointF();
        this.f41299h = new float[2];
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
            return aVar.f41450b;
        }
        d.a.a.w.c<A> cVar = this.f41292e;
        if (cVar == 0 || (pointF = (PointF) cVar.b(hVar.f41453e, hVar.f41454f.floatValue(), hVar.f41450b, hVar.f41451c, e(), f2, f())) == null) {
            if (this.i != hVar) {
                this.j = new PathMeasure(e2, false);
                this.i = hVar;
            }
            PathMeasure pathMeasure = this.j;
            pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f41299h, null);
            PointF pointF2 = this.f41298g;
            float[] fArr = this.f41299h;
            pointF2.set(fArr[0], fArr[1]);
            return this.f41298g;
        }
        return pointF;
    }
}
