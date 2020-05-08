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
public abstract class a implements d, j, a.InterfaceC0784a {
    private final float[] Bo;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> Br;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.model.layer.a mOn;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOo;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> mOp;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOq;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> mOr;
    private final PathMeasure Bk = new PathMeasure();
    private final Path path = new Path();
    private final Path Bl = new Path();
    private final RectF rect = new RectF();
    private final List<C0783a> Bn = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = fVar;
        this.mOn = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.mOp = dVar.dBo();
        this.mOo = bVar.dBo();
        if (bVar2 == null) {
            this.mOq = null;
        } else {
            this.mOq = bVar2.dBo();
        }
        this.Br = new ArrayList(list.size());
        this.Bo = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.Br.add(list.get(i).dBo());
        }
        aVar.a(this.mOp);
        aVar.a(this.mOo);
        for (int i2 = 0; i2 < this.Br.size(); i2++) {
            aVar.a(this.Br.get(i2));
        }
        if (this.mOq != null) {
            aVar.a(this.mOq);
        }
        this.mOp.b(this);
        this.mOo.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.Br.get(i3).b(this);
        }
        if (this.mOq != null) {
            this.mOq.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0784a
    public void ha() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0783a c0783a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).dBe() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0783a c0783a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).dBe() == ShapeTrimPath.Type.Individually) {
                if (c0783a2 != null) {
                    this.Bn.add(c0783a2);
                }
                C0783a c0783a3 = new C0783a((r) bVar2);
                ((r) bVar2).a(this);
                c0783a = c0783a3;
            } else if (bVar2 instanceof l) {
                c0783a = c0783a2 == null ? new C0783a(rVar) : c0783a2;
                c0783a.Bu.add((l) bVar2);
            } else {
                c0783a = c0783a2;
            }
            size2--;
            c0783a2 = c0783a;
        }
        if (c0783a2 != null) {
            this.Bn.add(c0783a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.mOp.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.mOo.getValue().floatValue() * com.tb.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.c.aV("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.mOr != null) {
            this.paint.setColorFilter(this.mOr.getValue());
        }
        for (int i2 = 0; i2 < this.Bn.size(); i2++) {
            C0783a c0783a = this.Bn.get(i2);
            if (c0783a.mOs != null) {
                a(canvas, c0783a, matrix);
            } else {
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0783a.Bu.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0783a.Bu.get(size)).hd(), matrix);
                }
                com.tb.airbnb.lottie.c.aV("StrokeContent#buildPath");
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.tb.airbnb.lottie.c.aV("StrokeContent#drawPath");
            }
        }
        com.tb.airbnb.lottie.c.aV("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0783a c0783a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyTrimPath");
        if (c0783a.mOs == null) {
            com.tb.airbnb.lottie.c.aV("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0783a.Bu.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0783a.Bu.get(size)).hd(), matrix);
        }
        this.Bk.setPath(this.path, false);
        float length = this.Bk.getLength();
        while (true) {
            f = length;
            if (!this.Bk.nextContour()) {
                break;
            }
            length = this.Bk.getLength() + f;
        }
        float floatValue = (c0783a.mOs.dBh().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0783a.mOs.dBf().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0783a.mOs.dBg().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0783a.Bu.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.Bl.set(((l) c0783a.Bu.get(size2)).hd());
            this.Bl.transform(matrix);
            this.Bk.setPath(this.Bl, false);
            float length2 = this.Bk.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.tb.airbnb.lottie.d.f.a(this.Bl, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.Bl, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.Bl, this.paint);
                } else {
                    com.tb.airbnb.lottie.d.f.a(this.Bl, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.Bl, this.paint);
                }
            }
            size2--;
            f2 += length2;
        }
        com.tb.airbnb.lottie.c.aV("StrokeContent#applyTrimPath");
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.Bn.size(); i++) {
            C0783a c0783a = this.Bn.get(i);
            for (int i2 = 0; i2 < c0783a.Bu.size(); i2++) {
                this.path.addPath(((l) c0783a.Bu.get(i2)).hd(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.mOo.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.c.aV("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.Br.isEmpty()) {
            com.tb.airbnb.lottie.c.aV("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.Br.size()) {
                break;
            }
            this.Bo[i2] = this.Br.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.Bo[i2] < 1.0f) {
                    this.Bo[i2] = 1.0f;
                }
            } else if (this.Bo[i2] < 0.1f) {
                this.Bo[i2] = 0.1f;
            }
            float[] fArr = this.Bo;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.Bo, this.mOq == null ? 0.0f : this.mOq.getValue().floatValue()));
        com.tb.airbnb.lottie.c.aV("StrokeContent#applyDashPattern");
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.Ay) {
            this.mOp.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AF) {
            this.mOo.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.AV) {
            if (cVar == null) {
                this.mOr = null;
                return;
            }
            this.mOr = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.mOr.b(this);
            this.mOn.a(this.mOr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0783a {
        private final List<l> Bu;
        @Nullable
        private final r mOs;

        private C0783a(@Nullable r rVar) {
            this.Bu = new ArrayList();
            this.mOs = rVar;
        }
    }
}
