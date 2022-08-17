package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class if7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static hf7 a(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof wd7)) {
                return null;
            }
            return ((wd7) tbPageContext.getPageActivity()).B();
        }
        return (hf7) invokeL.objValue;
    }

    public static LegoListFragment b(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof wd7)) {
                return null;
            }
            return ((wd7) tbPageContext.getPageActivity()).U();
        }
        return (LegoListFragment) invokeL.objValue;
    }

    public static mf7 c(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof wd7)) {
                return null;
            }
            return ((wd7) tbPageContext.getPageActivity()).v0();
        }
        return (mf7) invokeL.objValue;
    }
}
