package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
/* loaded from: classes20.dex */
public class h extends com.tb.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.tb.airbnb.lottie.e eVar, com.tb.airbnb.lottie.e.a<PointF> aVar) {
        super(eVar, aVar.If, aVar.Ig, aVar.Ih, aVar.Ce, aVar.Ii);
        boolean z = (this.Ig == 0 || this.If == 0 || !((PointF) this.If).equals(((PointF) this.Ig).x, ((PointF) this.Ig).y)) ? false : true;
        if (this.Ig != 0 && !z) {
            this.path = com.tb.airbnb.lottie.d.f.a((PointF) this.If, (PointF) this.Ig, aVar.Il, aVar.Im);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path iW() {
        return this.path;
    }
}
