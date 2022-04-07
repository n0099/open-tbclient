package com.repackage;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5OpenActivity;
import com.win.opensdk.core.Info;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class bp9 extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ H5OpenActivity a;

    public bp9(H5OpenActivity h5OpenActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h5OpenActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = h5OpenActivity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
            Context applicationContext = this.a.getApplicationContext();
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if ((TextUtils.isEmpty(scheme) || scheme.equals("http") || scheme.equals("https")) ? false : true) {
                try {
                    rr9 a = vr9.a(applicationContext);
                    a.i(new zr9(this.a.d), parse.toString(), 0);
                    a.m();
                    HashMap hashMap = new HashMap();
                    hashMap.put("__SCHEME__", parse.toString());
                    Info info = this.a.d;
                    if (info != null) {
                        pp9.K(pp9.i((String) info.getEvents().get(600, ""), "", info.isHo_c_sw(), hashMap));
                    }
                    wr9.b(applicationContext, parse);
                    return true;
                } catch (Exception e) {
                    rr9 a2 = vr9.a(applicationContext);
                    a2.i(new zr9(this.a.d), e.getMessage(), 2);
                    a2.m();
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
