package d.b.g0.a.i1;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.e0.l.i;
import d.b.g0.a.h;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44616e = k.f45050a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f44617f;

    /* renamed from: a  reason: collision with root package name */
    public String f44618a;

    /* renamed from: b  reason: collision with root package name */
    public String f44619b;

    /* renamed from: c  reason: collision with root package name */
    public String f44620c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.b0.e.a f44621d;

    public static int a(int i) {
        if (i != -2) {
            return i != 0 ? 6 : 0;
        }
        return 2;
    }

    public static a b() {
        if (f44617f == null) {
            synchronized (a.class) {
                if (f44617f == null) {
                    f44617f = new a();
                }
            }
        }
        return f44617f;
    }

    public static String d(UnitedSchemeEntity unitedSchemeEntity, String str) {
        String str2 = unitedSchemeEntity.getParams().get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new JSONObject(str2).optString(UserAccountActionItem.KEY_SRC);
        } catch (JSONException e2) {
            if (f44616e) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public boolean c(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        String d2 = d(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(d2)) {
            d.b.g0.a.c0.c.g("SwanAppPayLaunchMsg", "wxPay: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (!d.b.b0.b.a().b(context)) {
            d.b.g0.a.q1.b.f.d.f(context, context.getText(h.aiapps_wx_not_install_toast_msg)).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "had not installed WeChat");
            return false;
        } else if (!i.K2("wxPay", d.b.g0.a.e1.b.c(d2, d2))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            d.b.g0.a.c0.c.g("SwanAppPayLaunchMsg", "open wxPay page success");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("finalUrl", d2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
    }
}
