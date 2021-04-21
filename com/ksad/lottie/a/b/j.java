package com.ksad.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends f<PointF> {

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31687c;

    public j(List<com.ksad.lottie.e.a<PointF>> list) {
        super(list);
        this.f31687c = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f2) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f31767a;
        if (pointF3 == null || (pointF = aVar.f31768b) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        com.ksad.lottie.e.c<A> cVar = this.f31673b;
        if (cVar == 0 || (pointF2 = (PointF) cVar.a(aVar.f31770d, aVar.f31771e.floatValue(), pointF4, pointF5, f2, c(), f())) == null) {
            PointF pointF6 = this.f31687c;
            float f3 = pointF4.x;
            float f4 = pointF4.y;
            pointF6.set(f3 + ((pointF5.x - f3) * f2), f4 + (f2 * (pointF5.y - f4)));
            return this.f31687c;
        }
        return pointF2;
    }
}
