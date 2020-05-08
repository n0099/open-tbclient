package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h {
    private final List<com.tb.airbnb.lottie.model.a> Eg = new ArrayList();
    private PointF Eh;
    private boolean closed;

    public h(PointF pointF, boolean z, List<com.tb.airbnb.lottie.model.a> list) {
        this.Eh = pointF;
        this.closed = z;
        this.Eg.addAll(list);
    }

    public h() {
    }

    private void i(float f, float f2) {
        if (this.Eh == null) {
            this.Eh = new PointF();
        }
        this.Eh.set(f, f2);
    }

    public PointF iw() {
        return this.Eh;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.tb.airbnb.lottie.model.a> ix() {
        return this.Eg;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.Eh == null) {
            this.Eh = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.ix().size() != hVar2.ix().size()) {
            com.tb.airbnb.lottie.c.warn("Curves must have the same number of control points. Shape 1: " + hVar.ix().size() + "\tShape 2: " + hVar2.ix().size());
        }
        if (this.Eg.isEmpty()) {
            int min = Math.min(hVar.ix().size(), hVar2.ix().size());
            for (int i = 0; i < min; i++) {
                this.Eg.add(new com.tb.airbnb.lottie.model.a());
            }
        }
        PointF iw = hVar.iw();
        PointF iw2 = hVar2.iw();
        i(com.tb.airbnb.lottie.d.e.lerp(iw.x, iw2.x, f), com.tb.airbnb.lottie.d.e.lerp(iw.y, iw2.y, f));
        for (int size = this.Eg.size() - 1; size >= 0; size--) {
            com.tb.airbnb.lottie.model.a aVar = hVar.ix().get(size);
            com.tb.airbnb.lottie.model.a aVar2 = hVar2.ix().get(size);
            PointF hB = aVar.hB();
            PointF hC = aVar.hC();
            PointF hD = aVar.hD();
            PointF hB2 = aVar2.hB();
            PointF hC2 = aVar2.hC();
            PointF hD2 = aVar2.hD();
            this.Eg.get(size).f(com.tb.airbnb.lottie.d.e.lerp(hB.x, hB2.x, f), com.tb.airbnb.lottie.d.e.lerp(hB.y, hB2.y, f));
            this.Eg.get(size).g(com.tb.airbnb.lottie.d.e.lerp(hC.x, hC2.x, f), com.tb.airbnb.lottie.d.e.lerp(hC.y, hC2.y, f));
            this.Eg.get(size).h(com.tb.airbnb.lottie.d.e.lerp(hD.x, hD2.x, f), com.tb.airbnb.lottie.d.e.lerp(hD.y, hD2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.Eg.size() + "closed=" + this.closed + '}';
    }
}
