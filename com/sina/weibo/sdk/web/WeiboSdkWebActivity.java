package com.sina.weibo.sdk.web;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.sina.weibo.sdk.auth.BaseSsoHandler;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.UIUtils;
import com.sina.weibo.sdk.utils.WbUtils;
import com.sina.weibo.sdk.web.client.AuthWebViewClient;
import com.sina.weibo.sdk.web.client.BaseWebViewClient;
import com.sina.weibo.sdk.web.client.DefaultWebViewClient;
import com.sina.weibo.sdk.web.client.ShareWebViewClient;
import com.sina.weibo.sdk.web.param.AuthWebViewRequestParam;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam;
import com.sina.weibo.sdk.web.param.DefaultWebViewRequestParam;
import com.sina.weibo.sdk.web.param.ShareWebViewRequestParam;
import com.sina.weibo.sdk.web.view.LoadingBar;
/* loaded from: classes10.dex */
public class WeiboSdkWebActivity extends Activity implements WebViewRequestCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BROWSER_CLOSE_SCHEME = "sinaweibo://browser/close";
    public static final String CANCEL_EN = "Close";
    public static final String CANCEL_ZH_CN = "关闭";
    public static final String CANCEL_ZH_TW = "关闭";
    public static final String CHANNEL_DATA_ERROR_EN = "channel_data_error";
    public static final String CHANNEL_DATA_ERROR_ZH_CN = "重新加载";
    public static final String CHANNEL_DATA_ERROR_ZH_TW = "重新載入";
    public static final String EMPTY_PROMPT_BAD_NETWORK_UI_EN = "A network error occurs, please tap the button to reload";
    public static final String EMPTY_PROMPT_BAD_NETWORK_UI_ZH_CN = "网络出错啦，请点击按钮重新加载";
    public static final String EMPTY_PROMPT_BAD_NETWORK_UI_ZH_TW = "網路出錯啦，請點擊按鈕重新載入";
    public static final String LOADINFO_EN = "Loading....";
    public static final String LOADINFO_ZH_CN = "加载中....";
    public static final String LOADINFO_ZH_TW = "載入中....";
    public static final String WEIBOBROWSER_NO_TITLE_EN = "No Title";
    public static final String WEIBOBROWSER_NO_TITLE_ZH_CN = "无标题";
    public static final String WEIBOBROWSER_NO_TITLE_ZH_TW = "無標題";
    public transient /* synthetic */ FieldHolder $fh;
    public BaseWebViewRequestParam baseParam;
    public TextView leftBtn;
    public LoadingBar loadingBar;
    public int pageStatus;
    public Button retryBtn;
    public LinearLayout retryLayout;
    public TextView retryTitle;
    public TextView titleText;
    public WebView webView;
    public BaseWebViewClient webViewClient;

    @Override // com.sina.weibo.sdk.web.WebViewRequestCallback
    public void onPageStartedCallBack(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, str, bitmap) == null) {
        }
    }

    @Override // com.sina.weibo.sdk.web.WebViewRequestCallback
    public boolean shouldOverrideUrlLoadingCallBack(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, str)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* loaded from: classes10.dex */
    public class MyChromeClient extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WeiboSdkWebActivity this$0;

        public MyChromeClient(WeiboSdkWebActivity weiboSdkWebActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weiboSdkWebActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = weiboSdkWebActivity;
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                if (TextUtils.isEmpty(this.this$0.baseParam.getBaseData().getSpecifyTitle())) {
                    this.this$0.titleText.setText(str);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, webView, i) == null) {
                super.onProgressChanged(webView, i);
                this.this$0.loadingBar.drawProgress(i);
                if (i == 100) {
                    this.this$0.loadingBar.setVisibility(4);
                } else {
                    this.this$0.loadingBar.setVisibility(0);
                }
            }
        }
    }

    public WeiboSdkWebActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.pageStatus = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDefaultPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.retryLayout.setVisibility(8);
            this.webView.setVisibility(0);
        }
    }

    private void showErrorPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.retryLayout.setVisibility(0);
            this.webView.setVisibility(8);
        }
    }

    @Override // com.sina.weibo.sdk.web.WebViewRequestCallback
    public void closePage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkRequestUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith(ShareWebViewRequestParam.SHARE_URL) || str.startsWith(BaseSsoHandler.OAUTH2_BASE_URL)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            LogUtil.i("Share", "startWebActivity");
            requestWindowFeature(1);
            super.onCreate(bundle);
            setContentView(initView());
            initLoad();
        }
    }

    public static void removeJavascriptInterface(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, webView, str) == null) {
            try {
                WebView.class.getDeclaredMethod("removeJavascriptInterface", String.class).invoke(webView, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (this.webViewClient.onBackKeyDown()) {
                    return true;
                }
                if (this.webView.canGoBack()) {
                    this.webView.goBack();
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.sina.weibo.sdk.web.WebViewRequestCallback
    public void onPageFinishedCallBack(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
            if (this.pageStatus == -1) {
                showErrorPage();
            } else {
                showDefaultPage();
            }
        }
    }

    private void initLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            LogUtil.i("Share", "WebActivity.initLoad().start");
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            int i = extras.getInt("type", -1);
            if (i == -1) {
                finish();
                return;
            }
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        this.baseParam = new AuthWebViewRequestParam();
                        this.webViewClient = new AuthWebViewClient(this, this, this.baseParam);
                    }
                } else {
                    this.baseParam = new ShareWebViewRequestParam(this);
                    this.webViewClient = new ShareWebViewClient(this, this, this.baseParam);
                }
            } else {
                this.baseParam = new DefaultWebViewRequestParam();
                this.webViewClient = new DefaultWebViewClient(this, this.baseParam);
            }
            this.webView.setWebViewClient(this.webViewClient);
            this.baseParam.transformBundle(extras);
            initWebView();
            if (this.baseParam.hasExtraTask()) {
                this.baseParam.doExtraTask(new BaseWebViewRequestParam.ExtraTaskCallback(this) { // from class: com.sina.weibo.sdk.web.WeiboSdkWebActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WeiboSdkWebActivity this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam.ExtraTaskCallback
                    public void onException(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                            LogUtil.i("Share", "WebActivity.sharePic.onException()");
                            this.this$0.webViewClient.errorBack(this.this$0, "pic upload error");
                            this.this$0.finish();
                        }
                    }

                    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam.ExtraTaskCallback
                    public void onComplete(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                            LogUtil.i("Share", "WebActivity.sharePic.onComplete()");
                            WeiboSdkWebActivity weiboSdkWebActivity = this.this$0;
                            if (weiboSdkWebActivity.checkRequestUrl(weiboSdkWebActivity.baseParam.getRequestUrl())) {
                                this.this$0.webView.loadUrl(this.this$0.baseParam.getRequestUrl());
                            }
                        }
                    }
                });
            } else {
                String requestUrl = this.baseParam.getRequestUrl();
                if (checkRequestUrl(requestUrl)) {
                    this.webView.loadUrl(requestUrl);
                }
            }
            LogUtil.i("Share", "WebActivity.initLoad().end");
        }
    }

    private View initView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            relativeLayout.setBackgroundColor(-1);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            TextView textView = new TextView(this);
            this.leftBtn = textView;
            textView.setTextSize(17.0f);
            this.leftBtn.setTextColor(ResourceManager.createColorStateList(-32256, 1728020992));
            this.leftBtn.setText(ResourceManager.getString(this, "Close", "关闭", "关闭"));
            this.leftBtn.setOnClickListener(new View.OnClickListener(this) { // from class: com.sina.weibo.sdk.web.WeiboSdkWebActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WeiboSdkWebActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.webViewClient.closeWeb();
                        this.this$0.closeActivity();
                    }
                }
            });
            TextView textView2 = new TextView(this);
            this.titleText = textView2;
            textView2.setTextSize(18.0f);
            this.titleText.setTextColor(-11382190);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            this.leftBtn.setPadding(UIUtils.dip2px(10, this), 0, UIUtils.dip2px(10, this), 0);
            layoutParams2.addRule(13);
            relativeLayout2.addView(this.leftBtn, layoutParams);
            relativeLayout2.addView(this.titleText, layoutParams2);
            relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, UIUtils.dip2px(55, this)));
            WebView webView = new WebView(getApplicationContext());
            this.webView = webView;
            webView.getSettings().setSavePassword(false);
            this.webView.getSettings().setAllowFileAccess(false);
            this.webView.getSettings().setAllowContentAccess(false);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.topMargin = UIUtils.dip2px(55, this);
            relativeLayout.addView(this.webView, layoutParams3);
            this.loadingBar = new LoadingBar(this);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, UIUtils.dip2px(3, this));
            layoutParams4.topMargin = UIUtils.dip2px(55, this);
            relativeLayout.addView(this.loadingBar, layoutParams4);
            View view2 = new View(this);
            view2.setBackgroundResource(getResources().getIdentifier("weibosdk_common_shadow_top", ResourceManager.DRAWABLE, getPackageName()));
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, UIUtils.dip2px(3, this));
            layoutParams5.topMargin = UIUtils.dip2px(55, this);
            relativeLayout.addView(view2, layoutParams5);
            LinearLayout linearLayout = new LinearLayout(this);
            this.retryLayout = linearLayout;
            linearLayout.setOrientation(1);
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(getResources().getIdentifier("weibosdk_empty_failed", ResourceManager.DRAWABLE, getPackageName()));
            this.retryLayout.addView(imageView);
            TextView textView3 = new TextView(this);
            this.retryTitle = textView3;
            textView3.setTextSize(14.0f);
            this.retryTitle.setTextColor(-4342339);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams6.topMargin = UIUtils.dip2px(18, this);
            layoutParams6.bottomMargin = UIUtils.dip2px(20, this);
            this.retryLayout.addView(this.retryTitle, layoutParams6);
            Button button = new Button(this);
            this.retryBtn = button;
            button.setTextSize(16.0f);
            this.retryBtn.setTextColor(-8882056);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(UIUtils.dip2px(Cea708Decoder.COMMAND_DLC, this), UIUtils.dip2px(46, this));
            layoutParams7.gravity = 17;
            this.retryLayout.addView(this.retryBtn, layoutParams7);
            this.retryBtn.setBackgroundResource(getResources().getIdentifier("retry_btn_selector", ResourceManager.DRAWABLE, getPackageName()));
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams8.addRule(13);
            relativeLayout.addView(this.retryLayout, layoutParams8);
            this.retryLayout.setVisibility(8);
            this.webView.setWebChromeClient(new MyChromeClient());
            this.retryBtn.setOnClickListener(new View.OnClickListener(this) { // from class: com.sina.weibo.sdk.web.WeiboSdkWebActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WeiboSdkWebActivity this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view3) != null) {
                        return;
                    }
                    this.this$0.pageStatus = 0;
                    this.this$0.showDefaultPage();
                    this.this$0.webView.reload();
                }
            });
            this.retryTitle.setText(ResourceManager.getString(this, EMPTY_PROMPT_BAD_NETWORK_UI_EN, EMPTY_PROMPT_BAD_NETWORK_UI_ZH_CN, EMPTY_PROMPT_BAD_NETWORK_UI_ZH_TW));
            this.retryBtn.setText(ResourceManager.getString(this, CHANNEL_DATA_ERROR_EN, CHANNEL_DATA_ERROR_ZH_CN, CHANNEL_DATA_ERROR_ZH_TW));
            return relativeLayout;
        }
        return (View) invokeV.objValue;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (!TextUtils.isEmpty(this.baseParam.getBaseData().getSpecifyTitle())) {
                this.titleText.setText(this.baseParam.getBaseData().getSpecifyTitle());
            }
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.getSettings().setSavePassword(false);
            this.webView.getSettings().setUserAgentString(WbUtils.generateUA(this, this.baseParam.getBaseData().getAuthInfo().getAppKey()));
            this.webView.requestFocus();
            this.webView.setScrollBarStyle(0);
            removeJavascriptInterface(this.webView, "searchBoxJavaBridge_");
            removeJavascriptInterface(this.webView, "accessibility");
            removeJavascriptInterface(this.webView, "accessibilityTraversal");
            if (Build.VERSION.SDK_INT >= 21) {
                this.webView.getSettings().setMixedContentMode(2);
            }
        }
    }

    @Override // com.sina.weibo.sdk.web.WebViewRequestCallback
    public void onReceivedErrorCallBack(WebView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048581, this, webView, i, str, str2) == null) {
            String url = webView.getUrl();
            try {
                if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(str2)) {
                    Uri parse = Uri.parse(url);
                    Uri parse2 = Uri.parse(str2);
                    if (parse.getHost().equals(parse2.getHost()) && parse.getScheme().equals(parse2.getScheme())) {
                        this.pageStatus = -1;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.sina.weibo.sdk.web.WebViewRequestCallback
    public void onReceivedSslErrorCallBack(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, webView, sslErrorHandler, sslError) == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("警告");
            builder.setMessage("你访问的连接可能存在隐患，是否继续访问");
            builder.setPositiveButton("继续", new DialogInterface.OnClickListener(this, sslErrorHandler) { // from class: com.sina.weibo.sdk.web.WeiboSdkWebActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WeiboSdkWebActivity this$0;
                public final /* synthetic */ SslErrorHandler val$handler;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sslErrorHandler};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handler = sslErrorHandler;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i) == null) {
                        this.val$handler.proceed();
                    }
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener(this, sslErrorHandler) { // from class: com.sina.weibo.sdk.web.WeiboSdkWebActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WeiboSdkWebActivity this$0;
                public final /* synthetic */ SslErrorHandler val$handler;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sslErrorHandler};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$handler = sslErrorHandler;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i) == null) {
                        this.val$handler.cancel();
                    }
                }
            });
            builder.create().show();
        }
    }
}
