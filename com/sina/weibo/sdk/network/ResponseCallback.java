package com.sina.weibo.sdk.network;

import com.sina.weibo.sdk.network.base.RequestResult;
/* loaded from: classes8.dex */
public interface ResponseCallback<E> {
    void onFailure(Exception exc);

    void onSuccess(RequestResult requestResult);

    void onSuccess(E e2);
}
