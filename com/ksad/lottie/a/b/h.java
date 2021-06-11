package com.ksad.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class h extends com.ksad.lottie.e.a<PointF> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Path f31826h;

    public h(com.ksad.lottie.d dVar, com.ksad.lottie.e.a<PointF> aVar) {
        super(dVar, aVar.f31913a, aVar.f31914b, aVar.f31915c, aVar.f31916d, aVar.f31917e);
        T t;
        T t2 = this.f31914b;
        boolean z = (t2 == 0 || (t = this.f31913a) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f31914b;
        if (t3 == 0 || z) {
            return;
        }
        this.f31826h = com.ksad.lottie.d.f.a((PointF) this.f31913a, (PointF) t3, aVar.f31918f, aVar.f31919g);
    }

    @Nullable
    public Path a() {
        return this.f31826h;
    }
}
