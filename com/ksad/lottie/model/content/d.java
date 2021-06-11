package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final GradientType f32048a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f32049b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.c f32050c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f32051d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f32052e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f32053f;

    /* renamed from: g  reason: collision with root package name */
    public final String f32054g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32055h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32056i;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2) {
        this.f32048a = gradientType;
        this.f32049b = fillType;
        this.f32050c = cVar;
        this.f32051d = dVar;
        this.f32052e = fVar;
        this.f32053f = fVar2;
        this.f32054g = str;
        this.f32055h = bVar;
        this.f32056i = bVar2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.g(fVar, aVar, this);
    }

    public String a() {
        return this.f32054g;
    }

    public GradientType b() {
        return this.f32048a;
    }

    public Path.FillType c() {
        return this.f32049b;
    }

    public com.ksad.lottie.model.a.c d() {
        return this.f32050c;
    }

    public com.ksad.lottie.model.a.d e() {
        return this.f32051d;
    }

    public com.ksad.lottie.model.a.f f() {
        return this.f32052e;
    }

    public com.ksad.lottie.model.a.f g() {
        return this.f32053f;
    }
}
