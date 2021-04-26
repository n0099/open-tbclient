package d.a.h0.a.i1;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.e0.l.i;
import d.a.h0.a.h;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f42653e = k.f43101a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f42654f;

    /* renamed from: a  reason: collision with root package name */
    public String f42655a;

    /* renamed from: b  reason: collision with root package name */
    public String f42656b;

    /* renamed from: c  reason: collision with root package name */
    public String f42657c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.z.e.a f42658d;

    public static int a(int i2) {
        if (i2 != -2) {
            return i2 != 0 ? 6 : 0;
        }
        return 2;
    }

    public static a b() {
        if (f42654f == null) {
            synchronized (a.class) {
                if (f42654f == null) {
                    f42654f = new a();
                }
            }
        }
        return f42654f;
    }

    public static String d(UnitedSchemeEntity unitedSchemeEntity, String str) {
        String str2 = unitedSchemeEntity.getParams().get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new JSONObject(str2).optString(UserAccountActionItem.KEY_SRC);
        } catch (JSONException e2) {
            if (f42653e) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public boolean c(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        String d2 = d(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(d2)) {
            d.a.h0.a.c0.c.g("SwanAppPayLaunchMsg", "wxPay: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (!d.a.z.b.a().a(context)) {
            d.a.h0.a.q1.b.f.d.f(context, context.getText(h.aiapps_wx_not_install_toast_msg)).C();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, "had not installed WeChat");
            return false;
        } else if (!i.J2("wxPay", d.a.h0.a.e1.b.c(d2, d2))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            d.a.h0.a.c0.c.g("SwanAppPayLaunchMsg", "open wxPay page success");
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
