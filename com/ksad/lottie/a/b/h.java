package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class h extends com.ksad.lottie.e.a<PointF> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Path f31298h;

    public h(com.ksad.lottie.d dVar, com.ksad.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.f31383a, aVar.f31384b, aVar.f31385c, aVar.f31386d, aVar.f31387e);
        T t;
        T t2 = this.f31384b;
        boolean z = (t2 == 0 || (t = this.f31383a) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f31384b;
        if (t3 == 0 || z) {
            return;
        }
        this.f31298h = com.ksad.lottie.d.f.a((PointF) this.f31383a, (PointF) t3, aVar.f31388f, aVar.f31389g);
    }

    @Nullable
    public Path a() {
        return this.f31298h;
    }
}
