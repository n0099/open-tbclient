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
/* loaded from: classes6.dex */
public abstract class a implements d, j, a.InterfaceC0865a {
    private final float[] BO;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> BR;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.model.layer.a nFu;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nFv;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> nFw;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nFx;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> nFy;
    private final PathMeasure BK = new PathMeasure();
    private final Path path = new Path();
    private final Path BL = new Path();
    private final RectF rect = new RectF();
    private final List<C0864a> BN = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = fVar;
        this.nFu = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.nFw = dVar.dNG();
        this.nFv = bVar.dNG();
        if (bVar2 == null) {
            this.nFx = null;
        } else {
            this.nFx = bVar2.dNG();
        }
        this.BR = new ArrayList(list.size());
        this.BO = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.BR.add(list.get(i).dNG());
        }
        aVar.a(this.nFw);
        aVar.a(this.nFv);
        for (int i2 = 0; i2 < this.BR.size(); i2++) {
            aVar.a(this.BR.get(i2));
        }
        if (this.nFx != null) {
            aVar.a(this.nFx);
        }
        this.nFw.b(this);
        this.nFv.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.BR.get(i3).b(this);
        }
        if (this.nFx != null) {
            this.nFx.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0865a
    public void hq() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0864a c0864a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).dNw() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0864a c0864a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).dNw() == ShapeTrimPath.Type.Individually) {
                if (c0864a2 != null) {
                    this.BN.add(c0864a2);
                }
                C0864a c0864a3 = new C0864a((r) bVar2);
                ((r) bVar2).a(this);
                c0864a = c0864a3;
            } else if (bVar2 instanceof l) {
                c0864a = c0864a2 == null ? new C0864a(rVar) : c0864a2;
                c0864a.BU.add((l) bVar2);
            } else {
                c0864a = c0864a2;
            }
            size2--;
            c0864a2 = c0864a;
        }
        if (c0864a2 != null) {
            this.BN.add(c0864a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.nFw.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.nFv.getValue().floatValue() * com.tb.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.c.aW("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.nFy != null) {
            this.paint.setColorFilter(this.nFy.getValue());
        }
        for (int i2 = 0; i2 < this.BN.size(); i2++) {
            C0864a c0864a = this.BN.get(i2);
            if (c0864a.nFz != null) {
                a(canvas, c0864a, matrix);
            } else {
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0864a.BU.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0864a.BU.get(size)).ht(), matrix);
                }
                com.tb.airbnb.lottie.c.aW("StrokeContent#buildPath");
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.tb.airbnb.lottie.c.aW("StrokeContent#drawPath");
            }
        }
        com.tb.airbnb.lottie.c.aW("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0864a c0864a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyTrimPath");
        if (c0864a.nFz == null) {
            com.tb.airbnb.lottie.c.aW("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0864a.BU.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0864a.BU.get(size)).ht(), matrix);
        }
        this.BK.setPath(this.path, false);
        float length = this.BK.getLength();
        while (true) {
            f = length;
            if (!this.BK.nextContour()) {
                break;
            }
            length = this.BK.getLength() + f;
        }
        float floatValue = (c0864a.nFz.dNz().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0864a.nFz.dNx().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0864a.nFz.dNy().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0864a.BU.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.BL.set(((l) c0864a.BU.get(size2)).ht());
            this.BL.transform(matrix);
            this.BK.setPath(this.BL, false);
            float length2 = this.BK.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.tb.airbnb.lottie.d.f.a(this.BL, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.BL, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.BL, this.paint);
                } else {
                    com.tb.airbnb.lottie.d.f.a(this.BL, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.BL, this.paint);
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
        for (int i = 0; i < this.BN.size(); i++) {
            C0864a c0864a = this.BN.get(i);
            for (int i2 = 0; i2 < c0864a.BU.size(); i2++) {
                this.path.addPath(((l) c0864a.BU.get(i2)).ht(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.nFv.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.c.aW("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.BR.isEmpty()) {
            com.tb.airbnb.lottie.c.aW("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.BR.size()) {
                break;
            }
            this.BO[i2] = this.BR.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.BO[i2] < 1.0f) {
                    this.BO[i2] = 1.0f;
                }
            } else if (this.BO[i2] < 0.1f) {
                this.BO[i2] = 0.1f;
            }
            float[] fArr = this.BO;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.BO, this.nFx == null ? 0.0f : this.nFx.getValue().floatValue()));
        com.tb.airbnb.lottie.c.aW("StrokeContent#applyDashPattern");
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Bb) {
            this.nFw.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bi) {
            this.nFv.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Bv) {
            if (cVar == null) {
                this.nFy = null;
                return;
            }
            this.nFy = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.nFy.b(this);
            this.nFu.a(this.nFy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0864a {
        private final List<l> BU;
        @Nullable
        private final r nFz;

        private C0864a(@Nullable r rVar) {
            this.BU = new ArrayList();
            this.nFz = rVar;
        }
    }
}
