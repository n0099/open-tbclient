package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public class h extends com.tb.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.tb.airbnb.lottie.d dVar, com.tb.airbnb.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.Gp, aVar.Gq, aVar.Gr, aVar.Aq, aVar.Gs);
        boolean z = (this.Gq == 0 || this.Gp == 0 || !((PointF) this.Gp).equals(((PointF) this.Gq).x, ((PointF) this.Gq).y)) ? false : true;
        if (this.Gq != 0 && !z) {
            this.path = com.tb.airbnb.lottie.d.f.a((PointF) this.Gp, (PointF) this.Gq, aVar.Gv, aVar.Gw);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path ht() {
        return this.path;
    }
}
