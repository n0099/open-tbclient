package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes7.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a ohY;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> oic;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> oii;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.edv().toPaintCap(), shapeStroke.edw().toPaintJoin(), shapeStroke.jX(), shapeStroke.edl(), shapeStroke.edu(), shapeStroke.jV(), shapeStroke.edx());
        this.ohY = aVar;
        this.name = shapeStroke.getName();
        this.oii = shapeStroke.edL().edf();
        this.oii.b(this);
        aVar.a(this.oii);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.oii.getValue().intValue());
        if (this.oic != null) {
            this.paint.setColorFilter(this.oic.getValue());
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
            this.oii.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cb) {
            if (cVar == null) {
                this.oic = null;
                return;
            }
            this.oic = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.oic.b(this);
            this.ohY.a(this.oii);
        }
    }
}
