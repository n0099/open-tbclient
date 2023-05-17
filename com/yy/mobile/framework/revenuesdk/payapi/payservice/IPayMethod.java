package com.yy.mobile.framework.revenuesdk.payapi.payservice;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
/* loaded from: classes10.dex */
public interface IPayMethod {
    boolean isSupported(Activity activity);

    void onQQPayResult(int i, String str);

    void onWxPayResult(int i, String str);

    void requestPay(Activity activity, long j, ProductInfo productInfo, String str, IPayCallback<PurchaseInfo> iPayCallback);

    void requestPay(Activity activity, long j, String str, String str2, IPayCallback<PurchaseInfo> iPayCallback);

    /* loaded from: classes10.dex */
    public enum Status {
        OK(0, EventAlias.PayEventAlias.PAY_SUCCESS),
        NOT_SUPPORT(-101, "当前设备不支持该支付方式"),
        ERROR(-102, "支付错误"),
        UNKNOWN(-103, "未知错误");
        
        public final int code;
        public final String message;

        Status(int i, String str) {
            this.code = i;
            this.message = str;
        }

        public static Status valueOf(int i) {
            if (i != 0) {
                switch (i) {
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

        public int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }
    }
}
