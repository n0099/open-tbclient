package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final GradientType f32146a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f32147b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.c f32148c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f32149d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f32150e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f32151f;

    /* renamed from: g  reason: collision with root package name */
    public final String f32152g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32153h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f32154i;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2) {
        this.f32146a = gradientType;
        this.f32147b = fillType;
        this.f32148c = cVar;
        this.f32149d = dVar;
        this.f32150e = fVar;
        this.f32151f = fVar2;
        this.f32152g = str;
        this.f32153h = bVar;
        this.f32154i = bVar2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.g(fVar, aVar, this);
    }

    public String a() {
        return this.f32152g;
    }

    public GradientType b() {
        return this.f32146a;
    }

    public Path.FillType c() {
        return this.f32147b;
    }

    public com.ksad.lottie.model.a.c d() {
        return this.f32148c;
    }

    public com.ksad.lottie.model.a.d e() {
        return this.f32149d;
    }

    public com.ksad.lottie.model.a.f f() {
        return this.f32150e;
    }

    public com.ksad.lottie.model.a.f g() {
        return this.f32151f;
    }
}
