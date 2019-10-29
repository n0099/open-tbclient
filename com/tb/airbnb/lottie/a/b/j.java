package com.tb.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends f<PointF> {
    private final PointF fA;

    public j(List<com.tb.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.fA = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.a.a<PointF> aVar, float f) {
        if (aVar.ej == null || aVar.ek == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = aVar.ej;
        PointF pointF2 = aVar.ek;
        this.fA.set(pointF.x + ((pointF2.x - pointF.x) * f), ((pointF2.y - pointF.y) * f) + pointF.y);
        return this.fA;
    }
}
