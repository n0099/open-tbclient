package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes2.dex */
public class l extends a<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path gP;
    private final com.tb.airbnb.lottie.model.content.h mNy;

    public l(List<com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.mNy = new com.tb.airbnb.lottie.model.content.h();
        this.gP = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.content.h> aVar, float f) {
        this.mNy.a(aVar.kn, aVar.ko, f);
        com.tb.airbnb.lottie.c.e.a(this.mNy, this.gP);
        return this.gP;
    }
}
