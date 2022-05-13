package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class fi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static zh5 a(ai5 ai5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ai5Var)) == null) {
            if (ai5Var != null && (ai5Var.a() instanceof TbPageContext) && (((TbPageContext) ai5Var.a()).getPageActivity() instanceof zh5)) {
                return (zh5) ((TbPageContext) ai5Var.a()).getPageActivity();
            }
            return null;
        }
        return (zh5) invokeL.objValue;
    }
}
