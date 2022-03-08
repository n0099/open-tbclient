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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.WbUtils;
import com.sina.weibo.sdk.web.WebViewRequestCallback;
import com.sina.weibo.sdk.web.WeiboCallbackManager;
import com.sina.weibo.sdk.web.WeiboSdkWebActivity;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam;
/* loaded from: classes8.dex */
public class ShareWebViewClient extends BaseWebViewClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String RESP_PARAM_CODE = "code";
    public static final String RESP_PARAM_MSG = "msg";
    public static final String RESP_SUCC_CODE = "0";
    public transient /* synthetic */ FieldHolder $fh;
    public Activity activity;
    public boolean hasCallbacked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareWebViewClient(Activity activity, WebViewRequestCallback webViewRequestCallback, BaseWebViewRequestParam baseWebViewRequestParam) {
        super(webViewRequestCallback, baseWebViewRequestParam);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, webViewRequestCallback, baseWebViewRequestParam};
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
        this.hasCallbacked = false;
        this.activity = activity;
    }

    private boolean needOverLoad(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
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
        return invokeL.booleanValue;
    }

    private void sendSdkResponse(Activity activity, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, this, activity, i2, str) == null) {
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
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient
    public void closeWeb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.closeWeb();
            sendSdkCancleResponse(this.activity);
        }
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient
    public void errorBack(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str) == null) {
            super.errorBack(activity, str);
            sendSdkErrorResponse(activity, str);
        }
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient
    public boolean onBackKeyDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
            super.onPageFinished(webView, str);
            WebViewRequestCallback webViewRequestCallback = this.requestCallback;
            if (webViewRequestCallback != null) {
                webViewRequestCallback.onPageFinishedCallBack(webView, str);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
            WebViewRequestCallback webViewRequestCallback = this.requestCallback;
            if (webViewRequestCallback != null) {
                webViewRequestCallback.onPageStartedCallBack(webView, str, bitmap);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, webView, webResourceRequest, webResourceError) == null) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            WebViewRequestCallback webViewRequestCallback = this.requestCallback;
            if (webViewRequestCallback != null) {
                webViewRequestCallback.onReceivedErrorCallBack(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }
        }
    }

    public void sendSdkCancleResponse(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            sendSdkResponse(activity, 1, "send cancel!!!");
        }
    }

    public void sendSdkErrorResponse(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, str) == null) {
            sendSdkResponse(activity, 2, str);
        }
    }

    public void sendSdkOkResponse(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, activity) == null) {
            sendSdkResponse(activity, 0, "send ok!!!");
        }
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient, android.webkit.WebViewClient
    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, webResourceRequest)) == null) ? needOverLoad(webResourceRequest.getUrl().toString()) : invokeLL.booleanValue;
    }

    @Override // com.sina.weibo.sdk.web.client.BaseWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, webView, str)) == null) {
            WebViewRequestCallback webViewRequestCallback = this.requestCallback;
            if (webViewRequestCallback != null) {
                webViewRequestCallback.shouldOverrideUrlLoadingCallBack(webView, str);
            }
            return needOverLoad(str);
        }
        return invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048581, this, webView, i2, str, str2) == null) {
            super.onReceivedError(webView, i2, str, str2);
            WebViewRequestCallback webViewRequestCallback = this.requestCallback;
            if (webViewRequestCallback != null) {
                webViewRequestCallback.onReceivedErrorCallBack(webView, i2, str, str2);
            }
        }
    }
}
