package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class h extends com.tb.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.tb.airbnb.lottie.d dVar, com.tb.airbnb.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.FL, aVar.FM, aVar.FN, aVar.zN, aVar.FO);
        boolean z = (this.FM == 0 || this.FL == 0 || !((PointF) this.FL).equals(((PointF) this.FM).x, ((PointF) this.FM).y)) ? false : true;
        if (this.FM != 0 && !z) {
            this.path = com.tb.airbnb.lottie.d.f.a((PointF) this.FL, (PointF) this.FM, aVar.FR, aVar.FT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path hd() {
        return this.path;
    }
}
