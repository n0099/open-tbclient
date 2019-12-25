package com.tb.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a implements d, a.InterfaceC0687a {
    private final float[] fI;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> fL;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mMQ;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> mMR;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mMS;
    private final PathMeasure fE = new PathMeasure();
    private final Path path = new Path();
    private final Path fF = new Path();
    private final RectF rect = new RectF();
    private final List<C0686a> fH = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = fVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.mMR = dVar.dBq();
        this.mMQ = bVar.dBq();
        if (bVar2 == null) {
            this.mMS = null;
        } else {
            this.mMS = bVar2.dBq();
        }
        this.fL = new ArrayList(list.size());
        this.fI = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.fL.add(list.get(i).dBq());
        }
        aVar.a(this.mMR);
        aVar.a(this.mMQ);
        for (int i2 = 0; i2 < this.fL.size(); i2++) {
            aVar.a(this.fL.get(i2));
        }
        if (this.mMS != null) {
            aVar.a(this.mMS);
        }
        this.mMR.b(this);
        this.mMQ.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.fL.get(i3).b(this);
        }
        if (this.mMS != null) {
            this.mMS.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0687a
    public void bC() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0686a c0686a;
        int size = list.size() - 1;
        q qVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            qVar = ((bVar instanceof q) && ((q) bVar).dBh() == ShapeTrimPath.Type.Individually) ? (q) bVar : qVar;
        }
        if (qVar != null) {
            qVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0686a c0686a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof q) && ((q) bVar2).dBh() == ShapeTrimPath.Type.Individually) {
                if (c0686a2 != null) {
                    this.fH.add(c0686a2);
                }
                C0686a c0686a3 = new C0686a((q) bVar2);
                ((q) bVar2).a(this);
                c0686a = c0686a3;
            } else if (bVar2 instanceof k) {
                c0686a = c0686a2 == null ? new C0686a(qVar) : c0686a2;
                c0686a.fO.add((k) bVar2);
            } else {
                c0686a = c0686a2;
            }
            size2--;
            c0686a2 = c0686a;
        }
        if (c0686a2 != null) {
            this.fH.add(c0686a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha((int) (((this.mMR.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.paint.setStrokeWidth(this.mMQ.getValue().floatValue() * com.tb.airbnb.lottie.c.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.d.F("StrokeContent#draw");
            return;
        }
        a(matrix);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.fH.size()) {
                C0686a c0686a = this.fH.get(i3);
                if (c0686a.mMT != null) {
                    a(canvas, c0686a, matrix);
                } else {
                    com.tb.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                    this.path.reset();
                    for (int size = c0686a.fO.size() - 1; size >= 0; size--) {
                        this.path.addPath(((k) c0686a.fO.get(size)).bF(), matrix);
                    }
                    com.tb.airbnb.lottie.d.F("StrokeContent#buildPath");
                    com.tb.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                    canvas.drawPath(this.path, this.paint);
                    com.tb.airbnb.lottie.d.F("StrokeContent#drawPath");
                }
                i2 = i3 + 1;
            } else {
                com.tb.airbnb.lottie.d.F("StrokeContent#draw");
                return;
            }
        }
    }

    private void a(Canvas canvas, C0686a c0686a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0686a.mMT == null) {
            com.tb.airbnb.lottie.d.F("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0686a.fO.size() - 1; size >= 0; size--) {
            this.path.addPath(((k) c0686a.fO.get(size)).bF(), matrix);
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
        float floatValue = (c0686a.mMT.dBk().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0686a.mMT.dBi().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0686a.mMT.dBj().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0686a.fO.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.fF.set(((k) c0686a.fO.get(size2)).bF());
            this.fF.transform(matrix);
            this.fE.setPath(this.fF, false);
            float length2 = this.fE.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.tb.airbnb.lottie.c.f.a(this.fF, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.fF, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.fF, this.paint);
                } else {
                    com.tb.airbnb.lottie.c.f.a(this.fF, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.fF, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.tb.airbnb.lottie.d.F("StrokeContent#applyTrimPath");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.fH.size(); i++) {
            C0686a c0686a = this.fH.get(i);
            for (int i2 = 0; i2 < c0686a.fO.size(); i2++) {
                this.path.addPath(((k) c0686a.fO.get(i2)).bF(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.mMQ.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.d.F("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.fL.isEmpty()) {
            com.tb.airbnb.lottie.d.F("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.tb.airbnb.lottie.c.f.b(matrix);
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
        this.paint.setPathEffect(new DashPathEffect(this.fI, this.mMS == null ? 0.0f : this.mMS.getValue().floatValue()));
        com.tb.airbnb.lottie.d.F("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0686a {
        private final List<k> fO;
        @Nullable
        private final q mMT;

        private C0686a(@Nullable q qVar) {
            this.fO = new ArrayList();
            this.mMT = qVar;
        }
    }
}
