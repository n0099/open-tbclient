package com.ksad.lottie.model.content;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f5394a;
    private final List<b> b;

    public j(String str, List<b> list) {
        this.f5394a = str;
        this.b = list;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.c(fVar, aVar, this);
    }

    public String a() {
        return this.f5394a;
    }

    public List<b> b() {
        return this.b;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f5394a + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
    }
}
