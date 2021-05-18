package d.a.i0.a.q1;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.h;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43990e = k.f43025a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f43991f;

    /* renamed from: a  reason: collision with root package name */
    public String f43992a;

    /* renamed from: b  reason: collision with root package name */
    public String f43993b;

    /* renamed from: c  reason: collision with root package name */
    public String f43994c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.z.e.a f43995d;

    public static int a(int i2) {
        if (i2 != -2) {
            return i2 != 0 ? 6 : 0;
        }
        return 2;
    }

    public static a b() {
        if (f43991f == null) {
            synchronized (a.class) {
                if (f43991f == null) {
                    f43991f = new a();
                }
            }
        }
        return f43991f;
    }

    public static String c(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRMSG, str2);
        } catch (JSONException e2) {
            if (f43990e) {
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
            return new JSONObject(str2).optString(UserAccountActionItem.KEY_SRC);
        } catch (JSONException e2) {
            if (f43990e) {
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
            if (f43990e) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public boolean e(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        String f2 = f(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(f2)) {
            d.a.i0.a.e0.d.g("SwanAppPayLaunchMsg", "wxPay: url is empty");
            d.a.i0.a.e0.d.h("SwanAppPayLaunchMsg", "param check error - src" + f2);
            d.a.i0.a.j2.k.D(false, "wechatH5Action", c(f2, "param check error - src"));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (!d.a.z.b.a().a(context)) {
            d.a.i0.a.z1.b.f.e.g(context, context.getText(h.aiapps_wx_not_install_toast_msg)).F();
            d.a.i0.a.e0.d.h("SwanAppPayLaunchMsg", "Error: wechat not install. " + f2);
            d.a.i0.a.j2.k.D(false, "wechatH5Action", c(f2, "Error: wechat not install. "));
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "had not installed WeChat");
            return false;
        } else {
            d.a.i0.a.l1.b e2 = d.a.i0.a.l1.b.e(f2, f2);
            d.a.i0.a.e0.d.h("SwanAppPayLaunchMsg", "Info: open wechat pay webview, pageParam =" + e2);
            if (!d.a.i0.a.h0.g.k.Q2("wxPay", e2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.i0.a.e0.d.h("SwanAppPayLaunchMsg", "Error: webview fragment not opened.");
                return false;
            }
            d.a.i0.a.e0.d.h("SwanAppPayLaunchMsg", "Success:open wxPay page success");
            d.a.i0.a.e0.d.h("SwanAppPayLaunchMsg", "Info: end WeChat H5 redirect " + f2);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(d(f2), 0));
            return true;
        }
    }
}
