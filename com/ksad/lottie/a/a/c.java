package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements d, l, a.InterfaceC1067a {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f7935a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f7936b;
    private final RectF c;
    private final String d;
    private final List<b> e;
    private final com.ksad.lottie.f f;
    @Nullable
    private List<l> g;
    @Nullable
    private com.ksad.lottie.a.b.o h;

    public c(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.j jVar) {
        this(fVar, aVar, jVar.a(), a(fVar, aVar, jVar.b()), a(jVar.b()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, String str, List<b> list, @Nullable com.ksad.lottie.model.a.l lVar) {
        this.f7935a = new Matrix();
        this.f7936b = new Path();
        this.c = new RectF();
        this.d = str;
        this.f = fVar;
        this.e = list;
        if (lVar != null) {
            this.h = lVar.h();
            this.h.a(aVar);
            this.h.a(this);
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
    static com.ksad.lottie.model.a.l a(List<com.ksad.lottie.model.content.b> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return null;
            }
            com.ksad.lottie.model.content.b bVar = list.get(i2);
            if (bVar instanceof com.ksad.lottie.model.a.l) {
                return (com.ksad.lottie.model.a.l) bVar;
            }
            i = i2 + 1;
        }
    }

    private static List<b> a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, List<com.ksad.lottie.model.content.b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            b a2 = list.get(i2).a(fVar, aVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
            i = i2 + 1;
        }
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC1067a
    public void a() {
        this.f.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f7935a.set(matrix);
        if (this.h != null) {
            this.f7935a.preConcat(this.h.d());
            i = (int) ((((this.h.a().e().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.e.size() - 1; size >= 0; size--) {
            b bVar = this.e.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(canvas, this.f7935a, i);
            }
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.f7935a.set(matrix);
        if (this.h != null) {
            this.f7935a.preConcat(this.h.d());
        }
        this.c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.e.size() - 1; size >= 0; size--) {
            b bVar = this.e.get(size);
            if (bVar instanceof d) {
                ((d) bVar).a(this.c, this.f7935a);
                if (rectF.isEmpty()) {
                    rectF.set(this.c);
                } else {
                    rectF.set(Math.min(rectF.left, this.c.left), Math.min(rectF.top, this.c.top), Math.max(rectF.right, this.c.right), Math.max(rectF.bottom, this.c.bottom));
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.e.size());
        arrayList.addAll(list);
        for (int size = this.e.size() - 1; size >= 0; size--) {
            b bVar = this.e.get(size);
            bVar.a(arrayList, this.e.subList(0, size));
            arrayList.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<l> b() {
        if (this.g == null) {
            this.g = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.e.size()) {
                    break;
                }
                b bVar = this.e.get(i2);
                if (bVar instanceof l) {
                    this.g.add((l) bVar);
                }
                i = i2 + 1;
            }
        }
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix c() {
        if (this.h != null) {
            return this.h.d();
        }
        this.f7935a.reset();
        return this.f7935a;
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        this.f7935a.reset();
        if (this.h != null) {
            this.f7935a.set(this.h.d());
        }
        this.f7936b.reset();
        for (int size = this.e.size() - 1; size >= 0; size--) {
            b bVar = this.e.get(size);
            if (bVar instanceof l) {
                this.f7936b.addPath(((l) bVar).d(), this.f7935a);
            }
        }
        return this.f7936b;
    }
}
