package d.a.a.s.k;

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
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import d.a.a.q.b.a;
import d.a.a.q.b.o;
import d.a.a.s.j.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a implements d.a.a.q.a.d, a.InterfaceC0528a, d.a.a.s.f {
    public final String l;
    public final d.a.a.f n;
    public final Layer o;
    @Nullable
    public d.a.a.q.b.g p;
    @Nullable
    public a q;
    @Nullable
    public a r;
    public List<a> s;
    public final o u;

    /* renamed from: a  reason: collision with root package name */
    public final Path f41406a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final Matrix f41407b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    public final Paint f41408c = new Paint(1);

    /* renamed from: d  reason: collision with root package name */
    public final Paint f41409d = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    public final Paint f41410e = new Paint(1);

    /* renamed from: f  reason: collision with root package name */
    public final Paint f41411f = new Paint(1);

    /* renamed from: g  reason: collision with root package name */
    public final Paint f41412g = new Paint();

    /* renamed from: h  reason: collision with root package name */
    public final RectF f41413h = new RectF();
    public final RectF i = new RectF();
    public final RectF j = new RectF();
    public final RectF k = new RectF();
    public final Matrix m = new Matrix();
    public final List<d.a.a.q.b.a<?, ?>> t = new ArrayList();
    public boolean v = true;

    /* renamed from: d.a.a.s.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0529a implements a.InterfaceC0528a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.a.q.b.c f41414a;

        public C0529a(d.a.a.q.b.c cVar) {
            this.f41414a = cVar;
        }

        @Override // d.a.a.q.b.a.InterfaceC0528a
        public void a() {
            a.this.A(this.f41414a.h().floatValue() == 1.0f);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41416a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f41417b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f41417b = iArr;
            try {
                iArr[Mask.MaskMode.MaskModeSubtract.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41417b[Mask.MaskMode.MaskModeIntersect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41417b[Mask.MaskMode.MaskModeAdd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f41416a = iArr2;
            try {
                iArr2[Layer.LayerType.Shape.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41416a[Layer.LayerType.PreComp.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41416a[Layer.LayerType.Solid.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41416a[Layer.LayerType.Image.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41416a[Layer.LayerType.Null.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41416a[Layer.LayerType.Text.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41416a[Layer.LayerType.Unknown.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public a(d.a.a.f fVar, Layer layer) {
        this.n = fVar;
        this.o = layer;
        this.l = layer.g() + "#draw";
        this.f41412g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f41409d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f41410e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        if (layer.f() == Layer.MatteType.Invert) {
            this.f41411f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.f41411f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        o b2 = layer.u().b();
        this.u = b2;
        b2.b(this);
        if (layer.e() != null && !layer.e().isEmpty()) {
            d.a.a.q.b.g gVar = new d.a.a.q.b.g(layer.e());
            this.p = gVar;
            for (d.a.a.q.b.a<h, Path> aVar : gVar.a()) {
                aVar.a(this);
            }
            for (d.a.a.q.b.a<Integer, Integer> aVar2 : this.p.c()) {
                h(aVar2);
                aVar2.a(this);
            }
        }
        B();
    }

    @Nullable
    public static a n(Layer layer, d.a.a.f fVar, d.a.a.d dVar) {
        switch (b.f41416a[layer.d().ordinal()]) {
            case 1:
                return new e(fVar, layer);
            case 2:
                return new d.a.a.s.k.b(fVar, layer, dVar.l(layer.k()), dVar);
            case 3:
                return new f(fVar, layer);
            case 4:
                return new c(fVar, layer);
            case 5:
                return new d(fVar, layer);
            case 6:
                return new g(fVar, layer);
            default:
                d.a.a.c.d("Unknown layer type " + layer.d());
                return null;
        }
    }

    public final void A(boolean z) {
        if (z != this.v) {
            this.v = z;
            t();
        }
    }

    public final void B() {
        if (!this.o.c().isEmpty()) {
            d.a.a.q.b.c cVar = new d.a.a.q.b.c(this.o.c());
            cVar.k();
            cVar.a(new C0529a(cVar));
            A(cVar.h().floatValue() == 1.0f);
            h(cVar);
            return;
        }
        A(true);
    }

    @Override // d.a.a.q.b.a.InterfaceC0528a
    public void a() {
        t();
    }

    @Override // d.a.a.q.a.b
    public void b(List<d.a.a.q.a.b> list, List<d.a.a.q.a.b> list2) {
    }

    @Override // d.a.a.q.a.d
    @CallSuper
    public void c(RectF rectF, Matrix matrix) {
        this.m.set(matrix);
        this.m.preConcat(this.u.e());
    }

    @Override // d.a.a.s.f
    @CallSuper
    public <T> void d(T t, @Nullable d.a.a.w.c<T> cVar) {
        this.u.c(t, cVar);
    }

    @Override // d.a.a.s.f
    public void e(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2) {
        if (eVar.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.c(getName(), i)) {
                    list.add(eVar2.i(this));
                }
            }
            if (eVar.h(getName(), i)) {
                v(eVar, i + eVar.e(getName(), i), list, eVar2);
            }
        }
    }

    @Override // d.a.a.q.a.d
    public void g(Canvas canvas, Matrix matrix, int i) {
        d.a.a.c.a(this.l);
        if (!this.v) {
            d.a.a.c.c(this.l);
            return;
        }
        k();
        d.a.a.c.a("Layer#parentMatrix");
        this.f41407b.reset();
        this.f41407b.set(matrix);
        for (int size = this.s.size() - 1; size >= 0; size--) {
            this.f41407b.preConcat(this.s.get(size).u.e());
        }
        d.a.a.c.c("Layer#parentMatrix");
        int intValue = (int) ((((i / 255.0f) * this.u.g().h().intValue()) / 100.0f) * 255.0f);
        if (!q() && !p()) {
            this.f41407b.preConcat(this.u.e());
            d.a.a.c.a("Layer#drawLayer");
            m(canvas, this.f41407b, intValue);
            d.a.a.c.c("Layer#drawLayer");
            u(d.a.a.c.c(this.l));
            return;
        }
        d.a.a.c.a("Layer#computeBounds");
        this.f41413h.set(0.0f, 0.0f, 0.0f, 0.0f);
        c(this.f41413h, this.f41407b);
        s(this.f41413h, this.f41407b);
        this.f41407b.preConcat(this.u.e());
        r(this.f41413h, this.f41407b);
        this.f41413h.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        d.a.a.c.c("Layer#computeBounds");
        d.a.a.c.a("Layer#saveLayer");
        w(canvas, this.f41413h, this.f41408c, true);
        d.a.a.c.c("Layer#saveLayer");
        l(canvas);
        d.a.a.c.a("Layer#drawLayer");
        m(canvas, this.f41407b, intValue);
        d.a.a.c.c("Layer#drawLayer");
        if (p()) {
            i(canvas, this.f41407b);
        }
        if (q()) {
            d.a.a.c.a("Layer#drawMatte");
            d.a.a.c.a("Layer#saveLayer");
            w(canvas, this.f41413h, this.f41411f, false);
            d.a.a.c.c("Layer#saveLayer");
            l(canvas);
            this.q.g(canvas, matrix, intValue);
            d.a.a.c.a("Layer#restoreLayer");
            canvas.restore();
            d.a.a.c.c("Layer#restoreLayer");
            d.a.a.c.c("Layer#drawMatte");
        }
        d.a.a.c.a("Layer#restoreLayer");
        canvas.restore();
        d.a.a.c.c("Layer#restoreLayer");
        u(d.a.a.c.c(this.l));
    }

    @Override // d.a.a.q.a.b
    public String getName() {
        return this.o.g();
    }

    public void h(d.a.a.q.b.a<?, ?> aVar) {
        this.t.add(aVar);
    }

    public final void i(Canvas canvas, Matrix matrix) {
        j(canvas, matrix, Mask.MaskMode.MaskModeAdd);
        j(canvas, matrix, Mask.MaskMode.MaskModeIntersect);
        j(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
    }

    public final void j(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        Paint paint;
        boolean z = true;
        if (b.f41417b[maskMode.ordinal()] != 1) {
            paint = this.f41409d;
        } else {
            paint = this.f41410e;
        }
        int size = this.p.b().size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            } else if (this.p.b().get(i).a() == maskMode) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            d.a.a.c.a("Layer#drawMask");
            d.a.a.c.a("Layer#saveLayer");
            w(canvas, this.f41413h, paint, false);
            d.a.a.c.c("Layer#saveLayer");
            l(canvas);
            for (int i2 = 0; i2 < size; i2++) {
                if (this.p.b().get(i2).a() == maskMode) {
                    this.f41406a.set(this.p.a().get(i2).h());
                    this.f41406a.transform(matrix);
                    int alpha = this.f41408c.getAlpha();
                    this.f41408c.setAlpha((int) (this.p.c().get(i2).h().intValue() * 2.55f));
                    canvas.drawPath(this.f41406a, this.f41408c);
                    this.f41408c.setAlpha(alpha);
                }
            }
            d.a.a.c.a("Layer#restoreLayer");
            canvas.restore();
            d.a.a.c.c("Layer#restoreLayer");
            d.a.a.c.c("Layer#drawMask");
        }
    }

    public final void k() {
        if (this.s != null) {
            return;
        }
        if (this.r == null) {
            this.s = Collections.emptyList();
            return;
        }
        this.s = new ArrayList();
        for (a aVar = this.r; aVar != null; aVar = aVar.r) {
            this.s.add(aVar);
        }
    }

    public final void l(Canvas canvas) {
        d.a.a.c.a("Layer#clearLayer");
        RectF rectF = this.f41413h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f41412g);
        d.a.a.c.c("Layer#clearLayer");
    }

    public abstract void m(Canvas canvas, Matrix matrix, int i);

    public Layer o() {
        return this.o;
    }

    public boolean p() {
        d.a.a.q.b.g gVar = this.p;
        return (gVar == null || gVar.a().isEmpty()) ? false : true;
    }

    public boolean q() {
        return this.q != null;
    }

    public final void r(RectF rectF, Matrix matrix) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (p()) {
            int size = this.p.b().size();
            for (int i = 0; i < size; i++) {
                this.f41406a.set(this.p.a().get(i).h());
                this.f41406a.transform(matrix);
                int i2 = b.f41417b[this.p.b().get(i).a().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    return;
                }
                this.f41406a.computeBounds(this.k, false);
                if (i == 0) {
                    this.i.set(this.k);
                } else {
                    RectF rectF2 = this.i;
                    rectF2.set(Math.min(rectF2.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                }
            }
            rectF.set(Math.max(rectF.left, this.i.left), Math.max(rectF.top, this.i.top), Math.min(rectF.right, this.i.right), Math.min(rectF.bottom, this.i.bottom));
        }
    }

    public final void s(RectF rectF, Matrix matrix) {
        if (q() && this.o.f() != Layer.MatteType.Invert) {
            this.q.c(this.j, matrix);
            rectF.set(Math.max(rectF.left, this.j.left), Math.max(rectF.top, this.j.top), Math.min(rectF.right, this.j.right), Math.min(rectF.bottom, this.j.bottom));
        }
    }

    public final void t() {
        this.n.invalidateSelf();
    }

    public final void u(float f2) {
        this.n.l().k().a(this.o.g(), f2);
    }

    public void v(d.a.a.s.e eVar, int i, List<d.a.a.s.e> list, d.a.a.s.e eVar2) {
    }

    @SuppressLint({"WrongConstant"})
    public final void w(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, z ? 31 : 19);
        } else {
            canvas.saveLayer(rectF, paint);
        }
    }

    public void x(@Nullable a aVar) {
        this.q = aVar;
    }

    public void y(@Nullable a aVar) {
        this.r = aVar;
    }

    public void z(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.u.i(f2);
        if (this.p != null) {
            for (int i = 0; i < this.p.a().size(); i++) {
                this.p.a().get(i).l(f2);
            }
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        a aVar = this.q;
        if (aVar != null) {
            this.q.z(aVar.o.t() * f2);
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            this.t.get(i2).l(f2);
        }
    }
}
