package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a npO;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> npS;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> npY;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.dHg().toPaintCap(), shapeStroke.dHh().toPaintJoin(), shapeStroke.cJ(), shapeStroke.dGW(), shapeStroke.dHf(), shapeStroke.cH(), shapeStroke.dHi());
        this.npO = aVar;
        this.name = shapeStroke.getName();
        this.npY = shapeStroke.dHw().dGQ();
        this.npY.b(this);
        aVar.a(this.npY);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.npY.getValue().intValue());
        if (this.npS != null) {
            this.paint.setColorFilter(this.npS.getValue());
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
            this.npY.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fq) {
            if (cVar == null) {
                this.npS = null;
                return;
            }
            this.npS = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.npS.b(this);
            this.npO.a(this.npY);
        }
    }
}
