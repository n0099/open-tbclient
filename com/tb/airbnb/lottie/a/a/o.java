package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes5.dex */
public class o implements d, i, j, l, a.InterfaceC0730a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a noZ;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> npw;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> npx;
    private final com.tb.airbnb.lottie.a.b.o npy;
    private c npz;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.g gVar) {
        this.lottieDrawable = fVar;
        this.noZ = aVar;
        this.name = gVar.getName();
        this.npw = gVar.dGj().dFG();
        aVar.a(this.npw);
        this.npw.b(this);
        this.npx = gVar.dGk().dFG();
        aVar.a(this.npx);
        this.npx.b(this);
        this.npy = gVar.dGl().dFP();
        this.npy.a(aVar);
        this.npy.a(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.npz == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.npz = new c(this.lottieDrawable, this.noZ, "Repeater", arrayList, null);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.npz.b(list, list2);
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path bF() {
        Path bF = this.npz.bF();
        this.path.reset();
        float floatValue = this.npw.getValue().floatValue();
        float floatValue2 = this.npx.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.npy.j(i + floatValue2));
            this.path.addPath(bF, this.matrix);
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.npw.getValue().floatValue();
        float floatValue2 = this.npx.getValue().floatValue();
        float floatValue3 = this.npy.dFC().getValue().floatValue() / 100.0f;
        float floatValue4 = this.npy.dFD().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.npy.j(i2 + floatValue2));
            this.npz.a(canvas, this.matrix, (int) (i * com.tb.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.npz.a(rectF, matrix);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0730a
    public void bC() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (!this.npy.b(t, cVar)) {
            if (t == com.tb.airbnb.lottie.j.eW) {
                this.npw.a(cVar);
            } else if (t == com.tb.airbnb.lottie.j.eX) {
                this.npx.a(cVar);
            }
        }
    }
}
