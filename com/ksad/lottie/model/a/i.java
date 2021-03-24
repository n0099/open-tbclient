package com.ksad.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    public final b f31452a;

    /* renamed from: b  reason: collision with root package name */
    public final b f31453b;

    public i(b bVar, b bVar2) {
        this.f31452a = bVar;
        this.f31453b = bVar2;
    }

    @Override // com.ksad.lottie.model.a.m
    public com.ksad.lottie.a.b.a<PointF, PointF> a() {
        return new com.ksad.lottie.a.b.m(this.f31452a.a(), this.f31453b.a());
    }
}
