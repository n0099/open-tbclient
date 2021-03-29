package d.b.g0.m.a.a;

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
import androidx.fragment.app.FragmentManagerImpl;
import com.baidu.swan.support.v4.app.BackStackState;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentManagerState;
import com.baidu.swan.support.v4.app.FragmentState;
import com.baidu.swan.support.v4.app.SuperNotCalledException;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.bumptech.glide.load.engine.GlideException;
import d.b.g0.m.a.a.e;
import d.b.g0.m.a.a.k;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public final class l extends k implements d.b.g0.m.a.d.e {
    public static final Interpolator A;
    public static boolean x = false;
    public static final boolean y;
    public static final Interpolator z;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Runnable> f49102a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable[] f49103b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49104c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment> f49105d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Fragment> f49106e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Integer> f49107f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<e> f49108g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Fragment> f49109h;
    public ArrayList<e> i;
    public ArrayList<Integer> j;
    public ArrayList<k.a> k;
    public j m;
    public h n;
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
            l.this.D();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Fragment f49111c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view, Animation animation, Fragment fragment) {
            super(view, animation);
            this.f49111c = fragment;
        }

        @Override // d.b.g0.m.a.a.l.c, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            Fragment fragment = this.f49111c;
            if (fragment.f13032f != null) {
                fragment.f13032f = null;
                l.this.T(fragment, fragment.f13033g, 0, 0, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f49113a = false;

        /* renamed from: b  reason: collision with root package name */
        public View f49114b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.m.a.d.f.d(c.this.f49114b, 2, null);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.b.g0.m.a.d.f.d(c.this.f49114b, 0, null);
            }
        }

        public c(View view, Animation animation) {
            if (view == null || animation == null) {
                return;
            }
            this.f49114b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        @CallSuper
        public void onAnimationEnd(Animation animation) {
            if (this.f49113a) {
                this.f49114b.post(new b());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        @CallSuper
        public void onAnimationStart(Animation animation) {
            boolean i0 = l.i0(this.f49114b, animation);
            this.f49113a = i0;
            if (i0) {
                this.f49114b.post(new a());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f49117a = {16842755, 16842960, 16842961};
    }

    static {
        y = Build.VERSION.SDK_INT >= 11;
        z = new DecelerateInterpolator(2.5f);
        A = new DecelerateInterpolator(1.5f);
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
    }

    public static Animation M(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(A);
        alphaAnimation.setDuration(220L);
        return alphaAnimation;
    }

    public static Animation O(Context context, float f2, float f3, float f4, float f5) {
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

    public static boolean P(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (animation instanceof AnimationSet) {
            List<Animation> animations = ((AnimationSet) animation).getAnimations();
            for (int i = 0; i < animations.size(); i++) {
                if (animations.get(i) instanceof AlphaAnimation) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int c0(int i) {
        if (i != 4097) {
            if (i != 4099) {
                return i != 8194 ? 0 : 4097;
            }
            return 4099;
        }
        return 8194;
    }

    public static boolean i0(View view, Animation animation) {
        return d.b.g0.m.a.d.f.b(view) == 0 && d.b.g0.m.a.d.f.c(view) && P(animation);
    }

    public static int m0(int i, boolean z2) {
        if (i == 4097) {
            return z2 ? 1 : 2;
        } else if (i == 4099) {
            return z2 ? 5 : 6;
        } else if (i != 8194) {
            return -1;
        } else {
            return z2 ? 3 : 4;
        }
    }

    public void A() {
        this.q = false;
        R(4, false);
    }

    public void B() {
        this.q = true;
        R(3, false);
    }

    public void C(Runnable runnable, boolean z2) {
        if (!z2) {
            k();
        }
        synchronized (this) {
            if (!this.r && this.m != null) {
                if (this.f49102a == null) {
                    this.f49102a = new ArrayList<>();
                }
                this.f49102a.add(runnable);
                if (this.f49102a.size() == 1) {
                    this.m.j().removeCallbacks(this.w);
                    this.m.j().post(this.w);
                }
            } else {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
        r6.f49104c = true;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r3 >= r2) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
        r6.f49103b[r3].run();
        r6.f49103b[r3] = null;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean D() {
        p pVar;
        if (!this.f49104c) {
            if (Looper.myLooper() == this.m.j().getLooper()) {
                boolean z2 = false;
                while (true) {
                    synchronized (this) {
                        if (this.f49102a == null || this.f49102a.size() == 0) {
                            break;
                        }
                        int size = this.f49102a.size();
                        if (this.f49103b == null || this.f49103b.length < size) {
                            this.f49103b = new Runnable[size];
                        }
                        this.f49102a.toArray(this.f49103b);
                        this.f49102a.clear();
                        this.m.j().removeCallbacks(this.w);
                    }
                    this.f49104c = false;
                    z2 = true;
                }
                if (this.t) {
                    boolean z3 = false;
                    for (int i = 0; i < this.f49105d.size(); i++) {
                        Fragment fragment = this.f49105d.get(i);
                        if (fragment != null && (pVar = fragment.Q) != null) {
                            z3 |= pVar.j();
                        }
                    }
                    if (!z3) {
                        this.t = false;
                        k0();
                    }
                }
                return z2;
            }
            throw new IllegalStateException("Must be called from main thread of process");
        }
        throw new IllegalStateException("Recursive entry to executePendingTransactions");
    }

    public Fragment E(int i) {
        ArrayList<Fragment> arrayList = this.f49106e;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f49106e.get(size);
                if (fragment != null && fragment.A == i) {
                    return fragment;
                }
            }
        }
        ArrayList<Fragment> arrayList2 = this.f49105d;
        if (arrayList2 != null) {
            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f49105d.get(size2);
                if (fragment2 != null && fragment2.A == i) {
                    return fragment2;
                }
            }
            return null;
        }
        return null;
    }

    public Fragment F(String str) {
        ArrayList<Fragment> arrayList = this.f49106e;
        if (arrayList != null && str != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f49106e.get(size);
                if (fragment != null && str.equals(fragment.C)) {
                    return fragment;
                }
            }
        }
        ArrayList<Fragment> arrayList2 = this.f49105d;
        if (arrayList2 == null || str == null) {
            return null;
        }
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            Fragment fragment2 = this.f49105d.get(size2);
            if (fragment2 != null && str.equals(fragment2.C)) {
                return fragment2;
            }
        }
        return null;
    }

    public void G(int i) {
        synchronized (this) {
            this.i.set(i, null);
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            if (x) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.j.add(Integer.valueOf(i));
        }
    }

    public Fragment H(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i < this.f49105d.size()) {
            Fragment fragment = this.f49105d.get(i);
            if (fragment != null) {
                return fragment;
            }
            l0(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
            throw null;
        }
        l0(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        throw null;
    }

    public d.b.g0.m.a.d.e I() {
        return this;
    }

    public void J(Fragment fragment, int i, int i2) {
        if (x) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.D) {
            return;
        }
        fragment.D = true;
        if (fragment.M != null) {
            Animation K = K(fragment, i, false, i2);
            if (K != null) {
                h0(fragment.M, K);
                fragment.M.startAnimation(K);
            }
            fragment.M.setVisibility(8);
        }
        if (fragment.p && fragment.H && fragment.I) {
            this.p = true;
        }
        fragment.z0(true);
    }

    public Animation K(Fragment fragment, int i, boolean z2, int i2) {
        int m0;
        Animation loadAnimation;
        Animation t0 = fragment.t0(i, z2, fragment.K);
        if (t0 != null) {
            return t0;
        }
        if (fragment.K == 0 || (loadAnimation = AnimationUtils.loadAnimation(this.m.h(), fragment.K)) == null) {
            if (i != 0 && (m0 = m0(i, z2)) >= 0) {
                switch (m0) {
                    case 1:
                        return O(this.m.h(), 1.125f, 1.0f, 0.0f, 1.0f);
                    case 2:
                        return O(this.m.h(), 1.0f, 0.975f, 1.0f, 0.0f);
                    case 3:
                        return O(this.m.h(), 0.975f, 1.0f, 0.0f, 1.0f);
                    case 4:
                        return O(this.m.h(), 1.0f, 1.075f, 1.0f, 0.0f);
                    case 5:
                        return M(this.m.h(), 0.0f, 1.0f);
                    case 6:
                        return M(this.m.h(), 1.0f, 0.0f);
                    default:
                        if (i2 == 0 && this.m.r()) {
                            i2 = this.m.q();
                        }
                        if (i2 == 0) {
                        }
                        return null;
                }
            }
            return null;
        }
        return loadAnimation;
    }

    public void L(Fragment fragment) {
        if (fragment.j >= 0) {
            return;
        }
        ArrayList<Integer> arrayList = this.f49107f;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<Integer> arrayList2 = this.f49107f;
            fragment.e1(arrayList2.remove(arrayList2.size() - 1).intValue(), this.o);
            this.f49105d.set(fragment.j, fragment);
        } else {
            if (this.f49105d == null) {
                this.f49105d = new ArrayList<>();
            }
            fragment.e1(this.f49105d.size(), this.o);
            this.f49105d.add(fragment);
        }
        if (x) {
            Log.v("FragmentManager", "Allocated fragment index " + fragment);
        }
    }

    public void N(Fragment fragment) {
        if (fragment.j < 0) {
            return;
        }
        if (x) {
            Log.v("FragmentManager", "Freeing fragment index " + fragment);
        }
        this.f49105d.set(fragment.j, null);
        if (this.f49107f == null) {
            this.f49107f = new ArrayList<>();
        }
        this.f49107f.add(Integer.valueOf(fragment.j));
        this.m.m(fragment.k);
        fragment.X();
    }

    public void Q(int i, int i2, int i3, boolean z2) {
        j jVar;
        if (this.m == null && i != 0) {
            throw new IllegalStateException("No host");
        }
        if (z2 || this.l != i) {
            this.l = i;
            if (this.f49105d != null) {
                boolean z3 = false;
                for (int i4 = 0; i4 < this.f49105d.size(); i4++) {
                    Fragment fragment = this.f49105d.get(i4);
                    if (fragment != null) {
                        T(fragment, i, i2, i3, false);
                        p pVar = fragment.Q;
                        if (pVar != null) {
                            z3 |= pVar.j();
                        }
                    }
                }
                if (!z3) {
                    k0();
                }
                if (this.p && (jVar = this.m) != null && this.l == 5) {
                    jVar.u();
                    this.p = false;
                }
            }
        }
    }

    public void R(int i, boolean z2) {
        Q(i, 0, 0, z2);
    }

    public void S(Fragment fragment) {
        T(fragment, this.l, 0, 0, false);
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
    public void T(Fragment fragment, int i, int i2, int i3, boolean z2) {
        int i4;
        View view;
        String str;
        String str2;
        boolean z3;
        l i5;
        ?? r14;
        ViewGroup viewGroup;
        int i6;
        int i7 = 1;
        if (!fragment.p || fragment.E) {
            i4 = i;
            if (i4 > 1) {
                i4 = 1;
            }
        } else {
            i4 = i;
        }
        if (fragment.q && i4 > (i6 = fragment.f13031e)) {
            i4 = i6;
        }
        int i8 = (!fragment.O || fragment.f13031e >= 4 || i4 <= 3) ? i4 : 3;
        int i9 = fragment.f13031e;
        if (i9 < i8) {
            if (fragment.s && !fragment.t) {
                return;
            }
            if (fragment.f13032f != null) {
                fragment.f13032f = null;
                str = "FragmentManager";
                T(fragment, fragment.f13033g, 0, 0, true);
            } else {
                str = "FragmentManager";
            }
            int i10 = fragment.f13031e;
            if (i10 == 0) {
                if (x) {
                    str2 = str;
                    Log.v(str2, "moveto CREATED: " + fragment);
                } else {
                    str2 = str;
                }
                Bundle bundle = fragment.f13034h;
                if (bundle != null) {
                    bundle.setClassLoader(this.m.h().getClassLoader());
                    fragment.i = fragment.f13034h.getSparseParcelableArray(FragmentManagerImpl.VIEW_STATE_TAG);
                    Fragment H = H(fragment.f13034h, FragmentManagerImpl.TARGET_STATE_TAG);
                    fragment.m = H;
                    if (H != null) {
                        z3 = false;
                        fragment.o = fragment.f13034h.getInt(FragmentManagerImpl.TARGET_REQUEST_CODE_STATE_TAG, 0);
                    } else {
                        z3 = false;
                    }
                    boolean z4 = fragment.f13034h.getBoolean(FragmentManagerImpl.USER_VISIBLE_HINT_TAG, true);
                    fragment.P = z4;
                    if (!z4) {
                        fragment.O = true;
                        if (i8 > 3) {
                            i8 = 3;
                        }
                    }
                } else {
                    z3 = false;
                }
                j jVar = this.m;
                fragment.x = jVar;
                Fragment fragment2 = this.o;
                fragment.z = fragment2;
                if (fragment2 != null) {
                    i5 = fragment2.y;
                } else {
                    i5 = jVar.i();
                }
                fragment.w = i5;
                fragment.J = z3;
                fragment.r0(this.m.h());
                if (fragment.J) {
                    if (fragment.z == null) {
                        this.m.n(fragment);
                    }
                    if (!fragment.G) {
                        fragment.M0(fragment.f13034h);
                    }
                    fragment.G = z3;
                    if (fragment.s) {
                        r14 = 0;
                        r14 = 0;
                        View O0 = fragment.O0(fragment.q(fragment.f13034h), null, fragment.f13034h);
                        fragment.M = O0;
                        if (O0 != null) {
                            fragment.N = O0;
                            if (Build.VERSION.SDK_INT >= 11) {
                                d.b.g0.m.a.d.f.e(O0, z3);
                            } else {
                                fragment.M = q.a(O0);
                            }
                            if (fragment.D) {
                                fragment.M.setVisibility(8);
                            }
                            fragment.H0(fragment.M, fragment.f13034h);
                        } else {
                            fragment.N = null;
                        }
                        if (i8 > 1) {
                            if (x) {
                                Log.v(str2, "moveto ACTIVITY_CREATED: " + fragment);
                            }
                            if (!fragment.s) {
                                int i11 = fragment.B;
                                if (i11 != 0) {
                                    viewGroup = (ViewGroup) this.n.a(i11);
                                    if (viewGroup == null && !fragment.u) {
                                        l0(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.B) + " (" + fragment.u().getResourceName(fragment.B) + ") for fragment " + fragment));
                                        throw r14;
                                    }
                                } else {
                                    viewGroup = r14;
                                }
                                fragment.L = viewGroup;
                                View O02 = fragment.O0(fragment.q(fragment.f13034h), viewGroup, fragment.f13034h);
                                fragment.M = O02;
                                if (O02 != null) {
                                    fragment.N = O02;
                                    if (Build.VERSION.SDK_INT >= 11) {
                                        d.b.g0.m.a.d.f.e(O02, z3);
                                    } else {
                                        fragment.M = q.a(O02);
                                    }
                                    if (viewGroup != null) {
                                        Animation K = K(fragment, i2, true, i3);
                                        if (K != null) {
                                            h0(fragment.M, K);
                                            fragment.M.startAnimation(K);
                                        }
                                        viewGroup.addView(fragment.M);
                                    }
                                    if (fragment.D) {
                                        fragment.M.setVisibility(8);
                                    }
                                    fragment.H0(fragment.M, fragment.f13034h);
                                } else {
                                    fragment.N = r14;
                                }
                            }
                            fragment.J0(fragment.f13034h);
                            if (fragment.M != null) {
                                fragment.c1(fragment.f13034h);
                            }
                            fragment.f13034h = r14;
                        }
                        if (i8 > 3) {
                        }
                        if (i8 > 4) {
                        }
                    }
                } else {
                    throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onAttach()");
                }
            } else if (i10 == 1) {
                str2 = str;
                z3 = false;
            } else if (i10 == 2 || i10 == 3) {
                str2 = str;
                r14 = 0;
                if (i8 > 3) {
                    if (x) {
                        Log.v(str2, "moveto STARTED: " + fragment);
                    }
                    fragment.Z0();
                }
                if (i8 > 4) {
                    if (x) {
                        Log.v(str2, "moveto RESUMED: " + fragment);
                    }
                    fragment.r = true;
                    fragment.X0();
                    fragment.f13034h = r14;
                    fragment.i = r14;
                }
            } else if (i10 == 4) {
                str2 = str;
                r14 = 0;
                if (i8 > 4) {
                }
            }
            r14 = 0;
            if (i8 > 1) {
            }
            if (i8 > 3) {
            }
            if (i8 > 4) {
            }
        } else if (i9 > i8) {
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 != 3) {
                        if (i9 != 4) {
                            if (i9 == 5) {
                                if (i8 < 5) {
                                    if (x) {
                                        Log.v("FragmentManager", "movefrom RESUMED: " + fragment);
                                    }
                                    fragment.U0();
                                    fragment.r = false;
                                }
                            }
                        }
                        if (i8 < 4) {
                            if (x) {
                                Log.v("FragmentManager", "movefrom STARTED: " + fragment);
                            }
                            fragment.a1();
                        }
                    }
                    if (i8 < 3) {
                        if (x) {
                            Log.v("FragmentManager", "movefrom STOPPED: " + fragment);
                        }
                        fragment.W0();
                    }
                }
                if (i8 < 2) {
                    if (x) {
                        Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                    }
                    if (fragment.M != null && this.m.t(fragment) && fragment.i == null) {
                        f0(fragment);
                    }
                    fragment.Q0();
                    if (fragment.M != null && fragment.L != null) {
                        Animation K2 = (this.l <= 0 || this.r) ? null : K(fragment, i2, false, i3);
                        if (K2 != null) {
                            View view2 = fragment.M;
                            fragment.f13032f = view2;
                            fragment.f13033g = i8;
                            K2.setAnimationListener(new b(view2, K2, fragment));
                            fragment.M.startAnimation(K2);
                        }
                        fragment.L.removeView(fragment.M);
                    }
                    fragment.L = null;
                    fragment.M = null;
                    fragment.N = null;
                }
            }
            if (i8 < 1) {
                if (this.r && (view = fragment.f13032f) != null) {
                    fragment.f13032f = null;
                    view.clearAnimation();
                }
                if (fragment.f13032f != null) {
                    fragment.f13033g = i8;
                    fragment.f13031e = i7;
                }
                if (x) {
                    Log.v("FragmentManager", "movefrom CREATED: " + fragment);
                }
                if (!fragment.G) {
                    fragment.P0();
                }
                fragment.J = false;
                fragment.y0();
                if (!fragment.J) {
                    throw new SuperNotCalledException("Fragment " + fragment + " did not call through to super.onDetach()");
                } else if (!z2) {
                    if (!fragment.G) {
                        N(fragment);
                    } else {
                        fragment.x = null;
                        fragment.z = null;
                        fragment.w = null;
                        fragment.y = null;
                    }
                }
            }
        }
        i7 = i8;
        fragment.f13031e = i7;
    }

    public void U() {
        this.q = false;
    }

    public void V(Fragment fragment) {
        if (fragment.O) {
            if (this.f49104c) {
                this.t = true;
                return;
            }
            fragment.O = false;
            T(fragment, this.l, 0, 0, false);
        }
    }

    public boolean W(Handler handler, String str, int i, int i2) {
        int size;
        ArrayList<e> arrayList = this.f49108g;
        if (arrayList == null) {
            return false;
        }
        e.C1025e c1025e = null;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size2 = arrayList.size() - 1;
            if (size2 < 0) {
                return false;
            }
            e remove = this.f49108g.remove(size2);
            SparseArray<Fragment> sparseArray = new SparseArray<>();
            SparseArray<Fragment> sparseArray2 = new SparseArray<>();
            remove.p(sparseArray, sparseArray2);
            remove.H(true, null, sparseArray, sparseArray2);
            Z();
        } else {
            if (str != null || i >= 0) {
                size = this.f49108g.size() - 1;
                while (size >= 0) {
                    e eVar = this.f49108g.get(size);
                    if ((str != null && str.equals(eVar.D())) || (i >= 0 && i == eVar.r)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        e eVar2 = this.f49108g.get(size);
                        if (str == null || !str.equals(eVar2.D())) {
                            if (i < 0 || i != eVar2.r) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.f49108g.size() - 1) {
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int size3 = this.f49108g.size() - 1; size3 > size; size3--) {
                arrayList2.add(this.f49108g.remove(size3));
            }
            int size4 = arrayList2.size() - 1;
            SparseArray<Fragment> sparseArray3 = new SparseArray<>();
            SparseArray<Fragment> sparseArray4 = new SparseArray<>();
            for (int i3 = 0; i3 <= size4; i3++) {
                ((e) arrayList2.get(i3)).p(sparseArray3, sparseArray4);
            }
            int i4 = 0;
            while (i4 <= size4) {
                if (x) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList2.get(i4));
                }
                c1025e = ((e) arrayList2.get(i4)).H(i4 == size4, c1025e, sparseArray3, sparseArray4);
                i4++;
            }
            Z();
        }
        return true;
    }

    public void X(Bundle bundle, String str, Fragment fragment) {
        int i = fragment.j;
        if (i >= 0) {
            bundle.putInt(str, i);
            return;
        }
        l0(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    public void Y(Fragment fragment, int i, int i2) {
        if (x) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.v);
        }
        int i3 = !fragment.m0();
        if (fragment.E && i3 == 0) {
            return;
        }
        ArrayList<Fragment> arrayList = this.f49106e;
        if (arrayList != null) {
            arrayList.remove(fragment);
        }
        if (fragment.H && fragment.I) {
            this.p = true;
        }
        fragment.p = false;
        fragment.q = true;
        T(fragment, i3 ^ 1, i, i2, false);
    }

    public void Z() {
        if (this.k != null) {
            for (int i = 0; i < this.k.size(); i++) {
                this.k.get(i).onBackStackChanged();
            }
        }
    }

    @Override // d.b.g0.m.a.a.k
    public m a() {
        return new e(this);
    }

    public void a0(Parcelable parcelable, List<Fragment> list) {
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f13041e == null) {
            return;
        }
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Fragment fragment = list.get(i);
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                }
                FragmentState fragmentState = fragmentManagerState.f13041e[fragment.j];
                fragmentState.o = fragment;
                fragment.i = null;
                fragment.v = 0;
                fragment.t = false;
                fragment.p = false;
                fragment.m = null;
                Bundle bundle = fragmentState.n;
                if (bundle != null) {
                    bundle.setClassLoader(this.m.h().getClassLoader());
                    fragment.i = fragmentState.n.getSparseParcelableArray(FragmentManagerImpl.VIEW_STATE_TAG);
                    fragment.f13034h = fragmentState.n;
                }
            }
        }
        this.f49105d = new ArrayList<>(fragmentManagerState.f13041e.length);
        ArrayList<Integer> arrayList = this.f49107f;
        if (arrayList != null) {
            arrayList.clear();
        }
        int i2 = 0;
        while (true) {
            FragmentState[] fragmentStateArr = fragmentManagerState.f13041e;
            if (i2 >= fragmentStateArr.length) {
                break;
            }
            FragmentState fragmentState2 = fragmentStateArr[i2];
            if (fragmentState2 != null) {
                Fragment a2 = fragmentState2.a(this.m, this.o);
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a2);
                }
                this.f49105d.add(a2);
                fragmentState2.o = null;
            } else {
                this.f49105d.add(null);
                if (this.f49107f == null) {
                    this.f49107f = new ArrayList<>();
                }
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                }
                this.f49107f.add(Integer.valueOf(i2));
            }
            i2++;
        }
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                Fragment fragment2 = list.get(i3);
                int i4 = fragment2.n;
                if (i4 >= 0) {
                    if (i4 < this.f49105d.size()) {
                        fragment2.m = this.f49105d.get(fragment2.n);
                    } else {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.n);
                        fragment2.m = null;
                    }
                }
            }
        }
        if (fragmentManagerState.f13042f != null) {
            this.f49106e = new ArrayList<>(fragmentManagerState.f13042f.length);
            int i5 = 0;
            while (true) {
                int[] iArr = fragmentManagerState.f13042f;
                if (i5 >= iArr.length) {
                    break;
                }
                Fragment fragment3 = this.f49105d.get(iArr[i5]);
                if (fragment3 != null) {
                    fragment3.p = true;
                    if (x) {
                        Log.v("FragmentManager", "restoreAllState: added #" + i5 + ": " + fragment3);
                    }
                    if (!this.f49106e.contains(fragment3)) {
                        this.f49106e.add(fragment3);
                        i5++;
                    } else {
                        throw new IllegalStateException("Already added!");
                    }
                } else {
                    l0(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f13042f[i5]));
                    throw null;
                }
            }
        } else {
            this.f49106e = null;
        }
        if (fragmentManagerState.f13043g != null) {
            this.f49108g = new ArrayList<>(fragmentManagerState.f13043g.length);
            int i6 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.f13043g;
                if (i6 >= backStackStateArr.length) {
                    return;
                }
                e a3 = backStackStateArr[i6].a(this);
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i6 + " (index " + a3.r + "): " + a3);
                    a3.y(GlideException.IndentedAppendable.INDENT, new PrintWriter(new d.b.g0.m.a.c.d("FragmentManager")), false);
                }
                this.f49108g.add(a3);
                int i7 = a3.r;
                if (i7 >= 0) {
                    g0(i7, a3);
                }
                i6++;
            }
        } else {
            this.f49108g = null;
        }
    }

    @Override // d.b.g0.m.a.a.k
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + "    ";
        ArrayList<Fragment> arrayList = this.f49105d;
        if (arrayList != null && (size6 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size6; i++) {
                Fragment fragment = this.f49105d.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.e(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        ArrayList<Fragment> arrayList2 = this.f49106e;
        if (arrayList2 != null && (size5 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f49106e.get(i2).toString());
            }
        }
        ArrayList<Fragment> arrayList3 = this.f49109h;
        if (arrayList3 != null && (size4 = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.f49109h.get(i3).toString());
            }
        }
        ArrayList<e> arrayList4 = this.f49108g;
        if (arrayList4 != null && (size3 = arrayList4.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                e eVar = this.f49108g.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(eVar.toString());
                eVar.x(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.i != null && (size2 = this.i.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println((e) this.i.get(i5));
                }
            }
            if (this.j != null && this.j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.j.toArray()));
            }
        }
        ArrayList<Runnable> arrayList5 = this.f49102a;
        if (arrayList5 != null && (size = arrayList5.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println((Runnable) this.f49102a.get(i6));
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
        ArrayList<Integer> arrayList6 = this.f49107f;
        if (arrayList6 == null || arrayList6.size() <= 0) {
            return;
        }
        printWriter.print(str);
        printWriter.print("  mAvailIndices: ");
        printWriter.println(Arrays.toString(this.f49107f.toArray()));
    }

    public ArrayList<Fragment> b0() {
        ArrayList<Fragment> arrayList = null;
        if (this.f49105d != null) {
            for (int i = 0; i < this.f49105d.size(); i++) {
                Fragment fragment = this.f49105d.get(i);
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

    @Override // d.b.g0.m.a.a.k
    public boolean c() {
        return D();
    }

    @Override // d.b.g0.m.a.a.k
    public List<Fragment> d() {
        return this.f49105d;
    }

    public Parcelable d0() {
        int[] iArr;
        int size;
        int size2;
        D();
        if (y) {
            this.q = true;
        }
        ArrayList<Fragment> arrayList = this.f49105d;
        BackStackState[] backStackStateArr = null;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size3 = this.f49105d.size();
        FragmentState[] fragmentStateArr = new FragmentState[size3];
        boolean z2 = false;
        for (int i = 0; i < size3; i++) {
            Fragment fragment = this.f49105d.get(i);
            if (fragment != null) {
                if (fragment.j >= 0) {
                    FragmentState fragmentState = new FragmentState(fragment);
                    fragmentStateArr[i] = fragmentState;
                    if (fragment.f13031e > 0 && fragmentState.n == null) {
                        Bundle e0 = e0(fragment);
                        fragmentState.n = e0;
                        Fragment fragment2 = fragment.m;
                        if (fragment2 != null) {
                            if (fragment2.j >= 0) {
                                if (e0 == null) {
                                    fragmentState.n = new Bundle();
                                }
                                X(fragmentState.n, FragmentManagerImpl.TARGET_STATE_TAG, fragment.m);
                                int i2 = fragment.o;
                                if (i2 != 0) {
                                    fragmentState.n.putInt(FragmentManagerImpl.TARGET_REQUEST_CODE_STATE_TAG, i2);
                                }
                            } else {
                                l0(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.m));
                                throw null;
                            }
                        }
                    } else {
                        fragmentState.n = fragment.f13034h;
                    }
                    if (x) {
                        Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.n);
                    }
                    z2 = true;
                } else {
                    l0(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.j));
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
        ArrayList<Fragment> arrayList2 = this.f49106e;
        if (arrayList2 == null || (size2 = arrayList2.size()) <= 0) {
            iArr = null;
        } else {
            iArr = new int[size2];
            for (int i3 = 0; i3 < size2; i3++) {
                iArr[i3] = this.f49106e.get(i3).j;
                if (iArr[i3] >= 0) {
                    if (x) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i3 + ": " + this.f49106e.get(i3));
                    }
                } else {
                    l0(new IllegalStateException("Failure saving state: active " + this.f49106e.get(i3) + " has cleared index: " + iArr[i3]));
                    throw null;
                }
            }
        }
        ArrayList<e> arrayList3 = this.f49108g;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i4 = 0; i4 < size; i4++) {
                backStackStateArr[i4] = new BackStackState(this.f49108g.get(i4));
                if (x) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i4 + ": " + this.f49108g.get(i4));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f13041e = fragmentStateArr;
        fragmentManagerState.f13042f = iArr;
        fragmentManagerState.f13043g = backStackStateArr;
        return fragmentManagerState;
    }

    @Override // d.b.g0.m.a.a.k
    public boolean e() {
        k();
        c();
        return W(this.m.j(), null, -1, 0);
    }

    public Bundle e0(Fragment fragment) {
        if (this.u == null) {
            this.u = new Bundle();
        }
        fragment.Y0(this.u);
        Bundle bundle = null;
        if (!this.u.isEmpty()) {
            Bundle bundle2 = this.u;
            this.u = null;
            bundle = bundle2;
        }
        if (fragment.M != null) {
            f0(fragment);
        }
        if (fragment.i != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(FragmentManagerImpl.VIEW_STATE_TAG, fragment.i);
        }
        if (!fragment.P) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(FragmentManagerImpl.USER_VISIBLE_HINT_TAG, fragment.P);
        }
        return bundle;
    }

    public void f(e eVar) {
        if (this.f49108g == null) {
            this.f49108g = new ArrayList<>();
        }
        this.f49108g.add(eVar);
        Z();
    }

    public void f0(Fragment fragment) {
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
            fragment.i = this.v;
            this.v = null;
        }
    }

    public void g(Fragment fragment, boolean z2) {
        if (this.f49106e == null) {
            this.f49106e = new ArrayList<>();
        }
        if (x) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        L(fragment);
        if (fragment.E) {
            return;
        }
        if (!this.f49106e.contains(fragment)) {
            this.f49106e.add(fragment);
            fragment.p = true;
            fragment.q = false;
            if (fragment.H && fragment.I) {
                this.p = true;
            }
            if (z2) {
                S(fragment);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void g0(int i, e eVar) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (i < size) {
                if (x) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + eVar);
                }
                this.i.set(i, eVar);
            } else {
                while (size < i) {
                    this.i.add(null);
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
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + eVar);
                }
                this.i.add(eVar);
            }
        }
    }

    public int h(e eVar) {
        synchronized (this) {
            if (this.j != null && this.j.size() > 0) {
                int intValue = this.j.remove(this.j.size() - 1).intValue();
                if (x) {
                    Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + eVar);
                }
                this.i.set(intValue, eVar);
                return intValue;
            }
            if (this.i == null) {
                this.i = new ArrayList<>();
            }
            int size = this.i.size();
            if (x) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + eVar);
            }
            this.i.add(eVar);
            return size;
        }
    }

    public final void h0(View view, Animation animation) {
        if (view == null || animation == null || !i0(view, animation)) {
            return;
        }
        animation.setAnimationListener(new c(view, animation));
    }

    public void i(j jVar, h hVar, Fragment fragment) {
        if (this.m == null) {
            this.m = jVar;
            this.n = hVar;
            this.o = fragment;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public void j(Fragment fragment, int i, int i2) {
        if (x) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.E) {
            fragment.E = false;
            if (fragment.p) {
                return;
            }
            if (this.f49106e == null) {
                this.f49106e = new ArrayList<>();
            }
            if (!this.f49106e.contains(fragment)) {
                if (x) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f49106e.add(fragment);
                fragment.p = true;
                if (fragment.H && fragment.I) {
                    this.p = true;
                }
                T(fragment, this.l, i, i2, false);
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    public void j0(Fragment fragment, int i, int i2) {
        if (x) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.D) {
            fragment.D = false;
            if (fragment.M != null) {
                Animation K = K(fragment, i, true, i2);
                if (K != null) {
                    h0(fragment.M, K);
                    fragment.M.startAnimation(K);
                }
                fragment.M.setVisibility(0);
            }
            if (fragment.p && fragment.H && fragment.I) {
                this.p = true;
            }
            fragment.z0(false);
        }
    }

    public final void k() {
        if (!this.q) {
            if (this.s == null) {
                return;
            }
            throw new IllegalStateException("Can not perform this action inside of " + this.s);
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    public void k0() {
        if (this.f49105d == null) {
            return;
        }
        for (int i = 0; i < this.f49105d.size(); i++) {
            Fragment fragment = this.f49105d.get(i);
            if (fragment != null) {
                V(fragment);
            }
        }
    }

    public void l(Fragment fragment, int i, int i2) {
        if (x) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.E) {
            return;
        }
        fragment.E = true;
        if (fragment.p) {
            if (this.f49106e != null) {
                if (x) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.f49106e.remove(fragment);
            }
            if (fragment.H && fragment.I) {
                this.p = true;
            }
            fragment.p = false;
            T(fragment, 1, i, i2, false);
        }
    }

    public final void l0(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new d.b.g0.m.a.c.d("FragmentManager"));
        j jVar = this.m;
        if (jVar != null) {
            try {
                jVar.o(GlideException.IndentedAppendable.INDENT, null, printWriter, new String[0]);
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

    public void m() {
        this.q = false;
        R(2, false);
    }

    public void n(Configuration configuration) {
        if (this.f49106e != null) {
            for (int i = 0; i < this.f49106e.size(); i++) {
                Fragment fragment = this.f49106e.get(i);
                if (fragment != null) {
                    fragment.K0(configuration);
                }
            }
        }
    }

    public boolean o(MenuItem menuItem) {
        if (this.f49106e != null) {
            for (int i = 0; i < this.f49106e.size(); i++) {
                Fragment fragment = this.f49106e.get(i);
                if (fragment != null && fragment.L0(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // d.b.g0.m.a.d.e
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, DealIntentService.KEY_CLASS);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f49117a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            String str2 = attributeValue;
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (Fragment.n0(this.m.h(), str2)) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
                }
                Fragment E = resourceId != -1 ? E(resourceId) : null;
                if (E == null && string != null) {
                    E = F(string);
                }
                if (E == null && id != -1) {
                    E = E(id);
                }
                if (x) {
                    Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + E);
                }
                if (E == null) {
                    E = Fragment.d0(context, str2);
                    E.s = true;
                    E.A = resourceId != 0 ? resourceId : id;
                    E.B = id;
                    E.C = string;
                    E.t = true;
                    E.w = this;
                    j jVar = this.m;
                    E.x = jVar;
                    E.B0(jVar.h(), attributeSet, E.f13034h);
                    g(E, true);
                } else if (!E.t) {
                    E.t = true;
                    if (!E.G) {
                        E.B0(this.m.h(), attributeSet, E.f13034h);
                    }
                } else {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
                }
                Fragment fragment = E;
                if (this.l < 1 && fragment.s) {
                    T(fragment, 1, 0, 0, false);
                } else {
                    S(fragment);
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

    public void p() {
        this.q = false;
        R(1, false);
    }

    public boolean q(Menu menu, MenuInflater menuInflater) {
        boolean z2;
        ArrayList<Fragment> arrayList = null;
        if (this.f49106e != null) {
            z2 = false;
            for (int i = 0; i < this.f49106e.size(); i++) {
                Fragment fragment = this.f49106e.get(i);
                if (fragment != null && fragment.N0(menu, menuInflater)) {
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
        if (this.f49109h != null) {
            for (int i2 = 0; i2 < this.f49109h.size(); i2++) {
                Fragment fragment2 = this.f49109h.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.w0();
                }
            }
        }
        this.f49109h = arrayList;
        return z2;
    }

    public void r() {
        this.r = true;
        D();
        R(0, false);
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public void s() {
        R(1, false);
    }

    public void t() {
        if (this.f49106e != null) {
            for (int i = 0; i < this.f49106e.size(); i++) {
                Fragment fragment = this.f49106e.get(i);
                if (fragment != null) {
                    fragment.R0();
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.o;
        if (fragment != null) {
            d.b.g0.m.a.c.c.a(fragment, sb);
        } else {
            d.b.g0.m.a.c.c.a(this.m, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    public boolean u(MenuItem menuItem) {
        if (this.f49106e != null) {
            for (int i = 0; i < this.f49106e.size(); i++) {
                Fragment fragment = this.f49106e.get(i);
                if (fragment != null && fragment.S0(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void v(Menu menu) {
        if (this.f49106e != null) {
            for (int i = 0; i < this.f49106e.size(); i++) {
                Fragment fragment = this.f49106e.get(i);
                if (fragment != null) {
                    fragment.T0(menu);
                }
            }
        }
    }

    public void w() {
        R(4, false);
    }

    public boolean x(Menu menu) {
        if (this.f49106e != null) {
            boolean z2 = false;
            for (int i = 0; i < this.f49106e.size(); i++) {
                Fragment fragment = this.f49106e.get(i);
                if (fragment != null && fragment.V0(menu)) {
                    z2 = true;
                }
            }
            return z2;
        }
        return false;
    }

    public void y() {
        R(2, false);
    }

    public void z() {
        this.q = false;
        R(5, false);
    }
}
