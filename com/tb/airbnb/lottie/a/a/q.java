package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes20.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a pAO;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> pAS;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> pAY;

    public q(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.eBy().toPaintCap(), shapeStroke.eBz().toPaintJoin(), shapeStroke.jZ(), shapeStroke.eBo(), shapeStroke.eBx(), shapeStroke.jX(), shapeStroke.eBA());
        this.pAO = aVar;
        this.name = shapeStroke.getName();
        this.pAY = shapeStroke.eBO().eBi();
        this.pAY.b(this);
        aVar.a(this.pAY);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.pAY.getValue().intValue());
        if (this.pAS != null) {
            this.paint.setColorFilter(this.pAS.getValue());
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
        if (t == com.tb.airbnb.lottie.k.CO) {
            this.pAY.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Do) {
            if (cVar == null) {
                this.pAS = null;
                return;
            }
            this.pAS = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.pAS.b(this);
            this.pAO.a(this.pAY);
        }
    }
}
