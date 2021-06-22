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
public class o implements d, i, j, l, a.InterfaceC0355a {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f31889a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final Path f31890b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f31891c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f31892d;

    /* renamed from: e  reason: collision with root package name */
    public final String f31893e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Float, Float> f31894f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Float, Float> f31895g;

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.a.b.o f31896h;

    /* renamed from: i  reason: collision with root package name */
    public c f31897i;

    public o(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.g gVar) {
        this.f31891c = fVar;
        this.f31892d = aVar;
        this.f31893e = gVar.a();
        com.ksad.lottie.a.b.a<Float, Float> a2 = gVar.b().a();
        this.f31894f = a2;
        aVar.a(a2);
        this.f31894f.a(this);
        com.ksad.lottie.a.b.a<Float, Float> a3 = gVar.c().a();
        this.f31895g = a3;
        aVar.a(a3);
        this.f31895g.a(this);
        com.ksad.lottie.a.b.o h2 = gVar.d().h();
        this.f31896h = h2;
        h2.a(aVar);
        this.f31896h.a(this);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0355a
    public void a() {
        this.f31891c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        float floatValue = this.f31894f.e().floatValue();
        float floatValue2 = this.f31895g.e().floatValue();
        float floatValue3 = this.f31896h.b().e().floatValue() / 100.0f;
        float floatValue4 = this.f31896h.c().e().floatValue() / 100.0f;
        for (int i3 = ((int) floatValue) - 1; i3 >= 0; i3--) {
            this.f31889a.set(matrix);
            float f2 = i3;
            this.f31889a.preConcat(this.f31896h.b(f2 + floatValue2));
            this.f31897i.a(canvas, this.f31889a, (int) (i2 * com.ksad.lottie.d.e.a(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.f31897i.a(rectF, matrix);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        this.f31897i.a(list, list2);
    }

    @Override // com.ksad.lottie.a.a.i
    public void a(ListIterator<b> listIterator) {
        if (this.f31897i != null) {
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
        this.f31897i = new c(this.f31891c, this.f31892d, "Repeater", arrayList, null);
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        Path d2 = this.f31897i.d();
        this.f31890b.reset();
        float floatValue = this.f31894f.e().floatValue();
        float floatValue2 = this.f31895g.e().floatValue();
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f31889a.set(this.f31896h.b(i2 + floatValue2));
            this.f31890b.addPath(d2, this.f31889a);
        }
        return this.f31890b;
    }
}
