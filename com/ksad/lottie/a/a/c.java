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
public class c implements d, l, a.InterfaceC0351a {

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f31200a;

    /* renamed from: b  reason: collision with root package name */
    public final Path f31201b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f31202c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31203d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b> f31204e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.f f31205f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public List<l> f31206g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.ksad.lottie.a.b.o f31207h;

    public c(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.j jVar) {
        this(fVar, aVar, jVar.a(), a(fVar, aVar, jVar.b()), a(jVar.b()));
    }

    public c(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, String str, List<b> list, @Nullable com.ksad.lottie.model.a.l lVar) {
        this.f31200a = new Matrix();
        this.f31201b = new Path();
        this.f31202c = new RectF();
        this.f31203d = str;
        this.f31205f = fVar;
        this.f31204e = list;
        if (lVar != null) {
            com.ksad.lottie.a.b.o h2 = lVar.h();
            this.f31207h = h2;
            h2.a(aVar);
            this.f31207h.a(this);
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
        for (int i = 0; i < list.size(); i++) {
            com.ksad.lottie.model.content.b bVar = list.get(i);
            if (bVar instanceof com.ksad.lottie.model.a.l) {
                return (com.ksad.lottie.model.a.l) bVar;
            }
        }
        return null;
    }

    public static List<b> a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, List<com.ksad.lottie.model.content.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            b a2 = list.get(i).a(fVar, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0351a
    public void a() {
        this.f31205f.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f31200a.set(matrix);
        com.ksad.lottie.a.b.o oVar = this.f31207h;
        if (oVar != null) {
            this.f31200a.preConcat(oVar.d());
            i = (int) ((((this.f31207h.a().e().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.f31204e.size() - 1; size >= 0; size--) {
            b bVar = this.f31204e.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(canvas, this.f31200a, i);
            }
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.f31200a.set(matrix);
        com.ksad.lottie.a.b.o oVar = this.f31207h;
        if (oVar != null) {
            this.f31200a.preConcat(oVar.d());
        }
        this.f31202c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f31204e.size() - 1; size >= 0; size--) {
            b bVar = this.f31204e.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(this.f31202c, this.f31200a);
                if (rectF.isEmpty()) {
                    rectF.set(this.f31202c);
                } else {
                    rectF.set(Math.min(rectF.left, this.f31202c.left), Math.min(rectF.top, this.f31202c.top), Math.max(rectF.right, this.f31202c.right), Math.max(rectF.bottom, this.f31202c.bottom));
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f31204e.size());
        arrayList.addAll(list);
        for (int size = this.f31204e.size() - 1; size >= 0; size--) {
            b bVar = this.f31204e.get(size);
            bVar.a(arrayList, this.f31204e.subList(0, size));
            arrayList.add(bVar);
        }
    }

    public List<l> b() {
        if (this.f31206g == null) {
            this.f31206g = new ArrayList();
            for (int i = 0; i < this.f31204e.size(); i++) {
                b bVar = this.f31204e.get(i);
                if (bVar instanceof l) {
                    this.f31206g.add((l) bVar);
                }
            }
        }
        return this.f31206g;
    }

    public Matrix c() {
        com.ksad.lottie.a.b.o oVar = this.f31207h;
        if (oVar != null) {
            return oVar.d();
        }
        this.f31200a.reset();
        return this.f31200a;
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        this.f31200a.reset();
        com.ksad.lottie.a.b.o oVar = this.f31207h;
        if (oVar != null) {
            this.f31200a.set(oVar.d());
        }
        this.f31201b.reset();
        for (int size = this.f31204e.size() - 1; size >= 0; size--) {
            b bVar = this.f31204e.get(size);
            if (bVar instanceof l) {
                this.f31201b.addPath(((l) bVar).d(), this.f31200a);
            }
        }
        return this.f31201b;
    }
}
