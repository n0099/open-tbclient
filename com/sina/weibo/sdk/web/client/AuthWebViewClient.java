package com.sina.weibo.sdk.web.client;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.web.WebViewRequestCallback;
import com.sina.weibo.sdk.web.WeiboCallbackManager;
import com.sina.weibo.sdk.web.WeiboSdkWebActivity;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam;
/* loaded from: classes6.dex */
public class AuthWebViewClient extends BaseWebViewClient {
    private static final String TAG = "AuthWebViewClient";
    private boolean authed;
    private Context context;

    public AuthWebViewClient(WebViewRequestCallback webViewRequestCallback, Context context, BaseWebViewRequestParam baseWebViewRequestParam) {
        super(webViewRequestCallback, baseWebViewRequestParam);
        this.authed = false;
        this.context = context;
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient, android.webkit.WebViewClient
    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        LogUtil.d(TAG, "shouldOverrideUrlLoading,request.getUrl()");
        return needOverLoad(webView, webResourceRequest.getUrl().toString());
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        LogUtil.d(TAG, "shouldOverrideUrlLoading,url");
        return needOverLoad(webView, str);
    }

    private boolean needOverLoad(WebView webView, String str) {
        if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.putExtra("address", str.replace(UrlSchemaHelper.SCHEMA_TYPE_SMS, ""));
                intent.setType("vnd.android-dir/mms-sms");
                this.context.startActivity(intent);
                return true;
            } catch (Exception e) {
            }
        } else if (str.startsWith(WeiboSdkWebActivity.BROWSER_CLOSE_SCHEME)) {
            if (this.param.getBaseData() == null || TextUtils.isEmpty(this.param.getBaseData().getCallback())) {
                return true;
            }
            String callback = this.param.getBaseData().getCallback();
            WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance();
            if (weiboCallbackManager.getWeiboAuthListener(callback) != null) {
                weiboCallbackManager.getWeiboAuthListener(callback).cancel();
            }
            weiboCallbackManager.removeWeiboAuthListener(callback);
            return true;
        } else if (isMatchWithRedirectUrl(str) && !TextUtils.isEmpty(Utility.parseUrl(str).getString("access_token"))) {
            return true;
        }
        return false;
    }

    private boolean isMatchWithRedirectUrl(String str) {
        Uri parse = Uri.parse(this.param.getBaseData().getAuthInfo().getRedirectUrl());
        Uri parse2 = Uri.parse(str);
        String host = parse.getHost();
        return !TextUtils.isEmpty(host) && host.equals(parse2.getHost());
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        LogUtil.d(TAG, "onPageStarted:");
        if (this.requestCallback != null) {
            this.requestCallback.onPageStartedCallBack(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        LogUtil.d(TAG, "onPageFinished:");
        super.onPageFinished(webView, str);
        if (this.requestCallback != null) {
            this.requestCallback.onPageFinishedCallBack(webView, str);
        }
        if (isMatchWithRedirectUrl(str) && !this.authed) {
            this.authed = true;
            handleRedirectUrl(str);
            webView.stopLoading();
            if (this.requestCallback != null) {
                this.requestCallback.closePage();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(24)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        LogUtil.d(TAG, "onReceivedError");
        if (this.requestCallback != null) {
            this.requestCallback.onReceivedErrorCallBack(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        LogUtil.d(TAG, "onReceivedError");
        if (this.requestCallback != null) {
            this.requestCallback.onReceivedErrorCallBack(webView, i, str, str2);
        }
    }

    private void handleRedirectUrl(String str) {
        Bundle parseUrl = Utility.parseUrl(str);
        String string = parseUrl.getString(BdStatsConstant.StatsType.ERROR);
        String string2 = parseUrl.getString("error_code");
        String string3 = parseUrl.getString("error_description");
        WbAuthListener wbAuthListener = null;
        if (this.param.getBaseData() != null && !TextUtils.isEmpty(this.param.getBaseData().getCallback())) {
            String callback = this.param.getBaseData().getCallback();
            WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance();
            wbAuthListener = weiboCallbackManager.getWeiboAuthListener(callback);
            weiboCallbackManager.removeWeiboAuthListener(callback);
        }
        if (string == null && string2 == null) {
            if (wbAuthListener != null) {
                Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(parseUrl);
                AccessTokenKeeper.writeAccessToken(this.context, parseAccessToken);
                wbAuthListener.onSuccess(parseAccessToken);
            }
        } else if (wbAuthListener != null) {
            wbAuthListener.onFailure(new WbConnectErrorMessage(string2, string3));
        }
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient
    public void closeWeb() {
        super.closeWeb();
        if (this.param.getBaseData() != null && !TextUtils.isEmpty(this.param.getBaseData().getCallback())) {
            String callback = this.param.getBaseData().getCallback();
            WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance();
            if (weiboCallbackManager.getWeiboAuthListener(callback) != null) {
                weiboCallbackManager.getWeiboAuthListener(callback).cancel();
            }
            weiboCallbackManager.removeWeiboAuthListener(callback);
        }
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient
    public boolean onBackKeyDown() {
        closeWeb();
        if (this.requestCallback != null) {
            this.requestCallback.closePage();
            return true;
        }
        return true;
    }
}
