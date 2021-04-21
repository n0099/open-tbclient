package com.ksad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.ksad.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends a {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public com.ksad.lottie.a.b.a<Float, Float> f31964e;

    /* renamed from: f  reason: collision with root package name */
    public final List<a> f31965f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f31966g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f31967h;

    /* renamed from: com.ksad.lottie.model.layer.b$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31968a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f31968a = iArr;
            try {
                iArr[Layer.MatteType.Add.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31968a[Layer.MatteType.Invert.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(com.ksad.lottie.f fVar, Layer layer, List<Layer> list, com.ksad.lottie.d dVar) {
        super(fVar, layer);
        int i;
        a aVar;
        this.f31965f = new ArrayList();
        this.f31966g = new RectF();
        this.f31967h = new RectF();
        com.ksad.lottie.model.a.b u = layer.u();
        if (u != null) {
            com.ksad.lottie.a.b.a<Float, Float> a2 = u.a();
            this.f31964e = a2;
            a(a2);
            this.f31964e.a(this);
        } else {
            this.f31964e = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(dVar.g().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            a a3 = a.a(layer2, fVar, dVar);
            if (a3 != null) {
                longSparseArray.put(a3.b().e(), a3);
                if (aVar2 != null) {
                    aVar2.a(a3);
                    aVar2 = null;
                } else {
                    this.f31965f.add(0, a3);
                    int i2 = AnonymousClass1.f31968a[layer2.l().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar2 = a3;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            a aVar3 = (a) longSparseArray.get(longSparseArray.keyAt(i));
            if (aVar3 != null && (aVar = (a) longSparseArray.get(aVar3.b().m())) != null) {
                aVar3.b(aVar);
            }
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        super.a(f2);
        if (this.f31964e != null) {
            f2 = (this.f31964e.e().floatValue() * 1000.0f) / this.f31953b.r().c();
        }
        if (this.f31954c.b() != 0.0f) {
            f2 /= this.f31954c.b();
        }
        float c2 = f2 - this.f31954c.c();
        for (int size = this.f31965f.size() - 1; size >= 0; size--) {
            this.f31965f.get(size).a(c2);
        }
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.f31966g.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f31965f.size() - 1; size >= 0; size--) {
            this.f31965f.get(size).a(this.f31966g, this.f31952a);
            if (rectF.isEmpty()) {
                rectF.set(this.f31966g);
            } else {
                rectF.set(Math.min(rectF.left, this.f31966g.left), Math.min(rectF.top, this.f31966g.top), Math.max(rectF.right, this.f31966g.right), Math.max(rectF.bottom, this.f31966g.bottom));
            }
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i) {
        com.ksad.lottie.c.c("CompositionLayer#draw");
        canvas.save();
        this.f31967h.set(0.0f, 0.0f, this.f31954c.h(), this.f31954c.i());
        matrix.mapRect(this.f31967h);
        for (int size = this.f31965f.size() - 1; size >= 0; size--) {
            if (!this.f31967h.isEmpty() ? canvas.clipRect(this.f31967h) : true) {
                this.f31965f.get(size).a(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.ksad.lottie.c.d("CompositionLayer#draw");
    }
}
