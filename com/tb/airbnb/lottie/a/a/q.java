package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes16.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> oHA;
    private final com.tb.airbnb.lottie.model.layer.a oHq;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> oHu;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.elm().toPaintCap(), shapeStroke.eln().toPaintJoin(), shapeStroke.jZ(), shapeStroke.elc(), shapeStroke.ell(), shapeStroke.jX(), shapeStroke.elo());
        this.oHq = aVar;
        this.name = shapeStroke.getName();
        this.oHA = shapeStroke.elC().ekW();
        this.oHA.b(this);
        aVar.a(this.oHA);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.oHA.getValue().intValue());
        if (this.oHu != null) {
            this.paint.setColorFilter(this.oHu.getValue());
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
        if (t == com.tb.airbnb.lottie.j.BW) {
            this.oHA.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cs) {
            if (cVar == null) {
                this.oHu = null;
                return;
            }
            this.oHu = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.oHu.b(this);
            this.oHq.a(this.oHA);
        }
    }
}
