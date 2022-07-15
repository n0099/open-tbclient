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

    public static boolean a(k55 k55Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, k55Var)) == null) {
            if (k55Var != null) {
                return k55Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(k55 k55Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{k55Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) || a(k55Var) || context == null || view2 == null) {
            return;
        }
        if (k55Var == null) {
            k55Var = new k55(context, onClickListener);
        }
        k55Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
        k55Var.attachView(view2, z);
        k55Var.p();
        k55Var.onChangeSkinType();
    }
}
