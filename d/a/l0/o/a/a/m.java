package d.a.l0.o.a.a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import androidx.annotation.CallSuper;
import androidx.fragment.app.FragmentStateManager;
import com.baidu.swan.support.v4.app.BackStackState;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentManagerState;
import com.baidu.swan.support.v4.app.FragmentState;
import com.baidu.swan.support.v4.app.SuperNotCalledException;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.bumptech.glide.load.engine.GlideException;
import d.a.l0.o.a.a.e;
import d.a.l0.o.a.a.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public final class m extends l implements d.a.l0.o.a.d.e {
    public static final Interpolator A;
    public static boolean x = false;
    public static final boolean y;
    public static final Interpolator z;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Runnable> f48232a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable[] f48233b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48234c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment> f48235d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Fragment> f48236e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Integer> f48237f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.a.l0.o.a.a.e> f48238g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Fragment> f48239h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<d.a.l0.o.a.a.e> f48240i;
    public ArrayList<Integer> j;
    public ArrayList<l.a> k;
    public k m;
    public i n;
    public Fragment o;
    public boolean p;
    public boolean q;
    public boolean r;
    public String s;
    public boolean t;
    public int l = 0;
    public Bundle u = null;
    public SparseArray<Parcelable> v = null;
    public Runnable w = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.E();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48242e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48243f;

        public b(int i2, int i3) {
            this.f48242e = i2;
            this.f48243f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar = m.this;
            mVar.X(mVar.m.j(), null, this.f48242e, this.f48243f);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Fragment f48245c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view, Animation animation, Fragment fragment) {
            super(view, animation);
            this.f48245c = fragment;
        }

        @Override // d.a.l0.o.a.a.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            Fragment fragment = this.f48245c;
            if (fragment.f11850f != null) {
                fragment.f11850f = null;
                m.this.U(fragment, fragment.f11851g, 0, 0, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f48247a = false;

        /* renamed from: b  reason: collision with root package name */
        public View f48248b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.o.a.d.f.d(d.this.f48248b, 2, null);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.o.a.d.f.d(d.this.f48248b, 0, null);
            }
        }

        public d(View view, Animation animation) {
            if (view == null || animation == null) {
                return;
            }
            this.f48248b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        @CallSuper
        public void onAnimationEnd(Animation animation) {
            if (this.f48247a) {
                this.f48248b.post(new b());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        @CallSuper
        public void onAnimationStart(Animation animation) {
            boolean j0 = m.j0(this.f48248b, animation);
            this.f48247a = j0;
            if (j0) {
                this.f48248b.post(new a());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f48251a = {16842755, 16842960, 16842961};
    }

    static {
        y = Build.VERSION.SDK_INT >= 11;
        z = new DecelerateInterpolator(2.5f);
        A = new DecelerateInterpolator(1.5f);
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
    }

    public static Animation N(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(A);
        alphaAnimation.setDuration(220L);
        return alphaAnimation;
    }

    public static Animation P(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(z);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(A);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    public static boolean Q(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (animation instanceof AnimationSet) {
            List<Animation> animations = ((AnimationSet) animation).getAnimations();
            for (int i2 = 0; i2 < animations.size(); i2++) {
                if (animations.get(i2) instanceof AlphaAnimation) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int d0(int i2) {
        if (i2 != 4097) {
            if (i2 != 4099) {
                return i2 != 8194 ? 0 : 4097;
            }
            return 4099;
        }
        return 8194;
    }

    public static boolean j0(View view, Animation animation) {
        return d.a.l0.o.a.d.f.b(view) == 0 && d.a.l0.o.a.d.f.c(view) && Q(animation);
    }

    public static int n0(int i2, boolean z2) {
        if (i2 == 4097) {
            return z2 ? 1 : 2;
        } else if (i2 == 4099) {
            return z2 ? 5 : 6;
        } else if (i2 != 8194) {
            return -1;
        } else {
            return z2 ? 3 : 4;
        }
    }

    public void A() {
        this.q = false;
        S(5, false);
    }

    public void B() {
        this.q = false;
        S(4, false);
    }

    public void C() {
        this.q = true;
        S(3, false);
    }

    public void D(Runnable runnable, boolean z2) {
        if (!z2) {
            l();
        }
        synchronized (this) {
            if (!this.r && this.m != null) {
                if (this.f48232a == null) {
                    this.f48232a = new ArrayList<>();
                }
                this.f48232a.add(runnable);
                if (this.f48232a.size() == 1) {
                    this.m.j().removeCallbacks(this.w);
                    this.m.j().post(this.w);
                }
            } else {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
        r6.f48234c = true;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r3 >= r2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
        r6.f48233b[r3].run();
        r6.f48233b[r3] = null;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean E() {
        q qVar;
        if (!this.f48234c) {
            if (Looper.myLooper() == this.m.j().getLooper()) {
                boolean z2 = false;
                while (true) {
                    synchronized (this) {
                        if (this.f48232a == null || this.f48232a.size() == 0) {
                            break;
                        }
                        int size = this.f48232a.size();
                        if (this.f48233b == null || this.f48233b.length < size) {
                            this.f48233b = new Runnable[size];
                        }
                        this.f48232a.toArray(this.f48233b);
                        this.f48232a.clear();
                        this.m.j().removeCallbacks(this.w);
                    }
                    this.f48234c = false;
                    z2 = true;
                }
                if (this.t) {
                    boolean z3 = false;
                    for (int i2 = 0; i2 < this.f48235d.size(); i2++) {
                        Fragment fragment = this.f48235d.get(i2);
                        if (fragment != null && (qVar = fragment.Q) != null) {
                            z3 |= qVar.j();
                        }
                    }
                    if (!z3) {
                        this.t = false;
                        l0();
                    }
                }
                return z2;
            }
            throw new IllegalStateException("Must be called from main thread of process");
        }
        throw new IllegalStateException("Recursive entry to executePendingTransactions");
    }

    public Fragment F(int i2) {
        ArrayList<Fragment> arrayList = this.f48236e;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f48236e.get(size);
                if (fragment != null && fragment.A == i2) {
                    return fragment;
                }
            }
        }
        ArrayList<Fragment> arrayList2 = this.f48235d;
        if (arrayList2 != null) {
            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f48235d.get(size2);
                if (fragment2 != null && fragment2.A == i2) {
                    return fragment2;
                }
            }
            return null;
        }
        return null;
    }

    public Fragment G(String str) {
        ArrayList<Fragment> arrayList = this.f48236e;
        if (arrayList != null && str != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f48236e.get(size);
                if (fragment != null && str.equals(fragment.C)) {
                    return fragment;
                }
            }
        }
        ArrayList<Fragment> arrayList2 = this.f48235d;
        if (arrayList2 == null || str == null) {
            return null;
        }
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            Fragment fragment2 = this.f48235d.get(size2);
            if (fragment2 != null && str.equals(fragment2.C)) {
                return fragment2;
            }
        }
        return null;
    }

    public void H(int i2) {
        synchronized (this) {
            this.f48240i.set(i2, null);
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            if (x) {
                Log.v("FragmentManager", "Freeing back stack index " + i2);
            }
            this.j.add(Integer.valueOf(i2));
        }
    }

    public Fragment I(Bundle bundle, String str) {
        int i2 = bundle.getInt(str, -1);
        if (i2 == -1) {
            return null;
        }
        if (i2 < this.f48235d.size()) {
            Fragment fragment = this.f48235d.get(i2);
            if (fragment != null) {
                return fragment;
            }
            m0(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
            throw null;
        }
        m0(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
        throw null;
    }

    public d.a.l0.o.a.d.e J() {
        return this;
    }

    public void K(Fragment fragment, int i2, int i3) {
        if (x) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.D) {
            return;
        }
        fragment.D = true;
        if (fragment.M != null) {
            Animation L = L(fragment, i2, false, i3);
            if (L != null) {
                i0(fragment.M, L);
                fragment.M.startAnimation(L);
            }
            fragment.M.setVisibility(8);
        }
        if (fragment.p && fragment.H && fragment.I) {
            this.p = true;
        }
        fragment.F0(true);
    }

    public Animation L(Fragment fragment, int i2, boolean z2, int i3) {
        int n0;
        Animation loadAnimation;
        Animation z0 = fragment.z0(i2, z2, fragment.K);
        if (z0 != null) {
            return z0;
        }
        if (fragment.K == 0 || (loadAnimation = AnimationUtils.loadAnimation(this.m.h(), fragment.K)) == null) {
            if (i2 != 0 && (n0 = n0(i2, z2)) >= 0) {
                switch (n0) {
                    case 1:
                        return P(this.m.h(), 1.125f, 1.0f, 0.0f, 1.0f);
                    case 2:
                        return P(this.m.h(), 1.0f, 0.975f, 1.0f, 0.0f);
                    case 3:
                        return P(this.m.h(), 0.975f, 1.0f, 0.0f, 1.0f);
                    case 4:
                        return P(this.m.h(), 1.0f, 1.075f, 1.0f, 0.0f);
                    case 5:
                        return N(this.m.h(), 0.0f, 1.0f);
                    case 6:
                        return N(this.m.h(), 1.0f, 0.0f);
                    default:
                        if (i3 == 0 && this.m.r()) {
                            i3 = this.m.q();
                        }
                        if (i3 == 0) {
                        }
                        return null;
                }
            }
            return null;
        }
        return loadAnimation;
    }

    public void M(Fragment fragment) {
        if (fragment.j >= 0) {
            return;
        }
        ArrayList<Integer> arrayList = this.f48237f;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<Integer> arrayList2 = this.f48237f;
            fragment.k1(arrayList2.remove(arrayList2.size() - 1).intValue(), this.o);
            this.f48235d.set(fragment.j, fragment);
        } else {
            if (this.f48235d == null) {
                this.f48235d = new ArrayList<>();
            }
            fragment.k1(this.f48235d.size(), this.o);
            this.f48235d.add(fragment);
        }
        if (x) {
            Log.v("FragmentManager", "Allocated fragment index " + fragment);
        }
    }

    public void O(Fragment fragment) {
        if (fragment.j < 0) {
            return;
        }
        if (x) {
            Log.v("FragmentManager", "Freeing fragment index " + fragment);
        }
        this.f48235d.set(fragment.j, null);
        if (this.f48237f == null) {
            this.f48237f = new ArrayList<>();
        }
        this.f48237f.add(Integer.valueOf(fragment.j));
        this.m.m(fragment.k);
        fragment.e0();
    }

    public void R(int i2, int i3, int i4, boolean z2) {
        k kVar;
        if (this.m == null && i2 != 0) {
            throw new IllegalStateException("No host");
        }
        if (z2 || this.l != i2) {
            this.l = i2;
            if (this.f48235d != null) {
                boolean z3 = false;
                for (int i5 = 0; i5 < this.f48235d.size(); i5++) {
                    Fragment fragment = this.f48235d.get(i5);
                    if (fragment != null) {
                        U(fragment, i2, i3, i4, false);
                        q qVar = fragment.Q;
                        if (qVar != null) {
                            z3 |= qVar.j();
                        }
                    }
                }
                if (!z3) {
                    l0();
                }
                if (this.p && (kVar = this.m) != null && this.l == 5) {
                    kVar.u();
                    this.p = false;
                }
            }
        }
    }

    public void S(int i2, boolean z2) {
        R(i2, 0, 0, z2);
    }

    public void T(Fragment fragment) {
        U(fragment, this.l, 0, 0, false);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:122:0x0222 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x015a */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015c  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Throwable, android.os.Bundle, android.view.View] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [android.os.Bundle, android.util.SparseArray<android.os.Parcelable>] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void U(Fragment fragment, int i2, int i3, int i4, boolean z2) {
        int i5;
        View view;
        String str;
        String str2;
        boolean z3;
        m i6;
        ?? r14;
        ViewGroup viewGroup;
        int i7;
        int i8 = 1;
        if (!fragment.p || fragment.E) {
            i5 = i2;
            if (i5 > 1) {
                i5 = 1;
            }
        } else {
            i5 = i2;
        }
        if (fragment.q && i5 > (i7 = fragment.f11849e)) {
            i5 = i7;
        }
        int i9 = (!fragment.O || fragment.f11849e >= 4 || i5 <= 3) ? i5 : 3;
        int i10 = fragment.f11849e;
        if (i10 < i9) {
            if (fragment.s && !fragment.t) {
                return;
            }
            if (fragment.f11850f != null) {
                fragment.f11850f = null;
                str = "FragmentManager";
                U(fragment, fragment.f11851g, 0, 0, true);
            } else {
                str = "FragmentManager";
            }
            int i11 = fragment.f11849e;
            if (i11 == 0) {
                if (x) {
                    str2 = str;
                    Log.v(str2, "moveto CREATED: " + fragment);
                } else {
                    str2 = str;
                }
                Bundle bundle = fragment.f11852h;
                if (bundle != null) {
                    bundle.setClassLoader(this.m.h().getClassLoader());
                    fragment.f11853i = fragment.f11852h.getSparseParcelableArray(FragmentStateManager.VIEW_STATE_TAG);
                    Fragment I = I(fragment.f11852h, FragmentStateManager.TARGET_STATE_TAG);
                    fragment.m = I;
                    if (I != null) {
                        z3 = false;
                        fragment.o = fragment.f11852h.getInt(FragmentStateManager.TARGET_REQUEST_CODE_STATE_TAG, 0);
                    } else {
                        z3 = false;
                    }
                    boolean z4 = fragment.f11852h.getBoolean(FragmentStateManager.USER_VISIBLE_HINT_TAG, true);
                    fragment.P = z4;
                    if (!z4) {
                        fragment.O = true;
                        if (i9 > 3) {
                            i9 = 3;
                        }
                    }
                } else {
                    z3 = false;
                }
                k kVar = this.m;
                fragment.x = kVar;
                Fragment fragment2 = this.o;
                fragment.z = fragment2;
                if (fragment2 != null) {
                    i6 = fragment2.y;
                } else {
                    i6 = kVar.i();
                }
                fragment.w = i6;
                fragment.J = z3;
                fragment.x0(this.m.h());
                if (fragment.J) {
                    if (fragment.z == null) {
                        this.m.n(fragment);
                    }
                    if (!fragment.G) {
                        fragment.S0(fragment.f11852h);
                    }
                    fragment.G = z3;
                    if (fragment.s) {
                        r14 = 0;
                        r14 = 0;
                        View U0 = fragment.U0(fragment.v(fragment.f11852h), null, fragment.f11852h);
                        fragment.M = U0;
                        if (U0 != null) {
                            fragment.N = U0;
                            if (Build.VERSION.SDK_INT >= 11) {
                                d.a.l0.o.a.d.f.e(U0, z3);
                            } else {
                                fragment.M = r.a(U0);
                            }
                            if (fragment.D) {
                                fragment.M.setVisibility(8);
                            }
                            fragment.N0(fragment.M, fragment.f11852h);
                        } else {
                            fragment.N = null;
                        }
                        if (i9 > 1) {
                            if (x) {
                                Log.v(str2, "moveto ACTIVITY_CREATED: " + fragment);
                            }
                            if (!fragment.s) {
                                int i12 = fragment.B;
                                if (i12 != 0) {
                                    viewGroup = (ViewGroup) this.n.a(i12);
                                    if (viewGroup == null && !fragment.u) {
                                        m0(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.B) + " (" + fragment.z().getResourceName(fragment.B) + ") for fragment " + fragment));
                                        throw r14;
                                    }
                                } else {
                                    viewGroup = r14;
                                }
                                fragment.L = viewGroup;
                                View U02 = fragment.U0(fragment.v(fragment.f11852h), viewGroup, fragment.f11852h);
                                fragment.M = U02;
                                if (U02 != null) {
                                    fragment.N = U02;
                                    if (Build.VERSION.SDK_INT >= 11) {
                                        d.a.l0.o.a.d.f.e(U02, z3);
                                    } else {
                                        fragment.M = r.a(U02);
                                    }
                                    if (viewGroup != null) {
                                        Animation L = L(fragment, i3, true, i4);
                                        if (L != null) {
                                            i0(fragment.M, L);
                                            fragment.M.startAnimation(L);
                                        }
                                        viewGroup.addView(fragment.M);
                                    }
                                    if (fragment.D) {
                                        fragment.M.setVisibility(8);
                                    }
                                    fragment.N0(fragment.M, fragment.f11852h);
                                } else {
                                    fragment.N = r14;
                                }
                            }
                            fragment.P0(fragment.f11852h);
                            if (fragment.M != null) {
                                fragment.i1(fragment.f11852h);
                            }
                            fragment.f11852h = r14;
                        }
                        if (i9 > 3) {
                        }
                        if (i9 > 4) {
                        }
                    }
                } else {
                    throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onAttach()");
                }
            } else if (i11 == 1) {
                str2 = str;
                z3 = false;
            } else if (i11 == 2 || i11 == 3) {
                str2 = str;
                r14 = 0;
                if (i9 > 3) {
                    if (x) {
                        Log.v(str2, "moveto STARTED: " + fragment);
                    }
                    fragment.f1();
                }
                if (i9 > 4) {
                    if (x) {
                        Log.v(str2, "moveto RESUMED: " + fragment);
                    }
                    fragment.r = true;
                    fragment.d1();
                    fragment.f11852h = r14;
                    fragment.f11853i = r14;
                }
            } else if (i11 == 4) {
                str2 = str;
                r14 = 0;
                if (i9 > 4) {
                }
            }
            r14 = 0;
            if (i9 > 1) {
            }
            if (i9 > 3) {
            }
            if (i9 > 4) {
            }
        } else if (i10 > i9) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 == 5) {
                                if (i9 < 5) {
                                    if (x) {
                                        Log.v("FragmentManager", "movefrom RESUMED: " + fragment);
                                    }
                                    fragment.a1();
                                    fragment.r = false;
                                }
                            }
                        }
                        if (i9 < 4) {
                            if (x) {
                                Log.v("FragmentManager", "movefrom STARTED: " + fragment);
                            }
                            fragment.g1();
                        }
                    }
                    if (i9 < 3) {
                        if (x) {
                            Log.v("FragmentManager", "movefrom STOPPED: " + fragment);
                        }
                        fragment.c1();
                    }
                }
                if (i9 < 2) {
                    if (x) {
                        Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                    }
                    if (fragment.M != null && this.m.t(fragment) && fragment.f11853i == null) {
                        g0(fragment);
                    }
                    fragment.W0();
                    if (fragment.M != null && fragment.L != null) {
                        Animation L2 = (this.l <= 0 || this.r) ? null : L(fragment, i3, false, i4);
                        if (L2 != null) {
                            View view2 = fragment.M;
                            fragment.f11850f = view2;
                            fragment.f11851g = i9;
                            L2.setAnimationListener(new c(view2, L2, fragment));
                            fragment.M.startAnimation(L2);
                        }
                        fragment.L.removeView(fragment.M);
                    }
                    fragment.L = null;
                    fragment.M = null;
                    fragment.N = null;
                }
            }
            if (i9 < 1) {
                if (this.r && (view = fragment.f11850f) != null) {
                    fragment.f11850f = null;
                    view.clearAnimation();
                }
                if (fragment.f11850f != null) {
                    fragment.f11851g = i9;
                    fragment.f11849e = i8;
                }
                if (x) {
                    Log.v("FragmentManager", "movefrom CREATED: " + fragment);
                }
                if (!fragment.G) {
                    fragment.V0();
                }
                fragment.J = false;
                fragment.E0();
                if (!fragment.J) {
                    throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onDetach()");
                } else if (!z2) {
                    if (!fragment.G) {
                        O(fragment);
                    } else {
                        fragment.x = null;
                        fragment.z = null;
                        fragment.w = null;
                        fragment.y = null;
                    }
                }
            }
        }
        i8 = i9;
        fragment.f11849e = i8;
    }

    public void V() {
        this.q = false;
    }

    public void W(Fragment fragment) {
        if (fragment.O) {
            if (this.f48234c) {
                this.t = true;
                return;
            }
            fragment.O = false;
            U(fragment, this.l, 0, 0, false);
        }
    }

    public boolean X(Handler handler, String str, int i2, int i3) {
        int size;
        ArrayList<d.a.l0.o.a.a.e> arrayList = this.f48238g;
        if (arrayList == null) {
            return false;
        }
        e.C1081e c1081e = null;
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size2 = arrayList.size() - 1;
            if (size2 < 0) {
                return false;
            }
            d.a.l0.o.a.a.e remove = this.f48238g.remove(size2);
            SparseArray<Fragment> sparseArray = new SparseArray<>();
            SparseArray<Fragment> sparseArray2 = new SparseArray<>();
            remove.q(sparseArray, sparseArray2);
            remove.I(true, null, sparseArray, sparseArray2);
            a0();
        } else {
            if (str != null || i2 >= 0) {
                size = this.f48238g.size() - 1;
                while (size >= 0) {
                    d.a.l0.o.a.a.e eVar = this.f48238g.get(size);
                    if ((str != null && str.equals(eVar.E())) || (i2 >= 0 && i2 == eVar.r)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        d.a.l0.o.a.a.e eVar2 = this.f48238g.get(size);
                        if (str == null || !str.equals(eVar2.E())) {
                            if (i2 < 0 || i2 != eVar2.r) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.f48238g.size() - 1) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int size3 = this.f48238g.size() - 1; size3 > size; size3--) {
                arrayList2.add(this.f48238g.remove(size3));
            }
            int size4 = arrayList2.size() - 1;
            SparseArray<Fragment> sparseArray3 = new SparseArray<>();
            SparseArray<Fragment> sparseArray4 = new SparseArray<>();
            for (int i4 = 0; i4 <= size4; i4++) {
                ((d.a.l0.o.a.a.e) arrayList2.get(i4)).q(sparseArray3, sparseArray4);
            }
            int i5 = 0;
            while (i5 <= size4) {
                if (x) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList2.get(i5));
                }
                c1081e = ((d.a.l0.o.a.a.e) arrayList2.get(i5)).I(i5 == size4, c1081e, sparseArray3, sparseArray4);
                i5++;
            }
            a0();
        }
        return true;
    }

    public void Y(Bundle bundle, String str, Fragment fragment) {
        int i2 = fragment.j;
        if (i2 >= 0) {
            bundle.putInt(str, i2);
            return;
        }
        m0(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    public void Z(Fragment fragment, int i2, int i3) {
        if (x) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.v);
        }
        int i4 = !fragment.s0();
        if (fragment.E && i4 == 0) {
            return;
        }
        ArrayList<Fragment> arrayList = this.f48236e;
        if (arrayList != null) {
            arrayList.remove(fragment);
        }
        if (fragment.H && fragment.I) {
            this.p = true;
        }
        fragment.p = false;
        fragment.q = true;
        U(fragment, i4 ^ 1, i2, i3, false);
    }

    @Override // d.a.l0.o.a.a.l
    public n a() {
        return new d.a.l0.o.a.a.e(this);
    }

    public void a0() {
        if (this.k != null) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                this.k.get(i2).onBackStackChanged();
            }
        }
    }

    @Override // d.a.l0.o.a.a.l
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + "    ";
        ArrayList<Fragment> arrayList = this.f48235d;
        if (arrayList != null && (size6 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i2 = 0; i2 < size6; i2++) {
                Fragment fragment = this.f48235d.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.g(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        ArrayList<Fragment> arrayList2 = this.f48236e;
        if (arrayList2 != null && (size5 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size5; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.f48236e.get(i3).toString());
            }
        }
        ArrayList<Fragment> arrayList3 = this.f48239h;
        if (arrayList3 != null && (size4 = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i4 = 0; i4 < size4; i4++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(this.f48239h.get(i4).toString());
            }
        }
        ArrayList<d.a.l0.o.a.a.e> arrayList4 = this.f48238g;
        if (arrayList4 != null && (size3 = arrayList4.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i5 = 0; i5 < size3; i5++) {
                d.a.l0.o.a.a.e eVar = this.f48238g.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(eVar.toString());
                eVar.y(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.f48240i != null && (size2 = this.f48240i.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i6 = 0; i6 < size2; i6++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println((d.a.l0.o.a.a.e) this.f48240i.get(i6));
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        ArrayList<Runnable> arrayList5 = this.f48232a;
        if (arrayList5 != null && (size = arrayList5.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i7 = 0; i7 < size; i7++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println((Runnable) this.f48232a.get(i7));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.n);
        if (this.o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.q);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.r);
        if (this.p) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.p);
        }
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.s);
        }
        ArrayList<Integer> arrayList6 = this.f48237f;
        if (arrayList6 == null || arrayList6.size() <= 0) {
            return;
        }
        printWriter.print(str);
        printWriter.print("  mAvailIndices: ");
        printWriter.println(Arrays.toString(this.f48237f.toArray()));
    }

    public void b0(Parcelable parcelable, List<Fragment> list) {
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f11861e == null) {
            return;
        }
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                Fragment fragment = list.get(i2);
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                }
                FragmentState fragmentState = fragmentManagerState.f11861e[fragment.j];
                fragmentState.o = fragment;
                fragment.f11853i = null;
                fragment.v = 0;
                fragment.t = false;
                fragment.p = false;
                fragment.m = null;
                Bundle bundle = fragmentState.n;
                if (bundle != null) {
                    bundle.setClassLoader(this.m.h().getClassLoader());
                    fragment.f11853i = fragmentState.n.getSparseParcelableArray(FragmentStateManager.VIEW_STATE_TAG);
                    fragment.f11852h = fragmentState.n;
                }
            }
        }
        this.f48235d = new ArrayList<>(fragmentManagerState.f11861e.length);
        ArrayList<Integer> arrayList = this.f48237f;
        if (arrayList != null) {
            arrayList.clear();
        }
        int i3 = 0;
        while (true) {
            FragmentState[] fragmentStateArr = fragmentManagerState.f11861e;
            if (i3 >= fragmentStateArr.length) {
                break;
            }
            FragmentState fragmentState2 = fragmentStateArr[i3];
            if (fragmentState2 != null) {
                Fragment a2 = fragmentState2.a(this.m, this.o);
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: active #" + i3 + ": " + a2);
                }
                this.f48235d.add(a2);
                fragmentState2.o = null;
            } else {
                this.f48235d.add(null);
                if (this.f48237f == null) {
                    this.f48237f = new ArrayList<>();
                }
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: avail #" + i3);
                }
                this.f48237f.add(Integer.valueOf(i3));
            }
            i3++;
        }
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                Fragment fragment2 = list.get(i4);
                int i5 = fragment2.n;
                if (i5 >= 0) {
                    if (i5 < this.f48235d.size()) {
                        fragment2.m = this.f48235d.get(fragment2.n);
                    } else {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.n);
                        fragment2.m = null;
                    }
                }
            }
        }
        if (fragmentManagerState.f11862f != null) {
            this.f48236e = new ArrayList<>(fragmentManagerState.f11862f.length);
            int i6 = 0;
            while (true) {
                int[] iArr = fragmentManagerState.f11862f;
                if (i6 >= iArr.length) {
                    break;
                }
                Fragment fragment3 = this.f48235d.get(iArr[i6]);
                if (fragment3 != null) {
                    fragment3.p = true;
                    if (x) {
                        Log.v("FragmentManager", "restoreAllState: added #" + i6 + ": " + fragment3);
                    }
                    if (!this.f48236e.contains(fragment3)) {
                        this.f48236e.add(fragment3);
                        i6++;
                    } else {
                        throw new IllegalStateException("Already added!");
                    }
                } else {
                    m0(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f11862f[i6]));
                    throw null;
                }
            }
        } else {
            this.f48236e = null;
        }
        if (fragmentManagerState.f11863g != null) {
            this.f48238g = new ArrayList<>(fragmentManagerState.f11863g.length);
            int i7 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.f11863g;
                if (i7 >= backStackStateArr.length) {
                    return;
                }
                d.a.l0.o.a.a.e a3 = backStackStateArr[i7].a(this);
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i7 + " (index " + a3.r + "): " + a3);
                    a3.z(GlideException.IndentedAppendable.INDENT, new PrintWriter(new d.a.l0.o.a.c.d("FragmentManager")), false);
                }
                this.f48238g.add(a3);
                int i8 = a3.r;
                if (i8 >= 0) {
                    h0(i8, a3);
                }
                i7++;
            }
        } else {
            this.f48238g = null;
        }
    }

    @Override // d.a.l0.o.a.a.l
    public boolean c() {
        return E();
    }

    public ArrayList<Fragment> c0() {
        ArrayList<Fragment> arrayList = null;
        if (this.f48235d != null) {
            for (int i2 = 0; i2 < this.f48235d.size(); i2++) {
                Fragment fragment = this.f48235d.get(i2);
                if (fragment != null && fragment.F) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                    fragment.G = true;
                    Fragment fragment2 = fragment.m;
                    fragment.n = fragment2 != null ? fragment2.j : -1;
                    if (x) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // d.a.l0.o.a.a.l
    public List<Fragment> d() {
        return this.f48235d;
    }

    @Override // d.a.l0.o.a.a.l
    public void e(int i2, int i3) {
        if (i2 >= 0) {
            D(new b(i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    public Parcelable e0() {
        int[] iArr;
        int size;
        int size2;
        E();
        if (y) {
            this.q = true;
        }
        ArrayList<Fragment> arrayList = this.f48235d;
        BackStackState[] backStackStateArr = null;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size3 = this.f48235d.size();
        FragmentState[] fragmentStateArr = new FragmentState[size3];
        boolean z2 = false;
        for (int i2 = 0; i2 < size3; i2++) {
            Fragment fragment = this.f48235d.get(i2);
            if (fragment != null) {
                if (fragment.j >= 0) {
                    FragmentState fragmentState = new FragmentState(fragment);
                    fragmentStateArr[i2] = fragmentState;
                    if (fragment.f11849e > 0 && fragmentState.n == null) {
                        Bundle f0 = f0(fragment);
                        fragmentState.n = f0;
                        Fragment fragment2 = fragment.m;
                        if (fragment2 != null) {
                            if (fragment2.j >= 0) {
                                if (f0 == null) {
                                    fragmentState.n = new Bundle();
                                }
                                Y(fragmentState.n, FragmentStateManager.TARGET_STATE_TAG, fragment.m);
                                int i3 = fragment.o;
                                if (i3 != 0) {
                                    fragmentState.n.putInt(FragmentStateManager.TARGET_REQUEST_CODE_STATE_TAG, i3);
                                }
                            } else {
                                m0(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.m));
                                throw null;
                            }
                        }
                    } else {
                        fragmentState.n = fragment.f11852h;
                    }
                    if (x) {
                        Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.n);
                    }
                    z2 = true;
                } else {
                    m0(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.j));
                    throw null;
                }
            }
        }
        if (!z2) {
            if (x) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<Fragment> arrayList2 = this.f48236e;
        if (arrayList2 == null || (size2 = arrayList2.size()) <= 0) {
            iArr = null;
        } else {
            iArr = new int[size2];
            for (int i4 = 0; i4 < size2; i4++) {
                iArr[i4] = this.f48236e.get(i4).j;
                if (iArr[i4] >= 0) {
                    if (x) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i4 + ": " + this.f48236e.get(i4));
                    }
                } else {
                    m0(new IllegalStateException("Failure saving state: active " + this.f48236e.get(i4) + " has cleared index: " + iArr[i4]));
                    throw null;
                }
            }
        }
        ArrayList<d.a.l0.o.a.a.e> arrayList3 = this.f48238g;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i5 = 0; i5 < size; i5++) {
                backStackStateArr[i5] = new BackStackState(this.f48238g.get(i5));
                if (x) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i5 + ": " + this.f48238g.get(i5));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f11861e = fragmentStateArr;
        fragmentManagerState.f11862f = iArr;
        fragmentManagerState.f11863g = backStackStateArr;
        return fragmentManagerState;
    }

    @Override // d.a.l0.o.a.a.l
    public boolean f() {
        l();
        c();
        return X(this.m.j(), null, -1, 0);
    }

    public Bundle f0(Fragment fragment) {
        if (this.u == null) {
            this.u = new Bundle();
        }
        fragment.e1(this.u);
        Bundle bundle = null;
        if (!this.u.isEmpty()) {
            Bundle bundle2 = this.u;
            this.u = null;
            bundle = bundle2;
        }
        if (fragment.M != null) {
            g0(fragment);
        }
        if (fragment.f11853i != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(FragmentStateManager.VIEW_STATE_TAG, fragment.f11853i);
        }
        if (!fragment.P) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(FragmentStateManager.USER_VISIBLE_HINT_TAG, fragment.P);
        }
        return bundle;
    }

    public void g(d.a.l0.o.a.a.e eVar) {
        if (this.f48238g == null) {
            this.f48238g = new ArrayList<>();
        }
        this.f48238g.add(eVar);
        a0();
    }

    public void g0(Fragment fragment) {
        if (fragment.N == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.v;
        if (sparseArray == null) {
            this.v = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.N.saveHierarchyState(this.v);
        if (this.v.size() > 0) {
            fragment.f11853i = this.v;
            this.v = null;
        }
    }

    public void h(Fragment fragment, boolean z2) {
        if (this.f48236e == null) {
            this.f48236e = new ArrayList<>();
        }
        if (x) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        M(fragment);
        if (fragment.E) {
            return;
        }
        if (!this.f48236e.contains(fragment)) {
            this.f48236e.add(fragment);
            fragment.p = true;
            fragment.q = false;
            if (fragment.H && fragment.I) {
                this.p = true;
            }
            if (z2) {
                T(fragment);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void h0(int i2, d.a.l0.o.a.a.e eVar) {
        synchronized (this) {
            if (this.f48240i == null) {
                this.f48240i = new ArrayList<>();
            }
            int size = this.f48240i.size();
            if (i2 < size) {
                if (x) {
                    Log.v("FragmentManager", "Setting back stack index " + i2 + " to " + eVar);
                }
                this.f48240i.set(i2, eVar);
            } else {
                while (size < i2) {
                    this.f48240i.add(null);
                    if (this.j == null) {
                        this.j = new ArrayList<>();
                    }
                    if (x) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.j.add(Integer.valueOf(size));
                    size++;
                }
                if (x) {
                    Log.v("FragmentManager", "Adding back stack index " + i2 + " with " + eVar);
                }
                this.f48240i.add(eVar);
            }
        }
    }

    public int i(d.a.l0.o.a.a.e eVar) {
        synchronized (this) {
            if (this.j != null && this.j.size() > 0) {
                int intValue = this.j.remove(this.j.size() - 1).intValue();
                if (x) {
                    Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + eVar);
                }
                this.f48240i.set(intValue, eVar);
                return intValue;
            }
            if (this.f48240i == null) {
                this.f48240i = new ArrayList<>();
            }
            int size = this.f48240i.size();
            if (x) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + eVar);
            }
            this.f48240i.add(eVar);
            return size;
        }
    }

    public final void i0(View view, Animation animation) {
        if (view == null || animation == null || !j0(view, animation)) {
            return;
        }
        animation.setAnimationListener(new d(view, animation));
    }

    public void j(k kVar, i iVar, Fragment fragment) {
        if (this.m == null) {
            this.m = kVar;
            this.n = iVar;
            this.o = fragment;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public void k(Fragment fragment, int i2, int i3) {
        if (x) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.E) {
            fragment.E = false;
            if (fragment.p) {
                return;
            }
            if (this.f48236e == null) {
                this.f48236e = new ArrayList<>();
            }
            if (!this.f48236e.contains(fragment)) {
                if (x) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f48236e.add(fragment);
                fragment.p = true;
                if (fragment.H && fragment.I) {
                    this.p = true;
                }
                U(fragment, this.l, i2, i3, false);
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    public void k0(Fragment fragment, int i2, int i3) {
        if (x) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.D) {
            fragment.D = false;
            if (fragment.M != null) {
                Animation L = L(fragment, i2, true, i3);
                if (L != null) {
                    i0(fragment.M, L);
                    fragment.M.startAnimation(L);
                }
                fragment.M.setVisibility(0);
            }
            if (fragment.p && fragment.H && fragment.I) {
                this.p = true;
            }
            fragment.F0(false);
        }
    }

    public final void l() {
        if (!this.q) {
            if (this.s == null) {
                return;
            }
            throw new IllegalStateException("Can not perform this action inside of " + this.s);
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    public void l0() {
        if (this.f48235d == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f48235d.size(); i2++) {
            Fragment fragment = this.f48235d.get(i2);
            if (fragment != null) {
                W(fragment);
            }
        }
    }

    public void m(Fragment fragment, int i2, int i3) {
        if (x) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.E) {
            return;
        }
        fragment.E = true;
        if (fragment.p) {
            if (this.f48236e != null) {
                if (x) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.f48236e.remove(fragment);
            }
            if (fragment.H && fragment.I) {
                this.p = true;
            }
            fragment.p = false;
            U(fragment, 1, i2, i3, false);
        }
    }

    public final void m0(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new d.a.l0.o.a.c.d("FragmentManager"));
        k kVar = this.m;
        if (kVar != null) {
            try {
                kVar.o(GlideException.IndentedAppendable.INDENT, null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            try {
                b(GlideException.IndentedAppendable.INDENT, null, printWriter, new String[0]);
            } catch (Exception e3) {
                Log.e("FragmentManager", "Failed dumping state", e3);
            }
        }
        try {
            printWriter.close();
        } catch (Exception unused) {
            if (x) {
                Log.e("FragmentManager", "pw close exception");
            }
        }
        throw runtimeException;
    }

    public void n() {
        this.q = false;
        S(2, false);
    }

    public void o(Configuration configuration) {
        if (this.f48236e != null) {
            for (int i2 = 0; i2 < this.f48236e.size(); i2++) {
                Fragment fragment = this.f48236e.get(i2);
                if (fragment != null) {
                    fragment.Q0(configuration);
                }
            }
        }
    }

    @Override // d.a.l0.o.a.d.e
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, DealIntentService.KEY_CLASS);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f48251a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            String str2 = attributeValue;
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (Fragment.t0(this.m.h(), str2)) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
                }
                Fragment F = resourceId != -1 ? F(resourceId) : null;
                if (F == null && string != null) {
                    F = G(string);
                }
                if (F == null && id != -1) {
                    F = F(id);
                }
                if (x) {
                    Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + F);
                }
                if (F == null) {
                    F = Fragment.f0(context, str2);
                    F.s = true;
                    F.A = resourceId != 0 ? resourceId : id;
                    F.B = id;
                    F.C = string;
                    F.t = true;
                    F.w = this;
                    k kVar = this.m;
                    F.x = kVar;
                    F.H0(kVar.h(), attributeSet, F.f11852h);
                    h(F, true);
                } else if (!F.t) {
                    F.t = true;
                    if (!F.G) {
                        F.H0(this.m.h(), attributeSet, F.f11852h);
                    }
                } else {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
                }
                Fragment fragment = F;
                if (this.l < 1 && fragment.s) {
                    U(fragment, 1, 0, 0, false);
                } else {
                    T(fragment);
                }
                View view2 = fragment.M;
                if (view2 != null) {
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (fragment.M.getTag() == null) {
                        fragment.M.setTag(string);
                    }
                    return fragment.M;
                }
                throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
            }
            return null;
        }
        return null;
    }

    public boolean p(MenuItem menuItem) {
        if (this.f48236e != null) {
            for (int i2 = 0; i2 < this.f48236e.size(); i2++) {
                Fragment fragment = this.f48236e.get(i2);
                if (fragment != null && fragment.R0(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void q() {
        this.q = false;
        S(1, false);
    }

    public boolean r(Menu menu, MenuInflater menuInflater) {
        boolean z2;
        ArrayList<Fragment> arrayList = null;
        if (this.f48236e != null) {
            z2 = false;
            for (int i2 = 0; i2 < this.f48236e.size(); i2++) {
                Fragment fragment = this.f48236e.get(i2);
                if (fragment != null && fragment.T0(menu, menuInflater)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                    z2 = true;
                }
            }
        } else {
            z2 = false;
        }
        if (this.f48239h != null) {
            for (int i3 = 0; i3 < this.f48239h.size(); i3++) {
                Fragment fragment2 = this.f48239h.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.C0();
                }
            }
        }
        this.f48239h = arrayList;
        return z2;
    }

    public void s() {
        this.r = true;
        E();
        S(0, false);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public void t() {
        S(1, false);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.o;
        if (fragment != null) {
            d.a.l0.o.a.c.c.a(fragment, sb);
        } else {
            d.a.l0.o.a.c.c.a(this.m, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    public void u() {
        if (this.f48236e != null) {
            for (int i2 = 0; i2 < this.f48236e.size(); i2++) {
                Fragment fragment = this.f48236e.get(i2);
                if (fragment != null) {
                    fragment.X0();
                }
            }
        }
    }

    public boolean v(MenuItem menuItem) {
        if (this.f48236e != null) {
            for (int i2 = 0; i2 < this.f48236e.size(); i2++) {
                Fragment fragment = this.f48236e.get(i2);
                if (fragment != null && fragment.Y0(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void w(Menu menu) {
        if (this.f48236e != null) {
            for (int i2 = 0; i2 < this.f48236e.size(); i2++) {
                Fragment fragment = this.f48236e.get(i2);
                if (fragment != null) {
                    fragment.Z0(menu);
                }
            }
        }
    }

    public void x() {
        S(4, false);
    }

    public boolean y(Menu menu) {
        if (this.f48236e != null) {
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f48236e.size(); i2++) {
                Fragment fragment = this.f48236e.get(i2);
                if (fragment != null && fragment.b1(menu)) {
                    z2 = true;
                }
            }
            return z2;
        }
        return false;
    }

    public void z() {
        S(2, false);
    }
}
