package com.repackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.or2;
/* loaded from: classes6.dex */
public final class hr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile String b;
    public static volatile boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: com.repackage.hr2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0427a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ Bitmap b;
            public final /* synthetic */ Rect c;

            public RunnableC0427a(a aVar, int i, Bitmap bitmap, Rect rect) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), bitmap, rect};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = i;
                this.b = bitmap;
                this.c = rect;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    or2 a = or2.a.a("simple_parser");
                    a.c(this.a);
                    if (a.a(this.b, this.c)) {
                        return;
                    }
                    hr2.h();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            d02 swanAppFragmentManager;
            c02 o;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = hm2.U().getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null || (o = swanAppFragmentManager.o()) == null) {
                return;
            }
            Bitmap p = le3.p();
            od3.f().execute(new RunnableC0427a(this, dr2.d(o), p, dr2.b(p, o, hm2.U().B(this.a))), "SwanNAArrivalCheck");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755638711, "Lcom/repackage/hr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755638711, "Lcom/repackage/hr2;");
                return;
            }
        }
        a = eh1.a;
        b = "";
        c = true;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            oe3.a0(new a(str));
        }
    }

    public static void c() {
        d02 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (a) {
                Log.d("SwanArrivalMonitor", "start handle arrival report");
            }
            if (e73.f() || (V = hm2.U().V()) == null) {
                return;
            }
            c02 o = V.o();
            ln1 ln1Var = null;
            if (o != null) {
                an1 n3 = o.n3();
                if (n3 == null) {
                    return;
                }
                dn1 m = n3.m();
                if (m != null) {
                    ln1Var = m.P();
                } else {
                    ln1Var = n3.P();
                }
            }
            if (ln1Var == null || ln1Var.b <= 0) {
                return;
            }
            e73.a(ln1Var);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || e73.h()) {
            return;
        }
        c02 H = hm2.U().H();
        if (H == null) {
            if (a) {
                Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
            }
        } else if (!f(H)) {
            if (a) {
                Log.d("SwanArrivalMonitor", "start na report");
            }
            h();
        } else {
            if (a) {
                Log.d("SwanArrivalMonitor", "start check for na arrival");
            }
            b(H.s3());
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b = str;
        }
    }

    public static boolean f(c02 c02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, c02Var)) == null) {
            if (c02Var == null) {
                return false;
            }
            boolean equals = TextUtils.equals(b, c02Var.s3());
            if (a) {
                Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            }
            return equals;
        }
        return invokeL.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c : invokeV.booleanValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            e73.o(u03.L() != null ? u03.L().X() : null);
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
            if (a) {
                Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
            }
            if (z && e73.j()) {
                if (a) {
                    Log.d("SwanArrivalMonitor", "end handle swan page change");
                    return;
                }
                return;
            }
            if (z) {
                c = false;
            }
            if (!z) {
                d();
            }
            e73.G();
            c();
            u03 L = u03.L();
            if (L == null || z) {
                return;
            }
            e73.q(L.X());
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            b = "";
            c = true;
        }
    }
}
