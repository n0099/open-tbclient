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
/* loaded from: classes17.dex */
public class o implements d, i, j, l, a.InterfaceC0929a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private c osA;
    private final com.tb.airbnb.lottie.model.layer.a osa;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> osx;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> osy;
    private final com.tb.airbnb.lottie.a.b.o osz;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.g gVar) {
        this.lottieDrawable = fVar;
        this.osa = aVar;
        this.name = gVar.getName();
        this.osx = gVar.ehO().ehl();
        aVar.a(this.osx);
        this.osx.b(this);
        this.osy = gVar.ehP().ehl();
        aVar.a(this.osy);
        this.osy.b(this);
        this.osz = gVar.ehQ().ehu();
        this.osz.a(aVar);
        this.osz.a(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.osA == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.osA = new c(this.lottieDrawable, this.osa, "Repeater", arrayList, null);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.osA.b(list, list2);
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path iV() {
        Path iV = this.osA.iV();
        this.path.reset();
        float floatValue = this.osx.getValue().floatValue();
        float floatValue2 = this.osy.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.osz.i(i + floatValue2));
            this.path.addPath(iV, this.matrix);
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.osx.getValue().floatValue();
        float floatValue2 = this.osy.getValue().floatValue();
        float floatValue3 = this.osz.ehh().getValue().floatValue() / 100.0f;
        float floatValue4 = this.osz.ehi().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.osz.i(i2 + floatValue2));
            this.osA.a(canvas, this.matrix, (int) (i * com.tb.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.osA.a(rectF, matrix);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0929a
    public void iS() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (!this.osz.b(t, cVar)) {
            if (t == com.tb.airbnb.lottie.j.BQ) {
                this.osx.a(cVar);
            } else if (t == com.tb.airbnb.lottie.j.BR) {
                this.osy.a(cVar);
            }
        }
    }
}
