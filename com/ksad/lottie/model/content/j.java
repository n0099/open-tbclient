package com.ksad.lottie.model.content;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8381a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f8382b;

    public j(String str, List<b> list) {
        this.f8381a = str;
        this.f8382b = list;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.c(fVar, aVar, this);
    }

    public String a() {
        return this.f8381a;
    }

    public List<b> b() {
        return this.f8382b;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f8381a + "' Shapes: " + Arrays.toString(this.f8382b.toArray()) + '}';
    }
}
