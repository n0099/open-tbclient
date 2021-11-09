package com.ss.android.socialbase.downloader.network;

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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f69674a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f69675b = "b";

    /* renamed from: g  reason: collision with root package name */
    public static long f69676g = -1;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f69677h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final k f69678c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f69679d;

    /* renamed from: e  reason: collision with root package name */
    public final a f69680e;

    /* renamed from: f  reason: collision with root package name */
    public long f69681f;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f69682a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, looper};
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
            this.f69682a = bVar;
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
                this.f69682a.f();
                sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1709913032, "Lcom/ss/android/socialbase/downloader/network/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1709913032, "Lcom/ss/android/socialbase/downloader/network/b;");
        }
    }

    public b() {
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
        this.f69678c = k.a();
        this.f69679d = new AtomicInteger();
        this.f69680e = new a(this, com.ss.android.socialbase.downloader.h.e.a());
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f69677h == null) {
                synchronized (b.class) {
                    if (f69677h == null) {
                        f69677h = new b();
                    }
                }
            }
            return f69677h;
        }
        return (b) invokeV.objValue;
    }

    public static long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes() : invokeV.longValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            f69674a = com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N());
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                String str = f69675b;
                com.ss.android.socialbase.downloader.c.a.c(str, "startSampling: mSamplingCounter = " + this.f69679d);
                if (this.f69679d.getAndIncrement() == 0) {
                    this.f69680e.a();
                    this.f69681f = SystemClock.uptimeMillis();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                String str = f69675b;
                com.ss.android.socialbase.downloader.c.a.c(str, "stopSampling: mSamplingCounter = " + this.f69679d);
                if (this.f69679d.decrementAndGet() == 0) {
                    this.f69680e.b();
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
                if (f69674a) {
                    mobileRxBytes = d();
                } else {
                    mobileRxBytes = TrafficStats.getMobileRxBytes();
                }
                long j = mobileRxBytes - f69676g;
                if (f69676g >= 0) {
                    synchronized (this) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        this.f69678c.a(j, uptimeMillis - this.f69681f);
                        this.f69681f = uptimeMillis;
                    }
                }
                f69676g = mobileRxBytes;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
            f69676g = -1L;
        }
    }
}
