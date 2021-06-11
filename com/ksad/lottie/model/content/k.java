package com.ksad.lottie.model.content;

import com.ksad.lottie.a.a.p;
/* loaded from: classes6.dex */
public class k implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f32084a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32085b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.h f32086c;

    public k(String str, int i2, com.ksad.lottie.model.a.h hVar) {
        this.f32084a = str;
        this.f32085b = i2;
        this.f32086c = hVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new p(fVar, aVar, this);
    }

    public String a() {
        return this.f32084a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.f32086c;
    }

    public String toString() {
        return "ShapePath{name=" + this.f32084a + ", index=" + this.f32085b + '}';
    }
}
