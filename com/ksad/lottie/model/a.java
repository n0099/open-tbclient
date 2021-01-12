package com.ksad.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f8039a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f8040b;
    private final PointF c;

    public a() {
        this.f8039a = new PointF();
        this.f8040b = new PointF();
        this.c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f8039a = pointF;
        this.f8040b = pointF2;
        this.c = pointF3;
    }

    public PointF a() {
        return this.f8039a;
    }

    public void a(float f, float f2) {
        this.f8039a.set(f, f2);
    }

    public PointF b() {
        return this.f8040b;
    }

    public void b(float f, float f2) {
        this.f8040b.set(f, f2);
    }

    public PointF c() {
        return this.c;
    }

    public void c(float f, float f2) {
        this.c.set(f, f2);
    }
}
