package d.a.a.s.c;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes.dex */
public class m extends a<PointF, PointF> {
    public final PointF i;
    public final a<Float, Float> j;
    public final a<Float, Float> k;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.i = new PointF();
        this.j = aVar;
        this.k = aVar2;
        l(f());
    }

    @Override // d.a.a.s.c.a
    public void l(float f2) {
        this.j.l(f2);
        this.k.l(f2);
        this.i.set(this.j.h().floatValue(), this.k.h().floatValue());
        for (int i = 0; i < this.f41690a.size(); i++) {
            this.f41690a.get(i).a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.s.c.a
    /* renamed from: o */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.s.c.a
    /* renamed from: p */
    public PointF i(d.a.a.y.a<PointF> aVar, float f2) {
        return this.i;
    }
}
