package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes6.dex */
public class l extends a<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path fd;
    private final com.tb.airbnb.lottie.model.content.h ksK;

    public l(List<com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.ksK = new com.tb.airbnb.lottie.model.content.h();
        this.fd = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.content.h> aVar, float f) {
        this.ksK.a(aVar.dK, aVar.dL, f);
        com.tb.airbnb.lottie.c.e.a(this.ksK, this.fd);
        return this.fd;
    }
}
