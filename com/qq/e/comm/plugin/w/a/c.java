package com.qq.e.comm.plugin.w.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.baidu.live.tbadk.pay.PayHelper;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.net.URLEncoder;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile AlertDialog f12928a;

    public static int a(Context context, String str, String str2, String str3, String str4, boolean z) {
        if (StringUtil.isEmpty(str2) && StringUtil.isEmpty(str)) {
            return 0;
        }
        ResolveInfo b2 = b(context, str, str2);
        if (StringUtil.isEmpty(str2) || b2 != null) {
            try {
                String a2 = a(str2, str3, str4);
                Intent a3 = a(context, str, StringUtil.isEmpty(a2) ? null : Uri.parse(a2));
                if (a3 != null) {
                    CharSequence loadLabel = b2 == null ? null : b2.loadLabel(context.getPackageManager());
                    String charSequence = loadLabel != null ? loadLabel.toString() : null;
                    if (z && !a(context, charSequence)) {
                        GDTLogger.d("deep link cancel startActivity");
                        return 2;
                    }
                    GDTLogger.d("deep link startActivity");
                    context.startActivity(a3);
                    return 1;
                }
                return 0;
            } catch (Throwable th) {
                GDTLogger.report("ExceptionIn DownClickRunnable.startInstalledAPP", th);
                return 0;
            }
        }
        return 0;
    }

    public static Intent a(Context context, String str, Uri uri) {
        if (uri == null) {
            if (StringUtil.isEmpty(str)) {
                return null;
            }
            return context.getPackageManager().getLaunchIntentForPackage(str).addFlags(268435456);
        }
        Intent intent = new Intent();
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (StringUtil.isEmpty(str)) {
            return intent;
        }
        intent.setPackage(str);
        return intent;
    }

    public static String a(String str, String str2, String str3) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        if (StringUtil.isEmpty(str2)) {
            str2 = "unknown";
        }
        if (StringUtil.isEmpty(str3)) {
            str3 = "unknown";
        }
        return str.replaceAll("\\$\\{platform\\}", URLEncoder.encode("e.qq.com")).replaceAll("\\$\\{adid\\}", URLEncoder.encode(str2)).replaceAll("\\$\\{clickid\\}", URLEncoder.encode(str3)).replaceAll("\\$\\{traceurl\\}", "none");
    }

    public static void a() {
        if (f12928a != null) {
            try {
                f12928a.dismiss();
                f12928a = null;
            } catch (Throwable th) {
                f12928a = null;
            }
        }
    }

    private static boolean a(Context context, String str) {
        final Exchanger exchanger = new Exchanger();
        final AlertDialog.Builder builder = new AlertDialog.Builder(context, Build.VERSION.SDK_INT >= 21 ? 16974394 : 0);
        if (str == null) {
            str = "APP";
        }
        builder.setMessage(String.format("前往“%s”了解更多", str));
        builder.setCancelable(false);
        builder.setPositiveButton("前往", new DialogInterface.OnClickListener() { // from class: com.qq.e.comm.plugin.w.a.c.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    exchanger.exchange(true, 100L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        builder.setNegativeButton(PayHelper.STATUS_CANCEL_DESC, new DialogInterface.OnClickListener() { // from class: com.qq.e.comm.plugin.w.a.c.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    exchanger.exchange(false, 100L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.qq.e.comm.plugin.w.a.c.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                try {
                    exchanger.exchange(false, 100L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.w.a.c.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.a();
                    AlertDialog unused = c.f12928a = builder.show();
                    c.f12928a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qq.e.comm.plugin.w.a.c.4.1
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            try {
                                exchanger.exchange(false, 100L, TimeUnit.MILLISECONDS);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                } catch (Throwable th) {
                    th.printStackTrace();
                    try {
                        exchanger.exchange(false);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        try {
            boolean booleanValue = ((Boolean) exchanger.exchange(false)).booleanValue();
            a();
            return booleanValue;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        return b(context, str, str2) != null;
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4) {
        return a(context, str, str2, str3, str4, false) != 0;
    }

    public static ResolveInfo b(Context context, String str, String str2) {
        if (StringUtil.isEmpty(str2)) {
            return null;
        }
        Uri parse = Uri.parse(a(str2, (String) null, (String) null));
        if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme())) {
            return null;
        }
        return context.getPackageManager().resolveActivity(a(context, str, parse), 65536);
    }
}
