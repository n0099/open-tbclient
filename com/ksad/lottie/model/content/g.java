package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
import com.ksad.lottie.a.a.o;
import com.ksad.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f31917a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31918b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f31919c;

    /* renamed from: d  reason: collision with root package name */
    public final l f31920d;

    public g(String str, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2, l lVar) {
        this.f31917a = str;
        this.f31918b = bVar;
        this.f31919c = bVar2;
        this.f31920d = lVar;
    }

    @Override // com.ksad.lottie.model.content.b
    @Nullable
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }

    public String a() {
        return this.f31917a;
    }

    public com.ksad.lottie.model.a.b b() {
        return this.f31918b;
    }

    public com.ksad.lottie.model.a.b c() {
        return this.f31919c;
    }

    public l d() {
        return this.f31920d;
    }
}
