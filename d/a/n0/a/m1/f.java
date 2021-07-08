package d.a.n0.a.m1;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import d.a.n0.a.m1.i.a;
import d.a.n0.a.v2.n0;
import d.a.n0.a.v2.q;
import d.a.n0.a.v2.q0;
/* loaded from: classes7.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46100a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f46101b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f46102c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46103e;

        /* renamed from: d.a.n0.a.m1.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0810a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f46104e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bitmap f46105f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ Rect f46106g;

            public RunnableC0810a(a aVar, int i2, Bitmap bitmap, Rect rect) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), bitmap, rect};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46104e = i2;
                this.f46105f = bitmap;
                this.f46106g = rect;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.n0.a.m1.i.a a2 = a.C0811a.a("simple_parser");
                    a2.c(this.f46104e);
                    if (a2.a(this.f46105f, this.f46106g)) {
                        return;
                    }
                    f.h();
                }
            }
        }

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46103e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            d.a.n0.a.h0.g.g swanAppFragmentManager;
            d.a.n0.a.h0.g.f o;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = d.a.n0.a.g1.f.V().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null || (o = swanAppFragmentManager.o()) == null) {
                return;
            }
            Bitmap p = n0.p();
            q.e().execute(new RunnableC0810a(this, c.d(o), p, c.b(p, o, d.a.n0.a.g1.f.V().C(this.f46103e))), "SwanNAArrivalCheck");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(711122922, "Ld/a/n0/a/m1/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(711122922, "Ld/a/n0/a/m1/f;");
                return;
            }
        }
        f46100a = k.f45831a;
        f46101b = "";
        f46102c = true;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            q0.X(new a(str));
        }
    }

    public static void c() {
        d.a.n0.a.h0.g.g W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (f46100a) {
                Log.d("SwanArrivalMonitor", "start handle arrival report");
            }
            if (d.a.n0.a.j2.e.f() || (W = d.a.n0.a.g1.f.V().W()) == null) {
                return;
            }
            d.a.n0.a.h0.g.f o = W.o();
            d.a.n0.a.p.e.j.d dVar = null;
            if (o != null) {
                d.a.n0.a.p.e.b b3 = o.b3();
                if (b3 == null) {
                    return;
                }
                d.a.n0.a.p.e.e m = b3.m();
                if (m != null) {
                    dVar = m.O();
                } else {
                    dVar = b3.O();
                }
            }
            if (dVar == null || dVar.f46627b <= 0) {
                return;
            }
            d.a.n0.a.j2.e.a(dVar);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || d.a.n0.a.j2.e.h()) {
            return;
        }
        d.a.n0.a.h0.g.f J = d.a.n0.a.g1.f.V().J();
        if (J == null) {
            if (f46100a) {
                Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
            }
        } else if (!f(J)) {
            if (f46100a) {
                Log.d("SwanArrivalMonitor", "start na report");
            }
            h();
        } else {
            if (f46100a) {
                Log.d("SwanArrivalMonitor", "start check for na arrival");
            }
            b(J.g3());
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            f46101b = str;
        }
    }

    public static boolean f(d.a.n0.a.h0.g.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, fVar)) == null) {
            if (fVar == null) {
                return false;
            }
            boolean equals = TextUtils.equals(f46101b, fVar.g3());
            if (f46100a) {
                Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            }
            return equals;
        }
        return invokeL.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f46102c : invokeV.booleanValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            d.a.n0.a.j2.e.o(d.a.n0.a.a2.e.i() != null ? d.a.n0.a.a2.e.i().N() : null);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            if (f46100a) {
                Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
            }
            if (z && d.a.n0.a.j2.e.j()) {
                if (f46100a) {
                    Log.d("SwanArrivalMonitor", "end handle swan page change");
                    return;
                }
                return;
            }
            if (z) {
                f46102c = false;
            }
            if (!z) {
                d();
            }
            d.a.n0.a.j2.e.G();
            c();
            d.a.n0.a.a2.e i2 = d.a.n0.a.a2.e.i();
            if (i2 == null || z) {
                return;
            }
            d.a.n0.a.j2.e.q(i2.N());
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            f46101b = "";
            f46102c = true;
        }
    }
}
