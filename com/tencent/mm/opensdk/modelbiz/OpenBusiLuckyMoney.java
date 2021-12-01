package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelbase.BaseReq;
/* loaded from: classes3.dex */
public class OpenBusiLuckyMoney {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class Req extends BaseReq {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MAX_URL_LENGHT = 10240;
        public transient /* synthetic */ FieldHolder $fh;
        public String appId;
        public String nonceStr;
        public String packageExt;
        public String signType;
        public String signature;
        public String timeStamp;

        public Req() {
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

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            InterceptResult invokeV;
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str5 = this.appId;
                return str5 != null && str5.length() > 0 && (str = this.timeStamp) != null && str.length() > 0 && (str2 = this.nonceStr) != null && str2.length() > 0 && (str3 = this.signType) != null && str3.length() > 0 && (str4 = this.signature) != null && str4.length() > 0;
            }
            return invokeV.booleanValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 13;
            }
            return invokeV.intValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
                super.toBundle(bundle);
                bundle.putString("_wxapi_open_busi_lucky_money_appid", this.appId);
                bundle.putString("_wxapi_open_busi_lucky_money_timeStamp", this.timeStamp);
                bundle.putString("_wxapi_open_busi_lucky_money_nonceStr", this.nonceStr);
                bundle.putString("_wxapi_open_busi_lucky_money_signType", this.signType);
                bundle.putString("_wxapi_open_busi_lucky_money_signature", this.signature);
                bundle.putString("_wxapi_open_busi_lucky_money_package", this.packageExt);
            }
        }
    }

    public OpenBusiLuckyMoney() {
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
}
