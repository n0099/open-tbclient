package com.fun.ad.sdk.internal.api.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SignatureMd5Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public transient /* synthetic */ FieldHolder $fh;

    public SignatureMd5Utils() {
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

    public static synchronized String getSignatureMd5(Context context) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (SignatureMd5Utils.class) {
                if (TextUtils.isEmpty(a)) {
                    try {
                        str = MD5Utils.getMD5String(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
                    } catch (PackageManager.NameNotFoundException unused) {
                        str = "";
                    }
                    a = str;
                }
                str2 = a;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
