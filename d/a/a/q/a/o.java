package d.a.a.q.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import d.a.a.q.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes.dex */
public class o implements d, l, i, a.InterfaceC0528a, j {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f41268a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final Path f41269b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.f f41270c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.s.k.a f41271d;

    /* renamed from: e  reason: collision with root package name */
    public final String f41272e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.q.b.a<Float, Float> f41273f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.q.b.a<Float, Float> f41274g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.a.q.b.o f41275h;
    public c i;

    public o(d.a.a.f fVar, d.a.a.s.k.a aVar, d.a.a.s.j.g gVar) {
        this.f41270c = fVar;
        this.f41271d = aVar;
        this.f41272e = gVar.c();
        d.a.a.q.b.a<Float, Float> a2 = gVar.b().a();
        this.f41273f = a2;
        aVar.h(a2);
        this.f41273f.a(this);
        d.a.a.q.b.a<Float, Float> a3 = gVar.d().a();
        this.f41274g = a3;
        aVar.h(a3);
        this.f41274g.a(this);
        d.a.a.q.b.o b2 = gVar.e().b();
        this.f41275h = b2;
        b2.a(aVar);
        this.f41275h.b(this);
    }

    @Override // d.a.a.q.b.a.InterfaceC0528a
    public void a() {
        this.f41270c.invalidateSelf();
    }

    @Override // d.a.a.q.a.b
    public void b(List<b> list, List<b> list2) {
        this.i.b(list, list2);
    }

    @Override // d.a.a.q.a.d
    public void c(RectF rectF, Matrix matrix) {
        this.i.c(rectF, matrix);
    }

    @Override // d.a.a.s.f
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        if (this.f41275h.c(t, cVar)) {
            return;
        }
        if (t == d.a.a.j.m) {
            this.f41273f.m(cVar);
        } else if (t == d.a.a.j.n) {
            this.f41274g.m(cVar);
        }
    }

    @Override // d.a.a.s.f
    public void e(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2) {
        d.a.a.v.e.l(eVar, i, list, eVar2, this);
    }

    @Override // d.a.a.q.a.i
    public void f(ListIterator<b> listIterator) {
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
        this.i = new c(this.f41270c, this.f41271d, "Repeater", arrayList, null);
    }

    @Override // d.a.a.q.a.d
    public void g(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.f41273f.h().floatValue();
        float floatValue2 = this.f41274g.h().floatValue();
        float floatValue3 = this.f41275h.h().h().floatValue() / 100.0f;
        float floatValue4 = this.f41275h.d().h().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f41268a.set(matrix);
            float f2 = i2;
            this.f41268a.preConcat(this.f41275h.f(f2 + floatValue2));
            this.i.g(canvas, this.f41268a, (int) (i * d.a.a.v.e.j(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41272e;
    }

    @Override // d.a.a.q.a.l
    public Path getPath() {
        Path path = this.i.getPath();
        this.f41269b.reset();
        float floatValue = this.f41273f.h().floatValue();
        float floatValue2 = this.f41274g.h().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f41268a.set(this.f41275h.f(i + floatValue2));
            this.f41269b.addPath(path, this.f41268a);
        }
        return this.f41269b;
    }
}
