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
/* loaded from: classes6.dex */
public abstract class a implements com.ksad.lottie.a.a.d, a.InterfaceC0352a {

    /* renamed from: b  reason: collision with root package name */
    public final com.ksad.lottie.f f31569b;

    /* renamed from: c  reason: collision with root package name */
    public final Layer f31570c;

    /* renamed from: d  reason: collision with root package name */
    public final o f31571d;
    public final String p;
    @Nullable
    public com.ksad.lottie.a.b.g q;
    @Nullable
    public a r;
    @Nullable
    public a s;
    public List<a> t;

    /* renamed from: e  reason: collision with root package name */
    public final Path f31572e = new Path();

    /* renamed from: f  reason: collision with root package name */
    public final Matrix f31573f = new Matrix();

    /* renamed from: g  reason: collision with root package name */
    public final Paint f31574g = new Paint(1);

    /* renamed from: h  reason: collision with root package name */
    public final Paint f31575h = new Paint(1);
    public final Paint i = new Paint(1);
    public final Paint j = new Paint(1);
    public final Paint k = new Paint();
    public final RectF l = new RectF();
    public final RectF m = new RectF();
    public final RectF n = new RectF();
    public final RectF o = new RectF();

    /* renamed from: a  reason: collision with root package name */
    public final Matrix f31568a = new Matrix();
    public final List<com.ksad.lottie.a.b.a<?, ?>> u = new ArrayList();
    public boolean v = true;

    /* renamed from: com.ksad.lottie.model.layer.a$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31578a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f31579b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f31579b = iArr;
            try {
                iArr[Mask.MaskMode.MaskModeSubtract.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31579b[Mask.MaskMode.MaskModeIntersect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31579b[Mask.MaskMode.MaskModeAdd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f31578a = iArr2;
            try {
                iArr2[Layer.LayerType.Shape.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31578a[Layer.LayerType.PreComp.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31578a[Layer.LayerType.Solid.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31578a[Layer.LayerType.Image.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f31578a[Layer.LayerType.Null.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f31578a[Layer.LayerType.Text.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f31578a[Layer.LayerType.Unknown.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public a(com.ksad.lottie.f fVar, Layer layer) {
        Paint paint;
        PorterDuffXfermode porterDuffXfermode;
        this.f31569b = fVar;
        this.f31570c = layer;
        this.p = layer.f() + "#draw";
        this.k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f31575h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.l() == Layer.MatteType.Invert) {
            paint = this.j;
            porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        } else {
            paint = this.j;
            porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        }
        paint.setXfermode(porterDuffXfermode);
        o h2 = layer.o().h();
        this.f31571d = h2;
        h2.a((a.InterfaceC0352a) this);
        if (layer.j() != null && !layer.j().isEmpty()) {
            com.ksad.lottie.a.b.g gVar = new com.ksad.lottie.a.b.g(layer.j());
            this.q = gVar;
            for (com.ksad.lottie.a.b.a<h, Path> aVar : gVar.b()) {
                aVar.a(this);
            }
            for (com.ksad.lottie.a.b.a<Integer, Integer> aVar2 : this.q.c()) {
                a(aVar2);
                aVar2.a(this);
            }
        }
        e();
    }

    @Nullable
    public static a a(Layer layer, com.ksad.lottie.f fVar, com.ksad.lottie.d dVar) {
        switch (AnonymousClass2.f31578a[layer.k().ordinal()]) {
            case 1:
                return new e(fVar, layer);
            case 2:
                return new b(fVar, layer, dVar.b(layer.g()), dVar);
            case 3:
                return new f(fVar, layer);
            case 4:
                return new c(fVar, layer);
            case 5:
                return new d(fVar, layer);
            case 6:
                return new g(fVar, layer);
            default:
                com.ksad.lottie.c.b("Unknown layer type " + layer.k());
                return null;
        }
    }

    private void a(Canvas canvas) {
        com.ksad.lottie.c.c("Layer#clearLayer");
        RectF rectF = this.l;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.k);
        com.ksad.lottie.c.d("Layer#clearLayer");
    }

    private void a(Canvas canvas, Matrix matrix) {
        a(canvas, matrix, Mask.MaskMode.MaskModeAdd);
        a(canvas, matrix, Mask.MaskMode.MaskModeIntersect);
        a(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
    }

    private void a(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        boolean z = true;
        Paint paint = AnonymousClass2.f31579b[maskMode.ordinal()] != 1 ? this.f31575h : this.i;
        int size = this.q.a().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            } else if (this.q.a().get(i).a() == maskMode) {
                break;
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
                    this.f31572e.set(this.q.b().get(i2).e());
                    this.f31572e.transform(matrix);
                    int alpha = this.f31574g.getAlpha();
                    this.f31574g.setAlpha((int) (this.q.c().get(i2).e().intValue() * 2.55f));
                    canvas.drawPath(this.f31572e, this.f31574g);
                    this.f31574g.setAlpha(alpha);
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

    private void b(float f2) {
        this.f31569b.r().a().a(this.f31570c.f(), f2);
    }

    private void b(RectF rectF, Matrix matrix) {
        this.m.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (d()) {
            int size = this.q.a().size();
            for (int i = 0; i < size; i++) {
                this.f31572e.set(this.q.b().get(i).e());
                this.f31572e.transform(matrix);
                int i2 = AnonymousClass2.f31579b[this.q.a().get(i).a().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    return;
                }
                this.f31572e.computeBounds(this.o, false);
                RectF rectF2 = this.m;
                if (i == 0) {
                    rectF2.set(this.o);
                } else {
                    rectF2.set(Math.min(rectF2.left, this.o.left), Math.min(this.m.top, this.o.top), Math.max(this.m.right, this.o.right), Math.max(this.m.bottom, this.o.bottom));
                }
            }
            rectF.set(Math.max(rectF.left, this.m.left), Math.max(rectF.top, this.m.top), Math.min(rectF.right, this.m.right), Math.min(rectF.bottom, this.m.bottom));
        }
    }

    private void c(RectF rectF, Matrix matrix) {
        if (c() && this.f31570c.l() != Layer.MatteType.Invert) {
            this.r.a(this.n, matrix);
            rectF.set(Math.max(rectF.left, this.n.left), Math.max(rectF.top, this.n.top), Math.min(rectF.right, this.n.right), Math.min(rectF.bottom, this.n.bottom));
        }
    }

    private void e() {
        if (this.f31570c.d().isEmpty()) {
            a(true);
            return;
        }
        final com.ksad.lottie.a.b.c cVar = new com.ksad.lottie.a.b.c(this.f31570c.d());
        cVar.a();
        cVar.a(new a.InterfaceC0352a() { // from class: com.ksad.lottie.model.layer.a.1
            @Override // com.ksad.lottie.a.b.a.InterfaceC0352a
            public void a() {
                a.this.a(cVar.e().floatValue() == 1.0f);
            }
        });
        a(cVar.e().floatValue() == 1.0f);
        a(cVar);
    }

    private void f() {
        this.f31569b.invalidateSelf();
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

    @Override // com.ksad.lottie.a.b.a.InterfaceC0352a
    public void a() {
        f();
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f31571d.a(f2);
        if (this.q != null) {
            for (int i = 0; i < this.q.b().size(); i++) {
                this.q.b().get(i).a(f2);
            }
        }
        if (this.f31570c.b() != 0.0f) {
            f2 /= this.f31570c.b();
        }
        a aVar = this.r;
        if (aVar != null) {
            this.r.a(aVar.f31570c.b() * f2);
        }
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            this.u.get(i2).a(f2);
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
        this.f31573f.reset();
        this.f31573f.set(matrix);
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.f31573f.preConcat(this.t.get(size).f31571d.d());
        }
        com.ksad.lottie.c.d("Layer#parentMatrix");
        int intValue = (int) ((((i / 255.0f) * this.f31571d.a().e().intValue()) / 100.0f) * 255.0f);
        if (!c() && !d()) {
            this.f31573f.preConcat(this.f31571d.d());
            com.ksad.lottie.c.c("Layer#drawLayer");
            b(canvas, this.f31573f, intValue);
            com.ksad.lottie.c.d("Layer#drawLayer");
            b(com.ksad.lottie.c.d(this.p));
            return;
        }
        com.ksad.lottie.c.c("Layer#computeBounds");
        this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
        a(this.l, this.f31573f);
        c(this.l, this.f31573f);
        this.f31573f.preConcat(this.f31571d.d());
        b(this.l, this.f31573f);
        this.l.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        com.ksad.lottie.c.d("Layer#computeBounds");
        com.ksad.lottie.c.c("Layer#saveLayer");
        a(canvas, this.l, this.f31574g, true);
        com.ksad.lottie.c.d("Layer#saveLayer");
        a(canvas);
        com.ksad.lottie.c.c("Layer#drawLayer");
        b(canvas, this.f31573f, intValue);
        com.ksad.lottie.c.d("Layer#drawLayer");
        if (d()) {
            a(canvas, this.f31573f);
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
        this.f31568a.set(matrix);
        this.f31568a.preConcat(this.f31571d.d());
    }

    public void a(com.ksad.lottie.a.b.a<?, ?> aVar) {
        this.u.add(aVar);
    }

    public void a(@Nullable a aVar) {
        this.r = aVar;
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<com.ksad.lottie.a.a.b> list, List<com.ksad.lottie.a.a.b> list2) {
    }

    public Layer b() {
        return this.f31570c;
    }

    public abstract void b(Canvas canvas, Matrix matrix, int i);

    public void b(@Nullable a aVar) {
        this.s = aVar;
    }

    public boolean c() {
        return this.r != null;
    }

    public boolean d() {
        com.ksad.lottie.a.b.g gVar = this.q;
        return (gVar == null || gVar.b().isEmpty()) ? false : true;
    }
}
