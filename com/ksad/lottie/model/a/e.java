package com.ksad.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.ksad.lottie.e.a<PointF>> f8340a;

    public e() {
        this.f8340a = Collections.singletonList(new com.ksad.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.ksad.lottie.e.a<PointF>> list) {
        this.f8340a = list;
    }

    @Override // com.ksad.lottie.model.a.m
    public com.ksad.lottie.a.b.a<PointF, PointF> a() {
        return this.f8340a.get(0).d() ? new com.ksad.lottie.a.b.j(this.f8340a) : new com.ksad.lottie.a.b.i(this.f8340a);
    }
}
