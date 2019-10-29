package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
/* loaded from: classes6.dex */
public class p extends a {
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> ktb;
    private final String name;

    public p(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.cLL().toPaintCap(), shapeStroke.cLM().toPaintJoin(), shapeStroke.cLz(), shapeStroke.cLK(), shapeStroke.cE(), shapeStroke.cLN());
        this.name = shapeStroke.getName();
        this.ktb = shapeStroke.cMb().cLn();
        this.ktb.b(this);
        aVar.a(this.ktb);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // com.tb.airbnb.lottie.a.a.a, com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.ktb.getValue().intValue());
        super.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }
}
