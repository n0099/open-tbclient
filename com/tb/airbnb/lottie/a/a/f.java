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
public class f implements d, j, a.InterfaceC0738a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a npB;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> npD;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> npF;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> npL;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<l> fS = new ArrayList();

    public f(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.i iVar) {
        this.npB = aVar;
        this.name = iVar.getName();
        this.lottieDrawable = fVar;
        if (iVar.dHt() == null || iVar.dGT() == null) {
            this.npL = null;
            this.npD = null;
            return;
        }
        this.path.setFillType(iVar.cA());
        this.npL = iVar.dHt().dGN();
        this.npL.b(this);
        aVar.a(this.npL);
        this.npD = iVar.dGT().dGN();
        this.npD.b(this);
        aVar.a(this.npD);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0738a
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
                    this.fS.add((l) bVar);
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
        this.paint.setColor(this.npL.getValue().intValue());
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.npD.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        if (this.npF != null) {
            this.paint.setColorFilter(this.npF.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.fS.size(); i2++) {
            this.path.addPath(this.fS.get(i2).bG(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.c.F("FillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.fS.size(); i++) {
            this.path.addPath(this.fS.get(i).bG(), matrix);
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
        if (t == com.tb.airbnb.lottie.j.eN) {
            this.npL.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eQ) {
            this.npD.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fq) {
            if (cVar == null) {
                this.npF = null;
                return;
            }
            this.npF = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.npF.b(this);
            this.npB.a(this.npF);
        }
    }
}
