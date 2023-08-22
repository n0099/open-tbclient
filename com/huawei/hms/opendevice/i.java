package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;
/* loaded from: classes10.dex */
public class i extends PushPreferences {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "i";
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context) {
        super(context, "push_client_self_info");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return PushEncrypter.decrypter(this.b, getString(str));
            } catch (Exception e) {
                String str2 = TAG;
                HMSLog.e(str2, "getSecureData" + e.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return a("token_info_v2");
                }
                return a(str);
            } catch (Exception e) {
                String str2 = TAG;
                HMSLog.e(str2, "getSecureData" + e.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return removeKey("token_info_v2");
                }
                return removeKey(str);
            } catch (Exception e) {
                String str2 = TAG;
                HMSLog.e(str2, "removeToken" + e.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static i a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return new i(context);
        }
        return (i) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Map<String, ?> all = getAll();
            if (!all.isEmpty() && !all.keySet().isEmpty()) {
                for (String str : all.keySet()) {
                    if (!"push_kit_auto_init_enabled".equals(str) && !"_proxy_init".equals(str)) {
                        removeKey(str);
                    }
                }
            }
        }
    }

    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return saveString(str, PushEncrypter.encrypter(this.b, str2));
            } catch (Exception e) {
                String str3 = TAG;
                HMSLog.e(str3, "saveSecureData" + e.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return a("token_info_v2", str2);
                }
                return a(str, str2);
            } catch (Exception e) {
                String str3 = TAG;
                HMSLog.e(str3, "saveSecureData" + e.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
