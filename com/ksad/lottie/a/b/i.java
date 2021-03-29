package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends f<PointF> {

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31299c;

    /* renamed from: d  reason: collision with root package name */
    public final float[] f31300d;

    /* renamed from: e  reason: collision with root package name */
    public h f31301e;

    /* renamed from: f  reason: collision with root package name */
    public PathMeasure f31302f;

    public i(List<? extends com.ksad.lottie.e.a<PointF>> list) {
        super(list);
        this.f31299c = new PointF();
        this.f31300d = new float[2];
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
            return aVar.f31383a;
        }
        com.ksad.lottie.e.c<A> cVar = this.f31289b;
        if (cVar == 0 || (pointF = (PointF) cVar.a(hVar.f31386d, hVar.f31387e.floatValue(), hVar.f31383a, hVar.f31384b, c(), f2, f())) == null) {
            if (this.f31301e != hVar) {
                this.f31302f = new PathMeasure(a2, false);
                this.f31301e = hVar;
            }
            PathMeasure pathMeasure = this.f31302f;
            pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f31300d, null);
            PointF pointF2 = this.f31299c;
            float[] fArr = this.f31300d;
            pointF2.set(fArr[0], fArr[1]);
            return this.f31299c;
        }
        return pointF;
    }
}
