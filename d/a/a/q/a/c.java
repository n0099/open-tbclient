package d.a.a.q.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import d.a.a.q.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements d, l, a.InterfaceC0528a, d.a.a.s.f {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f41212a;

    /* renamed from: b  reason: collision with root package name */
    public final Path f41213b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f41214c;

    /* renamed from: d  reason: collision with root package name */
    public final String f41215d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b> f41216e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.f f41217f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public List<l> f41218g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public d.a.a.q.b.o f41219h;

    public c(d.a.a.f fVar, d.a.a.s.k.a aVar, d.a.a.s.j.j jVar) {
        this(fVar, aVar, jVar.c(), f(fVar, aVar, jVar.b()), h(jVar.b()));
    }

    public static List<b> f(d.a.a.f fVar, d.a.a.s.k.a aVar, List<d.a.a.s.j.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            b a2 = list.get(i).a(fVar, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    @Nullable
    public static d.a.a.s.i.l h(List<d.a.a.s.j.b> list) {
        for (int i = 0; i < list.size(); i++) {
            d.a.a.s.j.b bVar = list.get(i);
            if (bVar instanceof d.a.a.s.i.l) {
                return (d.a.a.s.i.l) bVar;
            }
        }
        return null;
    }

    @Override // d.a.a.q.b.a.InterfaceC0528a
    public void a() {
        this.f41217f.invalidateSelf();
    }

    @Override // d.a.a.q.a.b
    public void b(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f41216e.size());
        arrayList.addAll(list);
        for (int size = this.f41216e.size() - 1; size >= 0; size--) {
            b bVar = this.f41216e.get(size);
            bVar.b(arrayList, this.f41216e.subList(0, size));
            arrayList.add(bVar);
        }
    }

    @Override // d.a.a.q.a.d
    public void c(RectF rectF, Matrix matrix) {
        this.f41212a.set(matrix);
        d.a.a.q.b.o oVar = this.f41219h;
        if (oVar != null) {
            this.f41212a.preConcat(oVar.e());
        }
        this.f41214c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f41216e.size() - 1; size >= 0; size--) {
            b bVar = this.f41216e.get(size);
            if (bVar instanceof d) {
                ((d) bVar).c(this.f41214c, this.f41212a);
                if (rectF.isEmpty()) {
                    rectF.set(this.f41214c);
                } else {
                    rectF.set(Math.min(rectF.left, this.f41214c.left), Math.min(rectF.top, this.f41214c.top), Math.max(rectF.right, this.f41214c.right), Math.max(rectF.bottom, this.f41214c.bottom));
                }
            }
        }
    }

    @Override // d.a.a.s.f
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        d.a.a.q.b.o oVar = this.f41219h;
        if (oVar != null) {
            oVar.c(t, cVar);
        }
    }

    @Override // d.a.a.s.f
    public void e(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2) {
        if (eVar.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.c(getName(), i)) {
                    list.add(eVar2.i(this));
                }
            }
            if (eVar.h(getName(), i)) {
                int e2 = i + eVar.e(getName(), i);
                for (int i2 = 0; i2 < this.f41216e.size(); i2++) {
                    b bVar = this.f41216e.get(i2);
                    if (bVar instanceof d.a.a.s.f) {
                        ((d.a.a.s.f) bVar).e(eVar, e2, list, eVar2);
                    }
                }
            }
        }
    }

    @Override // d.a.a.q.a.d
    public void g(Canvas canvas, Matrix matrix, int i) {
        this.f41212a.set(matrix);
        d.a.a.q.b.o oVar = this.f41219h;
        if (oVar != null) {
            this.f41212a.preConcat(oVar.e());
            i = (int) ((((this.f41219h.g().h().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.f41216e.size() - 1; size >= 0; size--) {
            b bVar = this.f41216e.get(size);
            if (bVar instanceof d) {
                ((d) bVar).g(canvas, this.f41212a, i);
            }
        }
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.f41215d;
    }

    @Override // d.a.a.q.a.l
    public Path getPath() {
        this.f41212a.reset();
        d.a.a.q.b.o oVar = this.f41219h;
        if (oVar != null) {
            this.f41212a.set(oVar.e());
        }
        this.f41213b.reset();
        for (int size = this.f41216e.size() - 1; size >= 0; size--) {
            b bVar = this.f41216e.get(size);
            if (bVar instanceof l) {
                this.f41213b.addPath(((l) bVar).getPath(), this.f41212a);
            }
        }
        return this.f41213b;
    }

    public List<l> i() {
        if (this.f41218g == null) {
            this.f41218g = new ArrayList();
            for (int i = 0; i < this.f41216e.size(); i++) {
                b bVar = this.f41216e.get(i);
                if (bVar instanceof l) {
                    this.f41218g.add((l) bVar);
                }
            }
        }
        return this.f41218g;
    }

    public Matrix j() {
        d.a.a.q.b.o oVar = this.f41219h;
        if (oVar != null) {
            return oVar.e();
        }
        this.f41212a.reset();
        return this.f41212a;
    }

    public c(d.a.a.f fVar, d.a.a.s.k.a aVar, String str, List<b> list, @Nullable d.a.a.s.i.l lVar) {
        this.f41212a = new Matrix();
        this.f41213b = new Path();
        this.f41214c = new RectF();
        this.f41215d = str;
        this.f41217f = fVar;
        this.f41216e = list;
        if (lVar != null) {
            d.a.a.q.b.o b2 = lVar.b();
            this.f41219h = b2;
            b2.a(aVar);
            this.f41219h.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar = list.get(size);
            if (bVar instanceof i) {
                arrayList.add((i) bVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((i) arrayList.get(size2)).f(list.listIterator(list.size()));
        }
    }
}
