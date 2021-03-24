package d.a.a.q.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes.dex */
public class j extends f<PointF> {

    /* renamed from: g  reason: collision with root package name */
    public final PointF f41300g;

    public j(List<d.a.a.w.a<PointF>> list) {
        super(list);
        this.f41300g = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.q.b.a
    /* renamed from: n */
    public PointF i(d.a.a.w.a<PointF> aVar, float f2) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f41450b;
        if (pointF3 != null && (pointF = aVar.f41451c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            d.a.a.w.c<A> cVar = this.f41292e;
            if (cVar == 0 || (pointF2 = (PointF) cVar.b(aVar.f41453e, aVar.f41454f.floatValue(), pointF4, pointF5, f2, e(), f())) == null) {
                PointF pointF6 = this.f41300g;
                float f3 = pointF4.x;
                float f4 = pointF4.y;
                pointF6.set(f3 + ((pointF5.x - f3) * f2), f4 + (f2 * (pointF5.y - f4)));
                return this.f41300g;
            }
            return pointF2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
