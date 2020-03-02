package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a npD;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> npH;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> npN;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.dHf().toPaintCap(), shapeStroke.dHg().toPaintJoin(), shapeStroke.cJ(), shapeStroke.dGV(), shapeStroke.dHe(), shapeStroke.cH(), shapeStroke.dHh());
        this.npD = aVar;
        this.name = shapeStroke.getName();
        this.npN = shapeStroke.dHv().dGP();
        this.npN.b(this);
        aVar.a(this.npN);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.npN.getValue().intValue());
        if (this.npH != null) {
            this.paint.setColorFilter(this.npH.getValue());
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
            this.npN.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fq) {
            if (cVar == null) {
                this.npH = null;
                return;
            }
            this.npH = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.npH.b(this);
            this.npD.a(this.npN);
        }
    }
}
