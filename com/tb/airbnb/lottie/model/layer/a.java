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
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC0865a, com.tb.airbnb.lottie.model.f {
    private final String EY;
    private List<a> Fe;
    final com.tb.airbnb.lottie.f lottieDrawable;
    final o nFT;
    final Layer nHh;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g nHi;
    @Nullable
    private a nHj;
    @Nullable
    private a nHk;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint EP = new Paint(1);
    private final Paint ER = new Paint(1);
    private final Paint ES = new Paint(1);
    private final Paint ET = new Paint(1);
    private final Paint EU = new Paint();
    private final RectF rect = new RectF();
    private final RectF EV = new RectF();
    private final RectF EW = new RectF();
    private final RectF EX = new RectF();
    final Matrix EZ = new Matrix();
    private final List<com.tb.airbnb.lottie.a.b.a<?, ?>> Ff = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.d dVar) {
        switch (layer.dOr()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, dVar.aY(layer.getRefId()), dVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer);
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                com.tb.airbnb.lottie.c.warn("Unknown layer type " + layer.dOr());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, Layer layer) {
        this.lottieDrawable = fVar;
        this.nHh = layer;
        this.EY = layer.getName() + "#draw";
        this.EU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.ER.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.ES.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.dOs() == Layer.MatteType.Invert) {
            this.ET.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.ET.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.nFT = layer.dOl().dNP();
        this.nFT.a((a.InterfaceC0865a) this);
        if (layer.hK() != null && !layer.hK().isEmpty()) {
            this.nHi = new com.tb.airbnb.lottie.a.b.g(layer.hK());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.nHi.hL()) {
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.nHi.hM()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        iU();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0865a
    public void hq() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer dOq() {
        return this.nHh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.nHj = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean iT() {
        return this.nHj != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.nHk = aVar;
    }

    private void iU() {
        if (!this.nHh.iZ().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.nHh.iZ());
            cVar.hE();
            cVar.b(new a.InterfaceC0865a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0865a
                public void hq() {
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
        this.Ff.add(aVar);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.EZ.set(matrix);
        this.EZ.preConcat(this.nFT.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection(this.EY);
        if (!this.visible) {
            com.tb.airbnb.lottie.c.aW(this.EY);
            return;
        }
        iW();
        com.tb.airbnb.lottie.c.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.Fe.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.Fe.get(size).nFT.getMatrix());
        }
        com.tb.airbnb.lottie.c.aW("Layer#parentMatrix");
        int intValue = (int) (((this.nFT.dNB().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!iT() && !iV()) {
            this.matrix.preConcat(this.nFT.getMatrix());
            com.tb.airbnb.lottie.c.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.tb.airbnb.lottie.c.aW("Layer#drawLayer");
            j(com.tb.airbnb.lottie.c.aW(this.EY));
            return;
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.nFT.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.tb.airbnb.lottie.c.aW("Layer#computeBounds");
        com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.EP, true);
        com.tb.airbnb.lottie.c.aW("Layer#saveLayer");
        e(canvas);
        com.tb.airbnb.lottie.c.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.tb.airbnb.lottie.c.aW("Layer#drawLayer");
        if (iV()) {
            a(canvas, this.matrix);
        }
        if (iT()) {
            com.tb.airbnb.lottie.c.beginSection("Layer#drawMatte");
            com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.ET, false);
            com.tb.airbnb.lottie.c.aW("Layer#saveLayer");
            e(canvas);
            this.nHj.a(canvas, matrix, intValue);
            com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.c.aW("Layer#restoreLayer");
            com.tb.airbnb.lottie.c.aW("Layer#drawMatte");
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tb.airbnb.lottie.c.aW("Layer#restoreLayer");
        j(com.tb.airbnb.lottie.c.aW(this.EY));
    }

    private void j(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.nHh.getName(), f);
    }

    private void e(Canvas canvas) {
        com.tb.airbnb.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.EU);
        com.tb.airbnb.lottie.c.aW("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.EV.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (iV()) {
            int size = this.nHi.hK().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.nHi.hL().get(i).getValue());
                this.path.transform(matrix);
                switch (this.nHi.hK().get(i).dNZ()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.EX, false);
                        if (i == 0) {
                            this.EV.set(this.EX);
                        } else {
                            this.EV.set(Math.min(this.EV.left, this.EX.left), Math.min(this.EV.top, this.EX.top), Math.max(this.EV.right, this.EX.right), Math.max(this.EV.bottom, this.EX.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.EV.left), Math.max(rectF.top, this.EV.top), Math.min(rectF.right, this.EV.right), Math.min(rectF.bottom, this.EV.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (iT() && this.nHh.dOs() != Layer.MatteType.Invert) {
            this.nHj.a(this.EW, matrix);
            rectF.set(Math.max(rectF.left, this.EW.left), Math.max(rectF.top, this.EW.top), Math.min(rectF.right, this.EW.right), Math.min(rectF.bottom, this.EW.bottom));
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
                paint = this.ES;
                break;
            default:
                paint = this.ER;
                break;
        }
        int size = this.nHi.hK().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.nHi.hK().get(i).dNZ() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.tb.airbnb.lottie.c.beginSection("Layer#drawMask");
            com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.rect, paint, false);
            com.tb.airbnb.lottie.c.aW("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.nHi.hK().get(i2).dNZ() == maskMode) {
                    this.path.set(this.nHi.hL().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.EP.getAlpha();
                    this.EP.setAlpha((int) (this.nHi.hM().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.EP);
                    this.EP.setAlpha(alpha);
                }
            }
            com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.c.aW("Layer#restoreLayer");
            com.tb.airbnb.lottie.c.aW("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean iV() {
        return (this.nHi == null || this.nHi.hL().isEmpty()) ? false : true;
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
        this.nFT.setProgress(f);
        if (this.nHi != null) {
            for (int i = 0; i < this.nHi.hL().size(); i++) {
                this.nHi.hL().get(i).setProgress(f);
            }
        }
        if (this.nHh.iX() != 0.0f) {
            f /= this.nHh.iX();
        }
        if (this.nHj != null) {
            this.nHj.setProgress(this.nHj.nHh.iX() * f);
        }
        for (int i2 = 0; i2 < this.Ff.size(); i2++) {
            this.Ff.get(i2).setProgress(f);
        }
    }

    private void iW() {
        if (this.Fe == null) {
            if (this.nHk == null) {
                this.Fe = Collections.emptyList();
                return;
            }
            this.Fe = new ArrayList();
            for (a aVar = this.nHk; aVar != null; aVar = aVar.nHk) {
                this.Fe.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.nHh.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        if (eVar.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.RP(getName());
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
        this.nFT.b(t, cVar);
    }
}
