package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c implements d, k, a.InterfaceC0572a {
    private final List<b> ec;
    @Nullable
    private List<k> ed;
    @Nullable
    private com.tb.airbnb.lottie.a.b.p ksg;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final Matrix matrix;
    private final String name;
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
    static com.tb.airbnb.lottie.model.a.l eX(List<com.tb.airbnb.lottie.model.content.b> list) {
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
        this(fVar, aVar, jVar.getName(), a(fVar, aVar, jVar.getItems()), eX(jVar.getItems()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, String str, List<b> list, @Nullable com.tb.airbnb.lottie.model.a.l lVar) {
        this.matrix = new Matrix();
        this.path = new Path();
        this.rect = new RectF();
        this.name = str;
        this.lottieDrawable = fVar;
        this.ec = list;
        if (lVar != null) {
            this.ksg = lVar.cLA();
            this.ksg.a(aVar);
            this.ksg.a(this);
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

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0572a
    public void bt() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ec.size()) {
                b bVar = this.ec.get(i2);
                if (bVar instanceof d) {
                    d dVar = (d) bVar;
                    if (str2 == null || str2.equals(bVar.getName())) {
                        dVar.b(str, null, colorFilter);
                    } else {
                        dVar.b(str, str2, colorFilter);
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.ec.size());
        arrayList.addAll(list);
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            b bVar = this.ec.get(size);
            bVar.b(arrayList, this.ec.subList(0, size));
            arrayList.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<k> bu() {
        if (this.ed == null) {
            this.ed = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ec.size()) {
                    break;
                }
                b bVar = this.ec.get(i2);
                if (bVar instanceof k) {
                    this.ed.add((k) bVar);
                }
                i = i2 + 1;
            }
        }
        return this.ed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix bv() {
        if (this.ksg != null) {
            return this.ksg.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    @Override // com.tb.airbnb.lottie.a.a.k
    public Path bw() {
        this.matrix.reset();
        if (this.ksg != null) {
            this.matrix.set(this.ksg.getMatrix());
        }
        this.path.reset();
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            b bVar = this.ec.get(size);
            if (bVar instanceof k) {
                this.path.addPath(((k) bVar).bw(), this.matrix);
            }
        }
        return this.path;
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.matrix.set(matrix);
        if (this.ksg != null) {
            this.matrix.preConcat(this.ksg.getMatrix());
            i = (int) ((((this.ksg.cLi().getValue().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            b bVar = this.ec.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(canvas, this.matrix, i);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.matrix.set(matrix);
        if (this.ksg != null) {
            this.matrix.preConcat(this.ksg.getMatrix());
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.ec.size() - 1; size >= 0; size--) {
            b bVar = this.ec.get(size);
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
}
