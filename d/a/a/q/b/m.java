package d.a.a.q.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: g  reason: collision with root package name */
    public final PointF f41303g;

    /* renamed from: h  reason: collision with root package name */
    public final a<Float, Float> f41304h;
    public final a<Float, Float> i;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f41303g = new PointF();
        this.f41304h = aVar;
        this.i = aVar2;
        l(f());
    }

    @Override // d.a.a.q.b.a
    public void l(float f2) {
        this.f41304h.l(f2);
        this.i.l(f2);
        this.f41303g.set(this.f41304h.h().floatValue(), this.i.h().floatValue());
        for (int i = 0; i < this.f41288a.size(); i++) {
            this.f41288a.get(i).a();
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
        return this.f41303g;
    }
}
