package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes5.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a noU;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> noY;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> npe;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.dFU().toPaintCap(), shapeStroke.dFV().toPaintJoin(), shapeStroke.cI(), shapeStroke.dFK(), shapeStroke.dFT(), shapeStroke.cG(), shapeStroke.dFW());
        this.noU = aVar;
        this.name = shapeStroke.getName();
        this.npe = shapeStroke.dGk().dFE();
        this.npe.b(this);
        aVar.a(this.npe);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.npe.getValue().intValue());
        if (this.noY != null) {
            this.paint.setColorFilter(this.noY.getValue());
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
        if (t == com.tb.airbnb.lottie.j.eL) {
            this.npe.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fj) {
            if (cVar == null) {
                this.noY = null;
                return;
            }
            this.noY = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.noY.b(this);
            this.noU.a(this.npe);
        }
    }
}
