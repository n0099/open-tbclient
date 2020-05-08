package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class h extends com.tb.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.tb.airbnb.lottie.d dVar, com.tb.airbnb.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.FO, aVar.FP, aVar.FQ, aVar.zN, aVar.FR);
        boolean z = (this.FP == 0 || this.FO == 0 || !((PointF) this.FO).equals(((PointF) this.FP).x, ((PointF) this.FP).y)) ? false : true;
        if (this.FP != 0 && !z) {
            this.path = com.tb.airbnb.lottie.d.f.a((PointF) this.FO, (PointF) this.FP, aVar.FV, aVar.FW);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path hd() {
        return this.path;
    }
}
