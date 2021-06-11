package com.yy.mobile.framework.revenuesdk.payapi;

import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
/* loaded from: classes7.dex */
public enum PayStatus {
    OK(1, "请求成功"),
    VALIDATE_FAIL(-1, "账号验证失败"),
    CAN_NOT_USE(-5, "账户已冻结"),
    APPLE_PAY_FAIL(-14, "苹果支付凭证重复验证"),
    WRONG_ARGS(ErrorCode.ARGS_ERROR, "参数错误，特指参数缺失"),
    SEVER_ERROR(-500, "服务端错误"),
    ORDER_RISK_ERROR(-18, "风控拦截"),
    UNKNOWN(0, "未知状态"),
    CANCEL(-6001, "用户取消支付");
    
    public final int code;
    public final String msg;

    PayStatus(int i2, String str) {
        this.code = i2;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.msg;
    }

    public static PayStatus valueOf(int i2) {
        if (i2 != -500) {
            if (i2 != -400) {
                if (i2 != -18) {
                    if (i2 != -14) {
                        if (i2 != -5) {
                            if (i2 != -1) {
                                if (i2 != 1) {
                                    return UNKNOWN;
                                }
                                return OK;
                            }
                            return VALIDATE_FAIL;
                        }
                        return CAN_NOT_USE;
                    }
                    return APPLE_PAY_FAIL;
                }
                return ORDER_RISK_ERROR;
            }
            return WRONG_ARGS;
        }
        return SEVER_ERROR;
    }
}
