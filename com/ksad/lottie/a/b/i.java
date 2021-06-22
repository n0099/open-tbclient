package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends f<PointF> {

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31925c;

    /* renamed from: d  reason: collision with root package name */
    public final float[] f31926d;

    /* renamed from: e  reason: collision with root package name */
    public h f31927e;

    /* renamed from: f  reason: collision with root package name */
    public PathMeasure f31928f;

    public i(List<? extends com.ksad.lottie.e.a<PointF>> list) {
        super(list);
        this.f31925c = new PointF();
        this.f31926d = new float[2];
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
            return aVar.f32011a;
        }
        com.ksad.lottie.e.c<A> cVar = this.f31915b;
        if (cVar == 0 || (pointF = (PointF) cVar.a(hVar.f32014d, hVar.f32015e.floatValue(), hVar.f32011a, hVar.f32012b, c(), f2, f())) == null) {
            if (this.f31927e != hVar) {
                this.f31928f = new PathMeasure(a2, false);
                this.f31927e = hVar;
            }
            PathMeasure pathMeasure = this.f31928f;
            pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f31926d, null);
            PointF pointF2 = this.f31925c;
            float[] fArr = this.f31926d;
            pointF2.set(fArr[0], fArr[1]);
            return this.f31925c;
        }
        return pointF;
    }
}
