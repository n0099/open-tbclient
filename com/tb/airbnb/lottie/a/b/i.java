package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends f<PointF> {
    private final PointF gO;
    private final float[] gP;
    private PathMeasure gR;
    private h nqm;

    public i(List<? extends com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.gO = new PointF();
        this.gP = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        h hVar = (h) aVar;
        Path bG = hVar.bG();
        if (bG == null) {
            return aVar.kq;
        }
        if (this.nqj == null || (pointF = (PointF) this.nqj.b(hVar.ed, hVar.kt.floatValue(), hVar.kq, hVar.kr, bT(), f, getProgress())) == null) {
            if (this.nqm != hVar) {
                this.gR = new PathMeasure(bG, false);
                this.nqm = hVar;
            }
            this.gR.getPosTan(this.gR.getLength() * f, this.gP, null);
            this.gO.set(this.gP[0], this.gP[1]);
            return this.gO;
        }
        return pointF;
    }
}
