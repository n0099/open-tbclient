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
/* loaded from: classes6.dex */
public abstract class a implements d, a.InterfaceC0577a {
    private final float[] ev;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> ey;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ksT;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> ksU;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ksV;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final PathMeasure er = new PathMeasure();
    private final Path path = new Path();
    private final Path es = new Path();
    private final RectF rect = new RectF();
    private final List<C0576a> eu = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = fVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.ksU = dVar.cLn();
        this.ksT = bVar.cLn();
        if (bVar2 == null) {
            this.ksV = null;
        } else {
            this.ksV = bVar2.cLn();
        }
        this.ey = new ArrayList(list.size());
        this.ev = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.ey.add(list.get(i).cLn());
        }
        aVar.a(this.ksU);
        aVar.a(this.ksT);
        for (int i2 = 0; i2 < this.ey.size(); i2++) {
            aVar.a(this.ey.get(i2));
        }
        if (this.ksV != null) {
            aVar.a(this.ksV);
        }
        this.ksU.b(this);
        this.ksT.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.ey.get(i3).b(this);
        }
        if (this.ksV != null) {
            this.ksV.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0577a
    public void bt() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0576a c0576a;
        int size = list.size() - 1;
        q qVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            qVar = ((bVar instanceof q) && ((q) bVar).cLf() == ShapeTrimPath.Type.Individually) ? (q) bVar : qVar;
        }
        if (qVar != null) {
            qVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0576a c0576a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof q) && ((q) bVar2).cLf() == ShapeTrimPath.Type.Individually) {
                if (c0576a2 != null) {
                    this.eu.add(c0576a2);
                }
                C0576a c0576a3 = new C0576a((q) bVar2);
                ((q) bVar2).a(this);
                c0576a = c0576a3;
            } else if (bVar2 instanceof k) {
                c0576a = c0576a2 == null ? new C0576a(qVar) : c0576a2;
                c0576a.eA.add((k) bVar2);
            } else {
                c0576a = c0576a2;
            }
            size2--;
            c0576a2 = c0576a;
        }
        if (c0576a2 != null) {
            this.eu.add(c0576a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha((int) (((this.ksU.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.paint.setStrokeWidth(this.ksT.getValue().floatValue() * com.tb.airbnb.lottie.c.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.d.D("StrokeContent#draw");
            return;
        }
        a(matrix);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.eu.size()) {
                C0576a c0576a = this.eu.get(i3);
                if (c0576a.ksW != null) {
                    a(canvas, c0576a, matrix);
                } else {
                    com.tb.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                    this.path.reset();
                    for (int size = c0576a.eA.size() - 1; size >= 0; size--) {
                        this.path.addPath(((k) c0576a.eA.get(size)).bw(), matrix);
                    }
                    com.tb.airbnb.lottie.d.D("StrokeContent#buildPath");
                    com.tb.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                    canvas.drawPath(this.path, this.paint);
                    com.tb.airbnb.lottie.d.D("StrokeContent#drawPath");
                }
                i2 = i3 + 1;
            } else {
                com.tb.airbnb.lottie.d.D("StrokeContent#draw");
                return;
            }
        }
    }

    private void a(Canvas canvas, C0576a c0576a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0576a.ksW == null) {
            com.tb.airbnb.lottie.d.D("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0576a.eA.size() - 1; size >= 0; size--) {
            this.path.addPath(((k) c0576a.eA.get(size)).bw(), matrix);
        }
        this.er.setPath(this.path, false);
        float length = this.er.getLength();
        while (true) {
            f = length;
            if (!this.er.nextContour()) {
                break;
            }
            length = this.er.getLength() + f;
        }
        float floatValue = (c0576a.ksW.cLi().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0576a.ksW.cLg().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0576a.ksW.cLh().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0576a.eA.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.es.set(((k) c0576a.eA.get(size2)).bw());
            this.es.transform(matrix);
            this.er.setPath(this.es, false);
            float length2 = this.er.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.tb.airbnb.lottie.c.f.a(this.es, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.es, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.es, this.paint);
                } else {
                    com.tb.airbnb.lottie.c.f.a(this.es, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.es, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.tb.airbnb.lottie.d.D("StrokeContent#applyTrimPath");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.eu.size(); i++) {
            C0576a c0576a = this.eu.get(i);
            for (int i2 = 0; i2 < c0576a.eA.size(); i2++) {
                this.path.addPath(((k) c0576a.eA.get(i2)).bw(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.ksT.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.d.D("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.ey.isEmpty()) {
            com.tb.airbnb.lottie.d.D("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.tb.airbnb.lottie.c.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ey.size()) {
                break;
            }
            this.ev[i2] = this.ey.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.ev[i2] < 1.0f) {
                    this.ev[i2] = 1.0f;
                }
            } else if (this.ev[i2] < 0.1f) {
                this.ev[i2] = 0.1f;
            }
            float[] fArr = this.ev;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.ev, this.ksV == null ? 0.0f : this.ksV.getValue().floatValue()));
        com.tb.airbnb.lottie.d.D("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0576a {
        private final List<k> eA;
        @Nullable
        private final q ksW;

        private C0576a(@Nullable q qVar) {
            this.eA = new ArrayList();
            this.ksW = qVar;
        }
    }
}
