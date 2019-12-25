package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends f<PointF> {
    private final PointF gK;
    private final float[] gL;
    private PathMeasure gN;
    private h mNx;

    public i(List<? extends com.tb.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.gK = new PointF();
        this.gL = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.a.a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path bF = hVar.bF();
        if (bF == null) {
            return aVar.kn;
        }
        if (this.mNx != hVar) {
            this.gN = new PathMeasure(bF, false);
            this.mNx = hVar;
        }
        this.gN.getPosTan(this.gN.getLength() * f, this.gL, null);
        this.gK.set(this.gL[0], this.gL[1]);
        return this.gK;
    }
}
