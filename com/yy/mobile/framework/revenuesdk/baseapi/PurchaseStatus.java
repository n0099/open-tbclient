package com.yy.mobile.framework.revenuesdk.baseapi;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
@Keep
/* loaded from: classes2.dex */
public enum PurchaseStatus {
    UNKNOWN(0, "未知状态"),
    ORDER_START(100, "开始下单请求"),
    ORDER_SUCCESS(101, "下单请求成功"),
    ORDER_FAIL(102, "下单请求失败"),
    PAY_START(110, "开始支付，支付页面拉起"),
    PAY_CANCEL(111, "支付取消"),
    PAY_SUCCESS(112, EventAlias.PayEventAlias.PAY_SUCCESS),
    PAY_FAIL(113, EventAlias.PayEventAlias.PAY_FAIL);
    
    public final int code;
    public final String msg;

    PurchaseStatus(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public static PurchaseStatus valueOf(int i) {
        switch (i) {
            case 100:
                return ORDER_START;
            case 101:
                return ORDER_SUCCESS;
            case 102:
                return ORDER_FAIL;
            default:
                switch (i) {
                    case 110:
                        return PAY_START;
                    case 111:
                        return PAY_CANCEL;
                    case 112:
                        return PAY_SUCCESS;
                    case 113:
                        return PAY_FAIL;
                    default:
                        return UNKNOWN;
                }
        }
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.msg;
    }
}
