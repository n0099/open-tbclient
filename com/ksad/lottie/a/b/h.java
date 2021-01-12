package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class h extends com.ksad.lottie.e.a<PointF> {
    @Nullable
    private Path h;

    public h(com.ksad.lottie.d dVar, com.ksad.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.f8001a, aVar.f8002b, aVar.c, aVar.d, aVar.e);
        boolean z = (this.f8002b == 0 || this.f8001a == 0 || !((PointF) this.f8001a).equals(((PointF) this.f8002b).x, ((PointF) this.f8002b).y)) ? false : true;
        if (this.f8002b == 0 || z) {
            return;
        }
        this.h = com.ksad.lottie.d.f.a((PointF) this.f8001a, (PointF) this.f8002b, aVar.f, aVar.g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Path a() {
        return this.h;
    }
}
