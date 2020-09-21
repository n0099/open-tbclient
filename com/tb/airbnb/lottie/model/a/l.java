package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes17.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e otg;
    private final m<PointF, PointF> oth;
    private final g oti;
    private final b otj;
    private final d otk;
    @Nullable
    private final b otl;
    @Nullable
    private final b otm;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.otg = eVar;
        this.oth = mVar;
        this.oti = gVar;
        this.otj = bVar;
        this.otk = dVar;
        this.otl = bVar2;
        this.otm = bVar3;
    }

    public e ehn() {
        return this.otg;
    }

    public m<PointF, PointF> eho() {
        return this.oth;
    }

    public g ehp() {
        return this.oti;
    }

    public b ehq() {
        return this.otj;
    }

    public d ehr() {
        return this.otk;
    }

    @Nullable
    public b ehs() {
        return this.otl;
    }

    @Nullable
    public b eht() {
        return this.otm;
    }

    public o ehu() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
