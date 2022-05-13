package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static wd7 a(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof lc7)) {
                return null;
            }
            return ((lc7) tbPageContext.getPageActivity()).getFloatVideoContainer();
        }
        return (wd7) invokeL.objValue;
    }

    public static LegoListFragment b(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof lc7)) {
                return null;
            }
            return ((lc7) tbPageContext.getPageActivity()).getLegoListFragment();
        }
        return (LegoListFragment) invokeL.objValue;
    }

    public static be7 c(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof lc7)) {
                return null;
            }
            return ((lc7) tbPageContext.getPageActivity()).getPlaySwitchController();
        }
        return (be7) invokeL.objValue;
    }
}
