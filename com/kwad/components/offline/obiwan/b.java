package com.kwad.components.offline.obiwan;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
/* loaded from: classes5.dex */
public final class b implements com.kwad.sdk.core.d.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IObiwanLogcat a;

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
        this.a = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.a.v(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void a(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, z) == null) {
            this.a.v(str, str2, true);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            this.a.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.a.d(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void b(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, str2, z) == null) {
            this.a.w(str, str2, z);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.a.i(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.a.w(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.kwai.a
    public final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.a.e(str, str2);
        }
    }
}
