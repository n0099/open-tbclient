package com.ksad.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes5.dex */
public class l extends a<com.ksad.lottie.model.content.h, Path> {
    private final com.ksad.lottie.model.content.h c;
    private final Path d;

    public l(List<com.ksad.lottie.e.a<com.ksad.lottie.model.content.h>> list) {
        super(list);
        this.c = new com.ksad.lottie.model.content.h();
        this.d = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public Path a(com.ksad.lottie.e.a<com.ksad.lottie.model.content.h> aVar, float f) {
        this.c.a(aVar.f8300a, aVar.f8301b, f);
        com.ksad.lottie.d.e.a(this.c, this.d);
        return this.d;
    }
}
