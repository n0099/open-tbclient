package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.model.a.m;
/* loaded from: classes3.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f5386a;
    private final m<PointF, PointF> b;
    private final com.ksad.lottie.model.a.f c;
    private final boolean d;

    public a(String str, m<PointF, PointF> mVar, com.ksad.lottie.model.a.f fVar, boolean z) {
        this.f5386a = str;
        this.b = mVar;
        this.c = fVar;
        this.d = z;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.e(fVar, aVar, this);
    }

    public String a() {
        return this.f5386a;
    }

    public m<PointF, PointF> b() {
        return this.b;
    }

    public com.ksad.lottie.model.a.f c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }
}
