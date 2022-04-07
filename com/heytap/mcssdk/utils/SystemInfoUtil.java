package com.heytap.mcssdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes5.dex */
public class SystemInfoUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MODEL_NULL = "0";
    public static final int SDK_INT_21 = 21;
    public transient /* synthetic */ FieldHolder $fh;

    public SystemInfoUtil() {
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

    public static String getAndroidVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Build.VERSION.RELEASE : (String) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String getCarrierName(Context context) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String lowerCase = getOperator(context).toLowerCase();
            switch (lowerCase.hashCode()) {
                case -42227884:
                    if (lowerCase.equals("china net")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 278980793:
                    if (lowerCase.equals("chinamobile")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 394699659:
                    if (lowerCase.equals("china mobile")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 507293352:
                    if (lowerCase.equals("chinaunicom")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 618558396:
                    if (lowerCase.equals("中国电信")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 618596989:
                    if (lowerCase.equals("中国移动")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 618663094:
                    if (lowerCase.equals("中国联通")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 623012218:
                    if (lowerCase.equals("china unicom")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1661280486:
                    if (lowerCase.equals("chinanet")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                    return "China Mobile";
                case 3:
                case 4:
                case 5:
                    return "China Unicom";
                case 6:
                case 7:
                case '\b':
                    return "China Net";
                default:
                    return "none";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (isEmpty(Build.MODEL)) {
                LogUtil.w("No MODEL.");
                return "0";
            }
            return Build.MODEL.toUpperCase();
        }
        return (String) invokeV.objValue;
    }

    public static String getOperator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                return telephonyManager != null ? telephonyManager.getNetworkOperatorName() : "";
            } catch (Exception e) {
                LogUtil.e(e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getRomVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? SystemProperties.get(RomUtils.PROP_RO_BUILD_DISPLAY_ID, "") : (String) invokeV.objValue;
    }

    public static boolean isEmpty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equals(str) : invokeL.booleanValue;
    }
}
