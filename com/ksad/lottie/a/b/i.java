package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends f<PointF> {

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31683c;

    /* renamed from: d  reason: collision with root package name */
    public final float[] f31684d;

    /* renamed from: e  reason: collision with root package name */
    public h f31685e;

    /* renamed from: f  reason: collision with root package name */
    public PathMeasure f31686f;

    public i(List<? extends com.ksad.lottie.e.a<PointF>> list) {
        super(list);
        this.f31683c = new PointF();
        this.f31684d = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f2) {
        PointF pointF;
        h hVar = (h) aVar;
        Path a2 = hVar.a();
        if (a2 == null) {
            return aVar.f31767a;
        }
        com.ksad.lottie.e.c<A> cVar = this.f31673b;
        if (cVar == 0 || (pointF = (PointF) cVar.a(hVar.f31770d, hVar.f31771e.floatValue(), hVar.f31767a, hVar.f31768b, c(), f2, f())) == null) {
            if (this.f31685e != hVar) {
                this.f31686f = new PathMeasure(a2, false);
                this.f31685e = hVar;
            }
            PathMeasure pathMeasure = this.f31686f;
            pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f31684d, null);
            PointF pointF2 = this.f31683c;
            float[] fArr = this.f31684d;
            pointF2.set(fArr[0], fArr[1]);
            return this.f31683c;
        }
        return pointF;
    }
}
