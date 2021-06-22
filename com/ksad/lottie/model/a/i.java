package com.ksad.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    public final b f32083a;

    /* renamed from: b  reason: collision with root package name */
    public final b f32084b;

    public i(b bVar, b bVar2) {
        this.f32083a = bVar;
        this.f32084b = bVar2;
    }

    @Override // com.ksad.lottie.model.a.m
    public com.ksad.lottie.a.b.a<PointF, PointF> a() {
        return new com.ksad.lottie.a.b.m(this.f32083a.a(), this.f32084b.a());
    }
}
