package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import java.util.List;
/* loaded from: classes5.dex */
public class l extends a<com.tb.airbnb.lottie.model.content.h, Path> {
    private final Path Dc;
    private final com.tb.airbnb.lottie.model.content.h nOM;

    public l(List<com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.nOM = new com.tb.airbnb.lottie.model.content.h();
        this.Dc = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: g */
    public Path a(com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.h> aVar, float f) {
        this.nOM.a(aVar.Gp, aVar.Gq, f);
        com.tb.airbnb.lottie.d.e.a(this.nOM, this.Dc);
        return this.Dc;
    }
}
