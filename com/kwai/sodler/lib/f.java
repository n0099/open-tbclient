package com.kwai.sodler.lib;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.kwai.sodler.lib.a.b a(@NonNull Context context, @NonNull com.kwai.sodler.lib.kwai.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, fVar)) == null) {
            fVar.b().f().a(fVar);
            return fVar.s();
        }
        return (com.kwai.sodler.lib.a.b) invokeLL.objValue;
    }
}
