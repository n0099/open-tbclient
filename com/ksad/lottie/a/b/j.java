package com.ksad.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends f<PointF> {
    private final PointF c;

    public j(List<com.ksad.lottie.e.a<PointF>> list) {
        super(list);
        this.c = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.f5351a == null || aVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.f5351a;
        PointF pointF3 = aVar.b;
        if (this.b == null || (pointF = (PointF) this.b.a(aVar.d, aVar.e.floatValue(), pointF2, pointF3, f, c(), f())) == null) {
            this.c.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.c;
        }
        return pointF;
    }
}
