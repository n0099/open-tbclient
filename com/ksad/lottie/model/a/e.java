package com.ksad.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.ksad.lottie.e.a<PointF>> f32082a;

    public e() {
        this.f32082a = Collections.singletonList(new com.ksad.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.ksad.lottie.e.a<PointF>> list) {
        this.f32082a = list;
    }

    @Override // com.ksad.lottie.model.a.m
    public com.ksad.lottie.a.b.a<PointF, PointF> a() {
        return this.f32082a.get(0).d() ? new com.ksad.lottie.a.b.j(this.f32082a) : new com.ksad.lottie.a.b.i(this.f32082a);
    }
}
