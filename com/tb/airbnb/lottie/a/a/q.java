package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a npB;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> npF;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> npL;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.dHd().toPaintCap(), shapeStroke.dHe().toPaintJoin(), shapeStroke.cJ(), shapeStroke.dGT(), shapeStroke.dHc(), shapeStroke.cH(), shapeStroke.dHf());
        this.npB = aVar;
        this.name = shapeStroke.getName();
        this.npL = shapeStroke.dHt().dGN();
        this.npL.b(this);
        aVar.a(this.npL);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.npL.getValue().intValue());
        if (this.npF != null) {
            this.paint.setColorFilter(this.npF.getValue());
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
        if (t == com.tb.airbnb.lottie.j.eO) {
            this.npL.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fq) {
            if (cVar == null) {
                this.npF = null;
                return;
            }
            this.npF = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.npF.b(this);
            this.npB.a(this.npL);
        }
    }
}
