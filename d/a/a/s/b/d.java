package d.a.a.s.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import d.a.a.s.c.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d implements e, m, a.b, d.a.a.u.e {

    /* renamed from: a  reason: collision with root package name */
    public Paint f41612a;

    /* renamed from: b  reason: collision with root package name */
    public RectF f41613b;

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f41614c;

    /* renamed from: d  reason: collision with root package name */
    public final Path f41615d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f41616e;

    /* renamed from: f  reason: collision with root package name */
    public final String f41617f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f41618g;

    /* renamed from: h  reason: collision with root package name */
    public final List<c> f41619h;
    public final d.a.a.f i;
    @Nullable
    public List<m> j;
    @Nullable
    public d.a.a.s.c.o k;

    public d(d.a.a.f fVar, d.a.a.u.k.a aVar, d.a.a.u.j.j jVar) {
        this(fVar, aVar, jVar.c(), jVar.d(), f(fVar, aVar, jVar.b()), h(jVar.b()));
    }

    public static List<c> f(d.a.a.f fVar, d.a.a.u.k.a aVar, List<d.a.a.u.j.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            c a2 = list.get(i).a(fVar, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    @Nullable
    public static d.a.a.u.i.l h(List<d.a.a.u.j.b> list) {
        for (int i = 0; i < list.size(); i++) {
            d.a.a.u.j.b bVar = list.get(i);
            if (bVar instanceof d.a.a.u.i.l) {
                return (d.a.a.u.i.l) bVar;
            }
        }
        return null;
    }

    @Override // d.a.a.s.c.a.b
    public void a() {
        this.i.invalidateSelf();
    }

    @Override // d.a.a.s.b.c
    public void b(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f41619h.size());
        arrayList.addAll(list);
        for (int size = this.f41619h.size() - 1; size >= 0; size--) {
            c cVar = this.f41619h.get(size);
            cVar.b(arrayList, this.f41619h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // d.a.a.u.e
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        d.a.a.s.c.o oVar = this.k;
        if (oVar != null) {
            oVar.c(t, cVar);
        }
    }

    @Override // d.a.a.u.e
    public void d(d.a.a.u.d dVar, int i, List<d.a.a.u.d> list, d.a.a.u.d dVar2) {
        if (dVar.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.a(getName());
                if (dVar.c(getName(), i)) {
                    list.add(dVar2.i(this));
                }
            }
            if (dVar.h(getName(), i)) {
                int e2 = i + dVar.e(getName(), i);
                for (int i2 = 0; i2 < this.f41619h.size(); i2++) {
                    c cVar = this.f41619h.get(i2);
                    if (cVar instanceof d.a.a.u.e) {
                        ((d.a.a.u.e) cVar).d(dVar, e2, list, dVar2);
                    }
                }
            }
        }
    }

    @Override // d.a.a.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.f41614c.set(matrix);
        d.a.a.s.c.o oVar = this.k;
        if (oVar != null) {
            this.f41614c.preConcat(oVar.f());
        }
        this.f41616e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f41619h.size() - 1; size >= 0; size--) {
            c cVar = this.f41619h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).e(this.f41616e, this.f41614c, z);
                rectF.union(this.f41616e);
            }
        }
    }

    @Override // d.a.a.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (this.f41618g) {
            return;
        }
        this.f41614c.set(matrix);
        d.a.a.s.c.o oVar = this.k;
        if (oVar != null) {
            this.f41614c.preConcat(oVar.f());
            i = (int) (((((this.k.h() == null ? 100 : this.k.h().h().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.i.K() && k() && i != 255;
        if (z) {
            this.f41613b.set(0.0f, 0.0f, 0.0f, 0.0f);
            e(this.f41613b, this.f41614c, true);
            this.f41612a.setAlpha(i);
            d.a.a.x.h.m(canvas, this.f41613b, this.f41612a);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.f41619h.size() - 1; size >= 0; size--) {
            c cVar = this.f41619h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).g(canvas, this.f41614c, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.f41617f;
    }

    @Override // d.a.a.s.b.m
    public Path getPath() {
        this.f41614c.reset();
        d.a.a.s.c.o oVar = this.k;
        if (oVar != null) {
            this.f41614c.set(oVar.f());
        }
        this.f41615d.reset();
        if (this.f41618g) {
            return this.f41615d;
        }
        for (int size = this.f41619h.size() - 1; size >= 0; size--) {
            c cVar = this.f41619h.get(size);
            if (cVar instanceof m) {
                this.f41615d.addPath(((m) cVar).getPath(), this.f41614c);
            }
        }
        return this.f41615d;
    }

    public List<m> i() {
        if (this.j == null) {
            this.j = new ArrayList();
            for (int i = 0; i < this.f41619h.size(); i++) {
                c cVar = this.f41619h.get(i);
                if (cVar instanceof m) {
                    this.j.add((m) cVar);
                }
            }
        }
        return this.j;
    }

    public Matrix j() {
        d.a.a.s.c.o oVar = this.k;
        if (oVar != null) {
            return oVar.f();
        }
        this.f41614c.reset();
        return this.f41614c;
    }

    public final boolean k() {
        int i = 0;
        for (int i2 = 0; i2 < this.f41619h.size(); i2++) {
            if ((this.f41619h.get(i2) instanceof e) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public d(d.a.a.f fVar, d.a.a.u.k.a aVar, String str, boolean z, List<c> list, @Nullable d.a.a.u.i.l lVar) {
        this.f41612a = new d.a.a.s.a();
        this.f41613b = new RectF();
        this.f41614c = new Matrix();
        this.f41615d = new Path();
        this.f41616e = new RectF();
        this.f41617f = str;
        this.i = fVar;
        this.f41618g = z;
        this.f41619h = list;
        if (lVar != null) {
            d.a.a.s.c.o b2 = lVar.b();
            this.k = b2;
            b2.a(aVar);
            this.k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).f(list.listIterator(list.size()));
        }
    }
}
