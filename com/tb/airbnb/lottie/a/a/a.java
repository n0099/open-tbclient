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
/* loaded from: classes20.dex */
public abstract class a implements d, j, a.InterfaceC1019a {
    private final float[] DJ;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> DN;
    private final com.tb.airbnb.lottie.g lottieDrawable;
    private final com.tb.airbnb.lottie.model.layer.a pAQ;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pAR;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> pAS;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pAT;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> pAU;
    private final PathMeasure DE = new PathMeasure();
    private final Path path = new Path();
    private final Path DG = new Path();
    private final RectF rect = new RectF();
    private final List<C1018a> DI = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = gVar;
        this.pAQ = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.pAS = dVar.eBj();
        this.pAR = bVar.eBj();
        if (bVar2 == null) {
            this.pAT = null;
        } else {
            this.pAT = bVar2.eBj();
        }
        this.DN = new ArrayList(list.size());
        this.DJ = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.DN.add(list.get(i).eBj());
        }
        aVar.a(this.pAS);
        aVar.a(this.pAR);
        for (int i2 = 0; i2 < this.DN.size(); i2++) {
            aVar.a(this.DN.get(i2));
        }
        if (this.pAT != null) {
            aVar.a(this.pAT);
        }
        this.pAS.b(this);
        this.pAR.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.DN.get(i3).b(this);
        }
        if (this.pAT != null) {
            this.pAT.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1019a
    public void iT() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C1018a c1018a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).eAZ() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C1018a c1018a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).eAZ() == ShapeTrimPath.Type.Individually) {
                if (c1018a2 != null) {
                    this.DI.add(c1018a2);
                }
                C1018a c1018a3 = new C1018a((r) bVar2);
                ((r) bVar2).a(this);
                c1018a = c1018a3;
            } else if (bVar2 instanceof l) {
                c1018a = c1018a2 == null ? new C1018a(rVar) : c1018a2;
                c1018a.DR.add((l) bVar2);
            } else {
                c1018a = c1018a2;
            }
            size2--;
            c1018a2 = c1018a;
        }
        if (c1018a2 != null) {
            this.DI.add(c1018a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.pAS.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.pAR.getValue().floatValue() * com.tb.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.d.be("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.pAU != null) {
            this.paint.setColorFilter(this.pAU.getValue());
        }
        for (int i2 = 0; i2 < this.DI.size(); i2++) {
            C1018a c1018a = this.DI.get(i2);
            if (c1018a.pAV != null) {
                a(canvas, c1018a, matrix);
            } else {
                com.tb.airbnb.lottie.d.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c1018a.DR.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c1018a.DR.get(size)).iW(), matrix);
                }
                com.tb.airbnb.lottie.d.be("StrokeContent#buildPath");
                com.tb.airbnb.lottie.d.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.tb.airbnb.lottie.d.be("StrokeContent#drawPath");
            }
        }
        com.tb.airbnb.lottie.d.be("StrokeContent#draw");
    }

    private void a(Canvas canvas, C1018a c1018a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#applyTrimPath");
        if (c1018a.pAV == null) {
            com.tb.airbnb.lottie.d.be("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c1018a.DR.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c1018a.DR.get(size)).iW(), matrix);
        }
        this.DE.setPath(this.path, false);
        float length = this.DE.getLength();
        while (true) {
            f = length;
            if (!this.DE.nextContour()) {
                break;
            }
            length = this.DE.getLength() + f;
        }
        float floatValue = (c1018a.pAV.eBc().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c1018a.pAV.eBa().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c1018a.pAV.eBb().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c1018a.DR.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.DG.set(((l) c1018a.DR.get(size2)).iW());
            this.DG.transform(matrix);
            this.DE.setPath(this.DG, false);
            float length2 = this.DE.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.tb.airbnb.lottie.d.f.a(this.DG, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.DG, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.DG, this.paint);
                } else {
                    com.tb.airbnb.lottie.d.f.a(this.DG, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.DG, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.tb.airbnb.lottie.d.be("StrokeContent#applyTrimPath");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.DI.size(); i++) {
            C1018a c1018a = this.DI.get(i);
            for (int i2 = 0; i2 < c1018a.DR.size(); i2++) {
                this.path.addPath(((l) c1018a.DR.get(i2)).iW(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.pAR.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.d.be("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.d.beginSection("StrokeContent#applyDashPattern");
        if (this.DN.isEmpty()) {
            com.tb.airbnb.lottie.d.be("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.DN.size()) {
                break;
            }
            this.DJ[i2] = this.DN.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.DJ[i2] < 1.0f) {
                    this.DJ[i2] = 1.0f;
                }
            } else if (this.DJ[i2] < 0.1f) {
                this.DJ[i2] = 0.1f;
            }
            float[] fArr = this.DJ;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.DJ, this.pAT == null ? 0.0f : this.pAT.getValue().floatValue()));
        com.tb.airbnb.lottie.d.be("StrokeContent#applyDashPattern");
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.k.CQ) {
            this.pAS.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Db) {
            this.pAR.a(cVar);
        } else if (t == com.tb.airbnb.lottie.k.Do) {
            if (cVar == null) {
                this.pAU = null;
                return;
            }
            this.pAU = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.pAU.b(this);
            this.pAQ.a(this.pAU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C1018a {
        private final List<l> DR;
        @Nullable
        private final r pAV;

        private C1018a(@Nullable r rVar) {
            this.DR = new ArrayList();
            this.pAV = rVar;
        }
    }
}
