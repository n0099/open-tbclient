package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(h65 h65Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, h65Var)) == null) {
            if (h65Var != null) {
                return h65Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(h65 h65Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{h65Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) || a(h65Var) || context == null || view2 == null) {
            return;
        }
        if (h65Var == null) {
            h65Var = new h65(context, onClickListener);
        }
        h65Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
        h65Var.attachView(view2, z);
        h65Var.p();
        h65Var.onChangeSkinType();
    }
}
