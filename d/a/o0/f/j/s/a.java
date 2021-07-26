package d.a.o0.f.j.s;

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
import d.a.o0.f.j.b;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f50082a;

    /* renamed from: b  reason: collision with root package name */
    public static long f50083b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f50084c;

    /* renamed from: d  reason: collision with root package name */
    public static long f50085d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f50086e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f50087f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.f.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1071a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C1071a f50088e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(196982160, "Ld/a/o0/f/j/s/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(196982160, "Ld/a/o0/f/j/s/a$a;");
                    return;
                }
            }
            f50088e = new C1071a();
        }

        public C1071a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 0 && a.f50087f.g()) {
                    a aVar = a.f50087f;
                    if (a.f50083b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a aVar2 = a.f50087f;
                        a aVar3 = a.f50087f;
                        a.f50083b = (a.f50083b + elapsedRealtime) - a.f50085d;
                        a aVar4 = a.f50087f;
                        a.f50085d = elapsedRealtime;
                        a aVar5 = a.f50087f;
                        Handler handler = a.f50084c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        a aVar6 = a.f50087f;
                        if ((a.f50083b / 1000) % 15 == 0) {
                            b bVar = b.o;
                            a aVar7 = a.f50087f;
                            bVar.U(a.f50083b);
                            return true;
                        }
                        return true;
                    }
                }
                a aVar8 = a.f50087f;
                a.f50085d = 0L;
                a.f50087f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1188620499, "Ld/a/o0/f/j/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1188620499, "Ld/a/o0/f/j/s/a;");
                return;
            }
        }
        f50087f = new a();
        f50086e = C1071a.f50088e;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f50083b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f50082a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j = f50083b;
            if (j < 30000) {
                return;
            }
            f50083b = j % 30000;
            b.o.M();
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            f50082a = z;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f50084c == null) {
                f50084c = new Handler(f50086e);
            }
            f50083b = b.o.A();
            f50082a = true;
            f50085d = SystemClock.elapsedRealtime();
            Handler handler = f50084c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f50082a = false;
            Handler handler = f50084c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (f50085d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                f50083b = (f50083b + elapsedRealtime) - f50085d;
                f50085d = elapsedRealtime;
            }
            b.o.U(f50083b);
        }
    }
}
