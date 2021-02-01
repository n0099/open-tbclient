package com.ksad.lottie.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.a.b.o;
import com.ksad.lottie.model.content.Mask;
import com.ksad.lottie.model.content.h;
import com.ksad.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a implements com.ksad.lottie.a.a.d, a.InterfaceC1065a {

    /* renamed from: b  reason: collision with root package name */
    final com.ksad.lottie.f f8096b;
    final Layer c;
    final o d;
    private final String p;
    @Nullable
    private com.ksad.lottie.a.b.g q;
    @Nullable
    private a r;
    @Nullable
    private a s;
    private List<a> t;
    private final Path e = new Path();
    private final Matrix f = new Matrix();
    private final Paint g = new Paint(1);
    private final Paint h = new Paint(1);
    private final Paint i = new Paint(1);
    private final Paint j = new Paint(1);
    private final Paint k = new Paint();
    private final RectF l = new RectF();
    private final RectF m = new RectF();
    private final RectF n = new RectF();
    private final RectF o = new RectF();

    /* renamed from: a  reason: collision with root package name */
    final Matrix f8095a = new Matrix();
    private final List<com.ksad.lottie.a.b.a<?, ?>> u = new ArrayList();
    private boolean v = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.ksad.lottie.f fVar, Layer layer) {
        this.f8096b = fVar;
        this.c = layer;
        this.p = layer.f() + "#draw";
        this.k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.l() == Layer.MatteType.Invert) {
            this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.d = layer.o().h();
        this.d.a((a.InterfaceC1065a) this);
        if (layer.j() != null && !layer.j().isEmpty()) {
            this.q = new com.ksad.lottie.a.b.g(layer.j());
            for (com.ksad.lottie.a.b.a<h, Path> aVar : this.q.b()) {
                aVar.a(this);
            }
            for (com.ksad.lottie.a.b.a<Integer, Integer> aVar2 : this.q.c()) {
                a(aVar2);
                aVar2.a(this);
            }
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a a(Layer layer, com.ksad.lottie.f fVar, com.ksad.lottie.d dVar) {
        switch (layer.k()) {
            case Shape:
                return new e(fVar, layer);
            case PreComp:
                return new b(fVar, layer, dVar.b(layer.g()), dVar);
            case Solid:
                return new f(fVar, layer);
            case Image:
                return new c(fVar, layer);
            case Null:
                return new d(fVar, layer);
            case Text:
                return new g(fVar, layer);
            default:
                com.ksad.lottie.c.b("Unknown layer type " + layer.k());
                return null;
        }
    }

    private void a(Canvas canvas) {
        com.ksad.lottie.c.c("Layer#clearLayer");
        canvas.drawRect(this.l.left - 1.0f, this.l.top - 1.0f, this.l.right + 1.0f, 1.0f + this.l.bottom, this.k);
        com.ksad.lottie.c.d("Layer#clearLayer");
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
                paint = this.i;
                break;
            default:
                paint = this.h;
                break;
        }
        int size = this.q.a().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
            } else if (this.q.a().get(i).a() == maskMode) {
                z = true;
            } else {
                i++;
            }
        }
        if (z) {
            com.ksad.lottie.c.c("Layer#drawMask");
            com.ksad.lottie.c.c("Layer#saveLayer");
            a(canvas, this.l, paint, false);
            com.ksad.lottie.c.d("Layer#saveLayer");
            a(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.q.a().get(i2).a() == maskMode) {
                    this.e.set(this.q.b().get(i2).e());
                    this.e.transform(matrix);
                    int alpha = this.g.getAlpha();
                    this.g.setAlpha((int) (this.q.c().get(i2).e().intValue() * 2.55f));
                    canvas.drawPath(this.e, this.g);
                    this.g.setAlpha(alpha);
                }
            }
            com.ksad.lottie.c.c("Layer#restoreLayer");
            canvas.restore();
            com.ksad.lottie.c.d("Layer#restoreLayer");
            com.ksad.lottie.c.d("Layer#drawMask");
        }
    }

    @SuppressLint({"WrongConstant"})
    private void a(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z != this.v) {
            this.v = z;
            f();
        }
    }

    private void b(float f) {
        this.f8096b.r().a().a(this.c.f(), f);
    }

    private void b(RectF rectF, Matrix matrix) {
        this.m.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (d()) {
            int size = this.q.a().size();
            for (int i = 0; i < size; i++) {
                this.e.set(this.q.b().get(i).e());
                this.e.transform(matrix);
                switch (this.q.a().get(i).a()) {
                    case MaskModeSubtract:
                    case MaskModeIntersect:
                        return;
                    default:
                        this.e.computeBounds(this.o, false);
                        if (i == 0) {
                            this.m.set(this.o);
                        } else {
                            this.m.set(Math.min(this.m.left, this.o.left), Math.min(this.m.top, this.o.top), Math.max(this.m.right, this.o.right), Math.max(this.m.bottom, this.o.bottom));
                        }
                }
            }
            rectF.set(Math.max(rectF.left, this.m.left), Math.max(rectF.top, this.m.top), Math.min(rectF.right, this.m.right), Math.min(rectF.bottom, this.m.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (c() && this.c.l() != Layer.MatteType.Invert) {
            this.r.a(this.n, matrix);
            rectF.set(Math.max(rectF.left, this.n.left), Math.max(rectF.top, this.n.top), Math.min(rectF.right, this.n.right), Math.min(rectF.bottom, this.n.bottom));
        }
    }

    private void e() {
        if (this.c.d().isEmpty()) {
            a(true);
            return;
        }
        final com.ksad.lottie.a.b.c cVar = new com.ksad.lottie.a.b.c(this.c.d());
        cVar.a();
        cVar.a(new a.InterfaceC1065a() { // from class: com.ksad.lottie.model.layer.a.1
            @Override // com.ksad.lottie.a.b.a.InterfaceC1065a
            public void a() {
                a.this.a(cVar.e().floatValue() == 1.0f);
            }
        });
        a(cVar.e().floatValue() == 1.0f);
        a(cVar);
    }

    private void f() {
        this.f8096b.invalidateSelf();
    }

    private void g() {
        if (this.t != null) {
            return;
        }
        if (this.s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        for (a aVar = this.s; aVar != null; aVar = aVar.s) {
            this.t.add(aVar);
        }
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC1065a
    public void a() {
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.d.a(f);
        if (this.q != null) {
            for (int i = 0; i < this.q.b().size(); i++) {
                this.q.b().get(i).a(f);
            }
        }
        if (this.c.b() != 0.0f) {
            f /= this.c.b();
        }
        if (this.r != null) {
            this.r.a(this.r.c.b() * f);
        }
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            this.u.get(i2).a(f);
        }
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.ksad.lottie.c.c(this.p);
        if (!this.v) {
            com.ksad.lottie.c.d(this.p);
            return;
        }
        g();
        com.ksad.lottie.c.c("Layer#parentMatrix");
        this.f.reset();
        this.f.set(matrix);
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.f.preConcat(this.t.get(size).d.d());
        }
        com.ksad.lottie.c.d("Layer#parentMatrix");
        int intValue = (int) (((this.d.a().e().intValue() * (i / 255.0f)) / 100.0f) * 255.0f);
        if (!c() && !d()) {
            this.f.preConcat(this.d.d());
            com.ksad.lottie.c.c("Layer#drawLayer");
            b(canvas, this.f, intValue);
            com.ksad.lottie.c.d("Layer#drawLayer");
            b(com.ksad.lottie.c.d(this.p));
            return;
        }
        com.ksad.lottie.c.c("Layer#computeBounds");
        this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.l, this.f);
        c(this.l, this.f);
        this.f.preConcat(this.d.d());
        b(this.l, this.f);
        this.l.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.ksad.lottie.c.d("Layer#computeBounds");
        com.ksad.lottie.c.c("Layer#saveLayer");
        a(canvas, this.l, this.g, true);
        com.ksad.lottie.c.d("Layer#saveLayer");
        a(canvas);
        com.ksad.lottie.c.c("Layer#drawLayer");
        b(canvas, this.f, intValue);
        com.ksad.lottie.c.d("Layer#drawLayer");
        if (d()) {
            a(canvas, this.f);
        }
        if (c()) {
            com.ksad.lottie.c.c("Layer#drawMatte");
            com.ksad.lottie.c.c("Layer#saveLayer");
            a(canvas, this.l, this.j, false);
            com.ksad.lottie.c.d("Layer#saveLayer");
            a(canvas);
            this.r.a(canvas, matrix, intValue);
            com.ksad.lottie.c.c("Layer#restoreLayer");
            canvas.restore();
            com.ksad.lottie.c.d("Layer#restoreLayer");
            com.ksad.lottie.c.d("Layer#drawMatte");
        }
        com.ksad.lottie.c.c("Layer#restoreLayer");
        canvas.restore();
        com.ksad.lottie.c.d("Layer#restoreLayer");
        b(com.ksad.lottie.c.d(this.p));
    }

    @Override // com.ksad.lottie.a.a.d
    @CallSuper
    public void a(RectF rectF, Matrix matrix) {
        this.f8095a.set(matrix);
        this.f8095a.preConcat(this.d.d());
    }

    public void a(com.ksad.lottie.a.b.a<?, ?> aVar) {
        this.u.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@Nullable a aVar) {
        this.r = aVar;
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<com.ksad.lottie.a.a.b> list, List<com.ksad.lottie.a.a.b> list2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer b() {
        return this.c;
    }

    abstract void b(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable a aVar) {
        this.s = aVar;
    }

    boolean c() {
        return this.r != null;
    }

    boolean d() {
        return (this.q == null || this.q.b().isEmpty()) ? false : true;
    }
}
