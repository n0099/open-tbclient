package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class x78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(h45 h45Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, h45Var)) == null) {
            if (h45Var != null) {
                return h45Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(h45 h45Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{h45Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) || a(h45Var) || context == null || view2 == null) {
            return;
        }
        if (h45Var == null) {
            h45Var = new h45(context, onClickListener);
        }
        h45Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
        h45Var.attachView(view2, z);
        h45Var.p();
        h45Var.onChangeSkinType();
    }
}
