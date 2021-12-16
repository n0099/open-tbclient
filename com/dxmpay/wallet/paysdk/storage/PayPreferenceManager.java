package com.dxmpay.wallet.paysdk.storage;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import java.util.Map;
/* loaded from: classes2.dex */
public final class PayPreferenceManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PWDPAY_DISPLAY_SCORE_TIP = "pwdpay_display_score_tip";
    public transient /* synthetic */ FieldHolder $fh;

    public PayPreferenceManager() {
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

    public static boolean getBoolean(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, context, str, z)) == null) ? ((Boolean) SharedPreferencesUtils.getParam(context, "_dxm_pay.preferences", str, Boolean.valueOf(z))).booleanValue() : invokeLLZ.booleanValue;
    }

    public static String getNewPpKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Map<String, String> loginData = WalletLoginHelper.getInstance().getLoginData();
            if (loginData == null) {
                return null;
            }
            String str = loginData.get("pass_union_id");
            if (!TextUtils.isEmpty(str)) {
                return Md5Utils.toMD5(str);
            }
            String str2 = loginData.get("pass_user_name");
            if (!TextUtils.isEmpty(str2)) {
                return Md5Utils.toMD5(str2);
            }
            String str3 = loginData.get("pass_open_bduss");
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            return Md5Utils.toMD5(str3);
        }
        return (String) invokeL.objValue;
    }

    public static String getPpCheckTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String newPpKey = getNewPpKey(context);
            if (TextUtils.isEmpty(newPpKey)) {
                newPpKey = getPpKey(context);
            }
            if (TextUtils.isEmpty(newPpKey)) {
                return "";
            }
            return (String) SharedPreferencesUtils.getParam(context, "_dxm_pay.preferences", newPpKey + "time", "");
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String getPpKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            Map<String, String> loginData = WalletLoginHelper.getInstance().getLoginData();
            if (loginData == null) {
                return null;
            }
            String str = loginData.get("pass_uid");
            if (!TextUtils.isEmpty(str)) {
                return Md5Utils.toMD5(str);
            }
            String str2 = loginData.get("pass_bduss");
            if (!TextUtils.isEmpty(str2)) {
                return Md5Utils.toMD5(str2);
            }
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return Md5Utils.toMD5(str2);
        }
        return (String) invokeL.objValue;
    }

    public static boolean getPpSwitch(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String getWalletInterfaceData(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, str, str2)) == null) ? (String) SharedPreferencesUtils.getParam(context, "dxm_wallet_interface.preferences", str, str2) : (String) invokeLLL.objValue;
    }

    public static void setBoolean(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65543, null, context, str, z) == null) {
            SharedPreferencesUtils.setParam(context, "_dxm_pay.preferences", str, Boolean.valueOf(z));
        }
    }

    public static void setPpCheckTime(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) {
            String newPpKey = getNewPpKey(context);
            if (TextUtils.isEmpty(newPpKey)) {
                return;
            }
            SharedPreferencesUtils.setParam(context, "_dxm_pay.preferences", newPpKey + "time", str);
        }
    }

    public static void setPpSwitch(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, context, z) == null) {
            String newPpKey = getNewPpKey(context);
            if (TextUtils.isEmpty(newPpKey)) {
                return;
            }
            SharedPreferencesUtils.setParam(context, "_dxm_pay.preferences", newPpKey, Boolean.valueOf(z));
        }
    }

    public static void setWalletInterfaceData(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, context, str, str2) == null) {
            SharedPreferencesUtils.setParam(context, "dxm_wallet_interface.preferences", str, str2);
        }
    }
}
