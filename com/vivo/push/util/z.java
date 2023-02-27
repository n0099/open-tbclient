package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class z extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;

    public z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context != null) {
            this.b = context;
            a(context);
        }
    }

    private synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
            synchronized (this) {
                a(context, "com.vivo.push_preferences.appconfig_v1");
            }
        }
    }

    /* JADX DEBUG: Possible override for method com.vivo.push.util.c.b()V */
    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = "";
            String b = b("APP_APPID", "");
            if (TextUtils.isEmpty(b)) {
                Context context = this.b;
                String packageName = context.getPackageName();
                Object a = ag.a(context, packageName, "com.vivo.push.app_id");
                if (a != null) {
                    str = a.toString();
                } else {
                    Object a2 = ag.a(context, packageName, "app_id");
                    if (a2 != null) {
                        str = a2.toString();
                    }
                }
                return str;
            }
            return b;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = "";
            String b = b("APP_APIKEY", "");
            if (TextUtils.isEmpty(b)) {
                Context context = this.b;
                String packageName = context.getPackageName();
                Object a = ag.a(context, packageName, "com.vivo.push.api_key");
                if (a != null) {
                    str = a.toString();
                } else {
                    Object a2 = ag.a(context, packageName, "api_key");
                    if (a2 != null) {
                        str = a2.toString();
                    }
                }
                return str;
            }
            return b;
        }
        return (String) invokeV.objValue;
    }
}
