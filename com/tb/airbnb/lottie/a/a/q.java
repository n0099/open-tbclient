package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> nFE;
    private final com.tb.airbnb.lottie.model.layer.a nFu;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> nFy;
    private final String name;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.dNW().toPaintCap(), shapeStroke.dNX().toPaintJoin(), shapeStroke.iy(), shapeStroke.dNM(), shapeStroke.dNV(), shapeStroke.iw(), shapeStroke.dNY());
        this.nFu = aVar;
        this.name = shapeStroke.getName();
        this.nFE = shapeStroke.dOm().dNG();
        this.nFE.b(this);
        aVar.a(this.nFE);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.nFE.getValue().intValue());
        if (this.nFy != null) {
            this.paint.setColorFilter(this.nFy.getValue());
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
            this.nFE.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bv) {
            if (cVar == null) {
                this.nFy = null;
                return;
            }
            this.nFy = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.nFy.b(this);
            this.nFu.a(this.nFE);
        }
    }
}
