package com.sina.weibo.sdk.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.component.ShareRequestParam;
import com.sina.weibo.sdk.component.view.LoadingBar;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.Utility;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class WeiboSdkBrowser extends Activity implements BrowserRequestCallBack {
    public static final String BROWSER_CLOSE_SCHEME = "sinaweibo://browser/close";
    public static final String BROWSER_WIDGET_SCHEME = "sinaweibo://browser/datatransfer";
    private static final String CANCEL_EN = "Close";
    private static final String CANCEL_ZH_CN = "关闭";
    private static final String CANCEL_ZH_TW = "关闭";
    private static final String CHANNEL_DATA_ERROR_EN = "channel_data_error";
    private static final String CHANNEL_DATA_ERROR_ZH_CN = "重新加载";
    private static final String CHANNEL_DATA_ERROR_ZH_TW = "重新載入";
    private static final String EMPTY_PROMPT_BAD_NETWORK_UI_EN = "A network error occurs, please tap the button to reload";
    private static final String EMPTY_PROMPT_BAD_NETWORK_UI_ZH_CN = "网络出错啦，请点击按钮重新加载";
    private static final String EMPTY_PROMPT_BAD_NETWORK_UI_ZH_TW = "網路出錯啦，請點擊按鈕重新載入";
    private static final String LOADINFO_EN = "Loading....";
    private static final String LOADINFO_ZH_CN = "加载中....";
    private static final String LOADINFO_ZH_TW = "載入中....";
    private static final String TAG = WeiboSdkBrowser.class.getName();
    private static final String WEIBOBROWSER_NO_TITLE_EN = "No Title";
    private static final String WEIBOBROWSER_NO_TITLE_ZH_CN = "无标题";
    private static final String WEIBOBROWSER_NO_TITLE_ZH_TW = "無標題";
    private boolean isErrorPage;
    private Boolean isFromGame = false;
    private boolean isLoading;
    private String mHtmlTitle;
    private TextView mLeftBtn;
    private Button mLoadErrorRetryBtn;
    private LinearLayout mLoadErrorView;
    private LoadingBar mLoadingBar;
    private BrowserRequestParamBase mRequestParam;
    private String mSpecifyTitle;
    private TextView mTitleText;
    private String mUrl;
    private WebView mWebView;
    private WeiboWebViewClient mWeiboWebViewClient;

    public static void startAuth(Context context, String str, AuthInfo authInfo, WeiboAuthListener weiboAuthListener) {
        AuthRequestParam authRequestParam = new AuthRequestParam(context);
        authRequestParam.setLauncher(BrowserLauncher.AUTH);
        authRequestParam.setUrl(str);
        authRequestParam.setAuthInfo(authInfo);
        authRequestParam.setAuthListener(weiboAuthListener);
        Intent intent = new Intent(context, WeiboSdkBrowser.class);
        intent.putExtras(authRequestParam.createRequestParamBundle());
        context.startActivity(intent);
    }

    public static void startShared(Context context, String str, AuthInfo authInfo, WeiboAuthListener weiboAuthListener) {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!initDataFromIntent(getIntent())) {
            finish();
            return;
        }
        setContentView();
        initWebView();
        if (isWeiboShareRequestParam(this.mRequestParam)) {
            startShare();
        } else {
            openUrl(this.mUrl);
        }
    }

    private boolean initDataFromIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        this.mRequestParam = createBrowserRequestParam(extras);
        if (this.mRequestParam != null) {
            this.mUrl = this.mRequestParam.getUrl();
            this.mSpecifyTitle = this.mRequestParam.getSpecifyTitle();
        } else {
            String string = extras.getString("key_url");
            String string2 = extras.getString("key_specify_title");
            if (!TextUtils.isEmpty(string) && string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mUrl = string;
                this.mSpecifyTitle = string2;
            }
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            return false;
        }
        LogUtil.d(TAG, "LOAD URL : " + this.mUrl);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        this.mWebView.loadUrl(str);
    }

    private void startShare() {
        LogUtil.d(TAG, "Enter startShare()............");
        final ShareRequestParam shareRequestParam = (ShareRequestParam) this.mRequestParam;
        if (shareRequestParam.hasImage()) {
            LogUtil.d(TAG, "loadUrl hasImage............");
            new AsyncWeiboRunner(this).requestAsync(ShareRequestParam.UPLOAD_PIC_URL, shareRequestParam.buildUploadPicParam(new WeiboParameters(shareRequestParam.getAppKey())), "POST", new RequestListener() { // from class: com.sina.weibo.sdk.component.WeiboSdkBrowser.1
                @Override // com.sina.weibo.sdk.net.RequestListener
                public void onWeiboException(WeiboException weiboException) {
                    LogUtil.d(WeiboSdkBrowser.TAG, "post onWeiboException " + weiboException.getMessage());
                    shareRequestParam.sendSdkErrorResponse(WeiboSdkBrowser.this, weiboException.getMessage());
                    WeiboSdkBrowser.this.finish();
                }

                @Override // com.sina.weibo.sdk.net.RequestListener
                public void onComplete(String str) {
                    LogUtil.d(WeiboSdkBrowser.TAG, "post onComplete : " + str);
                    ShareRequestParam.UploadPicResult parse = ShareRequestParam.UploadPicResult.parse(str);
                    if (parse != null && parse.getCode() == 1 && !TextUtils.isEmpty(parse.getPicId())) {
                        WeiboSdkBrowser.this.openUrl(shareRequestParam.buildUrl(parse.getPicId()));
                        return;
                    }
                    shareRequestParam.sendSdkErrorResponse(WeiboSdkBrowser.this, "upload pic faild");
                    WeiboSdkBrowser.this.finish();
                }
            });
            return;
        }
        openUrl(this.mUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebView() {
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        if (isWeiboShareRequestParam(this.mRequestParam)) {
            this.mWebView.getSettings().setUserAgentString(Utility.generateUA(this));
        }
        this.mWebView.getSettings().setSavePassword(false);
        this.mWebView.setWebViewClient(this.mWeiboWebViewClient);
        this.mWebView.setWebChromeClient(new WeiboChromeClient(this, null));
        this.mWebView.requestFocus();
        this.mWebView.setScrollBarStyle(0);
        if (Build.VERSION.SDK_INT >= 11) {
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        } else {
            removeJavascriptInterface(this.mWebView);
        }
    }

    private void setTopNavTitle() {
        this.mTitleText.setText(this.mSpecifyTitle);
        this.mLeftBtn.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.component.WeiboSdkBrowser.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (WeiboSdkBrowser.this.mRequestParam != null) {
                    WeiboSdkBrowser.this.mRequestParam.execRequest(WeiboSdkBrowser.this, 3);
                }
                WeiboSdkBrowser.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleName() {
        String str = "";
        if (!TextUtils.isEmpty(this.mHtmlTitle)) {
            str = this.mHtmlTitle;
        } else if (!TextUtils.isEmpty(this.mSpecifyTitle)) {
            str = this.mSpecifyTitle;
        }
        this.mTitleText.setText(str);
    }

    private void setContentView() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(-1);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View initTitleBar = initTitleBar();
        TextView textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, ResourceManager.dp2px(this, 2)));
        textView.setBackgroundDrawable(ResourceManager.getNinePatchDrawable(this, "weibosdk_common_shadow_top.9.png"));
        this.mLoadingBar = new LoadingBar(this);
        this.mLoadingBar.setBackgroundColor(0);
        this.mLoadingBar.drawProgress(0);
        this.mLoadingBar.setLayoutParams(new LinearLayout.LayoutParams(-1, ResourceManager.dp2px(this, 3)));
        linearLayout.addView(initTitleBar);
        linearLayout.addView(textView);
        linearLayout.addView(this.mLoadingBar);
        this.mWebView = new WebView(this);
        this.mWebView.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 1);
        this.mWebView.setLayoutParams(layoutParams);
        this.mLoadErrorView = new LinearLayout(this);
        this.mLoadErrorView.setVisibility(8);
        this.mLoadErrorView.setOrientation(1);
        this.mLoadErrorView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(3, 1);
        this.mLoadErrorView.setLayoutParams(layoutParams2);
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(ResourceManager.getDrawable(this, "weibosdk_empty_failed.png"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        int dp2px = ResourceManager.dp2px(this, 8);
        layoutParams3.bottomMargin = dp2px;
        layoutParams3.rightMargin = dp2px;
        layoutParams3.topMargin = dp2px;
        layoutParams3.leftMargin = dp2px;
        imageView.setLayoutParams(layoutParams3);
        this.mLoadErrorView.addView(imageView);
        TextView textView2 = new TextView(this);
        textView2.setGravity(1);
        textView2.setTextColor(-4342339);
        textView2.setTextSize(2, 14.0f);
        textView2.setText(ResourceManager.getString(this, EMPTY_PROMPT_BAD_NETWORK_UI_EN, EMPTY_PROMPT_BAD_NETWORK_UI_ZH_CN, EMPTY_PROMPT_BAD_NETWORK_UI_ZH_TW));
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.mLoadErrorView.addView(textView2);
        this.mLoadErrorRetryBtn = new Button(this);
        this.mLoadErrorRetryBtn.setGravity(17);
        this.mLoadErrorRetryBtn.setTextColor(-8882056);
        this.mLoadErrorRetryBtn.setTextSize(2, 16.0f);
        this.mLoadErrorRetryBtn.setText(ResourceManager.getString(this, CHANNEL_DATA_ERROR_EN, CHANNEL_DATA_ERROR_ZH_CN, CHANNEL_DATA_ERROR_ZH_TW));
        this.mLoadErrorRetryBtn.setBackgroundDrawable(ResourceManager.createStateListDrawable(this, "weibosdk_common_button_alpha.9.png", "weibosdk_common_button_alpha_highlighted.9.png"));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(ResourceManager.dp2px(this, 142), ResourceManager.dp2px(this, 46));
        layoutParams4.topMargin = ResourceManager.dp2px(this, 10);
        this.mLoadErrorRetryBtn.setLayoutParams(layoutParams4);
        this.mLoadErrorRetryBtn.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.component.WeiboSdkBrowser.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                WeiboSdkBrowser.this.openUrl(WeiboSdkBrowser.this.mUrl);
                WeiboSdkBrowser.this.isErrorPage = false;
            }
        });
        this.mLoadErrorView.addView(this.mLoadErrorRetryBtn);
        relativeLayout.addView(linearLayout);
        relativeLayout.addView(this.mWebView);
        relativeLayout.addView(this.mLoadErrorView);
        setContentView(relativeLayout);
        setTopNavTitle();
    }

    private View initTitleBar() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, ResourceManager.dp2px(this, 45)));
        relativeLayout.setBackgroundDrawable(ResourceManager.getNinePatchDrawable(this, "weibosdk_navigationbar_background.9.png"));
        this.mLeftBtn = new TextView(this);
        this.mLeftBtn.setClickable(true);
        this.mLeftBtn.setTextSize(2, 17.0f);
        this.mLeftBtn.setTextColor(ResourceManager.createColorStateList(-32256, 1728020992));
        this.mLeftBtn.setText(ResourceManager.getString(this, "Close", "关闭", "关闭"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5);
        layoutParams.addRule(15);
        layoutParams.leftMargin = ResourceManager.dp2px(this, 10);
        layoutParams.rightMargin = ResourceManager.dp2px(this, 10);
        this.mLeftBtn.setLayoutParams(layoutParams);
        relativeLayout.addView(this.mLeftBtn);
        this.mTitleText = new TextView(this);
        this.mTitleText.setTextSize(2, 18.0f);
        this.mTitleText.setTextColor(-11382190);
        this.mTitleText.setEllipsize(TextUtils.TruncateAt.END);
        this.mTitleText.setSingleLine(true);
        this.mTitleText.setGravity(17);
        this.mTitleText.setMaxWidth(ResourceManager.dp2px(this, 160));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mTitleText.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.mTitleText);
        return relativeLayout;
    }

    protected void refreshAllViews() {
        if (this.isLoading) {
            setViewLoading();
        } else {
            setViewNormal();
        }
    }

    private void setViewNormal() {
        updateTitleName();
        this.mLoadingBar.setVisibility(8);
    }

    private void setViewLoading() {
        this.mTitleText.setText(ResourceManager.getString(this, LOADINFO_EN, LOADINFO_ZH_CN, LOADINFO_ZH_TW));
        this.mLoadingBar.setVisibility(0);
    }

    private void handleReceivedError(WebView webView, int i, String str, String str2) {
        if (!str2.startsWith("sinaweibo")) {
            this.isErrorPage = true;
            promptError();
        }
    }

    private void promptError() {
        this.mLoadErrorView.setVisibility(0);
        this.mWebView.setVisibility(8);
    }

    private void hiddenErrorPrompt() {
        this.mLoadErrorView.setVisibility(8);
        this.mWebView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class WeiboChromeClient extends WebChromeClient {
        private WeiboChromeClient() {
        }

        /* synthetic */ WeiboChromeClient(WeiboSdkBrowser weiboSdkBrowser, WeiboChromeClient weiboChromeClient) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            WeiboSdkBrowser.this.mLoadingBar.drawProgress(i);
            if (i == 100) {
                WeiboSdkBrowser.this.isLoading = false;
                WeiboSdkBrowser.this.refreshAllViews();
            } else if (!WeiboSdkBrowser.this.isLoading) {
                WeiboSdkBrowser.this.isLoading = true;
                WeiboSdkBrowser.this.refreshAllViews();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (!WeiboSdkBrowser.this.isWeiboCustomScheme(WeiboSdkBrowser.this.mUrl) && !WeiboSdkBrowser.this.isFromGame.booleanValue()) {
                WeiboSdkBrowser.this.mHtmlTitle = str;
                WeiboSdkBrowser.this.updateTitleName();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isWeiboCustomScheme(String str) {
        return !TextUtils.isEmpty(str) && "sinaweibo".equalsIgnoreCase(Uri.parse(str).getAuthority());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        NetworkHelper.clearCookies(this);
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mRequestParam != null) {
                this.mRequestParam.execRequest(this, 3);
            }
            finish();
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    private BrowserRequestParamBase createBrowserRequestParam(Bundle bundle) {
        this.isFromGame = false;
        BrowserLauncher browserLauncher = (BrowserLauncher) bundle.getSerializable(BrowserRequestParamBase.EXTRA_KEY_LAUNCHER);
        if (browserLauncher == BrowserLauncher.AUTH) {
            AuthRequestParam authRequestParam = new AuthRequestParam(this);
            authRequestParam.setupRequestParam(bundle);
            installAuthWeiboWebViewClient(authRequestParam);
            return authRequestParam;
        } else if (browserLauncher == BrowserLauncher.SHARE) {
            ShareRequestParam shareRequestParam = new ShareRequestParam(this);
            shareRequestParam.setupRequestParam(bundle);
            installShareWeiboWebViewClient(shareRequestParam);
            return shareRequestParam;
        } else if (browserLauncher == BrowserLauncher.WIDGET) {
            WidgetRequestParam widgetRequestParam = new WidgetRequestParam(this);
            widgetRequestParam.setupRequestParam(bundle);
            installWidgetWeiboWebViewClient(widgetRequestParam);
            return widgetRequestParam;
        } else if (browserLauncher != BrowserLauncher.GAME) {
            return null;
        } else {
            this.isFromGame = true;
            GameRequestParam gameRequestParam = new GameRequestParam(this);
            gameRequestParam.setupRequestParam(bundle);
            installWeiboWebGameClient(gameRequestParam);
            return gameRequestParam;
        }
    }

    private boolean isWeiboShareRequestParam(BrowserRequestParamBase browserRequestParamBase) {
        return browserRequestParamBase != null && browserRequestParamBase.getLauncher() == BrowserLauncher.SHARE;
    }

    private void installAuthWeiboWebViewClient(AuthRequestParam authRequestParam) {
        this.mWeiboWebViewClient = new AuthWeiboWebViewClient(this, authRequestParam);
        this.mWeiboWebViewClient.setBrowserRequestCallBack(this);
    }

    private void installShareWeiboWebViewClient(ShareRequestParam shareRequestParam) {
        ShareWeiboWebViewClient shareWeiboWebViewClient = new ShareWeiboWebViewClient(this, shareRequestParam);
        shareWeiboWebViewClient.setBrowserRequestCallBack(this);
        this.mWeiboWebViewClient = shareWeiboWebViewClient;
    }

    private void installWidgetWeiboWebViewClient(WidgetRequestParam widgetRequestParam) {
        WidgetWeiboWebViewClient widgetWeiboWebViewClient = new WidgetWeiboWebViewClient(this, widgetRequestParam);
        widgetWeiboWebViewClient.setBrowserRequestCallBack(this);
        this.mWeiboWebViewClient = widgetWeiboWebViewClient;
    }

    private void installWeiboWebGameClient(GameRequestParam gameRequestParam) {
        WeiboGameClient weiboGameClient = new WeiboGameClient(this, gameRequestParam);
        weiboGameClient.setBrowserRequestCallBack(this);
        this.mWeiboWebViewClient = weiboGameClient;
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestCallBack
    public void onPageStartedCallBack(WebView webView, String str, Bitmap bitmap) {
        LogUtil.d(TAG, "onPageStarted URL: " + str);
        this.mUrl = str;
        if (!isWeiboCustomScheme(str)) {
            this.mHtmlTitle = "";
        }
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestCallBack
    public boolean shouldOverrideUrlLoadingCallBack(WebView webView, String str) {
        LogUtil.i(TAG, "shouldOverrideUrlLoading URL: " + str);
        return false;
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestCallBack
    public void onPageFinishedCallBack(WebView webView, String str) {
        LogUtil.d(TAG, "onPageFinished URL: " + str);
        if (this.isErrorPage) {
            promptError();
            return;
        }
        this.isErrorPage = false;
        hiddenErrorPrompt();
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestCallBack
    public void onReceivedErrorCallBack(WebView webView, int i, String str, String str2) {
        LogUtil.d(TAG, "onReceivedError: errorCode = " + i + ", description = " + str + ", failingUrl = " + str2);
        handleReceivedError(webView, i, str, str2);
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestCallBack
    public void onReceivedSslErrorCallBack(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        LogUtil.d(TAG, "onReceivedSslErrorCallBack.........");
    }

    public static void closeBrowser(Activity activity, String str, String str2) {
        WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance(activity.getApplicationContext());
        if (!TextUtils.isEmpty(str)) {
            weiboCallbackManager.removeWeiboAuthListener(str);
            activity.finish();
        }
        if (!TextUtils.isEmpty(str2)) {
            weiboCallbackManager.removeWidgetRequestCallback(str2);
            activity.finish();
        }
    }

    public void removeJavascriptInterface(WebView webView) {
        if (Build.VERSION.SDK_INT < 11) {
            try {
                webView.getClass().getDeclaredMethod("removeJavascriptInterface", new Class[0]).invoke("searchBoxJavaBridge_", new Object[0]);
            } catch (Exception e) {
                LogUtil.e(TAG, e.toString());
            }
        }
    }
}
