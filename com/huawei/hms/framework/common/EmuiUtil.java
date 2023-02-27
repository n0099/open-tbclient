package com.huawei.hms.framework.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.android.os.BuildEx;
/* loaded from: classes8.dex */
public class EmuiUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUILDEX_NAME = "com.huawei.android.os.BuildEx";
    public static final String BUILDEX_VERSION = "com.huawei.android.os.BuildEx$VERSION";
    public static final int EMUI_3_0 = 7;
    public static final int EMUI_3_1 = 8;
    public static final int EMUI_4_0 = 9;
    public static final int EMUI_4_1 = 10;
    public static final int EMUI_5_0 = 11;
    public static final int EMUI_6_0 = 14;
    public static final int EMUI_8_0_1 = 15;
    public static final int EMUI_9_0 = 17;
    public static final String EMUI_SDK_INT = "EMUI_SDK_INT";
    public static final int EMUI_TYPE_UNKOWN = -1;
    public static final String GET_PRIMARY_COLOR = "getPrimaryColor";
    public static final String GET_SUGGESTION_FOR_GROUND_COLOR_STYLE = "getSuggestionForgroundColorStyle";
    public static final String IMMERSION_STYLE = "com.huawei.android.immersion.ImmersionStyle";
    public static final String TAG = "KPMS_Util_Emui";
    public static final int TYPE_EMUI_30 = 30;
    public static final int TYPE_EMUI_31 = 31;
    public static final int TYPE_EMUI_40 = 40;
    public static final int TYPE_EMUI_41 = 41;
    public static final int TYPE_EMUI_50 = 50;
    public static final int TYPE_EMUI_60 = 60;
    public static final int TYPE_EMUI_801 = 81;
    public static final int TYPE_EMUI_90 = 90;
    public static int emuiType = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-98430919, "Lcom/huawei/hms/framework/common/EmuiUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-98430919, "Lcom/huawei/hms/framework/common/EmuiUtil;");
                return;
            }
        }
        initEmuiType();
    }

    public EmuiUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean isEMUI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (-1 != emuiType) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int getEMUIVersionCode() {
        InterceptResult invokeV;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Object staticFieldObj = ReflectionUtils.getStaticFieldObj(BUILDEX_VERSION, EMUI_SDK_INT);
            if (staticFieldObj != null) {
                try {
                    intValue = ((Integer) staticFieldObj).intValue();
                } catch (ClassCastException e) {
                    Logger.e(TAG, "getEMUIVersionCode ClassCastException:", e);
                }
                Logger.d(TAG, "the emui version code is::" + intValue);
                return intValue;
            }
            intValue = 0;
            Logger.d(TAG, "the emui version code is::" + intValue);
            return intValue;
        }
        return invokeV.intValue;
    }

    public static boolean isUpPVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (ReflectionUtils.checkCompatible(BUILDEX_NAME)) {
                Logger.d(TAG, "com.huawei.android.os.BuildEx.VERSION.EMUI_SDK_INT: " + BuildEx.VERSION.EMUI_SDK_INT);
                if (BuildEx.VERSION.EMUI_SDK_INT < 17) {
                    return false;
                }
                return true;
            }
            Logger.w(TAG, "com.huawei.android.os.BuildEx : false");
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void initEmuiType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            int eMUIVersionCode = getEMUIVersionCode();
            Logger.d(TAG, "getEmuiType emuiVersionCode=" + eMUIVersionCode);
            if (eMUIVersionCode >= 17) {
                emuiType = 90;
            } else if (eMUIVersionCode >= 15) {
                emuiType = 81;
            } else if (eMUIVersionCode >= 14) {
                emuiType = 60;
            } else if (eMUIVersionCode >= 11) {
                emuiType = 50;
            } else if (eMUIVersionCode >= 10) {
                emuiType = 41;
            } else if (eMUIVersionCode >= 9) {
                emuiType = 40;
            } else if (eMUIVersionCode >= 8) {
                emuiType = 31;
            } else if (eMUIVersionCode >= 7) {
                emuiType = 30;
            }
            if (emuiType == -1) {
                Logger.i(TAG, "emuiType is unkown");
            }
        }
    }
}
