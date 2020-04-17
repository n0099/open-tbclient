package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes6.dex */
public class l extends a<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path Cu;
    private final com.tb.airbnb.lottie.model.content.h mOU;

    public l(List<com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.mOU = new com.tb.airbnb.lottie.model.content.h();
        this.Cu = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h> aVar, float f) {
        this.mOU.a(aVar.FL, aVar.FM, f);
        com.tb.airbnb.lottie.d.e.a(this.mOU, this.Cu);
        return this.Cu;
    }
}
