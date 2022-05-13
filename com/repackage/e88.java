package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(y45 y45Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, y45Var)) == null) {
            if (y45Var != null) {
                return y45Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(y45 y45Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{y45Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) || a(y45Var) || context == null || view2 == null) {
            return;
        }
        if (y45Var == null) {
            y45Var = new y45(context, onClickListener);
        }
        y45Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
        y45Var.attachView(view2, z);
        y45Var.p();
        y45Var.onChangeSkinType();
    }
}
