package com.ksad.lottie.model.a;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.ksad.lottie.e.a<PointF>> f5373a;

    public e() {
        this.f5373a = Collections.singletonList(new com.ksad.lottie.e.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<com.ksad.lottie.e.a<PointF>> list) {
        this.f5373a = list;
    }

    @Override // com.ksad.lottie.model.a.m
    public com.ksad.lottie.a.b.a<PointF, PointF> a() {
        return this.f5373a.get(0).d() ? new com.ksad.lottie.a.b.j(this.f5373a) : new com.ksad.lottie.a.b.i(this.f5373a);
    }
}
