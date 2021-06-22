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
    public com.ksad.lottie.a.b.a<Float, Float> f32217e;

    /* renamed from: f  reason: collision with root package name */
    public final List<a> f32218f;

    /* renamed from: g  reason: collision with root package name */
    public final RectF f32219g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f32220h;

    /* renamed from: com.ksad.lottie.model.layer.b$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32221a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f32221a = iArr;
            try {
                iArr[Layer.MatteType.Add.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32221a[Layer.MatteType.Invert.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(com.ksad.lottie.f fVar, Layer layer, List<Layer> list, com.ksad.lottie.d dVar) {
        super(fVar, layer);
        int i2;
        a aVar;
        this.f32218f = new ArrayList();
        this.f32219g = new RectF();
        this.f32220h = new RectF();
        com.ksad.lottie.model.a.b u = layer.u();
        if (u != null) {
            com.ksad.lottie.a.b.a<Float, Float> a2 = u.a();
            this.f32217e = a2;
            a(a2);
            this.f32217e.a(this);
        } else {
            this.f32217e = null;
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
                    this.f32218f.add(0, a3);
                    int i3 = AnonymousClass1.f32221a[layer2.l().ordinal()];
                    if (i3 == 1 || i3 == 2) {
                        aVar2 = a3;
                    }
                }
            }
            size--;
        }
        for (i2 = 0; i2 < longSparseArray.size(); i2++) {
            a aVar3 = (a) longSparseArray.get(longSparseArray.keyAt(i2));
            if (aVar3 != null && (aVar = (a) longSparseArray.get(aVar3.b().m())) != null) {
                aVar3.b(aVar);
            }
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        super.a(f2);
        if (this.f32217e != null) {
            f2 = (this.f32217e.e().floatValue() * 1000.0f) / this.f32205b.r().c();
        }
        if (this.f32206c.b() != 0.0f) {
            f2 /= this.f32206c.b();
        }
        float c2 = f2 - this.f32206c.c();
        for (int size = this.f32218f.size() - 1; size >= 0; size--) {
            this.f32218f.get(size).a(c2);
        }
    }

    @Override // com.ksad.lottie.model.layer.a, com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.f32219g.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f32218f.size() - 1; size >= 0; size--) {
            this.f32218f.get(size).a(this.f32219g, this.f32204a);
            if (rectF.isEmpty()) {
                rectF.set(this.f32219g);
            } else {
                rectF.set(Math.min(rectF.left, this.f32219g.left), Math.min(rectF.top, this.f32219g.top), Math.max(rectF.right, this.f32219g.right), Math.max(rectF.bottom, this.f32219g.bottom));
            }
        }
    }

    @Override // com.ksad.lottie.model.layer.a
    public void b(Canvas canvas, Matrix matrix, int i2) {
        com.ksad.lottie.c.c("CompositionLayer#draw");
        canvas.save();
        this.f32220h.set(0.0f, 0.0f, this.f32206c.h(), this.f32206c.i());
        matrix.mapRect(this.f32220h);
        for (int size = this.f32218f.size() - 1; size >= 0; size--) {
            if (!this.f32220h.isEmpty() ? canvas.clipRect(this.f32220h) : true) {
                this.f32218f.get(size).a(canvas, matrix, i2);
            }
        }
        canvas.restore();
        com.ksad.lottie.c.d("CompositionLayer#draw");
    }
}
