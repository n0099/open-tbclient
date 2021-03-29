package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final GradientType f31513a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f31514b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.c f31515c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31516d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31517e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f31518f;

    /* renamed from: g  reason: collision with root package name */
    public final String f31519g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31520h;
    @Nullable
    public final com.ksad.lottie.model.a.b i;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2) {
        this.f31513a = gradientType;
        this.f31514b = fillType;
        this.f31515c = cVar;
        this.f31516d = dVar;
        this.f31517e = fVar;
        this.f31518f = fVar2;
        this.f31519g = str;
        this.f31520h = bVar;
        this.i = bVar2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.g(fVar, aVar, this);
    }

    public String a() {
        return this.f31519g;
    }

    public GradientType b() {
        return this.f31513a;
    }

    public Path.FillType c() {
        return this.f31514b;
    }

    public com.ksad.lottie.model.a.c d() {
        return this.f31515c;
    }

    public com.ksad.lottie.model.a.d e() {
        return this.f31516d;
    }

    public com.ksad.lottie.model.a.f f() {
        return this.f31517e;
    }

    public com.ksad.lottie.model.a.f g() {
        return this.f31518f;
    }
}
