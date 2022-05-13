package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.win.opensdk.activitys.H5OpenActivity;
import com.win.opensdk.core.Info;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class vp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, Info info, cs9 cs9Var, String str2) {
        WebView webView;
        yr9 yr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65536, null, context, str, info, cs9Var, str2) == null) {
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
                    str = ro9.i(str, str2, info.isHo_c_sw(), null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ((info != null ? info.getPs() : 0) != 0) {
                new jr9().a(context, str, info);
            } else if (b(context, Uri.parse(str), info)) {
            } else {
                if (info.getOpent() == 1) {
                    if (uo9.d.c) {
                        Toast.makeText(context, context.getString(R.string.obfuscated_res_0x7f0f1594), 1).show();
                        tq9 a = xq9.a(context);
                        a.q(new br9(info), 5);
                        a.m();
                        return;
                    }
                    if (!TextUtils.isEmpty(info.getDl_name())) {
                        Context applicationContext = context.getApplicationContext();
                        Toast.makeText(applicationContext, context.getString(R.string.obfuscated_res_0x7f0f1598) + info.getDl_name(), 0).show();
                    }
                    tq9 a2 = xq9.a(context);
                    br9 br9Var = new br9(info);
                    String open = info.getOpen();
                    try {
                        a2.b = xq9.d("wdtr", br9Var);
                        a2.l("msg", xq9.b(open));
                    } catch (JSONException unused2) {
                    }
                    a2.m();
                    if (cs9Var != null) {
                        cs9Var.c = info;
                        WebView webView2 = cs9Var.b;
                        if (webView2 == null) {
                            return;
                        }
                        webView2.loadUrl(info.getOpen());
                        webView = cs9Var.b;
                        yr9Var = new yr9(cs9Var);
                    } else {
                        cs9 cs9Var2 = new cs9(context);
                        cs9Var2.c = info;
                        WebView webView3 = cs9Var2.b;
                        if (webView3 == null) {
                            return;
                        }
                        webView3.loadUrl(info.getOpen());
                        webView = cs9Var2.b;
                        yr9Var = new yr9(cs9Var2);
                    }
                    webView.setDownloadListener(yr9Var);
                    return;
                }
                if (info.getOpent() == 3) {
                    Intent intent = new Intent(context, H5OpenActivity.class);
                    info.setOph5Url(str);
                    intent.putExtra("Key_H5OpenActData", info);
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    context.startActivity(intent);
                    return;
                }
                yq9.a(context, Uri.parse(str));
            }
        }
    }

    public static boolean b(Context context, Uri uri, Info info) {
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
                                tq9 a = xq9.a(context);
                                a.i(new br9(info), e.getMessage(), 2);
                                a.m();
                                dp9.x = false;
                            }
                            return false;
                        }
                    }
                    yq9.b(context, uri);
                    if (info != null) {
                        tq9 a2 = xq9.a(context);
                        a2.i(new br9(info), uri.toString(), 0);
                        a2.m();
                        dp9.x = true;
                    }
                    return true;
                } else if ((scheme == null || !scheme.equals("http")) && scheme.equals("https")) {
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c(Info info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, info)) == null) ? info != null && info.getOpent() == 3 : invokeL.booleanValue;
    }

    public static boolean d(Info info, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, info, j)) == null) ? info != null && System.currentTimeMillis() - j > 1000 : invokeLJ.booleanValue;
    }
}
