package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.ksad.lottie.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes3.dex */
public class o implements d, i, j, l, a.InterfaceC1065a {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f7952a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f7953b = new Path();
    private final com.ksad.lottie.f c;
    private final com.ksad.lottie.model.layer.a d;
    private final String e;
    private final com.ksad.lottie.a.b.a<Float, Float> f;
    private final com.ksad.lottie.a.b.a<Float, Float> g;
    private final com.ksad.lottie.a.b.o h;
    private c i;

    public o(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.g gVar) {
        this.c = fVar;
        this.d = aVar;
        this.e = gVar.a();
        this.f = gVar.b().a();
        aVar.a(this.f);
        this.f.a(this);
        this.g = gVar.c().a();
        aVar.a(this.g);
        this.g.a(this);
        this.h = gVar.d().h();
        this.h.a(aVar);
        this.h.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC1065a
    public void a() {
        this.c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.f.e().floatValue();
        float floatValue2 = this.g.e().floatValue();
        float floatValue3 = this.h.b().e().floatValue() / 100.0f;
        float floatValue4 = this.h.c().e().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f7952a.set(matrix);
            this.f7952a.preConcat(this.h.b(i2 + floatValue2));
            this.i.a(canvas, this.f7952a, (int) (i * com.ksad.lottie.d.e.a(floatValue3, floatValue4, i2 / floatValue)));
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.i.a(rectF, matrix);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        this.i.a(list, list2);
    }

    @Override // com.ksad.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.i != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.i = new c(this.c, this.d, "Repeater", arrayList, null);
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        Path d = this.i.d();
        this.f7953b.reset();
        float floatValue = this.f.e().floatValue();
        float floatValue2 = this.g.e().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f7952a.set(this.h.b(i + floatValue2));
            this.f7953b.addPath(d, this.f7952a);
        }
        return this.f7953b;
    }
}
