package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes4.dex */
public class i extends f<PointF> {
    private final PointF c;
    private final float[] d;
    private h e;
    private PathMeasure f;

    public i(List<? extends com.ksad.lottie.e.a<PointF>> list) {
        super(list);
        this.c = new PointF();
        this.d = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        h hVar = (h) aVar;
        Path a2 = hVar.a();
        if (a2 == null) {
            return aVar.f8001a;
        }
        if (this.f7958b == null || (pointF = (PointF) this.f7958b.a(hVar.d, hVar.e.floatValue(), hVar.f8001a, hVar.f8002b, c(), f, f())) == null) {
            if (this.e != hVar) {
                this.f = new PathMeasure(a2, false);
                this.e = hVar;
            }
            this.f.getPosTan(this.f.getLength() * f, this.d, null);
            this.c.set(this.d[0], this.d[1]);
            return this.c;
        }
        return pointF;
    }
}
