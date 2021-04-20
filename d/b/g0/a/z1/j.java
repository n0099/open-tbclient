package d.b.g0.a.z1;

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
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.z1.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j extends d.b.g0.a.n1.a.a.a {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47642f = k.f45443a;

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
                d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
                if (y != null) {
                    b.a L = y.L();
                    jSONObject2.put("launchInfo", L == null ? StringUtil.NULL_STRING : L.A1());
                    SwanAppActivity n = y.n();
                    d.b.g0.a.y0.e.b bVar = null;
                    if (n != null && (intent = n.getIntent()) != null) {
                        bVar = d.b.g0.a.y0.e.b.V0(intent);
                    }
                    if (bVar != null) {
                        str3 = bVar.A1();
                    }
                    jSONObject2.put("launchInfoIntent", str3);
                } else {
                    jSONObject2.put("swanApp", StringUtil.NULL_STRING);
                }
                jSONObject2.put("stackTrace", k0.u());
                if (jSONObject != null) {
                    jSONObject2.put("reportExtInfo", jSONObject);
                }
            } catch (JSONException e2) {
                if (f47642f) {
                    e2.printStackTrace();
                }
            }
            d.b.g0.a.n1.c.e.a q = d.b.g0.a.r1.d.e().q();
            if (q != null) {
                Bundle bundle = new Bundle();
                bundle.putString("key_swan_appid", str);
                bundle.putString("key_report_info", jSONObject2.toString());
                q.I(bundle, j.class);
            }
        }
    }

    @Override // d.b.g0.a.n1.a.a.a
    public void b(@NonNull Bundle bundle) {
        d.b.g0.a.g0.a o;
        String string = bundle.getString("key_swan_appid", "");
        String string2 = bundle.getString("key_report_info", "");
        String str = TextUtils.isEmpty(string2) ? "" : string2;
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            if (f47642f) {
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
        if (f47642f) {
            Log.d("VersionBusinessUbc", "report info: " + jSONObject.toString());
        }
        c.b bVar = new c.b(10002);
        bVar.i(jSONObject.toString());
        bVar.l();
        c();
    }
}
