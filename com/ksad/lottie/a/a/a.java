package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a implements d, j, a.InterfaceC1037a {
    private final com.ksad.lottie.f f;
    private final com.ksad.lottie.model.layer.a g;
    private final float[] i;
    private final com.ksad.lottie.a.b.a<?, Float> j;
    private final com.ksad.lottie.a.b.a<?, Integer> k;
    private final List<com.ksad.lottie.a.b.a<?, Float>> l;
    @Nullable
    private final com.ksad.lottie.a.b.a<?, Float> m;
    @Nullable
    private com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> n;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f8229b = new PathMeasure();
    private final Path c = new Path();
    private final Path d = new Path();
    private final RectF e = new RectF();
    private final List<C1036a> h = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    final Paint f8228a = new Paint(1);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ksad.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1036a {

        /* renamed from: a  reason: collision with root package name */
        private final List<l> f8230a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final r f8231b;

        private C1036a(@Nullable r rVar) {
            this.f8230a = new ArrayList();
            this.f8231b = rVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.b bVar, List<com.ksad.lottie.model.a.b> list, com.ksad.lottie.model.a.b bVar2) {
        this.f = fVar;
        this.g = aVar;
        this.f8228a.setStyle(Paint.Style.STROKE);
        this.f8228a.setStrokeCap(cap);
        this.f8228a.setStrokeJoin(join);
        this.f8228a.setStrokeMiter(f);
        this.k = dVar.a();
        this.j = bVar.a();
        if (bVar2 == null) {
            this.m = null;
        } else {
            this.m = bVar2.a();
        }
        this.l = new ArrayList(list.size());
        this.i = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(list.get(i).a());
        }
        aVar.a(this.k);
        aVar.a(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            aVar.a(this.l.get(i2));
        }
        if (this.m != null) {
            aVar.a(this.m);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l.get(i3).a(this);
        }
        if (this.m != null) {
            this.m.a(this);
        }
    }

    private void a(Canvas canvas, C1036a c1036a, Matrix matrix) {
        float f;
        com.ksad.lottie.c.c("StrokeContent#applyTrimPath");
        if (c1036a.f8231b == null) {
            com.ksad.lottie.c.d("StrokeContent#applyTrimPath");
            return;
        }
        this.c.reset();
        for (int size = c1036a.f8230a.size() - 1; size >= 0; size--) {
            this.c.addPath(((l) c1036a.f8230a.get(size)).d(), matrix);
        }
        this.f8229b.setPath(this.c, false);
        float length = this.f8229b.getLength();
        while (true) {
            f = length;
            if (!this.f8229b.nextContour()) {
                break;
            }
            length = this.f8229b.getLength() + f;
        }
        float floatValue = (c1036a.f8231b.e().e().floatValue() * f) / 360.0f;
        float floatValue2 = ((c1036a.f8231b.c().e().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c1036a.f8231b.d().e().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c1036a.f8230a.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.d.set(((l) c1036a.f8230a.get(size2)).d());
            this.d.transform(matrix);
            this.f8229b.setPath(this.d, false);
            float length2 = this.f8229b.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.ksad.lottie.d.f.a(this.d, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.d, this.f8228a);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 > floatValue3 || floatValue2 >= f2) {
                    com.ksad.lottie.d.f.a(this.d, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.d, this.f8228a);
                } else {
                    canvas.drawPath(this.d, this.f8228a);
                }
            }
            size2--;
            f2 += length2;
        }
        com.ksad.lottie.c.d("StrokeContent#applyTrimPath");
    }

    private void a(Matrix matrix) {
        com.ksad.lottie.c.c("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            com.ksad.lottie.c.d("StrokeContent#applyDashPattern");
            return;
        }
        float a2 = com.ksad.lottie.d.f.a(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.l.size()) {
                break;
            }
            this.i[i2] = this.l.get(i2).e().floatValue();
            if (i2 % 2 == 0) {
                if (this.i[i2] < 1.0f) {
                    this.i[i2] = 1.0f;
                }
            } else if (this.i[i2] < 0.1f) {
                this.i[i2] = 0.1f;
            }
            float[] fArr = this.i;
            fArr[i2] = fArr[i2] * a2;
            i = i2 + 1;
        }
        this.f8228a.setPathEffect(new DashPathEffect(this.i, this.m == null ? 0.0f : this.m.e().floatValue()));
        com.ksad.lottie.c.d("StrokeContent#applyDashPattern");
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC1037a
    public void a() {
        this.f.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.ksad.lottie.c.c("StrokeContent#draw");
        this.f8228a.setAlpha(com.ksad.lottie.d.e.a((int) (((this.k.e().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.f8228a.setStrokeWidth(this.j.e().floatValue() * com.ksad.lottie.d.f.a(matrix));
        if (this.f8228a.getStrokeWidth() <= 0.0f) {
            com.ksad.lottie.c.d("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.n != null) {
            this.f8228a.setColorFilter(this.n.e());
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            C1036a c1036a = this.h.get(i2);
            if (c1036a.f8231b != null) {
                a(canvas, c1036a, matrix);
            } else {
                com.ksad.lottie.c.c("StrokeContent#buildPath");
                this.c.reset();
                for (int size = c1036a.f8230a.size() - 1; size >= 0; size--) {
                    this.c.addPath(((l) c1036a.f8230a.get(size)).d(), matrix);
                }
                com.ksad.lottie.c.d("StrokeContent#buildPath");
                com.ksad.lottie.c.c("StrokeContent#drawPath");
                canvas.drawPath(this.c, this.f8228a);
                com.ksad.lottie.c.d("StrokeContent#drawPath");
            }
        }
        com.ksad.lottie.c.d("StrokeContent#draw");
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.ksad.lottie.c.c("StrokeContent#getBounds");
        this.c.reset();
        for (int i = 0; i < this.h.size(); i++) {
            C1036a c1036a = this.h.get(i);
            for (int i2 = 0; i2 < c1036a.f8230a.size(); i2++) {
                this.c.addPath(((l) c1036a.f8230a.get(i2)).d(), matrix);
            }
        }
        this.c.computeBounds(this.e, false);
        float floatValue = this.j.e().floatValue();
        this.e.set(this.e.left - (floatValue / 2.0f), this.e.top - (floatValue / 2.0f), this.e.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.e.bottom);
        rectF.set(this.e);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.ksad.lottie.c.d("StrokeContent#getBounds");
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        C1036a c1036a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).b() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C1036a c1036a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).b() == ShapeTrimPath.Type.Individually) {
                if (c1036a2 != null) {
                    this.h.add(c1036a2);
                }
                C1036a c1036a3 = new C1036a((r) bVar2);
                ((r) bVar2).a(this);
                c1036a = c1036a3;
            } else if (bVar2 instanceof l) {
                c1036a = c1036a2 == null ? new C1036a(rVar) : c1036a2;
                c1036a.f8230a.add((l) bVar2);
            } else {
                c1036a = c1036a2;
            }
            size2--;
            c1036a2 = c1036a;
        }
        if (c1036a2 != null) {
            this.h.add(c1036a2);
        }
    }
}
