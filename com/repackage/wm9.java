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
public class wm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, Info info, dp9 dp9Var, String str2) {
        WebView webView;
        zo9 zo9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65536, null, context, str, info, dp9Var, str2) == null) {
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
                    str = sl9.i(str, str2, info.isHo_c_sw(), null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if ((info != null ? info.getPs() : 0) != 0) {
                new ko9().a(context, str, info);
            } else if (b(context, Uri.parse(str), info)) {
            } else {
                if (info.getOpent() == 1) {
                    if (vl9.d.c) {
                        Toast.makeText(context, context.getString(R.string.obfuscated_res_0x7f0f15b4), 1).show();
                        un9 a = yn9.a(context);
                        a.q(new co9(info), 5);
                        a.m();
                        return;
                    }
                    if (!TextUtils.isEmpty(info.getDl_name())) {
                        Context applicationContext = context.getApplicationContext();
                        Toast.makeText(applicationContext, context.getString(R.string.obfuscated_res_0x7f0f15b8) + info.getDl_name(), 0).show();
                    }
                    un9 a2 = yn9.a(context);
                    co9 co9Var = new co9(info);
                    String open = info.getOpen();
                    try {
                        a2.b = yn9.d("wdtr", co9Var);
                        a2.l("msg", yn9.b(open));
                    } catch (JSONException unused2) {
                    }
                    a2.m();
                    if (dp9Var != null) {
                        dp9Var.c = info;
                        WebView webView2 = dp9Var.b;
                        if (webView2 == null) {
                            return;
                        }
                        webView2.loadUrl(info.getOpen());
                        webView = dp9Var.b;
                        zo9Var = new zo9(dp9Var);
                    } else {
                        dp9 dp9Var2 = new dp9(context);
                        dp9Var2.c = info;
                        WebView webView3 = dp9Var2.b;
                        if (webView3 == null) {
                            return;
                        }
                        webView3.loadUrl(info.getOpen());
                        webView = dp9Var2.b;
                        zo9Var = new zo9(dp9Var2);
                    }
                    webView.setDownloadListener(zo9Var);
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
                zn9.a(context, Uri.parse(str));
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
                                un9 a = yn9.a(context);
                                a.i(new co9(info), e.getMessage(), 2);
                                a.m();
                                em9.x = false;
                            }
                            return false;
                        }
                    }
                    zn9.b(context, uri);
                    if (info != null) {
                        un9 a2 = yn9.a(context);
                        a2.i(new co9(info), uri.toString(), 0);
                        a2.m();
                        em9.x = true;
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
