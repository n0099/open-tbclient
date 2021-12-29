package com.tencent.connect;

import android.content.Context;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.tauth.IUiListener;
/* loaded from: classes4.dex */
public class UnionInfo extends BaseApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String URL_GET_UNION_ID = "https://openmobile.qq.com/oauth2.0/me";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnionInfo(Context context, QQToken qQToken) {
        super(qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, qQToken};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((QQToken) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void getUnionId(IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iUiListener) == null) {
            Bundle a = a();
            a.putString("unionid", "1");
            HttpUtils.requestAsync(this.f62800c, f.a(), URL_GET_UNION_ID, a, "GET", new BaseApi.TempRequestListener(this, iUiListener));
        }
    }
}
