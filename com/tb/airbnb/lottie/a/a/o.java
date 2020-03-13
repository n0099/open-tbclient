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
public class o implements d, i, j, l, a.InterfaceC0738a {
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final String name;
    private final com.tb.airbnb.lottie.model.layer.a npO;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> nql;
    private final com.tb.airbnb.lottie.a.b.a<Float, Float> nqm;
    private final com.tb.airbnb.lottie.a.b.o nqn;
    private c nqo;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public o(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.g gVar) {
        this.lottieDrawable = fVar;
        this.npO = aVar;
        this.name = gVar.getName();
        this.nql = gVar.dHt().dGQ();
        aVar.a(this.nql);
        this.nql.b(this);
        this.nqm = gVar.dHu().dGQ();
        aVar.a(this.nqm);
        this.nqm.b(this);
        this.nqn = gVar.dHv().dGZ();
        this.nqn.a(aVar);
        this.nqn.a(this);
    }

    @Override // com.tb.airbnb.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.nqo == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.nqo = new c(this.lottieDrawable, this.npO, "Repeater", arrayList, null);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        this.nqo.b(list, list2);
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path bG() {
        Path bG = this.nqo.bG();
        this.path.reset();
        float floatValue = this.nql.getValue().floatValue();
        float floatValue2 = this.nqm.getValue().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.nqn.j(i + floatValue2));
            this.path.addPath(bG, this.matrix);
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.nql.getValue().floatValue();
        float floatValue2 = this.nqm.getValue().floatValue();
        float floatValue3 = this.nqn.dGM().getValue().floatValue() / 100.0f;
        float floatValue4 = this.nqn.dGN().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            this.matrix.preConcat(this.nqn.j(i2 + floatValue2));
            this.nqo.a(canvas, this.matrix, (int) (i * com.tb.airbnb.lottie.d.e.lerp(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.nqo.a(rectF, matrix);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0738a
    public void bD() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (!this.nqn.b(t, cVar)) {
            if (t == com.tb.airbnb.lottie.j.eZ) {
                this.nql.a(cVar);
            } else if (t == com.tb.airbnb.lottie.j.fb) {
                this.nqm.a(cVar);
            }
        }
    }
}
