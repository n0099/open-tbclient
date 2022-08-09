package com.kwad.components.core.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.m.p;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: classes5.dex */
public class SimpleWebViewActivity extends com.kwad.components.core.i.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_PAGE_TITLE = "key_page_title";
    public static final String KEY_PAGE_URL = "key_page_url";
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdWebView mAdWebView;
    public TextView mTitle;
    public String title;

    public SimpleWebViewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f0910c5);
            String stringExtra = getIntent().getStringExtra("key_page_title");
            this.title = stringExtra;
            if (!TextUtils.isEmpty(stringExtra)) {
                this.mTitle.setText(this.title);
            }
            findViewById(R.id.obfuscated_res_0x7f0910c7).setVisibility(8);
            findViewById(R.id.obfuscated_res_0x7f0910c6).setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.core.page.SimpleWebViewActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SimpleWebViewActivity Gc;

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
                    this.Gc = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.Gc.finish();
                    }
                }
            });
        }
    }

    private void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09121b);
            this.mAdWebView = ksAdWebView;
            p.b(ksAdWebView);
        }
    }

    public static void launch(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        KsAdSDKImpl.putComponentProxy(AdWebViewActivity.class, SimpleWebViewActivity.class);
        Intent intent = new Intent(context, AdWebViewActivity.class);
        intent.putExtra("key_page_url", str);
        intent.putExtra("key_page_title", str2);
        context.startActivity(intent);
    }

    private void loadUrl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            if (TextUtils.isEmpty(this.title)) {
                this.mAdWebView.setWebChromeClient(new com.kwad.components.core.webview.kwai.b(this) { // from class: com.kwad.components.core.page.SimpleWebViewActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SimpleWebViewActivity Gc;

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
                        this.Gc = this;
                    }

                    @Override // android.webkit.WebChromeClient
                    public final void onReceivedTitle(WebView webView, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                            super.onReceivedTitle(webView, str);
                            this.Gc.mTitle.setText(str);
                        }
                    }
                });
            }
            String stringExtra = getIntent().getStringExtra("key_page_url");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.mAdWebView.loadUrl(stringExtra);
        }
    }

    @Override // com.kwad.components.core.i.a
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "SimpleWebViewActivity" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0404);
            initView();
            initWebView();
            loadUrl();
        }
    }
}
