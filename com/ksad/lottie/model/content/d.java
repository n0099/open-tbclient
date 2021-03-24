package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final GradientType f31512a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f31513b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.c f31514c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31515d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31516e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31517f;

    /* renamed from: g  reason: collision with root package name */
    public final String f31518g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31519h;
    @Nullable
    public final com.ksad.lottie.model.a.b i;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2) {
        this.f31512a = gradientType;
        this.f31513b = fillType;
        this.f31514c = cVar;
        this.f31515d = dVar;
        this.f31516e = fVar;
        this.f31517f = fVar2;
        this.f31518g = str;
        this.f31519h = bVar;
        this.i = bVar2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.g(fVar, aVar, this);
    }

    public String a() {
        return this.f31518g;
    }

    public GradientType b() {
        return this.f31512a;
    }

    public Path.FillType c() {
        return this.f31513b;
    }

    public com.ksad.lottie.model.a.c d() {
        return this.f31514c;
    }

    public com.ksad.lottie.model.a.d e() {
        return this.f31515d;
    }

    public com.ksad.lottie.model.a.f f() {
        return this.f31516e;
    }

    public com.ksad.lottie.model.a.f g() {
        return this.f31517f;
    }
}
