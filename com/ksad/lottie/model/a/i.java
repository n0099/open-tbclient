package com.ksad.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes3.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final b f5374a;
    private final b b;

    public i(b bVar, b bVar2) {
        this.f5374a = bVar;
        this.b = bVar2;
    }

    @Override // com.ksad.lottie.model.a.m
    public com.ksad.lottie.a.b.a<PointF, PointF> a() {
        return new com.ksad.lottie.a.b.m(this.f5374a.a(), this.b.a());
    }
}
