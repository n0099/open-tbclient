package com.ksad.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final PointF f32079a;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f32080b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f32081c;

    public a() {
        this.f32079a = new PointF();
        this.f32080b = new PointF();
        this.f32081c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f32079a = pointF;
        this.f32080b = pointF2;
        this.f32081c = pointF3;
    }

    public PointF a() {
        return this.f32079a;
    }

    public void a(float f2, float f3) {
        this.f32079a.set(f2, f3);
    }

    public PointF b() {
        return this.f32080b;
    }

    public void b(float f2, float f3) {
        this.f32080b.set(f2, f3);
    }

    public PointF c() {
        return this.f32081c;
    }

    public void c(float f2, float f3) {
        this.f32081c.set(f2, f3);
    }
}
