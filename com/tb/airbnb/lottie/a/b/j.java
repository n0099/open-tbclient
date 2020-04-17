package com.tb.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends f<PointF> {
    private final PointF Cp;

    public j(List<com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.Cp = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.FL == null || aVar.FM == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.FL;
        PointF pointF3 = aVar.FM;
        if (this.mOQ == null || (pointF = (PointF) this.mOQ.b(aVar.zN, aVar.FO.floatValue(), pointF2, pointF3, f, hq(), getProgress())) == null) {
            this.Cp.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.Cp;
        }
        return pointF;
    }
}
