package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a njC;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> njG;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> njM;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.dJm().toPaintCap(), shapeStroke.dJn().toPaintJoin(), shapeStroke.ih(), shapeStroke.dJc(), shapeStroke.dJl(), shapeStroke.m49if(), shapeStroke.dJo());
        this.njC = aVar;
        this.name = shapeStroke.getName();
        this.njM = shapeStroke.dJC().dIW();
        this.njM.b(this);
        aVar.a(this.njM);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.njM.getValue().intValue());
        if (this.njG != null) {
            this.paint.setColorFilter(this.njG.getValue());
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
        if (t == com.tb.airbnb.lottie.j.Aw) {
            this.njM.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AV) {
            if (cVar == null) {
                this.njG = null;
                return;
            }
            this.njG = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.njG.b(this);
            this.njC.a(this.njM);
        }
    }
}
