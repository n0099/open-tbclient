package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final String name;
    private final m<PointF, PointF> nkJ;
    private final com.tb.airbnb.lottie.model.a.f nkP;
    private final com.tb.airbnb.lottie.model.a.b nli;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.nkJ = mVar;
        this.nkP = fVar;
        this.nli = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dJy() {
        return this.nli;
    }

    public com.tb.airbnb.lottie.model.a.f dJg() {
        return this.nkP;
    }

    public m<PointF, PointF> dIZ() {
        return this.nkJ;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.nkJ + ", size=" + this.nkP + '}';
    }
}
