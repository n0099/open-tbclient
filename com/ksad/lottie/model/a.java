package com.ksad.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final PointF f31981a;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f31982b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31983c;

    public a() {
        this.f31981a = new PointF();
        this.f31982b = new PointF();
        this.f31983c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f31981a = pointF;
        this.f31982b = pointF2;
        this.f31983c = pointF3;
    }

    public PointF a() {
        return this.f31981a;
    }

    public void a(float f2, float f3) {
        this.f31981a.set(f2, f3);
    }

    public PointF b() {
        return this.f31982b;
    }

    public void b(float f2, float f3) {
        this.f31982b.set(f2, f3);
    }

    public PointF c() {
        return this.f31983c;
    }

    public void c(float f2, float f3) {
        this.f31983c.set(f2, f3);
    }
}
