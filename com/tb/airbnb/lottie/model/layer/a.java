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
/* loaded from: classes20.dex */
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC1019a, com.tb.airbnb.lottie.model.f {
    private final String GN;
    private List<a> GV;
    final com.tb.airbnb.lottie.g lottieDrawable;
    final o pBn;
    final Layer pCB;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g pCC;
    @Nullable
    private a pCD;
    @Nullable
    private a pCE;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint GF = new Paint(1);
    private final Paint GG = new Paint(1);
    private final Paint GH = new Paint(1);
    private final Paint GI = new Paint(1);
    private final Paint GJ = new Paint();
    private final RectF rect = new RectF();
    private final RectF GK = new RectF();
    private final RectF GL = new RectF();
    private final RectF GM = new RectF();
    final Matrix GO = new Matrix();
    private final List<com.tb.airbnb.lottie.a.b.a<?, ?>> GW = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.e eVar) {
        switch (layer.eBT()) {
            case Shape:
                return new e(gVar, layer);
            case PreComp:
                return new b(gVar, layer, eVar.bg(layer.getRefId()), eVar);
            case Solid:
                return new f(gVar, layer);
            case Image:
                return new c(gVar, layer);
            case Null:
                return new d(gVar, layer);
            case Text:
                return new g(gVar, layer);
            default:
                com.tb.airbnb.lottie.d.warn("Unknown layer type " + layer.eBT());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.g gVar, Layer layer) {
        this.lottieDrawable = gVar;
        this.pCB = layer;
        this.GN = layer.getName() + "#draw";
        this.GJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.GG.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.GH.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.eBU() == Layer.MatteType.Invert) {
            this.GI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.GI.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.pBn = layer.eBN().eBr();
        this.pBn.a((a.InterfaceC1019a) this);
        if (layer.jn() != null && !layer.jn().isEmpty()) {
            this.pCC = new com.tb.airbnb.lottie.a.b.g(layer.jn());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.pCC.jo()) {
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.pCC.jp()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        kv();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1019a
    public void iT() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer eBS() {
        return this.pCB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.pCD = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ku() {
        return this.pCD != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.pCE = aVar;
    }

    private void kv() {
        if (!this.pCB.kA().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.pCB.kA());
            cVar.jh();
            cVar.b(new a.InterfaceC1019a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1019a
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
        this.GW.add(aVar);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.GO.set(matrix);
        this.GO.preConcat(this.pBn.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection(this.GN);
        if (!this.visible) {
            com.tb.airbnb.lottie.d.be(this.GN);
            return;
        }
        kx();
        com.tb.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.GV.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.GV.get(size).pBn.getMatrix());
        }
        com.tb.airbnb.lottie.d.be("Layer#parentMatrix");
        int intValue = (int) (((this.pBn.eBd().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!ku() && !kw()) {
            this.matrix.preConcat(this.pBn.getMatrix());
            com.tb.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.tb.airbnb.lottie.d.be("Layer#drawLayer");
            i(com.tb.airbnb.lottie.d.be(this.GN));
            return;
        }
        com.tb.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.pBn.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.tb.airbnb.lottie.d.be("Layer#computeBounds");
        com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.GF, true);
        com.tb.airbnb.lottie.d.be("Layer#saveLayer");
        e(canvas);
        com.tb.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.tb.airbnb.lottie.d.be("Layer#drawLayer");
        if (kw()) {
            a(canvas, this.matrix);
        }
        if (ku()) {
            com.tb.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.GI, false);
            com.tb.airbnb.lottie.d.be("Layer#saveLayer");
            e(canvas);
            this.pCD.a(canvas, matrix, intValue);
            com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.d.be("Layer#restoreLayer");
            com.tb.airbnb.lottie.d.be("Layer#drawMatte");
        }
        com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tb.airbnb.lottie.d.be("Layer#restoreLayer");
        i(com.tb.airbnb.lottie.d.be(this.GN));
    }

    private void i(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.pCB.getName(), f);
    }

    private void e(Canvas canvas) {
        com.tb.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.GJ);
        com.tb.airbnb.lottie.d.be("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.GK.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (kw()) {
            int size = this.pCC.jn().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.pCC.jo().get(i).getValue());
                this.path.transform(matrix);
                switch (this.pCC.jn().get(i).eBB()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.GM, false);
                        if (i == 0) {
                            this.GK.set(this.GM);
                        } else {
                            this.GK.set(Math.min(this.GK.left, this.GM.left), Math.min(this.GK.top, this.GM.top), Math.max(this.GK.right, this.GM.right), Math.max(this.GK.bottom, this.GM.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.GK.left), Math.max(rectF.top, this.GK.top), Math.min(rectF.right, this.GK.right), Math.min(rectF.bottom, this.GK.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (ku() && this.pCB.eBU() != Layer.MatteType.Invert) {
            this.pCD.a(this.GL, matrix);
            rectF.set(Math.max(rectF.left, this.GL.left), Math.max(rectF.top, this.GL.top), Math.min(rectF.right, this.GL.right), Math.min(rectF.bottom, this.GL.bottom));
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
                paint = this.GH;
                break;
            default:
                paint = this.GG;
                break;
        }
        int size = this.pCC.jn().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.pCC.jn().get(i).eBB() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.tb.airbnb.lottie.d.beginSection("Layer#drawMask");
            com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
            a(canvas, this.rect, paint, false);
            com.tb.airbnb.lottie.d.be("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.pCC.jn().get(i2).eBB() == maskMode) {
                    this.path.set(this.pCC.jo().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.GF.getAlpha();
                    this.GF.setAlpha((int) (this.pCC.jp().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.GF);
                    this.GF.setAlpha(alpha);
                }
            }
            com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.d.be("Layer#restoreLayer");
            com.tb.airbnb.lottie.d.be("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kw() {
        return (this.pCC == null || this.pCC.jo().isEmpty()) ? false : true;
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
        this.pBn.setProgress(f);
        if (this.pCC != null) {
            for (int i = 0; i < this.pCC.jo().size(); i++) {
                this.pCC.jo().get(i).setProgress(f);
            }
        }
        if (this.pCB.ky() != 0.0f) {
            f /= this.pCB.ky();
        }
        if (this.pCD != null) {
            this.pCD.setProgress(this.pCD.pCB.ky() * f);
        }
        for (int i2 = 0; i2 < this.GW.size(); i2++) {
            this.GW.get(i2).setProgress(f);
        }
    }

    private void kx() {
        if (this.GV == null) {
            if (this.pCE == null) {
                this.GV = Collections.emptyList();
                return;
            }
            this.GV = new ArrayList();
            for (a aVar = this.pCE; aVar != null; aVar = aVar.pCE) {
                this.GV.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.pCB.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.ZT(getName());
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
        this.pBn.b(t, cVar);
    }
}
