package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends f<PointF> {
    private final PointF eX;
    private final float[] eY;
    private PathMeasure fa;
    private h ksJ;

    public i(List<? extends com.tb.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.eX = new PointF();
        this.eY = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.a.a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path bw = hVar.bw();
        if (bw == null) {
            return aVar.dK;
        }
        if (this.ksJ != hVar) {
            this.fa = new PathMeasure(bw, false);
            this.ksJ = hVar;
        }
        this.fa.getPosTan(this.fa.getLength() * f, this.eY, null);
        this.eX.set(this.eY[0], this.eY[1]);
        return this.eX;
    }
}
