package com.ksad.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes6.dex */
public class l extends a<com.ksad.lottie.model.content.h, Path> {

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.content.h f31304c;

    /* renamed from: d  reason: collision with root package name */
    public final Path f31305d;

    public l(List<com.ksad.lottie.e.a<com.ksad.lottie.model.content.h>> list) {
        super(list);
        this.f31304c = new com.ksad.lottie.model.content.h();
        this.f31305d = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public Path a(com.ksad.lottie.e.a<com.ksad.lottie.model.content.h> aVar, float f2) {
        this.f31304c.a(aVar.f31383a, aVar.f31384b, f2);
        com.ksad.lottie.d.e.a(this.f31304c, this.f31305d);
        return this.f31305d;
    }
}
