package com.sina.weibo.sdk.network.intercept;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.network.IRequestIntercept;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.exception.InterceptException;
import com.sina.weibo.sdk.sso.WeiboSsoManager;
import com.sina.weibo.sdk.utils.LogUtil;
/* loaded from: classes10.dex */
public class CommonParamInterception implements IRequestIntercept {
    public static /* synthetic */ Interceptable $ic;
    public static String aidInfo;
    public static String appKey;
    public transient /* synthetic */ FieldHolder $fh;

    public CommonParamInterception() {
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

    public static String getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? String.valueOf(System.currentTimeMillis() / 1000) : (String) invokeV.objValue;
    }

    public static void setAppKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            appKey = str;
        }
    }

    @Override // com.sina.weibo.sdk.network.IRequestIntercept
    public boolean doIntercept(IRequestParam iRequestParam, Bundle bundle) throws InterceptException {
        InterceptResult invokeLL;
        Bundle postBundle;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iRequestParam, bundle)) == null) {
            if (TextUtils.isEmpty(aidInfo)) {
                aidInfo = WeiboSsoManager.getInstance().getAid(iRequestParam.getContext(), appKey);
            }
            if (!TextUtils.isEmpty(aidInfo)) {
                if (!TextUtils.isEmpty(aidInfo)) {
                    bundle.putString("aid", aidInfo);
                }
                if (iRequestParam.getMethod() == IRequestParam.RequestType.GET) {
                    postBundle = iRequestParam.getGetBundle();
                } else {
                    postBundle = iRequestParam.getPostBundle();
                }
                Object obj = postBundle.get("access_token");
                Object obj2 = postBundle.get("refresh_token");
                Object obj3 = postBundle.get("phone");
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                } else if (obj2 != null && (obj2 instanceof String)) {
                    str = (String) obj2;
                } else {
                    str = (obj3 == null || !(obj3 instanceof String)) ? "" : (String) obj3;
                }
                String timestamp = getTimestamp();
                bundle.putString("oauth_timestamp", timestamp);
                bundle.putString("oauth_sign", HttpManager.getOauthSign(iRequestParam.getContext(), aidInfo, str, appKey, timestamp));
                LogUtil.e("weiboSdk param", aidInfo + GlideException.IndentedAppendable.INDENT + timestamp + GlideException.IndentedAppendable.INDENT + appKey + "   " + str);
                return false;
            }
            throw new InterceptException("aid get error");
        }
        return invokeLL.booleanValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestIntercept
    public boolean needIntercept(IRequestParam iRequestParam, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iRequestParam, bundle)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }
}
