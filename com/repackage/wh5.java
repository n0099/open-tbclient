package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class wh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static qh5 a(rh5 rh5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rh5Var)) == null) {
            if (rh5Var != null && (rh5Var.a() instanceof TbPageContext) && (((TbPageContext) rh5Var.a()).getPageActivity() instanceof qh5)) {
                return (qh5) ((TbPageContext) rh5Var.a()).getPageActivity();
            }
            return null;
        }
        return (qh5) invokeL.objValue;
    }
}
