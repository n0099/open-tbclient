package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes20.dex */
public class i extends f<PointF> {
    private final PointF EM;
    private final float[] EN;
    private PathMeasure EP;
    private h pBx;

    public i(List<? extends com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.EM = new PointF();
        this.EN = new float[2];
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
        Path iW = hVar.iW();
        if (iW == null) {
            return aVar.If;
        }
        if (this.pBu == null || (pointF = (PointF) this.pBu.b(hVar.Ce, hVar.Ii.floatValue(), hVar.If, hVar.Ig, jj(), f, getProgress())) == null) {
            if (this.pBx != hVar) {
                this.EP = new PathMeasure(iW, false);
                this.pBx = hVar;
            }
            this.EP.getPosTan(this.EP.getLength() * f, this.EN, null);
            this.EM.set(this.EN[0], this.EN[1]);
            return this.EM;
        }
        return pointF;
    }
}
