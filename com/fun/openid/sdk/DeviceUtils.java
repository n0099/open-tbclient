package com.fun.openid.sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public class DeviceUtils {
    public static /* synthetic */ Interceptable $ic;
    public static String ANDROID_ID;
    public static String IMEI;
    public static String IMEI_NEW;
    public transient /* synthetic */ FieldHolder $fh;

    public DeviceUtils() {
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
            String str = ANDROID_ID;
            if (str != null) {
                return str;
            }
            if (context != null) {
                try {
                    ANDROID_ID = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (FunOpenIDSdk.isIsRPSPermissionGranted() && ANDROID_ID == null) {
                ANDROID_ID = "";
            }
            return ANDROID_ID;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            String str = IMEI;
            if (str != null) {
                return str;
            }
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null && checkPermission(context, com.kuaishou.weapon.p0.g.c)) {
                        IMEI = ApiReplaceUtil.getDeviceId(telephonyManager);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (FunOpenIDSdk.isIsRPSPermissionGranted() && IMEI == null) {
                IMEI = "";
            }
            return IMEI;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        if (android.text.TextUtils.isEmpty(com.fun.openid.sdk.DeviceUtils.IMEI_NEW) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getImeiNew(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            String str = IMEI_NEW;
            if (str != null) {
                return str;
            }
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null && checkPermission(context, com.kuaishou.weapon.p0.g.c)) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            try {
                                Method method = telephonyManager.getClass().getMethod("getImei", new Class[0]);
                                method.setAccessible(true);
                                IMEI_NEW = (String) method.invoke(telephonyManager, new Object[0]);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        IMEI_NEW = ApiReplaceUtil.getDeviceId(telephonyManager);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (FunOpenIDSdk.isIsRPSPermissionGranted() && IMEI_NEW == null) {
                IMEI_NEW = "";
            }
            return IMEI_NEW;
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
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & 255) | (-256)).substring(6));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
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
                    return (!checkPermission(context, com.kuaishou.weapon.p0.g.c) || telephonyManager == null) ? "" : telephonyManager.getNetworkOperator();
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
            if (telephonyManager == null || !checkPermission(context, com.kuaishou.weapon.p0.g.c) || Build.VERSION.SDK_INT >= 30) {
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
