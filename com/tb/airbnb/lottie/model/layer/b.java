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
    private final List<a> eb;
    private final RectF jl;
    @Nullable
    private Boolean jm;
    @Nullable
    private Boolean jn;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<Float, Float> ntu;
    private final RectF rect;

    public b(com.tb.airbnb.lottie.f fVar, Layer layer, List<Layer> list, com.tb.airbnb.lottie.d dVar) {
        super(fVar, layer);
        a aVar;
        a aVar2;
        this.eb = new ArrayList();
        this.rect = new RectF();
        this.jl = new RectF();
        com.tb.airbnb.lottie.model.a.b dIf = layer.dIf();
        if (dIf != null) {
            this.ntu = dIf.dHq();
            a(this.ntu);
            this.ntu.b(this);
        } else {
            this.ntu = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.bk().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a = a.a(list.get(size), fVar, dVar);
            if (a == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a.dIa().getId(), a);
                if (aVar3 != null) {
                    aVar3.b(a);
                    aVar2 = null;
                } else {
                    this.eb.add(0, a);
                    switch (r0.dIc()) {
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.dIa().dp())) != null) {
                aVar4.c(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("CompositionLayer#draw");
        canvas.save();
        this.jl.set(0.0f, 0.0f, this.nto.dl(), this.nto.dm());
        matrix.mapRect(this.jl);
        for (int size = this.eb.size() - 1; size >= 0; size--) {
            boolean z = true;
            if (!this.jl.isEmpty()) {
                z = canvas.clipRect(this.jl);
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
            this.eb.get(size).a(this.rect, this.iY);
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
        if (this.ntu != null) {
            f = (this.ntu.getValue().floatValue() * 1000.0f) / this.lottieDrawable.getComposition().bg();
        }
        if (this.nto.di() != 0.0f) {
            f /= this.nto.di();
        }
        float dj = f - this.nto.dj();
        for (int size = this.eb.size() - 1; size >= 0; size--) {
            this.eb.get(size).setProgress(dj);
        }
    }

    public boolean hasMasks() {
        if (this.jn == null) {
            for (int size = this.eb.size() - 1; size >= 0; size--) {
                a aVar = this.eb.get(size);
                if (aVar instanceof e) {
                    if (aVar.dg()) {
                        this.jn = true;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).hasMasks()) {
                    this.jn = true;
                    return true;
                }
            }
            this.jn = false;
        }
        return this.jn.booleanValue();
    }

    public boolean hasMatte() {
        if (this.jm == null) {
            if (de()) {
                this.jm = true;
                return true;
            }
            for (int size = this.eb.size() - 1; size >= 0; size--) {
                if (this.eb.get(size).de()) {
                    this.jm = true;
                    return true;
                }
            }
            this.jm = false;
        }
        return this.jm.booleanValue();
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
        if (t == j.fn) {
            if (cVar == null) {
                this.ntu = null;
                return;
            }
            this.ntu = new p(cVar);
            a(this.ntu);
        }
    }
}
