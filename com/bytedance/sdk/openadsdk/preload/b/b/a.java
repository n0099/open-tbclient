package com.bytedance.sdk.openadsdk.preload.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.b.d;
/* loaded from: classes5.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, dVar) == null) {
        }
    }

    public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar, th) == null) {
        }
    }

    public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, dVar) == null) {
        }
    }

    public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bVar, dVar, th) == null) {
        }
    }

    public <T> void c(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, dVar) == null) {
        }
    }

    public final void c(com.bytedance.sdk.openadsdk.preload.b.b bVar, d dVar, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, bVar, dVar, th) == null) {
            a(bVar, dVar, th);
        }
    }

    public final void d(com.bytedance.sdk.openadsdk.preload.b.b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bVar, dVar) == null) {
            c(bVar, dVar);
        }
    }

    public final void e(com.bytedance.sdk.openadsdk.preload.b.b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar, dVar) == null) {
            b(bVar, dVar);
        }
    }

    public final void f(com.bytedance.sdk.openadsdk.preload.b.b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, bVar, dVar) == null) {
            a(bVar, dVar);
        }
    }

    public <T> void f(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, bVar, dVar, th) == null) {
        }
    }

    public final void d(com.bytedance.sdk.openadsdk.preload.b.b bVar, d dVar, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, bVar, dVar, th) == null) {
            f(bVar, dVar, th);
        }
    }

    public final void e(com.bytedance.sdk.openadsdk.preload.b.b bVar, d dVar, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, bVar, dVar, th) == null) {
            b(bVar, dVar, th);
        }
    }
}
