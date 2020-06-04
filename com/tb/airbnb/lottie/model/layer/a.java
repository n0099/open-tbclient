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
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC0845a, com.tb.airbnb.lottie.model.f {
    private List<a> ED;
    private final String Ew;
    final com.tb.airbnb.lottie.f lottieDrawable;
    final o nkb;
    final Layer nlp;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g nlq;
    @Nullable
    private a nlr;
    @Nullable
    private a nls;
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
        switch (layer.dJH()) {
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
                com.tb.airbnb.lottie.c.warn("Unknown layer type " + layer.dJH());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, Layer layer) {
        this.lottieDrawable = fVar;
        this.nlp = layer;
        this.Ew = layer.getName() + "#draw";
        this.Es.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.Ep.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.Eq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dJI() == Layer.MatteType.Invert) {
            this.Er.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.Er.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.nkb = layer.dJB().dJf();
        this.nkb.a((a.InterfaceC0845a) this);
        if (layer.hu() != null && !layer.hu().isEmpty()) {
            this.nlq = new com.tb.airbnb.lottie.a.b.g(layer.hu());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.nlq.hv()) {
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.nlq.hw()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        iE();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0845a
    public void ha() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dJG() {
        return this.nlp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.nlr = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean iD() {
        return this.nlr != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.nls = aVar;
    }

    private void iE() {
        if (!this.nlp.iJ().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.nlp.iJ());
            cVar.ho();
            cVar.b(new a.InterfaceC0845a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0845a
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
        this.Ex.preConcat(this.nkb.getMatrix());
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
            this.matrix.preConcat(this.ED.get(size).nkb.getMatrix());
        }
        com.tb.airbnb.lottie.c.aV("Layer#parentMatrix");
        int intValue = (int) (((this.nkb.dIR().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!iD() && !iF()) {
            this.matrix.preConcat(this.nkb.getMatrix());
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
        this.matrix.preConcat(this.nkb.getMatrix());
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
            this.nlr.a(canvas, matrix, intValue);
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
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.nlp.getName(), f);
    }

    private void e(Canvas canvas) {
        com.tb.airbnb.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.Es);
        com.tb.airbnb.lottie.c.aV("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.Et.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (iF()) {
            int size = this.nlq.hu().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.nlq.hv().get(i).getValue());
                this.path.transform(matrix);
                switch (this.nlq.hu().get(i).dJp()) {
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
        if (iD() && this.nlp.dJI() != Layer.MatteType.Invert) {
            this.nlr.a(this.Eu, matrix);
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
        int size = this.nlq.hu().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.nlq.hu().get(i).dJp() != maskMode) {
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
                if (this.nlq.hu().get(i2).dJp() == maskMode) {
                    this.path.set(this.nlq.hv().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.Eo.getAlpha();
                    this.Eo.setAlpha((int) (this.nlq.hw().get(i2).getValue().intValue() * 2.55f));
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
        return (this.nlq == null || this.nlq.hv().isEmpty()) ? false : true;
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
        this.nkb.setProgress(f);
        if (this.nlq != null) {
            for (int i = 0; i < this.nlq.hv().size(); i++) {
                this.nlq.hv().get(i).setProgress(f);
            }
        }
        if (this.nlp.iH() != 0.0f) {
            f /= this.nlp.iH();
        }
        if (this.nlr != null) {
            this.nlr.setProgress(this.nlr.nlp.iH() * f);
        }
        for (int i2 = 0; i2 < this.EE.size(); i2++) {
            this.EE.get(i2).setProgress(f);
        }
    }

    private void iG() {
        if (this.ED == null) {
            if (this.nls == null) {
                this.ED = Collections.emptyList();
                return;
            }
            this.ED = new ArrayList();
            for (a aVar = this.nls; aVar != null; aVar = aVar.nls) {
                this.ED.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.nlp.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        if (eVar.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.Rc(getName());
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
        this.nkb.b(t, cVar);
    }
}
