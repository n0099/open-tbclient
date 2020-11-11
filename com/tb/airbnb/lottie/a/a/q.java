package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes16.dex */
public class q extends a {
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a pIh;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> pIl;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> pIr;

    public q(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(gVar, aVar, shapeStroke.ezb().toPaintCap(), shapeStroke.ezc().toPaintJoin(), shapeStroke.jZ(), shapeStroke.eyR(), shapeStroke.eza(), shapeStroke.jX(), shapeStroke.ezd());
        this.pIh = aVar;
        this.name = shapeStroke.getName();
        this.pIr = shapeStroke.ezr().eyL();
        this.pIr.b(this);
        aVar.a(this.pIr);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.pIr.getValue().intValue());
        if (this.pIl != null) {
            this.paint.setColorFilter(this.pIl.getValue());
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
            this.pIr.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Cs) {
            if (cVar == null) {
                this.pIl = null;
                return;
            }
            this.pIl = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.pIl.b(this);
            this.pIh.a(this.pIr);
        }
    }
}
