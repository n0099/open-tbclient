package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {
    private final List<com.tb.airbnb.lottie.model.a> EH = new ArrayList();
    private PointF EI;
    private boolean closed;

    public h(PointF pointF, boolean z, List<com.tb.airbnb.lottie.model.a> list) {
        this.EI = pointF;
        this.closed = z;
        this.EH.addAll(list);
    }

    public h() {
    }

    private void i(float f, float f2) {
        if (this.EI == null) {
            this.EI = new PointF();
        }
        this.EI.set(f, f2);
    }

    public PointF iM() {
        return this.EI;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.tb.airbnb.lottie.model.a> iN() {
        return this.EH;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.EI == null) {
            this.EI = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.iN().size() != hVar2.iN().size()) {
            com.tb.airbnb.lottie.c.warn("Curves must have the same number of control points. Shape 1: " + hVar.iN().size() + "\tShape 2: " + hVar2.iN().size());
        }
        if (this.EH.isEmpty()) {
            int min = Math.min(hVar.iN().size(), hVar2.iN().size());
            for (int i = 0; i < min; i++) {
                this.EH.add(new com.tb.airbnb.lottie.model.a());
            }
        }
        PointF iM = hVar.iM();
        PointF iM2 = hVar2.iM();
        i(com.tb.airbnb.lottie.d.e.lerp(iM.x, iM2.x, f), com.tb.airbnb.lottie.d.e.lerp(iM.y, iM2.y, f));
        for (int size = this.EH.size() - 1; size >= 0; size--) {
            com.tb.airbnb.lottie.model.a aVar = hVar.iN().get(size);
            com.tb.airbnb.lottie.model.a aVar2 = hVar2.iN().get(size);
            PointF hR = aVar.hR();
            PointF hS = aVar.hS();
            PointF hT = aVar.hT();
            PointF hR2 = aVar2.hR();
            PointF hS2 = aVar2.hS();
            PointF hT2 = aVar2.hT();
            this.EH.get(size).f(com.tb.airbnb.lottie.d.e.lerp(hR.x, hR2.x, f), com.tb.airbnb.lottie.d.e.lerp(hR.y, hR2.y, f));
            this.EH.get(size).g(com.tb.airbnb.lottie.d.e.lerp(hS.x, hS2.x, f), com.tb.airbnb.lottie.d.e.lerp(hS.y, hS2.y, f));
            this.EH.get(size).h(com.tb.airbnb.lottie.d.e.lerp(hT.x, hT2.x, f), com.tb.airbnb.lottie.d.e.lerp(hT.y, hT2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.EH.size() + "closed=" + this.closed + '}';
    }
}
