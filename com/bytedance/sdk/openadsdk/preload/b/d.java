package com.bytedance.sdk.openadsdk.preload.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public abstract class d<IN, OUT> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static AtomicLong f68611d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f68612a;

    /* renamed from: b  reason: collision with root package name */
    public IN f68613b;

    /* renamed from: c  reason: collision with root package name */
    public OUT f68614c;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.b.b.a f68615e;

    /* renamed from: f  reason: collision with root package name */
    public b f68616f;

    /* renamed from: g  reason: collision with root package name */
    public long f68617g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(45388159, "Lcom/bytedance/sdk/openadsdk/preload/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(45388159, "Lcom/bytedance/sdk/openadsdk/preload/b/d;");
                return;
            }
        }
        f68611d = new AtomicLong();
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
            }
        }
    }

    public final void a(b bVar, d dVar, IN in, com.bytedance.sdk.openadsdk.preload.b.b.a aVar, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, bVar, dVar, in, aVar, objArr) == null) {
            this.f68616f = new m(bVar);
            this.f68612a = dVar;
            this.f68613b = in;
            this.f68615e = aVar;
            a();
            a(objArr);
        }
    }

    public void a(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) {
        }
    }

    public abstract Object a_(b<OUT> bVar, IN in) throws Throwable;

    public final void b(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, th) == null) || (aVar = this.f68615e) == null) {
            return;
        }
        aVar.c(this.f68616f, this, th);
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68617g : invokeV.longValue;
    }

    public final void d() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f68615e) == null) {
            return;
        }
        aVar.d(this.f68616f, this);
    }

    public final void e() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f68615e) == null) {
            return;
        }
        aVar.f(this.f68616f, this);
    }

    public final void f() {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.f68615e) == null) {
            return;
        }
        aVar.e(this.f68616f, this);
    }

    public final void c(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, th) == null) || (aVar = this.f68615e) == null) {
            return;
        }
        aVar.e(this.f68616f, this, th);
    }

    public final void d(Throwable th) {
        com.bytedance.sdk.openadsdk.preload.b.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, th) == null) || (aVar = this.f68615e) == null) {
            return;
        }
        aVar.d(this.f68616f, this, th);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            d dVar = this.f68612a;
            if (dVar != null) {
                this.f68617g = dVar.f68617g;
                return;
            }
            long andIncrement = f68611d.getAndIncrement();
            this.f68617g = andIncrement;
            if (andIncrement < 0) {
                throw new RuntimeException("Pipeline ID use up!");
            }
        }
    }
}
