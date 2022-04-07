package com.sdk.base.framework.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public abstract class c<Params, Progress, Result> {
    public static /* synthetic */ Interceptable $ic;
    public static final g b;
    public static Executor c;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean a;
    public final h<Params, Result> d;
    public final FutureTask<Result> e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;
    public volatile boolean h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(922627858, "Lcom/sdk/base/framework/a/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(922627858, "Lcom/sdk/base/framework/a/c/c;");
                return;
            }
        }
        b = new g((byte) 0);
        c = new i();
    }

    public c() {
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
        this.f = new AtomicBoolean();
        this.g = new AtomicBoolean();
        this.h = false;
        this.a = Boolean.valueOf(com.sdk.base.framework.c.f.c);
        this.d = new d(this);
        this.e = new e(this, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result a(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, result)) == null) {
            b.obtainMessage(1, new f(this, result)).sendToTarget();
            return result;
        }
        return (Result) invokeL.objValue;
    }

    public static /* synthetic */ void b(c cVar, Object obj) {
        if (cVar.g.get()) {
            return;
        }
        cVar.a((c) obj);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a(true);
        }
    }

    public void a(Progress... progressArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, progressArr) == null) {
        }
    }

    public final boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.f.set(true);
            return this.e.cancel(true);
        }
        return invokeZ.booleanValue;
    }

    public abstract Result b(Params... paramsArr);

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f.get() : invokeV.booleanValue;
    }

    public final c<Params, Progress, Result> c(Params... paramsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, paramsArr)) == null) {
            Executor executor = c;
            if (this.h) {
                throw new IllegalStateException("Cannot execute task: the task is already executed.");
            }
            this.h = true;
            this.d.a = paramsArr;
            executor.execute(new n(0, this.e));
            return this;
        }
        return (c) invokeL.objValue;
    }

    public final void d(Progress... progressArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, progressArr) == null) || this.f.get()) {
            return;
        }
        b.obtainMessage(2, new f(this, progressArr)).sendToTarget();
    }
}
