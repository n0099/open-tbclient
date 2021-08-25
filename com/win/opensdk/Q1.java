package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.win.opensdk.activitys.H5OpenActivity;
import com.win.opensdk.core.Info;
import org.json.JSONException;
/* loaded from: classes10.dex */
public class Q1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, Info info, g2 g2Var, String str2) {
        WebView webView;
        f2 f2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65536, null, context, str, info, g2Var, str2) == null) {
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
                    str = N.a(str, 200, str2, info.isHo_c_sw());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if ((info != null ? info.getPs() : 0) != 0) {
                new c2().a(context, str, info);
            } else if (a(context, Uri.parse(str), info)) {
            } else {
                if (info.getOpent() == 1) {
                    if (O.f76641d.f76644c) {
                        Toast.makeText(context, context.getString(R.string.win_wdownload_loading), 1).show();
                        Z0.a(context).b(new a1(info), 5).a();
                        return;
                    }
                    if (!TextUtils.isEmpty(info.getDl_name())) {
                        Context applicationContext = context.getApplicationContext();
                        Toast.makeText(applicationContext, context.getString(R.string.win_wdownload_start_load) + info.getDl_name(), 0).show();
                    }
                    Y0 a2 = Z0.a(context);
                    a1 a1Var = new a1(info);
                    String open = info.getOpen();
                    try {
                        a2.f76755b = Z0.a("wdtr", a1Var);
                        a2.a("msg", Z0.a(open));
                    } catch (JSONException unused2) {
                    }
                    a2.a();
                    if (g2Var != null) {
                        g2Var.f76854c = info;
                        WebView webView2 = g2Var.f76853b;
                        if (webView2 == null) {
                            return;
                        }
                        webView2.loadUrl(info.getOpen());
                        webView = g2Var.f76853b;
                        f2Var = new f2(g2Var);
                    } else {
                        g2 g2Var2 = new g2(context);
                        g2Var2.f76854c = info;
                        WebView webView3 = g2Var2.f76853b;
                        if (webView3 == null) {
                            return;
                        }
                        webView3.loadUrl(info.getOpen());
                        webView = g2Var2.f76853b;
                        f2Var = new f2(g2Var2);
                    }
                    webView.setDownloadListener(f2Var);
                    return;
                }
                if (info.getOpent() == 3) {
                    Intent intent = new Intent(context, H5OpenActivity.class);
                    info.setOph5Url(str);
                    intent.putExtra("Key_H5OpenActData", info);
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    return;
                }
                Z1.a(context, Uri.parse(str));
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
                                Z0.a(context).a(new a1(info), e2.getMessage(), 2).a();
                                PBSplash.isdpl = false;
                            }
                            return false;
                        }
                    }
                    Z1.b(context, uri);
                    if (info != null) {
                        Z0.a(context).a(new a1(info), uri.toString(), 0).a();
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

    public static boolean a(Info info, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, info, j2)) == null) ? info != null && System.currentTimeMillis() - j2 > 1000 : invokeLJ.booleanValue;
    }
}
