package com.kwai.video.ksvodplayerkit;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwai.video.cache.AwesomeCache;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? AwesomeCache.isFullyCached(com.kwai.video.ksvodplayerkit.c.c.c(str)) : invokeL.booleanValue;
    }
}
