package com.sdk.mobile.manager.login.ctc;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.b.a.a;
/* loaded from: classes10.dex */
public class UiOauthManagerCtc extends SDKManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile UiOauthManagerCtc manager;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public UiOauthManagerCtc(Context context) {
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

    public static UiOauthManagerCtc getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (manager == null) {
                synchronized (UiOauthManagerCtc.class) {
                    if (manager == null) {
                        manager = new UiOauthManagerCtc(context);
                    }
                }
            }
            return manager;
        }
        return (UiOauthManagerCtc) invokeL.objValue;
    }

    public <T> void login(int i2, CallBack<T> callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, callBack) == null) {
            new a(this.mContext, i2, callBack).a(0);
        }
    }
}
