package com.sina.weibo.sdk.component;

import android.webkit.WebViewClient;
/* loaded from: classes3.dex */
abstract class WeiboWebViewClient extends WebViewClient {
    protected BrowserRequestCallBack mCallBack;

    public void setBrowserRequestCallBack(BrowserRequestCallBack browserRequestCallBack) {
        this.mCallBack = browserRequestCallBack;
    }
}
