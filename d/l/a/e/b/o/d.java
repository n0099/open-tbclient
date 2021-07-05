package d.l.a.e.b.o;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static final String f74992e = "d";

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f74993f = false;

    /* renamed from: g  reason: collision with root package name */
    public static long f74994g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile d f74995h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final m f74996a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f74997b;

    /* renamed from: c  reason: collision with root package name */
    public final a f74998c;

    /* renamed from: d  reason: collision with root package name */
    public long f74999d;

    /* loaded from: classes10.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f75000a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75000a = dVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sendEmptyMessage(1);
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                removeMessages(1);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) && message.what == 1) {
                this.f75000a.f();
                sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1799837430, "Ld/l/a/e/b/o/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1799837430, "Ld/l/a/e/b/o/d;");
        }
    }

    public d() {
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
        this.f74996a = m.a();
        this.f74997b = new AtomicInteger();
        this.f74998c = new a(this, d.l.a.e.b.k.e.a());
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f74995h == null) {
                synchronized (d.class) {
                    if (f74995h == null) {
                        f74995h = new d();
                    }
                }
            }
            return f74995h;
        }
        return (d) invokeV.objValue;
    }

    public static long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes() : invokeV.longValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
            f74993f = d.l.a.e.b.l.f.g0(d.l.a.e.b.g.e.n());
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                String str = f74992e;
                d.l.a.e.b.c.a.i(str, "startSampling: mSamplingCounter = " + this.f74997b);
                if (this.f74997b.getAndIncrement() == 0) {
                    this.f74998c.a();
                    this.f74999d = SystemClock.uptimeMillis();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                String str = f74992e;
                d.l.a.e.b.c.a.i(str, "stopSampling: mSamplingCounter = " + this.f74997b);
                if (this.f74997b.decrementAndGet() == 0) {
                    this.f74998c.b();
                    g();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void f() {
        long mobileRxBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                e();
                if (f74993f) {
                    mobileRxBytes = d();
                } else {
                    mobileRxBytes = TrafficStats.getMobileRxBytes();
                }
                long j = mobileRxBytes - f74994g;
                if (f74994g >= 0) {
                    synchronized (this) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        this.f74996a.c(j, uptimeMillis - this.f74999d);
                        this.f74999d = uptimeMillis;
                    }
                }
                f74994g = mobileRxBytes;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
            f74994g = -1L;
        }
    }
}
