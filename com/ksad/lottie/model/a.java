package com.ksad.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final PointF f31833a;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f31834b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31835c;

    public a() {
        this.f31833a = new PointF();
        this.f31834b = new PointF();
        this.f31835c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f31833a = pointF;
        this.f31834b = pointF2;
        this.f31835c = pointF3;
    }

    public PointF a() {
        return this.f31833a;
    }

    public void a(float f2, float f3) {
        this.f31833a.set(f2, f3);
    }

    public PointF b() {
        return this.f31834b;
    }

    public void b(float f2, float f3) {
        this.f31834b.set(f2, f3);
    }

    public PointF c() {
        return this.f31835c;
    }

    public void c(float f2, float f3) {
        this.f31835c.set(f2, f3);
    }
}
