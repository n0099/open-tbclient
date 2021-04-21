package com.ksad.lottie.model.content;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31929a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f31930b;

    public j(String str, List<b> list) {
        this.f31929a = str;
        this.f31930b = list;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.c(fVar, aVar, this);
    }

    public String a() {
        return this.f31929a;
    }

    public List<b> b() {
        return this.f31930b;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f31929a + "' Shapes: " + Arrays.toString(this.f31930b.toArray()) + '}';
    }
}
