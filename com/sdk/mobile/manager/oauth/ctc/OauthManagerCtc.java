package com.sdk.mobile.manager.oauth.ctc;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.api.CallBack;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.b.a.a;
import com.sdk.mobile.manager.oauth.cucc.OauthManager;
/* loaded from: classes7.dex */
public class OauthManagerCtc extends SDKManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile OauthManagerCtc manager;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public OauthManagerCtc(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public static OauthManagerCtc getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (manager == null) {
                synchronized (OauthManager.class) {
                    if (manager == null) {
                        manager = new OauthManagerCtc(context);
                    }
                }
            }
            return manager;
        }
        return (OauthManagerCtc) invokeL.objValue;
    }

    public <T> void getAuthoriseCode(int i2, CallBack<T> callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, callBack) == null) {
            new a(this.mContext, i2, callBack).a(1);
        }
    }

    public <T> void getMobileForCode(String str, int i2, CallBack<T> callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, callBack) == null) {
            if (c.a(str).booleanValue()) {
                SDKManager.toFailed(callBack, 101001, "授权码不能为空");
            } else {
                new a(this.mContext, i2, callBack).a(str, null);
            }
        }
    }

    public <T> void getMobileForCode(String str, String str2, int i2, CallBack<T> callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, str, str2, i2, callBack) == null) {
            if (c.a(str).booleanValue()) {
                SDKManager.toFailed(callBack, 101001, "授权码不能为空");
            } else if (c.a(str2).booleanValue()) {
                SDKManager.toFailed(callBack, 101002, "认证的手机号不能为空");
            } else {
                new a(this.mContext, i2, callBack).a(str, str2);
            }
        }
    }
}
