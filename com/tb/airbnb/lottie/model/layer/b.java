package com.tb.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends a {
    private final List<a> dz;
    private final RectF hW;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> kuQ;
    @Nullable
    private Boolean kuR;
    @Nullable
    private Boolean kuS;
    private final RectF rect;

    public b(com.tb.airbnb.lottie.f fVar, Layer layer, List<Layer> list, com.tb.airbnb.lottie.e eVar) {
        super(fVar, layer);
        a aVar;
        this.dz = new ArrayList();
        this.rect = new RectF();
        this.hW = new RectF();
        com.tb.airbnb.lottie.model.a.b cMk = layer.cMk();
        if (cMk != null) {
            this.kuQ = cMk.cLn();
            a(this.kuQ);
            this.kuQ.b(this);
        } else {
            this.kuQ = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.aW().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), fVar, eVar);
            if (a == null) {
                aVar = aVar2;
            } else {
                longSparseArray.put(a.cMf().getId(), a);
                if (aVar2 != null) {
                    aVar2.b(a);
                    aVar = null;
                } else {
                    this.dz.add(0, a);
                    switch (r0.cMh()) {
                        case Add:
                        case Invert:
                            aVar = a;
                            continue;
                        default:
                            aVar = aVar2;
                            continue;
                    }
                }
            }
            size--;
            aVar2 = aVar;
        }
        for (int i = 0; i < longSparseArray.size(); i++) {
            a aVar3 = (a) longSparseArray.get(longSparseArray.keyAt(i));
            a aVar4 = (a) longSparseArray.get(aVar3.cMf().dk());
            if (aVar4 != null) {
                aVar3.c(aVar4);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection("CompositionLayer#draw");
        canvas.save();
        this.hW.set(0.0f, 0.0f, this.kuK.dg(), this.kuK.dh());
        matrix.mapRect(this.hW);
        for (int size = this.dz.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.hW.isEmpty()) {
                z = canvas.clipRect(this.hW);
            }
            if (z) {
                this.dz.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.tb.airbnb.lottie.d.D("CompositionLayer#draw");
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.dz.size() - 1; size >= 0; size--) {
            this.dz.get(size).a(this.rect, this.hK);
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
        if (this.kuQ != null) {
            f = (this.kuQ.getValue().floatValue() * 1000.0f) / ((float) this.lottieDrawable.cLc().getDuration());
        }
        if (this.kuK.de() != 0.0f) {
            f /= this.kuK.de();
        }
        float bo = f - this.kuK.bo();
        for (int size = this.dz.size() - 1; size >= 0; size--) {
            this.dz.get(size).setProgress(bo);
        }
    }

    public boolean hasMasks() {
        if (this.kuS == null) {
            for (int size = this.dz.size() - 1; size >= 0; size--) {
                a aVar = this.dz.get(size);
                if (aVar instanceof e) {
                    if (aVar.dc()) {
                        this.kuS = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.kuS = true;
                    return true;
                }
            }
            this.kuS = false;
        }
        return this.kuS.booleanValue();
    }

    public boolean hasMatte() {
        if (this.kuR == null) {
            if (da()) {
                this.kuR = true;
                return true;
            }
            for (int size = this.dz.size() - 1; size >= 0; size--) {
                if (this.dz.get(size).da()) {
                    this.kuR = true;
                    return true;
                }
            }
            this.kuR = false;
        }
        return this.kuR.booleanValue();
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dz.size()) {
                a aVar = this.dz.get(i2);
                String name = aVar.cMf().getName();
                if (str == null) {
                    aVar.b((String) null, (String) null, colorFilter);
                } else if (name.equals(str)) {
                    aVar.b(str, str2, colorFilter);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
