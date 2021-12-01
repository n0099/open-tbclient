package com.kwad.sdk.crash;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.i;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f58132b;
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

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (a.class) {
                if (!a) {
                    a = true;
                    com.kwad.sdk.core.i.a.a().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.a.4
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
                                    a.d();
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }, TimeUnit.SECONDS.toMillis(c.f58169f));
                }
            }
        }
    }

    public static void a(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, bVar) == null) || bVar.f58139g == null || f58132b) {
            return;
        }
        f58132b = true;
        try {
            com.kwad.sdk.crash.utils.d.a(bVar.f58139g);
            com.kwad.sdk.crash.kwai.a.a(bVar.f58139g, bVar.n);
            d.a().a(bVar);
            c();
            Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.b.d(bVar.f58139g));
            a();
        } catch (Throwable unused) {
        }
    }

    public static void a(@NonNull Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, th) == null) {
            i.a(new Runnable(th) { // from class: com.kwad.sdk.crash.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Throwable a;

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
                    this.a = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (com.kwad.sdk.crash.a.a.a(this.a)) {
                                com.kwad.sdk.crash.b.a.a(new SdkCaughtException(this.a));
                            }
                        } catch (Throwable th2) {
                            com.kwad.sdk.core.d.a.a(th2);
                        }
                    }
                }
            });
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            com.kwad.sdk.crash.b.c.d().a(com.kwad.sdk.crash.kwai.a.b(), new e() { // from class: com.kwad.sdk.crash.a.2
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

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            e();
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            com.kwad.sdk.crash.report.d dVar = new com.kwad.sdk.crash.report.d();
            dVar.a(com.kwad.sdk.crash.b.c.d().a());
            dVar.a(com.kwad.sdk.crash.kwai.a.b());
        }
    }
}
