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
public abstract class a implements d, j, a.InterfaceC0355a {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f31810a;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.f f31815f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f31816g;

    /* renamed from: i  reason: collision with root package name */
    public final float[] f31818i;
    public final com.ksad.lottie.a.b.a<?, Float> j;
    public final com.ksad.lottie.a.b.a<?, Integer> k;
    public final List<com.ksad.lottie.a.b.a<?, Float>> l;
    @Nullable
    public final com.ksad.lottie.a.b.a<?, Float> m;
    @Nullable
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> n;

    /* renamed from: b  reason: collision with root package name */
    public final PathMeasure f31811b = new PathMeasure();

    /* renamed from: c  reason: collision with root package name */
    public final Path f31812c = new Path();

    /* renamed from: d  reason: collision with root package name */
    public final Path f31813d = new Path();

    /* renamed from: e  reason: collision with root package name */
    public final RectF f31814e = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public final List<C0354a> f31817h = new ArrayList();

    /* renamed from: com.ksad.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0354a {

        /* renamed from: a  reason: collision with root package name */
        public final List<l> f31819a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final r f31820b;

        public C0354a(@Nullable r rVar) {
            this.f31819a = new ArrayList();
            this.f31820b = rVar;
        }
    }

    public a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f2, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.b bVar, List<com.ksad.lottie.model.a.b> list, com.ksad.lottie.model.a.b bVar2) {
        Paint paint = new Paint(1);
        this.f31810a = paint;
        this.f31815f = fVar;
        this.f31816g = aVar;
        paint.setStyle(Paint.Style.STROKE);
        this.f31810a.setStrokeCap(cap);
        this.f31810a.setStrokeJoin(join);
        this.f31810a.setStrokeMiter(f2);
        this.k = dVar.a();
        this.j = bVar.a();
        this.m = bVar2 == null ? null : bVar2.a();
        this.l = new ArrayList(list.size());
        this.f31818i = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.l.add(list.get(i2).a());
        }
        aVar.a(this.k);
        aVar.a(this.j);
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            aVar.a(this.l.get(i3));
        }
        com.ksad.lottie.a.b.a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.l.get(i4).a(this);
        }
        com.ksad.lottie.a.b.a<?, Float> aVar3 = this.m;
        if (aVar3 != null) {
            aVar3.a(this);
        }
    }

    private void a(Canvas canvas, C0354a c0354a, Matrix matrix) {
        float f2;
        com.ksad.lottie.c.c("StrokeContent#applyTrimPath");
        if (c0354a.f31820b == null) {
            com.ksad.lottie.c.d("StrokeContent#applyTrimPath");
            return;
        }
        this.f31812c.reset();
        for (int size = c0354a.f31819a.size() - 1; size >= 0; size--) {
            this.f31812c.addPath(((l) c0354a.f31819a.get(size)).d(), matrix);
        }
        this.f31811b.setPath(this.f31812c, false);
        float length = this.f31811b.getLength();
        while (this.f31811b.nextContour()) {
            length += this.f31811b.getLength();
        }
        float floatValue = (c0354a.f31820b.e().e().floatValue() * length) / 360.0f;
        float floatValue2 = ((c0354a.f31820b.c().e().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((c0354a.f31820b.d().e().floatValue() * length) / 100.0f) + floatValue;
        float f3 = 0.0f;
        for (int size2 = c0354a.f31819a.size() - 1; size2 >= 0; size2--) {
            this.f31813d.set(((l) c0354a.f31819a.get(size2)).d());
            this.f31813d.transform(matrix);
            this.f31811b.setPath(this.f31813d, false);
            float length2 = this.f31811b.getLength();
            float f4 = 1.0f;
            if (floatValue3 > length) {
                float f5 = floatValue3 - length;
                if (f5 < f3 + length2 && f3 < f5) {
                    f2 = floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f;
                    f4 = Math.min(f5 / length2, 1.0f);
                    com.ksad.lottie.d.f.a(this.f31813d, f2, f4, 0.0f);
                    canvas.drawPath(this.f31813d, this.f31810a);
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
                    com.ksad.lottie.d.f.a(this.f31813d, f2, f4, 0.0f);
                }
                canvas.drawPath(this.f31813d, this.f31810a);
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
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            this.f31818i[i2] = this.l.get(i2).e().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f31818i;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f31818i;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f31818i;
            fArr3[i2] = fArr3[i2] * a2;
        }
        com.ksad.lottie.a.b.a<?, Float> aVar = this.m;
        this.f31810a.setPathEffect(new DashPathEffect(this.f31818i, aVar == null ? 0.0f : aVar.e().floatValue()));
        com.ksad.lottie.c.d("StrokeContent#applyDashPattern");
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0355a
    public void a() {
        this.f31815f.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        com.ksad.lottie.c.c("StrokeContent#draw");
        this.f31810a.setAlpha(com.ksad.lottie.d.e.a((int) ((((i2 / 255.0f) * this.k.e().intValue()) / 100.0f) * 255.0f), 0, 255));
        this.f31810a.setStrokeWidth(this.j.e().floatValue() * com.ksad.lottie.d.f.a(matrix));
        if (this.f31810a.getStrokeWidth() <= 0.0f) {
            com.ksad.lottie.c.d("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.f31810a.setColorFilter(aVar.e());
        }
        for (int i3 = 0; i3 < this.f31817h.size(); i3++) {
            C0354a c0354a = this.f31817h.get(i3);
            if (c0354a.f31820b != null) {
                a(canvas, c0354a, matrix);
            } else {
                com.ksad.lottie.c.c("StrokeContent#buildPath");
                this.f31812c.reset();
                for (int size = c0354a.f31819a.size() - 1; size >= 0; size--) {
                    this.f31812c.addPath(((l) c0354a.f31819a.get(size)).d(), matrix);
                }
                com.ksad.lottie.c.d("StrokeContent#buildPath");
                com.ksad.lottie.c.c("StrokeContent#drawPath");
                canvas.drawPath(this.f31812c, this.f31810a);
                com.ksad.lottie.c.d("StrokeContent#drawPath");
            }
        }
        com.ksad.lottie.c.d("StrokeContent#draw");
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.ksad.lottie.c.c("StrokeContent#getBounds");
        this.f31812c.reset();
        for (int i2 = 0; i2 < this.f31817h.size(); i2++) {
            C0354a c0354a = this.f31817h.get(i2);
            for (int i3 = 0; i3 < c0354a.f31819a.size(); i3++) {
                this.f31812c.addPath(((l) c0354a.f31819a.get(i3)).d(), matrix);
            }
        }
        this.f31812c.computeBounds(this.f31814e, false);
        float floatValue = this.j.e().floatValue();
        RectF rectF2 = this.f31814e;
        float f2 = floatValue / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f31814e);
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
        C0354a c0354a = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            b bVar2 = list2.get(size2);
            if (bVar2 instanceof r) {
                r rVar3 = (r) bVar2;
                if (rVar3.b() == ShapeTrimPath.Type.Individually) {
                    if (c0354a != null) {
                        this.f31817h.add(c0354a);
                    }
                    c0354a = new C0354a(rVar3);
                    rVar3.a(this);
                }
            }
            if (bVar2 instanceof l) {
                if (c0354a == null) {
                    c0354a = new C0354a(rVar);
                }
                c0354a.f31819a.add((l) bVar2);
            }
        }
        if (c0354a != null) {
            this.f31817h.add(c0354a);
        }
    }
}
