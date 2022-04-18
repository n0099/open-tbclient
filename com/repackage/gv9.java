package com.repackage;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.webviewbase.AdvancedWebView;
/* loaded from: classes6.dex */
public class gv9 extends WebChromeClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ AdvancedWebView a;

    public gv9(AdvancedWebView advancedWebView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {advancedWebView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = advancedWebView;
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WebChromeClient webChromeClient = this.a.k;
            return webChromeClient != null ? webChromeClient.getDefaultVideoPoster() : super.getDefaultVideoPoster();
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WebChromeClient webChromeClient = this.a.k;
            return webChromeClient != null ? webChromeClient.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
        }
        return (View) invokeV.objValue;
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, valueCallback) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.getVisitedHistory(valueCallback);
            } else {
                super.getVisitedHistory(valueCallback);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, webView) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.onCloseWindow(webView);
            } else {
                super.onCloseWindow(webView);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i, str2) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.onConsoleMessage(str, i, str2);
            } else {
                super.onConsoleMessage(str, i, str2);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, consoleMessage)) == null) {
            WebChromeClient webChromeClient = this.a.k;
            return webChromeClient != null ? webChromeClient.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
        }
        return invokeL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{webView, Boolean.valueOf(z), Boolean.valueOf(z2), message})) == null) {
            WebChromeClient webChromeClient = this.a.k;
            return webChromeClient != null ? webChromeClient.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            } else {
                super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.onGeolocationPermissionsHidePrompt();
            } else {
                super.onGeolocationPermissionsHidePrompt();
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, callback) == null) {
            AdvancedWebView advancedWebView = this.a;
            if (advancedWebView.l) {
                callback.invoke(str, true, false);
                return;
            }
            WebChromeClient webChromeClient = advancedWebView.k;
            if (webChromeClient != null) {
                webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
            } else {
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.onHideCustomView();
            } else {
                super.onHideCustomView();
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, webView, str, str2, jsResult)) == null) {
            WebChromeClient webChromeClient = this.a.k;
            return webChromeClient != null ? webChromeClient.onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, webView, str, str2, jsResult)) == null) {
            WebChromeClient webChromeClient = this.a.k;
            return webChromeClient != null ? webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048589, this, webView, str, str2, jsResult)) == null) {
            WebChromeClient webChromeClient = this.a.k;
            return webChromeClient != null ? webChromeClient.onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048590, this, webView, str, str2, str3, jsPromptResult)) == null) {
            WebChromeClient webChromeClient = this.a.k;
            return webChromeClient != null ? webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult) : super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            WebChromeClient webChromeClient = this.a.k;
            return webChromeClient != null ? webChromeClient.onJsTimeout() : super.onJsTimeout();
        }
        return invokeV.booleanValue;
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, permissionRequest) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        WebChromeClient webChromeClient = this.a.k;
        if (webChromeClient != null) {
            webChromeClient.onPermissionRequest(permissionRequest);
        } else {
            super.onPermissionRequest(permissionRequest);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, permissionRequest) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        WebChromeClient webChromeClient = this.a.k;
        if (webChromeClient != null) {
            webChromeClient.onPermissionRequestCanceled(permissionRequest);
        } else {
            super.onPermissionRequestCanceled(permissionRequest);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, webView, i) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.onProgressChanged(webView, i);
            } else {
                super.onProgressChanged(webView, i);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), quotaUpdater}) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            } else {
                super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, webView, bitmap) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.onReceivedIcon(webView, bitmap);
            } else {
                super.onReceivedIcon(webView, bitmap);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, webView, str) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.onReceivedTitle(webView, str);
            } else {
                super.onReceivedTitle(webView, str);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048598, this, webView, str, z) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.onReceivedTouchIconUrl(webView, str, z);
            } else {
                super.onReceivedTouchIconUrl(webView, str, z);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, webView) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.onRequestFocus(webView);
            } else {
                super.onRequestFocus(webView);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view2, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048600, this, view2, i, customViewCallback) == null) || Build.VERSION.SDK_INT < 14) {
            return;
        }
        WebChromeClient webChromeClient = this.a.k;
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view2, i, customViewCallback);
        } else {
            super.onShowCustomView(view2, i, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view2, WebChromeClient.CustomViewCallback customViewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, view2, customViewCallback) == null) {
            WebChromeClient webChromeClient = this.a.k;
            if (webChromeClient != null) {
                webChromeClient.onShowCustomView(view2, customViewCallback);
            } else {
                super.onShowCustomView(view2, customViewCallback);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048602, this, webView, valueCallback, fileChooserParams)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.a.e(null, valueCallback, fileChooserParams.getMode() == 1);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
