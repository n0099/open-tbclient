package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final GradientType f31802a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f31803b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.c f31804c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31805d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31806e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31807f;

    /* renamed from: g  reason: collision with root package name */
    public final String f31808g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31809h;
    @Nullable
    public final com.ksad.lottie.model.a.b i;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2) {
        this.f31802a = gradientType;
        this.f31803b = fillType;
        this.f31804c = cVar;
        this.f31805d = dVar;
        this.f31806e = fVar;
        this.f31807f = fVar2;
        this.f31808g = str;
        this.f31809h = bVar;
        this.i = bVar2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.g(fVar, aVar, this);
    }

    public String a() {
        return this.f31808g;
    }

    public GradientType b() {
        return this.f31802a;
    }

    public Path.FillType c() {
        return this.f31803b;
    }

    public com.ksad.lottie.model.a.c d() {
        return this.f31804c;
    }

    public com.ksad.lottie.model.a.d e() {
        return this.f31805d;
    }

    public com.ksad.lottie.model.a.f f() {
        return this.f31806e;
    }

    public com.ksad.lottie.model.a.f g() {
        return this.f31807f;
    }
}
