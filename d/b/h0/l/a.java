package d.b.h0.l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.util.Base64Encoder;
import com.baidu.wallet.core.Domains;
import d.b.b.e.p.k;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f50252a;

    public static void a(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
    }

    public static String b(String str) {
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
            sb.append("&cuid_gid=");
            sb.append(TbadkCoreApplication.getInst().getCuidGid());
        }
        sb.append("&timestamp=");
        sb.append(Long.toString(System.currentTimeMillis()));
        return sb.toString();
    }

    public static String c(String str, List<Pair<String, String>> list) {
        if (k.isEmpty(str) || list == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.indexOf("?") < 0) {
            sb.append("?");
        }
        for (Pair<String, String> pair : list) {
            if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first)) {
                sb.append("&");
                sb.append((String) pair.first);
                sb.append("=");
                sb.append((String) pair.second);
            }
        }
        return sb.toString();
    }

    public static String d(String str) {
        if (k.isEmpty(str) || str.indexOf("_client_version=") <= -1) {
            return str + "&_client_version=" + TbConfig.getVersion();
        }
        return str;
    }

    public static void e(Context context, String str) {
        h();
        try {
            if (StringUtils.isNull(str)) {
                return;
            }
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context, "", str, true, false, false, false);
            tbWebViewActivityConfig.setLoadType(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void f(Context context) {
        CookieManager cookieManager;
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
        cookieManager.setAcceptCookie(true);
        if (d.b.h0.r.l.a.b().d(TbadkCoreApplication.getCurrentBduss()) != null) {
            String a2 = d.b.h0.r.l.e.a(TbadkCoreApplication.getCurrentAccountInfo());
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
        cookieManager.setCookie(Domains.BAIDU, "CUID=" + TbadkCoreApplication.getInst().getCuid() + ";");
        String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
        cookieManager.setCookie(Domains.BAIDU, "BAIDUCUID=" + (!TextUtils.isEmpty(cuidGalaxy2) ? new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes())) : "") + ";");
        cookieManager.setCookie(Domains.BAIDU, "TBBRAND=" + Build.MODEL + ";");
        cookieManager.setCookie(Domains.BAIDU, "BAIDUZID=" + TbadkCoreApplication.getInst().getZid() + ";");
        cookieManager.setCookie(Domains.BAIDU, "cuid_galaxy2=" + cuidGalaxy2 + ";");
        cookieManager.setCookie(Domains.BAIDU, "cuid_gid=" + TbadkCoreApplication.getInst().getCuidGid() + ";");
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().flush();
            } else {
                CookieSyncManager.getInstance().sync();
            }
            SapiAccountManager.getInstance().getAccountService().webLogin(context);
        } catch (Throwable th2) {
            BdLog.e(th2);
        }
    }

    public static String g(String str, String str2) {
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

    public static void h() {
        new PvThread("open_webview", true).start();
    }

    public static void i(String str) {
        f50252a = str;
    }

    public static void j(Context context, String str) {
        String d2 = d(b(str));
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(d2));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void k(Context context, String str) {
        l(context, str);
    }

    public static void l(Context context, String str) {
        s(context, true, str);
    }

    public static void m(Context context, String str, String str2) {
        p(context, str, str2, true, true, true, true, true);
    }

    public static void n(Context context, String str, String str2, boolean z) {
        p(context, str, str2, true, z, true, true, true);
    }

    public static void o(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        p(context, str, str2, z, z2, z3, true, true);
    }

    public static void p(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        h();
        try {
            if (StringUtils.isNull(str2)) {
                return;
            }
            if (z5) {
                str2 = d(b(str2));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(context, str, str2, z, z2, z3)));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void q(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        r(context, str, str2, z, z2, z3, z4, z5, z6, false);
    }

    public static void r(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        h();
        try {
            if (StringUtils.isNull(str2)) {
                return;
            }
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context, str, z5 ? d(b(str2)) : str2, z, z2, z3, z6);
            tbWebViewActivityConfig.setFixTitle(z7);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void s(Context context, boolean z, String str) {
        p(context, "", str, true, true, true, true, z);
    }

    public static void t(Context context, boolean z, String str, String str2) {
        p(context, str2, str, true, true, true, true, z);
    }

    public static void u(boolean z, Context context, String str, String str2) {
        r(context, str, str2, true, true, true, true, true, false, z);
    }
}
