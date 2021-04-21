package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.a.a.n;
import com.ksad.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31913a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f31914b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31915c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31916d;

    public f(String str, m<PointF, PointF> mVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.b bVar) {
        this.f31913a = str;
        this.f31914b = mVar;
        this.f31915c = fVar;
        this.f31916d = bVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String a() {
        return this.f31913a;
    }

    public com.ksad.lottie.model.a.b b() {
        return this.f31916d;
    }

    public com.ksad.lottie.model.a.f c() {
        return this.f31915c;
    }

    public m<PointF, PointF> d() {
        return this.f31914b;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f31914b + ", size=" + this.f31915c + '}';
    }
}
