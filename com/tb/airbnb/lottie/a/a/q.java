package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes5.dex */
public class q extends a {
    private final com.tb.airbnb.lottie.model.layer.a nOc;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> nOg;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> nOm;
    private final String name;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.dRs().toPaintCap(), shapeStroke.dRt().toPaintJoin(), shapeStroke.iy(), shapeStroke.dRi(), shapeStroke.dRr(), shapeStroke.iw(), shapeStroke.dRu());
        this.nOc = aVar;
        this.name = shapeStroke.getName();
        this.nOm = shapeStroke.dRI().dRc();
        this.nOm.b(this);
        aVar.a(this.nOm);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.nOm.getValue().intValue());
        if (this.nOg != null) {
            this.paint.setColorFilter(this.nOg.getValue());
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
        if (t == com.tb.airbnb.lottie.j.Bb) {
            this.nOm.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bx) {
            if (cVar == null) {
                this.nOg = null;
                return;
            }
            this.nOg = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.nOg.b(this);
            this.nOc.a(this.nOm);
        }
    }
}
