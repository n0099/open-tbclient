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
public class f implements d, j, a.InterfaceC0844a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> niC;
    private final com.tb.airbnb.lottie.model.layer.a nis;
    private final com.tb.airbnb.lottie.a.b.a<Integer, Integer> niu;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> niw;
    private final Path path = new Path();
    private final Paint paint = new Paint(1);
    private final List<l> Bu = new ArrayList();

    public f(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.i iVar) {
        this.nis = aVar;
        this.name = iVar.getName();
        this.lottieDrawable = fVar;
        if (iVar.dJo() == null || iVar.dIO() == null) {
            this.niC = null;
            this.niu = null;
            return;
        }
        this.path.setFillType(iVar.hX());
        this.niC = iVar.dJo().dII();
        this.niC.b(this);
        aVar.a(this.niC);
        this.niu = iVar.dIO().dII();
        this.niu.b(this);
        aVar.a(this.niu);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0844a
    public void ha() {
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
                    this.Bu.add((l) bVar);
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
        this.paint.setColor(this.niC.getValue().intValue());
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.niu.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        if (this.niw != null) {
            this.paint.setColorFilter(this.niw.getValue());
        }
        this.path.reset();
        for (int i2 = 0; i2 < this.Bu.size(); i2++) {
            this.path.addPath(this.Bu.get(i2).hd(), matrix);
        }
        canvas.drawPath(this.path, this.paint);
        com.tb.airbnb.lottie.c.aV("FillContent#draw");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.path.reset();
        for (int i = 0; i < this.Bu.size(); i++) {
            this.path.addPath(this.Bu.get(i).hd(), matrix);
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
        if (t == com.tb.airbnb.lottie.j.Av) {
            this.niC.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Ay) {
            this.niu.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AV) {
            if (cVar == null) {
                this.niw = null;
                return;
            }
            this.niw = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.niw.b(this);
            this.nis.a(this.niw);
        }
    }
}
