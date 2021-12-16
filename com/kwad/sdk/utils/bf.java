package com.kwad.sdk.utils;

import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(WebView webView, String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, webView, str, valueCallback) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                ax.a(new Runnable(webView, str, valueCallback) { // from class: com.kwad.sdk.utils.bf.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WebView a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f60218b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ ValueCallback f60219c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {webView, str, valueCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = webView;
                        this.f60218b = str;
                        this.f60219c = valueCallback;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.evaluateJavascript(this.f60218b, this.f60219c);
                        }
                    }
                });
                return;
            }
            webView.loadUrl(str);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        }
    }

    public static void a(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, webView, str, str2) == null) {
            a(webView, "javascript:" + str + "(" + JSONObject.quote(str2) + SmallTailInfo.EMOTION_SUFFIX, (ValueCallback<String>) null);
        }
    }
}
