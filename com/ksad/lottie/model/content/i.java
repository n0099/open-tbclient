package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f32175a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f32176b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32177c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.a f32178d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f32179e;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.ksad.lottie.model.a.a aVar, @Nullable com.ksad.lottie.model.a.d dVar) {
        this.f32177c = str;
        this.f32175a = z;
        this.f32176b = fillType;
        this.f32178d = aVar;
        this.f32179e = dVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.f(fVar, aVar, this);
    }

    public String a() {
        return this.f32177c;
    }

    @Nullable
    public com.ksad.lottie.model.a.a b() {
        return this.f32178d;
    }

    @Nullable
    public com.ksad.lottie.model.a.d c() {
        return this.f32179e;
    }

    public Path.FillType d() {
        return this.f32176b;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f32175a + '}';
    }
}
