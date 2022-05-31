package com.repackage;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import com.repackage.cw2;
import com.repackage.ek2;
import com.repackage.lz2;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public abstract class gc2 extends pz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public transient /* synthetic */ FieldHolder $fh;
    public final SwanAppActivity b;
    public qy1 c;
    public cw2.c d;
    public final m93 e;
    public FrameLayout f;
    public n53 g;
    public hc2 h;
    public boolean i;
    public final String j;
    public FrameLifeState k;
    public FrameLifeState l;
    public boolean m;
    public boolean n;
    public final ez2 o;
    public boolean p;

    /* loaded from: classes6.dex */
    public class a implements ae3<lz2.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ gc2 c;

        public a(gc2 gc2Var, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gc2Var;
            this.a = z;
            this.b = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(lz2.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && gz2.J().D()) {
                this.c.o.f("event_first_action_launched");
                this.c.H0(this.a, this.b);
                this.c.N0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 a;

        public b(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.N0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 a;

        public c(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dr2.g().y();
                if (gc2.q) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (this.a.b != null && hz2.L() != null) {
                    hz2 L = hz2.L();
                    c92 l = c92.l();
                    l.n(10);
                    uc2.c(L, l.k());
                }
                if (it2.h()) {
                    ac3.m(this.a.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc2 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ d b;

            public a(d dVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.b == null || hz2.a0() == null) {
                    return;
                }
                this.b.a.R(this.a);
            }
        }

        public d(gc2 gc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bd3.e0(new a(this, bd3.i(this.a.Z(), "SwanActivityFrame", true)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-361829126, "Lcom/repackage/gc2$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-361829126, "Lcom/repackage/gc2$e;");
                    return;
                }
            }
            int[] iArr = new int[FrameLifeState.values().length];
            a = iArr;
            try {
                iArr[FrameLifeState.JUST_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FrameLifeState.JUST_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FrameLifeState.JUST_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FrameLifeState.INACTIVATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755682917, "Lcom/repackage/gc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755682917, "Lcom/repackage/gc2;");
                return;
            }
        }
        q = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gc2(SwanAppActivity swanAppActivity, String str) {
        super(gz2.J());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((kz2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = new m93();
        this.k = FrameLifeState.INACTIVATED;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = new ez2();
        this.p = true;
        this.b = swanAppActivity;
        this.j = str;
        this.h = new hc2();
        v(this.o);
    }

    public static void L0(Activity activity, String str, Bitmap bitmap, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65543, null, activity, str, bitmap, i) == null) {
            if (i != 0 && Color.alpha(i) != 255) {
                i = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i));
            }
        }
    }

    public final synchronized void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onResumeInternalStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                j0("onResumeInternal");
                this.h.e();
                hw1.i("SwanApp", "onResume: " + this);
                this.g = a63.c("607");
                U0();
                if (D()) {
                    r().A0(this.b);
                }
                at2.e().d(new c(this), "tryUpdateAndInsertHistory", false);
                HybridUbcFlow p2 = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_page_show");
                ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                p2.F(ubcFlowEvent2);
                h53.d().i("na_page_show");
                uk2.U().v();
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onResumeStart");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                z0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onResumeEnd");
                ubcFlowEvent4.a(true);
                p.F(ubcFlowEvent4);
            }
        }
    }

    public abstract void B0();

    public final synchronized void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onStartStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                j0("onStartInternal");
                this.h.d();
                B0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onStartEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }
    }

    public abstract void D0();

    public final synchronized void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                ms2.m();
                j0("onStopInternal");
                D0();
                this.h.f();
            }
        }
    }

    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            hw1.o("SwanActivityFrame", "onTrimMemory level:" + i);
            d0().a(i);
        }
    }

    public abstract void G0(boolean z, boolean z2);

    public final synchronized void H0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                HybridUbcFlow p = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onUpdateInternalStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                j0("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
                if (z) {
                    ek2.a Z = Z();
                    if (!z2) {
                        s0();
                    }
                    if (!TextUtils.isEmpty(Z.g0())) {
                        yw1.g(Z.g0());
                    }
                }
                uk2.U().l(this.b);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onUpdateStart");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                G0(z, z2);
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onUpdateEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
            }
        }
    }

    public void I0(fc2 fc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fc2Var) == null) {
            this.h.h(fc2Var);
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            s23.b = null;
            ms2.c = null;
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            py2.d(this.f);
        }
    }

    public final synchronized FrameLifeState M(@NonNull FrameLifeState frameLifeState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, frameLifeState)) == null) {
            synchronized (this) {
                if (!frameLifeState.inactivated() && !r().J() && frameLifeState.hasStarted() && !frameLifeState.moreInactiveThan(this.k)) {
                    return this.k.hasCreated() ? this.k : FrameLifeState.JUST_CREATED;
                }
                return frameLifeState;
            }
        }
        return (FrameLifeState) invokeL.objValue;
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09016a);
            this.f = frameLayout;
            py2.g(this.b, frameLayout);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.d == null) {
                this.d = b0();
            }
            z().L(null, this.d);
        }
    }

    public final synchronized void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                boolean z = true;
                this.m = true;
                while (this.l != null && f0()) {
                    FrameLifeState M = M(this.l);
                    j0("syncLifeState: pendingTarget=" + this.l + " fixedTarget=" + M);
                    this.l = null;
                    int i = e.a[M.ordinal()];
                    if (i == 1) {
                        X();
                        S();
                    } else if (i == 2) {
                        U();
                        W();
                    } else if (i != 3) {
                        T();
                    } else {
                        V();
                    }
                }
                j0("syncLifeState: done=" + this.k);
                if (FrameLifeState.INACTIVATED != this.l) {
                    z = false;
                }
                this.n = z;
                this.m = false;
            }
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.i || !pc2.c().a(new WeakReference<>(this.b))) {
                return false;
            }
            this.i = true;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void O0() {
        ti1 a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (a2 = y().a().a()) == null) {
            return;
        }
        a2.a(this.b);
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c = new qy1(this.b);
            q0();
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            hz2 L = hz2.L();
            uf1 M = L != null ? L.M() : null;
            if (M != null) {
                M.h(M.c(AppRuntime.getAppContext()));
            }
        }
    }

    public final void Q(k63 k63Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, k63Var) == null) && k63Var != null && D()) {
            ek2.a Z = Z();
            k63Var.a = a63.n(l());
            k63Var.f = Z.H();
            k63Var.c = Z.T();
            k63Var.b(a63.k(Z.W()));
            if (TextUtils.isEmpty(k63Var.b)) {
                k63Var.b = "click";
            }
            k63Var.d(Z.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            if (TextUtils.equals(k63Var.b, "click")) {
                q53.b(k63Var);
            } else {
                a63.onEvent(k63Var);
            }
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            O0();
            P0();
        }
    }

    public final void R(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, bitmap) == null) && r().H()) {
            L0(this.b, Z().K(), bitmap, (int) Z().b0());
        }
    }

    public final synchronized void R0(@NonNull FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, frameLifeState) == null) {
            synchronized (this) {
                j0(" transLifeState: target=" + frameLifeState + " holdon=" + this.m + " locked=" + this.n + " thread=" + Thread.currentThread());
                if (!this.n) {
                    this.l = frameLifeState;
                    this.n = FrameLifeState.INACTIVATED == frameLifeState;
                }
                if (this.m) {
                    return;
                }
                this.m = true;
                bd3.e0(new b(this));
            }
        }
    }

    public final synchronized void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this) {
                if (!this.k.hasCreated()) {
                    n0();
                    hw1.i("SwanApp", "onPostCreate: " + this);
                    w0();
                    this.k = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            z().d0();
            this.d = null;
        }
    }

    public final synchronized void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                X();
                if (this.k.hasCreated()) {
                    p0();
                    this.k = FrameLifeState.INACTIVATED;
                }
            }
        }
    }

    public void T0(fc2 fc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, fc2Var) == null) {
            this.h.i(fc2Var);
        }
    }

    public final synchronized void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (this.k.hasResumed()) {
                    v0();
                    this.k = FrameLifeState.JUST_STARTED;
                }
            }
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && r().H()) {
            at2.e().d(new d(this), "updateTaskDescription", false);
        }
    }

    public final synchronized void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this) {
                W();
                if (!this.k.hasResumed()) {
                    A0();
                    this.k = FrameLifeState.JUST_RESUMED;
                }
            }
        }
    }

    public final synchronized void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            synchronized (this) {
                S();
                if (!this.k.hasStarted()) {
                    C0();
                    this.k = FrameLifeState.JUST_STARTED;
                }
            }
        }
    }

    public final synchronized void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            synchronized (this) {
                U();
                if (this.k.hasStarted()) {
                    E0();
                    this.k = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            oi2.g0().getSwitch("swan_fixed_relaunch_switch", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public ek2.a Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? r().V() : (ek2.a) invokeV.objValue;
    }

    public synchronized FrameLifeState a0() {
        InterceptResult invokeV;
        FrameLifeState frameLifeState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            synchronized (this) {
                frameLifeState = this.k;
            }
            return frameLifeState;
        }
        return (FrameLifeState) invokeV.objValue;
    }

    @NonNull
    public abstract cw2.c b0();

    public qy1 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.c == null) {
                P();
            }
            return this.c;
        }
        return (qy1) invokeV.objValue;
    }

    @NonNull
    public m93 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.e : (m93) invokeV.objValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.c.k() != 1) {
                return false;
            }
            this.b.moveTaskToBack(true);
            this.b.handleSwanAppExit(2);
            jd3.b().e(1);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? uk2.U().Y() : invokeV.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) ? TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u") : invokeL.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final void j0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, str) == null) && q) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
        }
    }

    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            k0();
        }
    }

    public abstract void m0();

    @DebugTrace
    public final synchronized void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            synchronized (this) {
                j0("onCreateInternal");
                HybridUbcFlow p = ms2.p(NodeJS.STARTUP_SCRIPT_NAME);
                p.F(new UbcFlowEvent("frame_start_create"));
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onCreateInternalStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.h.g();
                hw1.i("SwanApp", "onCreate: " + this);
                if (yw1.d()) {
                    b62.N0(false);
                }
                P();
                gz2 J = gz2.J();
                if (J.D() && J.r().H()) {
                    N();
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onCreateStart");
                    ubcFlowEvent2.a(true);
                    p.F(ubcFlowEvent2);
                    m0();
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onCreateEnd");
                    ubcFlowEvent3.a(true);
                    p.F(ubcFlowEvent3);
                    pb3 slideHelper = this.b.getSlideHelper();
                    if (slideHelper != null) {
                        slideHelper.q();
                    }
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onCreateInternalEnd");
                    ubcFlowEvent4.a(true);
                    p.F(ubcFlowEvent4);
                    return;
                }
                ab3 ab3Var = new ab3();
                ab3Var.k(5L);
                ab3Var.i(11L);
                ab3Var.f("aiapp data is invalid");
                eb3.a().f(ab3Var);
                i63 i63Var = new i63();
                i63Var.q(a63.n(l()));
                i63Var.p(ab3Var);
                i63Var.r(Z());
                a63.R(i63Var);
                ms2.k(ab3Var);
                qb3.j(this.b);
            }
        }
    }

    public abstract void o0();

    public final synchronized void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            synchronized (this) {
                j0("onDestroyInternal");
                o0();
                this.h.c();
                hw1.i("SwanApp", "onDestroy: " + this);
                dr2.g().u();
                r42.k().v();
                fr1.c().d();
                yt2.f();
                J0();
                S0();
                uk2.b0();
                e92.b().a();
            }
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
        }
    }

    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048627, this, i, keyEvent)) == null) ? this.h.onKeyDown(i, keyEvent) : invokeIL.booleanValue;
    }

    public final synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            synchronized (this) {
                R0(FrameLifeState.INACTIVATED);
                y0();
            }
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.h.a();
        }
    }

    public abstract void u0();

    public final synchronized void update(FrameLifeState frameLifeState, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048632, this, frameLifeState, z) == null) {
            synchronized (this) {
                if (!this.b.isDestroyed()) {
                    boolean z2 = false;
                    boolean z3 = z | (!this.k.hasCreated());
                    if (this.k.hasCreated() && z3) {
                        z2 = true;
                    }
                    boolean Y = Y();
                    this.p = Y;
                    if (Y && z2 && !r().J()) {
                        this.o.e(new a(this, z3, z2), "event_first_action_launched");
                    } else {
                        H0(z3, z2);
                    }
                    R0(frameLifeState);
                    if (z3 && (z2 || 1 == l())) {
                        ms2.j(Z(), z2);
                    }
                }
            }
        }
    }

    public final synchronized void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            synchronized (this) {
                j0("onPauseInternal");
                u0();
                uk2.U().w();
                this.h.b();
                hw1.i("SwanApp", "onPause: " + this);
                if (this.g != null && D()) {
                    f63 f63Var = new f63();
                    ek2.a Z = Z();
                    f63Var.a = a63.n(l());
                    f63Var.f = Z.H();
                    f63Var.c = Z.T();
                    f63Var.i(Z);
                    f63Var.d(Z.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                    f63Var.b(a63.k(Z.W()));
                    a63.i(this.g, f63Var);
                    this.g = null;
                }
            }
        }
    }

    public abstract void w0();

    public abstract void x0();

    public final synchronized void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            synchronized (this) {
                j0("onReleaseInternal");
                x0();
                uk2.b0();
            }
        }
    }

    public abstract void z0();
}
