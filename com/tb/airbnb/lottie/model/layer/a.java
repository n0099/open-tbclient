package com.tb.airbnb.lottie.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.CallSuper;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.a.b.o;
import com.tb.airbnb.lottie.model.content.Mask;
import com.tb.airbnb.lottie.model.content.h;
import com.tb.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC0730a, com.tb.airbnb.lottie.model.f {
    private final String iU;
    private List<a> jb;
    final com.tb.airbnb.lottie.f lottieDrawable;
    final o npt;
    final Layer nqH;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g nqI;
    @Nullable
    private a nqJ;
    @Nullable
    private a nqK;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint iM = new Paint(1);
    private final Paint iN = new Paint(1);
    private final Paint iO = new Paint(1);
    private final Paint iP = new Paint(1);
    private final Paint iQ = new Paint();
    private final RectF rect = new RectF();
    private final RectF iR = new RectF();
    private final RectF iS = new RectF();
    private final RectF iT = new RectF();
    final Matrix iV = new Matrix();
    private final List<com.tb.airbnb.lottie.a.b.a<?, ?>> jc = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.d dVar) {
        switch (layer.dGp()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, dVar.H(layer.getRefId()), dVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer);
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                com.tb.airbnb.lottie.c.warn("Unknown layer type " + layer.dGp());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, Layer layer) {
        this.lottieDrawable = fVar;
        this.nqH = layer;
        this.iU = layer.getName() + "#draw";
        this.iQ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.iN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.iO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dGq() == Layer.MatteType.Invert) {
            this.iP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.iP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.npt = layer.dGj().dFN();
        this.npt.a((a.InterfaceC0730a) this);
        if (layer.bW() != null && !layer.bW().isEmpty()) {
            this.nqI = new com.tb.airbnb.lottie.a.b.g(layer.bW());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.nqI.bX()) {
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.nqI.bY()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        de();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0730a
    public void bC() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dGo() {
        return this.nqH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.nqJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dd() {
        return this.nqJ != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.nqK = aVar;
    }

    private void de() {
        if (!this.nqH.dj().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.nqH.dj());
            cVar.bQ();
            cVar.b(new a.InterfaceC0730a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0730a
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

    @SuppressLint({"WrongConstant"})
    private void a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public void a(com.tb.airbnb.lottie.a.b.a<?, ?> aVar) {
        this.jc.add(aVar);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.iV.set(matrix);
        this.iV.preConcat(this.npt.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection(this.iU);
        if (!this.visible) {
            com.tb.airbnb.lottie.c.F(this.iU);
            return;
        }
        dg();
        com.tb.airbnb.lottie.c.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.jb.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.jb.get(size).npt.getMatrix());
        }
        com.tb.airbnb.lottie.c.F("Layer#parentMatrix");
        int intValue = (int) (((this.npt.dFz().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!dd() && !df()) {
            this.matrix.preConcat(this.npt.getMatrix());
            com.tb.airbnb.lottie.c.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.tb.airbnb.lottie.c.F("Layer#drawLayer");
            k(com.tb.airbnb.lottie.c.F(this.iU));
            return;
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.npt.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.tb.airbnb.lottie.c.F("Layer#computeBounds");
        com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.iM, true);
        com.tb.airbnb.lottie.c.F("Layer#saveLayer");
        e(canvas);
        com.tb.airbnb.lottie.c.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.tb.airbnb.lottie.c.F("Layer#drawLayer");
        if (df()) {
            a(canvas, this.matrix);
        }
        if (dd()) {
            com.tb.airbnb.lottie.c.beginSection("Layer#drawMatte");
            com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.iP, false);
            com.tb.airbnb.lottie.c.F("Layer#saveLayer");
            e(canvas);
            this.nqJ.a(canvas, matrix, intValue);
            com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.c.F("Layer#restoreLayer");
            com.tb.airbnb.lottie.c.F("Layer#drawMatte");
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tb.airbnb.lottie.c.F("Layer#restoreLayer");
        k(com.tb.airbnb.lottie.c.F(this.iU));
    }

    private void k(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.nqH.getName(), f);
    }

    private void e(Canvas canvas) {
        com.tb.airbnb.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.iQ);
        com.tb.airbnb.lottie.c.F("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.iR.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (df()) {
            int size = this.nqI.bW().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.nqI.bX().get(i).getValue());
                this.path.transform(matrix);
                switch (this.nqI.bW().get(i).dFX()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.iT, false);
                        if (i == 0) {
                            this.iR.set(this.iT);
                        } else {
                            this.iR.set(Math.min(this.iR.left, this.iT.left), Math.min(this.iR.top, this.iT.top), Math.max(this.iR.right, this.iT.right), Math.max(this.iR.bottom, this.iT.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.iR.left), Math.max(rectF.top, this.iR.top), Math.min(rectF.right, this.iR.right), Math.min(rectF.bottom, this.iR.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (dd() && this.nqH.dGq() != Layer.MatteType.Invert) {
            this.nqJ.a(this.iS, matrix);
            rectF.set(Math.max(rectF.left, this.iS.left), Math.max(rectF.top, this.iS.top), Math.min(rectF.right, this.iS.right), Math.min(rectF.bottom, this.iS.bottom));
        }
    }

    private void a(Canvas canvas, Matrix matrix) {
        a(canvas, matrix, Mask.MaskMode.MaskModeAdd);
        a(canvas, matrix, Mask.MaskMode.MaskModeIntersect);
        a(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
    }

    private void a(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        Paint paint;
        boolean z;
        switch (maskMode) {
            case MaskModeSubtract:
                paint = this.iO;
                break;
            default:
                paint = this.iN;
                break;
        }
        int size = this.nqI.bW().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.nqI.bW().get(i).dFX() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.tb.airbnb.lottie.c.beginSection("Layer#drawMask");
            com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.rect, paint, false);
            com.tb.airbnb.lottie.c.F("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.nqI.bW().get(i2).dFX() == maskMode) {
                    this.path.set(this.nqI.bX().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.iM.getAlpha();
                    this.iM.setAlpha((int) (this.nqI.bY().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.iM);
                    this.iM.setAlpha(alpha);
                }
            }
            com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.c.F("Layer#restoreLayer");
            com.tb.airbnb.lottie.c.F("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean df() {
        return (this.nqI == null || this.nqI.bX().isEmpty()) ? false : true;
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
        this.npt.setProgress(f);
        if (this.nqI != null) {
            for (int i = 0; i < this.nqI.bX().size(); i++) {
                this.nqI.bX().get(i).setProgress(f);
            }
        }
        if (this.nqH.dh() != 0.0f) {
            f /= this.nqH.dh();
        }
        if (this.nqJ != null) {
            this.nqJ.setProgress(this.nqJ.nqH.dh() * f);
        }
        for (int i2 = 0; i2 < this.jc.size(); i2++) {
            this.jc.get(i2).setProgress(f);
        }
    }

    private void dg() {
        if (this.jb == null) {
            if (this.nqK == null) {
                this.jb = Collections.emptyList();
                return;
            }
            this.jb = new ArrayList();
            for (a aVar = this.nqK; aVar != null; aVar = aVar.nqK) {
                this.jb.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.nqH.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        if (eVar.c(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.Rm(getName());
                if (eVar.e(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.f(getName(), i)) {
                b(eVar, eVar.d(getName(), i) + i, list, eVar2);
            }
        }
    }

    void b(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        this.npt.b(t, cVar);
    }
}
