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
/* loaded from: classes7.dex */
public class b extends a {
    private final List<a> AW;
    private final RectF FP;
    @Nullable
    private Boolean FQ;
    @Nullable
    private Boolean FR;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> okj;
    private final RectF rect;

    public b(com.tb.airbnb.lottie.f fVar, Layer layer, List<Layer> list, com.tb.airbnb.lottie.d dVar) {
        super(fVar, layer);
        a aVar;
        a aVar2;
        this.AW = new ArrayList();
        this.rect = new RectF();
        this.FP = new RectF();
        com.tb.airbnb.lottie.model.a.b eed = layer.eed();
        if (eed != null) {
            this.okj = eed.edo();
            a(this.okj);
            this.okj.b(this);
        } else {
            this.okj = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.iy().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), fVar, dVar);
            if (a == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a.edY().getId(), a);
                if (aVar3 != null) {
                    aVar3.b(a);
                    aVar2 = null;
                } else {
                    this.AW.add(0, a);
                    switch (r0.eea()) {
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.edY().kD())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("CompositionLayer#draw");
        canvas.save();
        this.FP.set(0.0f, 0.0f, this.okd.kz(), this.okd.kA());
        matrix.mapRect(this.FP);
        for (int size = this.AW.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.FP.isEmpty()) {
                z = canvas.clipRect(this.FP);
            }
            if (z) {
                this.AW.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.tb.airbnb.lottie.c.bb("CompositionLayer#draw");
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.AW.size() - 1; size >= 0; size--) {
            this.AW.get(size).a(this.rect, this.FD);
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
        if (this.okj != null) {
            f = (this.okj.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().iu();
        }
        if (this.okd.kw() != 0.0f) {
            f /= this.okd.kw();
        }
        float kx = f - this.okd.kx();
        for (int size = this.AW.size() - 1; size >= 0; size--) {
            this.AW.get(size).setProgress(kx);
        }
    }

    public boolean hasMasks() {
        if (this.FR == null) {
            for (int size = this.AW.size() - 1; size >= 0; size--) {
                a aVar = this.AW.get(size);
                if (aVar instanceof e) {
                    if (aVar.ku()) {
                        this.FR = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.FR = true;
                    return true;
                }
            }
            this.FR = false;
        }
        return this.FR.booleanValue();
    }

    public boolean hasMatte() {
        if (this.FQ == null) {
            if (ks()) {
                this.FQ = true;
                return true;
            }
            for (int size = this.AW.size() - 1; size >= 0; size--) {
                if (this.AW.get(size).ks()) {
                    this.FQ = true;
                    return true;
                }
            }
            this.FQ = false;
        }
        return this.FQ.booleanValue();
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    protected void b(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.AW.size()) {
                this.AW.get(i3).a(eVar, i, list, eVar2);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((b) t, (com.tb.airbnb.lottie.e.c<b>) cVar);
        if (t == j.Ca) {
            if (cVar == null) {
                this.okj = null;
                return;
            }
            this.okj = new p(cVar);
            a(this.okj);
        }
    }
}
