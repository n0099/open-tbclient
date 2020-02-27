package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h {
    private boolean closed;
    private final List<com.tb.airbnb.lottie.model.a> iI = new ArrayList();
    private PointF iJ;

    public h(PointF pointF, boolean z, List<com.tb.airbnb.lottie.model.a> list) {
        this.iJ = pointF;
        this.closed = z;
        this.iI.addAll(list);
    }

    public h() {
    }

    private void i(float f, float f2) {
        if (this.iJ == null) {
            this.iJ = new PointF();
        }
        this.iJ.set(f, f2);
    }

    public PointF cX() {
        return this.iJ;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.tb.airbnb.lottie.model.a> cY() {
        return this.iI;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.iJ == null) {
            this.iJ = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.cY().size() != hVar2.cY().size()) {
            com.tb.airbnb.lottie.c.warn("Curves must have the same number of control points. Shape 1: " + hVar.cY().size() + "\tShape 2: " + hVar2.cY().size());
        }
        if (this.iI.isEmpty()) {
            int min = Math.min(hVar.cY().size(), hVar2.cY().size());
            for (int i = 0; i < min; i++) {
                this.iI.add(new com.tb.airbnb.lottie.model.a());
            }
        }
        PointF cX = hVar.cX();
        PointF cX2 = hVar2.cX();
        i(com.tb.airbnb.lottie.d.e.lerp(cX.x, cX2.x, f), com.tb.airbnb.lottie.d.e.lerp(cX.y, cX2.y, f));
        for (int size = this.iI.size() - 1; size >= 0; size--) {
            com.tb.airbnb.lottie.model.a aVar = hVar.cY().get(size);
            com.tb.airbnb.lottie.model.a aVar2 = hVar2.cY().get(size);
            PointF ce = aVar.ce();
            PointF cf = aVar.cf();
            PointF cg = aVar.cg();
            PointF ce2 = aVar2.ce();
            PointF cf2 = aVar2.cf();
            PointF cg2 = aVar2.cg();
            this.iI.get(size).f(com.tb.airbnb.lottie.d.e.lerp(ce.x, ce2.x, f), com.tb.airbnb.lottie.d.e.lerp(ce.y, ce2.y, f));
            this.iI.get(size).g(com.tb.airbnb.lottie.d.e.lerp(cf.x, cf2.x, f), com.tb.airbnb.lottie.d.e.lerp(cf.y, cf2.y, f));
            this.iI.get(size).h(com.tb.airbnb.lottie.d.e.lerp(cg.x, cg2.x, f), com.tb.airbnb.lottie.d.e.lerp(cg.y, cg2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.iI.size() + "closed=" + this.closed + '}';
    }
}
