package com.ksad.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes5.dex */
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
        if (aVar.f8300a == null || aVar.f8301b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.f8300a;
        PointF pointF3 = aVar.f8301b;
        if (this.f8257b == null || (pointF = (PointF) this.f8257b.a(aVar.d, aVar.e.floatValue(), pointF2, pointF3, f, c(), f())) == null) {
            this.c.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.c;
        }
        return pointF;
    }
}
