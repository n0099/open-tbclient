package com.ksad.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes6.dex */
public class l extends a<com.ksad.lottie.model.content.h, Path> {

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.content.h f31688c;

    /* renamed from: d  reason: collision with root package name */
    public final Path f31689d;

    public l(List<com.ksad.lottie.e.a<com.ksad.lottie.model.content.h>> list) {
        super(list);
        this.f31688c = new com.ksad.lottie.model.content.h();
        this.f31689d = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public Path a(com.ksad.lottie.e.a<com.ksad.lottie.model.content.h> aVar, float f2) {
        this.f31688c.a(aVar.f31767a, aVar.f31768b, f2);
        com.ksad.lottie.d.e.a(this.f31688c, this.f31689d);
        return this.f31689d;
    }
}
