package d.a.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import d.a.a.u.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class f extends Drawable implements Drawable.Callback, Animatable {
    public static final String t = f.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    public d.a.a.d f41147f;
    public final ArrayList<m> i;
    @Nullable
    public d.a.a.r.b j;
    @Nullable
    public String k;
    @Nullable
    public d.a.a.b l;
    @Nullable
    public d.a.a.r.a m;
    @Nullable
    public d.a.a.a n;
    @Nullable
    public p o;
    public boolean p;
    @Nullable
    public d.a.a.s.k.b q;
    public int r;
    public boolean s;

    /* renamed from: e  reason: collision with root package name */
    public final Matrix f41146e = new Matrix();

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.v.c f41148g = new d.a.a.v.c();

    /* renamed from: h  reason: collision with root package name */
    public float f41149h = 1.0f;

    /* loaded from: classes.dex */
    public class a implements m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f41150a;

        public a(int i) {
            this.f41150a = i;
        }

        @Override // d.a.a.f.m
        public void a(d.a.a.d dVar) {
            f.this.T(this.f41150a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f41152a;

        public b(float f2) {
            this.f41152a = f2;
        }

        @Override // d.a.a.f.m
        public void a(d.a.a.d dVar) {
            f.this.d0(this.f41152a);
        }
    }

    /* loaded from: classes.dex */
    public class c implements m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.a.s.e f41154a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f41155b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.a.w.c f41156c;

        public c(d.a.a.s.e eVar, Object obj, d.a.a.w.c cVar) {
            this.f41154a = eVar;
            this.f41155b = obj;
            this.f41156c = cVar;
        }

        @Override // d.a.a.f.m
        public void a(d.a.a.d dVar) {
            f.this.e(this.f41154a, this.f41155b, this.f41156c);
        }
    }

    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (f.this.q != null) {
                f.this.q.z(f.this.f41148g.i());
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements m {
        public e() {
        }

        @Override // d.a.a.f.m
        public void a(d.a.a.d dVar) {
            f.this.I();
        }
    }

    /* renamed from: d.a.a.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0526f implements m {
        public C0526f() {
        }

        @Override // d.a.a.f.m
        public void a(d.a.a.d dVar) {
            f.this.P();
        }
    }

    /* loaded from: classes.dex */
    public class g implements m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f41161a;

        public g(int i) {
            this.f41161a = i;
        }

        @Override // d.a.a.f.m
        public void a(d.a.a.d dVar) {
            f.this.a0(this.f41161a);
        }
    }

    /* loaded from: classes.dex */
    public class h implements m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f41163a;

        public h(float f2) {
            this.f41163a = f2;
        }

        @Override // d.a.a.f.m
        public void a(d.a.a.d dVar) {
            f.this.b0(this.f41163a);
        }
    }

    /* loaded from: classes.dex */
    public class i implements m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f41165a;

        public i(int i) {
            this.f41165a = i;
        }

        @Override // d.a.a.f.m
        public void a(d.a.a.d dVar) {
            f.this.W(this.f41165a);
        }
    }

    /* loaded from: classes.dex */
    public class j implements m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f41167a;

        public j(float f2) {
            this.f41167a = f2;
        }

        @Override // d.a.a.f.m
        public void a(d.a.a.d dVar) {
            f.this.X(this.f41167a);
        }
    }

    /* loaded from: classes.dex */
    public class k implements m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f41169a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f41170b;

        public k(int i, int i2) {
            this.f41169a = i;
            this.f41170b = i2;
        }

        @Override // d.a.a.f.m
        public void a(d.a.a.d dVar) {
            f.this.Y(this.f41169a, this.f41170b);
        }
    }

    /* loaded from: classes.dex */
    public class l implements m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f41172a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f41173b;

        public l(float f2, float f3) {
            this.f41172a = f2;
            this.f41173b = f3;
        }

        @Override // d.a.a.f.m
        public void a(d.a.a.d dVar) {
            f.this.Z(this.f41172a, this.f41173b);
        }
    }

    /* loaded from: classes.dex */
    public interface m {
        void a(d.a.a.d dVar);
    }

    public f() {
        new HashSet();
        this.i = new ArrayList<>();
        this.r = 255;
        this.f41148g.addUpdateListener(new d());
    }

    public float A() {
        return this.f41148g.n();
    }

    @Nullable
    public p B() {
        return this.o;
    }

    @Nullable
    public Typeface C(String str, String str2) {
        d.a.a.r.a n = n();
        if (n != null) {
            return n.b(str, str2);
        }
        return null;
    }

    public boolean D() {
        d.a.a.s.k.b bVar = this.q;
        return bVar != null && bVar.C();
    }

    public boolean E() {
        d.a.a.s.k.b bVar = this.q;
        return bVar != null && bVar.D();
    }

    public boolean F() {
        return this.f41148g.isRunning();
    }

    public boolean G() {
        return this.p;
    }

    public void H() {
        this.i.clear();
        this.f41148g.p();
    }

    @MainThread
    public void I() {
        if (this.q == null) {
            this.i.add(new e());
        } else {
            this.f41148g.q();
        }
    }

    public void J() {
        d.a.a.r.b bVar = this.j;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void K() {
        this.f41148g.removeAllListeners();
    }

    public void L() {
        this.f41148g.removeAllUpdateListeners();
    }

    public void M(Animator.AnimatorListener animatorListener) {
        this.f41148g.removeListener(animatorListener);
    }

    public void N(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f41148g.removeUpdateListener(animatorUpdateListener);
    }

    public List<d.a.a.s.e> O(d.a.a.s.e eVar) {
        if (this.q == null) {
            Log.w("LOTTIE", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.q.e(eVar, 0, arrayList, new d.a.a.s.e(new String[0]));
        return arrayList;
    }

    @MainThread
    public void P() {
        if (this.q == null) {
            this.i.add(new C0526f());
        } else {
            this.f41148g.u();
        }
    }

    public void Q() {
        this.f41148g.v();
    }

    public boolean R(d.a.a.d dVar) {
        if (this.f41147f == dVar) {
            return false;
        }
        h();
        this.f41147f = dVar;
        f();
        this.f41148g.w(dVar);
        d0(this.f41148g.getAnimatedFraction());
        g0(this.f41149h);
        k0();
        Iterator it = new ArrayList(this.i).iterator();
        while (it.hasNext()) {
            ((m) it.next()).a(dVar);
            it.remove();
        }
        this.i.clear();
        dVar.p(this.s);
        return true;
    }

    public void S(d.a.a.a aVar) {
        this.n = aVar;
        d.a.a.r.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.c(aVar);
        }
    }

    public void T(int i2) {
        if (this.f41147f == null) {
            this.i.add(new a(i2));
        } else {
            this.f41148g.x(i2);
        }
    }

    public void U(d.a.a.b bVar) {
        this.l = bVar;
        d.a.a.r.b bVar2 = this.j;
        if (bVar2 != null) {
            bVar2.e(bVar);
        }
    }

    public void V(@Nullable String str) {
        this.k = str;
    }

    public void W(int i2) {
        if (this.f41147f == null) {
            this.i.add(new i(i2));
        } else {
            this.f41148g.y(i2);
        }
    }

    public void X(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        d.a.a.d dVar = this.f41147f;
        if (dVar == null) {
            this.i.add(new j(f2));
        } else {
            W((int) d.a.a.v.e.j(dVar.m(), this.f41147f.f(), f2));
        }
    }

    public void Y(int i2, int i3) {
        if (this.f41147f == null) {
            this.i.add(new k(i2, i3));
        } else {
            this.f41148g.z(i2, i3);
        }
    }

    public void Z(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        d.a.a.d dVar = this.f41147f;
        if (dVar == null) {
            this.i.add(new l(f2, f3));
        } else {
            Y((int) d.a.a.v.e.j(dVar.m(), this.f41147f.f(), f2), (int) d.a.a.v.e.j(this.f41147f.m(), this.f41147f.f(), f3));
        }
    }

    public void a0(int i2) {
        if (this.f41147f == null) {
            this.i.add(new g(i2));
        } else {
            this.f41148g.A(i2);
        }
    }

    public void b0(float f2) {
        d.a.a.d dVar = this.f41147f;
        if (dVar == null) {
            this.i.add(new h(f2));
        } else {
            a0((int) d.a.a.v.e.j(dVar.m(), this.f41147f.f(), f2));
        }
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.f41148g.addListener(animatorListener);
    }

    public void c0(boolean z) {
        this.s = z;
        d.a.a.d dVar = this.f41147f;
        if (dVar != null) {
            dVar.p(z);
        }
    }

    public void d(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f41148g.addUpdateListener(animatorUpdateListener);
    }

    public void d0(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        d.a.a.d dVar = this.f41147f;
        if (dVar == null) {
            this.i.add(new b(f2));
        } else {
            T((int) d.a.a.v.e.j(dVar.m(), this.f41147f.f(), f2));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        float f2;
        d.a.a.c.a("Drawable#draw");
        if (this.q == null) {
            return;
        }
        float f3 = this.f41149h;
        float t2 = t(canvas);
        if (f3 > t2) {
            f2 = this.f41149h / t2;
        } else {
            t2 = f3;
            f2 = 1.0f;
        }
        int i2 = -1;
        if (f2 > 1.0f) {
            i2 = canvas.save();
            float width = this.f41147f.b().width() / 2.0f;
            float height = this.f41147f.b().height() / 2.0f;
            float f4 = width * t2;
            float f5 = height * t2;
            canvas.translate((z() * width) - f4, (z() * height) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.f41146e.reset();
        this.f41146e.preScale(t2, t2);
        this.q.g(canvas, this.f41146e, this.r);
        d.a.a.c.c("Drawable#draw");
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    public <T> void e(d.a.a.s.e eVar, T t2, d.a.a.w.c<T> cVar) {
        if (this.q == null) {
            this.i.add(new c(eVar, t2, cVar));
            return;
        }
        boolean z = true;
        if (eVar.d() != null) {
            eVar.d().d(t2, cVar);
        } else {
            List<d.a.a.s.e> O = O(eVar);
            for (int i2 = 0; i2 < O.size(); i2++) {
                O.get(i2).d().d(t2, cVar);
            }
            z = true ^ O.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t2 == d.a.a.j.w) {
                d0(w());
            }
        }
    }

    public void e0(int i2) {
        this.f41148g.setRepeatCount(i2);
    }

    public final void f() {
        this.q = new d.a.a.s.k.b(this, s.b(this.f41147f), this.f41147f.j(), this.f41147f);
    }

    public void f0(int i2) {
        this.f41148g.setRepeatMode(i2);
    }

    public void g() {
        this.i.clear();
        this.f41148g.cancel();
    }

    public void g0(float f2) {
        this.f41149h = f2;
        k0();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        d.a.a.d dVar = this.f41147f;
        if (dVar == null) {
            return -1;
        }
        return (int) (dVar.b().height() * z());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        d.a.a.d dVar = this.f41147f;
        if (dVar == null) {
            return -1;
        }
        return (int) (dVar.b().width() * z());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h() {
        J();
        if (this.f41148g.isRunning()) {
            this.f41148g.cancel();
        }
        this.f41147f = null;
        this.q = null;
        this.j = null;
        this.f41148g.g();
        invalidateSelf();
    }

    public void h0(float f2) {
        this.f41148g.B(f2);
    }

    public void i(boolean z) {
        if (this.p == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(t, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.p = z;
        if (this.f41147f != null) {
            f();
        }
    }

    public void i0(p pVar) {
        this.o = pVar;
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
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return F();
    }

    public boolean j() {
        return this.p;
    }

    @Nullable
    public Bitmap j0(String str, @Nullable Bitmap bitmap) {
        d.a.a.r.b q = q();
        if (q == null) {
            Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap f2 = q.f(str, bitmap);
        invalidateSelf();
        return f2;
    }

    @MainThread
    public void k() {
        this.i.clear();
        this.f41148g.h();
    }

    public final void k0() {
        if (this.f41147f == null) {
            return;
        }
        float z = z();
        setBounds(0, 0, (int) (this.f41147f.b().width() * z), (int) (this.f41147f.b().height() * z));
    }

    public d.a.a.d l() {
        return this.f41147f;
    }

    public boolean l0() {
        return this.o == null && this.f41147f.c().size() > 0;
    }

    @Nullable
    public final Context m() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public final d.a.a.r.a n() {
        if (getCallback() == null) {
            return null;
        }
        if (this.m == null) {
            this.m = new d.a.a.r.a(getCallback(), this.n);
        }
        return this.m;
    }

    public int o() {
        return (int) this.f41148g.j();
    }

    @Nullable
    public Bitmap p(String str) {
        d.a.a.r.b q = q();
        if (q != null) {
            return q.a(str);
        }
        return null;
    }

    public final d.a.a.r.b q() {
        if (getCallback() == null) {
            return null;
        }
        d.a.a.r.b bVar = this.j;
        if (bVar != null && !bVar.b(m())) {
            this.j.d();
            this.j = null;
        }
        if (this.j == null) {
            this.j = new d.a.a.r.b(getCallback(), this.k, this.l, this.f41147f.i());
        }
        return this.j;
    }

    @Nullable
    public String r() {
        return this.k;
    }

    public float s() {
        return this.f41148g.l();
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
        this.r = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Log.w("LOTTIE", "Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        I();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        k();
    }

    public final float t(@NonNull Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f41147f.b().width(), canvas.getHeight() / this.f41147f.b().height());
    }

    public float u() {
        return this.f41148g.m();
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
    public d.a.a.m v() {
        d.a.a.d dVar = this.f41147f;
        if (dVar != null) {
            return dVar.k();
        }
        return null;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float w() {
        return this.f41148g.i();
    }

    public int x() {
        return this.f41148g.getRepeatCount();
    }

    public int y() {
        return this.f41148g.getRepeatMode();
    }

    public float z() {
        return this.f41149h;
    }
}
