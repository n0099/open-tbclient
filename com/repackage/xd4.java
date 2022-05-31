package com.repackage;

import android.view.LayoutInflater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.wd4;
/* loaded from: classes7.dex */
public class xd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(LayoutInflater layoutInflater, yd4 yd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, layoutInflater, yd4Var) == null) {
            layoutInflater.setFactory2(yd4Var != null ? new wd4.a(yd4Var) : null);
        }
    }
}
