package io.flutter.plugins.webviewflutter;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.WebViewClientCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes10.dex */
public class FlutterWebViewClient {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FlutterWebViewClient";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasNavigationDelegate;
    public final MethodChannel methodChannel;

    /* loaded from: classes10.dex */
    public static class OnNavigationRequestResult implements MethodChannel.Result {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<String, String> headers;
        public final String url;
        public final WebView webView;

        private void loadUrl() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.webView.loadUrl(this.url, this.headers);
                } else {
                    this.webView.loadUrl(this.url);
                }
            }
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void error(String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
                throw new IllegalStateException("navigationRequest calls must succeed");
            }
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void notImplemented() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                throw new IllegalStateException("navigationRequest must be implemented by the webview method channel");
            }
        }

        @Override // io.flutter.plugin.common.MethodChannel.Result
        public void success(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) && ((Boolean) obj).booleanValue()) {
                loadUrl();
            }
        }

        public OnNavigationRequestResult(String str, Map<String, String> map, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, map, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.url = str;
            this.headers = map;
            this.webView = webView;
        }
    }

    public FlutterWebViewClient(MethodChannel methodChannel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {methodChannel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.methodChannel = methodChannel;
    }

    public static String errorCodeToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) {
            switch (i2) {
                case -16:
                    return "unsafeResource";
                case -15:
                    return "tooManyRequests";
                case -14:
                    return "fileNotFound";
                case -13:
                    return "file";
                case -12:
                    return "badUrl";
                case -11:
                    return "failedSslHandshake";
                case -10:
                    return "unsupportedScheme";
                case -9:
                    return "redirectLoop";
                case -8:
                    return "timeout";
                case -7:
                    return "io";
                case -6:
                    return "connect";
                case -5:
                    return "proxyAuthentication";
                case -4:
                    return "authentication";
                case -3:
                    return "unsupportedAuthScheme";
                case -2:
                    return "hostLookup";
                case -1:
                    return "unknown";
                default:
                    throw new IllegalArgumentException(String.format(Locale.getDefault(), "Could not find a string for errorCode: %d", Integer.valueOf(i2)));
            }
        }
        return (String) invokeI.objValue;
    }

    private WebViewClient internalCreateWebViewClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? new WebViewClient(this) { // from class: io.flutter.plugins.webviewflutter.FlutterWebViewClient.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterWebViewClient this$0;

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

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                    this.this$0.onPageFinished(webView, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                    this.this$0.onPageStarted(webView, str);
                }
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, webView, webResourceRequest, webResourceError) == null) {
                    this.this$0.onWebResourceError(webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
                }
            }

            @Override // android.webkit.WebViewClient
            public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048580, this, webView, keyEvent) == null) {
                }
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(24)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048581, this, webView, webResourceRequest)) == null) ? this.this$0.shouldOverrideUrlLoading(webView, webResourceRequest) : invokeLL.booleanValue;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                    this.this$0.onWebResourceError(i2, str, str2);
                }
            }
        } : (WebViewClient) invokeV.objValue;
    }

    private WebViewClientCompat internalCreateWebViewClientCompat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? new WebViewClientCompat(this) { // from class: io.flutter.plugins.webviewflutter.FlutterWebViewClient.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlutterWebViewClient this$0;

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

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                    this.this$0.onPageFinished(webView, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                    this.this$0.onPageStarted(webView, str);
                }
            }

            @Override // androidx.webkit.WebViewClientCompat
            @SuppressLint({"RequiresFeature"})
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceErrorCompat webResourceErrorCompat) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, webView, webResourceRequest, webResourceErrorCompat) == null) {
                    this.this$0.onWebResourceError(webResourceErrorCompat.getErrorCode(), webResourceErrorCompat.getDescription().toString(), webResourceRequest.getUrl().toString());
                }
            }

            @Override // android.webkit.WebViewClient
            public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048580, this, webView, keyEvent) == null) {
                }
            }

            @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048581, this, webView, webResourceRequest)) == null) ? this.this$0.shouldOverrideUrlLoading(webView, webResourceRequest) : invokeLL.booleanValue;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048582, this, webView, str)) == null) ? this.this$0.shouldOverrideUrlLoading(webView, str) : invokeLL.booleanValue;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                    this.this$0.onWebResourceError(i2, str, str2);
                }
            }
        } : (WebViewClientCompat) invokeV.objValue;
    }

    private void notifyOnNavigationRequest(String str, Map<String, String> map, WebView webView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{str, map, webView, Boolean.valueOf(z)}) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("isForMainFrame", Boolean.valueOf(z));
            if (z) {
                this.methodChannel.invokeMethod("navigationRequest", hashMap, new OnNavigationRequestResult(str, map, webView));
            } else {
                this.methodChannel.invokeMethod("navigationRequest", hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, webView, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            this.methodChannel.invokeMethod("onPageFinished", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPageStarted(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, webView, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            this.methodChannel.invokeMethod("onPageStarted", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWebResourceError(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65548, this, i2, str, str2) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", Integer.valueOf(i2));
            hashMap.put("description", str);
            hashMap.put("errorType", errorCodeToString(i2));
            hashMap.put("failingUrl", str2);
            this.methodChannel.invokeMethod("onWebResourceError", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, webView, webResourceRequest)) == null) {
            if (this.hasNavigationDelegate) {
                notifyOnNavigationRequest(webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders(), webView, webResourceRequest.isForMainFrame());
                return webResourceRequest.isForMainFrame();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public WebViewClient createWebViewClient(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.hasNavigationDelegate = z;
            if (z && Build.VERSION.SDK_INT < 24) {
                return internalCreateWebViewClientCompat();
            }
            return internalCreateWebViewClient();
        }
        return (WebViewClient) invokeZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, webView, str)) == null) {
            if (this.hasNavigationDelegate) {
                notifyOnNavigationRequest(str, null, webView, true);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
