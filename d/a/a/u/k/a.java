package d.a.a.u.k;

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
import d.a.a.s.c.a;
import d.a.a.s.c.o;
import d.a.a.u.j.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a implements d.a.a.s.b.e, a.b, d.a.a.u.e {
    public final String l;
    public final d.a.a.f n;
    public final Layer o;
    @Nullable
    public d.a.a.s.c.g p;
    @Nullable
    public d.a.a.s.c.c q;
    @Nullable
    public a r;
    @Nullable
    public a s;
    public List<a> t;
    public final o v;

    /* renamed from: a  reason: collision with root package name */
    public final Path f41813a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final Matrix f41814b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    public final Paint f41815c = new d.a.a.s.a(1);

    /* renamed from: d  reason: collision with root package name */
    public final Paint f41816d = new d.a.a.s.a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: e  reason: collision with root package name */
    public final Paint f41817e = new d.a.a.s.a(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: f  reason: collision with root package name */
    public final Paint f41818f = new d.a.a.s.a(1);

    /* renamed from: g  reason: collision with root package name */
    public final Paint f41819g = new d.a.a.s.a(PorterDuff.Mode.CLEAR);

    /* renamed from: h  reason: collision with root package name */
    public final RectF f41820h = new RectF();
    public final RectF i = new RectF();
    public final RectF j = new RectF();
    public final RectF k = new RectF();
    public final Matrix m = new Matrix();
    public final List<d.a.a.s.c.a<?, ?>> u = new ArrayList();
    public boolean w = true;

    /* renamed from: d.a.a.u.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0547a implements a.b {
        public C0547a() {
        }

        @Override // d.a.a.s.c.a.b
        public void a() {
            a aVar = a.this;
            aVar.H(aVar.q.o() == 1.0f);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41822a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f41823b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f41823b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41823b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41823b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41823b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f41822a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41822a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41822a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41822a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41822a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41822a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41822a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public a(d.a.a.f fVar, Layer layer) {
        this.n = fVar;
        this.o = layer;
        this.l = layer.g() + "#draw";
        if (layer.f() == Layer.MatteType.INVERT) {
            this.f41818f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.f41818f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        o b2 = layer.u().b();
        this.v = b2;
        b2.b(this);
        if (layer.e() != null && !layer.e().isEmpty()) {
            d.a.a.s.c.g gVar = new d.a.a.s.c.g(layer.e());
            this.p = gVar;
            for (d.a.a.s.c.a<h, Path> aVar : gVar.a()) {
                aVar.a(this);
            }
            for (d.a.a.s.c.a<Integer, Integer> aVar2 : this.p.c()) {
                i(aVar2);
                aVar2.a(this);
            }
        }
        I();
    }

    @Nullable
    public static a u(Layer layer, d.a.a.f fVar, d.a.a.d dVar) {
        switch (b.f41822a[layer.d().ordinal()]) {
            case 1:
                return new e(fVar, layer);
            case 2:
                return new d.a.a.u.k.b(fVar, layer, dVar.n(layer.k()), dVar);
            case 3:
                return new f(fVar, layer);
            case 4:
                return new c(fVar, layer);
            case 5:
                return new d(fVar, layer);
            case 6:
                return new g(fVar, layer);
            default:
                d.a.a.x.d.c("Unknown layer type " + layer.d());
                return null;
        }
    }

    public final void A() {
        this.n.invalidateSelf();
    }

    public final void B(float f2) {
        this.n.p().m().a(this.o.g(), f2);
    }

    public void C(d.a.a.s.c.a<?, ?> aVar) {
        this.u.remove(aVar);
    }

    public void D(d.a.a.u.d dVar, int i, List<d.a.a.u.d> list, d.a.a.u.d dVar2) {
    }

    public void E(@Nullable a aVar) {
        this.r = aVar;
    }

    public void F(@Nullable a aVar) {
        this.s = aVar;
    }

    public void G(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.v.j(f2);
        if (this.p != null) {
            for (int i = 0; i < this.p.a().size(); i++) {
                this.p.a().get(i).l(f2);
            }
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        d.a.a.s.c.c cVar = this.q;
        if (cVar != null) {
            cVar.l(f2 / this.o.t());
        }
        a aVar = this.r;
        if (aVar != null) {
            this.r.G(aVar.o.t() * f2);
        }
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            this.u.get(i2).l(f2);
        }
    }

    public final void H(boolean z) {
        if (z != this.w) {
            this.w = z;
            A();
        }
    }

    public final void I() {
        if (!this.o.c().isEmpty()) {
            d.a.a.s.c.c cVar = new d.a.a.s.c.c(this.o.c());
            this.q = cVar;
            cVar.k();
            this.q.a(new C0547a());
            H(this.q.h().floatValue() == 1.0f);
            i(this.q);
            return;
        }
        H(true);
    }

    @Override // d.a.a.s.c.a.b
    public void a() {
        A();
    }

    @Override // d.a.a.s.b.c
    public void b(List<d.a.a.s.b.c> list, List<d.a.a.s.b.c> list2) {
    }

    @Override // d.a.a.u.e
    @CallSuper
    public <T> void c(T t, @Nullable d.a.a.y.c<T> cVar) {
        this.v.c(t, cVar);
    }

    @Override // d.a.a.u.e
    public void d(d.a.a.u.d dVar, int i, List<d.a.a.u.d> list, d.a.a.u.d dVar2) {
        if (dVar.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.a(getName());
                if (dVar.c(getName(), i)) {
                    list.add(dVar2.i(this));
                }
            }
            if (dVar.h(getName(), i)) {
                D(dVar, i + dVar.e(getName(), i), list, dVar2);
            }
        }
    }

    @Override // d.a.a.s.b.e
    @CallSuper
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.f41820h.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.m.set(matrix);
        if (z) {
            List<a> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.m.preConcat(this.t.get(size).v.f());
                }
            } else {
                a aVar = this.s;
                if (aVar != null) {
                    this.m.preConcat(aVar.v.f());
                }
            }
        }
        this.m.preConcat(this.v.f());
    }

    @Override // d.a.a.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        d.a.a.c.a(this.l);
        if (this.w && !this.o.v()) {
            r();
            d.a.a.c.a("Layer#parentMatrix");
            this.f41814b.reset();
            this.f41814b.set(matrix);
            for (int size = this.t.size() - 1; size >= 0; size--) {
                this.f41814b.preConcat(this.t.get(size).v.f());
            }
            d.a.a.c.b("Layer#parentMatrix");
            int intValue = (int) ((((i / 255.0f) * (this.v.h() == null ? 100 : this.v.h().h().intValue())) / 100.0f) * 255.0f);
            if (!x() && !w()) {
                this.f41814b.preConcat(this.v.f());
                d.a.a.c.a("Layer#drawLayer");
                t(canvas, this.f41814b, intValue);
                d.a.a.c.b("Layer#drawLayer");
                B(d.a.a.c.b(this.l));
                return;
            }
            d.a.a.c.a("Layer#computeBounds");
            e(this.f41820h, this.f41814b, false);
            z(this.f41820h, matrix);
            this.f41814b.preConcat(this.v.f());
            y(this.f41820h, this.f41814b);
            if (!this.f41820h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.f41820h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            d.a.a.c.b("Layer#computeBounds");
            if (!this.f41820h.isEmpty()) {
                d.a.a.c.a("Layer#saveLayer");
                this.f41815c.setAlpha(255);
                d.a.a.x.h.m(canvas, this.f41820h, this.f41815c);
                d.a.a.c.b("Layer#saveLayer");
                s(canvas);
                d.a.a.c.a("Layer#drawLayer");
                t(canvas, this.f41814b, intValue);
                d.a.a.c.b("Layer#drawLayer");
                if (w()) {
                    o(canvas, this.f41814b);
                }
                if (x()) {
                    d.a.a.c.a("Layer#drawMatte");
                    d.a.a.c.a("Layer#saveLayer");
                    d.a.a.x.h.n(canvas, this.f41820h, this.f41818f, 19);
                    d.a.a.c.b("Layer#saveLayer");
                    s(canvas);
                    this.r.g(canvas, matrix, intValue);
                    d.a.a.c.a("Layer#restoreLayer");
                    canvas.restore();
                    d.a.a.c.b("Layer#restoreLayer");
                    d.a.a.c.b("Layer#drawMatte");
                }
                d.a.a.c.a("Layer#restoreLayer");
                canvas.restore();
                d.a.a.c.b("Layer#restoreLayer");
            }
            B(d.a.a.c.b(this.l));
            return;
        }
        d.a.a.c.b(this.l);
    }

    @Override // d.a.a.s.b.c
    public String getName() {
        return this.o.g();
    }

    public void i(@Nullable d.a.a.s.c.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.u.add(aVar);
    }

    public final void j(Canvas canvas, Matrix matrix, Mask mask, d.a.a.s.c.a<h, Path> aVar, d.a.a.s.c.a<Integer, Integer> aVar2) {
        this.f41813a.set(aVar.h());
        this.f41813a.transform(matrix);
        this.f41815c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f41813a, this.f41815c);
    }

    public final void k(Canvas canvas, Matrix matrix, Mask mask, d.a.a.s.c.a<h, Path> aVar, d.a.a.s.c.a<Integer, Integer> aVar2) {
        d.a.a.x.h.m(canvas, this.f41820h, this.f41816d);
        this.f41813a.set(aVar.h());
        this.f41813a.transform(matrix);
        this.f41815c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f41813a, this.f41815c);
        canvas.restore();
    }

    public final void l(Canvas canvas, Matrix matrix, Mask mask, d.a.a.s.c.a<h, Path> aVar, d.a.a.s.c.a<Integer, Integer> aVar2) {
        d.a.a.x.h.m(canvas, this.f41820h, this.f41815c);
        canvas.drawRect(this.f41820h, this.f41815c);
        this.f41813a.set(aVar.h());
        this.f41813a.transform(matrix);
        this.f41815c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f41813a, this.f41817e);
        canvas.restore();
    }

    public final void m(Canvas canvas, Matrix matrix, Mask mask, d.a.a.s.c.a<h, Path> aVar, d.a.a.s.c.a<Integer, Integer> aVar2) {
        d.a.a.x.h.m(canvas, this.f41820h, this.f41816d);
        canvas.drawRect(this.f41820h, this.f41815c);
        this.f41817e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.f41813a.set(aVar.h());
        this.f41813a.transform(matrix);
        canvas.drawPath(this.f41813a, this.f41817e);
        canvas.restore();
    }

    public final void n(Canvas canvas, Matrix matrix, Mask mask, d.a.a.s.c.a<h, Path> aVar, d.a.a.s.c.a<Integer, Integer> aVar2) {
        d.a.a.x.h.m(canvas, this.f41820h, this.f41817e);
        canvas.drawRect(this.f41820h, this.f41815c);
        this.f41817e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.f41813a.set(aVar.h());
        this.f41813a.transform(matrix);
        canvas.drawPath(this.f41813a, this.f41817e);
        canvas.restore();
    }

    public final void o(Canvas canvas, Matrix matrix) {
        d.a.a.c.a("Layer#saveLayer");
        d.a.a.x.h.n(canvas, this.f41820h, this.f41816d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        d.a.a.c.b("Layer#saveLayer");
        for (int i = 0; i < this.p.b().size(); i++) {
            Mask mask = this.p.b().get(i);
            d.a.a.s.c.a<h, Path> aVar = this.p.a().get(i);
            d.a.a.s.c.a<Integer, Integer> aVar2 = this.p.c().get(i);
            int i2 = b.f41823b[mask.a().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.f41815c.setColor(-16777216);
                        this.f41815c.setAlpha(255);
                        canvas.drawRect(this.f41820h, this.f41815c);
                    }
                    if (mask.d()) {
                        n(canvas, matrix, mask, aVar, aVar2);
                    } else {
                        p(canvas, matrix, mask, aVar, aVar2);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (mask.d()) {
                            l(canvas, matrix, mask, aVar, aVar2);
                        } else {
                            j(canvas, matrix, mask, aVar, aVar2);
                        }
                    }
                } else if (mask.d()) {
                    m(canvas, matrix, mask, aVar, aVar2);
                } else {
                    k(canvas, matrix, mask, aVar, aVar2);
                }
            } else if (q()) {
                this.f41815c.setAlpha(255);
                canvas.drawRect(this.f41820h, this.f41815c);
            }
        }
        d.a.a.c.a("Layer#restoreLayer");
        canvas.restore();
        d.a.a.c.b("Layer#restoreLayer");
    }

    public final void p(Canvas canvas, Matrix matrix, Mask mask, d.a.a.s.c.a<h, Path> aVar, d.a.a.s.c.a<Integer, Integer> aVar2) {
        this.f41813a.set(aVar.h());
        this.f41813a.transform(matrix);
        canvas.drawPath(this.f41813a, this.f41817e);
    }

    public final boolean q() {
        if (this.p.a().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.p.b().size(); i++) {
            if (this.p.b().get(i).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void r() {
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

    public final void s(Canvas canvas) {
        d.a.a.c.a("Layer#clearLayer");
        RectF rectF = this.f41820h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f41819g);
        d.a.a.c.b("Layer#clearLayer");
    }

    public abstract void t(Canvas canvas, Matrix matrix, int i);

    public Layer v() {
        return this.o;
    }

    public boolean w() {
        d.a.a.s.c.g gVar = this.p;
        return (gVar == null || gVar.a().isEmpty()) ? false : true;
    }

    public boolean x() {
        return this.r != null;
    }

    public final void y(RectF rectF, Matrix matrix) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (w()) {
            int size = this.p.b().size();
            for (int i = 0; i < size; i++) {
                Mask mask = this.p.b().get(i);
                this.f41813a.set(this.p.a().get(i).h());
                this.f41813a.transform(matrix);
                int i2 = b.f41823b[mask.a().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    return;
                }
                if ((i2 == 3 || i2 == 4) && mask.d()) {
                    return;
                }
                this.f41813a.computeBounds(this.k, false);
                if (i == 0) {
                    this.i.set(this.k);
                } else {
                    RectF rectF2 = this.i;
                    rectF2.set(Math.min(rectF2.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                }
            }
            if (rectF.intersect(this.i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void z(RectF rectF, Matrix matrix) {
        if (x() && this.o.f() != Layer.MatteType.INVERT) {
            this.j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.e(this.j, matrix, true);
            if (rectF.intersect(this.j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }
}
