package d.a.s0.n1.o.l;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c a(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof d.a.s0.n1.b)) {
                return null;
            }
            return ((d.a.s0.n1.b) tbPageContext.getPageActivity()).getFloatVideoContainer();
        }
        return (c) invokeL.objValue;
    }

    public static LegoListFragment b(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof d.a.s0.n1.b)) {
                return null;
            }
            return ((d.a.s0.n1.b) tbPageContext.getPageActivity()).getLegoListFragment();
        }
        return (LegoListFragment) invokeL.objValue;
    }

    public static n c(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            if (tbPageContext == null || !(tbPageContext.getPageActivity() instanceof d.a.s0.n1.b)) {
                return null;
            }
            return ((d.a.s0.n1.b) tbPageContext.getPageActivity()).getPlaySwitchController();
        }
        return (n) invokeL.objValue;
    }
}
