package com.ksad.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final PointF f31738a;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f31739b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31740c;

    public a() {
        this.f31738a = new PointF();
        this.f31739b = new PointF();
        this.f31740c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f31738a = pointF;
        this.f31739b = pointF2;
        this.f31740c = pointF3;
    }

    public PointF a() {
        return this.f31738a;
    }

    public void a(float f2, float f3) {
        this.f31738a.set(f2, f3);
    }

    public PointF b() {
        return this.f31739b;
    }

    public void b(float f2, float f3) {
        this.f31739b.set(f2, f3);
    }

    public PointF c() {
        return this.f31740c;
    }

    public void c(float f2, float f3) {
        this.f31740c.set(f2, f3);
    }
}
