package com.ksad.lottie.model.content;

import com.ksad.lottie.a.a.p;
/* loaded from: classes5.dex */
public class k implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8383a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8384b;
    private final com.ksad.lottie.model.a.h c;

    public k(String str, int i, com.ksad.lottie.model.a.h hVar) {
        this.f8383a = str;
        this.f8384b = i;
        this.c = hVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new p(fVar, aVar, this);
    }

    public String a() {
        return this.f8383a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.c;
    }

    public String toString() {
        return "ShapePath{name=" + this.f8383a + ", index=" + this.f8384b + '}';
    }
}
