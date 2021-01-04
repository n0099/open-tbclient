package com.ksad.lottie.model.content;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8380a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f8381b;

    public j(String str, List<b> list) {
        this.f8380a = str;
        this.f8381b = list;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.c(fVar, aVar, this);
    }

    public String a() {
        return this.f8380a;
    }

    public List<b> b() {
        return this.f8381b;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f8380a + "' Shapes: " + Arrays.toString(this.f8381b.toArray()) + '}';
    }
}
