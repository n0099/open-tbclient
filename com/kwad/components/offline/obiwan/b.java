package com.kwad.components.offline.obiwan;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
/* loaded from: classes7.dex */
public final class b implements com.kwad.sdk.core.e.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IObiwanLogcat Qi;

    public b(IObiwanLogcat iObiwanLogcat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iObiwanLogcat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Qi = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.Qi.d(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.Qi.e(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.Qi.i(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void printStackTraceOnly(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
            this.Qi.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.Qi.v(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void v(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048581, this, str, str2, z) == null) {
            this.Qi.v(str, str2, true);
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.Qi.w(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.kwai.a
    public final void w(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, str, str2, z) == null) {
            this.Qi.w(str, str2, z);
        }
    }
}
