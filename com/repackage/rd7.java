package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static qd7 a(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof ec7)) {
                return null;
            }
            return ((ec7) tbPageContext.getPageActivity()).getFloatVideoContainer();
        }
        return (qd7) invokeL.objValue;
    }

    public static LegoListFragment b(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof ec7)) {
                return null;
            }
            return ((ec7) tbPageContext.getPageActivity()).getLegoListFragment();
        }
        return (LegoListFragment) invokeL.objValue;
    }

    public static xd7 c(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof ec7)) {
                return null;
            }
            return ((ec7) tbPageContext.getPageActivity()).getPlaySwitchController();
        }
        return (xd7) invokeL.objValue;
    }
}
