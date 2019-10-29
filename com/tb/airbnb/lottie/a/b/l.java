package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes6.dex */
public class l extends a<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path fF;
    private final com.tb.airbnb.lottie.model.content.h ktB;

    public l(List<com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.ktB = new com.tb.airbnb.lottie.model.content.h();
        this.fF = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.content.h> aVar, float f) {
        this.ktB.a(aVar.ej, aVar.ek, f);
        com.tb.airbnb.lottie.c.e.a(this.ktB, this.fF);
        return this.fF;
    }
}
