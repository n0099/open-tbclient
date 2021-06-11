package d.a.j0.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.swan.apps.so.SoUtils;
import com.tencent.connect.common.Constants;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f44101a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44102b;

    /* renamed from: c  reason: collision with root package name */
    public static String f44103c;

    /* renamed from: d  reason: collision with root package name */
    public static String f44104d;

    /* renamed from: e  reason: collision with root package name */
    public static String f44105e;

    public static String b(Context context) {
        try {
            if (TextUtils.isEmpty(f44101a)) {
                f44101a = d.a.j0.l.c.e(context);
            }
            return TextUtils.isEmpty(f44101a) ? "" : f44101a;
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
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
            jSONObject.put("8", d.a.j0.a.f43930b);
            jSONObject.put("9", AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO);
            jSONObject.put("10", "1.0.7");
            jSONObject.put("14", d.a.j0.l.c.j(context));
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, e(context));
            jSONObject.put(SoUtils.SO_EVENT_ID_V8_SO, d.a.j0.g.a.a(context));
            jSONObject.put(EventType.GiftEventID.SEND_GIFT_TO_USER_FAIL, d.a.j0.b.a.h(context).J());
            return jSONObject;
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
            return null;
        }
    }

    public static String d(Context context) {
        try {
            if (TextUtils.isEmpty(f44102b)) {
                f44102b = d.a.j0.l.c.h(context);
            }
            return TextUtils.isEmpty(f44102b) ? "" : f44102b;
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
            return "";
        }
    }

    public static String e(Context context) {
        try {
            if (!TextUtils.isEmpty(f44105e)) {
                return f44105e;
            }
            String b2 = d.a.j0.g.a.b(context, true, false);
            f44105e = b2;
            return b2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String f(Context context) {
        try {
            if (TextUtils.isEmpty(f44103c)) {
                f44103c = context.getPackageName();
            }
            return TextUtils.isEmpty(f44103c) ? "" : f44103c;
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
            return "";
        }
    }

    public static String g(Context context) {
        try {
            if (!TextUtils.isEmpty(f44104d)) {
                return f44104d;
            }
            String j = d.a.j0.l.d.j(context);
            f44104d = j;
            return j;
        } catch (Throwable unused) {
            return "";
        }
    }

    public d.a.j0.j.a a(Context context, String str, String str2, int i2, int i3) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            JSONObject c2 = c(context, str2);
            c2.put("module_section", jSONArray);
            d.a.j0.j.a aVar = new d.a.j0.j.a();
            aVar.e(i2);
            aVar.c(c2.toString());
            aVar.g(i3);
            return aVar;
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
            return null;
        }
    }
}
