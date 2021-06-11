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
public class o implements d, i, j, l, a.InterfaceC0352a {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f31791a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final Path f31792b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f31793c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f31794d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31795e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Float, Float> f31796f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Float, Float> f31797g;

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.a.b.o f31798h;

    /* renamed from: i  reason: collision with root package name */
    public c f31799i;

    public o(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.g gVar) {
        this.f31793c = fVar;
        this.f31794d = aVar;
        this.f31795e = gVar.a();
        com.ksad.lottie.a.b.a<Float, Float> a2 = gVar.b().a();
        this.f31796f = a2;
        aVar.a(a2);
        this.f31796f.a(this);
        com.ksad.lottie.a.b.a<Float, Float> a3 = gVar.c().a();
        this.f31797g = a3;
        aVar.a(a3);
        this.f31797g.a(this);
        com.ksad.lottie.a.b.o h2 = gVar.d().h();
        this.f31798h = h2;
        h2.a(aVar);
        this.f31798h.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0352a
    public void a() {
        this.f31793c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        float floatValue = this.f31796f.e().floatValue();
        float floatValue2 = this.f31797g.e().floatValue();
        float floatValue3 = this.f31798h.b().e().floatValue() / 100.0f;
        float floatValue4 = this.f31798h.c().e().floatValue() / 100.0f;
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.f31791a.set(matrix);
            float f2 = i3;
            this.f31791a.preConcat(this.f31798h.b(f2 + floatValue2));
            this.f31799i.a(canvas, this.f31791a, (int) (i2 * com.ksad.lottie.d.e.a(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.f31799i.a(rectF, matrix);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        this.f31799i.a(list, list2);
    }

    @Override // com.ksad.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.f31799i != null) {
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
        this.f31799i = new c(this.f31793c, this.f31794d, "Repeater", arrayList, null);
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        Path d2 = this.f31799i.d();
        this.f31792b.reset();
        float floatValue = this.f31796f.e().floatValue();
        float floatValue2 = this.f31797g.e().floatValue();
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f31791a.set(this.f31798h.b(i2 + floatValue2));
            this.f31792b.addPath(d2, this.f31791a);
        }
        return this.f31792b;
    }
}
