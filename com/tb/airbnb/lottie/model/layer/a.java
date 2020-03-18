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
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC0739a, com.tb.airbnb.lottie.model.f {
    private final String iX;
    private List<a> je;
    final com.tb.airbnb.lottie.f lottieDrawable;
    final o nsa;
    final Layer nto;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g ntp;
    @Nullable
    private a ntq;
    @Nullable
    private a ntr;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint iP = new Paint(1);
    private final Paint iQ = new Paint(1);
    private final Paint iR = new Paint(1);
    private final Paint iS = new Paint(1);
    private final Paint iT = new Paint();
    private final RectF rect = new RectF();
    private final RectF iU = new RectF();
    private final RectF iV = new RectF();
    private final RectF iW = new RectF();
    final Matrix iY = new Matrix();
    private final List<com.tb.airbnb.lottie.a.b.a<?, ?>> jf = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.d dVar) {
        switch (layer.dIb()) {
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
                com.tb.airbnb.lottie.c.warn("Unknown layer type " + layer.dIb());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, Layer layer) {
        this.lottieDrawable = fVar;
        this.nto = layer;
        this.iX = layer.getName() + "#draw";
        this.iT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.iQ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.iR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dIc() == Layer.MatteType.Invert) {
            this.iS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.iS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.nsa = layer.dHV().dHz();
        this.nsa.a((a.InterfaceC0739a) this);
        if (layer.bX() != null && !layer.bX().isEmpty()) {
            this.ntp = new com.tb.airbnb.lottie.a.b.g(layer.bX());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.ntp.bY()) {
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.ntp.bZ()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        df();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0739a
    public void bD() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dIa() {
        return this.nto;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.ntq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean de() {
        return this.ntq != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.ntr = aVar;
    }

    private void df() {
        if (!this.nto.dk().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.nto.dk());
            cVar.bR();
            cVar.b(new a.InterfaceC0739a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0739a
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
        this.jf.add(aVar);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.iY.set(matrix);
        this.iY.preConcat(this.nsa.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection(this.iX);
        if (!this.visible) {
            com.tb.airbnb.lottie.c.F(this.iX);
            return;
        }
        dh();
        com.tb.airbnb.lottie.c.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.je.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.je.get(size).nsa.getMatrix());
        }
        com.tb.airbnb.lottie.c.F("Layer#parentMatrix");
        int intValue = (int) (((this.nsa.dHl().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!de() && !dg()) {
            this.matrix.preConcat(this.nsa.getMatrix());
            com.tb.airbnb.lottie.c.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.tb.airbnb.lottie.c.F("Layer#drawLayer");
            k(com.tb.airbnb.lottie.c.F(this.iX));
            return;
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.nsa.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.tb.airbnb.lottie.c.F("Layer#computeBounds");
        com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.iP, true);
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
            a(canvas, this.rect, this.iS, false);
            com.tb.airbnb.lottie.c.F("Layer#saveLayer");
            e(canvas);
            this.ntq.a(canvas, matrix, intValue);
            com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.c.F("Layer#restoreLayer");
            com.tb.airbnb.lottie.c.F("Layer#drawMatte");
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tb.airbnb.lottie.c.F("Layer#restoreLayer");
        k(com.tb.airbnb.lottie.c.F(this.iX));
    }

    private void k(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.nto.getName(), f);
    }

    private void e(Canvas canvas) {
        com.tb.airbnb.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.iT);
        com.tb.airbnb.lottie.c.F("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.iU.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (dg()) {
            int size = this.ntp.bX().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.ntp.bY().get(i).getValue());
                this.path.transform(matrix);
                switch (this.ntp.bX().get(i).dHJ()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.iW, false);
                        if (i == 0) {
                            this.iU.set(this.iW);
                        } else {
                            this.iU.set(Math.min(this.iU.left, this.iW.left), Math.min(this.iU.top, this.iW.top), Math.max(this.iU.right, this.iW.right), Math.max(this.iU.bottom, this.iW.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.iU.left), Math.max(rectF.top, this.iU.top), Math.min(rectF.right, this.iU.right), Math.min(rectF.bottom, this.iU.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (de() && this.nto.dIc() != Layer.MatteType.Invert) {
            this.ntq.a(this.iV, matrix);
            rectF.set(Math.max(rectF.left, this.iV.left), Math.max(rectF.top, this.iV.top), Math.min(rectF.right, this.iV.right), Math.min(rectF.bottom, this.iV.bottom));
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
                paint = this.iR;
                break;
            default:
                paint = this.iQ;
                break;
        }
        int size = this.ntp.bX().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.ntp.bX().get(i).dHJ() != maskMode) {
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
                if (this.ntp.bX().get(i2).dHJ() == maskMode) {
                    this.path.set(this.ntp.bY().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.iP.getAlpha();
                    this.iP.setAlpha((int) (this.ntp.bZ().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.iP);
                    this.iP.setAlpha(alpha);
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
        return (this.ntp == null || this.ntp.bY().isEmpty()) ? false : true;
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
        this.nsa.setProgress(f);
        if (this.ntp != null) {
            for (int i = 0; i < this.ntp.bY().size(); i++) {
                this.ntp.bY().get(i).setProgress(f);
            }
        }
        if (this.nto.di() != 0.0f) {
            f /= this.nto.di();
        }
        if (this.ntq != null) {
            this.ntq.setProgress(this.ntq.nto.di() * f);
        }
        for (int i2 = 0; i2 < this.jf.size(); i2++) {
            this.jf.get(i2).setProgress(f);
        }
    }

    private void dh() {
        if (this.je == null) {
            if (this.ntr == null) {
                this.je = Collections.emptyList();
                return;
            }
            this.je = new ArrayList();
            for (a aVar = this.ntr; aVar != null; aVar = aVar.ntr) {
                this.je.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.nto.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        if (eVar.c(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.Rx(getName());
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
        this.nsa.b(t, cVar);
    }
}
