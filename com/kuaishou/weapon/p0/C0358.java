package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* renamed from: com.kuaishou.weapon.p0.ʽˆ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0358 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final C0358 f187;

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final int f188 = 3;

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final int f189 = 6;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public final ThreadPoolExecutor f190;

    /* renamed from: com.kuaishou.weapon.p0.ʽˆ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class RejectedExecutionHandlerC0359 implements RejectedExecutionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ C0358 f191;

        public RejectedExecutionHandlerC0359(C0358 c0358) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0358};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f191 = c0358;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, threadPoolExecutor) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(335182926, "Lcom/kuaishou/weapon/p0/ʽˆ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(335182926, "Lcom/kuaishou/weapon/p0/ʽˆ;");
                return;
            }
        }
        f187 = new C0358();
    }

    public C0358() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f190 = new ThreadPoolExecutor(3, 6, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10), new RejectedExecutionHandlerC0359(this));
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static C0358 m366() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f187 : (C0358) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m367(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) || runnable == null) {
            return;
        }
        try {
            this.f190.execute(runnable);
        } catch (Exception unused) {
        }
    }
}
