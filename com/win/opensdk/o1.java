package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.alibaba.fastjson.asm.Label;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.win.opensdk.activitys.H5OpenActivity;
import com.win.opensdk.core.Info;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class o1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, Info info, E1 e1, String str2) {
        WebView webView;
        D1 d1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65536, null, context, str, info, e1, str2) == null) {
            if (info != null) {
                try {
                    if (info.getOpent() == 3 && TextUtils.isEmpty(str)) {
                        str = info.getOpen();
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            if (info != null && info.getOpent() == 0 && TextUtils.isEmpty(str)) {
                str = info.getOpen();
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                if (!TextUtils.isEmpty(str2)) {
                    str = z.a(str, 200, str2, info.isHo_c_sw());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if ((info != null ? info.getPs() : 0) != 0) {
                new A1().a(context, str, info);
            } else if (a(context, Uri.parse(str), info)) {
            } else {
                if (info.getOpent() == 1) {
                    if (A.f39315d.f39318c) {
                        Toast.makeText(context, context.getString(R.string.win_wdownload_loading), 1).show();
                        x0.a(context).b(new y0(info), 5).a();
                        return;
                    }
                    if (!TextUtils.isEmpty(info.getDl_name())) {
                        Context applicationContext = context.getApplicationContext();
                        Toast.makeText(applicationContext, context.getString(R.string.win_wdownload_start_load) + info.getDl_name(), 0).show();
                    }
                    w0 a2 = x0.a(context);
                    y0 y0Var = new y0(info);
                    String open = info.getOpen();
                    try {
                        a2.f39697b = x0.a("wdtr", y0Var);
                        a2.a("msg", x0.a(open));
                    } catch (JSONException unused2) {
                    }
                    a2.a();
                    if (e1 != null) {
                        e1.f39357c = info;
                        WebView webView2 = e1.f39356b;
                        if (webView2 == null) {
                            return;
                        }
                        webView2.loadUrl(info.getOpen());
                        webView = e1.f39356b;
                        d1 = new D1(e1);
                    } else {
                        E1 e12 = new E1(context);
                        e12.f39357c = info;
                        WebView webView3 = e12.f39356b;
                        if (webView3 == null) {
                            return;
                        }
                        webView3.loadUrl(info.getOpen());
                        webView = e12.f39356b;
                        d1 = new D1(e12);
                    }
                    webView.setDownloadListener(d1);
                    return;
                }
                if (info.getOpent() == 3) {
                    Intent intent = new Intent(context, H5OpenActivity.class);
                    info.setOph5Url(str);
                    intent.putExtra("Key_H5OpenActData", info);
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    context.startActivity(intent);
                    return;
                }
                x1.a(context, Uri.parse(str));
            }
        }
    }

    public static boolean a(Context context, Uri uri, Info info) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, uri, info)) == null) {
            if (context != null && uri != null) {
                String scheme = uri.getScheme();
                if ((info != null && !TextUtils.isEmpty(info.getDpl())) || (scheme != null && !scheme.equals("http") && !scheme.equals("https"))) {
                    if (info != null) {
                        try {
                            if (!TextUtils.isEmpty(info.getDpl())) {
                                uri = Uri.parse(info.getDpl());
                            }
                        } catch (Exception e2) {
                            if (info != null) {
                                x0.a(context).a(new y0(info), e2.getMessage(), 2).a();
                                PBSplash.isdpl = false;
                            }
                            return false;
                        }
                    }
                    x1.b(context, uri);
                    if (info != null) {
                        x0.a(context).a(new y0(info), uri.toString(), 0).a();
                        PBSplash.isdpl = true;
                    }
                    return true;
                } else if ((scheme == null || !scheme.equals("http")) && scheme.equals("https")) {
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(Info info, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, info, j)) == null) ? info != null && System.currentTimeMillis() - j > 1000 : invokeLJ.booleanValue;
    }
}
