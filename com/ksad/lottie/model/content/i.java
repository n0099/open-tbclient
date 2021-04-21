package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f31924a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f31925b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31926c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.a f31927d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31928e;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.ksad.lottie.model.a.a aVar, @Nullable com.ksad.lottie.model.a.d dVar) {
        this.f31926c = str;
        this.f31924a = z;
        this.f31925b = fillType;
        this.f31927d = aVar;
        this.f31928e = dVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.f(fVar, aVar, this);
    }

    public String a() {
        return this.f31926c;
    }

    @Nullable
    public com.ksad.lottie.model.a.a b() {
        return this.f31927d;
    }

    @Nullable
    public com.ksad.lottie.model.a.d c() {
        return this.f31928e;
    }

    public Path.FillType d() {
        return this.f31925b;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f31924a + '}';
    }
}
