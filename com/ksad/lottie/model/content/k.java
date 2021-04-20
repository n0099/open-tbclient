package com.ksad.lottie.model.content;

import com.ksad.lottie.a.a.p;
/* loaded from: classes6.dex */
public class k implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31836a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31837b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.h f31838c;

    public k(String str, int i, com.ksad.lottie.model.a.h hVar) {
        this.f31836a = str;
        this.f31837b = i;
        this.f31838c = hVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new p(fVar, aVar, this);
    }

    public String a() {
        return this.f31836a;
    }

    public com.ksad.lottie.model.a.h b() {
        return this.f31838c;
    }

    public String toString() {
        return "ShapePath{name=" + this.f31836a + ", index=" + this.f31837b + '}';
    }
}
