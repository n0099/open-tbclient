package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.sso.WeiboSsoManager;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes9.dex */
public class Utility {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CHARSET = "UTF-8";
    public transient /* synthetic */ FieldHolder $fh;

    public Utility() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String generateGUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return UUID.randomUUID().toString().replace("-", "");
        }
        return (String) invokeV.objValue;
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
                        if (split.length == 2) {
                            bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                        } else if (split.length == 1) {
                            bundle.putString(URLDecoder.decode(split[0], "UTF-8"), "");
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static String generateUAAid(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName) && packageName.contains("com.sina.weibo")) {
                str = "weibo";
            } else {
                str = "weibosdk";
            }
            sb.append(Build.MANUFACTURER);
            sb.append("-");
            sb.append(Build.MODEL);
            sb.append("__");
            sb.append(str);
            sb.append("__");
            try {
                sb.append(WbSdkVersion.WEIBO_SDK_VERSION_CODE.replaceAll("\\s+", "_"));
            } catch (Exception unused) {
                sb.append("unknown");
            }
            sb.append("__");
            sb.append("android");
            sb.append("__android");
            sb.append(Build.VERSION.RELEASE);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getAid(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            if (context == null) {
                return "";
            }
            return WeiboSsoManager.getInstance().getAid(context, str);
        }
        return (String) invokeLL.objValue;
    }

    public static String getSign(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                for (int i = 0; i < packageInfo.signatures.length; i++) {
                    byte[] byteArray = packageInfo.signatures[i].toByteArray();
                    if (byteArray != null) {
                        return MD5.hexdigest(byteArray);
                    }
                }
            } catch (PackageManager.NameNotFoundException | Exception unused) {
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String getWeiBoVersion(Context context) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        }
        return (String) invokeL.objValue;
    }

    public static String safeString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isChineseLocale(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                Locale locale = context.getResources().getConfiguration().locale;
                if (!Locale.CHINA.equals(locale) && !Locale.CHINESE.equals(locale) && !Locale.SIMPLIFIED_CHINESE.equals(locale)) {
                    if (!Locale.TAIWAN.equals(locale)) {
                        return false;
                    }
                }
            } catch (Exception unused) {
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Bundle parseUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            try {
                URL url = new URL(str);
                Bundle decodeUrl = decodeUrl(url.getQuery());
                decodeUrl.putAll(decodeUrl(url.getRef()));
                return decodeUrl;
            } catch (MalformedURLException unused) {
                return new Bundle();
            }
        }
        return (Bundle) invokeL.objValue;
    }
}
