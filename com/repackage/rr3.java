package com.repackage;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class rr3 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static long b;
    public static Handler c;
    public static long d;
    public static final Handler.Callback e;
    public static final rr3 f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-33025983, "Lcom/repackage/rr3$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-33025983, "Lcom/repackage/rr3$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message msg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, msg)) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.what == 0 && rr3.f.g()) {
                    rr3 rr3Var = rr3.f;
                    if (rr3.b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        rr3 rr3Var2 = rr3.f;
                        rr3 rr3Var3 = rr3.f;
                        rr3.b = (rr3.b + elapsedRealtime) - rr3.d;
                        rr3 rr3Var4 = rr3.f;
                        rr3.d = elapsedRealtime;
                        rr3 rr3Var5 = rr3.f;
                        Handler handler = rr3.c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        rr3 rr3Var6 = rr3.f;
                        if ((rr3.b / 1000) % 15 == 0) {
                            sq3 sq3Var = sq3.o;
                            rr3 rr3Var7 = rr3.f;
                            sq3Var.U(rr3.b);
                            return true;
                        }
                        return true;
                    }
                }
                rr3 rr3Var8 = rr3.f;
                rr3.d = 0L;
                rr3.f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755340770, "Lcom/repackage/rr3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755340770, "Lcom/repackage/rr3;");
                return;
            }
        }
        f = new rr3();
        e = a.a;
    }

    public rr3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j = b;
            if (j < 30000) {
                return;
            }
            b = j % 30000;
            sq3.o.M();
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            a = z;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (c == null) {
                c = new Handler(e);
            }
            b = sq3.o.A();
            a = true;
            d = SystemClock.elapsedRealtime();
            Handler handler = c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a = false;
            Handler handler = c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                b = (b + elapsedRealtime) - d;
                d = elapsedRealtime;
            }
            sq3.o.U(b);
        }
    }
}
