package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes17.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a osa;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> ose;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> osk;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.ehB().toPaintCap(), shapeStroke.ehC().toPaintJoin(), shapeStroke.jY(), shapeStroke.ehr(), shapeStroke.ehA(), shapeStroke.jW(), shapeStroke.ehD());
        this.osa = aVar;
        this.name = shapeStroke.getName();
        this.osk = shapeStroke.ehR().ehl();
        this.osk.b(this);
        aVar.a(this.osk);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.osk.getValue().intValue());
        if (this.ose != null) {
            this.paint.setColorFilter(this.ose.getValue());
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
            this.osk.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cb) {
            if (cVar == null) {
                this.ose = null;
                return;
            }
            this.ose = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.ose.b(this);
            this.osa.a(this.osk);
        }
    }
}
