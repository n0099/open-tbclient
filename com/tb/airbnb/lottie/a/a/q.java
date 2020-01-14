package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes5.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a noZ;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> npd;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> npj;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.dFW().toPaintCap(), shapeStroke.dFX().toPaintJoin(), shapeStroke.cI(), shapeStroke.dFM(), shapeStroke.dFV(), shapeStroke.cG(), shapeStroke.dFY());
        this.noZ = aVar;
        this.name = shapeStroke.getName();
        this.npj = shapeStroke.dGm().dFG();
        this.npj.b(this);
        aVar.a(this.npj);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.npj.getValue().intValue());
        if (this.npd != null) {
            this.paint.setColorFilter(this.npd.getValue());
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
            this.npj.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fj) {
            if (cVar == null) {
                this.npd = null;
                return;
            }
            this.npd = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.npd.b(this);
            this.noZ.a(this.npj);
        }
    }
}
