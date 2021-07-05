package com.kwad.sdk.glide.request;

import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class f extends a<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    @NonNull
    @CheckResult
    public static f b(@NonNull com.kwad.sdk.glide.load.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cVar)) == null) ? new f().a(cVar) : (f) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static f b(@NonNull com.kwad.sdk.glide.load.engine.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hVar)) == null) ? new f().a(hVar) : (f) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public static f b(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) ? new f().a(cls) : (f) invokeL.objValue;
    }
}
