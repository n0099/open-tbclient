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
/* loaded from: classes17.dex */
public class f implements d, j, a.InterfaceC1041a {
    private final com.tb.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a pJK;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> pJM;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> pJO;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> pJU;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<l> CX = new ArrayList();

    public f(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.i iVar) {
        this.pJK = aVar;
        this.name = iVar.getName();
        this.lottieDrawable = gVar;
        if (iVar.ezs() == null || iVar.eyS() == null) {
            this.pJU = null;
            this.pJM = null;
            return;
        }
        this.path.setFillType(iVar.jQ());
        this.pJU = iVar.ezs().eyM();
        this.pJU.b(this);
        aVar.a(this.pJU);
        this.pJM = iVar.eyS().eyM();
        this.pJM.b(this);
        aVar.a(this.pJM);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1041a
    public void iT() {
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
                    this.CX.add((l) bVar);
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
        com.tb.airbnb.lottie.d.beginSection("FillContent#draw");
        this.paint.setColor(this.pJU.getValue().intValue());
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.pJM.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        if (this.pJO != null) {
            this.paint.setColorFilter(this.pJO.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.CX.size(); i2++) {
            this.path.addPath(this.CX.get(i2).iW(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.d.bb("FillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.CX.size(); i++) {
            this.path.addPath(this.CX.get(i).iW(), matrix);
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
        if (t == com.tb.airbnb.lottie.k.BV) {
            this.pJU.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.BY) {
            this.pJM.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Cs) {
            if (cVar == null) {
                this.pJO = null;
                return;
            }
            this.pJO = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.pJO.b(this);
            this.pJK.a(this.pJO);
        }
    }
}
