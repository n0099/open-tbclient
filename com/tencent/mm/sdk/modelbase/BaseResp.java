package com.tencent.mm.sdk.modelbase;

import android.os.Bundle;
import com.baidu.tieba.wallet.pay.PayActivityStatic;
/* loaded from: classes7.dex */
public abstract class BaseResp {
    public int errCode;
    public String errStr;
    public String openId;
    public String transaction;

    /* loaded from: classes7.dex */
    public interface ErrCode {
        public static final int ERR_AUTH_DENIED = -4;
        public static final int ERR_COMM = -1;
        public static final int ERR_OK = 0;
        public static final int ERR_SENT_FAILED = -3;
        public static final int ERR_UNSUPPORT = -5;
        public static final int ERR_USER_CANCEL = -2;
    }

    public abstract boolean checkArgs();

    public void fromBundle(Bundle bundle) {
        this.errCode = bundle.getInt(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE);
        this.errStr = bundle.getString(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR);
        this.transaction = bundle.getString("_wxapi_baseresp_transaction");
        this.openId = bundle.getString("_wxapi_baseresp_openId");
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", getType());
        bundle.putInt(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_CODE, this.errCode);
        bundle.putString(PayActivityStatic.KEY_WX_RECHARGE_RESULT_ERROR_STR, this.errStr);
        bundle.putString("_wxapi_baseresp_transaction", this.transaction);
        bundle.putString("_wxapi_baseresp_openId", this.openId);
    }
}
