package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c implements d, l, a.InterfaceC0352a {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f31723a;

    /* renamed from: b  reason: collision with root package name */
    public final Path f31724b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f31725c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31726d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b> f31727e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.f f31728f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public List<l> f31729g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.ksad.lottie.a.b.o f31730h;

    public c(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.j jVar) {
        this(fVar, aVar, jVar.a(), a(fVar, aVar, jVar.b()), a(jVar.b()));
    }

    public c(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, String str, List<b> list, @Nullable com.ksad.lottie.model.a.l lVar) {
        this.f31723a = new Matrix();
        this.f31724b = new Path();
        this.f31725c = new RectF();
        this.f31726d = str;
        this.f31728f = fVar;
        this.f31727e = list;
        if (lVar != null) {
            com.ksad.lottie.a.b.o h2 = lVar.h();
            this.f31730h = h2;
            h2.a(aVar);
            this.f31730h.a(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar = list.get(size);
            if (bVar instanceof i) {
                arrayList.add((i) bVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((i) arrayList.get(size2)).a(list.listIterator(list.size()));
        }
    }

    @Nullable
    public static com.ksad.lottie.model.a.l a(List<com.ksad.lottie.model.content.b> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.ksad.lottie.model.content.b bVar = list.get(i2);
            if (bVar instanceof com.ksad.lottie.model.a.l) {
                return (com.ksad.lottie.model.a.l) bVar;
            }
        }
        return null;
    }

    public static List<b> a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, List<com.ksad.lottie.model.content.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            b a2 = list.get(i2).a(fVar, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0352a
    public void a() {
        this.f31728f.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        this.f31723a.set(matrix);
        com.ksad.lottie.a.b.o oVar = this.f31730h;
        if (oVar != null) {
            this.f31723a.preConcat(oVar.d());
            i2 = (int) ((((this.f31730h.a().e().intValue() / 100.0f) * i2) / 255.0f) * 255.0f);
        }
        for (int size = this.f31727e.size() - 1; size >= 0; size--) {
            b bVar = this.f31727e.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(canvas, this.f31723a, i2);
            }
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.f31723a.set(matrix);
        com.ksad.lottie.a.b.o oVar = this.f31730h;
        if (oVar != null) {
            this.f31723a.preConcat(oVar.d());
        }
        this.f31725c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f31727e.size() - 1; size >= 0; size--) {
            b bVar = this.f31727e.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(this.f31725c, this.f31723a);
                if (rectF.isEmpty()) {
                    rectF.set(this.f31725c);
                } else {
                    rectF.set(Math.min(rectF.left, this.f31725c.left), Math.min(rectF.top, this.f31725c.top), Math.max(rectF.right, this.f31725c.right), Math.max(rectF.bottom, this.f31725c.bottom));
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f31727e.size());
        arrayList.addAll(list);
        for (int size = this.f31727e.size() - 1; size >= 0; size--) {
            b bVar = this.f31727e.get(size);
            bVar.a(arrayList, this.f31727e.subList(0, size));
            arrayList.add(bVar);
        }
    }

    public List<l> b() {
        if (this.f31729g == null) {
            this.f31729g = new ArrayList();
            for (int i2 = 0; i2 < this.f31727e.size(); i2++) {
                b bVar = this.f31727e.get(i2);
                if (bVar instanceof l) {
                    this.f31729g.add((l) bVar);
                }
            }
        }
        return this.f31729g;
    }

    public Matrix c() {
        com.ksad.lottie.a.b.o oVar = this.f31730h;
        if (oVar != null) {
            return oVar.d();
        }
        this.f31723a.reset();
        return this.f31723a;
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        this.f31723a.reset();
        com.ksad.lottie.a.b.o oVar = this.f31730h;
        if (oVar != null) {
            this.f31723a.set(oVar.d());
        }
        this.f31724b.reset();
        for (int size = this.f31727e.size() - 1; size >= 0; size--) {
            b bVar = this.f31727e.get(size);
            if (bVar instanceof l) {
                this.f31724b.addPath(((l) bVar).d(), this.f31723a);
            }
        }
        return this.f31724b;
    }
}
