package com.tb.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends f<PointF> {
    private final PointF eX;

    public j(List<com.tb.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.eX = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.a.a<PointF> aVar, float f) {
        if (aVar.dK == null || aVar.dL == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = aVar.dK;
        PointF pointF2 = aVar.dL;
        this.eX.set(pointF.x + ((pointF2.x - pointF.x) * f), ((pointF2.y - pointF.y) * f) + pointF.y);
        return this.eX;
    }
}
