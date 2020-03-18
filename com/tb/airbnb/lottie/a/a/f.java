package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f implements d, j, a.InterfaceC0739a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a nrB;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> nrD;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> nrF;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> nrL;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<l> fR = new ArrayList();

    public f(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.i iVar) {
        this.nrB = aVar;
        this.name = iVar.getName();
        this.lottieDrawable = fVar;
        if (iVar.dHW() == null || iVar.dHw() == null) {
            this.nrL = null;
            this.nrD = null;
            return;
        }
        this.path.setFillType(iVar.cA());
        this.nrL = iVar.dHW().dHq();
        this.nrL.b(this);
        aVar.a(this.nrL);
        this.nrD = iVar.dHw().dHq();
        this.nrD.b(this);
        aVar.a(this.nrD);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0739a
    public void bD() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                b bVar = list2.get(i2);
                if (bVar instanceof l) {
                    this.fR.add((l) bVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("FillContent#draw");
        this.paint.setColor(this.nrL.getValue().intValue());
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.nrD.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        if (this.nrF != null) {
            this.paint.setColorFilter(this.nrF.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.fR.size(); i2++) {
            this.path.addPath(this.fR.get(i2).bG(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.c.F("FillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.fR.size(); i++) {
            this.path.addPath(this.fR.get(i).bG(), matrix);
        }
        this.path.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.eM) {
            this.nrL.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eP) {
            this.nrD.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fo) {
            if (cVar == null) {
                this.nrF = null;
                return;
            }
            this.nrF = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.nrF.b(this);
            this.nrB.a(this.nrF);
        }
    }
}
