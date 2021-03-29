package d.a.a.q.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: g  reason: collision with root package name */
    public final PointF f41304g;

    /* renamed from: h  reason: collision with root package name */
    public final a<Float, Float> f41305h;
    public final a<Float, Float> i;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f41304g = new PointF();
        this.f41305h = aVar;
        this.i = aVar2;
        l(f());
    }

    @Override // d.a.a.q.b.a
    public void l(float f2) {
        this.f41305h.l(f2);
        this.i.l(f2);
        this.f41304g.set(this.f41305h.h().floatValue(), this.i.h().floatValue());
        for (int i = 0; i < this.f41289a.size(); i++) {
            this.f41289a.get(i).a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.q.b.a
    /* renamed from: n */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.q.b.a
    /* renamed from: o */
    public PointF i(d.a.a.w.a<PointF> aVar, float f2) {
        return this.f41304g;
    }
}
