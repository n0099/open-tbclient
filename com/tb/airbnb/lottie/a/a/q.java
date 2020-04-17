package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class q extends a {
    private final com.tb.airbnb.lottie.model.layer.a mOk;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> mOo;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> mOu;
    private final String name;

    public q(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.dBI().toPaintCap(), shapeStroke.dBJ().toPaintJoin(), shapeStroke.ih(), shapeStroke.dBy(), shapeStroke.dBH(), shapeStroke.m48if(), shapeStroke.dBK());
        this.mOk = aVar;
        this.name = shapeStroke.getName();
        this.mOu = shapeStroke.dBY().dBs();
        this.mOu.b(this);
        aVar.a(this.mOu);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.mOu.getValue().intValue());
        if (this.mOo != null) {
            this.paint.setColorFilter(this.mOo.getValue());
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
            this.mOu.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AV) {
            if (cVar == null) {
                this.mOo = null;
                return;
            }
            this.mOo = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.mOo.b(this);
            this.mOk.a(this.mOu);
        }
    }
}
