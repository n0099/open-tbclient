package com.tb.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.j;
import java.util.Collections;
/* loaded from: classes6.dex */
public class e extends a {
    private final com.tb.airbnb.lottie.a.a.c ksB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.tb.airbnb.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        this.ksB = new com.tb.airbnb.lottie.a.a.c(fVar, this, new j(layer.getName(), layer.bX()));
        this.ksB.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.ksB.a(canvas, matrix, i);
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.ksB.a(rectF, this.hl);
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        this.ksB.b(str, str2, colorFilter);
    }
}
