package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f31829a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f31830b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31831c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.a f31832d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31833e;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.ksad.lottie.model.a.a aVar, @Nullable com.ksad.lottie.model.a.d dVar) {
        this.f31831c = str;
        this.f31829a = z;
        this.f31830b = fillType;
        this.f31832d = aVar;
        this.f31833e = dVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.f(fVar, aVar, this);
    }

    public String a() {
        return this.f31831c;
    }

    @Nullable
    public com.ksad.lottie.model.a.a b() {
        return this.f31832d;
    }

    @Nullable
    public com.ksad.lottie.model.a.d c() {
        return this.f31833e;
    }

    public Path.FillType d() {
        return this.f31830b;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f31829a + '}';
    }
}
