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
/* loaded from: classes5.dex */
public class f implements d, j, a.InterfaceC0730a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a noU;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> noW;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> noY;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> npe;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<l> fO = new ArrayList();

    public f(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.i iVar) {
        this.noU = aVar;
        this.name = iVar.getName();
        this.lottieDrawable = fVar;
        if (iVar.dGk() == null || iVar.dFK() == null) {
            this.npe = null;
            this.noW = null;
            return;
        }
        this.path.setFillType(iVar.cz());
        this.npe = iVar.dGk().dFE();
        this.npe.b(this);
        aVar.a(this.npe);
        this.noW = iVar.dFK().dFE();
        this.noW.b(this);
        aVar.a(this.noW);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0730a
    public void bC() {
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
                    this.fO.add((l) bVar);
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
        this.paint.setColor(this.npe.getValue().intValue());
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.noW.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        if (this.noY != null) {
            this.paint.setColorFilter(this.noY.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.fO.size(); i2++) {
            this.path.addPath(this.fO.get(i2).bF(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.c.F("FillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.fO.size(); i++) {
            this.path.addPath(this.fO.get(i).bF(), matrix);
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
        if (t == com.tb.airbnb.lottie.j.eK) {
            this.npe.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eN) {
            this.noW.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fj) {
            if (cVar == null) {
                this.noY = null;
                return;
            }
            this.noY = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.noY.b(this);
            this.noU.a(this.noY);
        }
    }
}
