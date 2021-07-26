package d.a.o0.o.a.a;

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
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentStateManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.support.v4.app.BackStackState;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentManagerState;
import com.baidu.swan.support.v4.app.FragmentState;
import com.baidu.swan.support.v4.app.SuperNotCalledException;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import d.a.o0.o.a.a.e;
import d.a.o0.o.a.a.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public final class m extends l implements d.a.o0.o.a.d.e {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator A;
    public static boolean x;
    public static final boolean y;
    public static final Interpolator z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<Runnable> f51360a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable[] f51361b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51362c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Fragment> f51363d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Fragment> f51364e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Integer> f51365f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.a.o0.o.a.a.e> f51366g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Fragment> f51367h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<d.a.o0.o.a.a.e> f51368i;
    public ArrayList<Integer> j;
    public ArrayList<l.a> k;
    public int l;
    public k m;
    public i n;
    public Fragment o;
    public boolean p;
    public boolean q;
    public boolean r;
    public String s;
    public boolean t;
    public Bundle u;
    public SparseArray<Parcelable> v;
    public Runnable w;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f51369e;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51369e = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51369e.E();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f51370e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f51371f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f51372g;

        public b(m mVar, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51372g = mVar;
            this.f51370e = i2;
            this.f51371f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m mVar = this.f51372g;
                mVar.X(mVar.m.j(), null, this.f51370e, this.f51371f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Fragment f51373c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ m f51374d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(m mVar, View view, Animation animation, Fragment fragment) {
            super(view, animation);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, view, animation, fragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], (Animation) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51374d = mVar;
            this.f51373c = fragment;
        }

        @Override // d.a.o0.o.a.a.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                super.onAnimationEnd(animation);
                Fragment fragment = this.f51373c;
                if (fragment.f12099f != null) {
                    fragment.f12099f = null;
                    this.f51374d.U(fragment, fragment.f12100g, 0, 0, false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f51375a;

        /* renamed from: b  reason: collision with root package name */
        public View f51376b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f51377e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f51377e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.o0.o.a.d.f.d(this.f51377e.f51376b, 2, null);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f51378e;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f51378e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.o0.o.a.d.f.d(this.f51378e.f51376b, 0, null);
                }
            }
        }

        public d(View view, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51375a = false;
            if (view == null || animation == null) {
                return;
            }
            this.f51376b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        @CallSuper
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.f51375a) {
                this.f51376b.post(new b(this));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        @CallSuper
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                boolean j0 = m.j0(this.f51376b, animation);
                this.f51375a = j0;
                if (j0) {
                    this.f51376b.post(new a(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f51379a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-592030318, "Ld/a/o0/o/a/a/m$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-592030318, "Ld/a/o0/o/a/a/m$e;");
                    return;
                }
            }
            f51379a = new int[]{16842755, 16842960, 16842961};
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1353572403, "Ld/a/o0/o/a/a/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1353572403, "Ld/a/o0/o/a/a/m;");
                return;
            }
        }
        y = Build.VERSION.SDK_INT >= 11;
        z = new DecelerateInterpolator(2.5f);
        A = new DecelerateInterpolator(1.5f);
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.u = null;
        this.v = null;
        this.w = new a(this);
    }

    public static Animation N(Context context, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
            alphaAnimation.setInterpolator(A);
            alphaAnimation.setDuration(220L);
            return alphaAnimation;
        }
        return (Animation) invokeCommon.objValue;
    }

    public static Animation P(Context context, float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
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
        return (Animation) invokeCommon.objValue;
    }

    public static boolean Q(Animation animation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, animation)) == null) {
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
        return invokeL.booleanValue;
    }

    public static int d0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            if (i2 != 4097) {
                if (i2 != 4099) {
                    return i2 != 8194 ? 0 : 4097;
                }
                return 4099;
            }
            return 8194;
        }
        return invokeI.intValue;
    }

    public static boolean j0(View view, Animation animation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, view, animation)) == null) ? d.a.o0.o.a.d.f.b(view) == 0 && d.a.o0.o.a.d.f.c(view) && Q(animation) : invokeLL.booleanValue;
    }

    public static int n0(int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
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
        return invokeCommon.intValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.q = false;
            S(5, false);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q = false;
            S(4, false);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q = true;
            S(3, false);
        }
    }

    public void D(Runnable runnable, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, runnable, z2) == null) {
            if (!z2) {
                l();
            }
            synchronized (this) {
                if (!this.r && this.m != null) {
                    if (this.f51360a == null) {
                        this.f51360a = new ArrayList<>();
                    }
                    this.f51360a.add(runnable);
                    if (this.f51360a.size() == 1) {
                        this.m.j().removeCallbacks(this.w);
                        this.m.j().post(this.w);
                    }
                } else {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
        r6.f51362c = true;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r3 >= r2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
        r6.f51361b[r3].run();
        r6.f51361b[r3] = null;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean E() {
        InterceptResult invokeV;
        q qVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.f51362c) {
                if (Looper.myLooper() == this.m.j().getLooper()) {
                    boolean z2 = false;
                    while (true) {
                        synchronized (this) {
                            if (this.f51360a == null || this.f51360a.size() == 0) {
                                break;
                            }
                            int size = this.f51360a.size();
                            if (this.f51361b == null || this.f51361b.length < size) {
                                this.f51361b = new Runnable[size];
                            }
                            this.f51360a.toArray(this.f51361b);
                            this.f51360a.clear();
                            this.m.j().removeCallbacks(this.w);
                        }
                        this.f51362c = false;
                        z2 = true;
                    }
                    if (this.t) {
                        boolean z3 = false;
                        for (int i2 = 0; i2 < this.f51363d.size(); i2++) {
                            Fragment fragment = this.f51363d.get(i2);
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
        return invokeV.booleanValue;
    }

    public Fragment F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            ArrayList<Fragment> arrayList = this.f51364e;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment = this.f51364e.get(size);
                    if (fragment != null && fragment.A == i2) {
                        return fragment;
                    }
                }
            }
            ArrayList<Fragment> arrayList2 = this.f51363d;
            if (arrayList2 != null) {
                for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                    Fragment fragment2 = this.f51363d.get(size2);
                    if (fragment2 != null && fragment2.A == i2) {
                        return fragment2;
                    }
                }
                return null;
            }
            return null;
        }
        return (Fragment) invokeI.objValue;
    }

    public Fragment G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            ArrayList<Fragment> arrayList = this.f51364e;
            if (arrayList != null && str != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment = this.f51364e.get(size);
                    if (fragment != null && str.equals(fragment.C)) {
                        return fragment;
                    }
                }
            }
            ArrayList<Fragment> arrayList2 = this.f51363d;
            if (arrayList2 == null || str == null) {
                return null;
            }
            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f51363d.get(size2);
                if (fragment2 != null && str.equals(fragment2.C)) {
                    return fragment2;
                }
            }
            return null;
        }
        return (Fragment) invokeL.objValue;
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            synchronized (this) {
                this.f51368i.set(i2, null);
                if (this.j == null) {
                    this.j = new ArrayList<>();
                }
                if (x) {
                    Log.v("FragmentManager", "Freeing back stack index " + i2);
                }
                this.j.add(Integer.valueOf(i2));
            }
        }
    }

    public Fragment I(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle, str)) == null) {
            int i2 = bundle.getInt(str, -1);
            if (i2 == -1) {
                return null;
            }
            if (i2 < this.f51363d.size()) {
                Fragment fragment = this.f51363d.get(i2);
                if (fragment != null) {
                    return fragment;
                }
                m0(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
                throw null;
            }
            m0(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i2));
            throw null;
        }
        return (Fragment) invokeLL.objValue;
    }

    public d.a.o0.o.a.d.e J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (d.a.o0.o.a.d.e) invokeV.objValue;
    }

    public void K(Fragment fragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, fragment, i2, i3) == null) {
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
    }

    public Animation L(Fragment fragment, int i2, boolean z2, int i3) {
        InterceptResult invokeCommon;
        int n0;
        Animation loadAnimation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{fragment, Integer.valueOf(i2), Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
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
        return (Animation) invokeCommon.objValue;
    }

    public void M(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, fragment) == null) || fragment.j >= 0) {
            return;
        }
        ArrayList<Integer> arrayList = this.f51365f;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<Integer> arrayList2 = this.f51365f;
            fragment.k1(arrayList2.remove(arrayList2.size() - 1).intValue(), this.o);
            this.f51363d.set(fragment.j, fragment);
        } else {
            if (this.f51363d == null) {
                this.f51363d = new ArrayList<>();
            }
            fragment.k1(this.f51363d.size(), this.o);
            this.f51363d.add(fragment);
        }
        if (x) {
            Log.v("FragmentManager", "Allocated fragment index " + fragment);
        }
    }

    public void O(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, fragment) == null) || fragment.j < 0) {
            return;
        }
        if (x) {
            Log.v("FragmentManager", "Freeing fragment index " + fragment);
        }
        this.f51363d.set(fragment.j, null);
        if (this.f51365f == null) {
            this.f51365f = new ArrayList<>();
        }
        this.f51365f.add(Integer.valueOf(fragment.j));
        this.m.m(fragment.k);
        fragment.c0();
    }

    public void R(int i2, int i3, int i4, boolean z2) {
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            if (this.m == null && i2 != 0) {
                throw new IllegalStateException("No host");
            }
            if (z2 || this.l != i2) {
                this.l = i2;
                if (this.f51363d != null) {
                    boolean z3 = false;
                    for (int i5 = 0; i5 < this.f51363d.size(); i5++) {
                        Fragment fragment = this.f51363d.get(i5);
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
    }

    public void S(int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            R(i2, 0, 0, z2);
        }
    }

    public void T(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fragment) == null) {
            U(fragment, this.l, 0, 0, false);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:124:0x0226 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x015e */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0160  */
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{fragment, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            int i8 = 1;
            if (!fragment.p || fragment.E) {
                i5 = i2;
                if (i5 > 1) {
                    i5 = 1;
                }
            } else {
                i5 = i2;
            }
            if (fragment.q && i5 > (i7 = fragment.f12098e)) {
                i5 = i7;
            }
            int i9 = (!fragment.O || fragment.f12098e >= 4 || i5 <= 3) ? i5 : 3;
            int i10 = fragment.f12098e;
            if (i10 < i9) {
                if (fragment.s && !fragment.t) {
                    return;
                }
                if (fragment.f12099f != null) {
                    fragment.f12099f = null;
                    str = "FragmentManager";
                    U(fragment, fragment.f12100g, 0, 0, true);
                } else {
                    str = "FragmentManager";
                }
                int i11 = fragment.f12098e;
                if (i11 == 0) {
                    if (x) {
                        str2 = str;
                        Log.v(str2, "moveto CREATED: " + fragment);
                    } else {
                        str2 = str;
                    }
                    Bundle bundle = fragment.f12101h;
                    if (bundle != null) {
                        bundle.setClassLoader(this.m.h().getClassLoader());
                        fragment.f12102i = fragment.f12101h.getSparseParcelableArray(FragmentStateManager.VIEW_STATE_TAG);
                        Fragment I = I(fragment.f12101h, FragmentStateManager.TARGET_STATE_TAG);
                        fragment.m = I;
                        if (I != null) {
                            z3 = false;
                            fragment.o = fragment.f12101h.getInt(FragmentStateManager.TARGET_REQUEST_CODE_STATE_TAG, 0);
                        } else {
                            z3 = false;
                        }
                        boolean z4 = fragment.f12101h.getBoolean(FragmentStateManager.USER_VISIBLE_HINT_TAG, true);
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
                    fragment.w0(this.m.h());
                    if (fragment.J) {
                        if (fragment.z == null) {
                            this.m.n(fragment);
                        }
                        if (!fragment.G) {
                            fragment.S0(fragment.f12101h);
                        }
                        fragment.G = z3;
                        if (fragment.s) {
                            r14 = 0;
                            r14 = 0;
                            View U0 = fragment.U0(fragment.v(fragment.f12101h), null, fragment.f12101h);
                            fragment.M = U0;
                            if (U0 != null) {
                                fragment.N = U0;
                                if (Build.VERSION.SDK_INT >= 11) {
                                    d.a.o0.o.a.d.f.e(U0, z3);
                                } else {
                                    fragment.M = r.a(U0);
                                }
                                if (fragment.D) {
                                    fragment.M.setVisibility(8);
                                }
                                fragment.N0(fragment.M, fragment.f12101h);
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
                                    View U02 = fragment.U0(fragment.v(fragment.f12101h), viewGroup, fragment.f12101h);
                                    fragment.M = U02;
                                    if (U02 != null) {
                                        fragment.N = U02;
                                        if (Build.VERSION.SDK_INT >= 11) {
                                            d.a.o0.o.a.d.f.e(U02, z3);
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
                                        fragment.N0(fragment.M, fragment.f12101h);
                                    } else {
                                        fragment.N = r14;
                                    }
                                }
                                fragment.P0(fragment.f12101h);
                                if (fragment.M != null) {
                                    fragment.i1(fragment.f12101h);
                                }
                                fragment.f12101h = r14;
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
                        fragment.f12101h = r14;
                        fragment.f12102i = r14;
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
                        if (fragment.M != null && this.m.t(fragment) && fragment.f12102i == null) {
                            g0(fragment);
                        }
                        fragment.W0();
                        if (fragment.M != null && fragment.L != null) {
                            Animation L2 = (this.l <= 0 || this.r) ? null : L(fragment, i3, false, i4);
                            if (L2 != null) {
                                View view2 = fragment.M;
                                fragment.f12099f = view2;
                                fragment.f12100g = i9;
                                L2.setAnimationListener(new c(this, view2, L2, fragment));
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
                    if (this.r && (view = fragment.f12099f) != null) {
                        fragment.f12099f = null;
                        view.clearAnimation();
                    }
                    if (fragment.f12099f != null) {
                        fragment.f12100g = i9;
                        fragment.f12098e = i8;
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
            fragment.f12098e = i8;
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.q = false;
        }
    }

    public void W(Fragment fragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, fragment) == null) && fragment.O) {
            if (this.f51362c) {
                this.t = true;
                return;
            }
            fragment.O = false;
            U(fragment, this.l, 0, 0, false);
        }
    }

    public boolean X(Handler handler, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048596, this, handler, str, i2, i3)) == null) {
            ArrayList<d.a.o0.o.a.a.e> arrayList = this.f51366g;
            if (arrayList == null) {
                return false;
            }
            e.C1158e c1158e = null;
            if (str == null && i2 < 0 && (i3 & 1) == 0) {
                int size2 = arrayList.size() - 1;
                if (size2 < 0) {
                    return false;
                }
                d.a.o0.o.a.a.e remove = this.f51366g.remove(size2);
                SparseArray<Fragment> sparseArray = new SparseArray<>();
                SparseArray<Fragment> sparseArray2 = new SparseArray<>();
                remove.q(sparseArray, sparseArray2);
                remove.I(true, null, sparseArray, sparseArray2);
                a0();
            } else {
                if (str != null || i2 >= 0) {
                    size = this.f51366g.size() - 1;
                    while (size >= 0) {
                        d.a.o0.o.a.a.e eVar = this.f51366g.get(size);
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
                            d.a.o0.o.a.a.e eVar2 = this.f51366g.get(size);
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
                if (size == this.f51366g.size() - 1) {
                    return false;
                }
                ArrayList arrayList2 = new ArrayList();
                for (int size3 = this.f51366g.size() - 1; size3 > size; size3--) {
                    arrayList2.add(this.f51366g.remove(size3));
                }
                int size4 = arrayList2.size() - 1;
                SparseArray<Fragment> sparseArray3 = new SparseArray<>();
                SparseArray<Fragment> sparseArray4 = new SparseArray<>();
                for (int i4 = 0; i4 <= size4; i4++) {
                    ((d.a.o0.o.a.a.e) arrayList2.get(i4)).q(sparseArray3, sparseArray4);
                }
                int i5 = 0;
                while (i5 <= size4) {
                    if (x) {
                        Log.v("FragmentManager", "Popping back stack state: " + arrayList2.get(i5));
                    }
                    c1158e = ((d.a.o0.o.a.a.e) arrayList2.get(i5)).I(i5 == size4, c1158e, sparseArray3, sparseArray4);
                    i5++;
                }
                a0();
            }
            return true;
        }
        return invokeLLII.booleanValue;
    }

    public void Y(Bundle bundle, String str, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, bundle, str, fragment) == null) {
            int i2 = fragment.j;
            if (i2 >= 0) {
                bundle.putInt(str, i2);
                return;
            }
            m0(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
            throw null;
        }
    }

    public void Z(Fragment fragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048598, this, fragment, i2, i3) == null) {
            if (x) {
                Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.v);
            }
            int i4 = !fragment.o0();
            if (fragment.E && i4 == 0) {
                return;
            }
            ArrayList<Fragment> arrayList = this.f51364e;
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
    }

    @Override // d.a.o0.o.a.a.l
    public n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? new d.a.o0.o.a.a.e(this) : (n) invokeV.objValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.k == null) {
            return;
        }
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            this.k.get(i2).onBackStackChanged();
        }
    }

    @Override // d.a.o0.o.a.a.l
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048601, this, str, fileDescriptor, printWriter, strArr) == null) {
            String str2 = str + "    ";
            ArrayList<Fragment> arrayList = this.f51363d;
            if (arrayList != null && (size6 = arrayList.size()) > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (int i2 = 0; i2 < size6; i2++) {
                    Fragment fragment = this.f51363d.get(i2);
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
            ArrayList<Fragment> arrayList2 = this.f51364e;
            if (arrayList2 != null && (size5 = arrayList2.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (int i3 = 0; i3 < size5; i3++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(this.f51364e.get(i3).toString());
                }
            }
            ArrayList<Fragment> arrayList3 = this.f51367h;
            if (arrayList3 != null && (size4 = arrayList3.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (int i4 = 0; i4 < size4; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(this.f51367h.get(i4).toString());
                }
            }
            ArrayList<d.a.o0.o.a.a.e> arrayList4 = this.f51366g;
            if (arrayList4 != null && (size3 = arrayList4.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (int i5 = 0; i5 < size3; i5++) {
                    d.a.o0.o.a.a.e eVar = this.f51366g.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(eVar.toString());
                    eVar.y(str2, fileDescriptor, printWriter, strArr);
                }
            }
            synchronized (this) {
                if (this.f51368i != null && (size2 = this.f51368i.size()) > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i6 = 0; i6 < size2; i6++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i6);
                        printWriter.print(": ");
                        printWriter.println((d.a.o0.o.a.a.e) this.f51368i.get(i6));
                    }
                }
                if (this.j != null && this.j.size() > 0) {
                    printWriter.print(str);
                    printWriter.print("mAvailBackStackIndices: ");
                    printWriter.println(Arrays.toString(this.j.toArray()));
                }
            }
            ArrayList<Runnable> arrayList5 = this.f51360a;
            if (arrayList5 != null && (size = arrayList5.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i7 = 0; i7 < size; i7++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i7);
                    printWriter.print(": ");
                    printWriter.println((Runnable) this.f51360a.get(i7));
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
            ArrayList<Integer> arrayList6 = this.f51365f;
            if (arrayList6 == null || arrayList6.size() <= 0) {
                return;
            }
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f51365f.toArray()));
        }
    }

    public void b0(Parcelable parcelable, List<Fragment> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, parcelable, list) == null) || parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                Fragment fragment = list.get(i2);
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                }
                FragmentState fragmentState = fragmentManagerState.mActive[fragment.j];
                fragmentState.mInstance = fragment;
                fragment.f12102i = null;
                fragment.v = 0;
                fragment.t = false;
                fragment.p = false;
                fragment.m = null;
                Bundle bundle = fragmentState.mSavedFragmentState;
                if (bundle != null) {
                    bundle.setClassLoader(this.m.h().getClassLoader());
                    fragment.f12102i = fragmentState.mSavedFragmentState.getSparseParcelableArray(FragmentStateManager.VIEW_STATE_TAG);
                    fragment.f12101h = fragmentState.mSavedFragmentState;
                }
            }
        }
        this.f51363d = new ArrayList<>(fragmentManagerState.mActive.length);
        ArrayList<Integer> arrayList = this.f51365f;
        if (arrayList != null) {
            arrayList.clear();
        }
        int i3 = 0;
        while (true) {
            FragmentState[] fragmentStateArr = fragmentManagerState.mActive;
            if (i3 >= fragmentStateArr.length) {
                break;
            }
            FragmentState fragmentState2 = fragmentStateArr[i3];
            if (fragmentState2 != null) {
                Fragment instantiate = fragmentState2.instantiate(this.m, this.o);
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: active #" + i3 + ": " + instantiate);
                }
                this.f51363d.add(instantiate);
                fragmentState2.mInstance = null;
            } else {
                this.f51363d.add(null);
                if (this.f51365f == null) {
                    this.f51365f = new ArrayList<>();
                }
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: avail #" + i3);
                }
                this.f51365f.add(Integer.valueOf(i3));
            }
            i3++;
        }
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                Fragment fragment2 = list.get(i4);
                int i5 = fragment2.n;
                if (i5 >= 0) {
                    if (i5 < this.f51363d.size()) {
                        fragment2.m = this.f51363d.get(fragment2.n);
                    } else {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.n);
                        fragment2.m = null;
                    }
                }
            }
        }
        if (fragmentManagerState.mAdded != null) {
            this.f51364e = new ArrayList<>(fragmentManagerState.mAdded.length);
            int i6 = 0;
            while (true) {
                int[] iArr = fragmentManagerState.mAdded;
                if (i6 >= iArr.length) {
                    break;
                }
                Fragment fragment3 = this.f51363d.get(iArr[i6]);
                if (fragment3 != null) {
                    fragment3.p = true;
                    if (x) {
                        Log.v("FragmentManager", "restoreAllState: added #" + i6 + ": " + fragment3);
                    }
                    if (!this.f51364e.contains(fragment3)) {
                        this.f51364e.add(fragment3);
                        i6++;
                    } else {
                        throw new IllegalStateException("Already added!");
                    }
                } else {
                    m0(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[i6]));
                    throw null;
                }
            }
        } else {
            this.f51364e = null;
        }
        if (fragmentManagerState.mBackStack != null) {
            this.f51366g = new ArrayList<>(fragmentManagerState.mBackStack.length);
            int i7 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.mBackStack;
                if (i7 >= backStackStateArr.length) {
                    return;
                }
                d.a.o0.o.a.a.e instantiate2 = backStackStateArr[i7].instantiate(this);
                if (x) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i7 + " (index " + instantiate2.r + "): " + instantiate2);
                    instantiate2.z(GlideException.IndentedAppendable.INDENT, new PrintWriter(new d.a.o0.o.a.c.d("FragmentManager")), false);
                }
                this.f51366g.add(instantiate2);
                int i8 = instantiate2.r;
                if (i8 >= 0) {
                    h0(i8, instantiate2);
                }
                i7++;
            }
        } else {
            this.f51366g = null;
        }
    }

    @Override // d.a.o0.o.a.a.l
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? E() : invokeV.booleanValue;
    }

    public ArrayList<Fragment> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ArrayList<Fragment> arrayList = null;
            if (this.f51363d != null) {
                for (int i2 = 0; i2 < this.f51363d.size(); i2++) {
                    Fragment fragment = this.f51363d.get(i2);
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
        return (ArrayList) invokeV.objValue;
    }

    @Override // d.a.o0.o.a.a.l
    public List<Fragment> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f51363d : (List) invokeV.objValue;
    }

    @Override // d.a.o0.o.a.a.l
    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048606, this, i2, i3) == null) {
            if (i2 >= 0) {
                D(new b(this, i2, i3), false);
                return;
            }
            throw new IllegalArgumentException("Bad id: " + i2);
        }
    }

    public Parcelable e0() {
        InterceptResult invokeV;
        int[] iArr;
        int size;
        int size2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            E();
            if (y) {
                this.q = true;
            }
            ArrayList<Fragment> arrayList = this.f51363d;
            BackStackState[] backStackStateArr = null;
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            int size3 = this.f51363d.size();
            FragmentState[] fragmentStateArr = new FragmentState[size3];
            boolean z2 = false;
            for (int i2 = 0; i2 < size3; i2++) {
                Fragment fragment = this.f51363d.get(i2);
                if (fragment != null) {
                    if (fragment.j >= 0) {
                        FragmentState fragmentState = new FragmentState(fragment);
                        fragmentStateArr[i2] = fragmentState;
                        if (fragment.f12098e > 0 && fragmentState.mSavedFragmentState == null) {
                            Bundle f0 = f0(fragment);
                            fragmentState.mSavedFragmentState = f0;
                            Fragment fragment2 = fragment.m;
                            if (fragment2 != null) {
                                if (fragment2.j >= 0) {
                                    if (f0 == null) {
                                        fragmentState.mSavedFragmentState = new Bundle();
                                    }
                                    Y(fragmentState.mSavedFragmentState, FragmentStateManager.TARGET_STATE_TAG, fragment.m);
                                    int i3 = fragment.o;
                                    if (i3 != 0) {
                                        fragmentState.mSavedFragmentState.putInt(FragmentStateManager.TARGET_REQUEST_CODE_STATE_TAG, i3);
                                    }
                                } else {
                                    m0(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.m));
                                    throw null;
                                }
                            }
                        } else {
                            fragmentState.mSavedFragmentState = fragment.f12101h;
                        }
                        if (x) {
                            Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.mSavedFragmentState);
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
            ArrayList<Fragment> arrayList2 = this.f51364e;
            if (arrayList2 == null || (size2 = arrayList2.size()) <= 0) {
                iArr = null;
            } else {
                iArr = new int[size2];
                for (int i4 = 0; i4 < size2; i4++) {
                    iArr[i4] = this.f51364e.get(i4).j;
                    if (iArr[i4] >= 0) {
                        if (x) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i4 + ": " + this.f51364e.get(i4));
                        }
                    } else {
                        m0(new IllegalStateException("Failure saving state: active " + this.f51364e.get(i4) + " has cleared index: " + iArr[i4]));
                        throw null;
                    }
                }
            }
            ArrayList<d.a.o0.o.a.a.e> arrayList3 = this.f51366g;
            if (arrayList3 != null && (size = arrayList3.size()) > 0) {
                backStackStateArr = new BackStackState[size];
                for (int i5 = 0; i5 < size; i5++) {
                    backStackStateArr[i5] = new BackStackState(this.f51366g.get(i5));
                    if (x) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i5 + ": " + this.f51366g.get(i5));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mActive = fragmentStateArr;
            fragmentManagerState.mAdded = iArr;
            fragmentManagerState.mBackStack = backStackStateArr;
            return fragmentManagerState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // d.a.o0.o.a.a.l
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            l();
            c();
            return X(this.m.j(), null, -1, 0);
        }
        return invokeV.booleanValue;
    }

    public Bundle f0(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, fragment)) == null) {
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
            if (fragment.f12102i != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray(FragmentStateManager.VIEW_STATE_TAG, fragment.f12102i);
            }
            if (!fragment.P) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean(FragmentStateManager.USER_VISIBLE_HINT_TAG, fragment.P);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public void g(d.a.o0.o.a.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, eVar) == null) {
            if (this.f51366g == null) {
                this.f51366g = new ArrayList<>();
            }
            this.f51366g.add(eVar);
            a0();
        }
    }

    public void g0(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, fragment) == null) || fragment.N == null) {
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
            fragment.f12102i = this.v;
            this.v = null;
        }
    }

    public void h(Fragment fragment, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048612, this, fragment, z2) == null) {
            if (this.f51364e == null) {
                this.f51364e = new ArrayList<>();
            }
            if (x) {
                Log.v("FragmentManager", "add: " + fragment);
            }
            M(fragment);
            if (fragment.E) {
                return;
            }
            if (!this.f51364e.contains(fragment)) {
                this.f51364e.add(fragment);
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
    }

    public void h0(int i2, d.a.o0.o.a.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048613, this, i2, eVar) == null) {
            synchronized (this) {
                if (this.f51368i == null) {
                    this.f51368i = new ArrayList<>();
                }
                int size = this.f51368i.size();
                if (i2 < size) {
                    if (x) {
                        Log.v("FragmentManager", "Setting back stack index " + i2 + " to " + eVar);
                    }
                    this.f51368i.set(i2, eVar);
                } else {
                    while (size < i2) {
                        this.f51368i.add(null);
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
                    this.f51368i.add(eVar);
                }
            }
        }
    }

    public int i(d.a.o0.o.a.a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, eVar)) == null) {
            synchronized (this) {
                if (this.j != null && this.j.size() > 0) {
                    int intValue = this.j.remove(this.j.size() - 1).intValue();
                    if (x) {
                        Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + eVar);
                    }
                    this.f51368i.set(intValue, eVar);
                    return intValue;
                }
                if (this.f51368i == null) {
                    this.f51368i = new ArrayList<>();
                }
                int size = this.f51368i.size();
                if (x) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + eVar);
                }
                this.f51368i.add(eVar);
                return size;
            }
        }
        return invokeL.intValue;
    }

    public final void i0(View view, Animation animation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048615, this, view, animation) == null) || view == null || animation == null || !j0(view, animation)) {
            return;
        }
        animation.setAnimationListener(new d(view, animation));
    }

    public void j(k kVar, i iVar, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048616, this, kVar, iVar, fragment) == null) {
            if (this.m == null) {
                this.m = kVar;
                this.n = iVar;
                this.o = fragment;
                return;
            }
            throw new IllegalStateException("Already attached");
        }
    }

    public void k(Fragment fragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048617, this, fragment, i2, i3) == null) {
            if (x) {
                Log.v("FragmentManager", "attach: " + fragment);
            }
            if (fragment.E) {
                fragment.E = false;
                if (fragment.p) {
                    return;
                }
                if (this.f51364e == null) {
                    this.f51364e = new ArrayList<>();
                }
                if (!this.f51364e.contains(fragment)) {
                    if (x) {
                        Log.v("FragmentManager", "add from attach: " + fragment);
                    }
                    this.f51364e.add(fragment);
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
    }

    public void k0(Fragment fragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048618, this, fragment, i2, i3) == null) {
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
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (!this.q) {
                if (this.s == null) {
                    return;
                }
                throw new IllegalStateException("Can not perform this action inside of " + this.s);
            }
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || this.f51363d == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f51363d.size(); i2++) {
            Fragment fragment = this.f51363d.get(i2);
            if (fragment != null) {
                W(fragment);
            }
        }
    }

    public void m(Fragment fragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048621, this, fragment, i2, i3) == null) {
            if (x) {
                Log.v("FragmentManager", "detach: " + fragment);
            }
            if (fragment.E) {
                return;
            }
            fragment.E = true;
            if (fragment.p) {
                if (this.f51364e != null) {
                    if (x) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f51364e.remove(fragment);
                }
                if (fragment.H && fragment.I) {
                    this.p = true;
                }
                fragment.p = false;
                U(fragment, 1, i2, i3, false);
            }
        }
    }

    public final void m0(RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, runtimeException) == null) {
            Log.e("FragmentManager", runtimeException.getMessage());
            Log.e("FragmentManager", "Activity state:");
            PrintWriter printWriter = new PrintWriter(new d.a.o0.o.a.c.d("FragmentManager"));
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
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.q = false;
            S(2, false);
        }
    }

    public void o(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, configuration) == null) || this.f51364e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f51364e.size(); i2++) {
            Fragment fragment = this.f51364e.get(i2);
            if (fragment != null) {
                fragment.Q0(configuration);
            }
        }
    }

    @Override // d.a.o0.o.a.d.e
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048625, this, view, str, context, attributeSet)) == null) {
            if ("fragment".equals(str)) {
                String attributeValue = attributeSet.getAttributeValue(null, DealIntentService.KEY_CLASS);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f51379a);
                if (attributeValue == null) {
                    attributeValue = obtainStyledAttributes.getString(0);
                }
                String str2 = attributeValue;
                int resourceId = obtainStyledAttributes.getResourceId(1, -1);
                String string = obtainStyledAttributes.getString(2);
                obtainStyledAttributes.recycle();
                if (Fragment.p0(this.m.h(), str2)) {
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
                        F = Fragment.e0(context, str2);
                        F.s = true;
                        F.A = resourceId != 0 ? resourceId : id;
                        F.B = id;
                        F.C = string;
                        F.t = true;
                        F.w = this;
                        k kVar = this.m;
                        F.x = kVar;
                        F.H0(kVar.h(), attributeSet, F.f12101h);
                        h(F, true);
                    } else if (!F.t) {
                        F.t = true;
                        if (!F.G) {
                            F.H0(this.m.h(), attributeSet, F.f12101h);
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
        return (View) invokeLLLL.objValue;
    }

    public boolean p(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, menuItem)) == null) {
            if (this.f51364e != null) {
                for (int i2 = 0; i2 < this.f51364e.size(); i2++) {
                    Fragment fragment = this.f51364e.get(i2);
                    if (fragment != null && fragment.R0(menuItem)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.q = false;
            S(1, false);
        }
    }

    public boolean r(Menu menu, MenuInflater menuInflater) {
        InterceptResult invokeLL;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048628, this, menu, menuInflater)) == null) {
            ArrayList<Fragment> arrayList = null;
            if (this.f51364e != null) {
                z2 = false;
                for (int i2 = 0; i2 < this.f51364e.size(); i2++) {
                    Fragment fragment = this.f51364e.get(i2);
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
            if (this.f51367h != null) {
                for (int i3 = 0; i3 < this.f51367h.size(); i3++) {
                    Fragment fragment2 = this.f51367h.get(i3);
                    if (arrayList == null || !arrayList.contains(fragment2)) {
                        fragment2.C0();
                    }
                }
            }
            this.f51367h = arrayList;
            return z2;
        }
        return invokeLL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.r = true;
            E();
            S(0, false);
            this.m = null;
            this.n = null;
            this.o = null;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            S(1, false);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("FragmentManager{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" in ");
            Fragment fragment = this.o;
            if (fragment != null) {
                d.a.o0.o.a.c.c.a(fragment, sb);
            } else {
                d.a.o0.o.a.c.c.a(this.m, sb);
            }
            sb.append("}}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || this.f51364e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f51364e.size(); i2++) {
            Fragment fragment = this.f51364e.get(i2);
            if (fragment != null) {
                fragment.X0();
            }
        }
    }

    public boolean v(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, menuItem)) == null) {
            if (this.f51364e != null) {
                for (int i2 = 0; i2 < this.f51364e.size(); i2++) {
                    Fragment fragment = this.f51364e.get(i2);
                    if (fragment != null && fragment.Y0(menuItem)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void w(Menu menu) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, menu) == null) || this.f51364e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f51364e.size(); i2++) {
            Fragment fragment = this.f51364e.get(i2);
            if (fragment != null) {
                fragment.Z0(menu);
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            S(4, false);
        }
    }

    public boolean y(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, menu)) == null) {
            if (this.f51364e != null) {
                boolean z2 = false;
                for (int i2 = 0; i2 < this.f51364e.size(); i2++) {
                    Fragment fragment = this.f51364e.get(i2);
                    if (fragment != null && fragment.b1(menu)) {
                        z2 = true;
                    }
                }
                return z2;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            S(2, false);
        }
    }
}
