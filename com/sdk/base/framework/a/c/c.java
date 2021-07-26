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
/* loaded from: classes6.dex */
public abstract class c<Params, Progress, Result> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final g f38288b;

    /* renamed from: c  reason: collision with root package name */
    public static Executor f38289c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f38290a;

    /* renamed from: d  reason: collision with root package name */
    public final h<Params, Result> f38291d;

    /* renamed from: e  reason: collision with root package name */
    public final FutureTask<Result> f38292e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f38293f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f38294g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f38295h;

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
        f38288b = new g((byte) 0);
        f38289c = new i();
    }

    public c() {
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
        this.f38293f = new AtomicBoolean();
        this.f38294g = new AtomicBoolean();
        this.f38295h = false;
        this.f38290a = Boolean.valueOf(com.sdk.base.framework.c.f.f38385c);
        this.f38291d = new d(this);
        this.f38292e = new e(this, this.f38291d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result a(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, result)) == null) {
            f38288b.obtainMessage(1, new f(this, result)).sendToTarget();
            return result;
        }
        return (Result) invokeL.objValue;
    }

    public static /* synthetic */ void b(c cVar, Object obj) {
        if (cVar.f38294g.get()) {
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
            this.f38293f.set(true);
            return this.f38292e.cancel(true);
        }
        return invokeZ.booleanValue;
    }

    public abstract Result b(Params... paramsArr);

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38293f.get() : invokeV.booleanValue;
    }

    public final c<Params, Progress, Result> c(Params... paramsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, paramsArr)) == null) {
            Executor executor = f38289c;
            if (this.f38295h) {
                throw new IllegalStateException("Cannot execute task: the task is already executed.");
            }
            this.f38295h = true;
            this.f38291d.f38300a = paramsArr;
            executor.execute(new n(0, this.f38292e));
            return this;
        }
        return (c) invokeL.objValue;
    }

    public final void d(Progress... progressArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, progressArr) == null) || this.f38293f.get()) {
            return;
        }
        f38288b.obtainMessage(2, new f(this, progressArr)).sendToTarget();
    }
}
