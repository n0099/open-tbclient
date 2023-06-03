package com.win.opensdk.bridge;

import android.webkit.WebView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.M1;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void finish(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, webView, jSONObject, jsCallback) == null) {
            M1.a("hcl", "hcl", null);
        }
    }

    public static void onCustomEvent(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, webView, jSONObject, jsCallback) == null) {
            String optString = jSONObject.optString("message");
            int optInt = jSONObject.optInt("event");
            M1.a("onCustomEvent", "" + optInt, optString);
        }
    }

    public static void onPlayProgress(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, webView, jSONObject, jsCallback) == null) {
            M1.a("onPlayProgress", "onPlayProgress", Integer.valueOf(jSONObject.optInt("message", 0)));
        }
    }

    public static void onRewardedAdFinish(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, webView, jSONObject, jsCallback) == null) {
            M1.a("onRewardedAdFinish", "onRewardedAdFinish", Integer.valueOf(jSONObject.optInt("message", 0)));
        }
    }

    public static void onRewardedAdStart(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, webView, jSONObject, jsCallback) == null) {
            M1.a("onRewardedAdStart", "onRewardedAdStart", null);
        }
    }

    public static void onRewardedShowFail(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, webView, jSONObject, jsCallback) == null) {
            M1.a("onRewardedShowFail", "onRewardedShowFail", jSONObject.optString("message"));
        }
    }

    public static void onT(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, webView, jSONObject, jsCallback) == null) {
            M1.a("onT", "onT", jSONObject.optString("message"));
        }
    }

    public static void showToast(WebView webView, JSONObject jSONObject, JsCallback jsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, webView, jSONObject, jsCallback) == null) {
            Toast.makeText(webView.getContext(), jSONObject.toString(), 0).show();
            JsCallback.invokeJsCallback(jsCallback, true, null, null);
        }
    }
}
