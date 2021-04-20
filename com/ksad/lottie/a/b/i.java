package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends f<PointF> {

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31588c;

    /* renamed from: d  reason: collision with root package name */
    public final float[] f31589d;

    /* renamed from: e  reason: collision with root package name */
    public h f31590e;

    /* renamed from: f  reason: collision with root package name */
    public PathMeasure f31591f;

    public i(List<? extends com.ksad.lottie.e.a<PointF>> list) {
        super(list);
        this.f31588c = new PointF();
        this.f31589d = new float[2];
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
            return aVar.f31672a;
        }
        com.ksad.lottie.e.c<A> cVar = this.f31578b;
        if (cVar == 0 || (pointF = (PointF) cVar.a(hVar.f31675d, hVar.f31676e.floatValue(), hVar.f31672a, hVar.f31673b, c(), f2, f())) == null) {
            if (this.f31590e != hVar) {
                this.f31591f = new PathMeasure(a2, false);
                this.f31590e = hVar;
            }
            PathMeasure pathMeasure = this.f31591f;
            pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f31589d, null);
            PointF pointF2 = this.f31588c;
            float[] fArr = this.f31589d;
            pointF2.set(fArr[0], fArr[1]);
            return this.f31588c;
        }
        return pointF;
    }
}
