package com.win.opensdk.bridge.core;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.bridge.async.AsyncTaskExecutor;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class JsCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference a;
    public String b;

    /* loaded from: classes7.dex */
    public class JsCallbackException extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JsCallbackException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public JsCallback(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new WeakReference(webView);
        this.b = str;
    }

    public static void invokeJsCallback(JsCallback jsCallback, boolean z, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{jsCallback, Boolean.valueOf(z), jSONObject, str}) == null) || jsCallback == null) {
            return;
        }
        try {
            jsCallback.call(z, jSONObject, str);
        } catch (JsCallbackException e) {
            e.printStackTrace();
        }
    }

    public static JsCallback newInstance(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, webView, str)) == null) ? new JsCallback(webView, str) : (JsCallback) invokeLL.objValue;
    }

    public void call(boolean z, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), jSONObject, str}) == null) {
            WebView webView = (WebView) this.a.get();
            if (webView == null) {
                throw new JsCallbackException("The WebView related to the JsCallback has been recycled!");
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("code", !z ? 1 : 0);
                if (TextUtils.isEmpty(str)) {
                    jSONObject3.put("msg", "");
                } else {
                    jSONObject3.put("msg", str);
                }
                jSONObject2.put("status", jSONObject3);
                if (jSONObject != null) {
                    jSONObject2.put("data", jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String format = String.format(Locale.getDefault(), "javascript:JsBridge.onComplete(%s,%s);", this.b, jSONObject2.toString());
            if (AsyncTaskExecutor.isMainThread()) {
                webView.loadUrl(format);
            } else {
                AsyncTaskExecutor.runOnMainThread(new Runnable(this, webView, format) { // from class: com.win.opensdk.bridge.core.JsCallback.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WebView a;
                    public final /* synthetic */ String b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, webView, format};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = webView;
                        this.b = format;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.loadUrl(this.b);
                        }
                    }
                });
            }
        }
    }
}
