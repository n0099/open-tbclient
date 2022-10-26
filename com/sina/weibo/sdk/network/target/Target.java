package com.sina.weibo.sdk.network.target;

import com.sina.weibo.sdk.network.base.WbResponse;
/* loaded from: classes8.dex */
public interface Target {
    void onError();

    void onFailure(Exception exc);

    void onRequestDone();

    void onRequestSuccess(Object obj);

    void onRequestSuccessBg(Object obj);

    void onStart();

    void onStartBg();

    Object transResponse(WbResponse wbResponse) throws Exception;
}
