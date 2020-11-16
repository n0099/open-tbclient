package com.tb.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import com.tb.airbnb.lottie.a.b.p;
import com.tb.airbnb.lottie.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class b extends a {
    private final List<a> Bn;
    private final RectF Gh;
    @Nullable
    private Boolean Gi;
    @Nullable
    private Boolean Gj;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> pLD;
    private final RectF rect;

    public b(com.tb.airbnb.lottie.g gVar, Layer layer, List<Layer> list, com.tb.airbnb.lottie.e eVar) {
        super(gVar, layer);
        a aVar;
        a aVar2;
        this.Bn = new ArrayList();
        this.rect = new RectF();
        this.Gh = new RectF();
        com.tb.airbnb.lottie.model.a.b ezB = layer.ezB();
        if (ezB != null) {
            this.pLD = ezB.eyM();
            a(this.pLD);
            this.pLD.b(this);
        } else {
            this.pLD = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.iz().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a2 = a.a(list.get(size), gVar, eVar);
            if (a2 == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a2.ezw().getId(), a2);
                if (aVar3 != null) {
                    aVar3.b(a2);
                    aVar2 = null;
                } else {
                    this.Bn.add(0, a2);
                    switch (r0.ezy()) {
                        case Add:
                        case Invert:
                            aVar2 = a2;
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.ezw().kF())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection("CompositionLayer#draw");
        canvas.save();
        this.Gh.set(0.0f, 0.0f, this.pLx.kB(), this.pLx.kC());
        matrix.mapRect(this.Gh);
        for (int size = this.Bn.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.Gh.isEmpty()) {
                z = canvas.clipRect(this.Gh);
            }
            if (z) {
                this.Bn.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.tb.airbnb.lottie.d.bb("CompositionLayer#draw");
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.Bn.size() - 1; size >= 0; size--) {
            this.Bn.get(size).a(this.rect, this.FV);
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
        if (this.pLD != null) {
            f = (this.pLD.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().iv();
        }
        if (this.pLx.ky() != 0.0f) {
            f /= this.pLx.ky();
        }
        float kz = f - this.pLx.kz();
        for (int size = this.Bn.size() - 1; size >= 0; size--) {
            this.Bn.get(size).setProgress(kz);
        }
    }

    public boolean hasMasks() {
        if (this.Gj == null) {
            for (int size = this.Bn.size() - 1; size >= 0; size--) {
                a aVar = this.Bn.get(size);
                if (aVar instanceof e) {
                    if (aVar.kw()) {
                        this.Gj = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.Gj = true;
                    return true;
                }
            }
            this.Gj = false;
        }
        return this.Gj.booleanValue();
    }

    public boolean hasMatte() {
        if (this.Gi == null) {
            if (ku()) {
                this.Gi = true;
                return true;
            }
            for (int size = this.Bn.size() - 1; size >= 0; size--) {
                if (this.Bn.get(size).ku()) {
                    this.Gi = true;
                    return true;
                }
            }
            this.Gi = false;
        }
        return this.Gi.booleanValue();
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    protected void b(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.Bn.size()) {
                this.Bn.get(i3).a(eVar, i, list, eVar2);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((b) t, (com.tb.airbnb.lottie.e.c<b>) cVar);
        if (t == k.Cr) {
            if (cVar == null) {
                this.pLD = null;
                return;
            }
            this.pLD = new p(cVar);
            a(this.pLD);
        }
    }
}
