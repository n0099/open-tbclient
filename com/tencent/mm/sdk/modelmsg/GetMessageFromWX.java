package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
/* loaded from: classes2.dex */
public final class GetMessageFromWX {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class Req extends BaseReq {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String username;

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

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public boolean checkArgs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                super.fromBundle(bundle);
            }
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
                super.toBundle(bundle);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class Resp extends BaseResp {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "MicroMsg.SDK.GetMessageFromWX.Resp";
        public transient /* synthetic */ FieldHolder $fh;
        public WXMediaMessage message;

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

        @Override // com.tencent.mm.sdk.modelbase.BaseResp
        public boolean checkArgs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                WXMediaMessage wXMediaMessage = this.message;
                if (wXMediaMessage == null) {
                    a.a("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
                    return false;
                }
                return wXMediaMessage.checkArgs();
            }
            return invokeV.booleanValue;
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                super.fromBundle(bundle);
                this.message = WXMediaMessage.Builder.fromBundle(bundle);
            }
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseResp
        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
                super.toBundle(bundle);
                bundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
            }
        }
    }

    public GetMessageFromWX() {
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
