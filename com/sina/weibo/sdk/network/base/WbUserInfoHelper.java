package com.sina.weibo.sdk.network.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class WbUserInfoHelper {
    public static /* synthetic */ Interceptable $ic;
    public static WbUserInfoHelper userInfoHelper;
    public transient /* synthetic */ FieldHolder $fh;
    public WbUserInfo userInfo;

    public WbUserInfoHelper() {
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

    public static WbUserInfoHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (userInfoHelper == null) {
                userInfoHelper = new WbUserInfoHelper();
            }
            return userInfoHelper;
        }
        return (WbUserInfoHelper) invokeV.objValue;
    }

    public void clearUserInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.userInfo = null;
        }
    }

    public WbUserInfo getUserInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (context == null) {
                return null;
            }
            if (this.userInfo == null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("wb_sdk_user_key", 0);
                String string = sharedPreferences.getString("uid", null);
                String string2 = sharedPreferences.getString("gsid", null);
                String string3 = sharedPreferences.getString("token", null);
                if (!TextUtils.isEmpty(string2)) {
                    this.userInfo = new WbUserInfo(string2, string, string3);
                }
            }
            return this.userInfo;
        }
        return (WbUserInfo) invokeL.objValue;
    }
}
