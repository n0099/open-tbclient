package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.o;
/* loaded from: classes7.dex */
public class l implements com.tb.airbnb.lottie.model.content.b {
    private final e oje;
    private final m<PointF, PointF> ojf;
    private final g ojg;
    private final b ojh;
    private final d oji;
    @Nullable
    private final b ojj;
    @Nullable
    private final b ojk;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.oje = eVar;
        this.ojf = mVar;
        this.ojg = gVar;
        this.ojh = bVar;
        this.oji = dVar;
        this.ojj = bVar2;
        this.ojk = bVar3;
    }

    public e edh() {
        return this.oje;
    }

    public m<PointF, PointF> edi() {
        return this.ojf;
    }

    public g edj() {
        return this.ojg;
    }

    public b edk() {
        return this.ojh;
    }

    public d edl() {
        return this.oji;
    }

    @Nullable
    public b edm() {
        return this.ojj;
    }

    @Nullable
    public b edn() {
        return this.ojk;
    }

    public o edo() {
        return new o(this);
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
