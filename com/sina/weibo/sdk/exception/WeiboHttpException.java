package com.sina.weibo.sdk.exception;
/* loaded from: classes6.dex */
public class WeiboHttpException extends WeiboException {
    public static final long serialVersionUID = 1;
    public final int mStatusCode;

    public WeiboHttpException(String str, int i) {
        super(str);
        this.mStatusCode = i;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
