package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ti5 a(ui5 ui5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ui5Var)) == null) {
            if (ui5Var != null && (ui5Var.a() instanceof TbPageContext) && (((TbPageContext) ui5Var.a()).getPageActivity() instanceof ti5)) {
                return (ti5) ((TbPageContext) ui5Var.a()).getPageActivity();
            }
            return null;
        }
        return (ti5) invokeL.objValue;
    }
}
