package com.tb.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.tb.airbnb.lottie.model.content.j;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends a {
    private final com.tb.airbnb.lottie.a.a.c npz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.npz = new com.tb.airbnb.lottie.a.a.c(fVar, this, new j("__container", layer.ci()));
        this.npz.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.npz.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.npz.a(rectF, this.iV);
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    protected void b(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        this.npz.a(eVar, i, list, eVar2);
    }
}
