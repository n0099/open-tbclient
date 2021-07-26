package d.a.o0.a.t0;

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
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.h;
import d.a.o0.a.a2.i;
import d.a.o0.a.a2.m;
import d.a.o0.a.f;
import d.a.o0.a.f1.e.b;
import d.a.o0.a.h0.g.g;
import d.a.o0.a.k;
import d.a.o0.a.v1.c.e.a;
import d.a.o0.a.v2.p;
import d.a.o0.a.v2.q0;
import d.a.o0.a.v2.x0;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public abstract class c extends m {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final SwanAppActivity f47847f;

    /* renamed from: g  reason: collision with root package name */
    public g f47848g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f47849h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.o0.a.n2.h.d f47850i;
    public FrameLayout j;
    public d.a.o0.a.j2.a k;
    public d.a.o0.a.t0.d l;
    public boolean m;
    public final String n;
    public FrameLifeState o;
    public FrameLifeState p;
    public boolean q;
    public boolean r;
    public final d.a.o0.a.a2.b s;
    public boolean t;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47851e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f47852f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f47853g;

        public a(c cVar, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47853g = cVar;
            this.f47851e = z;
            this.f47852f = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && d.a.o0.a.a2.d.g().C()) {
                this.f47853g.s.f("event_first_action_launched");
                this.f47853g.w0(this.f47851e, this.f47852f);
                this.f47853g.D0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47854e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47854e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47854e.D0();
            }
        }
    }

    /* renamed from: d.a.o0.a.t0.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0899c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47855e;

        public RunnableC0899c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47855e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.n1.q.a.g().y();
                if (c.u) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (this.f47855e.f47847f != null && d.a.o0.a.a2.e.i() != null) {
                    d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
                    d.a.o0.a.n0.l.c l = d.a.o0.a.n0.l.c.l();
                    l.n(10);
                    d.a.o0.a.w0.c.c(i2, l.k());
                }
                if (d.a.o0.a.r1.l.e.l()) {
                    p.i(this.f47855e.f47847f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47856e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f47857e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f47858f;

            public a(d dVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47858f = dVar;
                this.f47857e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47858f.f47856e.f47847f == null || d.a.o0.a.a2.e.Q() == null) {
                    return;
                }
                this.f47858f.f47856e.G(this.f47857e);
            }
        }

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47856e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q0.b0(new a(this, q0.i(this.f47856e.O(), "SwanActivityFrame", true)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47859a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1787735565, "Ld/a/o0/a/t0/c$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1787735565, "Ld/a/o0/a/t0/c$e;");
                    return;
                }
            }
            int[] iArr = new int[FrameLifeState.values().length];
            f47859a = iArr;
            try {
                iArr[FrameLifeState.JUST_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47859a[FrameLifeState.JUST_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47859a[FrameLifeState.JUST_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47859a[FrameLifeState.INACTIVATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(521044180, "Ld/a/o0/a/t0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(521044180, "Ld/a/o0/a/t0/c;");
                return;
            }
        }
        u = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SwanAppActivity swanAppActivity, String str) {
        super(d.a.o0.a.a2.d.g());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47849h = null;
        this.f47850i = new d.a.o0.a.n2.h.d();
        this.o = FrameLifeState.INACTIVATED;
        this.p = null;
        this.q = false;
        this.r = false;
        this.s = new d.a.o0.a.a2.b();
        this.t = true;
        this.f47847f = swanAppActivity;
        this.n = str;
        this.l = new d.a.o0.a.t0.d();
        v(this.s);
    }

    public static void B0(Activity activity, String str, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65538, null, activity, str, bitmap, i2) == null) {
            if (i2 != 0 && Color.alpha(i2) != 255) {
                i2 = Color.argb(255, Color.red(i2), Color.green(i2), Color.blue(i2));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i2));
            }
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.o0.a.z1.b.d.a.c(this.j);
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FrameLayout frameLayout = (FrameLayout) this.f47847f.findViewById(f.ai_apps_activity_root);
            this.j = frameLayout;
            d.a.o0.a.z1.b.d.a.e(this.f47847f, frameLayout);
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.m || !d.a.o0.a.v0.c.c().a(new WeakReference<>(this.f47847f))) {
                return false;
            }
            this.m = true;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final synchronized void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                boolean z = true;
                this.q = true;
                while (this.p != null && U()) {
                    FrameLifeState j = j(this.p);
                    Y("syncLifeState: pendingTarget=" + this.p + " fixedTarget=" + j);
                    this.p = null;
                    int i2 = e.f47859a[j.ordinal()];
                    if (i2 == 1) {
                        M();
                        H();
                    } else if (i2 == 2) {
                        J();
                        L();
                    } else if (i2 != 3) {
                        I();
                    } else {
                        K();
                    }
                }
                Y("syncLifeState: done=" + this.o);
                if (FrameLifeState.INACTIVATED != this.p) {
                    z = false;
                }
                this.r = z;
                this.q = false;
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f47848g = new g(this.f47847f);
            f0();
        }
    }

    public final void E0() {
        d.a.o0.a.p.d.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (a2 = y().a().a()) == null) {
            return;
        }
        a2.a(this.f47847f);
    }

    public final void F(d.a.o0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) && fVar != null && C()) {
            b.a O = O();
            fVar.f46321a = d.a.o0.a.j2.k.m(l());
            fVar.f46326f = O.H();
            fVar.f46323c = O.T();
            fVar.b(d.a.o0.a.j2.k.k(O.W()));
            if (TextUtils.isEmpty(fVar.f46322b)) {
                fVar.f46322b = PrefetchEvent.STATE_CLICK;
            }
            fVar.d(O.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            if (TextUtils.equals(fVar.f46322b, PrefetchEvent.STATE_CLICK)) {
                d.a.o0.a.j2.d.b(fVar);
            } else {
                d.a.o0.a.j2.k.onEvent(fVar);
            }
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
            d.a.o0.a.m.b j = i2 != null ? i2.j() : null;
            if (j != null) {
                j.h(j.c(AppRuntime.getAppContext()));
            }
        }
    }

    public final void G(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) && r().e()) {
            B0(this.f47847f, O().K(), bitmap, (int) O().b0());
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            E0();
            F0();
        }
    }

    public final synchronized void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                if (!this.o.hasCreated()) {
                    c0();
                    d.a.o0.a.e0.d.g("SwanApp", "onPostCreate: " + this);
                    l0();
                    this.o = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public final synchronized void H0(@NonNull FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, frameLifeState) == null) {
            synchronized (this) {
                Y(" transLifeState: target=" + frameLifeState + " holdon=" + this.q + " locked=" + this.r + " thread=" + Thread.currentThread());
                if (!this.r) {
                    this.p = frameLifeState;
                    this.r = FrameLifeState.INACTIVATED == frameLifeState;
                }
                if (this.q) {
                    return;
                }
                this.q = true;
                q0.b0(new b(this));
            }
        }
    }

    public final synchronized void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                M();
                if (this.o.hasCreated()) {
                    e0();
                    this.o = FrameLifeState.INACTIVATED;
                }
            }
        }
    }

    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            z().S();
            this.f47849h = null;
        }
    }

    public final synchronized void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                if (this.o.hasResumed()) {
                    k0();
                    this.o = FrameLifeState.JUST_STARTED;
                }
            }
        }
    }

    public void J0(d.a.o0.a.t0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.l.i(bVar);
        }
    }

    public final synchronized void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                L();
                if (!this.o.hasResumed()) {
                    p0();
                    this.o = FrameLifeState.JUST_RESUMED;
                }
            }
        }
    }

    public final synchronized void K0(FrameLifeState frameLifeState, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, frameLifeState, z) == null) {
            synchronized (this) {
                if (!this.f47847f.isDestroyed()) {
                    boolean z2 = false;
                    boolean z3 = z | (!this.o.hasCreated());
                    if (this.o.hasCreated() && z3) {
                        z2 = true;
                    }
                    boolean N = N();
                    this.t = N;
                    if (N && z2 && !r().g()) {
                        this.s.e(new a(this, z3, z2), "event_first_action_launched");
                    } else {
                        w0(z3, z2);
                    }
                    H0(frameLifeState);
                    if (z3 && (z2 || 1 == l())) {
                        d.a.o0.a.r1.h.j(O(), z2);
                    }
                }
            }
        }
    }

    public final synchronized void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                H();
                if (!this.o.hasStarted()) {
                    r0();
                    this.o = FrameLifeState.JUST_STARTED;
                }
            }
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && r().e()) {
            d.a.o0.a.r1.k.i.b.e().f(new d(this), "updateTaskDescription");
        }
    }

    public final synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            synchronized (this) {
                J();
                if (this.o.hasStarted()) {
                    t0();
                    this.o = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            d.a.o0.a.c1.a.Z().getSwitch("swan_fixed_relaunch_switch", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public b.a O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? r().L() : (b.a) invokeV.objValue;
    }

    public synchronized FrameLifeState P() {
        InterceptResult invokeV;
        FrameLifeState frameLifeState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this) {
                frameLifeState = this.o;
            }
            return frameLifeState;
        }
        return (FrameLifeState) invokeV.objValue;
    }

    @NonNull
    public abstract a.c Q();

    public g R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.f47848g == null) {
                E();
            }
            return this.f47848g;
        }
        return (g) invokeV.objValue;
    }

    @NonNull
    public d.a.o0.a.n2.h.d S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f47850i : (d.a.o0.a.n2.h.d) invokeV.objValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.f47848g.k() != 1) {
                return false;
            }
            this.f47847f.moveTaskToBack(true);
            this.f47847f.handleSwanAppExit(2);
            x0.b().e(1);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? d.a.o0.a.g1.f.V().Z() : invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) ? TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u") : invokeL.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public final void Y(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && u) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public abstract void Z();

    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            Z();
        }
    }

    public abstract void b0();

    @DebugTrace
    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            synchronized (this) {
                Y("onCreateInternal");
                HybridUbcFlow p = d.a.o0.a.r1.h.p("startup");
                p.C(new UbcFlowEvent("frame_start_create"));
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onCreateInternalStart");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                this.l.g();
                d.a.o0.a.e0.d.g("SwanApp", "onCreate: " + this);
                if (d.a.o0.a.e0.f.e.e.d()) {
                    d.a.o0.a.h0.u.g.A0(false);
                }
                E();
                d.a.o0.a.a2.d g2 = d.a.o0.a.a2.d.g();
                if (g2.C() && g2.r().e()) {
                    k();
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onCreateStart");
                    ubcFlowEvent2.a(true);
                    p.C(ubcFlowEvent2);
                    b0();
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onCreateEnd");
                    ubcFlowEvent3.a(true);
                    p.C(ubcFlowEvent3);
                    d.a.o0.a.v2.e slideHelper = this.f47847f.getSlideHelper();
                    if (slideHelper != null) {
                        slideHelper.q();
                    }
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onCreateInternalEnd");
                    ubcFlowEvent4.a(true);
                    p.C(ubcFlowEvent4);
                    return;
                }
                d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
                aVar.j(5L);
                aVar.h(11L);
                aVar.e("aiapp data is invalid");
                d.a.o0.a.q2.e.a().f(aVar);
                d.a.o0.a.j2.p.d dVar = new d.a.o0.a.j2.p.d();
                dVar.q(d.a.o0.a.j2.k.m(l()));
                dVar.p(aVar);
                dVar.r(O());
                d.a.o0.a.j2.k.L(dVar);
                d.a.o0.a.r1.h.k(aVar);
                d.a.o0.a.v2.f.j(this.f47847f);
            }
        }
    }

    public abstract void d0();

    public final synchronized void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            synchronized (this) {
                Y("onDestroyInternal");
                d0();
                this.l.c();
                d.a.o0.a.e0.d.g("SwanApp", "onDestroy: " + this);
                d.a.o0.a.n1.q.a.g().u();
                d.a.o0.a.h0.q.b.g().n();
                d.a.o0.a.u.g.c.c().d();
                d.a.o0.a.r1.p.d.f();
                z0();
                I0();
                d.a.o0.a.g1.f.c0();
                d.a.o0.a.o0.b.b().a();
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    public boolean g0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048616, this, i2, keyEvent)) == null) ? this.l.onKeyDown(i2, keyEvent) : invokeIL.booleanValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.l.a();
        }
    }

    public final synchronized FrameLifeState j(@NonNull FrameLifeState frameLifeState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, frameLifeState)) == null) {
            synchronized (this) {
                if (!frameLifeState.inactivated() && !r().g() && frameLifeState.hasStarted() && !frameLifeState.moreInactiveThan(this.o)) {
                    return this.o.hasCreated() ? this.o : FrameLifeState.JUST_CREATED;
                }
                return frameLifeState;
            }
        }
        return (FrameLifeState) invokeL.objValue;
    }

    public abstract void j0();

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.f47849h == null) {
                this.f47849h = Q();
            }
            z().i(null, this.f47849h);
        }
    }

    public final synchronized void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            synchronized (this) {
                Y("onPauseInternal");
                j0();
                d.a.o0.a.g1.f.V().x();
                this.l.b();
                d.a.o0.a.e0.d.g("SwanApp", "onPause: " + this);
                if (this.k != null && C()) {
                    d.a.o0.a.j2.p.a aVar = new d.a.o0.a.j2.p.a();
                    b.a O = O();
                    aVar.f46321a = d.a.o0.a.j2.k.m(l());
                    aVar.f46326f = O.H();
                    aVar.f46323c = O.T();
                    aVar.i(O);
                    aVar.d(O.r0().getString(UBCCloudControlProcessor.UBC_KEY));
                    aVar.b(d.a.o0.a.j2.k.k(O.W()));
                    d.a.o0.a.j2.k.i(this.k, aVar);
                    this.k = null;
                }
            }
        }
    }

    public abstract void l0();

    public abstract void m0();

    public final synchronized void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            synchronized (this) {
                Y("onReleaseInternal");
                m0();
                d.a.o0.a.g1.f.c0();
            }
        }
    }

    public abstract void o0();

    public final synchronized void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = d.a.o0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onResumeInternalStart");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                Y("onResumeInternal");
                this.l.e();
                d.a.o0.a.e0.d.g("SwanApp", "onResume: " + this);
                this.k = d.a.o0.a.j2.k.c("607");
                L0();
                if (C()) {
                    r().o0(this.f47847f);
                }
                d.a.o0.a.r1.k.i.b.e().f(new RunnableC0899c(this), "tryUpdateAndInsertHistory");
                HybridUbcFlow p2 = d.a.o0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_page_show");
                ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                p2.C(ubcFlowEvent2);
                d.a.o0.a.i2.a.d().i("na_page_show");
                d.a.o0.a.g1.f.V().w();
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onResumeStart");
                ubcFlowEvent3.a(true);
                p.C(ubcFlowEvent3);
                o0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onResumeEnd");
                ubcFlowEvent4.a(true);
                p.C(ubcFlowEvent4);
            }
        }
    }

    public abstract void q0();

    public final synchronized void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = d.a.o0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onStartStart");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                Y("onStartInternal");
                this.l.d();
                q0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onStartEnd");
                ubcFlowEvent2.a(true);
                p.C(ubcFlowEvent2);
            }
        }
    }

    public abstract void s0();

    public final synchronized void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            synchronized (this) {
                d.a.o0.a.r1.h.m();
                Y("onStopInternal");
                s0();
                this.l.f();
            }
        }
    }

    public void u0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            d.a.o0.a.e0.d.l("SwanActivityFrame", "onTrimMemory level:" + i2);
            S().a(i2);
        }
    }

    public abstract void v0(boolean z, boolean z2);

    public final synchronized void w0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                HybridUbcFlow p = d.a.o0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onUpdateInternalStart");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                Y("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
                if (z) {
                    b.a O = O();
                    if (!z2) {
                        h0();
                    }
                    if (!TextUtils.isEmpty(O.g0())) {
                        d.a.o0.a.e0.f.e.e.g(O.g0());
                    }
                }
                d.a.o0.a.g1.f.V().l(this.f47847f);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onUpdateStart");
                ubcFlowEvent2.a(true);
                p.C(ubcFlowEvent2);
                v0(z, z2);
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onUpdateEnd");
                ubcFlowEvent3.a(true);
                p.C(ubcFlowEvent3);
            }
        }
    }

    public void x0(d.a.o0.a.t0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, bVar) == null) {
            this.l.h(bVar);
        }
    }

    public final synchronized void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            synchronized (this) {
                H0(FrameLifeState.INACTIVATED);
                n0();
            }
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            d.a.o0.a.c2.f.p0.c.f44287b = null;
            d.a.o0.a.r1.h.f47572e = null;
        }
    }
}
