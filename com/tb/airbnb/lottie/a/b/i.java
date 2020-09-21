package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes17.dex */
public class i extends f<PointF> {
    private final PointF DC;
    private final float[] DD;
    private PathMeasure DG;
    private h osJ;

    public i(List<? extends com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.DC = new PointF();
        this.DD = new float[2];
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
        Path iV = hVar.iV();
        if (iV == null) {
            return aVar.GX;
        }
        if (this.osG == null || (pointF = (PointF) this.osG.b(hVar.AX, hVar.Ha.floatValue(), hVar.GX, hVar.GY, ji(), f, getProgress())) == null) {
            if (this.osJ != hVar) {
                this.DG = new PathMeasure(iV, false);
                this.osJ = hVar;
            }
            this.DG.getPosTan(this.DG.getLength() * f, this.DD, null);
            this.DC.set(this.DD[0], this.DD[1]);
            return this.DC;
        }
        return pointF;
    }
}
