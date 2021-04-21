package d.a.a.s.c;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes.dex */
public class j extends f<PointF> {
    public final PointF i;

    public j(List<d.a.a.y.a<PointF>> list) {
        super(list);
        this.i = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.s.c.a
    /* renamed from: o */
    public PointF i(d.a.a.y.a<PointF> aVar, float f2) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f41896b;
        if (pointF3 != null && (pointF = aVar.f41897c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            d.a.a.y.c<A> cVar = this.f41694e;
            if (cVar == 0 || (pointF2 = (PointF) cVar.b(aVar.f41899e, aVar.f41900f.floatValue(), pointF4, pointF5, f2, e(), f())) == null) {
                PointF pointF6 = this.i;
                float f3 = pointF4.x;
                float f4 = pointF4.y;
                pointF6.set(f3 + ((pointF5.x - f3) * f2), f4 + (f2 * (pointF5.y - f4)));
                return this.i;
            }
            return pointF2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
