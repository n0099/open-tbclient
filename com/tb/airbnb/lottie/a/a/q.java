package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes5.dex */
public class q extends a {
    private final com.tb.airbnb.lottie.model.layer.a nOe;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> nOi;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> nOo;
    private final String name;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.dRt().toPaintCap(), shapeStroke.dRu().toPaintJoin(), shapeStroke.iy(), shapeStroke.dRj(), shapeStroke.dRs(), shapeStroke.iw(), shapeStroke.dRv());
        this.nOe = aVar;
        this.name = shapeStroke.getName();
        this.nOo = shapeStroke.dRJ().dRd();
        this.nOo.b(this);
        aVar.a(this.nOo);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.nOo.getValue().intValue());
        if (this.nOi != null) {
            this.paint.setColorFilter(this.nOi.getValue());
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
        if (t == com.tb.airbnb.lottie.j.Bb) {
            this.nOo.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bx) {
            if (cVar == null) {
                this.nOi = null;
                return;
            }
            this.nOi = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.nOi.b(this);
            this.nOe.a(this.nOo);
        }
    }
}
