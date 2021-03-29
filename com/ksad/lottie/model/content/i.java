package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f31540a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f31541b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31542c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.a f31543d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f31544e;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.ksad.lottie.model.a.a aVar, @Nullable com.ksad.lottie.model.a.d dVar) {
        this.f31542c = str;
        this.f31540a = z;
        this.f31541b = fillType;
        this.f31543d = aVar;
        this.f31544e = dVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new com.ksad.lottie.a.a.f(fVar, aVar, this);
    }

    public String a() {
        return this.f31542c;
    }

    @Nullable
    public com.ksad.lottie.model.a.a b() {
        return this.f31543d;
    }

    @Nullable
    public com.ksad.lottie.model.a.d c() {
        return this.f31544e;
    }

    public Path.FillType d() {
        return this.f31541b;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f31540a + '}';
    }
}
