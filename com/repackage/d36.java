package com.repackage;

import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c36 a(BaseFragment baseFragment, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, baseFragment, i)) == null) {
            if (baseFragment == null) {
                return null;
            }
            if (i == 1) {
                return new h36(baseFragment, i);
            }
            if (i == 2) {
                return new g36(baseFragment, i);
            }
            if (i == 3) {
                return new e36(baseFragment, i);
            }
            return null;
        }
        return (c36) invokeLI.objValue;
    }
}
