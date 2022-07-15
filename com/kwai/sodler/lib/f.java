package com.kwai.sodler.lib;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.kwai.sodler.lib.c.b a(@NonNull com.kwai.sodler.lib.a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fVar)) == null) {
            fVar.b().g().a(fVar);
            return fVar.r();
        }
        return (com.kwai.sodler.lib.c.b) invokeL.objValue;
    }
}
