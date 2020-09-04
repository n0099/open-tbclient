package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes7.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> oiA;
    private final com.tb.airbnb.lottie.model.layer.a oiq;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> oiu;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.edE().toPaintCap(), shapeStroke.edF().toPaintJoin(), shapeStroke.jX(), shapeStroke.edu(), shapeStroke.edD(), shapeStroke.jV(), shapeStroke.edG());
        this.oiq = aVar;
        this.name = shapeStroke.getName();
        this.oiA = shapeStroke.edU().edo();
        this.oiA.b(this);
        aVar.a(this.oiA);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.oiA.getValue().intValue());
        if (this.oiu != null) {
            this.paint.setColorFilter(this.oiu.getValue());
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
        if (t == com.tb.airbnb.lottie.j.BF) {
            this.oiA.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cb) {
            if (cVar == null) {
                this.oiu = null;
                return;
            }
            this.oiu = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.oiu.b(this);
            this.oiq.a(this.oiA);
        }
    }
}
