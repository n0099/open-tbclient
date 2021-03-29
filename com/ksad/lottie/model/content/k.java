package com.ksad.lottie.model.content;

import com.ksad.lottie.a.a.p;
/* loaded from: classes6.dex */
public class k implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31547a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31548b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.h f31549c;

    public k(String str, int i, com.ksad.lottie.model.a.h hVar) {
        this.f31547a = str;
        this.f31548b = i;
        this.f31549c = hVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new p(fVar, aVar, this);
    }

    public String a() {
        return this.f31547a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.f31549c;
    }

    public String toString() {
        return "ShapePath{name=" + this.f31547a + ", index=" + this.f31548b + '}';
    }
}
