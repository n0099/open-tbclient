package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes17.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a pJK;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> pJO;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> pJU;

    public q(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.ezc().toPaintCap(), shapeStroke.ezd().toPaintJoin(), shapeStroke.jZ(), shapeStroke.eyS(), shapeStroke.ezb(), shapeStroke.jX(), shapeStroke.eze());
        this.pJK = aVar;
        this.name = shapeStroke.getName();
        this.pJU = shapeStroke.ezs().eyM();
        this.pJU.b(this);
        aVar.a(this.pJU);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.pJU.getValue().intValue());
        if (this.pJO != null) {
            this.paint.setColorFilter(this.pJO.getValue());
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
        if (t == com.tb.airbnb.lottie.k.BW) {
            this.pJU.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Cs) {
            if (cVar == null) {
                this.pJO = null;
                return;
            }
            this.pJO = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.pJO.b(this);
            this.pJK.a(this.pJU);
        }
    }
}
