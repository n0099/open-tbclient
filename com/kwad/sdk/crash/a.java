package com.kwad.sdk.crash;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f36916a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f36917b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f36918c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-519587011, "Lcom/kwad/sdk/crash/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-519587011, "Lcom/kwad/sdk/crash/a;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || f36917b) {
            return;
        }
        f36917b = true;
        HandlerThread handlerThread = new HandlerThread("ex-uploader");
        f36916a = handlerThread;
        handlerThread.start();
        new Handler(f36916a.getLooper()).postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        a.f();
                    } catch (Throwable unused) {
                    }
                    a.e();
                }
            }
        }, TimeUnit.SECONDS.toMillis(c.f36947f));
    }

    public static void a(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, bVar) == null) || bVar.f36928g == null || f36918c) {
            return;
        }
        f36918c = true;
        try {
            com.kwad.sdk.crash.utils.d.a(bVar.f36928g);
            com.kwad.sdk.crash.a.a.a(bVar.f36928g, bVar.n);
            d.a().a(bVar);
            d();
            Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.c.d(bVar.f36928g));
            a();
        } catch (Throwable unused) {
        }
    }

    public static void a(@NonNull Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, th) == null) {
            com.kwad.sdk.utils.f.a(new Runnable(th) { // from class: com.kwad.sdk.crash.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Throwable f36919a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {th};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36919a = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (com.kwad.sdk.crash.b.a.a(this.f36919a)) {
                                com.kwad.sdk.crash.c.a.a(new SdkCaughtException(this.f36919a));
                            }
                        } catch (Throwable th2) {
                            com.kwad.sdk.core.d.a.a(th2);
                        }
                    }
                }
            });
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            com.kwad.sdk.crash.c.c.d().a(com.kwad.sdk.crash.a.a.b(), new e() { // from class: com.kwad.sdk.crash.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.kwad.sdk.crash.e
                public void a(int i2, ExceptionMessage exceptionMessage) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, exceptionMessage) == null) {
                        d.a().a(i2, exceptionMessage);
                    }
                }
            }, new com.kwad.sdk.crash.report.a() { // from class: com.kwad.sdk.crash.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.kwad.sdk.crash.report.c
                public void a(ExceptionMessage exceptionMessage) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, exceptionMessage) == null) {
                        a(exceptionMessage, 1);
                    }
                }
            });
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            try {
                if (f36916a == null || !f36916a.isAlive()) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    f36916a.quitSafely();
                } else {
                    f36916a.quit();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            g();
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            com.kwad.sdk.crash.report.d dVar = new com.kwad.sdk.crash.report.d();
            dVar.a(com.kwad.sdk.crash.c.c.d().a());
            dVar.a(com.kwad.sdk.crash.a.a.b());
        }
    }
}
