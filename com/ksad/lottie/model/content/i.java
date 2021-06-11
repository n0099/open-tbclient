package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f32077a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f32078b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32079c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.a f32080d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f32081e;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.ksad.lottie.model.a.a aVar, @Nullable com.ksad.lottie.model.a.d dVar) {
        this.f32079c = str;
        this.f32077a = z;
        this.f32078b = fillType;
        this.f32080d = aVar;
        this.f32081e = dVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.f(fVar, aVar, this);
    }

    public String a() {
        return this.f32079c;
    }

    @Nullable
    public com.ksad.lottie.model.a.a b() {
        return this.f32080d;
    }

    @Nullable
    public com.ksad.lottie.model.a.d c() {
        return this.f32081e;
    }

    public Path.FillType d() {
        return this.f32078b;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f32077a + '}';
    }
}
