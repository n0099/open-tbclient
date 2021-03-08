package com.ksad.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f5372a;
    private final PointF b;
    private final PointF c;

    public a() {
        this.f5372a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f5372a = pointF;
        this.b = pointF2;
        this.c = pointF3;
    }

    public PointF a() {
        return this.f5372a;
    }

    public void a(float f, float f2) {
        this.f5372a.set(f, f2);
    }

    public PointF b() {
        return this.b;
    }

    public void b(float f, float f2) {
        this.b.set(f, f2);
    }

    public PointF c() {
        return this.c;
    }

    public void c(float f, float f2) {
        this.c.set(f, f2);
    }
}
