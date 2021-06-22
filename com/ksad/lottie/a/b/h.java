package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class h extends com.ksad.lottie.e.a<PointF> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Path f31924h;

    public h(com.ksad.lottie.d dVar, com.ksad.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.f32011a, aVar.f32012b, aVar.f32013c, aVar.f32014d, aVar.f32015e);
        T t;
        T t2 = this.f32012b;
        boolean z = (t2 == 0 || (t = this.f32011a) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f32012b;
        if (t3 == 0 || z) {
            return;
        }
        this.f31924h = com.ksad.lottie.d.f.a((PointF) this.f32011a, (PointF) t3, aVar.f32016f, aVar.f32017g);
    }

    @Nullable
    public Path a() {
        return this.f31924h;
    }
}
