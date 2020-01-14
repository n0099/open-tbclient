package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes5.dex */
public class i extends f<PointF> {
    private final PointF gK;
    private final float[] gL;
    private PathMeasure gN;
    private h npI;

    public i(List<? extends com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.gK = new PointF();
        this.gL = new float[2];
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
        Path bF = hVar.bF();
        if (bF == null) {
            return aVar.km;
        }
        if (this.npF == null || (pointF = (PointF) this.npF.b(hVar.ec, hVar.kp.floatValue(), hVar.km, hVar.kn, bS(), f, getProgress())) == null) {
            if (this.npI != hVar) {
                this.gN = new PathMeasure(bF, false);
                this.npI = hVar;
            }
            this.gN.getPosTan(this.gN.getLength() * f, this.gL, null);
            this.gK.set(this.gL[0], this.gL[1]);
            return this.gK;
        }
        return pointF;
    }
}
