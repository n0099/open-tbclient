package com.win.opensdk;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class c2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f76612a;

    /* renamed from: b  reason: collision with root package name */
    public Info f76613b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f76614c;

    public c2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76614c = new a2(this);
    }

    public static boolean a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) ? "appmarket".equalsIgnoreCase(uri.getScheme()) : invokeL.booleanValue;
    }

    public static boolean b(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uri)) == null) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            return "market".equalsIgnoreCase(scheme) || "market.android.com".equalsIgnoreCase(host) || "play.google.com".equalsIgnoreCase(host);
        }
        return invokeL.booleanValue;
    }

    public void a(Context context, String str, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, info) == null) {
            this.f76612a = context;
            this.f76613b = info;
            WebView webView = new WebView(context);
            WebSettings settings = webView.getSettings();
            settings.setAllowContentAccess(true);
            settings.setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.setWebViewClient(new b2(this, context, info, str));
            HashMap hashMap = new HashMap();
            hashMap.put("X-Requested-With", "");
            webView.loadUrl(str, hashMap);
            Message obtain = Message.obtain();
            obtain.what = 11;
            obtain.obj = str;
            this.f76614c.sendMessageDelayed(obtain, 5000L);
        }
    }
}
