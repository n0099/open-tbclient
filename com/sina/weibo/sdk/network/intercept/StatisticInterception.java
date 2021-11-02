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
import com.sina.weibo.sdk.network.exception.InterceptException;
/* loaded from: classes2.dex */
public class StatisticInterception implements IRequestIntercept {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StatisticInterception() {
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
            TextUtils.isEmpty(bundle.getString("from"));
            bundle.putString("from", "2578195010");
            bundle.putString("wm", "20004_90015");
            return false;
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
