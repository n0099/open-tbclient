package com.tb.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes5.dex */
public class j extends f<PointF> {
    private final PointF gK;

    public j(List<com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.gK = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.km == null || aVar.kn == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.km;
        PointF pointF3 = aVar.kn;
        if (this.npA == null || (pointF = (PointF) this.npA.b(aVar.ec, aVar.kp.floatValue(), pointF2, pointF3, f, bS(), getProgress())) == null) {
            this.gK.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.gK;
        }
        return pointF;
    }
}
