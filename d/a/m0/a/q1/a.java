package d.a.m0.a.q1;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.h;
import d.a.m0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47948e = k.f46983a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f47949f;

    /* renamed from: a  reason: collision with root package name */
    public String f47950a;

    /* renamed from: b  reason: collision with root package name */
    public String f47951b;

    /* renamed from: c  reason: collision with root package name */
    public String f47952c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.b0.e.a f47953d;

    public static int a(int i2) {
        if (i2 != -2) {
            return i2 != 0 ? 6 : 0;
        }
        return 2;
    }

    public static a b() {
        if (f47949f == null) {
            synchronized (a.class) {
                if (f47949f == null) {
                    f47949f = new a();
                }
            }
        }
        return f47949f;
    }

    public static String c(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRMSG, str2);
        } catch (JSONException e2) {
            if (f47948e) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static String f(UnitedSchemeEntity unitedSchemeEntity, String str) {
        String str2 = unitedSchemeEntity.getParams().get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new JSONObject(str2).optString("src");
        } catch (JSONException e2) {
            if (f47948e) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("finalUrl", str);
        } catch (JSONException e2) {
            if (f47948e) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public boolean e(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        String f2 = f(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(f2)) {
            d.a.m0.a.e0.d.g("SwanAppPayLaunchMsg", "wxPay: url is empty");
            d.a.m0.a.e0.d.h("SwanAppPayLaunchMsg", "param check error - src" + f2);
            d.a.m0.a.j2.k.D(false, "wechatH5Action", c(f2, "param check error - src"));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (!d.a.b0.b.a().a(context)) {
            d.a.m0.a.z1.b.f.e.g(context, context.getText(h.aiapps_wx_not_install_toast_msg)).F();
            d.a.m0.a.e0.d.h("SwanAppPayLaunchMsg", "Error: wechat not install. " + f2);
            d.a.m0.a.j2.k.D(false, "wechatH5Action", c(f2, "Error: wechat not install. "));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "had not installed WeChat");
            return false;
        } else {
            d.a.m0.a.l1.b e2 = d.a.m0.a.l1.b.e(f2, f2);
            d.a.m0.a.e0.d.h("SwanAppPayLaunchMsg", "Info: open wechat pay webview, pageParam =" + e2);
            if (!d.a.m0.a.h0.g.k.Q2("wxPay", e2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.m0.a.e0.d.h("SwanAppPayLaunchMsg", "Error: webview fragment not opened.");
                return false;
            }
            d.a.m0.a.e0.d.h("SwanAppPayLaunchMsg", "Success:open wxPay page success");
            d.a.m0.a.e0.d.h("SwanAppPayLaunchMsg", "Info: end WeChat H5 redirect " + f2);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(d(f2), 0));
            return true;
        }
    }
}
