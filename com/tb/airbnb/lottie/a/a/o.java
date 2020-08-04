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
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> nOB;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> nOC;
    private final com.tb.airbnb.lottie.a.b.o nOD;
    private c nOE;
    private final com.tb.airbnb.lottie.model.layer.a nOe;
    private final String name;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.g gVar) {
        this.lottieDrawable = fVar;
        this.nOe = aVar;
        this.name = gVar.getName();
        this.nOB = gVar.dRG().dRd();
        aVar.a(this.nOB);
        this.nOB.b(this);
        this.nOC = gVar.dRH().dRd();
        aVar.a(this.nOC);
        this.nOC.b(this);
        this.nOD = gVar.dRI().dRm();
        this.nOD.a(aVar);
        this.nOD.a(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.nOE == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.nOE = new c(this.lottieDrawable, this.nOe, "Repeater", arrayList, null);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.nOE.b(list, list2);
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path ht() {
        Path ht = this.nOE.ht();
        this.path.reset();
        float floatValue = this.nOB.getValue().floatValue();
        float floatValue2 = this.nOC.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.nOD.i(i + floatValue2));
            this.path.addPath(ht, this.matrix);
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.nOB.getValue().floatValue();
        float floatValue2 = this.nOC.getValue().floatValue();
        float floatValue3 = this.nOD.dQZ().getValue().floatValue() / 100.0f;
        float floatValue4 = this.nOD.dRa().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.nOD.i(i2 + floatValue2));
            this.nOE.a(canvas, this.matrix, (int) (i * com.tb.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.nOE.a(rectF, matrix);
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
        if (!this.nOD.b(t, cVar)) {
            if (t == com.tb.airbnb.lottie.j.Bm) {
                this.nOB.a(cVar);
            } else if (t == com.tb.airbnb.lottie.j.Bn) {
                this.nOC.a(cVar);
            }
        }
    }
}
