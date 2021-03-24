package com.ksad.lottie.model.content;

import com.ksad.lottie.a.a.p;
/* loaded from: classes6.dex */
public class k implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31546a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31547b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.h f31548c;

    public k(String str, int i, com.ksad.lottie.model.a.h hVar) {
        this.f31546a = str;
        this.f31547b = i;
        this.f31548c = hVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new p(fVar, aVar, this);
    }

    public String a() {
        return this.f31546a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.f31548c;
    }

    public String toString() {
        return "ShapePath{name=" + this.f31546a + ", index=" + this.f31547b + '}';
    }
}
