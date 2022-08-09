package com.tencent.mm.opensdk.modelmsg;

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
/* loaded from: classes8.dex */
public final class SendAuth {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class Req extends BaseReq {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int LENGTH_LIMIT = 1024;
        public static final String TAG = "MicroMsg.SDK.SendAuth.Req";
        public transient /* synthetic */ FieldHolder $fh;
        public String extData;
        public String scope;
        public String state;

        public Req() {
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

        public Req(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str2 = this.scope;
                if (str2 == null || str2.length() == 0 || this.scope.length() > 1024) {
                    str = "checkArgs fail, scope is invalid";
                } else {
                    String str3 = this.state;
                    if (str3 == null || str3.length() <= 1024) {
                        return true;
                    }
                    str = "checkArgs fail, state is invalid";
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
                this.scope = bundle.getString("_wxapi_sendauth_req_scope");
                this.state = bundle.getString("_wxapi_sendauth_req_state");
                this.extData = bundle.getString("_wxapi_sendauth_req_ext_data");
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
                super.toBundle(bundle);
                bundle.putString("_wxapi_sendauth_req_scope", this.scope);
                bundle.putString("_wxapi_sendauth_req_state", this.state);
                bundle.putString("_wxapi_sendauth_req_ext_data", this.extData);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class Resp extends BaseResp {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ERR_SCOPE_SNSAPI_WXAAPP_INFO_CAN_ONLY_AUTHORIZED_SEPARATELY = -1000;
        public static final int LENGTH_LIMIT = 1024;
        public static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
        public transient /* synthetic */ FieldHolder $fh;
        public boolean authResult;
        public String code;
        public String country;
        public String lang;
        public String state;
        public String url;

        public Resp() {
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
            this.authResult = false;
        }

        public Resp(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.authResult = false;
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str = this.state;
                if (str == null || str.length() <= 1024) {
                    return true;
                }
                Log.e(TAG, "checkArgs fail, state is invalid");
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                super.fromBundle(bundle);
                this.code = bundle.getString("_wxapi_sendauth_resp_token");
                this.state = bundle.getString("_wxapi_sendauth_resp_state");
                this.url = bundle.getString("_wxapi_sendauth_resp_url");
                this.lang = bundle.getString("_wxapi_sendauth_resp_lang");
                this.country = bundle.getString("_wxapi_sendauth_resp_country");
                this.authResult = bundle.getBoolean("_wxapi_sendauth_resp_auth_result");
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
                super.toBundle(bundle);
                bundle.putString("_wxapi_sendauth_resp_token", this.code);
                bundle.putString("_wxapi_sendauth_resp_state", this.state);
                bundle.putString("_wxapi_sendauth_resp_url", this.url);
                bundle.putString("_wxapi_sendauth_resp_lang", this.lang);
                bundle.putString("_wxapi_sendauth_resp_country", this.country);
                bundle.putBoolean("_wxapi_sendauth_resp_auth_result", this.authResult);
            }
        }
    }

    public SendAuth() {
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
}
