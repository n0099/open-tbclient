package com.yy.mobile.framework.revenuesdk.payapi.payservice;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
/* loaded from: classes7.dex */
public interface IPayMethod {

    /* loaded from: classes7.dex */
    public enum Status {
        OK(0, "支付成功"),
        NOT_SUPPORT(-101, "当前不支持该种支付方式"),
        ERROR(-102, "支付错误"),
        UNKNOWN(-103, "未知错误");
        
        public final int code;
        public final String message;

        Status(int i2, String str) {
            this.code = i2;
            this.message = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public static Status valueOf(int i2) {
            if (i2 != 0) {
                switch (i2) {
                    case -103:
                        return UNKNOWN;
                    case -102:
                        return ERROR;
                    case -101:
                        return NOT_SUPPORT;
                    default:
                        return UNKNOWN;
                }
            }
            return OK;
        }
    }

    boolean isPayingStatus();

    boolean isSupported(Activity activity);

    void onWxPayResult(int i2, String str);

    void requestPay(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback);
}
