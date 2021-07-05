package com.fun.openid.sdk;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes6.dex */
public class FunOpenIDSdk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SDK_VERSION = "1.3.2";
    public static final String TAG = "FunOpenIDSdk";
    public static boolean logEnabled;
    public static String vivoAppId;
    public transient /* synthetic */ FieldHolder $fh;

    public FunOpenIDSdk() {
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

    public static String getAndroidId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context != null) {
                try {
                    return Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null && b.a(context, "android.permission.READ_PHONE_STATE")) {
                        return telephonyManager.getDeviceId();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getImeiNew(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String str = null;
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null || !b.a(context, "android.permission.READ_PHONE_STATE")) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
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

    public static synchronized void getOaid(Context context, OnGetOaidListener onGetOaidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, onGetOaidListener) == null) {
            synchronized (FunOpenIDSdk.class) {
                if (context == null) {
                    if (isLogEnabled()) {
                        Log.e(TAG, "getOaid context is null !!!");
                    }
                } else if (onGetOaidListener != null) {
                    j.f32669a.execute(new e(context, onGetOaidListener));
                } else {
                    if (isLogEnabled()) {
                        Log.e(TAG, "getOaid onGetOaidListener is null !!!");
                    }
                }
            }
        }
    }

    public static String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? SDK_VERSION : (String) invokeV.objValue;
    }

    public static String getVivoAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? vivoAppId : (String) invokeV.objValue;
    }

    public static boolean isLogEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? logEnabled : invokeV.booleanValue;
    }

    public static void setLogEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            logEnabled = z;
        }
    }

    public static void setVivoAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            vivoAppId = str;
        }
    }
}
