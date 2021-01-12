package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f8079a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f8080b;
    private final String c;
    @Nullable
    private final com.ksad.lottie.model.a.a d;
    @Nullable
    private final com.ksad.lottie.model.a.d e;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.ksad.lottie.model.a.a aVar, @Nullable com.ksad.lottie.model.a.d dVar) {
        this.c = str;
        this.f8079a = z;
        this.f8080b = fillType;
        this.d = aVar;
        this.e = dVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.f(fVar, aVar, this);
    }

    public String a() {
        return this.c;
    }

    @Nullable
    public com.ksad.lottie.model.a.a b() {
        return this.d;
    }

    @Nullable
    public com.ksad.lottie.model.a.d c() {
        return this.e;
    }

    public Path.FillType d() {
        return this.f8080b;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f8079a + '}';
    }
}
