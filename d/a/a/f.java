package d.a.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.a.w.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class f extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: f  reason: collision with root package name */
    public d.a.a.d f41537f;
    public final ArrayList<q> k;
    public final ValueAnimator.AnimatorUpdateListener l;
    @Nullable
    public ImageView.ScaleType m;
    @Nullable
    public d.a.a.t.b n;
    @Nullable
    public String o;
    @Nullable
    public d.a.a.b p;
    @Nullable
    public d.a.a.t.a q;
    @Nullable
    public d.a.a.a r;
    @Nullable
    public r s;
    public boolean t;
    @Nullable
    public d.a.a.u.k.b u;
    public int v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* renamed from: e  reason: collision with root package name */
    public final Matrix f41536e = new Matrix();

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.x.e f41538g = new d.a.a.x.e();

    /* renamed from: h  reason: collision with root package name */
    public float f41539h = 1.0f;
    public boolean i = true;
    public boolean j = false;

    /* loaded from: classes.dex */
    public class a implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41540a;

        public a(String str) {
            this.f41540a = str;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.f0(this.f41540a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41542a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41543b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f41544c;

        public b(String str, String str2, boolean z) {
            this.f41542a = str;
            this.f41543b = str2;
            this.f41544c = z;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.g0(this.f41542a, this.f41543b, this.f41544c);
        }
    }

    /* loaded from: classes.dex */
    public class c implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f41546a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f41547b;

        public c(int i, int i2) {
            this.f41546a = i;
            this.f41547b = i2;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.e0(this.f41546a, this.f41547b);
        }
    }

    /* loaded from: classes.dex */
    public class d implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f41549a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f41550b;

        public d(float f2, float f3) {
            this.f41549a = f2;
            this.f41550b = f3;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.h0(this.f41549a, this.f41550b);
        }
    }

    /* loaded from: classes.dex */
    public class e implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f41552a;

        public e(int i) {
            this.f41552a = i;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.Y(this.f41552a);
        }
    }

    /* renamed from: d.a.a.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0544f implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f41554a;

        public C0544f(float f2) {
            this.f41554a = f2;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.m0(this.f41554a);
        }
    }

    /* loaded from: classes.dex */
    public class g implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.a.u.d f41556a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f41557b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.a.y.c f41558c;

        public g(d.a.a.u.d dVar, Object obj, d.a.a.y.c cVar) {
            this.f41556a = dVar;
            this.f41557b = obj;
            this.f41558c = cVar;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.e(this.f41556a, this.f41557b, this.f41558c);
        }
    }

    /* loaded from: classes.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (f.this.u != null) {
                f.this.u.G(f.this.f41538g.i());
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements q {
        public i() {
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.N();
        }
    }

    /* loaded from: classes.dex */
    public class j implements q {
        public j() {
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.T();
        }
    }

    /* loaded from: classes.dex */
    public class k implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f41563a;

        public k(int i) {
            this.f41563a = i;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.i0(this.f41563a);
        }
    }

    /* loaded from: classes.dex */
    public class l implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f41565a;

        public l(float f2) {
            this.f41565a = f2;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.k0(this.f41565a);
        }
    }

    /* loaded from: classes.dex */
    public class m implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f41567a;

        public m(int i) {
            this.f41567a = i;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.b0(this.f41567a);
        }
    }

    /* loaded from: classes.dex */
    public class n implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f41569a;

        public n(float f2) {
            this.f41569a = f2;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.d0(this.f41569a);
        }
    }

    /* loaded from: classes.dex */
    public class o implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41571a;

        public o(String str) {
            this.f41571a = str;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.j0(this.f41571a);
        }
    }

    /* loaded from: classes.dex */
    public class p implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41573a;

        public p(String str) {
            this.f41573a = str;
        }

        @Override // d.a.a.f.q
        public void a(d.a.a.d dVar) {
            f.this.c0(this.f41573a);
        }
    }

    /* loaded from: classes.dex */
    public interface q {
        void a(d.a.a.d dVar);
    }

    public f() {
        new HashSet();
        this.k = new ArrayList<>();
        h hVar = new h();
        this.l = hVar;
        this.v = 255;
        this.y = true;
        this.z = false;
        this.f41538g.addUpdateListener(hVar);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float A() {
        return this.f41538g.i();
    }

    public int B() {
        return this.f41538g.getRepeatCount();
    }

    public int C() {
        return this.f41538g.getRepeatMode();
    }

    public float D() {
        return this.f41539h;
    }

    public float E() {
        return this.f41538g.n();
    }

    @Nullable
    public r F() {
        return this.s;
    }

    @Nullable
    public Typeface G(String str, String str2) {
        d.a.a.t.a r = r();
        if (r != null) {
            return r.b(str, str2);
        }
        return null;
    }

    public boolean H() {
        d.a.a.u.k.b bVar = this.u;
        return bVar != null && bVar.J();
    }

    public boolean I() {
        d.a.a.u.k.b bVar = this.u;
        return bVar != null && bVar.K();
    }

    public boolean J() {
        d.a.a.x.e eVar = this.f41538g;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    public boolean K() {
        return this.x;
    }

    public boolean L() {
        return this.t;
    }

    public void M() {
        this.k.clear();
        this.f41538g.p();
    }

    @MainThread
    public void N() {
        if (this.u == null) {
            this.k.add(new i());
            return;
        }
        if (this.i || B() == 0) {
            this.f41538g.q();
        }
        if (this.i) {
            return;
        }
        Y((int) (E() < 0.0f ? y() : w()));
        this.f41538g.h();
    }

    public void O() {
        this.f41538g.removeAllListeners();
    }

    public void P() {
        this.f41538g.removeAllUpdateListeners();
        this.f41538g.addUpdateListener(this.l);
    }

    public void Q(Animator.AnimatorListener animatorListener) {
        this.f41538g.removeListener(animatorListener);
    }

    public void R(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f41538g.removeUpdateListener(animatorUpdateListener);
    }

    public List<d.a.a.u.d> S(d.a.a.u.d dVar) {
        if (this.u == null) {
            d.a.a.x.d.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.u.d(dVar, 0, arrayList, new d.a.a.u.d(new String[0]));
        return arrayList;
    }

    @MainThread
    public void T() {
        if (this.u == null) {
            this.k.add(new j());
            return;
        }
        if (this.i || B() == 0) {
            this.f41538g.u();
        }
        if (this.i) {
            return;
        }
        Y((int) (E() < 0.0f ? y() : w()));
        this.f41538g.h();
    }

    public void U() {
        this.f41538g.v();
    }

    public void V(boolean z) {
        this.x = z;
    }

    public boolean W(d.a.a.d dVar) {
        if (this.f41537f == dVar) {
            return false;
        }
        this.z = false;
        h();
        this.f41537f = dVar;
        f();
        this.f41538g.w(dVar);
        m0(this.f41538g.getAnimatedFraction());
        q0(this.f41539h);
        w0();
        Iterator it = new ArrayList(this.k).iterator();
        while (it.hasNext()) {
            ((q) it.next()).a(dVar);
            it.remove();
        }
        this.k.clear();
        dVar.u(this.w);
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
            return true;
        }
        return true;
    }

    public void X(d.a.a.a aVar) {
        this.r = aVar;
        d.a.a.t.a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.c(aVar);
        }
    }

    public void Y(int i2) {
        if (this.f41537f == null) {
            this.k.add(new e(i2));
        } else {
            this.f41538g.x(i2);
        }
    }

    public void Z(d.a.a.b bVar) {
        this.p = bVar;
        d.a.a.t.b bVar2 = this.n;
        if (bVar2 != null) {
            bVar2.d(bVar);
        }
    }

    public void a0(@Nullable String str) {
        this.o = str;
    }

    public void b0(int i2) {
        if (this.f41537f == null) {
            this.k.add(new m(i2));
        } else {
            this.f41538g.y(i2 + 0.99f);
        }
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.f41538g.addListener(animatorListener);
    }

    public void c0(String str) {
        d.a.a.d dVar = this.f41537f;
        if (dVar == null) {
            this.k.add(new p(str));
            return;
        }
        d.a.a.u.g k2 = dVar.k(str);
        if (k2 != null) {
            b0((int) (k2.f41744b + k2.f41745c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void d(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f41538g.addUpdateListener(animatorUpdateListener);
    }

    public void d0(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        d.a.a.d dVar = this.f41537f;
        if (dVar == null) {
            this.k.add(new n(f2));
        } else {
            b0((int) d.a.a.x.g.k(dVar.o(), this.f41537f.f(), f2));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.z = false;
        d.a.a.c.a("Drawable#draw");
        if (this.j) {
            try {
                j(canvas);
            } catch (Throwable th) {
                d.a.a.x.d.b("Lottie crashed in draw!", th);
            }
        } else {
            j(canvas);
        }
        d.a.a.c.b("Drawable#draw");
    }

    public <T> void e(d.a.a.u.d dVar, T t, d.a.a.y.c<T> cVar) {
        d.a.a.u.k.b bVar = this.u;
        if (bVar == null) {
            this.k.add(new g(dVar, t, cVar));
            return;
        }
        boolean z = true;
        if (dVar == d.a.a.u.d.f41737c) {
            bVar.c(t, cVar);
        } else if (dVar.d() != null) {
            dVar.d().c(t, cVar);
        } else {
            List<d.a.a.u.d> S = S(dVar);
            for (int i2 = 0; i2 < S.size(); i2++) {
                S.get(i2).d().c(t, cVar);
            }
            z = true ^ S.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == d.a.a.k.A) {
                m0(A());
            }
        }
    }

    public void e0(int i2, int i3) {
        if (this.f41537f == null) {
            this.k.add(new c(i2, i3));
        } else {
            this.f41538g.z(i2, i3 + 0.99f);
        }
    }

    public final void f() {
        this.u = new d.a.a.u.k.b(this, s.a(this.f41537f), this.f41537f.j(), this.f41537f);
    }

    public void f0(String str) {
        d.a.a.d dVar = this.f41537f;
        if (dVar == null) {
            this.k.add(new a(str));
            return;
        }
        d.a.a.u.g k2 = dVar.k(str);
        if (k2 != null) {
            int i2 = (int) k2.f41744b;
            e0(i2, ((int) k2.f41745c) + i2);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void g() {
        this.k.clear();
        this.f41538g.cancel();
    }

    public void g0(String str, String str2, boolean z) {
        d.a.a.d dVar = this.f41537f;
        if (dVar == null) {
            this.k.add(new b(str, str2, z));
            return;
        }
        d.a.a.u.g k2 = dVar.k(str);
        if (k2 != null) {
            int i2 = (int) k2.f41744b;
            d.a.a.u.g k3 = this.f41537f.k(str2);
            if (str2 != null) {
                e0(i2, (int) (k3.f41744b + (z ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.v;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        d.a.a.d dVar = this.f41537f;
        if (dVar == null) {
            return -1;
        }
        return (int) (dVar.b().height() * D());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        d.a.a.d dVar = this.f41537f;
        if (dVar == null) {
            return -1;
        }
        return (int) (dVar.b().width() * D());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h() {
        if (this.f41538g.isRunning()) {
            this.f41538g.cancel();
        }
        this.f41537f = null;
        this.u = null;
        this.n = null;
        this.f41538g.g();
        invalidateSelf();
    }

    public void h0(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        d.a.a.d dVar = this.f41537f;
        if (dVar == null) {
            this.k.add(new d(f2, f3));
        } else {
            e0((int) d.a.a.x.g.k(dVar.o(), this.f41537f.f(), f2), (int) d.a.a.x.g.k(this.f41537f.o(), this.f41537f.f(), f3));
        }
    }

    public void i() {
        this.y = false;
    }

    public void i0(int i2) {
        if (this.f41537f == null) {
            this.k.add(new k(i2));
        } else {
            this.f41538g.A(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.z) {
            return;
        }
        this.z = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return J();
    }

    public final void j(@NonNull Canvas canvas) {
        if (ImageView.ScaleType.FIT_XY == this.m) {
            k(canvas);
        } else {
            l(canvas);
        }
    }

    public void j0(String str) {
        d.a.a.d dVar = this.f41537f;
        if (dVar == null) {
            this.k.add(new o(str));
            return;
        }
        d.a.a.u.g k2 = dVar.k(str);
        if (k2 != null) {
            i0((int) k2.f41744b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public final void k(Canvas canvas) {
        float f2;
        if (this.u == null) {
            return;
        }
        int i2 = -1;
        Rect bounds = getBounds();
        float width = bounds.width() / this.f41537f.b().width();
        float height = bounds.height() / this.f41537f.b().height();
        if (this.y) {
            float min = Math.min(width, height);
            if (min < 1.0f) {
                f2 = 1.0f / min;
                width /= f2;
                height /= f2;
            } else {
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                i2 = canvas.save();
                float width2 = bounds.width() / 2.0f;
                float height2 = bounds.height() / 2.0f;
                float f3 = width2 * min;
                float f4 = min * height2;
                canvas.translate(width2 - f3, height2 - f4);
                canvas.scale(f2, f2, f3, f4);
            }
        }
        this.f41536e.reset();
        this.f41536e.preScale(width, height);
        this.u.g(canvas, this.f41536e, this.v);
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    public void k0(float f2) {
        d.a.a.d dVar = this.f41537f;
        if (dVar == null) {
            this.k.add(new l(f2));
        } else {
            i0((int) d.a.a.x.g.k(dVar.o(), this.f41537f.f(), f2));
        }
    }

    public final void l(Canvas canvas) {
        float f2;
        if (this.u == null) {
            return;
        }
        float f3 = this.f41539h;
        float x = x(canvas);
        if (f3 > x) {
            f2 = this.f41539h / x;
        } else {
            x = f3;
            f2 = 1.0f;
        }
        int i2 = -1;
        if (f2 > 1.0f) {
            i2 = canvas.save();
            float width = this.f41537f.b().width() / 2.0f;
            float height = this.f41537f.b().height() / 2.0f;
            float f4 = width * x;
            float f5 = height * x;
            canvas.translate((D() * width) - f4, (D() * height) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.f41536e.reset();
        this.f41536e.preScale(x, x);
        this.u.g(canvas, this.f41536e, this.v);
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    public void l0(boolean z) {
        this.w = z;
        d.a.a.d dVar = this.f41537f;
        if (dVar != null) {
            dVar.u(z);
        }
    }

    public void m(boolean z) {
        if (this.t == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            d.a.a.x.d.c("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.t = z;
        if (this.f41537f != null) {
            f();
        }
    }

    public void m0(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f41537f == null) {
            this.k.add(new C0544f(f2));
            return;
        }
        d.a.a.c.a("Drawable#setProgress");
        this.f41538g.x(d.a.a.x.g.k(this.f41537f.o(), this.f41537f.f(), f2));
        d.a.a.c.b("Drawable#setProgress");
    }

    public boolean n() {
        return this.t;
    }

    public void n0(int i2) {
        this.f41538g.setRepeatCount(i2);
    }

    @MainThread
    public void o() {
        this.k.clear();
        this.f41538g.h();
    }

    public void o0(int i2) {
        this.f41538g.setRepeatMode(i2);
    }

    public d.a.a.d p() {
        return this.f41537f;
    }

    public void p0(boolean z) {
        this.j = z;
    }

    @Nullable
    public final Context q() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void q0(float f2) {
        this.f41539h = f2;
        w0();
    }

    public final d.a.a.t.a r() {
        if (getCallback() == null) {
            return null;
        }
        if (this.q == null) {
            this.q = new d.a.a.t.a(getCallback(), this.r);
        }
        return this.q;
    }

    public void r0(ImageView.ScaleType scaleType) {
        this.m = scaleType;
    }

    public int s() {
        return (int) this.f41538g.j();
    }

    public void s0(float f2) {
        this.f41538g.B(f2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.v = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        d.a.a.x.d.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || ((View) callback).isInEditMode()) {
            return;
        }
        N();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        o();
    }

    @Nullable
    public Bitmap t(String str) {
        d.a.a.t.b u = u();
        if (u != null) {
            return u.a(str);
        }
        return null;
    }

    public void t0(Boolean bool) {
        this.i = bool.booleanValue();
    }

    public final d.a.a.t.b u() {
        if (getCallback() == null) {
            return null;
        }
        d.a.a.t.b bVar = this.n;
        if (bVar != null && !bVar.b(q())) {
            this.n = null;
        }
        if (this.n == null) {
            this.n = new d.a.a.t.b(getCallback(), this.o, this.p, this.f41537f.i());
        }
        return this.n;
    }

    public void u0(r rVar) {
        this.s = rVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    @Nullable
    public String v() {
        return this.o;
    }

    @Nullable
    public Bitmap v0(String str, @Nullable Bitmap bitmap) {
        d.a.a.t.b u = u();
        if (u == null) {
            d.a.a.x.d.c("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap e2 = u.e(str, bitmap);
        invalidateSelf();
        return e2;
    }

    public float w() {
        return this.f41538g.l();
    }

    public final void w0() {
        if (this.f41537f == null) {
            return;
        }
        float D = D();
        setBounds(0, 0, (int) (this.f41537f.b().width() * D), (int) (this.f41537f.b().height() * D));
    }

    public final float x(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f41537f.b().width(), canvas.getHeight() / this.f41537f.b().height());
    }

    public boolean x0() {
        return this.s == null && this.f41537f.c().size() > 0;
    }

    public float y() {
        return this.f41538g.m();
    }

    @Nullable
    public d.a.a.n z() {
        d.a.a.d dVar = this.f41537f;
        if (dVar != null) {
            return dVar.m();
        }
        return null;
    }
}
