package com.sina.weibo.sdk.exception;
/* loaded from: classes6.dex */
public class WeiboHttpException extends WeiboException {
    public static final long serialVersionUID = 1;
    public final int mStatusCode;

    public WeiboHttpException(String str, int i2) {
        super(str);
        this.mStatusCode = i2;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
