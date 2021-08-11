package com.win.opensdk.bridge;

import android.webkit.WebView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.H1;
import com.win.opensdk.bridge.core.JsCallback;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class JsInvokeJavaScope {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JsInvokeJavaScope() {
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

    public static void finish(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, webView, jSONObject, jsCallback) == null) {
            H1.a("hcl", "hcl", null);
        }
    }

    public static void onPlayProgress(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, webView, jSONObject, jsCallback) == null) {
            H1.a("onPlayProgress", "onPlayProgress", Integer.valueOf(jSONObject.optInt("message", 0)));
        }
    }

    public static void onRewardedAdFinish(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, webView, jSONObject, jsCallback) == null) {
            H1.a("onRewardedAdFinish", "onRewardedAdFinish", Integer.valueOf(jSONObject.optInt("message", 0)));
        }
    }

    public static void onRewardedAdStart(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, webView, jSONObject, jsCallback) == null) {
            H1.a("onRewardedAdStart", "onRewardedAdStart", null);
        }
    }

    public static void onRewardedShowFail(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, webView, jSONObject, jsCallback) == null) {
            H1.a("onRewardedShowFail", "onRewardedShowFail", jSONObject.optString("message"));
        }
    }

    public static void onT(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, webView, jSONObject, jsCallback) == null) {
            H1.a("onT", "onT", jSONObject.optString("message"));
        }
    }

    public static void showToast(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, webView, jSONObject, jsCallback) == null) {
            Toast.makeText(webView.getContext(), jSONObject.toString(), 0).show();
            JsCallback.invokeJsCallback(jsCallback, true, null, null);
        }
    }
}
