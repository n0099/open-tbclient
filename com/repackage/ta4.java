package com.repackage;

import com.baidu.swan.pms.node.Node;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ta4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static qa4 a(Node node) {
        InterceptResult invokeL;
        Class<? extends qa4> processor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, node)) == null) {
            if (node == null || (processor = node.getProcessor()) == null) {
                return null;
            }
            try {
                return processor.newInstance();
            } catch (IllegalAccessException | InstantiationException unused) {
                return null;
            }
        }
        return (qa4) invokeL.objValue;
    }
}
