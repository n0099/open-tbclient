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
    public final Matrix f41668a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    public final Path f41669b = new Path();

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.f f41670c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.u.k.a f41671d;

    /* renamed from: e  reason: collision with root package name */
    public final String f41672e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f41673f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.s.c.a<Float, Float> f41674g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.a.s.c.a<Float, Float> f41675h;
    public final d.a.a.s.c.o i;
    public d j;

    public p(d.a.a.f fVar, d.a.a.u.k.a aVar, d.a.a.u.j.g gVar) {
        this.f41670c = fVar;
        this.f41671d = aVar;
        this.f41672e = gVar.c();
        this.f41673f = gVar.f();
        d.a.a.s.c.a<Float, Float> a2 = gVar.b().a();
        this.f41674g = a2;
        aVar.i(a2);
        this.f41674g.a(this);
        d.a.a.s.c.a<Float, Float> a3 = gVar.d().a();
        this.f41675h = a3;
        aVar.i(a3);
        this.f41675h.a(this);
        d.a.a.s.c.o b2 = gVar.e().b();
        this.i = b2;
        b2.a(aVar);
        this.i.b(this);
    }

    @Override // d.a.a.s.c.a.b
    public void a() {
        this.f41670c.invalidateSelf();
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
            this.f41674g.m(cVar);
        } else if (t == d.a.a.k.r) {
            this.f41675h.m(cVar);
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
        this.j = new d(this.f41670c, this.f41671d, "Repeater", this.f41673f, arrayList, null);
    }

    @Override // d.a.a.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        float floatValue = this.f41674g.h().floatValue();
        float floatValue2 = this.f41675h.h().floatValue();
        float floatValue3 = this.i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.i.e().h().floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f41668a.set(matrix);
            float f2 = i2;
            this.f41668a.preConcat(this.i.g(f2 + floatValue2));
            this.j.g(canvas, this.f41668a, (int) (i * d.a.a.x.g.k(floatValue3, floatValue4, f2 / floatValue)));
        }
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.f41672e;
    }

    @Override // d.a.a.s.b.m
    public Path getPath() {
        Path path = this.j.getPath();
        this.f41669b.reset();
        float floatValue = this.f41674g.h().floatValue();
        float floatValue2 = this.f41675h.h().floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f41668a.set(this.i.g(i + floatValue2));
            this.f41669b.addPath(path, this.f41668a);
        }
        return this.f41669b;
    }
}
