package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.api.core.ResContext;
/* loaded from: classes10.dex */
public class ai {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            Resources a2 = a(context);
            if (a2 == null) {
                a2 = context.getResources();
            }
            return a2.getIdentifier(str, "drawable", context.getPackageName());
        }
        return invokeLL.intValue;
    }

    public static Resources a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof ResContext) {
                applicationContext = ((ResContext) applicationContext).getDelegatedContext();
            }
            return applicationContext.getResources();
        }
        return (Resources) invokeL.objValue;
    }
}
