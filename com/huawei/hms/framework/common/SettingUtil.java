package com.huawei.hms.framework.common;

import android.content.ContentResolver;
import android.provider.Settings;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class SettingUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SettingUtil";
    public transient /* synthetic */ FieldHolder $fh;

    public SettingUtil() {
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

    public static int getSecureInt(ContentResolver contentResolver, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, contentResolver, str, i)) == null) {
            try {
                return Settings.Secure.getInt(contentResolver, str, i);
            } catch (RuntimeException e) {
                Logger.e(TAG, "Settings Secure getInt throwFromSystemServer:", e);
                return i;
            }
        }
        return invokeLLI.intValue;
    }

    public static int getSystemInt(ContentResolver contentResolver, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, contentResolver, str, i)) == null) {
            try {
                return Settings.System.getInt(contentResolver, str, i);
            } catch (RuntimeException e) {
                Logger.e(TAG, "Settings System getInt throwFromSystemServer:", e);
                return i;
            }
        }
        return invokeLLI.intValue;
    }
}
