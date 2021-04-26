package com.sina.weibo.sdk.web.client;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.WbUtils;
import com.sina.weibo.sdk.web.WebViewRequestCallback;
import com.sina.weibo.sdk.web.WeiboCallbackManager;
import com.sina.weibo.sdk.web.WeiboSdkWebActivity;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam;
/* loaded from: classes6.dex */
public class ShareWebViewClient extends BaseWebViewClient {
    public static final String RESP_PARAM_CODE = "code";
    public static final String RESP_PARAM_MSG = "msg";
    public static final String RESP_SUCC_CODE = "0";
    public Activity activity;
    public boolean hasCallbacked;

    public ShareWebViewClient(Activity activity, WebViewRequestCallback webViewRequestCallback, BaseWebViewRequestParam baseWebViewRequestParam) {
        super(webViewRequestCallback, baseWebViewRequestParam);
        this.hasCallbacked = false;
        this.activity = activity;
    }

    private boolean needOverLoad(String str) {
        if (str.startsWith(WeiboSdkWebActivity.BROWSER_CLOSE_SCHEME)) {
            Bundle parseUri = WbUtils.parseUri(str);
            if (this.param.getBaseData() != null && !TextUtils.isEmpty(this.param.getBaseData().getCallback())) {
                String callback = this.param.getBaseData().getCallback();
                WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance();
                if (weiboCallbackManager.getWeiboAuthListener(callback) != null && !parseUri.isEmpty()) {
                    weiboCallbackManager.removeWeiboAuthListener(callback);
                }
            }
            String string = parseUri.getString("code");
            String string2 = parseUri.getString("msg");
            if (TextUtils.isEmpty(string)) {
                sendSdkCancleResponse(this.activity);
            } else if (!"0".equals(string)) {
                sendSdkErrorResponse(this.activity, string2);
            } else {
                sendSdkOkResponse(this.activity);
            }
            WebViewRequestCallback webViewRequestCallback = this.requestCallback;
            if (webViewRequestCallback != null) {
                webViewRequestCallback.closePage();
                return true;
            }
            return true;
        }
        return false;
    }

    private void sendSdkResponse(Activity activity, int i2, String str) {
        LogUtil.i("Share", "WebActivity.sendSdkResponse,errCode:" + i2 + ",errMsg:" + str);
        Bundle extras = activity.getIntent().getExtras();
        if (extras == null || this.hasCallbacked) {
            return;
        }
        Intent intent = new Intent(WBConstants.ACTIVITY_REQ_SDK);
        String string = extras.getString("packageName");
        intent.setFlags(131072);
        intent.setPackage(string);
        intent.putExtras(extras);
        intent.putExtra(WBConstants.Base.APP_PKG, activity.getPackageName());
        intent.putExtra(WBConstants.Response.ERRCODE, i2);
        intent.putExtra(WBConstants.Response.ERRMSG, str);
        try {
            activity.startActivityForResult(intent, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
        } catch (ActivityNotFoundException unused) {
        }
        this.hasCallbacked = true;
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient
    public void closeWeb() {
        super.closeWeb();
        sendSdkCancleResponse(this.activity);
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient
    public void errorBack(Activity activity, String str) {
        super.errorBack(activity, str);
        sendSdkErrorResponse(activity, str);
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient
    public boolean onBackKeyDown() {
        closeWeb();
        WebViewRequestCallback webViewRequestCallback = this.requestCallback;
        if (webViewRequestCallback != null) {
            webViewRequestCallback.closePage();
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        WebViewRequestCallback webViewRequestCallback = this.requestCallback;
        if (webViewRequestCallback != null) {
            webViewRequestCallback.onPageFinishedCallBack(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        WebViewRequestCallback webViewRequestCallback = this.requestCallback;
        if (webViewRequestCallback != null) {
            webViewRequestCallback.onPageStartedCallBack(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        WebViewRequestCallback webViewRequestCallback = this.requestCallback;
        if (webViewRequestCallback != null) {
            webViewRequestCallback.onReceivedErrorCallBack(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    public void sendSdkCancleResponse(Activity activity) {
        sendSdkResponse(activity, 1, "send cancel!!!");
    }

    public void sendSdkErrorResponse(Activity activity, String str) {
        sendSdkResponse(activity, 2, str);
    }

    public void sendSdkOkResponse(Activity activity) {
        sendSdkResponse(activity, 0, "send ok!!!");
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient, android.webkit.WebViewClient
    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return needOverLoad(webResourceRequest.getUrl().toString());
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebViewRequestCallback webViewRequestCallback = this.requestCallback;
        if (webViewRequestCallback != null) {
            webViewRequestCallback.shouldOverrideUrlLoadingCallBack(webView, str);
        }
        return needOverLoad(str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        WebViewRequestCallback webViewRequestCallback = this.requestCallback;
        if (webViewRequestCallback != null) {
            webViewRequestCallback.onReceivedErrorCallBack(webView, i2, str, str2);
        }
    }
}
