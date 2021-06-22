package com.ksad.lottie.model.content;

import android.graphics.PointF;
import com.ksad.lottie.a.a.n;
import com.ksad.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f32164a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f32165b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f32166c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32167d;

    public f(String str, m<PointF, PointF> mVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.b bVar) {
        this.f32164a = str;
        this.f32165b = mVar;
        this.f32166c = fVar;
        this.f32167d = bVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String a() {
        return this.f32164a;
    }

    public com.ksad.lottie.model.a.b b() {
        return this.f32167d;
    }

    public com.ksad.lottie.model.a.f c() {
        return this.f32166c;
    }

    public m<PointF, PointF> d() {
        return this.f32165b;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f32165b + ", size=" + this.f32166c + '}';
    }
}
