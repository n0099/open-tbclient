package d.l.a.e.b.o;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static final String f72498e = "d";

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f72499f = false;

    /* renamed from: g  reason: collision with root package name */
    public static long f72500g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile d f72501h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final m f72502a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f72503b;

    /* renamed from: c  reason: collision with root package name */
    public final a f72504c;

    /* renamed from: d  reason: collision with root package name */
    public long f72505d;

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f72506a;

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
            this.f72506a = dVar;
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
                this.f72506a.f();
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
        this.f72502a = m.a();
        this.f72503b = new AtomicInteger();
        this.f72504c = new a(this, d.l.a.e.b.k.e.a());
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f72501h == null) {
                synchronized (d.class) {
                    if (f72501h == null) {
                        f72501h = new d();
                    }
                }
            }
            return f72501h;
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f72499f = d.l.a.e.b.l.f.g0(d.l.a.e.b.g.e.n());
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                String str = f72498e;
                d.l.a.e.b.c.a.i(str, "startSampling: mSamplingCounter = " + this.f72503b);
                if (this.f72503b.getAndIncrement() == 0) {
                    this.f72504c.a();
                    this.f72505d = SystemClock.uptimeMillis();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                String str = f72498e;
                d.l.a.e.b.c.a.i(str, "stopSampling: mSamplingCounter = " + this.f72503b);
                if (this.f72503b.decrementAndGet() == 0) {
                    this.f72504c.b();
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
                if (f72499f) {
                    mobileRxBytes = d();
                } else {
                    mobileRxBytes = TrafficStats.getMobileRxBytes();
                }
                long j = mobileRxBytes - f72500g;
                if (f72500g >= 0) {
                    synchronized (this) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        this.f72502a.c(j, uptimeMillis - this.f72505d);
                        this.f72505d = uptimeMillis;
                    }
                }
                f72500g = mobileRxBytes;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
            f72500g = -1L;
        }
    }
}
