package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gh5 a(hh5 hh5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hh5Var)) == null) {
            if (hh5Var != null && (hh5Var.a() instanceof TbPageContext) && (((TbPageContext) hh5Var.a()).getPageActivity() instanceof gh5)) {
                return (gh5) ((TbPageContext) hh5Var.a()).getPageActivity();
            }
            return null;
        }
        return (gh5) invokeL.objValue;
    }
}
