package com.win.opensdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class z1 extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f42712a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f42713b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Info f42714c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f42715d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ A1 f42716e;

    public z1(A1 a1, Context context, Info info, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a1, context, info, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42716e = a1;
        this.f42713b = context;
        this.f42714c = info;
        this.f42715d = str;
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Uri parse = Uri.parse(str);
            if (A1.a(parse) || A1.b(parse)) {
                this.f42712a = true;
                if (!o1.a(this.f42713b, parse, null)) {
                    x1.a(this.f42713b, parse);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
            super.onPageFinished(webView, str);
            this.f42716e.f42309c.removeMessages(11);
            if (this.f42712a) {
                return;
            }
            w0 a2 = x0.a(this.f42713b);
            try {
                a2.f42683b = x0.a("ps", new y0(this.f42714c));
                a2.a("co", 2004);
                a2.a("msg", str);
            } catch (JSONException unused) {
            }
            a2.a();
            Message obtain = Message.obtain();
            obtain.what = 12;
            obtain.obj = this.f42715d;
            this.f42716e.f42309c.sendMessage(obtain);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, webResourceRequest)) == null) ? Build.VERSION.SDK_INT >= 24 ? a(webResourceRequest.getUrl().toString()) : super.shouldOverrideUrlLoading(webView, webResourceRequest) : invokeLL.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) ? Build.VERSION.SDK_INT < 24 ? a(str) : super.shouldOverrideUrlLoading(webView, str) : invokeLL.booleanValue;
    }
}
