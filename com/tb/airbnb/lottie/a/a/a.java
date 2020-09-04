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
/* loaded from: classes7.dex */
public abstract class a implements d, j, a.InterfaceC0932a {
    private final float[] Cu;
    private final List<com.tb.airbnb.lottie.a.b.a<?, Float>> Cx;
    private final com.tb.airbnb.lottie.f lottieDrawable;
    private final com.tb.airbnb.lottie.model.layer.a oiq;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oir;
    private final com.tb.airbnb.lottie.a.b.a<?, Integer> ois;
    @Nullable
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oit;
    @Nullable
    private com.tb.airbnb.lottie.a.b.a<ColorFilter, ColorFilter> oiu;
    private final PathMeasure Cq = new PathMeasure();
    private final Path path = new Path();
    private final Path Cr = new Path();
    private final RectF rect = new RectF();
    private final List<C0931a> Ct = new ArrayList();
    final Paint paint = new Paint(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.b bVar, List<com.tb.airbnb.lottie.model.a.b> list, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.lottieDrawable = fVar;
        this.oiq = aVar;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(f);
        this.ois = dVar.edo();
        this.oir = bVar.edo();
        if (bVar2 == null) {
            this.oit = null;
        } else {
            this.oit = bVar2.edo();
        }
        this.Cx = new ArrayList(list.size());
        this.Cu = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.Cx.add(list.get(i).edo());
        }
        aVar.a(this.ois);
        aVar.a(this.oir);
        for (int i2 = 0; i2 < this.Cx.size(); i2++) {
            aVar.a(this.Cx.get(i2));
        }
        if (this.oit != null) {
            aVar.a(this.oit);
        }
        this.ois.b(this);
        this.oir.b(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.Cx.get(i3).b(this);
        }
        if (this.oit != null) {
            this.oit.b(this);
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0932a
    public void iR() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
        C0931a c0931a;
        int size = list.size() - 1;
        r rVar = null;
        while (size >= 0) {
            b bVar = list.get(size);
            size--;
            rVar = ((bVar instanceof r) && ((r) bVar).ede() == ShapeTrimPath.Type.Individually) ? (r) bVar : rVar;
        }
        if (rVar != null) {
            rVar.a(this);
        }
        int size2 = list2.size() - 1;
        C0931a c0931a2 = null;
        while (size2 >= 0) {
            b bVar2 = list2.get(size2);
            if ((bVar2 instanceof r) && ((r) bVar2).ede() == ShapeTrimPath.Type.Individually) {
                if (c0931a2 != null) {
                    this.Ct.add(c0931a2);
                }
                C0931a c0931a3 = new C0931a((r) bVar2);
                ((r) bVar2).a(this);
                c0931a = c0931a3;
            } else if (bVar2 instanceof l) {
                c0931a = c0931a2 == null ? new C0931a(rVar) : c0931a2;
                c0931a.CB.add((l) bVar2);
            } else {
                c0931a = c0931a2;
            }
            size2--;
            c0931a2 = c0931a;
        }
        if (c0931a2 != null) {
            this.Ct.add(c0931a2);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#draw");
        this.paint.setAlpha(com.tb.airbnb.lottie.d.e.clamp((int) (((this.ois.getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(this.oir.getValue().floatValue() * com.tb.airbnb.lottie.d.f.b(matrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            com.tb.airbnb.lottie.c.bb("StrokeContent#draw");
            return;
        }
        a(matrix);
        if (this.oiu != null) {
            this.paint.setColorFilter(this.oiu.getValue());
        }
        for (int i2 = 0; i2 < this.Ct.size(); i2++) {
            C0931a c0931a = this.Ct.get(i2);
            if (c0931a.oiv != null) {
                a(canvas, c0931a, matrix);
            } else {
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = c0931a.CB.size() - 1; size >= 0; size--) {
                    this.path.addPath(((l) c0931a.CB.get(size)).iU(), matrix);
                }
                com.tb.airbnb.lottie.c.bb("StrokeContent#buildPath");
                com.tb.airbnb.lottie.c.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                com.tb.airbnb.lottie.c.bb("StrokeContent#drawPath");
            }
        }
        com.tb.airbnb.lottie.c.bb("StrokeContent#draw");
    }

    private void a(Canvas canvas, C0931a c0931a, Matrix matrix) {
        float f;
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyTrimPath");
        if (c0931a.oiv == null) {
            com.tb.airbnb.lottie.c.bb("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = c0931a.CB.size() - 1; size >= 0; size--) {
            this.path.addPath(((l) c0931a.CB.get(size)).iU(), matrix);
        }
        this.Cq.setPath(this.path, false);
        float length = this.Cq.getLength();
        while (true) {
            f = length;
            if (!this.Cq.nextContour()) {
                break;
            }
            length = this.Cq.getLength() + f;
        }
        float floatValue = (c0931a.oiv.edh().getValue().floatValue() * f) / 360.0f;
        float floatValue2 = ((c0931a.oiv.edf().getValue().floatValue() * f) / 100.0f) + floatValue;
        float floatValue3 = ((c0931a.oiv.edg().getValue().floatValue() * f) / 100.0f) + floatValue;
        int size2 = c0931a.CB.size() - 1;
        float f2 = 0.0f;
        while (size2 >= 0) {
            this.Cr.set(((l) c0931a.CB.get(size2)).iU());
            this.Cr.transform(matrix);
            this.Cq.setPath(this.Cr, false);
            float length2 = this.Cq.getLength();
            if (floatValue3 > f && floatValue3 - f < f2 + length2 && f2 < floatValue3 - f) {
                com.tb.airbnb.lottie.d.f.a(this.Cr, floatValue2 > f ? (floatValue2 - f) / length2 : 0.0f, Math.min((floatValue3 - f) / length2, 1.0f), 0.0f);
                canvas.drawPath(this.Cr, this.paint);
            } else if (f2 + length2 >= floatValue2 && f2 <= floatValue3) {
                if (f2 + length2 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.Cr, this.paint);
                } else {
                    com.tb.airbnb.lottie.d.f.a(this.Cr, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 > f2 + length2 ? 1.0f : (floatValue3 - f2) / length2, 0.0f);
                    canvas.drawPath(this.Cr, this.paint);
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
        for (int i = 0; i < this.Ct.size(); i++) {
            C0931a c0931a = this.Ct.get(i);
            for (int i2 = 0; i2 < c0931a.CB.size(); i2++) {
                this.path.addPath(((l) c0931a.CB.get(i2)).iU(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = this.oir.getValue().floatValue();
        this.rect.set(this.rect.left - (floatValue / 2.0f), this.rect.top - (floatValue / 2.0f), this.rect.right + (floatValue / 2.0f), (floatValue / 2.0f) + this.rect.bottom);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.tb.airbnb.lottie.c.bb("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.tb.airbnb.lottie.c.beginSection("StrokeContent#applyDashPattern");
        if (this.Cx.isEmpty()) {
            com.tb.airbnb.lottie.c.bb("StrokeContent#applyDashPattern");
            return;
        }
        float b = com.tb.airbnb.lottie.d.f.b(matrix);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.Cx.size()) {
                break;
            }
            this.Cu[i2] = this.Cx.get(i2).getValue().floatValue();
            if (i2 % 2 == 0) {
                if (this.Cu[i2] < 1.0f) {
                    this.Cu[i2] = 1.0f;
                }
            } else if (this.Cu[i2] < 0.1f) {
                this.Cu[i2] = 0.1f;
            }
            float[] fArr = this.Cu;
            fArr[i2] = fArr[i2] * b;
            i = i2 + 1;
        }
        this.paint.setPathEffect(new DashPathEffect(this.Cu, this.oit == null ? 0.0f : this.oit.getValue().floatValue()));
        com.tb.airbnb.lottie.c.bb("StrokeContent#applyDashPattern");
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        com.tb.airbnb.lottie.d.e.a(eVar, i, list, eVar2, this);
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        if (t == com.tb.airbnb.lottie.j.BH) {
            this.ois.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.BO) {
            this.oir.a(cVar);
        } else if (t == com.tb.airbnb.lottie.j.Cb) {
            if (cVar == null) {
                this.oiu = null;
                return;
            }
            this.oiu = new com.tb.airbnb.lottie.a.b.p(cVar);
            this.oiu.b(this);
            this.oiq.a(this.oiu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tb.airbnb.lottie.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0931a {
        private final List<l> CB;
        @Nullable
        private final r oiv;

        private C0931a(@Nullable r rVar) {
            this.CB = new ArrayList();
            this.oiv = rVar;
        }
    }
}
