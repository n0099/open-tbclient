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
/* loaded from: classes6.dex */
public class o implements d, i, j, l, a.InterfaceC0366a {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f31553a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final Path f31554b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f31555c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f31556d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31557e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Float, Float> f31558f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Float, Float> f31559g;

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.a.b.o f31560h;
    public c i;

    public o(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.g gVar) {
        this.f31555c = fVar;
        this.f31556d = aVar;
        this.f31557e = gVar.a();
        com.ksad.lottie.a.b.a<Float, Float> a2 = gVar.b().a();
        this.f31558f = a2;
        aVar.a(a2);
        this.f31558f.a(this);
        com.ksad.lottie.a.b.a<Float, Float> a3 = gVar.c().a();
        this.f31559g = a3;
        aVar.a(a3);
        this.f31559g.a(this);
        com.ksad.lottie.a.b.o h2 = gVar.d().h();
        this.f31560h = h2;
        h2.a(aVar);
        this.f31560h.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0366a
    public void a() {
        this.f31555c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.f31558f.e().floatValue();
        float floatValue2 = this.f31559g.e().floatValue();
        float floatValue3 = this.f31560h.b().e().floatValue() / 100.0f;
        float floatValue4 = this.f31560h.c().e().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f31553a.set(matrix);
            float f2 = i2;
            this.f31553a.preConcat(this.f31560h.b(f2 + floatValue2));
            this.i.a(canvas, this.f31553a, (int) (i * com.ksad.lottie.d.e.a(floatValue3, floatValue4, f2 / floatValue)));
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
        this.i = new c(this.f31555c, this.f31556d, "Repeater", arrayList, null);
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        Path d2 = this.i.d();
        this.f31554b.reset();
        float floatValue = this.f31558f.e().floatValue();
        float floatValue2 = this.f31559g.e().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f31553a.set(this.f31560h.b(i + floatValue2));
            this.f31554b.addPath(d2, this.f31553a);
        }
        return this.f31554b;
    }
}
