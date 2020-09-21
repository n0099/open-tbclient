package com.sina.weibo.sdk.exception;
/* loaded from: classes24.dex */
public class WeiboHttpException extends WeiboException {
    private static final long serialVersionUID = 1;
    private final int mStatusCode;

    public WeiboHttpException(String str, int i) {
        super(str);
        this.mStatusCode = i;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
