package com.yy.mobile.framework.revenuesdk.baseapi;
/* loaded from: classes7.dex */
public interface RetryPolicy {

    /* loaded from: classes7.dex */
    public enum Status {
        RETRY_COUNT_EXHAUST(-1001, "重试次数用完了"),
        RETRY_CANCEL(-1002, "取消重试"),
        UNKNOWN(-1003, "未知状态");
        
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
            if (i2 != -1001) {
                return UNKNOWN;
            }
            return RETRY_COUNT_EXHAUST;
        }
    }

    void d();
}
