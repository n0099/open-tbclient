package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gk5 a(hk5 hk5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hk5Var)) == null) {
            if (hk5Var != null && (hk5Var.a() instanceof TbPageContext) && (((TbPageContext) hk5Var.a()).getPageActivity() instanceof gk5)) {
                return (gk5) ((TbPageContext) hk5Var.a()).getPageActivity();
            }
            return null;
        }
        return (gk5) invokeL.objValue;
    }
}
