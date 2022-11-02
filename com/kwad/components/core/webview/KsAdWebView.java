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
import com.kwad.components.core.m.p;
import com.kwad.components.core.webview.kwai.c;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.q;
import java.util.UUID;
/* loaded from: classes7.dex */
public class KsAdWebView extends com.kwad.components.core.webview.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.core.webview.kwai.c KJ;
    public long KK;
    public String KL;
    public long KM;
    public boolean KN;
    public c.a gX;
    public String mUniqueId;

    /* loaded from: classes7.dex */
    public class a implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ KsAdWebView KO;

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
            this.KO = ksAdWebView;
        }

        public /* synthetic */ a(KsAdWebView ksAdWebView, byte b) {
            this(ksAdWebView);
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                if (this.KO.gX == null || this.KO.gX.getAdTemplate() == null || !this.KO.gX.ps()) {
                    try {
                        this.KO.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return;
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.b.printStackTrace(e);
                        return;
                    }
                }
                com.kwad.sdk.core.response.a.d.bQ(this.KO.gX.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
                this.KO.gX.getAdTemplate().isWebViewDownload = true;
                c.a readyClientConfig = this.KO.getReadyClientConfig();
                if (readyClientConfig != null) {
                    readyClientConfig.R(this.KO.gX.getAdTemplate());
                }
                com.kwad.components.core.c.a.a.a(new a.C0577a(this.KO.getContext2()).L(this.KO.gX.getAdTemplate()).al(true));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void kU();

        void onSuccess();
    }

    /* loaded from: classes7.dex */
    public interface c {
        void nu();
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(int i, String str, String str2);

        void bv();

        void bw();
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
        init(context);
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
        init(context);
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
        init(context);
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
        init(context);
    }

    private void aB(String str) {
        c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) || (aVar = this.gX) == null || aVar.getAdTemplate() == null) {
            return;
        }
        boolean equals = TextUtils.equals(com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.bQ(this.gX.getAdTemplate())), str);
        this.KN = equals;
        if (equals) {
            this.gX.aC(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a getReadyClientConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            com.kwad.components.core.webview.kwai.c cVar = this.KJ;
            if (cVar == null || cVar.getClientConfig() == null) {
                return null;
            }
            return this.KJ.getClientConfig();
        }
        return (c.a) invokeV.objValue;
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            com.kwad.sdk.core.e.b.e("KsAdWebView", "init");
            setAccessibilityStateDisable(context);
            WebSettings b2 = p.b(this);
            b2.setUseWideViewPort(true);
            b2.setDomStorageEnabled(true);
            setVerticalScrollBarEnabled(false);
            this.mUniqueId = UUID.randomUUID().toString();
            com.kwad.components.core.webview.kwai.c cVar = new com.kwad.components.core.webview.kwai.c();
            this.KJ = cVar;
            cVar.aC(this.mUniqueId);
            setWebViewClient(this.KJ);
            setWebChromeClient(new com.kwad.components.core.webview.kwai.b());
            setDownloadListener(new a(this, (byte) 0));
            String userAgentString = b2.getUserAgentString();
            b2.setUserAgentString(userAgentString + po());
        }
    }

    private String po() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            return "KSADSDK_V3.3.26_" + getContext().getPackageName() + "_" + j.cb(getContext());
        }
        return (String) invokeV.objValue;
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

    public c.a getClientConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.gX == null) {
                this.gX = new c.a(getContext());
            }
            return this.gX;
        }
        return (c.a) invokeV.objValue;
    }

    public long getLoadTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.KM : invokeV.longValue;
    }

    public String getLoadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.KL : (String) invokeV.objValue;
    }

    public String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mUniqueId : (String) invokeV.objValue;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            aB(str);
            com.kwad.components.a.b.b.aW(this.mUniqueId);
            this.KL = str;
            this.KM = System.currentTimeMillis();
            super.loadUrl(str);
        }
    }

    public final void onActivityDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            release();
            c.a aVar = this.gX;
            if (aVar == null || !aVar.pt()) {
                return;
            }
            u.b clientParams = this.gX.getClientParams();
            if (clientParams == null) {
                clientParams = new u.b();
            }
            clientParams.Es = System.currentTimeMillis() - this.KK;
            com.kwad.sdk.core.report.a.d(this.gX.getAdTemplate(), clientParams);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            c.a aVar = this.gX;
            if (aVar == null || aVar.getOnWebViewScrollChangeListener() == null) {
                return;
            }
            this.gX.getOnWebViewScrollChangeListener().nu();
        }
    }

    public final void pp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a aVar = this.gX;
            if (aVar != null && aVar.pt()) {
                com.kwad.sdk.core.report.a.b(this.gX.getAdTemplate(), this.gX.getClientParams());
            }
            if (this.KJ != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.KK = currentTimeMillis;
                this.KJ.r(currentTimeMillis);
            }
        }
    }

    public void setClientConfig(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.KJ.setClientConfig(aVar);
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, webChromeClient) == null) {
            if (com.kwad.kwai.kwai.a.aw.booleanValue() && !(webChromeClient instanceof com.kwad.components.core.webview.kwai.b)) {
                throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
            }
            super.setWebChromeClient(webChromeClient);
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, webViewClient) == null) {
            if (com.kwad.kwai.kwai.a.aw.booleanValue() && !(webViewClient instanceof com.kwad.components.core.webview.kwai.a)) {
                throw new IllegalArgumentException("Not supported set webViewClient, please check it");
            }
            super.setWebViewClient(webViewClient);
        }
    }
}
