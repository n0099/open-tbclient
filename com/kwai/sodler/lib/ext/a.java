package com.kwai.sodler.lib.ext;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.a.f;
/* loaded from: classes10.dex */
public class a {
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

    @Nullable
    public b a(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) ? fVar.m() : (b) invokeL.objValue;
    }

    public void a(f fVar, com.kwai.sodler.lib.a.a aVar) {
        b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, aVar) == null) || (a2 = a(fVar)) == null) {
            return;
        }
        a2.a((b) fVar, (f) aVar);
    }

    public void a(f fVar, PluginError pluginError) {
        b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, pluginError) == null) || (a2 = a(fVar)) == null) {
            return;
        }
        a2.a((b) fVar, pluginError);
    }

    public void b(f fVar) {
        b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) || (a2 = a(fVar)) == null) {
            return;
        }
        a2.a(fVar);
    }

    public void c(f fVar) {
        b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) || (a2 = a(fVar)) == null) {
            return;
        }
        a2.c(fVar);
    }

    public void d(f fVar) {
        b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || (a2 = a(fVar)) == null) {
            return;
        }
        a2.b(fVar);
    }

    public void e(f fVar) {
        b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) || (a2 = a(fVar)) == null) {
            return;
        }
        a2.d(fVar);
    }
}
