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
public class o implements d, i, j, l, a.InterfaceC1038a {
    private final com.tb.airbnb.lottie.g lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> pIE;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> pIF;
    private final com.tb.airbnb.lottie.a.b.o pIG;
    private c pIH;
    private final com.tb.airbnb.lottie.model.layer.a pIh;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.g gVar2) {
        this.lottieDrawable = gVar;
        this.pIh = aVar;
        this.name = gVar2.getName();
        this.pIE = gVar2.ezo().eyL();
        aVar.a(this.pIE);
        this.pIE.b(this);
        this.pIF = gVar2.ezp().eyL();
        aVar.a(this.pIF);
        this.pIF.b(this);
        this.pIG = gVar2.ezq().eyU();
        this.pIG.a(aVar);
        this.pIG.a(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.pIH == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.pIH = new c(this.lottieDrawable, this.pIh, "Repeater", arrayList, null);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.pIH.b(list, list2);
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path iW() {
        Path iW = this.pIH.iW();
        this.path.reset();
        float floatValue = this.pIE.getValue().floatValue();
        float floatValue2 = this.pIF.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.pIG.i(i + floatValue2));
            this.path.addPath(iW, this.matrix);
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.pIE.getValue().floatValue();
        float floatValue2 = this.pIF.getValue().floatValue();
        float floatValue3 = this.pIG.eyH().getValue().floatValue() / 100.0f;
        float floatValue4 = this.pIG.eyI().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.pIG.i(i2 + floatValue2));
            this.pIH.a(canvas, this.matrix, (int) (i * com.tb.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.pIH.a(rectF, matrix);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1038a
    public void iT() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (!this.pIG.b(t, cVar)) {
            if (t == com.tb.airbnb.lottie.k.Ch) {
                this.pIE.a(cVar);
            } else if (t == com.tb.airbnb.lottie.k.Ci) {
                this.pIF.a(cVar);
            }
        }
    }
}
