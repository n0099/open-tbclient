package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f31539a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f31540b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31541c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.a f31542d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31543e;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.ksad.lottie.model.a.a aVar, @Nullable com.ksad.lottie.model.a.d dVar) {
        this.f31541c = str;
        this.f31539a = z;
        this.f31540b = fillType;
        this.f31542d = aVar;
        this.f31543e = dVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.f(fVar, aVar, this);
    }

    public String a() {
        return this.f31541c;
    }

    @Nullable
    public com.ksad.lottie.model.a.a b() {
        return this.f31542d;
    }

    @Nullable
    public com.ksad.lottie.model.a.d c() {
        return this.f31543e;
    }

    public Path.FillType d() {
        return this.f31540b;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f31539a + '}';
    }
}
