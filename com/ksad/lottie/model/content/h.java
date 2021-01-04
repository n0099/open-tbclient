package com.ksad.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.ksad.lottie.model.a> f8376a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private PointF f8377b;
    private boolean c;

    public h() {
    }

    public h(PointF pointF, boolean z, List<com.ksad.lottie.model.a> list) {
        this.f8377b = pointF;
        this.c = z;
        this.f8376a.addAll(list);
    }

    private void a(float f, float f2) {
        if (this.f8377b == null) {
            this.f8377b = new PointF();
        }
        this.f8377b.set(f, f2);
    }

    public PointF a() {
        return this.f8377b;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.f8377b == null) {
            this.f8377b = new PointF();
        }
        this.c = hVar.b() || hVar2.b();
        if (hVar.c().size() != hVar2.c().size()) {
            com.ksad.lottie.c.b("Curves must have the same number of control points. Shape 1: " + hVar.c().size() + "\tShape 2: " + hVar2.c().size());
        }
        if (this.f8376a.isEmpty()) {
            int min = Math.min(hVar.c().size(), hVar2.c().size());
            for (int i = 0; i < min; i++) {
                this.f8376a.add(new com.ksad.lottie.model.a());
            }
        }
        PointF a2 = hVar.a();
        PointF a3 = hVar2.a();
        a(com.ksad.lottie.d.e.a(a2.x, a3.x, f), com.ksad.lottie.d.e.a(a2.y, a3.y, f));
        for (int size = this.f8376a.size() - 1; size >= 0; size--) {
            com.ksad.lottie.model.a aVar = hVar.c().get(size);
            com.ksad.lottie.model.a aVar2 = hVar2.c().get(size);
            PointF a4 = aVar.a();
            PointF b2 = aVar.b();
            PointF c = aVar.c();
            PointF a5 = aVar2.a();
            PointF b3 = aVar2.b();
            PointF c2 = aVar2.c();
            this.f8376a.get(size).a(com.ksad.lottie.d.e.a(a4.x, a5.x, f), com.ksad.lottie.d.e.a(a4.y, a5.y, f));
            this.f8376a.get(size).b(com.ksad.lottie.d.e.a(b2.x, b3.x, f), com.ksad.lottie.d.e.a(b2.y, b3.y, f));
            this.f8376a.get(size).c(com.ksad.lottie.d.e.a(c.x, c2.x, f), com.ksad.lottie.d.e.a(c.y, c2.y, f));
        }
    }

    public boolean b() {
        return this.c;
    }

    public List<com.ksad.lottie.model.a> c() {
        return this.f8376a;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f8376a.size() + "closed=" + this.c + '}';
    }
}
