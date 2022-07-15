package com.kwad.components.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.l.p;
import com.kwad.components.core.webview.kwai.c;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.q;
import java.util.UUID;
/* loaded from: classes5.dex */
public class KsAdWebView extends com.kwad.components.core.webview.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.webview.kwai.c a;
    public c.a b;
    public long c;
    public String d;
    public String e;
    public boolean f;

    /* loaded from: classes5.dex */
    public class a implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ KsAdWebView a;

        public a(KsAdWebView ksAdWebView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ksAdWebView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ksAdWebView;
        }

        public /* synthetic */ a(KsAdWebView ksAdWebView, byte b) {
            this(ksAdWebView);
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                if (this.a.b == null || this.a.b.a() == null || !this.a.b.h()) {
                    try {
                        this.a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return;
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.a(e);
                        return;
                    }
                }
                com.kwad.sdk.core.response.a.d.i(this.a.b.a()).adConversionInfo.appDownloadUrl = str;
                this.a.b.a().isWebViewDownload = true;
                if (this.a.getReadyClientConfig() != null) {
                    this.a.getReadyClientConfig().a(this.a.b.a());
                }
                com.kwad.components.core.c.a.a.a(new a.C0507a(this.a.getContext2()).a(this.a.b.a()).c(true));
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();

        void a(int i, String str);

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAdWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAdWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, context) == null) {
            com.kwad.sdk.core.d.b.e("KsAdWebView", "init");
            setAccessibilityStateDisable(context);
            WebSettings a2 = p.a(this);
            a2.setUseWideViewPort(true);
            a2.setDomStorageEnabled(true);
            setVerticalScrollBarEnabled(false);
            this.d = UUID.randomUUID().toString();
            com.kwad.components.core.webview.kwai.c cVar = new com.kwad.components.core.webview.kwai.c();
            this.a = cVar;
            cVar.a(this.d);
            setWebViewClient(this.a);
            setWebChromeClient(new com.kwad.components.core.webview.kwai.b());
            setDownloadListener(new a(this, (byte) 0));
            String userAgentString = a2.getUserAgentString();
            a2.setUserAgentString(userAgentString + d());
        }
    }

    private void a(String str) {
        c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, str) == null) || (aVar = this.b) == null || aVar.a() == null) {
            return;
        }
        boolean equals = TextUtils.equals(com.kwad.sdk.core.response.a.a.N(com.kwad.sdk.core.response.a.d.i(this.b.a())), str);
        this.f = equals;
        if (equals) {
            this.b.c(true);
        }
    }

    private String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            return "KSADSDK_V3.3.24_" + getContext().getPackageName() + "_" + j.a(getContext());
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a getReadyClientConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            com.kwad.components.core.webview.kwai.c cVar = this.a;
            if (cVar == null || cVar.a() == null) {
                return null;
            }
            return this.a.a();
        }
        return (c.a) invokeV.objValue;
    }

    private void setAccessibilityStateDisable(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                    q.a((Object) accessibilityManager, "setState", 0);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a aVar = this.b;
            if (aVar != null && aVar.j()) {
                com.kwad.sdk.core.report.a.a(this.b.a(), this.b.e());
            }
            if (this.a != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.c = currentTimeMillis;
                this.a.a(currentTimeMillis);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            c.a aVar = this.b;
            if (aVar == null || !aVar.j()) {
                return;
            }
            u.b e = this.b.e();
            if (e == null) {
                e = new u.b();
            }
            e.w = System.currentTimeMillis() - this.c;
            com.kwad.sdk.core.report.a.c(this.b.a(), e);
        }
    }

    public c.a getClientConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b == null) {
                this.b = new c.a(getContext());
            }
            return this.b;
        }
        return (c.a) invokeV.objValue;
    }

    public String getLoadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            a(str);
            com.kwad.components.a.b.b.a(this.d);
            this.e = str;
            super.loadUrl(str);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            c.a aVar = this.b;
            if (aVar == null || aVar.i() == null) {
                return;
            }
            this.b.i().a();
        }
    }

    public void setClientConfig(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.a.a(aVar);
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webChromeClient) == null) {
            if (com.kwad.kwai.kwai.a.a.booleanValue() && !(webChromeClient instanceof com.kwad.components.core.webview.kwai.b)) {
                throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
            }
            super.setWebChromeClient(webChromeClient);
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, webViewClient) == null) {
            if (com.kwad.kwai.kwai.a.a.booleanValue() && !(webViewClient instanceof com.kwad.components.core.webview.kwai.a)) {
                throw new IllegalArgumentException("Not supported set webViewClient, please check it");
            }
            super.setWebViewClient(webViewClient);
        }
    }
}
