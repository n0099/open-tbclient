package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes7.dex */
public class ab {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            if (context instanceof ResContext) {
                context = ((ResContext) context).getDelegatedContext();
            }
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        }
        return invokeLL.intValue;
    }

    public static int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, str2)) == null) {
            a(str2, str);
            return a(context).getIdentifier(str, str2, b(context));
        }
        return invokeLLL.intValue;
    }

    public static Resources a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? Wrapper.wrapContextIfNeed(context).getResources() : (Resources) invokeL.objValue;
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
        }
    }

    public static Drawable b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, context, str)) == null) ? a(context).getDrawable(a(context, str, "drawable")) : (Drawable) invokeLL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? Loader.get().getExternalResource() != null ? "com.kwad.sdk" : context.getPackageName() : (String) invokeL.objValue;
    }
}
