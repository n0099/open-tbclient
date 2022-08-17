package com.repackage;

import android.content.res.Resources;
import android.util.TypedValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65536, null, f)) == null) ? (int) TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics()) : invokeF.intValue;
    }
}
