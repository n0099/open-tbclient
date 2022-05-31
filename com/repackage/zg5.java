package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static tg5 a(ug5 ug5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ug5Var)) == null) {
            if (ug5Var != null && (ug5Var.a() instanceof TbPageContext) && (((TbPageContext) ug5Var.a()).getPageActivity() instanceof tg5)) {
                return (tg5) ((TbPageContext) ug5Var.a()).getPageActivity();
            }
            return null;
        }
        return (tg5) invokeL.objValue;
    }
}
