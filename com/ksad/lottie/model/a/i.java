package com.ksad.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes5.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final b f8342a;

    /* renamed from: b  reason: collision with root package name */
    private final b f8343b;

    public i(b bVar, b bVar2) {
        this.f8342a = bVar;
        this.f8343b = bVar2;
    }

    @Override // com.ksad.lottie.model.a.m
    public com.ksad.lottie.a.b.a<PointF, PointF> a() {
        return new com.ksad.lottie.a.b.m(this.f8342a.a(), this.f8343b.a());
    }
}
