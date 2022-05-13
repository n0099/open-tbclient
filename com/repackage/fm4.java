package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.util.Base64Encoder;
import java.util.List;
/* loaded from: classes6.dex */
public class fm4 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(WebSettings webSettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, webSettings) == null) {
            CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (li.isEmpty(str) || str.indexOf("cuid=") > -1) {
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
        return (String) invokeL.objValue;
    }

    public static String c(String str, List<Pair<String, String>> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, list)) == null) {
            if (li.isEmpty(str) || list == null) {
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
        return (String) invokeLL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (li.isEmpty(str) || str.indexOf("_client_version=") <= -1) {
                return str + "&_client_version=" + TbConfig.getVersion();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String e() {
        CookieManager cookieManager;
        String[] split;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                cookieManager = CookieManager.getInstance();
            } catch (Exception e) {
                e.printStackTrace();
                cookieManager = null;
            }
            if (cookieManager == null) {
                return "";
            }
            String cookie = cookieManager.getCookie("*.baidu.com");
            if (TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) {
                cookie = a;
            }
            if (cookie != null) {
                for (String str : cookie.split(";")) {
                    if (str.contains("BAIDUID=")) {
                        return str.trim().substring(8);
                    }
                }
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static void f(Context context) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
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
            if ((mn4.b() != null ? mn4.b().c(TbadkCoreApplication.getCurrentBduss()) : null) != null) {
                String a2 = qn4.a(TbadkCoreApplication.getCurrentAccountInfo());
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
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            cookieManager.setCookie(".baidu.com", "CUID=" + TbadkCoreApplication.getInst().getCuid() + ";");
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            cookieManager.setCookie(".baidu.com", "BAIDUCUID=" + (!TextUtils.isEmpty(cuidGalaxy2) ? new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes())) : "") + ";");
            cookieManager.setCookie(".baidu.com", "TBBRAND=" + Build.MODEL + ";");
            cookieManager.setCookie(".baidu.com", "BAIDUZID=" + TbadkCoreApplication.getInst().getZid() + ";");
            cookieManager.setCookie(".baidu.com", "BAIDUID=" + TbSingleton.getInstance().getBaiduIdForAnti() + ";");
            cookieManager.setCookie(".baidu.com", "cuid_galaxy2=" + cuidGalaxy2 + ";");
            cookieManager.setCookie(".baidu.com", "cuid_gid=" + TbadkCoreApplication.getInst().getCuidGid() + ";");
            cookieManager.setCookie(".baidu.com", "BDUSS=" + TbadkCoreApplication.getCurrentBduss() + ";HttpOnly");
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
    }

    public static String g(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            new PvThread("open_webview", true).start();
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            a = str;
        }
    }

    public static void j(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) {
            k(context, str, true);
        }
    }

    public static void k(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65546, null, context, str, z) == null) {
            if (z) {
                str = d(b(str));
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                if (!(context instanceof Activity)) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                context.startActivity(intent);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void l(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, str) == null) {
            m(context, str);
        }
    }

    public static void m(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            v(context, true, str);
        }
    }

    public static void n(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, str, str2) == null) {
            r(context, str, str2, true, true, true, true, true);
        }
    }

    public static void o(Context context, String str, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65550, null, context, str, str2, bundle) == null) {
            u(context, str, str2, true, true, true, true, true, false, false, bundle);
        }
    }

    public static void p(Context context, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{context, str, str2, Boolean.valueOf(z)}) == null) {
            r(context, str, str2, true, z, true, true, true);
        }
    }

    public static void q(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            r(context, str, str2, z, z2, z3, true, true);
        }
    }

    public static void r(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            t(context, str, str2, z, z2, z3, z4, z5, false, false);
        }
    }

    public static void s(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6)}) == null) {
            t(context, str, str2, z, z2, z3, z4, z5, z6, false);
        }
    }

    public static void t(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7)}) == null) {
            u(context, str, str2, z, z2, z3, z4, z5, z6, z7, null);
        }
    }

    public static void u(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7), bundle}) == null) {
            h();
            try {
                if (StringUtils.isNull(str2)) {
                    return;
                }
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context, str, (bundle == null || bundle.getBoolean(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM, true)) ? z5 : false ? d(b(str2)) : str2, z, z2, z3);
                tbWebViewActivityConfig.setNeedImmerSiveSticky(z6);
                tbWebViewActivityConfig.setFixTitle(z7);
                tbWebViewActivityConfig.setBundle(bundle);
                if (bundle != null && bundle.getBoolean(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, false)) {
                    tbWebViewActivityConfig.setTextAutoSize(true);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void v(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{context, Boolean.valueOf(z), str}) == null) {
            r(context, "", str, true, true, true, true, z);
        }
    }

    public static void w(Context context, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, Boolean.valueOf(z), str, str2}) == null) {
            r(context, str2, str, true, true, true, true, z);
        }
    }

    public static void x(boolean z, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{Boolean.valueOf(z), context, str, str2}) == null) {
            t(context, str, str2, true, true, true, true, true, false, z);
        }
    }
}
