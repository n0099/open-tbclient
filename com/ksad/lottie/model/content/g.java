package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
import com.ksad.lottie.a.a.o;
import com.ksad.lottie.model.a.l;
/* loaded from: classes3.dex */
public class g implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f8077a;

    /* renamed from: b  reason: collision with root package name */
    private final com.ksad.lottie.model.a.b f8078b;
    private final com.ksad.lottie.model.a.b c;
    private final l d;

    public g(String str, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2, l lVar) {
        this.f8077a = str;
        this.f8078b = bVar;
        this.c = bVar2;
        this.d = lVar;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }

    public String a() {
        return this.f8077a;
    }

    public com.ksad.lottie.model.a.b b() {
        return this.f8078b;
    }

    public com.ksad.lottie.model.a.b c() {
        return this.c;
    }

    public l d() {
        return this.d;
    }
}
