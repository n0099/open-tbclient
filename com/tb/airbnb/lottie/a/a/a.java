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
public abstract class a implements d, a.InterfaceC0572a {
    private final float[] dV;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> dY;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ksc;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> ksd;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> kse;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final PathMeasure dS = new PathMeasure();
    private final Path path = new Path();
    private final Path dT = new Path();
    private final RectF rect = new RectF();
    private final List<C0571a> dU = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = fVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.ksd = dVar.cLl();
        this.ksc = bVar.cLl();
        if (bVar2 == null) {
            this.kse = null;
        } else {
            this.kse = bVar2.cLl();
        }
        this.dY = new ArrayList(list.size());
        this.dV = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.dY.add(list.get(i).cLl());
        }
        aVar.a(this.ksd);
        aVar.a(this.ksc);
        for (int i2 = 0; i2 < this.dY.size(); i2++) {
            aVar.a(this.dY.get(i2));
        }
        if (this.kse != null) {
            aVar.a(this.kse);
        }
        this.ksd.b(this);
        this.ksc.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.dY.get(i3).b(this);
        }
        if (this.kse != null) {
            this.kse.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0572a
    public void bt() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0571a c0571a;
        int size = list.size() - 1;
        q qVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            qVar = ((bVar instanceof q) && ((q) bVar).cLd() == ShapeTrimPath.Type.Individually) ? (q) bVar : qVar;
        }
        if (qVar != null) {
            qVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0571a c0571a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof q) && ((q) bVar2).cLd() == ShapeTrimPath.Type.Individually) {
                if (c0571a2 != null) {
                    this.dU.add(c0571a2);
                }
                C0571a c0571a3 = new C0571a((q) bVar2);
                ((q) bVar2).a(this);
                c0571a = c0571a3;
            } else if (bVar2 instanceof k) {
                c0571a = c0571a2 == null ? new C0571a(qVar) : c0571a2;
                c0571a.ea.add((k) bVar2);
            } else {
                c0571a = c0571a2;
            }
            size2--;
            c0571a2 = c0571a;
        }
        if (c0571a2 != null) {
            this.dU.add(c0571a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha((int) (((this.ksd.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f));
        this.paint.setStrokeWidth(this.ksc.getValue().floatValue() * com.tb.airbnb.lottie.c.f.c(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.d.D("StrokeContent#draw");
            return;
        }
        a(matrix);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.dU.size()) {
                C0571a c0571a = this.dU.get(i3);
                if (c0571a.ksf != null) {
                    a(canvas, c0571a, matrix);
                } else {
                    com.tb.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                    this.path.reset();
                    for (int size = c0571a.ea.size() - 1; size >= 0; size--) {
                        this.path.addPath(((k) c0571a.ea.get(size)).bw(), matrix);
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

    private void a(Canvas canvas, C0571a c0571a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c0571a.ksf == null) {
            com.tb.airbnb.lottie.d.D("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0571a.ea.size() - 1; size >= 0; size--) {
            this.path.addPath(((k) c0571a.ea.get(size)).bw(), matrix);
        }
        this.dS.setPath(this.path, false);
        float length = this.dS.getLength();
        while (true) {
            f = length;
            if (!this.dS.nextContour()) {
                break;
            }
            length = this.dS.getLength() + f;
        }
        float floatValue = (c0571a.ksf.cLg().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0571a.ksf.cLe().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0571a.ksf.cLf().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0571a.ea.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.dT.set(((k) c0571a.ea.get(size2)).bw());
            this.dT.transform(matrix);
            this.dS.setPath(this.dT, false);
            float length2 = this.dS.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.tb.airbnb.lottie.c.f.a(this.dT, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.dT, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.dT, this.paint);
                } else {
                    com.tb.airbnb.lottie.c.f.a(this.dT, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.dT, this.paint);
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
        for (int i = 0; i < this.dU.size(); i++) {
            C0571a c0571a = this.dU.get(i);
            for (int i2 = 0; i2 < c0571a.ea.size(); i2++) {
                this.path.addPath(((k) c0571a.ea.get(i2)).bw(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.ksc.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.d.D("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.dY.isEmpty()) {
            com.tb.airbnb.lottie.d.D("StrokeContent#applyDashPattern");
            return;
        }
        float c = com.tb.airbnb.lottie.c.f.c(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dY.size()) {
                break;
            }
            this.dV[i2] = this.dY.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.dV[i2] < 1.0f) {
                    this.dV[i2] = 1.0f;
                }
            } else if (this.dV[i2] < 0.1f) {
                this.dV[i2] = 0.1f;
            }
            float[] fArr = this.dV;
            fArr[i2] = fArr[i2] * c;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.dV, this.kse == null ? 0.0f : this.kse.getValue().floatValue()));
        com.tb.airbnb.lottie.d.D("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0571a {
        private final List<k> ea;
        @Nullable
        private final q ksf;

        private C0571a(@Nullable q qVar) {
            this.ea = new ArrayList();
            this.ksf = qVar;
        }
    }
}
