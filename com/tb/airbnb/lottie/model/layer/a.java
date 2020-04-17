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
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC0763a, com.tb.airbnb.lottie.model.f {
    private final String Et;
    private List<a> Ez;
    final com.tb.airbnb.lottie.f lottieDrawable;
    final o mOJ;
    final Layer mPZ;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g mQa;
    @Nullable
    private a mQb;
    @Nullable
    private a mQc;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint El = new Paint(1);
    private final Paint Em = new Paint(1);
    private final Paint En = new Paint(1);
    private final Paint Eo = new Paint(1);
    private final Paint Ep = new Paint();
    private final RectF rect = new RectF();
    private final RectF Eq = new RectF();
    private final RectF Er = new RectF();
    private final RectF Es = new RectF();
    final Matrix Eu = new Matrix();
    private final List<com.tb.airbnb.lottie.a.b.a<?, ?>> EA = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.d dVar) {
        switch (layer.dCd()) {
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
                com.tb.airbnb.lottie.c.warn("Unknown layer type " + layer.dCd());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, Layer layer) {
        this.lottieDrawable = fVar;
        this.mPZ = layer;
        this.Et = layer.getName() + "#draw";
        this.Ep.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.Em.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.En.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dCe() == Layer.MatteType.Invert) {
            this.Eo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.Eo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.mOJ = layer.dBX().dBB();
        this.mOJ.a((a.InterfaceC0763a) this);
        if (layer.hu() != null && !layer.hu().isEmpty()) {
            this.mQa = new com.tb.airbnb.lottie.a.b.g(layer.hu());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.mQa.hv()) {
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.mQa.hw()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        iE();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0763a
    public void ha() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dCc() {
        return this.mPZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.mQb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean iD() {
        return this.mQb != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.mQc = aVar;
    }

    private void iE() {
        if (!this.mPZ.iJ().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.mPZ.iJ());
            cVar.ho();
            cVar.b(new a.InterfaceC0763a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0763a
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
        this.EA.add(aVar);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.Eu.set(matrix);
        this.Eu.preConcat(this.mOJ.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection(this.Et);
        if (!this.visible) {
            com.tb.airbnb.lottie.c.aV(this.Et);
            return;
        }
        iG();
        com.tb.airbnb.lottie.c.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.Ez.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.Ez.get(size).mOJ.getMatrix());
        }
        com.tb.airbnb.lottie.c.aV("Layer#parentMatrix");
        int intValue = (int) (((this.mOJ.dBn().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!iD() && !iF()) {
            this.matrix.preConcat(this.mOJ.getMatrix());
            com.tb.airbnb.lottie.c.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.tb.airbnb.lottie.c.aV("Layer#drawLayer");
            h(com.tb.airbnb.lottie.c.aV(this.Et));
            return;
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.mOJ.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.tb.airbnb.lottie.c.aV("Layer#computeBounds");
        com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.El, true);
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
            a(canvas, this.rect, this.Eo, false);
            com.tb.airbnb.lottie.c.aV("Layer#saveLayer");
            e(canvas);
            this.mQb.a(canvas, matrix, intValue);
            com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.c.aV("Layer#restoreLayer");
            com.tb.airbnb.lottie.c.aV("Layer#drawMatte");
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tb.airbnb.lottie.c.aV("Layer#restoreLayer");
        h(com.tb.airbnb.lottie.c.aV(this.Et));
    }

    private void h(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.mPZ.getName(), f);
    }

    private void e(Canvas canvas) {
        com.tb.airbnb.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.Ep);
        com.tb.airbnb.lottie.c.aV("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.Eq.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (iF()) {
            int size = this.mQa.hu().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.mQa.hv().get(i).getValue());
                this.path.transform(matrix);
                switch (this.mQa.hu().get(i).dBL()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.Es, false);
                        if (i == 0) {
                            this.Eq.set(this.Es);
                        } else {
                            this.Eq.set(Math.min(this.Eq.left, this.Es.left), Math.min(this.Eq.top, this.Es.top), Math.max(this.Eq.right, this.Es.right), Math.max(this.Eq.bottom, this.Es.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.Eq.left), Math.max(rectF.top, this.Eq.top), Math.min(rectF.right, this.Eq.right), Math.min(rectF.bottom, this.Eq.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (iD() && this.mPZ.dCe() != Layer.MatteType.Invert) {
            this.mQb.a(this.Er, matrix);
            rectF.set(Math.max(rectF.left, this.Er.left), Math.max(rectF.top, this.Er.top), Math.min(rectF.right, this.Er.right), Math.min(rectF.bottom, this.Er.bottom));
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
                paint = this.En;
                break;
            default:
                paint = this.Em;
                break;
        }
        int size = this.mQa.hu().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.mQa.hu().get(i).dBL() != maskMode) {
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
                if (this.mQa.hu().get(i2).dBL() == maskMode) {
                    this.path.set(this.mQa.hv().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.El.getAlpha();
                    this.El.setAlpha((int) (this.mQa.hw().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.El);
                    this.El.setAlpha(alpha);
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
        return (this.mQa == null || this.mQa.hv().isEmpty()) ? false : true;
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
        this.mOJ.setProgress(f);
        if (this.mQa != null) {
            for (int i = 0; i < this.mQa.hv().size(); i++) {
                this.mQa.hv().get(i).setProgress(f);
            }
        }
        if (this.mPZ.iH() != 0.0f) {
            f /= this.mPZ.iH();
        }
        if (this.mQb != null) {
            this.mQb.setProgress(this.mQb.mPZ.iH() * f);
        }
        for (int i2 = 0; i2 < this.EA.size(); i2++) {
            this.EA.get(i2).setProgress(f);
        }
    }

    private void iG() {
        if (this.Ez == null) {
            if (this.mQc == null) {
                this.Ez = Collections.emptyList();
                return;
            }
            this.Ez = new ArrayList();
            for (a aVar = this.mQc; aVar != null; aVar = aVar.mQc) {
                this.Ez.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.mPZ.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        if (eVar.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.Pi(getName());
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
        this.mOJ.b(t, cVar);
    }
}
