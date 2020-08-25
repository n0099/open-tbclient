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
    private final com.tb.airbnb.lottie.model.layer.a ohY;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> oiv;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> oiw;
    private final com.tb.airbnb.lottie.a.b.o oix;
    private c oiy;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.g gVar) {
        this.lottieDrawable = fVar;
        this.ohY = aVar;
        this.name = gVar.getName();
        this.oiv = gVar.edI().edf();
        aVar.a(this.oiv);
        this.oiv.b(this);
        this.oiw = gVar.edJ().edf();
        aVar.a(this.oiw);
        this.oiw.b(this);
        this.oix = gVar.edK().edo();
        this.oix.a(aVar);
        this.oix.a(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.oiy == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.oiy = new c(this.lottieDrawable, this.ohY, "Repeater", arrayList, null);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.oiy.b(list, list2);
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path iU() {
        Path iU = this.oiy.iU();
        this.path.reset();
        float floatValue = this.oiv.getValue().floatValue();
        float floatValue2 = this.oiw.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.oix.i(i + floatValue2));
            this.path.addPath(iU, this.matrix);
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.oiv.getValue().floatValue();
        float floatValue2 = this.oiw.getValue().floatValue();
        float floatValue3 = this.oix.edb().getValue().floatValue() / 100.0f;
        float floatValue4 = this.oix.edc().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.oix.i(i2 + floatValue2));
            this.oiy.a(canvas, this.matrix, (int) (i * com.tb.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.oiy.a(rectF, matrix);
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
        if (!this.oix.b(t, cVar)) {
            if (t == com.tb.airbnb.lottie.j.BQ) {
                this.oiv.a(cVar);
            } else if (t == com.tb.airbnb.lottie.j.BR) {
                this.oiw.a(cVar);
            }
        }
    }
}
