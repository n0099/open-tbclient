package com.kwad.components.core.webview.b;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class t extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public t() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "registerVideoProgressListener" : (String) invokeV.objValue;
    }

    public final void a(com.kwad.components.core.webview.b.kwai.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
            com.kwad.sdk.core.d.b.a("RegisterVideoProgress", "setData enable: " + this.a);
            if (qVar != null) {
                com.kwad.sdk.core.d.b.a("RegisterVideoProgress", "setData data: " + qVar.toJson());
            }
            if (this.a) {
                super.a((com.kwad.sdk.core.response.kwai.a) qVar);
            }
        }
    }

    @Override // com.kwad.components.core.webview.b.m, com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            super.a(str, cVar);
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.a = false;
        }
    }
}
