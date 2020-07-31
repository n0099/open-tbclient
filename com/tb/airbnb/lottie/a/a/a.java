package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a implements d, j, a.InterfaceC0874a {
    private final float[] BQ;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> BT;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.model.layer.a nOc;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOd;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> nOe;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOf;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> nOg;
    private final PathMeasure BM = new PathMeasure();
    private final Path path = new Path();
    private final Path BN = new Path();
    private final RectF rect = new RectF();
    private final List<C0873a> BP = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = fVar;
        this.nOc = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.nOe = dVar.dRc();
        this.nOd = bVar.dRc();
        if (bVar2 == null) {
            this.nOf = null;
        } else {
            this.nOf = bVar2.dRc();
        }
        this.BT = new ArrayList(list.size());
        this.BQ = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.BT.add(list.get(i).dRc());
        }
        aVar.a(this.nOe);
        aVar.a(this.nOd);
        for (int i2 = 0; i2 < this.BT.size(); i2++) {
            aVar.a(this.BT.get(i2));
        }
        if (this.nOf != null) {
            aVar.a(this.nOf);
        }
        this.nOe.b(this);
        this.nOd.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.BT.get(i3).b(this);
        }
        if (this.nOf != null) {
            this.nOf.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0874a
    public void hq() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0873a c0873a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).dQS() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0873a c0873a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).dQS() == ShapeTrimPath.Type.Individually) {
                if (c0873a2 != null) {
                    this.BP.add(c0873a2);
                }
                C0873a c0873a3 = new C0873a((r) bVar2);
                ((r) bVar2).a(this);
                c0873a = c0873a3;
            } else if (bVar2 instanceof l) {
                c0873a = c0873a2 == null ? new C0873a(rVar) : c0873a2;
                c0873a.BW.add((l) bVar2);
            } else {
                c0873a = c0873a2;
            }
            size2--;
            c0873a2 = c0873a;
        }
        if (c0873a2 != null) {
            this.BP.add(c0873a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.nOe.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.nOd.getValue().floatValue() * com.tb.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.c.aW("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.nOg != null) {
            this.paint.setColorFilter(this.nOg.getValue());
        }
        for (int i2 = 0; i2 < this.BP.size(); i2++) {
            C0873a c0873a = this.BP.get(i2);
            if (c0873a.nOh != null) {
                a(canvas, c0873a, matrix);
            } else {
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0873a.BW.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0873a.BW.get(size)).ht(), matrix);
                }
                com.tb.airbnb.lottie.c.aW("StrokeContent#buildPath");
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.tb.airbnb.lottie.c.aW("StrokeContent#drawPath");
            }
        }
        com.tb.airbnb.lottie.c.aW("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0873a c0873a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyTrimPath");
        if (c0873a.nOh == null) {
            com.tb.airbnb.lottie.c.aW("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0873a.BW.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0873a.BW.get(size)).ht(), matrix);
        }
        this.BM.setPath(this.path, false);
        float length = this.BM.getLength();
        while (true) {
            f = length;
            if (!this.BM.nextContour()) {
                break;
            }
            length = this.BM.getLength() + f;
        }
        float floatValue = (c0873a.nOh.dQV().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0873a.nOh.dQT().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0873a.nOh.dQU().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0873a.BW.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.BN.set(((l) c0873a.BW.get(size2)).ht());
            this.BN.transform(matrix);
            this.BM.setPath(this.BN, false);
            float length2 = this.BM.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.tb.airbnb.lottie.d.f.a(this.BN, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.BN, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.BN, this.paint);
                } else {
                    com.tb.airbnb.lottie.d.f.a(this.BN, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.BN, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.tb.airbnb.lottie.c.aW("StrokeContent#applyTrimPath");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.BP.size(); i++) {
            C0873a c0873a = this.BP.get(i);
            for (int i2 = 0; i2 < c0873a.BW.size(); i2++) {
                this.path.addPath(((l) c0873a.BW.get(i2)).ht(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.nOd.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.c.aW("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.BT.isEmpty()) {
            com.tb.airbnb.lottie.c.aW("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.BT.size()) {
                break;
            }
            this.BQ[i2] = this.BT.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.BQ[i2] < 1.0f) {
                    this.BQ[i2] = 1.0f;
                }
            } else if (this.BQ[i2] < 0.1f) {
                this.BQ[i2] = 0.1f;
            }
            float[] fArr = this.BQ;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.BQ, this.nOf == null ? 0.0f : this.nOf.getValue().floatValue()));
        com.tb.airbnb.lottie.c.aW("StrokeContent#applyDashPattern");
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Bd) {
            this.nOe.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bk) {
            this.nOd.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bx) {
            if (cVar == null) {
                this.nOg = null;
                return;
            }
            this.nOg = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.nOg.b(this);
            this.nOc.a(this.nOg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0873a {
        private final List<l> BW;
        @Nullable
        private final r nOh;

        private C0873a(@Nullable r rVar) {
            this.BW = new ArrayList();
            this.nOh = rVar;
        }
    }
}
