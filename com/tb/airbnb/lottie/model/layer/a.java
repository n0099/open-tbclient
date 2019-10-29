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
/* loaded from: classes6.dex */
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC0577a {
    private final String hJ;
    private List<a> hP;
    final p ktr;
    final Layer kuK;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g kuL;
    @Nullable
    private a kuM;
    @Nullable
    private a kuN;
    final com.tb.airbnb.lottie.f lottieDrawable;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint hB = new Paint(1);
    private final Paint hC = new Paint(1);
    private final Paint hD = new Paint(1);
    private final Paint hE = new Paint(1);
    private final Paint hF = new Paint();
    private final RectF rect = new RectF();
    private final RectF hG = new RectF();
    private final RectF hH = new RectF();
    private final RectF hI = new RectF();
    final Matrix hK = new Matrix();
    private final List<com.tb.airbnb.lottie.a.b.a<?, ?>> hQ = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.e eVar) {
        switch (layer.cMg()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, eVar.F(layer.getRefId()), eVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer, eVar.bb());
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                Log.w("LOTTIE", "Unknown layer type " + layer.cMg());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, Layer layer) {
        this.lottieDrawable = fVar;
        this.kuK = layer;
        this.hJ = layer.getName() + "#draw";
        this.hF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.hC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.hD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.cMh() == Layer.MatteType.Invert) {
            this.hE.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.hE.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.ktr = layer.cMa().cLC();
        this.ktr.a((a.InterfaceC0577a) this);
        if (layer.bL() != null && !layer.bL().isEmpty()) {
            this.kuL = new com.tb.airbnb.lottie.a.b.g(layer.bL());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.kuL.bM()) {
                a(aVar);
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.kuL.bN()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        db();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0577a
    public void bt() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer cMf() {
        return this.kuK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.kuM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean da() {
        return this.kuM != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.kuN = aVar;
    }

    private void db() {
        if (!this.kuK.df().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.kuK.df());
            cVar.bH();
            cVar.b(new a.InterfaceC0577a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0577a
                public void bt() {
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
            this.hQ.add(aVar);
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.hK.set(matrix);
        this.hK.preConcat(this.ktr.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @SuppressLint({"WrongConstant"})
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.d.beginSection(this.hJ);
        if (!this.visible) {
            com.tb.airbnb.lottie.d.D(this.hJ);
            return;
        }
        dd();
        com.tb.airbnb.lottie.d.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.hP.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.hP.get(size).ktr.getMatrix());
        }
        com.tb.airbnb.lottie.d.D("Layer#parentMatrix");
        int intValue = (int) (((this.ktr.cLk().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!da() && !dc()) {
            this.matrix.preConcat(this.ktr.getMatrix());
            com.tb.airbnb.lottie.d.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.tb.airbnb.lottie.d.D("Layer#drawLayer");
            i(com.tb.airbnb.lottie.d.D(this.hJ));
            return;
        }
        com.tb.airbnb.lottie.d.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.ktr.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.tb.airbnb.lottie.d.D("Layer#computeBounds");
        com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
        canvas.saveLayer(this.rect, this.hB, 31);
        com.tb.airbnb.lottie.d.D("Layer#saveLayer");
        d(canvas);
        com.tb.airbnb.lottie.d.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.tb.airbnb.lottie.d.D("Layer#drawLayer");
        if (dc()) {
            a(canvas, this.matrix);
        }
        if (da()) {
            com.tb.airbnb.lottie.d.beginSection("Layer#drawMatte");
            com.tb.airbnb.lottie.d.beginSection("Layer#saveLayer");
            canvas.saveLayer(this.rect, this.hE, 19);
            com.tb.airbnb.lottie.d.D("Layer#saveLayer");
            d(canvas);
            this.kuM.a(canvas, matrix, intValue);
            com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.d.D("Layer#restoreLayer");
            com.tb.airbnb.lottie.d.D("Layer#drawMatte");
        }
        com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tb.airbnb.lottie.d.D("Layer#restoreLayer");
        i(com.tb.airbnb.lottie.d.D(this.hJ));
    }

    private void i(float f) {
        this.lottieDrawable.cLc().getPerformanceTracker().b(this.kuK.getName(), f);
    }

    private void d(Canvas canvas) {
        com.tb.airbnb.lottie.d.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.hF);
        com.tb.airbnb.lottie.d.D("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.hG.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (dc()) {
            int size = this.kuL.bL().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.kuL.bM().get(i).getValue());
                this.path.transform(matrix);
                switch (this.kuL.bL().get(i).cLO()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                    case MaskModeUnknown:
                        return;
                    default:
                        this.path.computeBounds(this.hI, false);
                        if (i == 0) {
                            this.hG.set(this.hI);
                        } else {
                            this.hG.set(Math.min(this.hG.left, this.hI.left), Math.min(this.hG.top, this.hI.top), Math.max(this.hG.right, this.hI.right), Math.max(this.hG.bottom, this.hI.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.hG.left), Math.max(rectF.top, this.hG.top), Math.min(rectF.right, this.hG.right), Math.min(rectF.bottom, this.hG.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (da() && this.kuK.cMh() != Layer.MatteType.Invert) {
            this.kuM.a(this.hH, matrix);
            rectF.set(Math.max(rectF.left, this.hH.left), Math.max(rectF.top, this.hH.top), Math.min(rectF.right, this.hH.right), Math.min(rectF.bottom, this.hH.bottom));
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
            paint = this.hD;
        } else {
            paint = this.hC;
        }
        int size = this.kuL.bL().size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (this.kuL.bL().get(i).cLO() != maskMode) {
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
            com.tb.airbnb.lottie.d.D("Layer#saveLayer");
            d(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.kuL.bL().get(i2).cLO() == maskMode) {
                    this.path.set(this.kuL.bM().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.hB.getAlpha();
                    this.hB.setAlpha((int) (this.kuL.bN().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.hB);
                    this.hB.setAlpha(alpha);
                }
            }
            com.tb.airbnb.lottie.d.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.d.D("Layer#restoreLayer");
            com.tb.airbnb.lottie.d.D("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dc() {
        return (this.kuL == null || this.kuL.bM().isEmpty()) ? false : true;
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
        this.ktr.setProgress(f);
        if (this.kuK.de() != 0.0f) {
            f /= this.kuK.de();
        }
        if (this.kuM != null) {
            this.kuM.setProgress(this.kuM.kuK.de() * f);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hQ.size()) {
                this.hQ.get(i2).setProgress(f);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void dd() {
        if (this.hP == null) {
            if (this.kuN == null) {
                this.hP = Collections.emptyList();
                return;
            }
            this.hP = new ArrayList();
            for (a aVar = this.kuN; aVar != null; aVar = aVar.kuN) {
                this.hP.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.kuK.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void b(@Nullable String str, @Nullable String str2, @Nullable ColorFilter colorFilter) {
    }
}
