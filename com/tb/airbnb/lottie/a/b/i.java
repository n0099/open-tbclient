package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes16.dex */
public class i extends f<PointF> {
    private final PointF DW;
    private final float[] DX;
    private PathMeasure DZ;
    private h pzw;

    public i(List<? extends com.tb.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.DW = new PointF();
        this.DX = new float[2];
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
            return aVar.Hn;
        }
        if (this.pzt == null || (pointF = (PointF) this.pzt.b(hVar.Bo, hVar.Hq.floatValue(), hVar.Hn, hVar.Ho, jj(), f, getProgress())) == null) {
            if (this.pzw != hVar) {
                this.DZ = new PathMeasure(iW, false);
                this.pzw = hVar;
            }
            this.DZ.getPosTan(this.DZ.getLength() * f, this.DX, null);
            this.DW.set(this.DX[0], this.DX[1]);
            return this.DW;
        }
        return pointF;
    }
}
