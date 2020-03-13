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
/* loaded from: classes6.dex */
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC0738a, com.tb.airbnb.lottie.model.f {
    private final String iY;
    private List<a> jf;
    final com.tb.airbnb.lottie.f lottieDrawable;
    final o nqn;
    final Layer nrB;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g nrC;
    @Nullable
    private a nrD;
    @Nullable
    private a nrE;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint iQ = new Paint(1);
    private final Paint iR = new Paint(1);
    private final Paint iS = new Paint(1);
    private final Paint iT = new Paint(1);
    private final Paint iU = new Paint();
    private final RectF rect = new RectF();
    private final RectF iV = new RectF();
    private final RectF iW = new RectF();
    private final RectF iX = new RectF();
    final Matrix iZ = new Matrix();
    private final List<com.tb.airbnb.lottie.a.b.a<?, ?>> jg = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.d dVar) {
        switch (layer.dHB()) {
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
                com.tb.airbnb.lottie.c.warn("Unknown layer type " + layer.dHB());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, Layer layer) {
        this.lottieDrawable = fVar;
        this.nrB = layer;
        this.iY = layer.getName() + "#draw";
        this.iU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.iR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.iS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dHC() == Layer.MatteType.Invert) {
            this.iT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.iT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.nqn = layer.dHv().dGZ();
        this.nqn.a((a.InterfaceC0738a) this);
        if (layer.bX() != null && !layer.bX().isEmpty()) {
            this.nrC = new com.tb.airbnb.lottie.a.b.g(layer.bX());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.nrC.bY()) {
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.nrC.bZ()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        df();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0738a
    public void bD() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dHA() {
        return this.nrB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.nrD = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean de() {
        return this.nrD != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.nrE = aVar;
    }

    private void df() {
        if (!this.nrB.dk().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.nrB.dk());
            cVar.bR();
            cVar.b(new a.InterfaceC0738a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0738a
                public void bD() {
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
        this.jg.add(aVar);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.iZ.set(matrix);
        this.iZ.preConcat(this.nqn.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection(this.iY);
        if (!this.visible) {
            com.tb.airbnb.lottie.c.F(this.iY);
            return;
        }
        dh();
        com.tb.airbnb.lottie.c.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.jf.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.jf.get(size).nqn.getMatrix());
        }
        com.tb.airbnb.lottie.c.F("Layer#parentMatrix");
        int intValue = (int) (((this.nqn.dGL().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!de() && !dg()) {
            this.matrix.preConcat(this.nqn.getMatrix());
            com.tb.airbnb.lottie.c.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.tb.airbnb.lottie.c.F("Layer#drawLayer");
            k(com.tb.airbnb.lottie.c.F(this.iY));
            return;
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.nqn.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.tb.airbnb.lottie.c.F("Layer#computeBounds");
        com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.iQ, true);
        com.tb.airbnb.lottie.c.F("Layer#saveLayer");
        e(canvas);
        com.tb.airbnb.lottie.c.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.tb.airbnb.lottie.c.F("Layer#drawLayer");
        if (dg()) {
            a(canvas, this.matrix);
        }
        if (de()) {
            com.tb.airbnb.lottie.c.beginSection("Layer#drawMatte");
            com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.iT, false);
            com.tb.airbnb.lottie.c.F("Layer#saveLayer");
            e(canvas);
            this.nrD.a(canvas, matrix, intValue);
            com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.c.F("Layer#restoreLayer");
            com.tb.airbnb.lottie.c.F("Layer#drawMatte");
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tb.airbnb.lottie.c.F("Layer#restoreLayer");
        k(com.tb.airbnb.lottie.c.F(this.iY));
    }

    private void k(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.nrB.getName(), f);
    }

    private void e(Canvas canvas) {
        com.tb.airbnb.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.iU);
        com.tb.airbnb.lottie.c.F("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.iV.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (dg()) {
            int size = this.nrC.bX().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.nrC.bY().get(i).getValue());
                this.path.transform(matrix);
                switch (this.nrC.bX().get(i).dHj()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.iX, false);
                        if (i == 0) {
                            this.iV.set(this.iX);
                        } else {
                            this.iV.set(Math.min(this.iV.left, this.iX.left), Math.min(this.iV.top, this.iX.top), Math.max(this.iV.right, this.iX.right), Math.max(this.iV.bottom, this.iX.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.iV.left), Math.max(rectF.top, this.iV.top), Math.min(rectF.right, this.iV.right), Math.min(rectF.bottom, this.iV.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (de() && this.nrB.dHC() != Layer.MatteType.Invert) {
            this.nrD.a(this.iW, matrix);
            rectF.set(Math.max(rectF.left, this.iW.left), Math.max(rectF.top, this.iW.top), Math.min(rectF.right, this.iW.right), Math.min(rectF.bottom, this.iW.bottom));
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
                paint = this.iS;
                break;
            default:
                paint = this.iR;
                break;
        }
        int size = this.nrC.bX().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.nrC.bX().get(i).dHj() != maskMode) {
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
                if (this.nrC.bX().get(i2).dHj() == maskMode) {
                    this.path.set(this.nrC.bY().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.iQ.getAlpha();
                    this.iQ.setAlpha((int) (this.nrC.bZ().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.iQ);
                    this.iQ.setAlpha(alpha);
                }
            }
            com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.c.F("Layer#restoreLayer");
            com.tb.airbnb.lottie.c.F("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dg() {
        return (this.nrC == null || this.nrC.bY().isEmpty()) ? false : true;
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
        this.nqn.setProgress(f);
        if (this.nrC != null) {
            for (int i = 0; i < this.nrC.bY().size(); i++) {
                this.nrC.bY().get(i).setProgress(f);
            }
        }
        if (this.nrB.di() != 0.0f) {
            f /= this.nrB.di();
        }
        if (this.nrD != null) {
            this.nrD.setProgress(this.nrD.nrB.di() * f);
        }
        for (int i2 = 0; i2 < this.jg.size(); i2++) {
            this.jg.get(i2).setProgress(f);
        }
    }

    private void dh() {
        if (this.jf == null) {
            if (this.nrE == null) {
                this.jf = Collections.emptyList();
                return;
            }
            this.jf = new ArrayList();
            for (a aVar = this.nrE; aVar != null; aVar = aVar.nrE) {
                this.jf.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.nrB.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        if (eVar.c(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.Ry(getName());
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
        this.nqn.b(t, cVar);
    }
}
