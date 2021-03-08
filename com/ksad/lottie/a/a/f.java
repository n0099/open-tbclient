package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements d, j, a.InterfaceC1084a {
    private final com.ksad.lottie.model.layer.a c;
    private final String d;
    private final com.ksad.lottie.a.b.a<Integer, Integer> f;
    private final com.ksad.lottie.a.b.a<Integer, Integer> g;
    @Nullable
    private com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> h;
    private final com.ksad.lottie.f i;

    /* renamed from: a  reason: collision with root package name */
    private final Path f5312a = new Path();
    private final Paint b = new Paint(1);
    private final List<l> e = new ArrayList();

    public f(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.i iVar) {
        this.c = aVar;
        this.d = iVar.a();
        this.i = fVar;
        if (iVar.b() == null || iVar.c() == null) {
            this.f = null;
            this.g = null;
            return;
        }
        this.f5312a.setFillType(iVar.d());
        this.f = iVar.b().a();
        this.f.a(this);
        aVar.a(this.f);
        this.g = iVar.c().a();
        this.g.a(this);
        aVar.a(this.g);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC1084a
    public void a() {
        this.i.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.ksad.lottie.c.c("FillContent#draw");
        this.b.setColor(this.f.e().intValue());
        this.b.setAlpha(com.ksad.lottie.d.e.a((int) (((this.g.e().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        if (this.h != null) {
            this.b.setColorFilter(this.h.e());
        }
        this.f5312a.reset();
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            this.f5312a.addPath(this.e.get(i2).d(), matrix);
        }
        canvas.drawPath(this.f5312a, this.b);
        com.ksad.lottie.c.d("FillContent#draw");
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.f5312a.reset();
        for (int i = 0; i < this.e.size(); i++) {
            this.f5312a.addPath(this.e.get(i).d(), matrix);
        }
        this.f5312a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list2.size()) {
                return;
            }
            b bVar = list2.get(i2);
            if (bVar instanceof l) {
                this.e.add((l) bVar);
            }
            i = i2 + 1;
        }
    }
}
