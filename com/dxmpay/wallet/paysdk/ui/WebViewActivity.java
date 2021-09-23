package com.dxmpay.wallet.paysdk.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.webmanager.SafeWebView;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.utils.HttpsCertVerifyUtil;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.storage.HtmlDataCache;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Arrays;
import java.util.HashMap;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes9.dex */
public class WebViewActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHANNEL_DISCOUNT_PARAMS = "channel_discount_params";
    public static final String EXTRA_PARAM = "extra_param";
    public static final String HTML_DATA_FROM_SCENE = "html_data_from_scene";
    public static final String JUMP_URL = "jump_url";
    public static final String TAG;
    public static final String WEBVIEW_TITLE = "webview_title";
    public static final String WEBVIEW_TITLE_STRING = "webview_title_string";
    public transient /* synthetic */ FieldHolder $fh;
    public String mHtml;
    public String mHtmlFromScene;
    public SafeWebView mWebView;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WebViewActivity f70220e;

        public a(WebViewActivity webViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70220e = webViewActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                GlobalUtils.hideKeyboard(this.f70220e.getActivity());
                this.f70220e.onBackPressed();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends SafeWebView.SafeChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WebViewActivity f70221e;

        public b(WebViewActivity webViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70221e = webViewActivity;
        }

        @Override // com.dxmpay.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                WebViewActivity webViewActivity = this.f70221e;
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(this.f70221e.getActivity(), "dxm_ebpay_wallet");
                }
                webViewActivity.initActionBar(str);
            }
        }

        public /* synthetic */ b(WebViewActivity webViewActivity, a aVar) {
            this(webViewActivity);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends SafeWebView.SafeWebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WebViewActivity f70222e;

        public c(WebViewActivity webViewActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webViewActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70222e = webViewActivity;
        }

        @Override // com.dxmpay.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                WalletGlobalUtils.safeDismissDialog(this.f70222e, -1);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, sslErrorHandler, sslError) == null) {
                int primaryError = sslError == null ? 5000 : sslError.getPrimaryError();
                String url = sslError == null ? null : sslError.getUrl();
                StatisticManager.onEventWithValues("#web_view_ssl_error", Arrays.asList(primaryError + "", url));
                if (HttpsCertVerifyUtil.isWhiteListVerificationPassed(sslError)) {
                    sslErrorHandler.proceed();
                } else {
                    super.onReceivedSslError(webView, sslErrorHandler, sslError);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str)) == null) {
                if (str.startsWith("tel:")) {
                    try {
                        this.f70222e.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return true;
                } else if (str.startsWith(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO)) {
                    try {
                        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str.substring(0, str.indexOf("?"))));
                        intent.putExtra("android.intent.extra.SUBJECT", Uri.parse(str.replace(com.baidu.webkit.sdk.WebView.SCHEME_MAILTO, "mailto://")).getQueryParameter("subject"));
                        this.f70222e.startActivity(intent);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        GlobalUtils.toast(this.f70222e.getActivity(), "请先配置邮箱");
                    }
                    return true;
                } else {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ c(WebViewActivity webViewActivity, a aVar) {
            this(webViewActivity);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1093243199, "Lcom/dxmpay/wallet/paysdk/ui/WebViewActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1093243199, "Lcom/dxmpay/wallet/paysdk/ui/WebViewActivity;");
                return;
            }
        }
        TAG = WebViewActivity.class.getSimpleName();
    }

    public WebViewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initActionBar(String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, str) == null) || (bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"))) == null) {
            return;
        }
        bdActionBar.setTitle(str);
        bdActionBar.setLeftZoneOnClickListener(new a(this));
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SafeWebView safeWebView = this.mWebView;
            if (safeWebView != null && safeWebView.canGoBack()) {
                this.mWebView.goBack();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(getActivity(), "dxm_wallet_base_webview_layout"));
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String string = extras.getString("webview_title");
                if (TextUtils.isEmpty(string)) {
                    str2 = extras.getString("webview_title_string");
                } else {
                    str2 = ResUtils.getString(getActivity(), string);
                }
                str = extras.getString("jump_url");
                String string2 = extras.getString("bank_type");
                String string3 = extras.getString("channel_discount_params");
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(string2)) {
                        str = str + "?bank_type=" + string2;
                    }
                    if (!TextUtils.isEmpty(string3)) {
                        str = str + string3;
                    }
                } else {
                    str = DomainConfig.getInstance().getAppPayHost() + "/content/resource/HTML5/eptos.html";
                }
            } else {
                str = DomainConfig.getInstance().getAppPayHost() + "/content/resource/HTML5/eptos.html";
                str2 = "";
            }
            String ua = BussinessUtils.getUA(this);
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("?")) {
                    str3 = str + "&ua=" + ua;
                } else {
                    str3 = str + "?ua=" + ua;
                }
                str = str3;
                if (extras != null) {
                    String string4 = extras.getString("extra_param");
                    if (!TextUtils.isEmpty(string4)) {
                        str = str + "&" + string4;
                    }
                }
            }
            WalletGlobalUtils.safeShowDialog(this, -1, "");
            SafeWebView safeWebView = (SafeWebView) findViewById(ResUtils.id(getActivity(), "dxm_cust_webview"));
            this.mWebView = safeWebView;
            safeWebView.setWebViewClient(new c(this, null));
            if (TextUtils.isEmpty(str2)) {
                this.mWebView.setWebChromeClient(new b(this, null));
            }
            this.mWebView.getSettings().setJavaScriptEnabled(true);
            this.mWebView.getSettings().setTextZoom(100);
            if (Build.VERSION.SDK_INT <= 18) {
                this.mWebView.getSettings().setSavePassword(false);
            }
            this.mWebView.setScrollBarStyle(0);
            this.mWebView.clearCache(false);
            this.mWebView.resumeTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
                this.mWebView.removeJavascriptInterface("accessibility");
                this.mWebView.removeJavascriptInterface("accessibilityTraversal");
            }
            String html = HtmlDataCache.getInstance().getHtml();
            this.mHtml = html;
            if (!TextUtils.isEmpty(html)) {
                this.mHtmlFromScene = extras.getString(HTML_DATA_FROM_SCENE);
                HashMap hashMap = new HashMap();
                hashMap.put("from_scene", this.mHtmlFromScene);
                StatHelper.statServiceEvent(StatServiceEvent.ENTER_H5_HTML_PAGE, hashMap, new String[0]);
                this.mWebView.loadDataWithBaseURL(null, this.mHtml, SapiWebView.DATA_MIME_TYPE, "utf-8", null);
            } else {
                this.mWebView.loadUrl(str);
            }
            initActionBar(str2);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            if (TextUtils.isEmpty(this.mHtml)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("from_scene", this.mHtmlFromScene);
            StatHelper.statServiceEvent(StatServiceEvent.CLOSE_H5_HTML_PAGE, hashMap, new String[0]);
            HtmlDataCache.getInstance().clearData();
            this.mHtml = null;
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPause();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
            }
        }
    }
}
