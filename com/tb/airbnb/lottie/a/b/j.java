package com.tb.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends f<PointF> {
    private final PointF gO;

    public j(List<com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.gO = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.kq == null || aVar.kr == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.kq;
        PointF pointF3 = aVar.kr;
        if (this.nqj == null || (pointF = (PointF) this.nqj.b(aVar.ed, aVar.kt.floatValue(), pointF2, pointF3, f, bT(), getProgress())) == null) {
            this.gO.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.gO;
        }
        return pointF;
    }
}
