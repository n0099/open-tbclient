package com.ksad.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes3.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final b f8044a;

    /* renamed from: b  reason: collision with root package name */
    private final b f8045b;

    public i(b bVar, b bVar2) {
        this.f8044a = bVar;
        this.f8045b = bVar2;
    }

    @Override // com.ksad.lottie.model.a.m
    public com.ksad.lottie.a.b.a<PointF, PointF> a() {
        return new com.ksad.lottie.a.b.m(this.f8044a.a(), this.f8045b.a());
    }
}
