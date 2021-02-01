package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.a.a.n;
import com.ksad.lottie.model.a.m;
/* loaded from: classes3.dex */
public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8075a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f8076b;
    private final com.ksad.lottie.model.a.f c;
    private final com.ksad.lottie.model.a.b d;

    public f(String str, m<PointF, PointF> mVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.b bVar) {
        this.f8075a = str;
        this.f8076b = mVar;
        this.c = fVar;
        this.d = bVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String a() {
        return this.f8075a;
    }

    public com.ksad.lottie.model.a.b b() {
        return this.d;
    }

    public com.ksad.lottie.model.a.f c() {
        return this.c;
    }

    public m<PointF, PointF> d() {
        return this.f8076b;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f8076b + ", size=" + this.c + '}';
    }
}
