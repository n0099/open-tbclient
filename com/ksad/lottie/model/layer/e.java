package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.ksad.lottie.model.content.j;
import java.util.Collections;
/* loaded from: classes6.dex */
public class e extends a {

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.a.c f31973e;

    public e(com.ksad.lottie.f fVar, Layer layer) {
        super(fVar, layer);
        com.ksad.lottie.a.a.c cVar = new com.ksad.lottie.a.a.c(fVar, this, new j("__container", layer.n()));
        this.f31973e = cVar;
        cVar.a(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.f31973e.a(rectF, this.f31952a);
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.f31973e.a(canvas, matrix, i);
    }
}
