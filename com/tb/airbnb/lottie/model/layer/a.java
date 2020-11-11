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
/* loaded from: classes16.dex */
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC1038a, com.tb.airbnb.lottie.model.f {
    private final String FU;
    private List<a> Ga;
    final com.tb.airbnb.lottie.g lottieDrawable;
    final o pIG;
    final Layer pJU;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g pJV;
    @Nullable
    private a pJW;
    @Nullable
    private a pJX;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint FL = new Paint(1);
    private final Paint FM = new Paint(1);
    private final Paint FN = new Paint(1);
    private final Paint FO = new Paint(1);
    private final Paint FP = new Paint();
    private final RectF rect = new RectF();
    private final RectF FQ = new RectF();
    private final RectF FR = new RectF();
    private final RectF FT = new RectF();
    final Matrix FV = new Matrix();
    private final List<com.tb.airbnb.lottie.a.b.a<?, ?>> Gb = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.e eVar) {
        switch (layer.ezw()) {
            case Shape:
                return new e(gVar, layer);
            case PreComp:
                return new b(gVar, layer, eVar.bd(layer.getRefId()), eVar);
            case Solid:
                return new f(gVar, layer);
            case Image:
                return new c(gVar, layer);
            case Null:
                return new d(gVar, layer);
            case Text:
                return new g(gVar, layer);
            default:
                com.tb.airbnb.lottie.d.warn("Unknown layer type " + layer.ezw());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.g gVar, Layer layer) {
        this.lottieDrawable = gVar;
        this.pJU = layer;
        this.FU = layer.getName() + "#draw";
        this.FP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.FM.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.FN.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.ezx() == Layer.MatteType.Invert) {
            this.FO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.FO.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.pIG = layer.ezq().eyU();
        this.pIG.a((a.InterfaceC1038a) this);
        if (layer.jn() != null && !layer.jn().isEmpty()) {
            this.pJV = new com.tb.airbnb.lottie.a.b.g(layer.jn());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.pJV.jo()) {
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.pJV.jp()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        kv();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1038a
    public void iT() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer ezv() {
        return this.pJU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.pJW = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ku() {
        return this.pJW != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.pJX = aVar;
    }

    private void kv() {
        if (!this.pJU.kA().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.pJU.kA());
            cVar.jh();
            cVar.b(new a.InterfaceC1038a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1038a
                public void iT() {
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
        this.Gb.add(aVar);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.FV.set(matrix);
        this.FV.preConcat(this.pIG.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection(this.FU);
        if (!this.visible) {
            com.tb.airbnb.lottie.d.bb(this.FU);
            return;
        }
        kx();
        com.tb.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.Ga.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.Ga.get(size).pIG.getMatrix());
        }
        com.tb.airbnb.lottie.d.bb("Layer#parentMatrix");
        int intValue = (int) (((this.pIG.eyG().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!ku() && !kw()) {
            this.matrix.preConcat(this.pIG.getMatrix());
            com.tb.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.tb.airbnb.lottie.d.bb("Layer#drawLayer");
            j(com.tb.airbnb.lottie.d.bb(this.FU));
            return;
        }
        com.tb.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.pIG.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.tb.airbnb.lottie.d.bb("Layer#computeBounds");
        com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.FL, true);
        com.tb.airbnb.lottie.d.bb("Layer#saveLayer");
        e(canvas);
        com.tb.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.tb.airbnb.lottie.d.bb("Layer#drawLayer");
        if (kw()) {
            a(canvas, this.matrix);
        }
        if (ku()) {
            com.tb.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.FO, false);
            com.tb.airbnb.lottie.d.bb("Layer#saveLayer");
            e(canvas);
            this.pJW.a(canvas, matrix, intValue);
            com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.d.bb("Layer#restoreLayer");
            com.tb.airbnb.lottie.d.bb("Layer#drawMatte");
        }
        com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tb.airbnb.lottie.d.bb("Layer#restoreLayer");
        j(com.tb.airbnb.lottie.d.bb(this.FU));
    }

    private void j(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.pJU.getName(), f);
    }

    private void e(Canvas canvas) {
        com.tb.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.FP);
        com.tb.airbnb.lottie.d.bb("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.FQ.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (kw()) {
            int size = this.pJV.jn().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.pJV.jo().get(i).getValue());
                this.path.transform(matrix);
                switch (this.pJV.jn().get(i).eze()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.FT, false);
                        if (i == 0) {
                            this.FQ.set(this.FT);
                        } else {
                            this.FQ.set(Math.min(this.FQ.left, this.FT.left), Math.min(this.FQ.top, this.FT.top), Math.max(this.FQ.right, this.FT.right), Math.max(this.FQ.bottom, this.FT.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.FQ.left), Math.max(rectF.top, this.FQ.top), Math.min(rectF.right, this.FQ.right), Math.min(rectF.bottom, this.FQ.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (ku() && this.pJU.ezx() != Layer.MatteType.Invert) {
            this.pJW.a(this.FR, matrix);
            rectF.set(Math.max(rectF.left, this.FR.left), Math.max(rectF.top, this.FR.top), Math.min(rectF.right, this.FR.right), Math.min(rectF.bottom, this.FR.bottom));
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
                paint = this.FN;
                break;
            default:
                paint = this.FM;
                break;
        }
        int size = this.pJV.jn().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.pJV.jn().get(i).eze() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.tb.airbnb.lottie.d.beginSection("Layer#drawMask");
            com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, paint, false);
            com.tb.airbnb.lottie.d.bb("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.pJV.jn().get(i2).eze() == maskMode) {
                    this.path.set(this.pJV.jo().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.FL.getAlpha();
                    this.FL.setAlpha((int) (this.pJV.jp().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.FL);
                    this.FL.setAlpha(alpha);
                }
            }
            com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.d.bb("Layer#restoreLayer");
            com.tb.airbnb.lottie.d.bb("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kw() {
        return (this.pJV == null || this.pJV.jo().isEmpty()) ? false : true;
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
        this.pIG.setProgress(f);
        if (this.pJV != null) {
            for (int i = 0; i < this.pJV.jo().size(); i++) {
                this.pJV.jo().get(i).setProgress(f);
            }
        }
        if (this.pJU.ky() != 0.0f) {
            f /= this.pJU.ky();
        }
        if (this.pJW != null) {
            this.pJW.setProgress(this.pJW.pJU.ky() * f);
        }
        for (int i2 = 0; i2 < this.Gb.size(); i2++) {
            this.Gb.get(i2).setProgress(f);
        }
    }

    private void kx() {
        if (this.Ga == null) {
            if (this.pJX == null) {
                this.Ga = Collections.emptyList();
                return;
            }
            this.Ga = new ArrayList();
            for (a aVar = this.pJX; aVar != null; aVar = aVar.pJX) {
                this.Ga.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.pJU.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.Zl(getName());
                if (eVar.j(getName(), i)) {
                    list.add(eVar2.a(this));
                }
            }
            if (eVar.k(getName(), i)) {
                b(eVar, eVar.i(getName(), i) + i, list, eVar2);
            }
        }
    }

    void b(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    @CallSuper
    public <T> void a(T t, @Nullable com.tb.airbnb.lottie.e.c<T> cVar) {
        this.pIG.b(t, cVar);
    }
}
