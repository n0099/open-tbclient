package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes7.dex */
public class l extends a<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path DI;
    private final com.tb.airbnb.lottie.model.content.h oiI;

    public l(List<com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.oiI = new com.tb.airbnb.lottie.model.content.h();
        this.DI = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h> aVar, float f) {
        this.oiI.a(aVar.GX, aVar.GY, f);
        com.tb.airbnb.lottie.d.e.a(this.oiI, this.DI);
        return this.DI;
    }
}
