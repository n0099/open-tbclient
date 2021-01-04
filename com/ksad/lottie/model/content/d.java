package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private final GradientType f8368a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f8369b;
    private final com.ksad.lottie.model.a.c c;
    private final com.ksad.lottie.model.a.d d;
    private final com.ksad.lottie.model.a.f e;
    private final com.ksad.lottie.model.a.f f;
    private final String g;
    @Nullable
    private final com.ksad.lottie.model.a.b h;
    @Nullable
    private final com.ksad.lottie.model.a.b i;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2) {
        this.f8368a = gradientType;
        this.f8369b = fillType;
        this.c = cVar;
        this.d = dVar;
        this.e = fVar;
        this.f = fVar2;
        this.g = str;
        this.h = bVar;
        this.i = bVar2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.g(fVar, aVar, this);
    }

    public String a() {
        return this.g;
    }

    public GradientType b() {
        return this.f8368a;
    }

    public Path.FillType c() {
        return this.f8369b;
    }

    public com.ksad.lottie.model.a.c d() {
        return this.c;
    }

    public com.ksad.lottie.model.a.d e() {
        return this.d;
    }

    public com.ksad.lottie.model.a.f f() {
        return this.e;
    }

    public com.ksad.lottie.model.a.f g() {
        return this.f;
    }
}
