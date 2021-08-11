package com.tencent.mm.sdk.modelbase;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wallet.pay.PayActivityStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public abstract class BaseResp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int errCode;
    public String errStr;
    public String openId;
    public String transaction;

    /* loaded from: classes10.dex */
    public interface ErrCode {
        public static final int ERR_AUTH_DENIED = -4;
        public static final int ERR_COMM = -1;
        public static final int ERR_OK = 0;
        public static final int ERR_SENT_FAILED = -3;
        public static final int ERR_UNSUPPORT = -5;
        public static final int ERR_USER_CANCEL = -2;
    }

    public BaseResp() {
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

    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.errCode = bundle.getInt(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE);
            this.errStr = bundle.getString(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR);
            this.transaction = bundle.getString("_wxapi_baseresp_transaction");
            this.openId = bundle.getString("_wxapi_baseresp_openId");
        }
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            bundle.putInt("_wxapi_command_type", getType());
            bundle.putInt(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE, this.errCode);
            bundle.putString(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR, this.errStr);
            bundle.putString("_wxapi_baseresp_transaction", this.transaction);
            bundle.putString("_wxapi_baseresp_openId", this.openId);
        }
    }
}
