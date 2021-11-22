package com.tencent.open.utils;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f71071a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f71072b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f71073c;

    /* renamed from: d  reason: collision with root package name */
    public static HandlerThread f71074d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.tencent.open.utils.j$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2036590800, "Lcom/tencent/open/utils/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2036590800, "Lcom/tencent/open/utils/j;");
                return;
            }
        }
        f71072b = new Object();
        f71071a = c();
    }

    public j() {
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

    public static Handler a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f71073c == null) {
                synchronized (j.class) {
                    HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                    f71074d = handlerThread;
                    handlerThread.start();
                    f71073c = new Handler(f71074d.getLooper());
                }
            }
            return f71073c;
        }
        return (Handler) invokeV.objValue;
    }

    public static Executor b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new a(null) : (Executor) invokeV.objValue;
    }

    public static Executor c() {
        InterceptResult invokeV;
        Executor threadPoolExecutor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            } else {
                try {
                    Field declaredField = AsyncTask.class.getDeclaredField("sExecutor");
                    declaredField.setAccessible(true);
                    threadPoolExecutor = (Executor) declaredField.get(null);
                } catch (Exception unused) {
                    threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                }
            }
            if (threadPoolExecutor instanceof ThreadPoolExecutor) {
                ((ThreadPoolExecutor) threadPoolExecutor).setCorePoolSize(3);
            }
            return threadPoolExecutor;
        }
        return (Executor) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public static class a implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Queue<Runnable> f71075a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f71076b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71075a = new LinkedList();
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    Runnable poll = this.f71075a.poll();
                    this.f71076b = poll;
                    if (poll != null) {
                        j.f71071a.execute(poll);
                    }
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                synchronized (this) {
                    this.f71075a.offer(new Runnable(this, runnable) { // from class: com.tencent.open.utils.j.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Runnable f71077a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ a f71078b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, runnable};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f71078b = this;
                            this.f71077a = runnable;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    this.f71077a.run();
                                } finally {
                                    this.f71078b.a();
                                }
                            }
                        }
                    });
                    if (this.f71076b == null) {
                        a();
                    }
                }
            }
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            a().post(runnable);
        }
    }
}
