package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
/* loaded from: classes3.dex */
public class d extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.ksad.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
    }
}
