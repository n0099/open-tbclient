package com.tb.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class h extends com.tb.airbnb.lottie.e.a<PointF> {
    @Nullable
    private Path path;

    public h(com.tb.airbnb.lottie.d dVar, com.tb.airbnb.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.kp, aVar.kq, aVar.kr, aVar.ec, aVar.ks);
        boolean z = (this.kq == 0 || this.kp == 0 || !((PointF) this.kp).equals(((PointF) this.kq).x, ((PointF) this.kq).y)) ? false : true;
        if (this.kq != 0 && !z) {
            this.path = com.tb.airbnb.lottie.d.f.a((PointF) this.kp, (PointF) this.kq, aVar.kv, aVar.kx);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path bG() {
        return this.path;
    }
}
