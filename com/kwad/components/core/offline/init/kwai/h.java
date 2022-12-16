package com.kwad.components.core.offline.init.kwai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
/* loaded from: classes8.dex */
public final class h implements IOfflineCompoLogcat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
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

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            com.kwad.sdk.core.e.b.d(str, str2);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            com.kwad.sdk.core.e.b.e(str, str2);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, th) == null) {
            com.kwad.sdk.core.e.b.e(str, str2, th);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            com.kwad.sdk.core.e.b.i(str, str2);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoLogcat
    public final boolean isLoggable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.e.b.XL : invokeV.booleanValue;
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void printStackTrace(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void printStackTraceOnly(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            com.kwad.sdk.core.e.b.v(str, str2);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void v(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, z) == null) {
            if (!z) {
                com.kwad.sdk.core.e.b.v(str, str2);
                return;
            }
            com.kwad.sdk.core.e.b.bT(str + " " + str2);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            com.kwad.sdk.core.e.b.w(str, str2);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void w(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048586, this, str, str2, z) == null) {
            if (z || com.kwad.components.core.a.aw.booleanValue()) {
                com.kwad.sdk.core.e.b.w(str, str2);
            }
        }
    }
}
