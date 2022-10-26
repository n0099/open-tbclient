package com.sina.weibo.sdk.network;

import com.sina.weibo.sdk.network.base.RequestResult;
/* loaded from: classes8.dex */
public interface ResponseCallback {
    void onFailure(Exception exc);

    void onSuccess(RequestResult requestResult);

    void onSuccess(Object obj);
}
