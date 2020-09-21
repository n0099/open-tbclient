package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class h {
    private final List<com.tb.airbnb.lottie.model.a> Fm = new ArrayList();
    private PointF Fn;
    private boolean closed;

    public h(PointF pointF, boolean z, List<com.tb.airbnb.lottie.model.a> list) {
        this.Fn = pointF;
        this.closed = z;
        this.Fm.addAll(list);
    }

    public h() {
    }

    private void h(float f, float f2) {
        if (this.Fn == null) {
            this.Fn = new PointF();
        }
        this.Fn.set(f, f2);
    }

    public PointF km() {
        return this.Fn;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.tb.airbnb.lottie.model.a> kn() {
        return this.Fm;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.Fn == null) {
            this.Fn = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.kn().size() != hVar2.kn().size()) {
            com.tb.airbnb.lottie.c.warn("Curves must have the same number of control points. Shape 1: " + hVar.kn().size() + "\tShape 2: " + hVar2.kn().size());
        }
        if (this.Fm.isEmpty()) {
            int min = Math.min(hVar.kn().size(), hVar2.kn().size());
            for (int i = 0; i < min; i++) {
                this.Fm.add(new com.tb.airbnb.lottie.model.a());
            }
        }
        PointF km = hVar.km();
        PointF km2 = hVar2.km();
        h(com.tb.airbnb.lottie.d.e.lerp(km.x, km2.x, f), com.tb.airbnb.lottie.d.e.lerp(km.y, km2.y, f));
        for (int size = this.Fm.size() - 1; size >= 0; size--) {
            com.tb.airbnb.lottie.model.a aVar = hVar.kn().get(size);
            com.tb.airbnb.lottie.model.a aVar2 = hVar2.kn().get(size);
            PointF jt = aVar.jt();
            PointF ju = aVar.ju();
            PointF jv = aVar.jv();
            PointF jt2 = aVar2.jt();
            PointF ju2 = aVar2.ju();
            PointF jv2 = aVar2.jv();
            this.Fm.get(size).e(com.tb.airbnb.lottie.d.e.lerp(jt.x, jt2.x, f), com.tb.airbnb.lottie.d.e.lerp(jt.y, jt2.y, f));
            this.Fm.get(size).f(com.tb.airbnb.lottie.d.e.lerp(ju.x, ju2.x, f), com.tb.airbnb.lottie.d.e.lerp(ju.y, ju2.y, f));
            this.Fm.get(size).g(com.tb.airbnb.lottie.d.e.lerp(jv.x, jv2.x, f), com.tb.airbnb.lottie.d.e.lerp(jv.y, jv2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.Fm.size() + "closed=" + this.closed + '}';
    }
}
