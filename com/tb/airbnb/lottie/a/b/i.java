package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends f<PointF> {
    private final PointF Cp;
    private final float[] Cq;
    private PathMeasure Cs;
    private h njb;

    public i(List<? extends com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.Cp = new PointF();
        this.Cq = new float[2];
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
        Path hd = hVar.hd();
        if (hd == null) {
            return aVar.FO;
        }
        if (this.niY == null || (pointF = (PointF) this.niY.b(hVar.zN, hVar.FR.floatValue(), hVar.FO, hVar.FP, hq(), f, getProgress())) == null) {
            if (this.njb != hVar) {
                this.Cs = new PathMeasure(hd, false);
                this.njb = hVar;
            }
            this.Cs.getPosTan(this.Cs.getLength() * f, this.Cq, null);
            this.Cp.set(this.Cq[0], this.Cq[1]);
            return this.Cp;
        }
        return pointF;
    }
}
