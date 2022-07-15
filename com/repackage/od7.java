package com.repackage;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class od7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static nd7 a(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof cc7)) {
                return null;
            }
            return ((cc7) tbPageContext.getPageActivity()).q();
        }
        return (nd7) invokeL.objValue;
    }

    public static LegoListFragment b(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof cc7)) {
                return null;
            }
            return ((cc7) tbPageContext.getPageActivity()).v();
        }
        return (LegoListFragment) invokeL.objValue;
    }

    public static sd7 c(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof cc7)) {
                return null;
            }
            return ((cc7) tbPageContext.getPageActivity()).g0();
        }
        return (sd7) invokeL.objValue;
    }
}
