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
/* loaded from: classes16.dex */
public class o implements d, i, j, l, a.InterfaceC0947a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> oHN;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> oHO;
    private final com.tb.airbnb.lottie.a.b.o oHP;
    private c oHQ;
    private final com.tb.airbnb.lottie.model.layer.a oHq;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.g gVar) {
        this.lottieDrawable = fVar;
        this.oHq = aVar;
        this.name = gVar.getName();
        this.oHN = gVar.elz().ekW();
        aVar.a(this.oHN);
        this.oHN.b(this);
        this.oHO = gVar.elA().ekW();
        aVar.a(this.oHO);
        this.oHO.b(this);
        this.oHP = gVar.elB().elf();
        this.oHP.a(aVar);
        this.oHP.a(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.oHQ == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.oHQ = new c(this.lottieDrawable, this.oHq, "Repeater", arrayList, null);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.oHQ.b(list, list2);
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path iW() {
        Path iW = this.oHQ.iW();
        this.path.reset();
        float floatValue = this.oHN.getValue().floatValue();
        float floatValue2 = this.oHO.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.oHP.i(i + floatValue2));
            this.path.addPath(iW, this.matrix);
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.oHN.getValue().floatValue();
        float floatValue2 = this.oHO.getValue().floatValue();
        float floatValue3 = this.oHP.ekS().getValue().floatValue() / 100.0f;
        float floatValue4 = this.oHP.ekT().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.oHP.i(i2 + floatValue2));
            this.oHQ.a(canvas, this.matrix, (int) (i * com.tb.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.oHQ.a(rectF, matrix);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0947a
    public void iT() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (!this.oHP.b(t, cVar)) {
            if (t == com.tb.airbnb.lottie.j.Ch) {
                this.oHN.a(cVar);
            } else if (t == com.tb.airbnb.lottie.j.Ci) {
                this.oHO.a(cVar);
            }
        }
    }
}
