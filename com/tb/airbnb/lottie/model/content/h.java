package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class h {
    private final List<com.tb.airbnb.lottie.model.a> Gv = new ArrayList();
    private PointF Gw;
    private boolean closed;

    public h(PointF pointF, boolean z, List<com.tb.airbnb.lottie.model.a> list) {
        this.Gw = pointF;
        this.closed = z;
        this.Gv.addAll(list);
    }

    public h() {
    }

    private void h(float f, float f2) {
        if (this.Gw == null) {
            this.Gw = new PointF();
        }
        this.Gw.set(f, f2);
    }

    public PointF kn() {
        return this.Gw;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.tb.airbnb.lottie.model.a> ko() {
        return this.Gv;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.Gw == null) {
            this.Gw = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.ko().size() != hVar2.ko().size()) {
            com.tb.airbnb.lottie.d.warn("Curves must have the same number of control points. Shape 1: " + hVar.ko().size() + "\tShape 2: " + hVar2.ko().size());
        }
        if (this.Gv.isEmpty()) {
            int min = Math.min(hVar.ko().size(), hVar2.ko().size());
            for (int i = 0; i < min; i++) {
                this.Gv.add(new com.tb.airbnb.lottie.model.a());
            }
        }
        PointF kn = hVar.kn();
        PointF kn2 = hVar2.kn();
        h(com.tb.airbnb.lottie.d.e.lerp(kn.x, kn2.x, f), com.tb.airbnb.lottie.d.e.lerp(kn.y, kn2.y, f));
        for (int size = this.Gv.size() - 1; size >= 0; size--) {
            com.tb.airbnb.lottie.model.a aVar = hVar.ko().get(size);
            com.tb.airbnb.lottie.model.a aVar2 = hVar2.ko().get(size);
            PointF ju = aVar.ju();
            PointF jv = aVar.jv();
            PointF jw = aVar.jw();
            PointF ju2 = aVar2.ju();
            PointF jv2 = aVar2.jv();
            PointF jw2 = aVar2.jw();
            this.Gv.get(size).e(com.tb.airbnb.lottie.d.e.lerp(ju.x, ju2.x, f), com.tb.airbnb.lottie.d.e.lerp(ju.y, ju2.y, f));
            this.Gv.get(size).f(com.tb.airbnb.lottie.d.e.lerp(jv.x, jv2.x, f), com.tb.airbnb.lottie.d.e.lerp(jv.y, jv2.y, f));
            this.Gv.get(size).g(com.tb.airbnb.lottie.d.e.lerp(jw.x, jw2.x, f), com.tb.airbnb.lottie.d.e.lerp(jw.y, jw2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.Gv.size() + "closed=" + this.closed + '}';
    }
}
