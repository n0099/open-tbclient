package d.b.g0.h;

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
    public static String f43664a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43665b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43666c;

    /* renamed from: d  reason: collision with root package name */
    public static String f43667d;

    /* renamed from: e  reason: collision with root package name */
    public static String f43668e;

    public static String b(Context context) {
        try {
            if (TextUtils.isEmpty(f43664a)) {
                f43664a = d.b.g0.l.c.e(context);
            }
            return TextUtils.isEmpty(f43664a) ? "" : f43664a;
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
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
            jSONObject.put("8", d.b.g0.a.f43498b);
            jSONObject.put(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
            jSONObject.put("10", "1.0.5");
            jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, d.b.g0.l.c.j(context));
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, e(context));
            jSONObject.put(SoUtils.SO_EVENT_ID_V8_SO, d.b.g0.g.a.a(context));
            jSONObject.put("31", d.b.g0.b.a.g(context).H());
            return jSONObject;
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
            return null;
        }
    }

    public static String d(Context context) {
        try {
            if (TextUtils.isEmpty(f43665b)) {
                f43665b = d.b.g0.l.c.h(context);
            }
            return TextUtils.isEmpty(f43665b) ? "" : f43665b;
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
            return "";
        }
    }

    public static String e(Context context) {
        try {
            if (!TextUtils.isEmpty(f43668e)) {
                return f43668e;
            }
            String b2 = d.b.g0.g.a.b(context);
            f43668e = b2;
            return b2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String f(Context context) {
        try {
            if (TextUtils.isEmpty(f43666c)) {
                f43666c = context.getPackageName();
            }
            return TextUtils.isEmpty(f43666c) ? "" : f43666c;
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
            return "";
        }
    }

    public static String g(Context context) {
        try {
            if (!TextUtils.isEmpty(f43667d)) {
                return f43667d;
            }
            String l = d.b.g0.l.d.l(context);
            f43667d = l;
            return l;
        } catch (Throwable unused) {
            return "";
        }
    }

    public d.b.g0.j.a a(Context context, String str, String str2, int i, int i2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            JSONObject c2 = c(context, str2);
            c2.put("module_section", jSONArray);
            d.b.g0.j.a aVar = new d.b.g0.j.a();
            aVar.e(i);
            aVar.c(c2.toString());
            aVar.g(i2);
            return aVar;
        } catch (Throwable th) {
            d.b.g0.l.c.d(th);
            return null;
        }
    }
}
