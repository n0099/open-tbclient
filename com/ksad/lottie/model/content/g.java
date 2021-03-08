package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
import com.ksad.lottie.a.a.o;
import com.ksad.lottie.model.a.l;
/* loaded from: classes3.dex */
public class g implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f5391a;
    private final com.ksad.lottie.model.a.b b;
    private final com.ksad.lottie.model.a.b c;
    private final l d;

    public g(String str, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2, l lVar) {
        this.f5391a = str;
        this.b = bVar;
        this.c = bVar2;
        this.d = lVar;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }

    public String a() {
        return this.f5391a;
    }

    public com.ksad.lottie.model.a.b b() {
        return this.b;
    }

    public com.ksad.lottie.model.a.b c() {
        return this.c;
    }

    public l d() {
        return this.d;
    }
}
