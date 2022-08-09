package com.tencent.mm.opensdk.modelbase;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.utils.a;
/* loaded from: classes8.dex */
public abstract class BaseReq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String openId;
    public String transaction;

    public BaseReq() {
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

    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.transaction = a.b(bundle, "_wxapi_basereq_transaction");
            this.openId = a.b(bundle, "_wxapi_basereq_openid");
        }
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            bundle.putInt("_wxapi_command_type", getType());
            bundle.putString("_wxapi_basereq_transaction", this.transaction);
            bundle.putString("_wxapi_basereq_openid", this.openId);
        }
    }
}
