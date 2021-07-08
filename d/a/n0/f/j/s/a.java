package d.a.n0.f.j.s;

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
import d.a.n0.f.j.b;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f49578a;

    /* renamed from: b  reason: collision with root package name */
    public static long f49579b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f49580c;

    /* renamed from: d  reason: collision with root package name */
    public static long f49581d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f49582e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f49583f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.f.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1062a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C1062a f49584e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(490385167, "Ld/a/n0/f/j/s/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(490385167, "Ld/a/n0/f/j/s/a$a;");
                    return;
                }
            }
            f49584e = new C1062a();
        }

        public C1062a() {
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
                if (message.what == 0 && a.f49583f.g()) {
                    a aVar = a.f49583f;
                    if (a.f49579b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a aVar2 = a.f49583f;
                        a aVar3 = a.f49583f;
                        a.f49579b = (a.f49579b + elapsedRealtime) - a.f49581d;
                        a aVar4 = a.f49583f;
                        a.f49581d = elapsedRealtime;
                        a aVar5 = a.f49583f;
                        Handler handler = a.f49580c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        a aVar6 = a.f49583f;
                        if ((a.f49579b / 1000) % 15 == 0) {
                            b bVar = b.o;
                            a aVar7 = a.f49583f;
                            bVar.U(a.f49579b);
                            return true;
                        }
                        return true;
                    }
                }
                a aVar8 = a.f49583f;
                a.f49581d = 0L;
                a.f49583f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(608330860, "Ld/a/n0/f/j/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(608330860, "Ld/a/n0/f/j/s/a;");
                return;
            }
        }
        f49583f = new a();
        f49582e = C1062a.f49584e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f49579b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f49578a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j = f49579b;
            if (j < 30000) {
                return;
            }
            f49579b = j % 30000;
            b.o.M();
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            f49578a = z;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f49580c == null) {
                f49580c = new Handler(f49582e);
            }
            f49579b = b.o.A();
            f49578a = true;
            f49581d = SystemClock.elapsedRealtime();
            Handler handler = f49580c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f49578a = false;
            Handler handler = f49580c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (f49581d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                f49579b = (f49579b + elapsedRealtime) - f49581d;
                f49581d = elapsedRealtime;
            }
            b.o.U(f49579b);
        }
    }
}
