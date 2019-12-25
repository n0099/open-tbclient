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
/* loaded from: classes2.dex */
public class b extends a {
    private final List<a> ec;
    private final RectF jj;
    @Nullable
    private Boolean jk;
    @Nullable
    private Boolean jl;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> mOS;
    private final RectF rect;

    public b(com.tb.airbnb.lottie.f fVar, Layer layer, List<Layer> list, com.tb.airbnb.lottie.e eVar) {
        super(fVar, layer);
        a aVar;
        this.ec = new ArrayList();
        this.rect = new RectF();
        this.jj = new RectF();
        com.tb.airbnb.lottie.model.a.b dCr = layer.dCr();
        if (dCr != null) {
            this.mOS = dCr.dBq();
            a(this.mOS);
            this.mOS.b(this);
        } else {
            this.mOS = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.bj().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), fVar, eVar);
            if (a == null) {
                aVar = aVar2;
            } else {
                longSparseArray.put(a.dCm().getId(), a);
                if (aVar2 != null) {
                    aVar2.b(a);
                    aVar = null;
                } else {
                    this.ec.add(0, a);
                    switch (r0.dCo()) {
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
            a aVar4 = (a) longSparseArray.get(aVar3.dCm().m32do());
            if (aVar4 != null) {
                aVar3.c(aVar4);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection("CompositionLayer#draw");
        canvas.save();
        this.jj.set(0.0f, 0.0f, this.mOM.dk(), this.mOM.dl());
        matrix.mapRect(this.jj);
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.jj.isEmpty()) {
                z = canvas.clipRect(this.jj);
            }
            if (z) {
                this.ec.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.tb.airbnb.lottie.d.F("CompositionLayer#draw");
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            this.ec.get(size).a(this.rect, this.iW);
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
        if (this.mOS != null) {
            f = (this.mOS.getValue().floatValue() * 1000.0f) / ((float) this.lottieDrawable.dBd().getDuration());
        }
        if (this.mOM.dh() != 0.0f) {
            f /= this.mOM.dh();
        }
        float di = f - this.mOM.di();
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            this.ec.get(size).setProgress(di);
        }
    }

    public boolean hasMasks() {
        if (this.jl == null) {
            for (int size = this.ec.size() - 1; size >= 0; size--) {
                a aVar = this.ec.get(size);
                if (aVar instanceof e) {
                    if (aVar.df()) {
                        this.jl = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.jl = true;
                    return true;
                }
            }
            this.jl = false;
        }
        return this.jl.booleanValue();
    }

    public boolean hasMatte() {
        if (this.jk == null) {
            if (dd()) {
                this.jk = true;
                return true;
            }
            for (int size = this.ec.size() - 1; size >= 0; size--) {
                if (this.ec.get(size).dd()) {
                    this.jk = true;
                    return true;
                }
            }
            this.jk = false;
        }
        return this.jk.booleanValue();
    }

    @Override // com.tb.airbnb.lottie.model.layer.a, com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ec.size()) {
                a aVar = this.ec.get(i2);
                String name = aVar.dCm().getName();
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
