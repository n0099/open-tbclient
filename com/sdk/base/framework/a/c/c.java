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
/* loaded from: classes4.dex */
public abstract class c<Params, Progress, Result> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final g f59204b;

    /* renamed from: c  reason: collision with root package name */
    public static Executor f59205c;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean a;

    /* renamed from: d  reason: collision with root package name */
    public final h<Params, Result> f59206d;

    /* renamed from: e  reason: collision with root package name */
    public final FutureTask<Result> f59207e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f59208f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f59209g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f59210h;

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
        f59204b = new g((byte) 0);
        f59205c = new i();
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
        this.f59208f = new AtomicBoolean();
        this.f59209g = new AtomicBoolean();
        this.f59210h = false;
        this.a = Boolean.valueOf(com.sdk.base.framework.c.f.f59282c);
        this.f59206d = new d(this);
        this.f59207e = new e(this, this.f59206d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result a(Result result) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, result)) == null) {
            f59204b.obtainMessage(1, new f(this, result)).sendToTarget();
            return result;
        }
        return (Result) invokeL.objValue;
    }

    public static /* synthetic */ void b(c cVar, Object obj) {
        if (cVar.f59209g.get()) {
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
            this.f59208f.set(true);
            return this.f59207e.cancel(true);
        }
        return invokeZ.booleanValue;
    }

    public abstract Result b(Params... paramsArr);

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59208f.get() : invokeV.booleanValue;
    }

    public final c<Params, Progress, Result> c(Params... paramsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, paramsArr)) == null) {
            Executor executor = f59205c;
            if (this.f59210h) {
                throw new IllegalStateException("Cannot execute task: the task is already executed.");
            }
            this.f59210h = true;
            this.f59206d.a = paramsArr;
            executor.execute(new n(0, this.f59207e));
            return this;
        }
        return (c) invokeL.objValue;
    }

    public final void d(Progress... progressArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, progressArr) == null) || this.f59208f.get()) {
            return;
        }
        f59204b.obtainMessage(2, new f(this, progressArr)).sendToTarget();
    }
}
