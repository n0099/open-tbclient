package com.tencent.mm.sdk.modelpay;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.sdk.modelbase.BaseResp;
/* loaded from: classes10.dex */
public class PayResp extends BaseResp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String extData;
    public String prepayId;
    public String returnKey;

    public PayResp() {
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

    public PayResp(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        fromBundle(bundle);
    }

    @Override // com.tencent.mm.sdk.modelbase.BaseResp
    public boolean checkArgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.sdk.modelbase.BaseResp
    public void fromBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.fromBundle(bundle);
            this.prepayId = bundle.getString("_wxapi_payresp_prepayid");
            this.returnKey = bundle.getString("_wxapi_payresp_returnkey");
            this.extData = bundle.getString("_wxapi_payresp_extdata");
        }
    }

    @Override // com.tencent.mm.sdk.modelbase.BaseResp
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 5;
        }
        return invokeV.intValue;
    }

    @Override // com.tencent.mm.sdk.modelbase.BaseResp
    public void toBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_payresp_prepayid", this.prepayId);
            bundle.putString("_wxapi_payresp_returnkey", this.returnKey);
            bundle.putString("_wxapi_payresp_extdata", this.extData);
        }
    }
}
