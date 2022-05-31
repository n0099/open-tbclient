package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class l58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(t35 t35Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, t35Var)) == null) {
            if (t35Var != null) {
                return t35Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(t35 t35Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{t35Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) || a(t35Var) || context == null || view2 == null) {
            return;
        }
        if (t35Var == null) {
            t35Var = new t35(context, onClickListener);
        }
        t35Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
        t35Var.attachView(view2, z);
        t35Var.p();
        t35Var.onChangeSkinType();
    }
}
