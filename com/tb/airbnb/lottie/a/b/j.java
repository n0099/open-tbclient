package com.tb.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes16.dex */
public class j extends f<PointF> {
    private final PointF DW;

    public j(List<com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.DW = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.Hn == null || aVar.Ho == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.Hn;
        PointF pointF3 = aVar.Ho;
        if (this.pIN == null || (pointF = (PointF) this.pIN.b(aVar.Bo, aVar.Hq.floatValue(), pointF2, pointF3, f, jj(), getProgress())) == null) {
            this.DW.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.DW;
        }
        return pointF;
    }
}
