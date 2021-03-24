package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
import com.ksad.lottie.a.a.o;
import com.ksad.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31532a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31533b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31534c;

    /* renamed from: d  reason: collision with root package name */
    public final l f31535d;

    public g(String str, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2, l lVar) {
        this.f31532a = str;
        this.f31533b = bVar;
        this.f31534c = bVar2;
        this.f31535d = lVar;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }

    public String a() {
        return this.f31532a;
    }

    public com.ksad.lottie.model.a.b b() {
        return this.f31533b;
    }

    public com.ksad.lottie.model.a.b c() {
        return this.f31534c;
    }

    public l d() {
        return this.f31535d;
    }
}
