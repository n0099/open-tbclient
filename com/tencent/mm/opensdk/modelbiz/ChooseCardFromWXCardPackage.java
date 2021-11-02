package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
/* loaded from: classes2.dex */
public class ChooseCardFromWXCardPackage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MicroMsg.ChooseCardFromWXCardPackage";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class Req extends BaseReq {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String appId;
        public String canMultiSelect;
        public String cardId;
        public String cardSign;
        public String cardType;
        public String locationId;
        public String nonceStr;
        public String signType;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str3 = this.appId;
                return str3 != null && str3.length() > 0 && (str = this.signType) != null && str.length() > 0 && (str2 = this.cardSign) != null && str2.length() > 0;
            }
            return invokeV.booleanValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
                super.toBundle(bundle);
                bundle.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
                bundle.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
                bundle.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
                bundle.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
                bundle.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
                bundle.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
                bundle.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
                bundle.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
                bundle.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Resp extends BaseResp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String cardItemList;

        public Resp() {
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

        public Resp(Bundle bundle) {
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

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str = this.cardItemList;
                return (str == null || str.length() == 0) ? false : true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                super.fromBundle(bundle);
                String string = bundle.getString("_wxapi_choose_card_from_wx_card_list");
                if (string == null || string.length() <= 0) {
                    Log.i(ChooseCardFromWXCardPackage.TAG, "cardItemList is empty!");
                } else {
                    this.cardItemList = string;
                }
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
                super.toBundle(bundle);
                bundle.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
            }
        }
    }

    public ChooseCardFromWXCardPackage() {
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
