package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes16.dex */
public class l extends a<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path Eb;
    private final com.tb.airbnb.lottie.model.content.h pIR;

    public l(List<com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.pIR = new com.tb.airbnb.lottie.model.content.h();
        this.Eb = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h> aVar, float f) {
        this.pIR.a(aVar.Hn, aVar.Ho, f);
        com.tb.airbnb.lottie.d.e.a(this.pIR, this.Eb);
        return this.Eb;
    }
}
