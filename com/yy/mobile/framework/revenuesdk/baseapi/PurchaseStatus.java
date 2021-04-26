package com.yy.mobile.framework.revenuesdk.baseapi;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes7.dex */
public enum PurchaseStatus {
    UNKNOWN(0, "未知状态"),
    ORDER_START(100, "开始下单请求"),
    ORDER_SUCCESS(101, "下单请求成功"),
    ORDER_FAIL(102, "下单请求失败"),
    PAY_START(110, "开始支付，支付页面拉起"),
    PAY_CANCEL(111, "支付取消"),
    PAY_SUCCESS(112, "支付成功"),
    PAY_FAIL(113, "支付失败"),
    REPORT_START(120, "上报开始"),
    REPORT_SUCCESS(121, "上报成功"),
    REPORT_FAIL(122, "上报失败");
    
    public final int code;
    public final String msg;

    PurchaseStatus(int i2, String str) {
        this.code = i2;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.msg;
    }

    public static PurchaseStatus valueOf(int i2) {
        if (i2 != 120) {
            if (i2 != 121) {
                switch (i2) {
                    case 100:
                        return ORDER_START;
                    case 101:
                        return ORDER_SUCCESS;
                    case 102:
                        return ORDER_FAIL;
                    default:
                        switch (i2) {
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
            return REPORT_FAIL;
        }
        return REPORT_SUCCESS;
    }
}
