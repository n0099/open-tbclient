package d.a.l0.a.j2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.database.SwanAppDbControl;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.j2.c;
import d.a.l0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends d.a.l0.a.v1.a.a.a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f43173f = d.a.l0.a.k.f43199a;

    public static boolean e(@Nullable String str) {
        return TextUtils.isEmpty(str) || TextUtils.equals("0", str);
    }

    public static void f(String str, String str2, @Nullable JSONObject jSONObject) {
        Intent intent;
        if (e(str2)) {
            JSONObject jSONObject2 = new JSONObject();
            String str3 = StringUtil.NULL_STRING;
            if (str2 == null) {
                str2 = StringUtil.NULL_STRING;
            }
            try {
                jSONObject2.put("version", str2);
                jSONObject2.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str == null ? StringUtil.NULL_STRING : str);
                d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
                if (i2 != null) {
                    b.a N = i2.N();
                    jSONObject2.put("launchInfo", N == null ? StringUtil.NULL_STRING : N.H1());
                    SwanAppActivity x = i2.x();
                    d.a.l0.a.f1.e.b bVar = null;
                    if (x != null && (intent = x.getIntent()) != null) {
                        bVar = d.a.l0.a.f1.e.b.b1(intent);
                    }
                    if (bVar != null) {
                        str3 = bVar.H1();
                    }
                    jSONObject2.put("launchInfoIntent", str3);
                } else {
                    jSONObject2.put("swanApp", StringUtil.NULL_STRING);
                }
                jSONObject2.put("stackTrace", q0.y());
                if (jSONObject != null) {
                    jSONObject2.put("reportExtInfo", jSONObject);
                }
            } catch (JSONException e2) {
                if (f43173f) {
                    e2.printStackTrace();
                }
            }
            d.a.l0.a.v1.c.e.a z = d.a.l0.a.a2.d.g().z();
            if (z != null) {
                Bundle bundle = new Bundle();
                bundle.putString("key_swan_appid", str);
                bundle.putString("key_report_info", jSONObject2.toString());
                z.K(bundle, m.class);
            }
        }
    }

    @Override // d.a.l0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        d.a.l0.a.j0.a o;
        String string = bundle.getString("key_swan_appid", "");
        String string2 = bundle.getString("key_report_info", "");
        String str = TextUtils.isEmpty(string2) ? "" : string2;
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            if (f43173f) {
                Log.e("VersionBusinessUbc", "execCall: ", e2);
            }
            e2.printStackTrace();
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!TextUtils.isEmpty(string) && (o = SwanAppDbControl.f(AppRuntime.getAppContext()).o(string)) != null) {
            try {
                jSONObject.put("appDbInfo", o.a());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (f43173f) {
            Log.d("VersionBusinessUbc", "report info: " + jSONObject.toString());
        }
        c.b bVar = new c.b(10002);
        bVar.i(jSONObject.toString());
        bVar.m();
        c();
    }
}
