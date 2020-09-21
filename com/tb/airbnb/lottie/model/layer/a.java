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
/* loaded from: classes17.dex */
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC0929a, com.tb.airbnb.lottie.model.f {
    private final String FC;
    private List<a> FI;
    final com.tb.airbnb.lottie.f lottieDrawable;
    final o osz;
    final Layer otN;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g otO;
    @Nullable
    private a otP;
    @Nullable
    private a otQ;
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint Fu = new Paint(1);
    private final Paint Fv = new Paint(1);
    private final Paint Fw = new Paint(1);
    private final Paint Fx = new Paint(1);
    private final Paint Fy = new Paint();
    private final RectF rect = new RectF();
    private final RectF Fz = new RectF();
    private final RectF FA = new RectF();
    private final RectF FB = new RectF();
    final Matrix FD = new Matrix();
    private final List<com.tb.airbnb.lottie.a.b.a<?, ?>> FJ = new ArrayList();
    private boolean visible = true;

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.d dVar) {
        switch (layer.ehW()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, dVar.bd(layer.getRefId()), dVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer);
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                com.tb.airbnb.lottie.c.warn("Unknown layer type " + layer.ehW());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, Layer layer) {
        this.lottieDrawable = fVar;
        this.otN = layer;
        this.FC = layer.getName() + "#draw";
        this.Fy.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.Fv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.Fw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.ehX() == Layer.MatteType.Invert) {
            this.Fx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.Fx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.osz = layer.ehQ().ehu();
        this.osz.a((a.InterfaceC0929a) this);
        if (layer.jm() != null && !layer.jm().isEmpty()) {
            this.otO = new com.tb.airbnb.lottie.a.b.g(layer.jm());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.otO.jn()) {
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.otO.jo()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        ku();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0929a
    public void iS() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer ehV() {
        return this.otN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.otP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kt() {
        return this.otP != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.otQ = aVar;
    }

    private void ku() {
        if (!this.otN.kz().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.otN.kz());
            cVar.jg();
            cVar.b(new a.InterfaceC0929a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0929a
                public void iS() {
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
        this.FJ.add(aVar);
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.FD.set(matrix);
        this.FD.preConcat(this.osz.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection(this.FC);
        if (!this.visible) {
            com.tb.airbnb.lottie.c.bb(this.FC);
            return;
        }
        kw();
        com.tb.airbnb.lottie.c.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.FI.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.FI.get(size).osz.getMatrix());
        }
        com.tb.airbnb.lottie.c.bb("Layer#parentMatrix");
        int intValue = (int) (((this.osz.ehg().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!kt() && !kv()) {
            this.matrix.preConcat(this.osz.getMatrix());
            com.tb.airbnb.lottie.c.beginSection("Layer#drawLayer");
            b(canvas, this.matrix, intValue);
            com.tb.airbnb.lottie.c.bb("Layer#drawLayer");
            j(com.tb.airbnb.lottie.c.bb(this.FC));
            return;
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.rect, this.matrix);
        c(this.rect, this.matrix);
        this.matrix.preConcat(this.osz.getMatrix());
        b(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.tb.airbnb.lottie.c.bb("Layer#computeBounds");
        com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
        a(canvas, this.rect, this.Fu, true);
        com.tb.airbnb.lottie.c.bb("Layer#saveLayer");
        e(canvas);
        com.tb.airbnb.lottie.c.beginSection("Layer#drawLayer");
        b(canvas, this.matrix, intValue);
        com.tb.airbnb.lottie.c.bb("Layer#drawLayer");
        if (kv()) {
            a(canvas, this.matrix);
        }
        if (kt()) {
            com.tb.airbnb.lottie.c.beginSection("Layer#drawMatte");
            com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.Fx, false);
            com.tb.airbnb.lottie.c.bb("Layer#saveLayer");
            e(canvas);
            this.otP.a(canvas, matrix, intValue);
            com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.c.bb("Layer#restoreLayer");
            com.tb.airbnb.lottie.c.bb("Layer#drawMatte");
        }
        com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
        canvas.restore();
        com.tb.airbnb.lottie.c.bb("Layer#restoreLayer");
        j(com.tb.airbnb.lottie.c.bb(this.FC));
    }

    private void j(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.otN.getName(), f);
    }

    private void e(Canvas canvas) {
        com.tb.airbnb.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.Fy);
        com.tb.airbnb.lottie.c.bb("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.Fz.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (kv()) {
            int size = this.otO.jm().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.otO.jn().get(i).getValue());
                this.path.transform(matrix);
                switch (this.otO.jm().get(i).ehE()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.path.computeBounds(this.FB, false);
                        if (i == 0) {
                            this.Fz.set(this.FB);
                        } else {
                            this.Fz.set(Math.min(this.Fz.left, this.FB.left), Math.min(this.Fz.top, this.FB.top), Math.max(this.Fz.right, this.FB.right), Math.max(this.Fz.bottom, this.FB.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.Fz.left), Math.max(rectF.top, this.Fz.top), Math.min(rectF.right, this.Fz.right), Math.min(rectF.bottom, this.Fz.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (kt() && this.otN.ehX() != Layer.MatteType.Invert) {
            this.otP.a(this.FA, matrix);
            rectF.set(Math.max(rectF.left, this.FA.left), Math.max(rectF.top, this.FA.top), Math.min(rectF.right, this.FA.right), Math.min(rectF.bottom, this.FA.bottom));
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
                paint = this.Fw;
                break;
            default:
                paint = this.Fv;
                break;
        }
        int size = this.otO.jm().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.otO.jm().get(i).ehE() != maskMode) {
                i++;
            } else {
                z = true;
            }
        }
        if (z) {
            com.tb.airbnb.lottie.c.beginSection("Layer#drawMask");
            com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.rect, paint, false);
            com.tb.airbnb.lottie.c.bb("Layer#saveLayer");
            e(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.otO.jm().get(i2).ehE() == maskMode) {
                    this.path.set(this.otO.jn().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.Fu.getAlpha();
                    this.Fu.setAlpha((int) (this.otO.jo().get(i2).getValue().intValue() * 2.55f));
                    canvas.drawPath(this.path, this.Fu);
                    this.Fu.setAlpha(alpha);
                }
            }
            com.tb.airbnb.lottie.c.beginSection("Layer#restoreLayer");
            canvas.restore();
            com.tb.airbnb.lottie.c.bb("Layer#restoreLayer");
            com.tb.airbnb.lottie.c.bb("Layer#drawMask");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean kv() {
        return (this.otO == null || this.otO.jn().isEmpty()) ? false : true;
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
        this.osz.setProgress(f);
        if (this.otO != null) {
            for (int i = 0; i < this.otO.jn().size(); i++) {
                this.otO.jn().get(i).setProgress(f);
            }
        }
        if (this.otN.kx() != 0.0f) {
            f /= this.otN.kx();
        }
        if (this.otP != null) {
            this.otP.setProgress(this.otP.otN.kx() * f);
        }
        for (int i2 = 0; i2 < this.FJ.size(); i2++) {
            this.FJ.get(i2).setProgress(f);
        }
    }

    private void kw() {
        if (this.FI == null) {
            if (this.otQ == null) {
                this.FI = Collections.emptyList();
                return;
            }
            this.FI = new ArrayList();
            for (a aVar = this.otQ; aVar != null; aVar = aVar.otQ) {
                this.FI.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.otN.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.Wg(getName());
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
        this.osz.b(t, cVar);
    }
}
