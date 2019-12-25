package com.tb.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class j extends f<PointF> {
    private final PointF gK;

    public j(List<com.tb.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.gK = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.a.a<PointF> aVar, float f) {
        if (aVar.kn == null || aVar.ko == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = aVar.kn;
        PointF pointF2 = aVar.ko;
        this.gK.set(pointF.x + ((pointF2.x - pointF.x) * f), ((pointF2.y - pointF.y) * f) + pointF.y);
        return this.gK;
    }
}
