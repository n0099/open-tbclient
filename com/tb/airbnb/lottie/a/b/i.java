package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends f<PointF> {
    private final PointF gN;
    private final float[] gO;
    private PathMeasure gQ;
    private h nsk;

    public i(List<? extends com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.gN = new PointF();
        this.gO = new float[2];
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
            return aVar.kp;
        }
        if (this.nsh == null || (pointF = (PointF) this.nsh.b(hVar.ec, hVar.ks.floatValue(), hVar.kp, hVar.kq, bT(), f, getProgress())) == null) {
            if (this.nsk != hVar) {
                this.gQ = new PathMeasure(bG, false);
                this.nsk = hVar;
            }
            this.gQ.getPosTan(this.gQ.getLength() * f, this.gO, null);
            this.gN.set(this.gO[0], this.gO[1]);
            return this.gN;
        }
        return pointF;
    }
}
