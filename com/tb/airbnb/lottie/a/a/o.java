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
public class o implements d, i, j, l, a.InterfaceC0874a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> nOA;
    private final com.tb.airbnb.lottie.a.b.o nOB;
    private c nOC;
    private final com.tb.airbnb.lottie.model.layer.a nOc;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> nOz;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.g gVar) {
        this.lottieDrawable = fVar;
        this.nOc = aVar;
        this.name = gVar.getName();
        this.nOz = gVar.dRF().dRc();
        aVar.a(this.nOz);
        this.nOz.b(this);
        this.nOA = gVar.dRG().dRc();
        aVar.a(this.nOA);
        this.nOA.b(this);
        this.nOB = gVar.dRH().dRl();
        this.nOB.a(aVar);
        this.nOB.a(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.nOC == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.nOC = new c(this.lottieDrawable, this.nOc, "Repeater", arrayList, null);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.nOC.b(list, list2);
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path ht() {
        Path ht = this.nOC.ht();
        this.path.reset();
        float floatValue = this.nOz.getValue().floatValue();
        float floatValue2 = this.nOA.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.nOB.i(i + floatValue2));
            this.path.addPath(ht, this.matrix);
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.nOz.getValue().floatValue();
        float floatValue2 = this.nOA.getValue().floatValue();
        float floatValue3 = this.nOB.dQY().getValue().floatValue() / 100.0f;
        float floatValue4 = this.nOB.dQZ().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.nOB.i(i2 + floatValue2));
            this.nOC.a(canvas, this.matrix, (int) (i * com.tb.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.nOC.a(rectF, matrix);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0874a
    public void hq() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (!this.nOB.b(t, cVar)) {
            if (t == com.tb.airbnb.lottie.j.Bm) {
                this.nOz.a(cVar);
            } else if (t == com.tb.airbnb.lottie.j.Bn) {
                this.nOA.a(cVar);
            }
        }
    }
}
