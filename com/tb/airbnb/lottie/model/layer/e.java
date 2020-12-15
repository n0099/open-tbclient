package com.tb.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.tb.airbnb.lottie.model.content.j;
import java.util.Collections;
import java.util.List;
/* loaded from: classes20.dex */
public class e extends a {
    private final com.tb.airbnb.lottie.a.a.c pBq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.tb.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        this.pBq = new com.tb.airbnb.lottie.a.a.c(gVar, this, new j("__container", layer.jz()));
        this.pBq.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.pBq.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.pBq.a(rectF, this.GO);
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    protected void b(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        this.pBq.a(eVar, i, list, eVar2);
    }
}
