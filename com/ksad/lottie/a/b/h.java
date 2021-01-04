package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class h extends com.ksad.lottie.e.a<PointF> {
    @Nullable
    private Path h;

    public h(com.ksad.lottie.d dVar, com.ksad.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.f8300a, aVar.f8301b, aVar.c, aVar.d, aVar.e);
        boolean z = (this.f8301b == 0 || this.f8300a == 0 || !((PointF) this.f8300a).equals(((PointF) this.f8301b).x, ((PointF) this.f8301b).y)) ? false : true;
        if (this.f8301b == 0 || z) {
            return;
        }
        this.h = com.ksad.lottie.d.f.a((PointF) this.f8300a, (PointF) this.f8301b, aVar.f, aVar.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path a() {
        return this.h;
    }
}
