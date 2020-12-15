package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes20.dex */
public class l extends a<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path ES;
    private final com.tb.airbnb.lottie.model.content.h pBA;

    public l(List<com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.pBA = new com.tb.airbnb.lottie.model.content.h();
        this.ES = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h> aVar, float f) {
        this.pBA.a(aVar.If, aVar.Ig, f);
        com.tb.airbnb.lottie.d.e.a(this.pBA, this.ES);
        return this.ES;
    }
}
