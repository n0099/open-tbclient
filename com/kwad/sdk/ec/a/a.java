package com.kwad.sdk.ec.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, str, i2, str2)) == null) ? TextUtils.isEmpty(str2) ? str : (i2 == 0 || i2 == 3) ? a(str, str2) : str : (String) invokeLIL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            Uri.Builder appendQueryParameter = buildUpon.appendQueryParameter("returnBack", "liveunion_" + KsAdSDKImpl.get().getAppId());
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
        }
        return (String) invokeLL.objValue;
    }
}
