package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class c implements d, l, a.InterfaceC1019a, com.tb.airbnb.lottie.model.f {
    @Nullable
    private List<l> DT;
    private final List<b> contents;
    private final com.tb.airbnb.lottie.g lottieDrawable;
    private final Matrix matrix;
    private final String name;
    @Nullable
    private com.tb.airbnb.lottie.a.b.o pAU;
    private final Path path;
    private final RectF rect;

    private static List<b> a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, List<com.tb.airbnb.lottie.model.content.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b a2 = list.get(i2).a(gVar, aVar);
                if (a2 != null) {
                    arrayList.add(a2);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    @Nullable
    static com.tb.airbnb.lottie.model.a.l gY(List<com.tb.airbnb.lottie.model.content.b> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                com.tb.airbnb.lottie.model.content.b bVar = list.get(i2);
                if (!(bVar instanceof com.tb.airbnb.lottie.model.a.l)) {
                    i = i2 + 1;
                } else {
                    return (com.tb.airbnb.lottie.model.a.l) bVar;
                }
            } else {
                return null;
            }
        }
    }

    public c(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.j jVar) {
        this(gVar, aVar, jVar.getName(), a(gVar, aVar, jVar.getItems()), gY(jVar.getItems()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, String str, List<b> list, @Nullable com.tb.airbnb.lottie.model.a.l lVar) {
        this.matrix = new Matrix();
        this.path = new Path();
        this.rect = new RectF();
        this.name = str;
        this.lottieDrawable = gVar;
        this.contents = list;
        if (lVar != null) {
            this.pAU = lVar.eBr();
            this.pAU.a(aVar);
            this.pAU.a(this);
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

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1019a
    public void iT() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.contents.size());
        arrayList.addAll(list);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            b bVar = this.contents.get(size);
            bVar.b(arrayList, this.contents.subList(0, size));
            arrayList.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<l> iU() {
        if (this.DT == null) {
            this.DT = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.contents.size()) {
                    break;
                }
                b bVar = this.contents.get(i2);
                if (bVar instanceof l) {
                    this.DT.add((l) bVar);
                }
                i = i2 + 1;
            }
        }
        return this.DT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix iV() {
        if (this.pAU != null) {
            return this.pAU.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path iW() {
        this.matrix.reset();
        if (this.pAU != null) {
            this.matrix.set(this.pAU.getMatrix());
        }
        this.path.reset();
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            b bVar = this.contents.get(size);
            if (bVar instanceof l) {
                this.path.addPath(((l) bVar).iW(), this.matrix);
            }
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.matrix.set(matrix);
        if (this.pAU != null) {
            this.matrix.preConcat(this.pAU.getMatrix());
            i = (int) ((((this.pAU.eBd().getValue().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            b bVar = this.contents.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(canvas, this.matrix, i);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.matrix.set(matrix);
        if (this.pAU != null) {
            this.matrix.preConcat(this.pAU.getMatrix());
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            b bVar = this.contents.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(this.rect, this.matrix);
                if (rectF.isEmpty()) {
                    rectF.set(this.rect);
                } else {
                    rectF.set(Math.min(rectF.left, this.rect.left), Math.min(rectF.top, this.rect.top), Math.max(rectF.right, this.rect.right), Math.max(rectF.bottom, this.rect.bottom));
                }
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.ZT(getName());
                if (eVar.j(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.k(getName(), i)) {
                int i2 = i + eVar.i(getName(), i);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < this.contents.size()) {
                        b bVar = this.contents.get(i4);
                        if (bVar instanceof com.tb.airbnb.lottie.model.f) {
                            ((com.tb.airbnb.lottie.model.f) bVar).a(eVar, i2, list, eVar2);
                        }
                        i3 = i4 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (this.pAU != null) {
            this.pAU.b(t, cVar);
        }
    }
}
