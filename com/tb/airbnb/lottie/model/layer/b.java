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
    private final RectF EH;
    @Nullable
    private Boolean EI;
    @Nullable
    private Boolean EJ;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> mQf;
    private final RectF rect;
    private final List<a> zM;

    public b(com.tb.airbnb.lottie.f fVar, Layer layer, List<Layer> list, com.tb.airbnb.lottie.d dVar) {
        super(fVar, layer);
        a aVar;
        a aVar2;
        this.zM = new ArrayList();
        this.rect = new RectF();
        this.EH = new RectF();
        com.tb.airbnb.lottie.model.a.b dCh = layer.dCh();
        if (dCh != null) {
            this.mQf = dCh.dBs();
            a(this.mQf);
            this.mQf.b(this);
        } else {
            this.mQf = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.gH().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), fVar, dVar);
            if (a == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a.dCc().getId(), a);
                if (aVar3 != null) {
                    aVar3.b(a);
                    aVar2 = null;
                } else {
                    this.zM.add(0, a);
                    switch (r0.dCe()) {
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.dCc().iO())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("CompositionLayer#draw");
        canvas.save();
        this.EH.set(0.0f, 0.0f, this.mPZ.iK(), this.mPZ.iL());
        matrix.mapRect(this.EH);
        for (int size = this.zM.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.EH.isEmpty()) {
                z = canvas.clipRect(this.EH);
            }
            if (z) {
                this.zM.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.tb.airbnb.lottie.c.aV("CompositionLayer#draw");
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.zM.size() - 1; size >= 0; size--) {
            this.zM.get(size).a(this.rect, this.Eu);
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
        if (this.mQf != null) {
            f = (this.mQf.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().gD();
        }
        if (this.mPZ.iH() != 0.0f) {
            f /= this.mPZ.iH();
        }
        float iI = f - this.mPZ.iI();
        for (int size = this.zM.size() - 1; size >= 0; size--) {
            this.zM.get(size).setProgress(iI);
        }
    }

    public boolean hasMasks() {
        if (this.EJ == null) {
            for (int size = this.zM.size() - 1; size >= 0; size--) {
                a aVar = this.zM.get(size);
                if (aVar instanceof e) {
                    if (aVar.iF()) {
                        this.EJ = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.EJ = true;
                    return true;
                }
            }
            this.EJ = false;
        }
        return this.EJ.booleanValue();
    }

    public boolean hasMatte() {
        if (this.EI == null) {
            if (iD()) {
                this.EI = true;
                return true;
            }
            for (int size = this.zM.size() - 1; size >= 0; size--) {
                if (this.zM.get(size).iD()) {
                    this.EI = true;
                    return true;
                }
            }
            this.EI = false;
        }
        return this.EI.booleanValue();
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    protected void b(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.zM.size()) {
                this.zM.get(i3).a(eVar, i, list, eVar2);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        super.a((b) t, (com.tb.airbnb.lottie.e.c<b>) cVar);
        if (t == j.AU) {
            if (cVar == null) {
                this.mQf = null;
                return;
            }
            this.mQf = new p(cVar);
            a(this.mQf);
        }
    }
}
