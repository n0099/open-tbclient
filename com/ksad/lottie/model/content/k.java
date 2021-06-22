package com.ksad.lottie.model.content;

import com.ksad.lottie.a.a.p;
/* loaded from: classes6.dex */
public class k implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f32182a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32183b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.h f32184c;

    public k(String str, int i2, com.ksad.lottie.model.a.h hVar) {
        this.f32182a = str;
        this.f32183b = i2;
        this.f32184c = hVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new p(fVar, aVar, this);
    }

    public String a() {
        return this.f32182a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.f32184c;
    }

    public String toString() {
        return "ShapePath{name=" + this.f32182a + ", index=" + this.f32183b + '}';
    }
}
