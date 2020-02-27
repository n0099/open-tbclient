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
/* loaded from: classes6.dex */
public class b extends a {
    private final List<a> ec;
    private final RectF jm;
    @Nullable
    private Boolean jn;
    @Nullable
    private Boolean jo;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> nru;
    private final RectF rect;

    public b(com.tb.airbnb.lottie.f fVar, Layer layer, List<Layer> list, com.tb.airbnb.lottie.d dVar) {
        super(fVar, layer);
        a aVar;
        a aVar2;
        this.ec = new ArrayList();
        this.rect = new RectF();
        this.jm = new RectF();
        com.tb.airbnb.lottie.model.a.b dHC = layer.dHC();
        if (dHC != null) {
            this.nru = dHC.dGN();
            a(this.nru);
            this.nru.b(this);
        } else {
            this.nru = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.bk().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), fVar, dVar);
            if (a == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a.dHx().getId(), a);
                if (aVar3 != null) {
                    aVar3.b(a);
                    aVar2 = null;
                } else {
                    this.ec.add(0, a);
                    switch (r0.dHz()) {
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.dHx().dp())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("CompositionLayer#draw");
        canvas.save();
        this.jm.set(0.0f, 0.0f, this.nro.dl(), this.nro.dm());
        matrix.mapRect(this.jm);
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.jm.isEmpty()) {
                z = canvas.clipRect(this.jm);
            }
            if (z) {
                this.ec.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.tb.airbnb.lottie.c.F("CompositionLayer#draw");
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            this.ec.get(size).a(this.rect, this.iZ);
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
        if (this.nru != null) {
            f = (this.nru.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().bg();
        }
        if (this.nro.di() != 0.0f) {
            f /= this.nro.di();
        }
        float dj = f - this.nro.dj();
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            this.ec.get(size).setProgress(dj);
        }
    }

    public boolean hasMasks() {
        if (this.jo == null) {
            for (int size = this.ec.size() - 1; size >= 0; size--) {
                a aVar = this.ec.get(size);
                if (aVar instanceof e) {
                    if (aVar.dg()) {
                        this.jo = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.jo = true;
                    return true;
                }
            }
            this.jo = false;
        }
        return this.jo.booleanValue();
    }

    public boolean hasMatte() {
        if (this.jn == null) {
            if (de()) {
                this.jn = true;
                return true;
            }
            for (int size = this.ec.size() - 1; size >= 0; size--) {
                if (this.ec.get(size).de()) {
                    this.jn = true;
                    return true;
                }
            }
            this.jn = false;
        }
        return this.jn.booleanValue();
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    protected void b(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.ec.size()) {
                this.ec.get(i3).a(eVar, i, list, eVar2);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((b) t, (com.tb.airbnb.lottie.e.c<b>) cVar);
        if (t == j.fo) {
            if (cVar == null) {
                this.nru = null;
                return;
            }
            this.nru = new p(cVar);
            a(this.nru);
        }
    }
}
