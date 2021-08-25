package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes9.dex */
public class j implements Executor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f68641a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f68642b;

    public j() {
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
        this.f68642b = com.bytedance.sdk.openadsdk.preload.geckox.b.r();
    }

    public static j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f68641a == null) {
                synchronized (j.class) {
                    if (f68641a == null) {
                        f68641a = new j();
                    }
                }
            }
            return f68641a;
        }
        return (j) invokeV.objValue;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            this.f68642b.execute(runnable);
        }
    }
}
