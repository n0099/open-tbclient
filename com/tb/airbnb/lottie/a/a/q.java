package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes16.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a pyN;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> pyR;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> pyX;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.evm().toPaintCap(), shapeStroke.evn().toPaintJoin(), shapeStroke.jZ(), shapeStroke.evc(), shapeStroke.evl(), shapeStroke.jX(), shapeStroke.evo());
        this.pyN = aVar;
        this.name = shapeStroke.getName();
        this.pyX = shapeStroke.evC().euW();
        this.pyX.b(this);
        aVar.a(this.pyX);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.pyX.getValue().intValue());
        if (this.pyR != null) {
            this.paint.setColorFilter(this.pyR.getValue());
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
            this.pyX.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cs) {
            if (cVar == null) {
                this.pyR = null;
                return;
            }
            this.pyR = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.pyR.b(this);
            this.pyN.a(this.pyX);
        }
    }
}
