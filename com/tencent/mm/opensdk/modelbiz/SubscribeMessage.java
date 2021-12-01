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
/* loaded from: classes3.dex */
public final class SubscribeMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class Req extends BaseReq {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int LENGTH_LIMIT = 1024;
        public static final String TAG = "MicroMsg.SDK.SubscribeMessage.Req";
        public transient /* synthetic */ FieldHolder $fh;
        public String reserved;
        public int scene;
        public String templateID;

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

        public Req(Bundle bundle) {
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

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str2 = this.templateID;
                if (str2 == null || str2.length() == 0) {
                    str = "checkArgs fail, templateID is null";
                } else if (this.templateID.length() > 1024) {
                    str = "checkArgs fail, templateID is too long";
                } else {
                    String str3 = this.reserved;
                    if (str3 == null || str3.length() <= 1024) {
                        return true;
                    }
                    str = "checkArgs fail, reserved is too long";
                }
                Log.e("MicroMsg.SDK.SubscribeMessage.Req", str);
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                super.fromBundle(bundle);
                this.scene = bundle.getInt("_wxapi_subscribemessage_req_scene");
                this.templateID = bundle.getString("_wxapi_subscribemessage_req_templateid");
                this.reserved = bundle.getString("_wxapi_subscribemessage_req_reserved");
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 18;
            }
            return invokeV.intValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
                super.toBundle(bundle);
                bundle.putInt("_wxapi_subscribemessage_req_scene", this.scene);
                bundle.putString("_wxapi_subscribemessage_req_templateid", this.templateID);
                bundle.putString("_wxapi_subscribemessage_req_reserved", this.reserved);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Resp extends BaseResp {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "MicroMsg.SDK.SubscribeMessage.Resp";
        public transient /* synthetic */ FieldHolder $fh;
        public String action;
        public String reserved;
        public int scene;
        public String templateID;

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
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                super.fromBundle(bundle);
                this.templateID = bundle.getString("_wxapi_subscribemessage_resp_templateid");
                this.scene = bundle.getInt("_wxapi_subscribemessage_resp_scene");
                this.action = bundle.getString("_wxapi_subscribemessage_resp_action");
                this.reserved = bundle.getString("_wxapi_subscribemessage_resp_reserved");
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 18;
            }
            return invokeV.intValue;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
                super.toBundle(bundle);
                bundle.putString("_wxapi_subscribemessage_resp_templateid", this.templateID);
                bundle.putInt("_wxapi_subscribemessage_resp_scene", this.scene);
                bundle.putString("_wxapi_subscribemessage_resp_action", this.action);
                bundle.putString("_wxapi_subscribemessage_resp_reserved", this.reserved);
            }
        }
    }

    public SubscribeMessage() {
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
