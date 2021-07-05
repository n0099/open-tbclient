package d.a.r0.s0;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(TbPageContext<?> tbPageContext, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, view)) == null) {
            boolean z = false;
            if (tbPageContext == null || view == null) {
                return false;
            }
            tbPageContext.getLayoutMode().k((TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) ? true : true);
            tbPageContext.getLayoutMode().j(view);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
