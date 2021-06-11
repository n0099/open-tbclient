package com.ksad.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.ksad.lottie.model.a> f32074a;

    /* renamed from: b  reason: collision with root package name */
    public PointF f32075b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32076c;

    public h() {
        this.f32074a = new ArrayList();
    }

    public h(PointF pointF, boolean z, List<com.ksad.lottie.model.a> list) {
        ArrayList arrayList = new ArrayList();
        this.f32074a = arrayList;
        this.f32075b = pointF;
        this.f32076c = z;
        arrayList.addAll(list);
    }

    private void a(float f2, float f3) {
        if (this.f32075b == null) {
            this.f32075b = new PointF();
        }
        this.f32075b.set(f2, f3);
    }

    public PointF a() {
        return this.f32075b;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f32075b == null) {
            this.f32075b = new PointF();
        }
        this.f32076c = hVar.b() || hVar2.b();
        if (hVar.c().size() != hVar2.c().size()) {
            com.ksad.lottie.c.b("Curves must have the same number of control points. Shape 1: " + hVar.c().size() + "\tShape 2: " + hVar2.c().size());
        }
        if (this.f32074a.isEmpty()) {
            int min = Math.min(hVar.c().size(), hVar2.c().size());
            for (int i2 = 0; i2 < min; i2++) {
                this.f32074a.add(new com.ksad.lottie.model.a());
            }
        }
        PointF a2 = hVar.a();
        PointF a3 = hVar2.a();
        a(com.ksad.lottie.d.e.a(a2.x, a3.x, f2), com.ksad.lottie.d.e.a(a2.y, a3.y, f2));
        for (int size = this.f32074a.size() - 1; size >= 0; size--) {
            com.ksad.lottie.model.a aVar = hVar.c().get(size);
            com.ksad.lottie.model.a aVar2 = hVar2.c().get(size);
            PointF a4 = aVar.a();
            PointF b2 = aVar.b();
            PointF c2 = aVar.c();
            PointF a5 = aVar2.a();
            PointF b3 = aVar2.b();
            PointF c3 = aVar2.c();
            this.f32074a.get(size).a(com.ksad.lottie.d.e.a(a4.x, a5.x, f2), com.ksad.lottie.d.e.a(a4.y, a5.y, f2));
            this.f32074a.get(size).b(com.ksad.lottie.d.e.a(b2.x, b3.x, f2), com.ksad.lottie.d.e.a(b2.y, b3.y, f2));
            this.f32074a.get(size).c(com.ksad.lottie.d.e.a(c2.x, c3.x, f2), com.ksad.lottie.d.e.a(c2.y, c3.y, f2));
        }
    }

    public boolean b() {
        return this.f32076c;
    }

    public List<com.ksad.lottie.model.a> c() {
        return this.f32074a;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f32074a.size() + "closed=" + this.f32076c + '}';
    }
}
