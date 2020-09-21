package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
/* loaded from: classes17.dex */
public class h extends com.tb.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.tb.airbnb.lottie.d dVar, com.tb.airbnb.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.GX, aVar.GY, aVar.GZ, aVar.AX, aVar.Ha);
        boolean z = (this.GY == 0 || this.GX == 0 || !((PointF) this.GX).equals(((PointF) this.GY).x, ((PointF) this.GY).y)) ? false : true;
        if (this.GY != 0 && !z) {
            this.path = com.tb.airbnb.lottie.d.f.a((PointF) this.GX, (PointF) this.GY, aVar.Hd, aVar.He);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path iV() {
        return this.path;
    }
}
