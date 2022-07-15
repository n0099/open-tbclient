package com.repackage;

import android.view.Window;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            h03 b0 = h03.b0();
            return (b0 == null || (w = b0.w()) == null || w.isFinishing() || (window = w.getWindow()) == null || (window.getAttributes().flags & 1024) != 1024) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
