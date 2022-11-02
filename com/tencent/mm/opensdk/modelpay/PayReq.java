package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.a;
/* loaded from: classes8.dex */
public class PayReq extends BaseReq {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EXTDATA_MAX_LENGTH = 1024;
    public static final String TAG = "MicroMsg.PaySdk.PayReq";
    public transient /* synthetic */ FieldHolder $fh;
    public String appId;
    public String extData;
    public String nonceStr;
    public Options options;
    public String packageValue;
    public String partnerId;
    public String prepayId;
    public String sign;
    public String signType;
    public String timeStamp;

    /* loaded from: classes8.dex */
    public static class Options {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int INVALID_FLAGS = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public String callbackClassName;
        public int callbackFlags;

        public Options() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.callbackFlags = -1;
        }

        public void fromBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                this.callbackClassName = a.b(bundle, "_wxapi_payoptions_callback_classname");
                this.callbackFlags = a.a(bundle, "_wxapi_payoptions_callback_flags");
            }
        }

        public void toBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                bundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
                bundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
            }
        }
    }

    public PayReq() {
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

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public boolean checkArgs() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str2 = this.appId;
            if (str2 == null || str2.length() == 0) {
                str = "checkArgs fail, invalid appId";
            } else {
                String str3 = this.partnerId;
                if (str3 == null || str3.length() == 0) {
                    str = "checkArgs fail, invalid partnerId";
                } else {
                    String str4 = this.prepayId;
                    if (str4 == null || str4.length() == 0) {
                        str = "checkArgs fail, invalid prepayId";
                    } else {
                        String str5 = this.nonceStr;
                        if (str5 == null || str5.length() == 0) {
                            str = "checkArgs fail, invalid nonceStr";
                        } else {
                            String str6 = this.timeStamp;
                            if (str6 == null || str6.length() == 0) {
                                str = "checkArgs fail, invalid timeStamp";
                            } else {
                                String str7 = this.packageValue;
                                if (str7 == null || str7.length() == 0) {
                                    str = "checkArgs fail, invalid packageValue";
                                } else {
                                    String str8 = this.sign;
                                    if (str8 == null || str8.length() == 0) {
                                        str = "checkArgs fail, invalid sign";
                                    } else {
                                        String str9 = this.extData;
                                        if (str9 == null || str9.length() <= 1024) {
                                            return true;
                                        }
                                        str = "checkArgs fail, extData length too long";
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Log.e(TAG, str);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public void fromBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.fromBundle(bundle);
            this.appId = a.b(bundle, "_wxapi_payreq_appid");
            this.partnerId = a.b(bundle, "_wxapi_payreq_partnerid");
            this.prepayId = a.b(bundle, "_wxapi_payreq_prepayid");
            this.nonceStr = a.b(bundle, "_wxapi_payreq_noncestr");
            this.timeStamp = a.b(bundle, "_wxapi_payreq_timestamp");
            this.packageValue = a.b(bundle, "_wxapi_payreq_packagevalue");
            this.sign = a.b(bundle, "_wxapi_payreq_sign");
            this.extData = a.b(bundle, "_wxapi_payreq_extdata");
            this.signType = a.b(bundle, "_wxapi_payreq_sign_type");
            Options options = new Options();
            this.options = options;
            options.fromBundle(bundle);
        }
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 5;
        }
        return invokeV.intValue;
    }

    @Override // com.tencent.mm.opensdk.modelbase.BaseReq
    public void toBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_payreq_appid", this.appId);
            bundle.putString("_wxapi_payreq_partnerid", this.partnerId);
            bundle.putString("_wxapi_payreq_prepayid", this.prepayId);
            bundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
            bundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
            bundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
            bundle.putString("_wxapi_payreq_sign", this.sign);
            bundle.putString("_wxapi_payreq_extdata", this.extData);
            bundle.putString("_wxapi_payreq_sign_type", this.signType);
            Options options = this.options;
            if (options != null) {
                options.toBundle(bundle);
            }
        }
    }
}
