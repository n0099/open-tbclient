package com.kwad.sdk.live.mode;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@NonNull LiveInfo liveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, liveInfo)) == null) ? liveInfo.liveStreamId : (String) invokeL.objValue;
    }

    public static long b(@NonNull LiveInfo liveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, liveInfo)) == null) ? liveInfo.user.user_id : invokeL.longValue;
    }

    public static String c(@NonNull LiveInfo liveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, liveInfo)) == null) ? liveInfo.exp_tag : (String) invokeL.objValue;
    }
}
