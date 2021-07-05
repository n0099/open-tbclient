package com.bytedance.sdk.openadsdk.preload.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.preload.b.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <IN> b<IN> a(List<h> list, e eVar, d dVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, list, eVar, dVar)) == null) {
            if (list != null) {
                if (eVar == null) {
                    eVar = new e.a();
                }
                return new i(Collections.unmodifiableList(new ArrayList(list)), 0, eVar, dVar);
            }
            throw new IllegalArgumentException("interceptors == null !");
        }
        return (b) invokeLLL.objValue;
    }

    public static <IN> b<IN> a(List<h> list, e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, list, eVar)) == null) ? a(list, eVar, null) : (b) invokeLL.objValue;
    }
}
