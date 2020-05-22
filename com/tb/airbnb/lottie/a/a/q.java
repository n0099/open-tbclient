package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> niC;
    private final com.tb.airbnb.lottie.model.layer.a nis;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> niw;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.dIY().toPaintCap(), shapeStroke.dIZ().toPaintJoin(), shapeStroke.ih(), shapeStroke.dIO(), shapeStroke.dIX(), shapeStroke.m50if(), shapeStroke.dJa());
        this.nis = aVar;
        this.name = shapeStroke.getName();
        this.niC = shapeStroke.dJo().dII();
        this.niC.b(this);
        aVar.a(this.niC);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.niC.getValue().intValue());
        if (this.niw != null) {
            this.paint.setColorFilter(this.niw.getValue());
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
            this.niC.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AV) {
            if (cVar == null) {
                this.niw = null;
                return;
            }
            this.niw = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.niw.b(this);
            this.nis.a(this.niC);
        }
    }
}
