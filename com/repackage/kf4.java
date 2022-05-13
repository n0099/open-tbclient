package com.repackage;

import android.view.LayoutInflater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.jf4;
/* loaded from: classes6.dex */
public class kf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, lf4 lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, lf4Var) == null) {
            layoutInflater.setFactory2(lf4Var != null ? new jf4.a(lf4Var) : null);
        }
    }
}
