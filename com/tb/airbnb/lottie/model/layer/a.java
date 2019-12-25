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
/* loaded from: classes2.dex */
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC0687a {
    private final String iV;
    private List<a> jc;
    final com.tb.airbnb.lottie.f lottieDrawable;
    final p mNo;
    final Layer mOM;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g mON;
    @Nullable
    private a mOO;
    @Nullable
    private a mOP;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint iN = new Paint(1);
    private final Paint iO = new Paint(1);
    private final Paint iP = new Paint(1);
    private final Paint iQ = new Paint(1);
    private final Paint iR = new Paint();
    private final RectF rect = new RectF();
    private final RectF iS = new RectF();
    private final RectF iT = new RectF();
    private final RectF iU = new RectF();
    final Matrix iW = new Matrix();
    private final List<com.tb.airbnb.lottie.a.b.a<?, ?>> jd = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.e eVar) {
        switch (layer.dCn()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, eVar.H(layer.getRefId()), eVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer, eVar.dAZ());
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.dCn());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, Layer layer) {
        this.lottieDrawable = fVar;
        this.mOM = layer;
        this.iV = layer.getName() + "#draw";
        this.iR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.iO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.iP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dCo() == Layer.MatteType.Invert) {
            this.iQ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.iQ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.mNo = layer.dCh().dBI();
        this.mNo.a((a.InterfaceC0687a) this);
        if (layer.bW() != null && !layer.bW().isEmpty()) {
            this.mON = new com.tb.airbnb.lottie.a.b.g(layer.bW());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.mON.bX()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.mON.bY()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        de();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0687a
    public void bC() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dCm() {
        return this.mOM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.mOO = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dd() {
        return this.mOO != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.mOP = aVar;
    }

    private void de() {
        if (!this.mOM.dj().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.mOM.dj());
            cVar.bQ();
            cVar.b(new a.InterfaceC0687a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0687a
                public void bC() {
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
            this.jd.add(aVar);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.iW.set(matrix);
        this.iW.preConcat(this.mNo.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection(this.iV);
        if (!this.visible) {
            com.tb.airbnb.lottie.d.F(this.iV);
            return;
        }
        dg();
        com.tb.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.jc.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.jc.get(size).mNo.getMatrix());
        }
        com.tb.airbnb.lottie.d.F("Layer#parentMatrix");
        int intValue = (int) (((this.mNo.dBn().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!dd() && !df()) {
            this.matrix.preConcat(this.mNo.getMatrix());
            com.tb.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.tb.airbnb.lottie.d.F("Layer#drawLayer");
            k(com.tb.airbnb.lottie.d.F(this.iV));
            return;
        }
        com.tb.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.mNo.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.tb.airbnb.lottie.d.F("Layer#computeBounds");
        com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.iN, 31);
        com.tb.airbnb.lottie.d.F("Layer#saveLayer");
        e(canvas);
        com.tb.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.tb.airbnb.lottie.d.F("Layer#drawLayer");
        if (df()) {
            a(canvas, this.matrix);
        }
        if (dd()) {
            com.tb.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, this.iQ, 19);
            com.tb.airbnb.lottie.d.F("Layer#saveLayer");
            e(canvas);
            this.mOO.a(canvas, matrix, intValue);
            com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.d.F("Layer#restoreLayer");
            com.tb.airbnb.lottie.d.F("Layer#drawMatte");
        }
        com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tb.airbnb.lottie.d.F("Layer#restoreLayer");
        k(com.tb.airbnb.lottie.d.F(this.iV));
    }

    private void k(float f) {
        this.lottieDrawable.dBd().getPerformanceTracker().b(this.mOM.getName(), f);
    }

    private void e(Canvas canvas) {
        com.tb.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.iR);
        com.tb.airbnb.lottie.d.F("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.iS.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (df()) {
            int size = this.mON.bW().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.mON.bX().get(i).getValue());
                this.path.transform(matrix);
                switch (this.mON.bW().get(i).dBV()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.path.computeBounds(this.iU, false);
                        if (i == 0) {
                            this.iS.set(this.iU);
                        } else {
                            this.iS.set(Math.min(this.iS.left, this.iU.left), Math.min(this.iS.top, this.iU.top), Math.max(this.iS.right, this.iU.right), Math.max(this.iS.bottom, this.iU.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.iS.left), Math.max(rectF.top, this.iS.top), Math.min(rectF.right, this.iS.right), Math.min(rectF.bottom, this.iS.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (dd() && this.mOM.dCo() != Layer.MatteType.Invert) {
            this.mOO.a(this.iT, matrix);
            rectF.set(Math.max(rectF.left, this.iT.left), Math.max(rectF.top, this.iT.top), Math.min(rectF.right, this.iT.right), Math.min(rectF.bottom, this.iT.bottom));
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
            paint = this.iP;
        } else {
            paint = this.iO;
        }
        int size = this.mON.bW().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.mON.bW().get(i).dBV() != maskMode) {
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
            com.tb.airbnb.lottie.d.F("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.mON.bW().get(i2).dBV() == maskMode) {
                    this.path.set(this.mON.bX().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.iN.getAlpha();
                    this.iN.setAlpha((int) (this.mON.bY().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.iN);
                    this.iN.setAlpha(alpha);
                }
            }
            com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.d.F("Layer#restoreLayer");
            com.tb.airbnb.lottie.d.F("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean df() {
        return (this.mON == null || this.mON.bX().isEmpty()) ? false : true;
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
        this.mNo.setProgress(f);
        if (this.mOM.dh() != 0.0f) {
            f /= this.mOM.dh();
        }
        if (this.mOO != null) {
            this.mOO.setProgress(this.mOO.mOM.dh() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jd.size()) {
                this.jd.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void dg() {
        if (this.jc == null) {
            if (this.mOP == null) {
                this.jc = Collections.emptyList();
                return;
            }
            this.jc = new ArrayList();
            for (a aVar = this.mOP; aVar != null; aVar = aVar.mOP) {
                this.jc.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.mOM.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
