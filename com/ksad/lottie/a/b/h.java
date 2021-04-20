package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class h extends com.ksad.lottie.e.a<PointF> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Path f31587h;

    public h(com.ksad.lottie.d dVar, com.ksad.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.f31672a, aVar.f31673b, aVar.f31674c, aVar.f31675d, aVar.f31676e);
        T t;
        T t2 = this.f31673b;
        boolean z = (t2 == 0 || (t = this.f31672a) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f31673b;
        if (t3 == 0 || z) {
            return;
        }
        this.f31587h = com.ksad.lottie.d.f.a((PointF) this.f31672a, (PointF) t3, aVar.f31677f, aVar.f31678g);
    }

    @Nullable
    public Path a() {
        return this.f31587h;
    }
}
