package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes5.dex */
public class i extends f<PointF> {
    private final PointF CX;
    private final float[] CY;
    private PathMeasure Da;
    private h nON;

    public i(List<? extends com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.CX = new PointF();
        this.CY = new float[2];
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
        Path ht = hVar.ht();
        if (ht == null) {
            return aVar.Gp;
        }
        if (this.nOK == null || (pointF = (PointF) this.nOK.b(hVar.Aq, hVar.Gs.floatValue(), hVar.Gp, hVar.Gq, hG(), f, getProgress())) == null) {
            if (this.nON != hVar) {
                this.Da = new PathMeasure(ht, false);
                this.nON = hVar;
            }
            this.Da.getPosTan(this.Da.getLength() * f, this.CY, null);
            this.CX.set(this.CY[0], this.CY[1]);
            return this.CX;
        }
        return pointF;
    }
}
