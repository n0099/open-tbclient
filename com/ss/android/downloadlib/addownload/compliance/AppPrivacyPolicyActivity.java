package com.ss.android.downloadlib.addownload.compliance;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.j;
/* loaded from: classes2.dex */
public class AppPrivacyPolicyActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f61250b;

    /* renamed from: c  reason: collision with root package name */
    public long f61251c;

    /* renamed from: d  reason: collision with root package name */
    public long f61252d;

    /* renamed from: e  reason: collision with root package name */
    public String f61253e;

    public AppPrivacyPolicyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.a = (ImageView) findViewById(R.id.iv_privacy_back);
            this.f61250b = (WebView) findViewById(R.id.privacy_webview);
            this.a.setOnClickListener(new View.OnClickListener(this) { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AppPrivacyPolicyActivity a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        e.a("lp_app_privacy_click_close", this.a.f61252d);
                        this.a.finish();
                    }
                }
            });
            WebSettings settings = this.f61250b.getSettings();
            settings.setDefaultFontSize(16);
            settings.setCacheMode(-1);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setSavePassword(false);
            settings.setAllowFileAccess(false);
            this.f61250b.setWebViewClient(new WebViewClient(this) { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AppPrivacyPolicyActivity a;

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
                    this.a = this;
                }

                private boolean a(Uri uri) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, uri)) == null) {
                        String scheme = uri.getScheme();
                        return ("http".equals(scheme) || "https".equals(scheme)) ? false : true;
                    }
                    return invokeL.booleanValue;
                }

                @Override // android.webkit.WebViewClient
                @TargetApi(21)
                public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, webView, webResourceRequest)) == null) ? a(webResourceRequest.getUrl()) : invokeLL.booleanValue;
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) ? a(Uri.parse(str)) : invokeLL.booleanValue;
                }
            });
            a(this.f61250b);
            this.f61250b.setScrollBarStyle(0);
            this.f61250b.loadUrl(this.f61253e);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e.a("lp_app_privacy_click_close", this.f61252d);
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.ttdownloader_activity_app_privacy_policy);
            if (a()) {
                b();
            } else {
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
            }
        }
    }

    public static void a(Activity activity, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65538, null, activity, j2) == null) {
            Intent intent = new Intent(activity, AppPrivacyPolicyActivity.class);
            intent.putExtra("app_info_id", j2);
            activity.startActivity(intent);
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            this.f61251c = getIntent().getLongExtra("app_info_id", 0L);
            com.ss.android.downloadlib.addownload.b.b a = c.a().a(this.f61251c);
            if (a == null) {
                return false;
            }
            this.f61252d = a.f61200b;
            String str = a.f61207i;
            this.f61253e = str;
            if (TextUtils.isEmpty(str)) {
                this.f61253e = j.i().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private void a(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, webView) == null) {
            try {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused) {
            }
        }
    }
}
