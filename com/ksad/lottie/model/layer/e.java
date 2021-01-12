package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.ksad.lottie.model.content.j;
import java.util.Collections;
/* loaded from: classes4.dex */
public class e extends a {
    private final com.ksad.lottie.a.a.c e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.e = new com.ksad.lottie.a.a.c(fVar, this, new j("__container", layer.n()));
        this.e.a(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.e.a(rectF, this.f8093a);
    }

    @Override // com.ksad.lottie.model.layer.a
    void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.e.a(canvas, matrix, i);
    }
}
