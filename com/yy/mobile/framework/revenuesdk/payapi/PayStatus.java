package com.yy.mobile.framework.revenuesdk.payapi;

import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
/* loaded from: classes9.dex */
public enum PayStatus {
    OK(1, "请求成功"),
    VALIDATE_FAIL(-1, "账号验证失败"),
    CAN_NOT_USE(-5, "账户已冻结"),
    APPLE_PAY_FAIL(-14, "苹果支付凭证重复验证"),
    WRONG_ARGS(ErrorCode.ARGS_ERROR, "参数错误，特指参数缺失"),
    SEVER_ERROR(ErrorCode.SERVER_ERROR, "服务端错误"),
    ORDER_RISK_ERROR(-18, "风控拦截"),
    UNKNOWN(0, "未知状态"),
    CANCEL(-6001, "用户取消支付"),
    DEVICE_NOT_SUPPORT(3, "当前设备不支持该支付方式");
    
    public final int code;
    public final String msg;

    PayStatus(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public static PayStatus valueOf(int i) {
        if (i != -500) {
            if (i != -400) {
                if (i != -18) {
                    if (i != -14) {
                        if (i != -5) {
                            if (i != -1) {
                                if (i != 1) {
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

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.msg;
    }
}
