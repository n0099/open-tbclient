package com.kwai.sodler.lib.ext;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.a.f;
/* loaded from: classes7.dex */
public final class a {
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

    @Nullable
    public static b n(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fVar)) == null) ? fVar.Fs() : (b) invokeL.objValue;
    }

    public final void c(f fVar, com.kwai.sodler.lib.a.a aVar) {
        b n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, fVar, aVar) == null) || (n = n(fVar)) == null) {
            return;
        }
        n.a((b) fVar, (f) aVar);
    }

    public final void c(f fVar, PluginError pluginError) {
        b n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, pluginError) == null) || (n = n(fVar)) == null) {
            return;
        }
        n.a((b) fVar, pluginError);
    }

    public final void o(f fVar) {
        b n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) || (n = n(fVar)) == null) {
            return;
        }
        n.a(fVar);
    }

    public final void p(f fVar) {
        b n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) || (n = n(fVar)) == null) {
            return;
        }
        n.c(fVar);
    }

    public final void q(f fVar) {
        b n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) || (n = n(fVar)) == null) {
            return;
        }
        n.b(fVar);
    }
}
