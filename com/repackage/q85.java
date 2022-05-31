package com.repackage;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class q85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(TbPageContext<?> tbPageContext, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, view2)) == null) {
            boolean z = false;
            if (tbPageContext == null || view2 == null) {
                return false;
            }
            tbPageContext.getLayoutMode().k((TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) ? true : true);
            tbPageContext.getLayoutMode().j(view2);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
