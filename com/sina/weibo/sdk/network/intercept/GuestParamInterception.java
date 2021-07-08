package com.sina.weibo.sdk.network.intercept;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.network.IRequestIntercept;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.base.WbUserInfo;
import com.sina.weibo.sdk.network.base.WbUserInfoHelper;
import com.sina.weibo.sdk.network.exception.InterceptException;
import com.sina.weibo.wcfc.sobusiness.UtilitySo;
/* loaded from: classes6.dex */
public class GuestParamInterception implements IRequestIntercept {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GuestParamInterception() {
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

    @Override // com.sina.weibo.sdk.network.IRequestIntercept
    public boolean doIntercept(IRequestParam iRequestParam, Bundle bundle) throws InterceptException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iRequestParam, bundle)) == null) {
            WbUserInfo userInfo = WbUserInfoHelper.getInstance().getUserInfo(iRequestParam.getContext());
            if (userInfo != null) {
                bundle.putString("gsid", userInfo.getGsid());
                bundle.putString("uid", userInfo.getUid());
                bundle.putString("s", UtilitySo.getInstance().calculateS(iRequestParam.getContext(), userInfo.getUid()));
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestIntercept
    public boolean needIntercept(IRequestParam iRequestParam, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iRequestParam, bundle)) == null) {
            String url = iRequestParam.getUrl();
            if (TextUtils.isEmpty(url)) {
                return true;
            }
            return (url.startsWith("https://api.weibo.cn/2/sdk/login") || url.startsWith("http://api.weibo.cn/2/sdk/login")) ? false : true;
        }
        return invokeLL.booleanValue;
    }
}
