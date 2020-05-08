package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes6.dex */
public class l extends a<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path Cu;
    private final com.tb.airbnb.lottie.model.content.h mOX;

    public l(List<com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.mOX = new com.tb.airbnb.lottie.model.content.h();
        this.Cu = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h> aVar, float f) {
        this.mOX.a(aVar.FO, aVar.FP, f);
        com.tb.airbnb.lottie.d.e.a(this.mOX, this.Cu);
        return this.Cu;
    }
}
