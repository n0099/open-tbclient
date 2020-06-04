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
/* loaded from: classes6.dex */
public class o implements d, i, j, l, a.InterfaceC0845a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a njC;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> njZ;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> nka;
    private final com.tb.airbnb.lottie.a.b.o nkb;
    private c nkc;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.g gVar) {
        this.lottieDrawable = fVar;
        this.njC = aVar;
        this.name = gVar.getName();
        this.njZ = gVar.dJz().dIW();
        aVar.a(this.njZ);
        this.njZ.b(this);
        this.nka = gVar.dJA().dIW();
        aVar.a(this.nka);
        this.nka.b(this);
        this.nkb = gVar.dJB().dJf();
        this.nkb.a(aVar);
        this.nkb.a(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.nkc == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.nkc = new c(this.lottieDrawable, this.njC, "Repeater", arrayList, null);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.nkc.b(list, list2);
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path hd() {
        Path hd = this.nkc.hd();
        this.path.reset();
        float floatValue = this.njZ.getValue().floatValue();
        float floatValue2 = this.nka.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.nkb.g(i + floatValue2));
            this.path.addPath(hd, this.matrix);
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.njZ.getValue().floatValue();
        float floatValue2 = this.nka.getValue().floatValue();
        float floatValue3 = this.nkb.dIS().getValue().floatValue() / 100.0f;
        float floatValue4 = this.nkb.dIT().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.nkb.g(i2 + floatValue2));
            this.nkc.a(canvas, this.matrix, (int) (i * com.tb.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.nkc.a(rectF, matrix);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0845a
    public void ha() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (!this.nkb.b(t, cVar)) {
            if (t == com.tb.airbnb.lottie.j.AH) {
                this.njZ.a(cVar);
            } else if (t == com.tb.airbnb.lottie.j.AI) {
                this.nka.a(cVar);
            }
        }
    }
}
