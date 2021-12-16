package com.sina.weibo.sdk.auth;
/* loaded from: classes3.dex */
public interface WbAuthListener {
    void cancel();

    void onFailure(WbConnectErrorMessage wbConnectErrorMessage);

    void onSuccess(Oauth2AccessToken oauth2AccessToken);
}
