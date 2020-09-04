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
/* loaded from: classes7.dex */
public class o implements d, i, j, l, a.InterfaceC0932a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> oiN;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> oiO;
    private final com.tb.airbnb.lottie.a.b.o oiP;
    private c oiQ;
    private final com.tb.airbnb.lottie.model.layer.a oiq;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.g gVar) {
        this.lottieDrawable = fVar;
        this.oiq = aVar;
        this.name = gVar.getName();
        this.oiN = gVar.edR().edo();
        aVar.a(this.oiN);
        this.oiN.b(this);
        this.oiO = gVar.edS().edo();
        aVar.a(this.oiO);
        this.oiO.b(this);
        this.oiP = gVar.edT().edx();
        this.oiP.a(aVar);
        this.oiP.a(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.oiQ == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.oiQ = new c(this.lottieDrawable, this.oiq, "Repeater", arrayList, null);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.oiQ.b(list, list2);
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path iU() {
        Path iU = this.oiQ.iU();
        this.path.reset();
        float floatValue = this.oiN.getValue().floatValue();
        float floatValue2 = this.oiO.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.oiP.i(i + floatValue2));
            this.path.addPath(iU, this.matrix);
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.oiN.getValue().floatValue();
        float floatValue2 = this.oiO.getValue().floatValue();
        float floatValue3 = this.oiP.edk().getValue().floatValue() / 100.0f;
        float floatValue4 = this.oiP.edl().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.oiP.i(i2 + floatValue2));
            this.oiQ.a(canvas, this.matrix, (int) (i * com.tb.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.oiQ.a(rectF, matrix);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0932a
    public void iR() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (!this.oiP.b(t, cVar)) {
            if (t == com.tb.airbnb.lottie.j.BQ) {
                this.oiN.a(cVar);
            } else if (t == com.tb.airbnb.lottie.j.BR) {
                this.oiO.a(cVar);
            }
        }
    }
}
