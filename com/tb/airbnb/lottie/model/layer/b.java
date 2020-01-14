package com.tb.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.tb.airbnb.lottie.a.b.p;
import com.tb.airbnb.lottie.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends a {
    private final List<a> eb;
    private final RectF ji;
    @Nullable
    private Boolean jj;
    @Nullable
    private Boolean jk;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> nqS;
    private final RectF rect;

    public b(com.tb.airbnb.lottie.f fVar, Layer layer, List<Layer> list, com.tb.airbnb.lottie.d dVar) {
        super(fVar, layer);
        a aVar;
        a aVar2;
        this.eb = new ArrayList();
        this.rect = new RectF();
        this.ji = new RectF();
        com.tb.airbnb.lottie.model.a.b dGv = layer.dGv();
        if (dGv != null) {
            this.nqS = dGv.dFG();
            a(this.nqS);
            this.nqS.b(this);
        } else {
            this.nqS = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.bj().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), fVar, dVar);
            if (a == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a.dGq().getId(), a);
                if (aVar3 != null) {
                    aVar3.b(a);
                    aVar2 = null;
                } else {
                    this.eb.add(0, a);
                    switch (r0.dGs()) {
                        case Add:
                        case Invert:
                            aVar2 = a;
                            continue;
                        default:
                            aVar2 = aVar3;
                            continue;
                    }
                }
            }
            size--;
            aVar3 = aVar2;
        }
        for (int i = 0; i < longSparseArray.size(); i++) {
            a aVar4 = (a) longSparseArray.get(longSparseArray.keyAt(i));
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.dGq().m41do())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("CompositionLayer#draw");
        canvas.save();
        this.ji.set(0.0f, 0.0f, this.nqM.dk(), this.nqM.dl());
        matrix.mapRect(this.ji);
        for (int size = this.eb.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.ji.isEmpty()) {
                z = canvas.clipRect(this.ji);
            }
            if (z) {
                this.eb.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.tb.airbnb.lottie.c.F("CompositionLayer#draw");
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.eb.size() - 1; size >= 0; size--) {
            this.eb.get(size).a(this.rect, this.iV);
            if (rectF.isEmpty()) {
                rectF.set(this.rect);
            } else {
                rectF.set(Math.min(rectF.left, this.rect.left), Math.min(rectF.top, this.rect.top), Math.max(rectF.right, this.rect.right), Math.max(rectF.bottom, this.rect.bottom));
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.setProgress(f);
        if (this.nqS != null) {
            f = (this.nqS.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().bf();
        }
        if (this.nqM.dh() != 0.0f) {
            f /= this.nqM.dh();
        }
        float di = f - this.nqM.di();
        for (int size = this.eb.size() - 1; size >= 0; size--) {
            this.eb.get(size).setProgress(di);
        }
    }

    public boolean hasMasks() {
        if (this.jk == null) {
            for (int size = this.eb.size() - 1; size >= 0; size--) {
                a aVar = this.eb.get(size);
                if (aVar instanceof e) {
                    if (aVar.df()) {
                        this.jk = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.jk = true;
                    return true;
                }
            }
            this.jk = false;
        }
        return this.jk.booleanValue();
    }

    public boolean hasMatte() {
        if (this.jj == null) {
            if (dd()) {
                this.jj = true;
                return true;
            }
            for (int size = this.eb.size() - 1; size >= 0; size--) {
                if (this.eb.get(size).dd()) {
                    this.jj = true;
                    return true;
                }
            }
            this.jj = false;
        }
        return this.jj.booleanValue();
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    protected void b(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.eb.size()) {
                this.eb.get(i3).a(eVar, i, list, eVar2);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((b) t, (com.tb.airbnb.lottie.e.c<b>) cVar);
        if (t == j.fi) {
            if (cVar == null) {
                this.nqS = null;
                return;
            }
            this.nqS = new p(cVar);
            a(this.nqS);
        }
    }
}
