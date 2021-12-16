package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.network.intercept.CommonParamInterception;
import com.sina.weibo.sdk.sso.WeiboSsoManager;
import java.util.List;
/* loaded from: classes3.dex */
public class WbSdk {
    public static /* synthetic */ Interceptable $ic;
    public static AuthInfo authInfo;
    public static boolean init;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-588316236, "Lcom/sina/weibo/sdk/WbSdk;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-588316236, "Lcom/sina/weibo/sdk/WbSdk;");
        }
    }

    public WbSdk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void checkInit() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && !init) {
            throw new RuntimeException("weibo sdk was not initall! please use: WbSdk.install() in your app Application or your main Activity. when you want to use weibo sdk function, make sure call WbSdk.install() before this function");
        }
    }

    public static AuthInfo getAuthInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            checkInit();
            return authInfo;
        }
        return (AuthInfo) invokeV.objValue;
    }

    public static void install(Context context, AuthInfo authInfo2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, authInfo2) == null) || init) {
            return;
        }
        if (authInfo2 != null && !TextUtils.isEmpty(authInfo2.getAppKey()) && !TextUtils.isEmpty(authInfo2.getRedirectUrl())) {
            authInfo = authInfo2;
            CommonParamInterception.setAppKey(authInfo2.getAppKey());
            WeiboSsoManager.getInstance().init(context, authInfo2.getAppKey());
            init = true;
            return;
        }
        throw new RuntimeException("please set right app info (appKey,redirect");
    }

    public static boolean isWbInstall(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
            intent.addCategory("android.intent.category.DEFAULT");
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            return (queryIntentServices == null || queryIntentServices.isEmpty()) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static boolean supportMultiImage(Context context) {
        InterceptResult invokeL;
        WbAppInfo wbAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? isWbInstall(context) && (wbAppInfo = WeiboAppManager.getInstance(context).getWbAppInfo()) != null && wbAppInfo.getSupportVersion() >= 10772 : invokeL.booleanValue;
    }
}
