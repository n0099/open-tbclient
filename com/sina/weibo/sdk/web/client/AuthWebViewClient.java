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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class AuthWebViewClient extends BaseWebViewClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AuthWebViewClient";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean authed;
    public Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthWebViewClient(WebViewRequestCallback webViewRequestCallback, Context context, BaseWebViewRequestParam baseWebViewRequestParam) {
        super(webViewRequestCallback, baseWebViewRequestParam);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webViewRequestCallback, context, baseWebViewRequestParam};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((WebViewRequestCallback) objArr2[0], (BaseWebViewRequestParam) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.authed = false;
        this.context = context;
    }

    private void handleRedirectUrl(String str) {
        WbAuthListener wbAuthListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            Bundle parseUrl = Utility.parseUrl(str);
            String string = parseUrl.getString("error");
            String string2 = parseUrl.getString("error_code");
            String string3 = parseUrl.getString("error_description");
            if (this.param.getBaseData() == null || TextUtils.isEmpty(this.param.getBaseData().getCallback())) {
                wbAuthListener = null;
            } else {
                String callback = this.param.getBaseData().getCallback();
                WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance();
                wbAuthListener = weiboCallbackManager.getWeiboAuthListener(callback);
                weiboCallbackManager.removeWeiboAuthListener(callback);
            }
            if (string != null || string2 != null) {
                if (wbAuthListener != null) {
                    wbAuthListener.onFailure(new WbConnectErrorMessage(string2, string3));
                }
            } else if (wbAuthListener != null) {
                Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(parseUrl);
                AccessTokenKeeper.writeAccessToken(this.context, parseAccessToken);
                wbAuthListener.onSuccess(parseAccessToken);
            }
        }
    }

    private boolean isMatchWithRedirectUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            Uri parse = Uri.parse(this.param.getBaseData().getAuthInfo().getRedirectUrl());
            Uri parse2 = Uri.parse(str);
            String host = parse.getHost();
            return !TextUtils.isEmpty(host) && host.equals(parse2.getHost());
        }
        return invokeL.booleanValue;
    }

    private boolean needOverLoad(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, webView, str)) == null) {
            if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.putExtra("address", str.replace(UrlSchemaHelper.SCHEMA_TYPE_SMS, ""));
                    intent.setType("vnd.android-dir/mms-sms");
                    this.context.startActivity(intent);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            } else if (!str.startsWith(WeiboSdkWebActivity.BROWSER_CLOSE_SCHEME)) {
                return isMatchWithRedirectUrl(str) && !TextUtils.isEmpty(Utility.parseUrl(str).getString("access_token"));
            } else {
                if (this.param.getBaseData() != null && !TextUtils.isEmpty(this.param.getBaseData().getCallback())) {
                    String callback = this.param.getBaseData().getCallback();
                    WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance();
                    if (weiboCallbackManager.getWeiboAuthListener(callback) != null) {
                        weiboCallbackManager.getWeiboAuthListener(callback).cancel();
                    }
                    weiboCallbackManager.removeWeiboAuthListener(callback);
                }
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient
    public void closeWeb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.closeWeb();
            if (this.param.getBaseData() == null || TextUtils.isEmpty(this.param.getBaseData().getCallback())) {
                return;
            }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            closeWeb();
            WebViewRequestCallback webViewRequestCallback = this.requestCallback;
            if (webViewRequestCallback != null) {
                webViewRequestCallback.closePage();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
            LogUtil.d(TAG, "onPageFinished:");
            super.onPageFinished(webView, str);
            WebViewRequestCallback webViewRequestCallback = this.requestCallback;
            if (webViewRequestCallback != null) {
                webViewRequestCallback.onPageFinishedCallBack(webView, str);
            }
            if (!isMatchWithRedirectUrl(str) || this.authed) {
                return;
            }
            this.authed = true;
            handleRedirectUrl(str);
            webView.stopLoading();
            WebViewRequestCallback webViewRequestCallback2 = this.requestCallback;
            if (webViewRequestCallback2 != null) {
                webViewRequestCallback2.closePage();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, str, bitmap) == null) {
            LogUtil.d(TAG, "onPageStarted:");
            WebViewRequestCallback webViewRequestCallback = this.requestCallback;
            if (webViewRequestCallback != null) {
                webViewRequestCallback.onPageStartedCallBack(webView, str, bitmap);
            }
            super.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(24)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, webView, webResourceRequest, webResourceError) == null) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            LogUtil.d(TAG, "onReceivedError");
            WebViewRequestCallback webViewRequestCallback = this.requestCallback;
            if (webViewRequestCallback != null) {
                webViewRequestCallback.onReceivedErrorCallBack(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }
        }
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient, android.webkit.WebViewClient
    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, webResourceRequest)) == null) {
            LogUtil.d(TAG, "shouldOverrideUrlLoading,request.getUrl()");
            return needOverLoad(webView, webResourceRequest.getUrl().toString());
        }
        return invokeLL.booleanValue;
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, str)) == null) {
            LogUtil.d(TAG, "shouldOverrideUrlLoading,url");
            return needOverLoad(webView, str);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, webView, i2, str, str2) == null) {
            super.onReceivedError(webView, i2, str, str2);
            LogUtil.d(TAG, "onReceivedError");
            WebViewRequestCallback webViewRequestCallback = this.requestCallback;
            if (webViewRequestCallback != null) {
                webViewRequestCallback.onReceivedErrorCallBack(webView, i2, str, str2);
            }
        }
    }
}
