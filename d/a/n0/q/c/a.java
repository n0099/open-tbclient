package d.a.n0.q.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AdWebViewActivityConfig;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.UtilHelper;
import d.a.c.e.p.k;
import d.a.m0.r.l.a;
import d.a.m0.r.l.e;
/* loaded from: classes4.dex */
public class a {
    public static String a(String str) {
        if (k.isEmpty(str) || str.indexOf("cuid=") > -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") > 0) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        if (!UtilHelper.isNativeAdURL(str)) {
            sb.append("cuid=");
            sb.append(TbadkCoreApplication.getInst().getCuid());
            sb.append("&cuid_galaxy2=");
            sb.append(TbadkCoreApplication.getInst().getCuidGalaxy2());
            sb.append("&c3_aid=");
            sb.append(TbadkCoreApplication.getInst().getCuidGalaxy3());
            sb.append("&cuid_gid=");
            sb.append(TbadkCoreApplication.getInst().getCuidGid());
        }
        sb.append("&timestamp=");
        sb.append(System.currentTimeMillis());
        return sb.toString();
    }

    public static String b(String str) {
        if (k.isEmpty(str) || str.indexOf("_client_version=") <= -1) {
            return str + "&_client_version=" + TbConfig.getVersion();
        }
        return str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00c9 -> B:29:0x00cc). Please submit an issue!!! */
    public static void c(Context context) {
        CookieManager cookieManager;
        a.b d2 = d.a.m0.r.l.a.b().d(TbadkCoreApplication.getCurrentBduss());
        try {
            CookieSyncManager.createInstance(TbadkCoreApplication.getInst());
            cookieManager = CookieManager.getInstance();
        } catch (Throwable th) {
            BdLog.e(th);
            cookieManager = null;
        }
        if (cookieManager == null) {
            return;
        }
        if (d2 != null) {
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("baidu.com", "CUID=" + TbadkCoreApplication.getInst().getCuid() + "; domain=.baidu.com; cuid_galaxy2=" + TbadkCoreApplication.getInst().getCuidGalaxy2() + "; c3_aid=" + TbadkCoreApplication.getInst().getCuidGalaxy3() + "; cuid_gid=" + TbadkCoreApplication.getInst().getCuidGid() + ";");
            String a2 = e.a(TbadkCoreApplication.getCurrentAccountInfo());
            StringBuilder sb = new StringBuilder();
            if (!StringUtils.isNull(a2)) {
                sb.append("STOKEN=");
                sb.append(a2);
                sb.append("; domain=.tieba.baidu.com;");
                cookieManager.setCookie(TbPatternsCompat.TB_DOMAIN_NAME, sb.toString());
            }
        } else {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    cookieManager.removeAllCookies(null);
                    CookieManager.getInstance().flush();
                } else {
                    cookieManager.removeAllCookie();
                    CookieSyncManager.createInstance(context);
                    CookieSyncManager.getInstance().sync();
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().flush();
            } else {
                CookieSyncManager.getInstance().sync();
            }
        } catch (Exception e3) {
            BdLog.e(e3);
        }
    }

    public static String d(String str, String str2) {
        String str3;
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            str = "http://".concat(str);
        }
        if (str.contains("?")) {
            str3 = "&st_type=" + str2;
        } else {
            str3 = "?st_type=" + str2;
        }
        return str.concat(str3);
    }

    public static void e() {
        new PvThread("open_webview", true).start();
    }

    public static void f(Context context, String str) {
        String b2 = b(a(str));
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(b2));
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void g(Context context, String str, String str2, Bundle bundle) {
        h(context, str2, str, true, true, true, bundle);
    }

    public static void h(Context context, String str, String str2, boolean z, boolean z2, boolean z3, Bundle bundle) {
        e();
        try {
            if (StringUtils.isNull(str2)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AdWebViewActivityConfig(context, str, str2, z, z2, z3, bundle)));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
