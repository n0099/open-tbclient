package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class h extends com.ksad.lottie.e.a<PointF> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Path f31682h;

    public h(com.ksad.lottie.d dVar, com.ksad.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.f31767a, aVar.f31768b, aVar.f31769c, aVar.f31770d, aVar.f31771e);
        T t;
        T t2 = this.f31768b;
        boolean z = (t2 == 0 || (t = this.f31767a) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f31768b;
        if (t3 == 0 || z) {
            return;
        }
        this.f31682h = com.ksad.lottie.d.f.a((PointF) this.f31767a, (PointF) t3, aVar.f31772f, aVar.f31773g);
    }

    @Nullable
    public Path a() {
        return this.f31682h;
    }
}
