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
public abstract class a implements d, j, a.InterfaceC0738a {
    private final float[] fM;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> fP;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.model.layer.a npD;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> npE;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> npF;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> npG;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> npH;
    private final PathMeasure fI = new PathMeasure();
    private final Path path = new Path();
    private final Path fJ = new Path();
    private final RectF rect = new RectF();
    private final List<C0737a> fL = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = fVar;
        this.npD = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.npF = dVar.dGP();
        this.npE = bVar.dGP();
        if (bVar2 == null) {
            this.npG = null;
        } else {
            this.npG = bVar2.dGP();
        }
        this.fP = new ArrayList(list.size());
        this.fM = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.fP.add(list.get(i).dGP());
        }
        aVar.a(this.npF);
        aVar.a(this.npE);
        for (int i2 = 0; i2 < this.fP.size(); i2++) {
            aVar.a(this.fP.get(i2));
        }
        if (this.npG != null) {
            aVar.a(this.npG);
        }
        this.npF.b(this);
        this.npE.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.fP.get(i3).b(this);
        }
        if (this.npG != null) {
            this.npG.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0738a
    public void bD() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0737a c0737a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).dGF() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0737a c0737a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).dGF() == ShapeTrimPath.Type.Individually) {
                if (c0737a2 != null) {
                    this.fL.add(c0737a2);
                }
                C0737a c0737a3 = new C0737a((r) bVar2);
                ((r) bVar2).a(this);
                c0737a = c0737a3;
            } else if (bVar2 instanceof l) {
                c0737a = c0737a2 == null ? new C0737a(rVar) : c0737a2;
                c0737a.fS.add((l) bVar2);
            } else {
                c0737a = c0737a2;
            }
            size2--;
            c0737a2 = c0737a;
        }
        if (c0737a2 != null) {
            this.fL.add(c0737a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.npF.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.npE.getValue().floatValue() * com.tb.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.c.F("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.npH != null) {
            this.paint.setColorFilter(this.npH.getValue());
        }
        for (int i2 = 0; i2 < this.fL.size(); i2++) {
            C0737a c0737a = this.fL.get(i2);
            if (c0737a.npI != null) {
                a(canvas, c0737a, matrix);
            } else {
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0737a.fS.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0737a.fS.get(size)).bG(), matrix);
                }
                com.tb.airbnb.lottie.c.F("StrokeContent#buildPath");
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.tb.airbnb.lottie.c.F("StrokeContent#drawPath");
            }
        }
        com.tb.airbnb.lottie.c.F("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0737a c0737a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyTrimPath");
        if (c0737a.npI == null) {
            com.tb.airbnb.lottie.c.F("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0737a.fS.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0737a.fS.get(size)).bG(), matrix);
        }
        this.fI.setPath(this.path, false);
        float length = this.fI.getLength();
        while (true) {
            f = length;
            if (!this.fI.nextContour()) {
                break;
            }
            length = this.fI.getLength() + f;
        }
        float floatValue = (c0737a.npI.dGI().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0737a.npI.dGG().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0737a.npI.dGH().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0737a.fS.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.fJ.set(((l) c0737a.fS.get(size2)).bG());
            this.fJ.transform(matrix);
            this.fI.setPath(this.fJ, false);
            float length2 = this.fI.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.tb.airbnb.lottie.d.f.a(this.fJ, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.fJ, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.fJ, this.paint);
                } else {
                    com.tb.airbnb.lottie.d.f.a(this.fJ, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.fJ, this.paint);
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
        for (int i = 0; i < this.fL.size(); i++) {
            C0737a c0737a = this.fL.get(i);
            for (int i2 = 0; i2 < c0737a.fS.size(); i2++) {
                this.path.addPath(((l) c0737a.fS.get(i2)).bG(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.npE.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.c.F("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.fP.isEmpty()) {
            com.tb.airbnb.lottie.c.F("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fP.size()) {
                break;
            }
            this.fM[i2] = this.fP.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.fM[i2] < 1.0f) {
                    this.fM[i2] = 1.0f;
                }
            } else if (this.fM[i2] < 0.1f) {
                this.fM[i2] = 0.1f;
            }
            float[] fArr = this.fM;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.fM, this.npG == null ? 0.0f : this.npG.getValue().floatValue()));
        com.tb.airbnb.lottie.c.F("StrokeContent#applyDashPattern");
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.eQ) {
            this.npF.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eX) {
            this.npE.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fq) {
            if (cVar == null) {
                this.npH = null;
                return;
            }
            this.npH = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.npH.b(this);
            this.npD.a(this.npH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0737a {
        private final List<l> fS;
        @Nullable
        private final r npI;

        private C0737a(@Nullable r rVar) {
            this.fS = new ArrayList();
            this.npI = rVar;
        }
    }
}
