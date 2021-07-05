package d.a.q0.f.j.s;

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
import d.a.q0.f.j.b;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f52880a;

    /* renamed from: b  reason: collision with root package name */
    public static long f52881b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f52882c;

    /* renamed from: d  reason: collision with root package name */
    public static long f52883d;

    /* renamed from: e  reason: collision with root package name */
    public static final Handler.Callback f52884e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f52885f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.f.j.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1113a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C1113a f52886e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-389823854, "Ld/a/q0/f/j/s/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-389823854, "Ld/a/q0/f/j/s/a$a;");
                    return;
                }
            }
            f52886e = new C1113a();
        }

        public C1113a() {
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
                if (message.what == 0 && a.f52885f.g()) {
                    a aVar = a.f52885f;
                    if (a.f52881b < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        a aVar2 = a.f52885f;
                        a aVar3 = a.f52885f;
                        a.f52881b = (a.f52881b + elapsedRealtime) - a.f52883d;
                        a aVar4 = a.f52885f;
                        a.f52883d = elapsedRealtime;
                        a aVar5 = a.f52885f;
                        Handler handler = a.f52882c;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 1000L);
                        }
                        a aVar6 = a.f52885f;
                        if ((a.f52881b / 1000) % 15 == 0) {
                            b bVar = b.o;
                            a aVar7 = a.f52885f;
                            bVar.U(a.f52881b);
                            return true;
                        }
                        return true;
                    }
                }
                a aVar8 = a.f52885f;
                a.f52883d = 0L;
                a.f52885f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-487555921, "Ld/a/q0/f/j/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-487555921, "Ld/a/q0/f/j/s/a;");
                return;
            }
        }
        f52885f = new a();
        f52884e = C1113a.f52886e;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f52881b : invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f52880a : invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j = f52881b;
            if (j < 30000) {
                return;
            }
            f52881b = j % 30000;
            b.o.M();
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            f52880a = z;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f52882c == null) {
                f52882c = new Handler(f52884e);
            }
            f52881b = b.o.A();
            f52880a = true;
            f52883d = SystemClock.elapsedRealtime();
            Handler handler = f52882c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f52880a = false;
            Handler handler = f52882c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (f52883d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                f52881b = (f52881b + elapsedRealtime) - f52883d;
                f52883d = elapsedRealtime;
            }
            b.o.U(f52881b);
        }
    }
}
