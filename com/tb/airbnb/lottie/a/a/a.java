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
public abstract class a implements d, j, a.InterfaceC0730a {
    private final float[] fI;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> fL;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.model.layer.a noU;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> noV;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> noW;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> noX;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> noY;
    private final PathMeasure fE = new PathMeasure();
    private final Path path = new Path();
    private final Path fF = new Path();
    private final RectF rect = new RectF();
    private final List<C0729a> fH = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = fVar;
        this.noU = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.noW = dVar.dFE();
        this.noV = bVar.dFE();
        if (bVar2 == null) {
            this.noX = null;
        } else {
            this.noX = bVar2.dFE();
        }
        this.fL = new ArrayList(list.size());
        this.fI = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.fL.add(list.get(i).dFE());
        }
        aVar.a(this.noW);
        aVar.a(this.noV);
        for (int i2 = 0; i2 < this.fL.size(); i2++) {
            aVar.a(this.fL.get(i2));
        }
        if (this.noX != null) {
            aVar.a(this.noX);
        }
        this.noW.b(this);
        this.noV.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.fL.get(i3).b(this);
        }
        if (this.noX != null) {
            this.noX.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0730a
    public void bC() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0729a c0729a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).dFu() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0729a c0729a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).dFu() == ShapeTrimPath.Type.Individually) {
                if (c0729a2 != null) {
                    this.fH.add(c0729a2);
                }
                C0729a c0729a3 = new C0729a((r) bVar2);
                ((r) bVar2).a(this);
                c0729a = c0729a3;
            } else if (bVar2 instanceof l) {
                c0729a = c0729a2 == null ? new C0729a(rVar) : c0729a2;
                c0729a.fO.add((l) bVar2);
            } else {
                c0729a = c0729a2;
            }
            size2--;
            c0729a2 = c0729a;
        }
        if (c0729a2 != null) {
            this.fH.add(c0729a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.noW.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.noV.getValue().floatValue() * com.tb.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.c.F("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.noY != null) {
            this.paint.setColorFilter(this.noY.getValue());
        }
        for (int i2 = 0; i2 < this.fH.size(); i2++) {
            C0729a c0729a = this.fH.get(i2);
            if (c0729a.noZ != null) {
                a(canvas, c0729a, matrix);
            } else {
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0729a.fO.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0729a.fO.get(size)).bF(), matrix);
                }
                com.tb.airbnb.lottie.c.F("StrokeContent#buildPath");
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.tb.airbnb.lottie.c.F("StrokeContent#drawPath");
            }
        }
        com.tb.airbnb.lottie.c.F("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0729a c0729a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyTrimPath");
        if (c0729a.noZ == null) {
            com.tb.airbnb.lottie.c.F("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0729a.fO.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0729a.fO.get(size)).bF(), matrix);
        }
        this.fE.setPath(this.path, false);
        float length = this.fE.getLength();
        while (true) {
            f = length;
            if (!this.fE.nextContour()) {
                break;
            }
            length = this.fE.getLength() + f;
        }
        float floatValue = (c0729a.noZ.dFx().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0729a.noZ.dFv().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0729a.noZ.dFw().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0729a.fO.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.fF.set(((l) c0729a.fO.get(size2)).bF());
            this.fF.transform(matrix);
            this.fE.setPath(this.fF, false);
            float length2 = this.fE.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.tb.airbnb.lottie.d.f.a(this.fF, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.fF, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.fF, this.paint);
                } else {
                    com.tb.airbnb.lottie.d.f.a(this.fF, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.fF, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.tb.airbnb.lottie.c.F("StrokeContent#applyTrimPath");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.fH.size(); i++) {
            C0729a c0729a = this.fH.get(i);
            for (int i2 = 0; i2 < c0729a.fO.size(); i2++) {
                this.path.addPath(((l) c0729a.fO.get(i2)).bF(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.noV.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.c.F("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.fL.isEmpty()) {
            com.tb.airbnb.lottie.c.F("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fL.size()) {
                break;
            }
            this.fI[i2] = this.fL.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.fI[i2] < 1.0f) {
                    this.fI[i2] = 1.0f;
                }
            } else if (this.fI[i2] < 0.1f) {
                this.fI[i2] = 0.1f;
            }
            float[] fArr = this.fI;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.fI, this.noX == null ? 0.0f : this.noX.getValue().floatValue()));
        com.tb.airbnb.lottie.c.F("StrokeContent#applyDashPattern");
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.eN) {
            this.noW.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eU) {
            this.noV.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fj) {
            if (cVar == null) {
                this.noY = null;
                return;
            }
            this.noY = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.noY.b(this);
            this.noU.a(this.noY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0729a {
        private final List<l> fO;
        @Nullable
        private final r noZ;

        private C0729a(@Nullable r rVar) {
            this.fO = new ArrayList();
            this.noZ = rVar;
        }
    }
}
