package com.kwad.components.core.offline.init.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.sdk.utils.az;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class a implements IAsync {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            com.kwad.sdk.utils.g.b(runnable);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnDefaultExecutor(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            com.kwad.sdk.utils.g.a(runnable);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            az.a(runnable);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnUiThreadDelay(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, runnable, j) == null) {
            az.a(runnable, j);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{runnable, Long.valueOf(j), timeUnit}) == null) {
            com.kwad.sdk.utils.g.a(runnable, j, timeUnit);
        }
    }
}
