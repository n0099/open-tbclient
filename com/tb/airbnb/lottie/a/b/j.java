package com.tb.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes17.dex */
public class j extends f<PointF> {
    private final PointF DC;

    public j(List<com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.DC = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.GX == null || aVar.GY == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.GX;
        PointF pointF3 = aVar.GY;
        if (this.osG == null || (pointF = (PointF) this.osG.b(aVar.AX, aVar.Ha.floatValue(), pointF2, pointF3, f, ji(), getProgress())) == null) {
            this.DC.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.DC;
        }
        return pointF;
    }
}
