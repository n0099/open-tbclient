package d.a.a.s.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import d.a.a.s.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes.dex */
public class p implements e, m, j, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f41573a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final Path f41574b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.f f41575c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.u.k.a f41576d;

    /* renamed from: e  reason: collision with root package name */
    public final String f41577e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f41578f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.s.c.a<Float, Float> f41579g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.a.s.c.a<Float, Float> f41580h;
    public final d.a.a.s.c.o i;
    public d j;

    public p(d.a.a.f fVar, d.a.a.u.k.a aVar, d.a.a.u.j.g gVar) {
        this.f41575c = fVar;
        this.f41576d = aVar;
        this.f41577e = gVar.c();
        this.f41578f = gVar.f();
        d.a.a.s.c.a<Float, Float> a2 = gVar.b().a();
        this.f41579g = a2;
        aVar.i(a2);
        this.f41579g.a(this);
        d.a.a.s.c.a<Float, Float> a3 = gVar.d().a();
        this.f41580h = a3;
        aVar.i(a3);
        this.f41580h.a(this);
        d.a.a.s.c.o b2 = gVar.e().b();
        this.i = b2;
        b2.a(aVar);
        this.i.b(this);
    }

    @Override // d.a.a.s.c.a.b
    public void a() {
        this.f41575c.invalidateSelf();
    }

    @Override // d.a.a.s.b.c
    public void b(List<c> list, List<c> list2) {
        this.j.b(list, list2);
    }

    @Override // d.a.a.u.e
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        if (this.i.c(t, cVar)) {
            return;
        }
        if (t == d.a.a.k.q) {
            this.f41579g.m(cVar);
        } else if (t == d.a.a.k.r) {
            this.f41580h.m(cVar);
        }
    }

    @Override // d.a.a.u.e
    public void d(d.a.a.u.d dVar, int i, List<d.a.a.u.d> list, d.a.a.u.d dVar2) {
        d.a.a.x.g.m(dVar, i, list, dVar2, this);
    }

    @Override // d.a.a.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.j.e(rectF, matrix, z);
    }

    @Override // d.a.a.s.b.j
    public void f(ListIterator<c> listIterator) {
        if (this.j != null) {
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
        this.j = new d(this.f41575c, this.f41576d, "Repeater", this.f41578f, arrayList, null);
    }

    @Override // d.a.a.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.f41579g.h().floatValue();
        float floatValue2 = this.f41580h.h().floatValue();
        float floatValue3 = this.i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.i.e().h().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f41573a.set(matrix);
            float f2 = i2;
            this.f41573a.preConcat(this.i.g(f2 + floatValue2));
            this.j.g(canvas, this.f41573a, (int) (i * d.a.a.x.g.k(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.f41577e;
    }

    @Override // d.a.a.s.b.m
    public Path getPath() {
        Path path = this.j.getPath();
        this.f41574b.reset();
        float floatValue = this.f41579g.h().floatValue();
        float floatValue2 = this.f41580h.h().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f41573a.set(this.i.g(i + floatValue2));
            this.f41574b.addPath(path, this.f41573a);
        }
        return this.f41574b;
    }
}
