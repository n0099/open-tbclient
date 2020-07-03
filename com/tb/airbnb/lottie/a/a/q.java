package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> nFB;
    private final com.tb.airbnb.lottie.model.layer.a nFr;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> nFv;
    private final String name;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.dNS().toPaintCap(), shapeStroke.dNT().toPaintJoin(), shapeStroke.iy(), shapeStroke.dNI(), shapeStroke.dNR(), shapeStroke.iw(), shapeStroke.dNU());
        this.nFr = aVar;
        this.name = shapeStroke.getName();
        this.nFB = shapeStroke.dOi().dNC();
        this.nFB.b(this);
        aVar.a(this.nFB);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.nFB.getValue().intValue());
        if (this.nFv != null) {
            this.paint.setColorFilter(this.nFv.getValue());
        }
        super.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((q) t, (com.tb.airbnb.lottie.e.c<q>) cVar);
        if (t == com.tb.airbnb.lottie.j.AZ) {
            this.nFB.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bv) {
            if (cVar == null) {
                this.nFv = null;
                return;
            }
            this.nFv = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.nFv.b(this);
            this.nFr.a(this.nFB);
        }
    }
}
