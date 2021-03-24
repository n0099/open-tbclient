package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class h extends com.ksad.lottie.e.a<PointF> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Path f31297h;

    public h(com.ksad.lottie.d dVar, com.ksad.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.f31382a, aVar.f31383b, aVar.f31384c, aVar.f31385d, aVar.f31386e);
        T t;
        T t2 = this.f31383b;
        boolean z = (t2 == 0 || (t = this.f31382a) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f31383b;
        if (t3 == 0 || z) {
            return;
        }
        this.f31297h = com.ksad.lottie.d.f.a((PointF) this.f31382a, (PointF) t3, aVar.f31387f, aVar.f31388g);
    }

    @Nullable
    public Path a() {
        return this.f31297h;
    }
}
