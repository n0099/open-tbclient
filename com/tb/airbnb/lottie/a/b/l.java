package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes5.dex */
public class l extends a<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path gP;
    private final com.tb.airbnb.lottie.model.content.h npJ;

    public l(List<com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.npJ = new com.tb.airbnb.lottie.model.content.h();
        this.gP = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h> aVar, float f) {
        this.npJ.a(aVar.km, aVar.kn, f);
        com.tb.airbnb.lottie.d.e.a(this.npJ, this.gP);
        return this.gP;
    }
}
