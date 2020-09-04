package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes7.dex */
public class l extends a<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path DI;
    private final com.tb.airbnb.lottie.model.content.h oja;

    public l(List<com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.oja = new com.tb.airbnb.lottie.model.content.h();
        this.DI = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h> aVar, float f) {
        this.oja.a(aVar.GX, aVar.GY, f);
        com.tb.airbnb.lottie.d.e.a(this.oja, this.DI);
        return this.DI;
    }
}
