package com.fun.openid.sdk;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes11.dex */
public class DeviceUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DeviceUtils() {
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

    public static boolean checkPermission(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            if (context != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0) {
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String getAndroidId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context != null) {
                try {
                    return Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getAppVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                return "";
            }
            try {
                return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getAppVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null) {
                return "";
            }
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null || !checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                        return null;
                    }
                    return telephonyManager.getDeviceId();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getImeiNew(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            String str = null;
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null || !checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                        return null;
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        try {
                            Method method = telephonyManager.getClass().getMethod("getImei", new Class[0]);
                            method.setAccessible(true);
                            str = (String) method.invoke(telephonyManager, new Object[0]);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(str)) {
                            return str;
                        }
                    }
                    return telephonyManager.getDeviceId();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getMD5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    sb.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getNetworkOperatorName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    return (!checkPermission(context, "android.permission.READ_PHONE_STATE") || telephonyManager == null) ? "" : telephonyManager.getNetworkOperator();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static int getNetworkType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || !checkPermission(context, "android.permission.READ_PHONE_STATE") || Build.VERSION.SDK_INT >= 30) {
                return 0;
            }
            return telephonyManager.getNetworkType();
        }
        return invokeL.intValue;
    }

    public static String getPackageName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context == null) {
                return null;
            }
            return context.getPackageName();
        }
        return (String) invokeL.objValue;
    }
}
