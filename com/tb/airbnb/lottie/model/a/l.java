package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes7.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final d ojA;
    @Nullable
    private final b ojB;
    @Nullable
    private final b ojC;
    private final e ojw;
    private final m<PointF, PointF> ojx;
    private final g ojy;
    private final b ojz;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.ojw = eVar;
        this.ojx = mVar;
        this.ojy = gVar;
        this.ojz = bVar;
        this.ojA = dVar;
        this.ojB = bVar2;
        this.ojC = bVar3;
    }

    public e edq() {
        return this.ojw;
    }

    public m<PointF, PointF> edr() {
        return this.ojx;
    }

    public g eds() {
        return this.ojy;
    }

    public b edt() {
        return this.ojz;
    }

    public d edu() {
        return this.ojA;
    }

    @Nullable
    public b edv() {
        return this.ojB;
    }

    @Nullable
    public b edw() {
        return this.ojC;
    }

    public o edx() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
