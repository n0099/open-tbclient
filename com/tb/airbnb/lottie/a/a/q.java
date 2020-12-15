package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes20.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a pAQ;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> pAU;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> pBa;

    public q(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.eBz().toPaintCap(), shapeStroke.eBA().toPaintJoin(), shapeStroke.jZ(), shapeStroke.eBp(), shapeStroke.eBy(), shapeStroke.jX(), shapeStroke.eBB());
        this.pAQ = aVar;
        this.name = shapeStroke.getName();
        this.pBa = shapeStroke.eBP().eBj();
        this.pBa.b(this);
        aVar.a(this.pBa);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.pBa.getValue().intValue());
        if (this.pAU != null) {
            this.paint.setColorFilter(this.pAU.getValue());
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
            this.pBa.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Do) {
            if (cVar == null) {
                this.pAU = null;
                return;
            }
            this.pAU = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.pAU.b(this);
            this.pAQ.a(this.pBa);
        }
    }
}
