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
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC0784a, com.tb.airbnb.lottie.model.f {
    private List<a> ED;
    private final String Ew;
    final com.tb.airbnb.lottie.f lottieDrawable;
    final o mOM;
    final Layer mQc;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g mQd;
    @Nullable
    private a mQe;
    @Nullable
    private a mQf;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint Eo = new Paint(1);
    private final Paint Ep = new Paint(1);
    private final Paint Eq = new Paint(1);
    private final Paint Er = new Paint(1);
    private final Paint Es = new Paint();
    private final RectF rect = new RectF();
    private final RectF Et = new RectF();
    private final RectF Eu = new RectF();
    private final RectF Ev = new RectF();
    final Matrix Ex = new Matrix();
    private final List<com.tb.airbnb.lottie.a.b.a<?, ?>> EE = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.d dVar) {
        switch (layer.dCa()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, dVar.aX(layer.getRefId()), dVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer);
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                com.tb.airbnb.lottie.c.warn("Unknown layer type " + layer.dCa());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, Layer layer) {
        this.lottieDrawable = fVar;
        this.mQc = layer;
        this.Ew = layer.getName() + "#draw";
        this.Es.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.Ep.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.Eq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dCb() == Layer.MatteType.Invert) {
            this.Er.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.Er.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.mOM = layer.dBU().dBy();
        this.mOM.a((a.InterfaceC0784a) this);
        if (layer.hu() != null && !layer.hu().isEmpty()) {
            this.mQd = new com.tb.airbnb.lottie.a.b.g(layer.hu());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.mQd.hv()) {
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.mQd.hw()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        iE();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0784a
    public void ha() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dBZ() {
        return this.mQc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.mQe = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean iD() {
        return this.mQe != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.mQf = aVar;
    }

    private void iE() {
        if (!this.mQc.iJ().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.mQc.iJ());
            cVar.ho();
            cVar.b(new a.InterfaceC0784a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0784a
                public void ha() {
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
        this.EE.add(aVar);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.Ex.set(matrix);
        this.Ex.preConcat(this.mOM.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection(this.Ew);
        if (!this.visible) {
            com.tb.airbnb.lottie.c.aV(this.Ew);
            return;
        }
        iG();
        com.tb.airbnb.lottie.c.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.ED.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.ED.get(size).mOM.getMatrix());
        }
        com.tb.airbnb.lottie.c.aV("Layer#parentMatrix");
        int intValue = (int) (((this.mOM.dBk().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!iD() && !iF()) {
            this.matrix.preConcat(this.mOM.getMatrix());
            com.tb.airbnb.lottie.c.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.tb.airbnb.lottie.c.aV("Layer#drawLayer");
            h(com.tb.airbnb.lottie.c.aV(this.Ew));
            return;
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.mOM.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.tb.airbnb.lottie.c.aV("Layer#computeBounds");
        com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.Eo, true);
        com.tb.airbnb.lottie.c.aV("Layer#saveLayer");
        e(canvas);
        com.tb.airbnb.lottie.c.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.tb.airbnb.lottie.c.aV("Layer#drawLayer");
        if (iF()) {
            a(canvas, this.matrix);
        }
        if (iD()) {
            com.tb.airbnb.lottie.c.beginSection("Layer#drawMatte");
            com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.Er, false);
            com.tb.airbnb.lottie.c.aV("Layer#saveLayer");
            e(canvas);
            this.mQe.a(canvas, matrix, intValue);
            com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.c.aV("Layer#restoreLayer");
            com.tb.airbnb.lottie.c.aV("Layer#drawMatte");
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tb.airbnb.lottie.c.aV("Layer#restoreLayer");
        h(com.tb.airbnb.lottie.c.aV(this.Ew));
    }

    private void h(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.mQc.getName(), f);
    }

    private void e(Canvas canvas) {
        com.tb.airbnb.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.Es);
        com.tb.airbnb.lottie.c.aV("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.Et.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (iF()) {
            int size = this.mQd.hu().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.mQd.hv().get(i).getValue());
                this.path.transform(matrix);
                switch (this.mQd.hu().get(i).dBI()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.Ev, false);
                        if (i == 0) {
                            this.Et.set(this.Ev);
                        } else {
                            this.Et.set(Math.min(this.Et.left, this.Ev.left), Math.min(this.Et.top, this.Ev.top), Math.max(this.Et.right, this.Ev.right), Math.max(this.Et.bottom, this.Ev.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.Et.left), Math.max(rectF.top, this.Et.top), Math.min(rectF.right, this.Et.right), Math.min(rectF.bottom, this.Et.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (iD() && this.mQc.dCb() != Layer.MatteType.Invert) {
            this.mQe.a(this.Eu, matrix);
            rectF.set(Math.max(rectF.left, this.Eu.left), Math.max(rectF.top, this.Eu.top), Math.min(rectF.right, this.Eu.right), Math.min(rectF.bottom, this.Eu.bottom));
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
                paint = this.Eq;
                break;
            default:
                paint = this.Ep;
                break;
        }
        int size = this.mQd.hu().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.mQd.hu().get(i).dBI() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.tb.airbnb.lottie.c.beginSection("Layer#drawMask");
            com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.rect, paint, false);
            com.tb.airbnb.lottie.c.aV("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.mQd.hu().get(i2).dBI() == maskMode) {
                    this.path.set(this.mQd.hv().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.Eo.getAlpha();
                    this.Eo.setAlpha((int) (this.mQd.hw().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.Eo);
                    this.Eo.setAlpha(alpha);
                }
            }
            com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.c.aV("Layer#restoreLayer");
            com.tb.airbnb.lottie.c.aV("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean iF() {
        return (this.mQd == null || this.mQd.hv().isEmpty()) ? false : true;
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
        this.mOM.setProgress(f);
        if (this.mQd != null) {
            for (int i = 0; i < this.mQd.hv().size(); i++) {
                this.mQd.hv().get(i).setProgress(f);
            }
        }
        if (this.mQc.iH() != 0.0f) {
            f /= this.mQc.iH();
        }
        if (this.mQe != null) {
            this.mQe.setProgress(this.mQe.mQc.iH() * f);
        }
        for (int i2 = 0; i2 < this.EE.size(); i2++) {
            this.EE.get(i2).setProgress(f);
        }
    }

    private void iG() {
        if (this.ED == null) {
            if (this.mQf == null) {
                this.ED = Collections.emptyList();
                return;
            }
            this.ED = new ArrayList();
            for (a aVar = this.mQf; aVar != null; aVar = aVar.mQf) {
                this.ED.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.mQc.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        if (eVar.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.Pl(getName());
                if (eVar.i(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.j(getName(), i)) {
                b(eVar, eVar.h(getName(), i) + i, list, eVar2);
            }
        }
    }

    void b(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        this.mOM.b(t, cVar);
    }
}
