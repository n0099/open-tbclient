package com.ksad.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final PointF f31448a;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f31449b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31450c;

    public a() {
        this.f31448a = new PointF();
        this.f31449b = new PointF();
        this.f31450c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f31448a = pointF;
        this.f31449b = pointF2;
        this.f31450c = pointF3;
    }

    public PointF a() {
        return this.f31448a;
    }

    public void a(float f2, float f3) {
        this.f31448a.set(f2, f3);
    }

    public PointF b() {
        return this.f31449b;
    }

    public void b(float f2, float f3) {
        this.f31449b.set(f2, f3);
    }

    public PointF c() {
        return this.f31450c;
    }

    public void c(float f2, float f3) {
        this.f31450c.set(f2, f3);
    }
}
