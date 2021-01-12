package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends a {
    @Nullable
    private com.ksad.lottie.a.b.a<Float, Float> e;
    private final List<a> f;
    private final RectF g;
    private final RectF h;

    public b(com.ksad.lottie.f fVar, Layer layer, List<Layer> list, com.ksad.lottie.d dVar) {
        super(fVar, layer);
        a aVar;
        a aVar2;
        this.f = new ArrayList();
        this.g = new RectF();
        this.h = new RectF();
        com.ksad.lottie.model.a.b u = layer.u();
        if (u != null) {
            this.e = u.a();
            a(this.e);
            this.e.a(this);
        } else {
            this.e = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.g().size());
        int size = list.size() - 1;
        a aVar3 = null;
        while (size >= 0) {
            a a2 = a.a(list.get(size), fVar, dVar);
            if (a2 == null) {
                aVar2 = aVar3;
            } else {
                longSparseArray.put(a2.b().e(), a2);
                if (aVar3 != null) {
                    aVar3.a(a2);
                    aVar2 = null;
                } else {
                    this.f.add(0, a2);
                    switch (r0.l()) {
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
            if (aVar4 != null && (aVar = (a) longSparseArray.get(aVar4.b().m())) != null) {
                aVar4.b(aVar);
            }
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        super.a(f);
        if (this.e != null) {
            f = (this.e.e().floatValue() * 1000.0f) / this.f8094b.r().c();
        }
        if (this.c.b() != 0.0f) {
            f /= this.c.b();
        }
        float c = f - this.c.c();
        for (int size = this.f.size() - 1; size >= 0; size--) {
            this.f.get(size).a(c);
        }
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.g.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f.size() - 1; size >= 0; size--) {
            this.f.get(size).a(this.g, this.f8093a);
            if (rectF.isEmpty()) {
                rectF.set(this.g);
            } else {
                rectF.set(Math.min(rectF.left, this.g.left), Math.min(rectF.top, this.g.top), Math.max(rectF.right, this.g.right), Math.max(rectF.bottom, this.g.bottom));
            }
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    void b(Canvas canvas, Matrix matrix, int i) {
        com.ksad.lottie.c.c("CompositionLayer#draw");
        canvas.save();
        this.h.set(0.0f, 0.0f, this.c.h(), this.c.i());
        matrix.mapRect(this.h);
        for (int size = this.f.size() - 1; size >= 0; size--) {
            if (this.h.isEmpty() ? true : canvas.clipRect(this.h)) {
                this.f.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.ksad.lottie.c.d("CompositionLayer#draw");
    }
}
