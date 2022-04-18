package com.repackage;

import android.view.Window;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            j03 a0 = j03.a0();
            return (a0 == null || (x = a0.x()) == null || x.isFinishing() || (window = x.getWindow()) == null || (window.getAttributes().flags & 1024) != 1024) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
