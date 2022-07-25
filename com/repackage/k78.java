package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(l55 l55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, l55Var)) == null) {
            if (l55Var != null) {
                return l55Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(l55 l55Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{l55Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) || a(l55Var) || context == null || view2 == null) {
            return;
        }
        if (l55Var == null) {
            l55Var = new l55(context, onClickListener);
        }
        l55Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
        l55Var.attachView(view2, z);
        l55Var.p();
        l55Var.onChangeSkinType();
    }
}
