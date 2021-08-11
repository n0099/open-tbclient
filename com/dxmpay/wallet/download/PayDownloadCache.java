package com.dxmpay.wallet.download;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.core.NoProguard;
/* loaded from: classes9.dex */
public class PayDownloadCache implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PREF_FILE_NAME_FP = "__PAY_SDK_DOWNLOAD_FP";
    public transient /* synthetic */ FieldHolder $fh;

    public PayDownloadCache() {
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

    public static String getDownloadFileMd5Value(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) ? (String) SharedPreferencesUtils.getParam(context, PREF_FILE_NAME_FP, str, "") : (String) invokeLL.objValue;
    }

    public static void setDownloadFileMd5Value(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, str, str2) == null) {
            SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, str, str2);
        }
    }
}
