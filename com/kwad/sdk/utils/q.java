package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.item.TipsConfigItem;
/* loaded from: classes7.dex */
public final class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            String a2 = com.kwad.sdk.core.config.c.a(TipsConfigItem.TipConfigData.BOTTOM);
            return (!TextUtils.isEmpty(a2) || context == null) ? a2 : context.getString(R.string.ksad_default_no_more_tip_or_toast_txt);
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String a2 = com.kwad.sdk.core.config.c.a("toast");
            return (!TextUtils.isEmpty(a2) || context == null) ? a2 : context.getString(R.string.ksad_default_no_more_tip_or_toast_txt);
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? context.getString(R.string.ksad_network_error_toast) : (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getString(R.string.ksad_page_loading_network_error_title) : (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) ? context.getString(R.string.ksad_page_loading_network_error_sub_title) : (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? context.getString(R.string.ksad_data_error_toast) : (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? context.getString(R.string.ksad_page_loading_data_error_title) : (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? context.getString(R.string.ksad_page_loading_data_error_sub_title) : (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? context.getString(R.string.ksad_page_loading_error_retry) : (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? context.getString(R.string.ksad_half_page_loading_error_tip) : (String) invokeL.objValue;
    }
}
