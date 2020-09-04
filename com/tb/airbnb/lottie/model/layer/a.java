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
/* loaded from: classes7.dex */
public abstract class a implements com.tb.airbnb.lottie.a.a.d, a.InterfaceC0932a, com.tb.airbnb.lottie.model.f {
    private final String FC;
    private List<a> FI;
    final com.tb.airbnb.lottie.f lottieDrawable;
    final o oiP;
    final Layer okd;
    @Nullable
    private com.tb.airbnb.lottie.a.b.g oke;
    @Nullable
    private a okf;
    @Nullable
    private a okg;
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
        switch (layer.edZ()) {
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
                com.tb.airbnb.lottie.c.warn("Unknown layer type " + layer.edZ());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.tb.airbnb.lottie.f fVar, Layer layer) {
        this.lottieDrawable = fVar;
        this.okd = layer;
        this.FC = layer.getName() + "#draw";
        this.Fy.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.Fv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.Fw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.eea() == Layer.MatteType.Invert) {
            this.Fx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.Fx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.oiP = layer.edT().edx();
        this.oiP.a((a.InterfaceC0932a) this);
        if (layer.jl() != null && !layer.jl().isEmpty()) {
            this.oke = new com.tb.airbnb.lottie.a.b.g(layer.jl());
            for (com.tb.airbnb.lottie.a.b.a<h, Path> aVar : this.oke.jm()) {
                aVar.b(this);
            }
            for (com.tb.airbnb.lottie.a.b.a<Integer, Integer> aVar2 : this.oke.jn()) {
                a(aVar2);
                aVar2.b(this);
            }
        }
        kt();
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0932a
    public void iR() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer edY() {
        return this.okd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.okf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ks() {
        return this.okf != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(@Nullable a aVar) {
        this.okg = aVar;
    }

    private void kt() {
        if (!this.okd.ky().isEmpty()) {
            final com.tb.airbnb.lottie.a.b.c cVar = new com.tb.airbnb.lottie.a.b.c(this.okd.ky());
            cVar.jf();
            cVar.b(new a.InterfaceC0932a() { // from class: com.tb.airbnb.lottie.model.layer.a.1
                @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0932a
                public void iR() {
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
        this.FD.preConcat(this.oiP.getMatrix());
    }

    @Override // com.tb.airbnb.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.tb.airbnb.lottie.c.beginSection(this.FC);
        if (!this.visible) {
            com.tb.airbnb.lottie.c.bb(this.FC);
            return;
        }
        kv();
        com.tb.airbnb.lottie.c.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.FI.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.FI.get(size).oiP.getMatrix());
        }
        com.tb.airbnb.lottie.c.bb("Layer#parentMatrix");
        int intValue = (int) (((this.oiP.edj().getValue().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!ks() && !ku()) {
            this.matrix.preConcat(this.oiP.getMatrix());
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
        this.matrix.preConcat(this.oiP.getMatrix());
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
        if (ku()) {
            a(canvas, this.matrix);
        }
        if (ks()) {
            com.tb.airbnb.lottie.c.beginSection("Layer#drawMatte");
            com.tb.airbnb.lottie.c.beginSection("Layer#saveLayer");
            a(canvas, this.rect, this.Fx, false);
            com.tb.airbnb.lottie.c.bb("Layer#saveLayer");
            e(canvas);
            this.okf.a(canvas, matrix, intValue);
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
        this.lottieDrawable.getComposition().getPerformanceTracker().b(this.okd.getName(), f);
    }

    private void e(Canvas canvas) {
        com.tb.airbnb.lottie.c.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, 1.0f + this.rect.bottom, this.Fy);
        com.tb.airbnb.lottie.c.bb("Layer#clearLayer");
    }

    private void b(RectF rectF, Matrix matrix) {
        this.Fz.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (ku()) {
            int size = this.oke.jl().size();
            for (int i = 0; i < size; i++) {
                this.path.set(this.oke.jm().get(i).getValue());
                this.path.transform(matrix);
                switch (this.oke.jl().get(i).edH()) {
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
        if (ks() && this.okd.eea() != Layer.MatteType.Invert) {
            this.okf.a(this.FA, matrix);
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
        int size = this.oke.jl().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.oke.jl().get(i).edH() != maskMode) {
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
                if (this.oke.jl().get(i2).edH() == maskMode) {
                    this.path.set(this.oke.jm().get(i2).getValue());
                    this.path.transform(matrix);
                    int alpha = this.Fu.getAlpha();
                    this.Fu.setAlpha((int) (this.oke.jn().get(i2).getValue().intValue() * 2.55f));
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
    public boolean ku() {
        return (this.oke == null || this.oke.jm().isEmpty()) ? false : true;
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
        this.oiP.setProgress(f);
        if (this.oke != null) {
            for (int i = 0; i < this.oke.jm().size(); i++) {
                this.oke.jm().get(i).setProgress(f);
            }
        }
        if (this.okd.kw() != 0.0f) {
            f /= this.okd.kw();
        }
        if (this.okf != null) {
            this.okf.setProgress(this.okf.okd.kw() * f);
        }
        for (int i2 = 0; i2 < this.FJ.size(); i2++) {
            this.FJ.get(i2).setProgress(f);
        }
    }

    private void kv() {
        if (this.FI == null) {
            if (this.okg == null) {
                this.FI = Collections.emptyList();
                return;
            }
            this.FI = new ArrayList();
            for (a aVar = this.okg; aVar != null; aVar = aVar.okg) {
                this.FI.add(aVar);
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.okd.getName();
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<com.tb.airbnb.lottie.a.a.b> list, List<com.tb.airbnb.lottie.a.a.b> list2) {
    }

    @Override // com.tb.airbnb.lottie.model.f
    public void a(com.tb.airbnb.lottie.model.e eVar, int i, List<com.tb.airbnb.lottie.model.e> list, com.tb.airbnb.lottie.model.e eVar2) {
        if (eVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.VE(getName());
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
        this.oiP.b(t, cVar);
    }
}
