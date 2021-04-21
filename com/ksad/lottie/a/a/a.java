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
/* loaded from: classes6.dex */
public abstract class a implements d, j, a.InterfaceC0369a {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f31575a;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.f f31580f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f31581g;
    public final float[] i;
    public final com.ksad.lottie.a.b.a<?, Float> j;
    public final com.ksad.lottie.a.b.a<?, Integer> k;
    public final List<com.ksad.lottie.a.b.a<?, Float>> l;
    @Nullable
    public final com.ksad.lottie.a.b.a<?, Float> m;
    @Nullable
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> n;

    /* renamed from: b  reason: collision with root package name */
    public final PathMeasure f31576b = new PathMeasure();

    /* renamed from: c  reason: collision with root package name */
    public final Path f31577c = new Path();

    /* renamed from: d  reason: collision with root package name */
    public final Path f31578d = new Path();

    /* renamed from: e  reason: collision with root package name */
    public final RectF f31579e = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public final List<C0368a> f31582h = new ArrayList();

    /* renamed from: com.ksad.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0368a {

        /* renamed from: a  reason: collision with root package name */
        public final List<l> f31583a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final r f31584b;

        public C0368a(@Nullable r rVar) {
            this.f31583a = new ArrayList();
            this.f31584b = rVar;
        }
    }

    public a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f2, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.b bVar, List<com.ksad.lottie.model.a.b> list, com.ksad.lottie.model.a.b bVar2) {
        Paint paint = new Paint(1);
        this.f31575a = paint;
        this.f31580f = fVar;
        this.f31581g = aVar;
        paint.setStyle(Paint.Style.STROKE);
        this.f31575a.setStrokeCap(cap);
        this.f31575a.setStrokeJoin(join);
        this.f31575a.setStrokeMiter(f2);
        this.k = dVar.a();
        this.j = bVar.a();
        this.m = bVar2 == null ? null : bVar2.a();
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
        com.ksad.lottie.a.b.a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l.get(i3).a(this);
        }
        com.ksad.lottie.a.b.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a(this);
        }
    }

    private void a(Canvas canvas, C0368a c0368a, Matrix matrix) {
        float f2;
        com.ksad.lottie.c.c("StrokeContent#applyTrimPath");
        if (c0368a.f31584b == null) {
            com.ksad.lottie.c.d("StrokeContent#applyTrimPath");
            return;
        }
        this.f31577c.reset();
        for (int size = c0368a.f31583a.size() - 1; size >= 0; size--) {
            this.f31577c.addPath(((l) c0368a.f31583a.get(size)).d(), matrix);
        }
        this.f31576b.setPath(this.f31577c, false);
        float length = this.f31576b.getLength();
        while (this.f31576b.nextContour()) {
            length += this.f31576b.getLength();
        }
        float floatValue = (c0368a.f31584b.e().e().floatValue() * length) / 360.0f;
        float floatValue2 = ((c0368a.f31584b.c().e().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((c0368a.f31584b.d().e().floatValue() * length) / 100.0f) + floatValue;
        float f3 = 0.0f;
        for (int size2 = c0368a.f31583a.size() - 1; size2 >= 0; size2--) {
            this.f31578d.set(((l) c0368a.f31583a.get(size2)).d());
            this.f31578d.transform(matrix);
            this.f31576b.setPath(this.f31578d, false);
            float length2 = this.f31576b.getLength();
            float f4 = 1.0f;
            if (floatValue3 > length) {
                float f5 = floatValue3 - length;
                if (f5 < f3 + length2 && f3 < f5) {
                    f2 = floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f;
                    f4 = Math.min(f5 / length2, 1.0f);
                    com.ksad.lottie.d.f.a(this.f31578d, f2, f4, 0.0f);
                    canvas.drawPath(this.f31578d, this.f31575a);
                    f3 += length2;
                }
            }
            float f6 = f3 + length2;
            if (f6 >= floatValue2 && f3 <= floatValue3) {
                if (f6 > floatValue3 || floatValue2 >= f3) {
                    f2 = floatValue2 < f3 ? 0.0f : (floatValue2 - f3) / length2;
                    if (floatValue3 <= f6) {
                        f4 = (floatValue3 - f3) / length2;
                    }
                    com.ksad.lottie.d.f.a(this.f31578d, f2, f4, 0.0f);
                }
                canvas.drawPath(this.f31578d, this.f31575a);
            }
            f3 += length2;
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
        for (int i = 0; i < this.l.size(); i++) {
            this.i[i] = this.l.get(i).e().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.i;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.i;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.i;
            fArr3[i] = fArr3[i] * a2;
        }
        com.ksad.lottie.a.b.a<?, Float> aVar = this.m;
        this.f31575a.setPathEffect(new DashPathEffect(this.i, aVar == null ? 0.0f : aVar.e().floatValue()));
        com.ksad.lottie.c.d("StrokeContent#applyDashPattern");
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0369a
    public void a() {
        this.f31580f.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.ksad.lottie.c.c("StrokeContent#draw");
        this.f31575a.setAlpha(com.ksad.lottie.d.e.a((int) ((((i / 255.0f) * this.k.e().intValue()) / 100.0f) * 255.0f), 0, 255));
        this.f31575a.setStrokeWidth(this.j.e().floatValue() * com.ksad.lottie.d.f.a(matrix));
        if (this.f31575a.getStrokeWidth() <= 0.0f) {
            com.ksad.lottie.c.d("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.f31575a.setColorFilter(aVar.e());
        }
        for (int i2 = 0; i2 < this.f31582h.size(); i2++) {
            C0368a c0368a = this.f31582h.get(i2);
            if (c0368a.f31584b != null) {
                a(canvas, c0368a, matrix);
            } else {
                com.ksad.lottie.c.c("StrokeContent#buildPath");
                this.f31577c.reset();
                for (int size = c0368a.f31583a.size() - 1; size >= 0; size--) {
                    this.f31577c.addPath(((l) c0368a.f31583a.get(size)).d(), matrix);
                }
                com.ksad.lottie.c.d("StrokeContent#buildPath");
                com.ksad.lottie.c.c("StrokeContent#drawPath");
                canvas.drawPath(this.f31577c, this.f31575a);
                com.ksad.lottie.c.d("StrokeContent#drawPath");
            }
        }
        com.ksad.lottie.c.d("StrokeContent#draw");
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.ksad.lottie.c.c("StrokeContent#getBounds");
        this.f31577c.reset();
        for (int i = 0; i < this.f31582h.size(); i++) {
            C0368a c0368a = this.f31582h.get(i);
            for (int i2 = 0; i2 < c0368a.f31583a.size(); i2++) {
                this.f31577c.addPath(((l) c0368a.f31583a.get(i2)).d(), matrix);
            }
        }
        this.f31577c.computeBounds(this.f31579e, false);
        float floatValue = this.j.e().floatValue();
        RectF rectF2 = this.f31579e;
        float f2 = floatValue / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f31579e);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.ksad.lottie.c.d("StrokeContent#getBounds");
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        r rVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            b bVar = list.get(size);
            if (bVar instanceof r) {
                r rVar2 = (r) bVar;
                if (rVar2.b() == ShapeTrimPath.Type.Individually) {
                    rVar = rVar2;
                }
            }
        }
        if (rVar != null) {
            rVar.a(this);
        }
        C0368a c0368a = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            b bVar2 = list2.get(size2);
            if (bVar2 instanceof r) {
                r rVar3 = (r) bVar2;
                if (rVar3.b() == ShapeTrimPath.Type.Individually) {
                    if (c0368a != null) {
                        this.f31582h.add(c0368a);
                    }
                    c0368a = new C0368a(rVar3);
                    rVar3.a(this);
                }
            }
            if (bVar2 instanceof l) {
                if (c0368a == null) {
                    c0368a = new C0368a(rVar);
                }
                c0368a.f31583a.add((l) bVar2);
            }
        }
        if (c0368a != null) {
            this.f31582h.add(c0368a);
        }
    }
}
