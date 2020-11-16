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
/* loaded from: classes17.dex */
public abstract class a implements d, j, a.InterfaceC1041a {
    private final float[] CN;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> CQ;
    private final com.tb.airbnb.lottie.g lottieDrawable;
    private final com.tb.airbnb.lottie.model.layer.a pJK;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pJL;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> pJM;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pJN;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> pJO;
    private final PathMeasure CI = new PathMeasure();
    private final Path path = new Path();
    private final Path CJ = new Path();
    private final RectF rect = new RectF();
    private final List<C1040a> CL = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = gVar;
        this.pJK = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.pJM = dVar.eyM();
        this.pJL = bVar.eyM();
        if (bVar2 == null) {
            this.pJN = null;
        } else {
            this.pJN = bVar2.eyM();
        }
        this.CQ = new ArrayList(list.size());
        this.CN = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.CQ.add(list.get(i).eyM());
        }
        aVar.a(this.pJM);
        aVar.a(this.pJL);
        for (int i2 = 0; i2 < this.CQ.size(); i2++) {
            aVar.a(this.CQ.get(i2));
        }
        if (this.pJN != null) {
            aVar.a(this.pJN);
        }
        this.pJM.b(this);
        this.pJL.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.CQ.get(i3).b(this);
        }
        if (this.pJN != null) {
            this.pJN.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1041a
    public void iT() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C1040a c1040a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).eyC() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C1040a c1040a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).eyC() == ShapeTrimPath.Type.Individually) {
                if (c1040a2 != null) {
                    this.CL.add(c1040a2);
                }
                C1040a c1040a3 = new C1040a((r) bVar2);
                ((r) bVar2).a(this);
                c1040a = c1040a3;
            } else if (bVar2 instanceof l) {
                c1040a = c1040a2 == null ? new C1040a(rVar) : c1040a2;
                c1040a.CX.add((l) bVar2);
            } else {
                c1040a = c1040a2;
            }
            size2--;
            c1040a2 = c1040a;
        }
        if (c1040a2 != null) {
            this.CL.add(c1040a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.pJM.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.pJL.getValue().floatValue() * com.tb.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.d.bb("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.pJO != null) {
            this.paint.setColorFilter(this.pJO.getValue());
        }
        for (int i2 = 0; i2 < this.CL.size(); i2++) {
            C1040a c1040a = this.CL.get(i2);
            if (c1040a.pJP != null) {
                a(canvas, c1040a, matrix);
            } else {
                com.tb.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c1040a.CX.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c1040a.CX.get(size)).iW(), matrix);
                }
                com.tb.airbnb.lottie.d.bb("StrokeContent#buildPath");
                com.tb.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.tb.airbnb.lottie.d.bb("StrokeContent#drawPath");
            }
        }
        com.tb.airbnb.lottie.d.bb("StrokeContent#draw");
    }

    private void a(Canvas canvas, C1040a c1040a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c1040a.pJP == null) {
            com.tb.airbnb.lottie.d.bb("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c1040a.CX.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c1040a.CX.get(size)).iW(), matrix);
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
        float floatValue = (c1040a.pJP.eyF().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c1040a.pJP.eyD().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c1040a.pJP.eyE().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c1040a.CX.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.CJ.set(((l) c1040a.CX.get(size2)).iW());
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
        com.tb.airbnb.lottie.d.bb("StrokeContent#applyTrimPath");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.CL.size(); i++) {
            C1040a c1040a = this.CL.get(i);
            for (int i2 = 0; i2 < c1040a.CX.size(); i2++) {
                this.path.addPath(((l) c1040a.CX.get(i2)).iW(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.pJL.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.d.bb("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.CQ.isEmpty()) {
            com.tb.airbnb.lottie.d.bb("StrokeContent#applyDashPattern");
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
        this.paint.setPathEffect(new DashPathEffect(this.CN, this.pJN == null ? 0.0f : this.pJN.getValue().floatValue()));
        com.tb.airbnb.lottie.d.bb("StrokeContent#applyDashPattern");
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.k.BY) {
            this.pJM.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Cf) {
            this.pJL.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Cs) {
            if (cVar == null) {
                this.pJO = null;
                return;
            }
            this.pJO = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.pJO.b(this);
            this.pJK.a(this.pJO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C1040a {
        private final List<l> CX;
        @Nullable
        private final r pJP;

        private C1040a(@Nullable r rVar) {
            this.CX = new ArrayList();
            this.pJP = rVar;
        }
    }
}
