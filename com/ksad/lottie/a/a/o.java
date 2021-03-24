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
public class o implements d, i, j, l, a.InterfaceC0351a {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f31263a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final Path f31264b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f31265c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f31266d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31267e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Float, Float> f31268f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Float, Float> f31269g;

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.a.b.o f31270h;
    public c i;

    public o(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.g gVar) {
        this.f31265c = fVar;
        this.f31266d = aVar;
        this.f31267e = gVar.a();
        com.ksad.lottie.a.b.a<Float, Float> a2 = gVar.b().a();
        this.f31268f = a2;
        aVar.a(a2);
        this.f31268f.a(this);
        com.ksad.lottie.a.b.a<Float, Float> a3 = gVar.c().a();
        this.f31269g = a3;
        aVar.a(a3);
        this.f31269g.a(this);
        com.ksad.lottie.a.b.o h2 = gVar.d().h();
        this.f31270h = h2;
        h2.a(aVar);
        this.f31270h.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0351a
    public void a() {
        this.f31265c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.f31268f.e().floatValue();
        float floatValue2 = this.f31269g.e().floatValue();
        float floatValue3 = this.f31270h.b().e().floatValue() / 100.0f;
        float floatValue4 = this.f31270h.c().e().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f31263a.set(matrix);
            float f2 = i2;
            this.f31263a.preConcat(this.f31270h.b(f2 + floatValue2));
            this.i.a(canvas, this.f31263a, (int) (i * com.ksad.lottie.d.e.a(floatValue3, floatValue4, f2 / floatValue)));
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
        this.i = new c(this.f31265c, this.f31266d, "Repeater", arrayList, null);
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        Path d2 = this.i.d();
        this.f31264b.reset();
        float floatValue = this.f31268f.e().floatValue();
        float floatValue2 = this.f31269g.e().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f31263a.set(this.f31270h.b(i + floatValue2));
            this.f31264b.addPath(d2, this.f31263a);
        }
        return this.f31264b;
    }
}
