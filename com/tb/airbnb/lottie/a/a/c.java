package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c implements d, l, a.InterfaceC0738a, com.tb.airbnb.lottie.model.f {
    private final List<b> contents;
    @Nullable
    private List<l> fU;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final Matrix matrix;
    private final String name;
    @Nullable
    private com.tb.airbnb.lottie.a.b.o npH;
    private final Path path;
    private final RectF rect;

    private static List<b> a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, List<com.tb.airbnb.lottie.model.content.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b a = list.get(i2).a(fVar, aVar);
                if (a != null) {
                    arrayList.add(a);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    @Nullable
    static com.tb.airbnb.lottie.model.a.l fr(List<com.tb.airbnb.lottie.model.content.b> list) {
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

    public c(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, com.tb.airbnb.lottie.model.content.j jVar) {
        this(fVar, aVar, jVar.getName(), a(fVar, aVar, jVar.getItems()), fr(jVar.getItems()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, String str, List<b> list, @Nullable com.tb.airbnb.lottie.model.a.l lVar) {
        this.matrix = new Matrix();
        this.path = new Path();
        this.rect = new RectF();
        this.name = str;
        this.lottieDrawable = fVar;
        this.contents = list;
        if (lVar != null) {
            this.npH = lVar.dGW();
            this.npH.a(aVar);
            this.npH.a(this);
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

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0738a
    public void bD() {
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
    public List<l> bE() {
        if (this.fU == null) {
            this.fU = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.contents.size()) {
                    break;
                }
                b bVar = this.contents.get(i2);
                if (bVar instanceof l) {
                    this.fU.add((l) bVar);
                }
                i = i2 + 1;
            }
        }
        return this.fU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix bF() {
        if (this.npH != null) {
            return this.npH.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    @Override // com.tb.airbnb.lottie.a.a.l
    public Path bG() {
        this.matrix.reset();
        if (this.npH != null) {
            this.matrix.set(this.npH.getMatrix());
        }
        this.path.reset();
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            b bVar = this.contents.get(size);
            if (bVar instanceof l) {
                this.path.addPath(((l) bVar).bG(), this.matrix);
            }
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.matrix.set(matrix);
        if (this.npH != null) {
            this.matrix.preConcat(this.npH.getMatrix());
            i = (int) ((((this.npH.dGI().getValue().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
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
        if (this.npH != null) {
            this.matrix.preConcat(this.npH.getMatrix());
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
        if (eVar.c(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.Rx(getName());
                if (eVar.e(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.f(getName(), i)) {
                int d = i + eVar.d(getName(), i);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < this.contents.size()) {
                        b bVar = this.contents.get(i3);
                        if (bVar instanceof com.tb.airbnb.lottie.model.f) {
                            ((com.tb.airbnb.lottie.model.f) bVar).a(eVar, d, list, eVar2);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // com.tb.airbnb.lottie.model.f
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (this.npH != null) {
            this.npH.b(t, cVar);
        }
    }
}
