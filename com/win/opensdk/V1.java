package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.win.opensdk.activitys.H5OpenActivity;
import com.win.opensdk.core.Info;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class V1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
                        } catch (Exception e) {
                            if (info != null) {
                                e1.a(context).a(new f1(info), e.getMessage(), 2).a();
                                PBSplash.isdpl = false;
                            }
                            return false;
                        }
                    }
                    e2.b(context, uri);
                    if (info != null) {
                        e1.a(context).a(new f1(info), uri.toString(), 0).a();
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

    public static boolean a(Info info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, info)) == null) ? info != null && info.getOpent() == 3 : invokeL.booleanValue;
    }

    public static boolean a(Info info, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, info, j)) == null) ? info != null && System.currentTimeMillis() - j > 1000 : invokeLJ.booleanValue;
    }

    public static void a(Context context, String str, Info info, m2 m2Var, String str2) {
        int i;
        WebView webView;
        l2 l2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65536, null, context, str, info, m2Var, str2) == null) {
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
                    str = M.a(str, str2, info.isHo_c_sw(), null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean z = false;
            if (info != null) {
                i = info.getPs();
            } else {
                i = 0;
            }
            if (i == 0) {
                if (!a(context, Uri.parse(str), info)) {
                    if (info.getOpent() == 1) {
                        if (N.d.c) {
                            Toast.makeText(context, context.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f16f2), 1).show();
                            e1.a(context).c(new f1(info), 5).a();
                            return;
                        }
                        if (!TextUtils.isEmpty(info.getDl_name())) {
                            Context applicationContext = context.getApplicationContext();
                            Toast.makeText(applicationContext, context.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f16f6) + info.getDl_name(), 0).show();
                        }
                        d1 a = e1.a(context);
                        f1 f1Var = new f1(info);
                        String open = info.getOpen();
                        try {
                            a.b = e1.a("wdtr", f1Var);
                            a.a("msg", e1.a(open));
                        } catch (JSONException unused2) {
                        }
                        a.a();
                        if (m2Var != null) {
                            m2Var.c = info;
                            WebView webView2 = m2Var.b;
                            if (webView2 != null) {
                                webView2.loadUrl(info.getOpen());
                                webView = m2Var.b;
                                l2Var = new l2(m2Var);
                            } else {
                                return;
                            }
                        } else {
                            m2 m2Var2 = new m2(context);
                            m2Var2.c = info;
                            WebView webView3 = m2Var2.b;
                            if (webView3 != null) {
                                webView3.loadUrl(info.getOpen());
                                webView = m2Var2.b;
                                l2Var = new l2(m2Var2);
                            } else {
                                return;
                            }
                        }
                        webView.setDownloadListener(l2Var);
                        return;
                    }
                    if (info.getOpent() == 3) {
                        z = true;
                    }
                    if (z) {
                        Intent intent = new Intent(context, H5OpenActivity.class);
                        info.setOph5Url(str);
                        intent.putExtra("Key_H5OpenActData", info);
                        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                        context.startActivity(intent);
                        return;
                    }
                    e2.a(context, Uri.parse(str));
                    return;
                }
                return;
            }
            new h2().a(context, str, info);
        }
    }
}
