package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.List;
/* loaded from: classes3.dex */
public class WbUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
    public transient /* synthetic */ FieldHolder $fh;

    public WbUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Bundle decodeUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            Bundle bundle = new Bundle();
            if (str != null) {
                for (String str2 : str.split("&")) {
                    String[] split = str2.split("=");
                    try {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static String generateUA(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            return Build.MANUFACTURER + "-" + Build.MODEL + "_" + Build.VERSION.RELEASE + "_weibosdk_" + WbSdkVersion.WEIBO_SDK_VERSION_CODE + "_android";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isWeiboInstall(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
            intent.addCategory("android.intent.category.DEFAULT");
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            return (queryIntentServices == null || queryIntentServices.isEmpty()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static Bundle parseUri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                return decodeUrl(new URI(str).getQuery());
            } catch (Exception unused) {
                return new Bundle();
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static boolean supportMixtureShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
