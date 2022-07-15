package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.hw;
import java.util.Map;
/* loaded from: classes8.dex */
public class br {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static hw a(hw hwVar) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hwVar)) == null) {
            if (hwVar != null && (map = hwVar.f1264b) != null) {
                map.remove("score_info");
            }
            return hwVar;
        }
        return (hw) invokeL.objValue;
    }
}
