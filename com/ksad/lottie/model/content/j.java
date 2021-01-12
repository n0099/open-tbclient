package com.ksad.lottie.model.content;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8081a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f8082b;

    public j(String str, List<b> list) {
        this.f8081a = str;
        this.f8082b = list;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.c(fVar, aVar, this);
    }

    public String a() {
        return this.f8081a;
    }

    public List<b> b() {
        return this.f8082b;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f8081a + "' Shapes: " + Arrays.toString(this.f8082b.toArray()) + '}';
    }
}
