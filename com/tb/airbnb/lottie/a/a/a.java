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
/* loaded from: classes16.dex */
public abstract class a implements d, j, a.InterfaceC0947a {
    private final float[] CN;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> CQ;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.model.layer.a oHq;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oHr;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> oHs;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oHt;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> oHu;
    private final PathMeasure CI = new PathMeasure();
    private final Path path = new Path();
    private final Path CJ = new Path();
    private final RectF rect = new RectF();
    private final List<C0946a> CL = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = fVar;
        this.oHq = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.oHs = dVar.ekW();
        this.oHr = bVar.ekW();
        if (bVar2 == null) {
            this.oHt = null;
        } else {
            this.oHt = bVar2.ekW();
        }
        this.CQ = new ArrayList(list.size());
        this.CN = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.CQ.add(list.get(i).ekW());
        }
        aVar.a(this.oHs);
        aVar.a(this.oHr);
        for (int i2 = 0; i2 < this.CQ.size(); i2++) {
            aVar.a(this.CQ.get(i2));
        }
        if (this.oHt != null) {
            aVar.a(this.oHt);
        }
        this.oHs.b(this);
        this.oHr.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.CQ.get(i3).b(this);
        }
        if (this.oHt != null) {
            this.oHt.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0947a
    public void iT() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0946a c0946a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).ekM() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0946a c0946a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).ekM() == ShapeTrimPath.Type.Individually) {
                if (c0946a2 != null) {
                    this.CL.add(c0946a2);
                }
                C0946a c0946a3 = new C0946a((r) bVar2);
                ((r) bVar2).a(this);
                c0946a = c0946a3;
            } else if (bVar2 instanceof l) {
                c0946a = c0946a2 == null ? new C0946a(rVar) : c0946a2;
                c0946a.CX.add((l) bVar2);
            } else {
                c0946a = c0946a2;
            }
            size2--;
            c0946a2 = c0946a;
        }
        if (c0946a2 != null) {
            this.CL.add(c0946a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.oHs.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.oHr.getValue().floatValue() * com.tb.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.c.bb("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.oHu != null) {
            this.paint.setColorFilter(this.oHu.getValue());
        }
        for (int i2 = 0; i2 < this.CL.size(); i2++) {
            C0946a c0946a = this.CL.get(i2);
            if (c0946a.oHv != null) {
                a(canvas, c0946a, matrix);
            } else {
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0946a.CX.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0946a.CX.get(size)).iW(), matrix);
                }
                com.tb.airbnb.lottie.c.bb("StrokeContent#buildPath");
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.tb.airbnb.lottie.c.bb("StrokeContent#drawPath");
            }
        }
        com.tb.airbnb.lottie.c.bb("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0946a c0946a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyTrimPath");
        if (c0946a.oHv == null) {
            com.tb.airbnb.lottie.c.bb("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0946a.CX.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0946a.CX.get(size)).iW(), matrix);
        }
        this.CI.setPath(this.path, false);
        float length = this.CI.getLength();
        while (true) {
            f = length;
            if (!this.CI.nextContour()) {
                break;
            }
            length = this.CI.getLength() + f;
        }
        float floatValue = (c0946a.oHv.ekP().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0946a.oHv.ekN().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0946a.oHv.ekO().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0946a.CX.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.CJ.set(((l) c0946a.CX.get(size2)).iW());
            this.CJ.transform(matrix);
            this.CI.setPath(this.CJ, false);
            float length2 = this.CI.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.tb.airbnb.lottie.d.f.a(this.CJ, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.CJ, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.CJ, this.paint);
                } else {
                    com.tb.airbnb.lottie.d.f.a(this.CJ, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.CJ, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.tb.airbnb.lottie.c.bb("StrokeContent#applyTrimPath");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.CL.size(); i++) {
            C0946a c0946a = this.CL.get(i);
            for (int i2 = 0; i2 < c0946a.CX.size(); i2++) {
                this.path.addPath(((l) c0946a.CX.get(i2)).iW(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.oHr.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.c.bb("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.CQ.isEmpty()) {
            com.tb.airbnb.lottie.c.bb("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.CQ.size()) {
                break;
            }
            this.CN[i2] = this.CQ.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.CN[i2] < 1.0f) {
                    this.CN[i2] = 1.0f;
                }
            } else if (this.CN[i2] < 0.1f) {
                this.CN[i2] = 0.1f;
            }
            float[] fArr = this.CN;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.CN, this.oHt == null ? 0.0f : this.oHt.getValue().floatValue()));
        com.tb.airbnb.lottie.c.bb("StrokeContent#applyDashPattern");
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.BY) {
            this.oHs.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cf) {
            this.oHr.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cs) {
            if (cVar == null) {
                this.oHu = null;
                return;
            }
            this.oHu = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.oHu.b(this);
            this.oHq.a(this.oHu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C0946a {
        private final List<l> CX;
        @Nullable
        private final r oHv;

        private C0946a(@Nullable r rVar) {
            this.CX = new ArrayList();
            this.oHv = rVar;
        }
    }
}
