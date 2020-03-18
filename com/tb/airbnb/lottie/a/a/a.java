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
public abstract class a implements d, j, a.InterfaceC0739a {
    private final float[] fL;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> fO;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.model.layer.a nrB;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nrC;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> nrD;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nrE;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> nrF;
    private final PathMeasure fH = new PathMeasure();
    private final Path path = new Path();
    private final Path fI = new Path();
    private final RectF rect = new RectF();
    private final List<C0738a> fK = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = fVar;
        this.nrB = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.nrD = dVar.dHq();
        this.nrC = bVar.dHq();
        if (bVar2 == null) {
            this.nrE = null;
        } else {
            this.nrE = bVar2.dHq();
        }
        this.fO = new ArrayList(list.size());
        this.fL = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.fO.add(list.get(i).dHq());
        }
        aVar.a(this.nrD);
        aVar.a(this.nrC);
        for (int i2 = 0; i2 < this.fO.size(); i2++) {
            aVar.a(this.fO.get(i2));
        }
        if (this.nrE != null) {
            aVar.a(this.nrE);
        }
        this.nrD.b(this);
        this.nrC.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.fO.get(i3).b(this);
        }
        if (this.nrE != null) {
            this.nrE.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0739a
    public void bD() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0738a c0738a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).dHg() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0738a c0738a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).dHg() == ShapeTrimPath.Type.Individually) {
                if (c0738a2 != null) {
                    this.fK.add(c0738a2);
                }
                C0738a c0738a3 = new C0738a((r) bVar2);
                ((r) bVar2).a(this);
                c0738a = c0738a3;
            } else if (bVar2 instanceof l) {
                c0738a = c0738a2 == null ? new C0738a(rVar) : c0738a2;
                c0738a.fR.add((l) bVar2);
            } else {
                c0738a = c0738a2;
            }
            size2--;
            c0738a2 = c0738a;
        }
        if (c0738a2 != null) {
            this.fK.add(c0738a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.nrD.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.nrC.getValue().floatValue() * com.tb.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.c.F("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.nrF != null) {
            this.paint.setColorFilter(this.nrF.getValue());
        }
        for (int i2 = 0; i2 < this.fK.size(); i2++) {
            C0738a c0738a = this.fK.get(i2);
            if (c0738a.nrG != null) {
                a(canvas, c0738a, matrix);
            } else {
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0738a.fR.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0738a.fR.get(size)).bG(), matrix);
                }
                com.tb.airbnb.lottie.c.F("StrokeContent#buildPath");
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.tb.airbnb.lottie.c.F("StrokeContent#drawPath");
            }
        }
        com.tb.airbnb.lottie.c.F("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0738a c0738a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyTrimPath");
        if (c0738a.nrG == null) {
            com.tb.airbnb.lottie.c.F("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0738a.fR.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0738a.fR.get(size)).bG(), matrix);
        }
        this.fH.setPath(this.path, false);
        float length = this.fH.getLength();
        while (true) {
            f = length;
            if (!this.fH.nextContour()) {
                break;
            }
            length = this.fH.getLength() + f;
        }
        float floatValue = (c0738a.nrG.dHj().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0738a.nrG.dHh().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0738a.nrG.dHi().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0738a.fR.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.fI.set(((l) c0738a.fR.get(size2)).bG());
            this.fI.transform(matrix);
            this.fH.setPath(this.fI, false);
            float length2 = this.fH.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.tb.airbnb.lottie.d.f.a(this.fI, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.fI, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.fI, this.paint);
                } else {
                    com.tb.airbnb.lottie.d.f.a(this.fI, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.fI, this.paint);
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
        for (int i = 0; i < this.fK.size(); i++) {
            C0738a c0738a = this.fK.get(i);
            for (int i2 = 0; i2 < c0738a.fR.size(); i2++) {
                this.path.addPath(((l) c0738a.fR.get(i2)).bG(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.nrC.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.c.F("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.fO.isEmpty()) {
            com.tb.airbnb.lottie.c.F("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fO.size()) {
                break;
            }
            this.fL[i2] = this.fO.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.fL[i2] < 1.0f) {
                    this.fL[i2] = 1.0f;
                }
            } else if (this.fL[i2] < 0.1f) {
                this.fL[i2] = 0.1f;
            }
            float[] fArr = this.fL;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.fL, this.nrE == null ? 0.0f : this.nrE.getValue().floatValue()));
        com.tb.airbnb.lottie.c.F("StrokeContent#applyDashPattern");
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.eP) {
            this.nrD.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.eW) {
            this.nrC.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.fo) {
            if (cVar == null) {
                this.nrF = null;
                return;
            }
            this.nrF = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.nrF.b(this);
            this.nrB.a(this.nrF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0738a {
        private final List<l> fR;
        @Nullable
        private final r nrG;

        private C0738a(@Nullable r rVar) {
            this.fR = new ArrayList();
            this.nrG = rVar;
        }
    }
}
