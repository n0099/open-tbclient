package d.a.g0.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f40916a;

    /* renamed from: b  reason: collision with root package name */
    public static String f40917b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40918c;

    /* renamed from: d  reason: collision with root package name */
    public static String f40919d;

    /* renamed from: e  reason: collision with root package name */
    public static String f40920e;

    public static String b(Context context) {
        try {
            if (TextUtils.isEmpty(f40916a)) {
                f40916a = d.a.g0.l.c.e(context);
            }
            return TextUtils.isEmpty(f40916a) ? "" : f40916a;
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
            return "";
        }
    }

    public static JSONObject c(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", b(context));
            jSONObject.put("3", d(context));
            jSONObject.put("2", f(context));
            jSONObject.put("4", g(context));
            jSONObject.put("5", str);
            jSONObject.put("6", System.currentTimeMillis());
            jSONObject.put("7", "0");
            jSONObject.put("8", d.a.g0.a.f40743b);
            jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
            jSONObject.put("10", "1.0.5");
            jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, d.a.g0.l.c.j(context));
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, e(context));
            jSONObject.put(SoUtils.SO_EVENT_ID_V8_SO, d.a.g0.g.a.a(context));
            jSONObject.put("31", d.a.g0.b.a.g(context).H());
            return jSONObject;
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
            return null;
        }
    }

    public static String d(Context context) {
        try {
            if (TextUtils.isEmpty(f40917b)) {
                f40917b = d.a.g0.l.c.h(context);
            }
            return TextUtils.isEmpty(f40917b) ? "" : f40917b;
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
            return "";
        }
    }

    public static String e(Context context) {
        try {
            if (!TextUtils.isEmpty(f40920e)) {
                return f40920e;
            }
            String b2 = d.a.g0.g.a.b(context);
            f40920e = b2;
            return b2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String f(Context context) {
        try {
            if (TextUtils.isEmpty(f40918c)) {
                f40918c = context.getPackageName();
            }
            return TextUtils.isEmpty(f40918c) ? "" : f40918c;
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
            return "";
        }
    }

    public static String g(Context context) {
        try {
            if (!TextUtils.isEmpty(f40919d)) {
                return f40919d;
            }
            String l = d.a.g0.l.d.l(context);
            f40919d = l;
            return l;
        } catch (Throwable unused) {
            return "";
        }
    }

    public d.a.g0.j.a a(Context context, String str, String str2, int i2, int i3) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            JSONObject c2 = c(context, str2);
            c2.put("module_section", jSONArray);
            d.a.g0.j.a aVar = new d.a.g0.j.a();
            aVar.e(i2);
            aVar.c(c2.toString());
            aVar.g(i3);
            return aVar;
        } catch (Throwable th) {
            d.a.g0.l.c.d(th);
            return null;
        }
    }
}
