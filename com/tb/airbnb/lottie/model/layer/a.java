package com.tb.airbnb.lottie.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.a.b.n;
import com.tb.airbnb.lottie.a.b.p;
import com.tb.airbnb.lottie.model.content.Mask;
import com.tb.airbnb.lottie.model.content.h;
import com.tb.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC0577a {
    private final String hk;
    private List<a> hq;
    final p ksA;
    final Layer ktT;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g ktU;
    @Nullable
    private a ktV;
    @Nullable
    private a ktW;
    final com.tb.airbnb.lottie.f lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint hb = new Paint(1);
    private final Paint hc = new Paint(1);
    private final Paint hd = new Paint(1);
    private final Paint hf = new Paint(1);
    private final Paint hg = new Paint();
    private final RectF rect = new RectF();
    private final RectF hh = new RectF();
    private final RectF hi = new RectF();
    private final RectF hj = new RectF();
    final Matrix hl = new Matrix();
    private final List<com.tb.airbnb.lottie.a.b.a<?, ?>> hr = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.e eVar) {
        switch (layer.cMe()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, eVar.F(layer.getRefId()), eVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer, eVar.bb());
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.cMe());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, Layer layer) {
        this.lottieDrawable = fVar;
        this.ktT = layer;
        this.hk = layer.getName() + "#draw";
        this.hg.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.hd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.cMf() == Layer.MatteType.Invert) {
            this.hf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.hf.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.ksA = layer.cLY().cLA();
        this.ksA.a((a.InterfaceC0577a) this);
        if (layer.bL() != null && !layer.bL().isEmpty()) {
            this.ktU = new com.tb.airbnb.lottie.a.b.g(layer.bL());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.ktU.bM()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.ktU.bN()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        db();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0577a
    public void bt() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer cMd() {
        return this.ktT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.ktV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean da() {
        return this.ktV != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.ktW = aVar;
    }

    private void db() {
        if (!this.ktT.df().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.ktT.df());
            cVar.bH();
            cVar.b(new a.InterfaceC0577a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0577a
                public void bt() {
                    a.this.setVisible(cVar.getValue().floatValue() == 1.0f);
                }
            });
            setVisible(cVar.getValue().floatValue() == 1.0f);
            a(cVar);
            return;
        }
        setVisible(true);
    }

    private void invalidateSelf() {
        this.lottieDrawable.invalidateSelf();
    }

    public void a(com.tb.airbnb.lottie.a.b.a<?, ?> aVar) {
        if (!(aVar instanceof n)) {
            this.hr.add(aVar);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.hl.set(matrix);
        this.hl.preConcat(this.ksA.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection(this.hk);
        if (!this.visible) {
            com.tb.airbnb.lottie.d.D(this.hk);
            return;
        }
        dd();
        com.tb.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.hq.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.hq.get(size).ksA.getMatrix());
        }
        com.tb.airbnb.lottie.d.D("Layer#parentMatrix");
        int intValue = (int) (((this.ksA.cLi().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!da() && !dc()) {
            this.matrix.preConcat(this.ksA.getMatrix());
            com.tb.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.tb.airbnb.lottie.d.D("Layer#drawLayer");
            i(com.tb.airbnb.lottie.d.D(this.hk));
            return;
        }
        com.tb.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.ksA.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.tb.airbnb.lottie.d.D("Layer#computeBounds");
        com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.hb, 31);
        com.tb.airbnb.lottie.d.D("Layer#saveLayer");
        d(canvas);
        com.tb.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.tb.airbnb.lottie.d.D("Layer#drawLayer");
        if (dc()) {
            a(canvas, this.matrix);
        }
        if (da()) {
            com.tb.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, this.hf, 19);
            com.tb.airbnb.lottie.d.D("Layer#saveLayer");
            d(canvas);
            this.ktV.a(canvas, matrix, intValue);
            com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.d.D("Layer#restoreLayer");
            com.tb.airbnb.lottie.d.D("Layer#drawMatte");
        }
        com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tb.airbnb.lottie.d.D("Layer#restoreLayer");
        i(com.tb.airbnb.lottie.d.D(this.hk));
    }

    private void i(float f) {
        this.lottieDrawable.cLa().getPerformanceTracker().b(this.ktT.getName(), f);
    }

    private void d(Canvas canvas) {
        com.tb.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.hg);
        com.tb.airbnb.lottie.d.D("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.hh.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (dc()) {
            int size = this.ktU.bL().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.ktU.bM().get(i).getValue());
                this.path.transform(matrix);
                switch (this.ktU.bL().get(i).cLM()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.path.computeBounds(this.hj, false);
                        if (i == 0) {
                            this.hh.set(this.hj);
                        } else {
                            this.hh.set(Math.min(this.hh.left, this.hj.left), Math.min(this.hh.top, this.hj.top), Math.max(this.hh.right, this.hj.right), Math.max(this.hh.bottom, this.hj.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.hh.left), Math.max(rectF.top, this.hh.top), Math.min(rectF.right, this.hh.right), Math.min(rectF.bottom, this.hh.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (da() && this.ktT.cMf() != Layer.MatteType.Invert) {
            this.ktV.a(this.hi, matrix);
            rectF.set(Math.max(rectF.left, this.hi.left), Math.max(rectF.top, this.hi.top), Math.min(rectF.right, this.hi.right), Math.min(rectF.bottom, this.hi.bottom));
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        a(canvas, matrix, Mask.MaskMode.MaskModeAdd);
        a(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
    }

    @SuppressLint({"WrongConstant"})
    private void a(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        Paint paint;
        boolean z;
        if (maskMode == Mask.MaskMode.MaskModeSubtract) {
            paint = this.hd;
        } else {
            paint = this.hc;
        }
        int size = this.ktU.bL().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.ktU.bL().get(i).cLM() != maskMode) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            com.tb.airbnb.lottie.d.beginSection("Layer#drawMask");
            com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, paint, 19);
            com.tb.airbnb.lottie.d.D("Layer#saveLayer");
            d(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ktU.bL().get(i2).cLM() == maskMode) {
                    this.path.set(this.ktU.bM().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.hb.getAlpha();
                    this.hb.setAlpha((int) (this.ktU.bN().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.hb);
                    this.hb.setAlpha(alpha);
                }
            }
            com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.d.D("Layer#restoreLayer");
            com.tb.airbnb.lottie.d.D("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dc() {
        return (this.ktU == null || this.ktU.bM().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisible(boolean z) {
        if (z != this.visible) {
            this.visible = z;
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.ksA.setProgress(f);
        if (this.ktT.de() != 0.0f) {
            f /= this.ktT.de();
        }
        if (this.ktV != null) {
            this.ktV.setProgress(this.ktV.ktT.de() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hr.size()) {
                this.hr.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void dd() {
        if (this.hq == null) {
            if (this.ktW == null) {
                this.hq = Collections.emptyList();
                return;
            }
            this.hq = new ArrayList();
            for (a aVar = this.ktW; aVar != null; aVar = aVar.ktW) {
                this.hq.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.ktT.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
