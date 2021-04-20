package d.b.g0.b.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import d.b.g0.a.i2.i0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47697a = d.b.g0.a.k.f45443a;

    public static String a(String str, String str2) {
        return b(str, HttpRequest.BDUSS, str2);
    }

    public static String b(String str, String str2, String str3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return c(str, str2, str3, calendar.getTime(), false);
    }

    public static String c(String str, String str2, String str3, Date date, boolean z) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        sb.append(";domain=");
        sb.append(str);
        sb.append(";path=/;expires=");
        sb.append(simpleDateFormat.format(date));
        sb.append(";httponly");
        sb.append(z ? ";secure" : "");
        return sb.toString();
    }

    public static String d(String str, String str2) {
        return b(str, "PTOKEN", str2);
    }

    public static List<String> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }

    public static void f(String str, String str2, boolean z) {
        CookieManager.getInstance().setCookie(str, str2);
        if (z) {
            CookieSyncManager.getInstance().sync();
        }
    }

    public static void g(Context context, String str, List<String> list) {
        String a2;
        if (list == null) {
            if (f47697a) {
                Log.w("SwanAppCookieUtils", "bduss domains is invalid");
                return;
            }
            return;
        }
        for (String str2 : list) {
            if (TextUtils.isEmpty(str)) {
                a2 = i0.j(str2, HttpRequest.BDUSS, "deleted", 0L);
            } else {
                a2 = a(str2, str);
            }
            f("http://www." + str2, a2, false);
        }
    }

    public static void h(Context context) {
        if (context == null) {
            return;
        }
        String i = a.i(context);
        String r = a.r(context);
        g(context, i, e());
        j(context, r, e());
    }

    public static void i(Context context) {
        h(context);
    }

    public static void j(Context context, String str, List<String> list) {
        String d2;
        if (list == null) {
            if (f47697a) {
                Log.w("SwanAppCookieUtils", "ptoken domains is invalid");
                return;
            }
            return;
        }
        for (String str2 : list) {
            if (TextUtils.isEmpty(str)) {
                d2 = i0.j(str2, "PTOKEN", "deleted", 0L);
            } else {
                d2 = d(str2, str);
            }
            f("http://www." + str2, d2, false);
        }
    }
}
