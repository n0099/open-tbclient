package com.dxmpay.wallet.paysdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Xml;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.webmanager.SafeWebView;
import com.dxmpay.wallet.core.DebugConfig;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.BeanActivity;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.core.utils.PassUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes11.dex */
public class PassNormalizeActivity extends BeanActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FLAG_PAY_SKD = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mContent;
    public SafeWebView mWebView;
    public int type;
    public String url;

    /* loaded from: classes11.dex */
    public class JavascriptInterfaceImpl implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PassNormalizeActivity this$0;

        public JavascriptInterfaceImpl(PassNormalizeActivity passNormalizeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passNormalizeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = passNormalizeActivity;
        }

        @JavascriptInterface
        public void authorized_response(String str) {
            Map parseAuthorizedResult;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (parseAuthorizedResult = this.this$0.parseAuthorizedResult(str)) == null) {
                return;
            }
            if (!TextUtils.isEmpty((CharSequence) parseAuthorizedResult.get("pass_error_code")) && "0".equals(parseAuthorizedResult.get("pass_error_code"))) {
                PassUtil.backNormalized(this.this$0.mContent.getApplicationContext(), this.this$0.type, parseAuthorizedResult);
                StatisticManager.onEventWithValue("normalizeComplete", "success");
                this.this$0.finish();
                return;
            }
            if (!TextUtils.isEmpty((CharSequence) parseAuthorizedResult.get("pass_error_msg"))) {
                GlobalUtils.toast(this.this$0.mContent, (CharSequence) parseAuthorizedResult.get("pass_error_msg"));
            } else {
                GlobalUtils.toast(this.this$0.mContent, "帐号补全失败");
            }
            String str2 = (String) parseAuthorizedResult.get("pass_error_code");
            if (TextUtils.isEmpty(str2)) {
                str2 = "-12345";
            }
            StatisticManager.onEventWithValue("normalizeComplete", str2);
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public final class b extends SafeWebView.SafeWebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PassNormalizeActivity f62671e;

        public /* synthetic */ b(PassNormalizeActivity passNormalizeActivity, a aVar) {
            this(passNormalizeActivity);
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, webView, message, message2) == null) {
            }
        }

        @Override // com.dxmpay.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                String str2 = "onPageFinished url=" + str;
                if (this.f62671e.mContent != null) {
                    WalletGlobalUtils.safeDismissDialog(this.f62671e, -1);
                }
                String property = DebugConfig.getInstance(this.f62671e.mContent).getProperty("pass_complete_verify", "http://wappass.baidu.com/v2/?bindingret");
                if (str != null && str.startsWith(property)) {
                    this.f62671e.mWebView.loadUrl("javascript:window.sapi_obj.authorized_response(document.body.innerHTML);");
                }
                super.onPageFinished(webView, str);
            }
        }

        @Override // com.dxmpay.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
                String str2 = "url=" + str;
                if (str == null || !str.equals(TbDomainConfig.DOMAIN_HTTPS_BAIDU)) {
                    if (this.f62671e.mContent != null) {
                        PassNormalizeActivity passNormalizeActivity = this.f62671e;
                        WalletGlobalUtils.safeShowDialog(passNormalizeActivity, -1, ResUtils.getString(passNormalizeActivity.mContent, "dxm_ebpay_loading"));
                    }
                    super.onPageStarted(webView, str, bitmap);
                    return;
                }
                PassUtil.backNormalized(this.f62671e.mContent, this.f62671e.type, null);
                StatisticManager.onEventWithValue("normalizeVerify", QueryResponse.Options.CANCEL);
                this.f62671e.finish();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (str != null && (str.startsWith("sms") || str.startsWith("tel") || str.startsWith("bdscenter"))) {
                    try {
                        this.f62671e.mContent.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return true;
                    } catch (Throwable th) {
                        th.getMessage();
                        return true;
                    }
                }
                webView.loadUrl(str);
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }

        public b(PassNormalizeActivity passNormalizeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passNormalizeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62671e = passNormalizeActivity;
        }
    }

    public PassNormalizeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.url = "";
        this.type = 0;
    }

    public static String getMatcher(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            Pattern compile = Pattern.compile(str);
            String str3 = "";
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            Matcher matcher = compile.matcher(str2);
            while (matcher.find()) {
                str3 = matcher.group();
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> parseAuthorizedResult(String str) {
        InterceptResult invokeL;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            String str2 = "html=" + str;
            String matcher = getMatcher("<client>([\\S\\s]*?)</client>", str);
            HashMap hashMap2 = null;
            if (TextUtils.isEmpty(matcher)) {
                return null;
            }
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(matcher.getBytes()), "UTF-8");
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    if (eventType != 2) {
                        continue;
                    } else {
                        String name = newPullParser.getName();
                        if (!name.equalsIgnoreCase("data")) {
                            if (hashMap2 == null && name.equalsIgnoreCase("error_code")) {
                                hashMap = new HashMap();
                                try {
                                    hashMap.put("pass_error_code", Integer.parseInt(newPullParser.nextText()) + "");
                                } catch (Exception e2) {
                                    hashMap2 = hashMap;
                                    e = e2;
                                    e.printStackTrace();
                                    return hashMap2;
                                }
                            } else if (hashMap2 == null && name.equalsIgnoreCase("error_description")) {
                                hashMap = new HashMap();
                                hashMap.put("pass_error_code", newPullParser.nextText());
                            } else if (hashMap2 == null) {
                                continue;
                            } else if (name.equalsIgnoreCase("errno")) {
                                hashMap2.put("pass_error_code", Integer.parseInt(newPullParser.nextText()) + "");
                                continue;
                            } else if (name.equalsIgnoreCase("errmsg")) {
                                hashMap2.put("pass_error_msg", newPullParser.nextText());
                                continue;
                            } else {
                                continue;
                            }
                            hashMap2 = hashMap;
                            continue;
                        } else if (hashMap2 == null) {
                            hashMap = new HashMap();
                            hashMap2 = hashMap;
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
            return hashMap2;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, obj, str) == null) {
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mWebView.canGoBack()) {
                this.mWebView.goBack();
                return;
            }
            if (this.type == 1) {
                StatisticManager.onEventWithValue("normalizeComplete", QueryResponse.Options.CANCEL);
            } else {
                StatisticManager.onEventWithValue("normalizeVerify", QueryResponse.Options.CANCEL);
            }
            PassUtil.backNormalized(this.mContent, this.type, null);
            finish();
        }
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.mContent = getActivity();
            setFlagPaySdk();
            setContentView(ResUtils.layout(this.mContent, "dxm_wallet_base_webview_layout"));
            Intent intent = getIntent();
            if (intent != null) {
                this.url = intent.getStringExtra("normalize_url");
                this.type = intent.getIntExtra("pass_util_type", 0);
                String str = "intent url=" + this.url;
            }
            String str2 = "type111=" + this.type;
            if (this.type == 1) {
                StatisticManager.onEventWithValue("normalizeComplete", "open");
                initActionBar("dxm_ebpay_complete_pass");
            } else {
                StatisticManager.onEventWithValue("normalizeVerify", "open");
                initActionBar("dxm_ebpay_verify_pass");
            }
            String str3 = "url=" + this.url;
            if (TextUtils.isEmpty(this.url)) {
                finish();
                return;
            }
            SafeWebView safeWebView = (SafeWebView) findViewById(ResUtils.id(this.mContent, "dxm_cust_webview"));
            this.mWebView = safeWebView;
            WebSettings settings = safeWebView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            this.mWebView.setScrollBarStyle(0);
            this.mWebView.clearCache(false);
            this.mWebView.resumeTimers();
            if (Build.VERSION.SDK_INT >= 11) {
                this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
                this.mWebView.removeJavascriptInterface("accessibility");
                this.mWebView.removeJavascriptInterface("accessibilityTraversal");
            }
            if (Build.VERSION.SDK_INT <= 18) {
                this.mWebView.getSettings().setSavePassword(false);
            }
            this.mWebView.getSettings().setAllowFileAccess(false);
            this.mWebView.setWebViewClient(new b(this, null));
            settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
            this.mWebView.addJavascriptInterface(new JavascriptInterfaceImpl(this), "sapi_obj");
            this.mWebView.loadUrl(this.url);
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

    @Override // com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
            }
        }
    }

    public void setFlagPaySdk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mFlag |= 1;
        }
    }
}
