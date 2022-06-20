package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class p68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(i45 i45Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, i45Var)) == null) {
            if (i45Var != null) {
                return i45Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(i45 i45Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{i45Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) || a(i45Var) || context == null || view2 == null) {
            return;
        }
        if (i45Var == null) {
            i45Var = new i45(context, onClickListener);
        }
        i45Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
        i45Var.attachView(view2, z);
        i45Var.p();
        i45Var.onChangeSkinType();
    }
}
