package d.b.h0.a.t.c.n;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import d.b.h0.a.i2.k0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.h0.a.t.b.d {
    public b(@NonNull d.b.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public final d.b.h0.a.t.e.b q(JSONObject jSONObject) {
        d.b.h0.a.e0.f.k("data_init", "业务数据初始化异常");
        return new d.b.h0.a.t.e.b(0);
    }

    public d.b.h0.a.t.e.b r(String str) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-HandleException", "params = " + str);
        }
        if (k()) {
            d.b.h0.a.c0.c.b("Api-HandleException", "Api-HandleException does not supported when app is invisible.");
            return new d.b.h0.a.t.e.b(1001, "Api-HandleException does not supported when app is invisible.");
        }
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-HandleException", str);
        d.b.h0.a.t.e.b bVar = (d.b.h0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.h0.a.t.b.d.f46650c) {
                d.b.h0.a.c0.c.b("Api-HandleException", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("code");
        if (TextUtils.isEmpty(optString)) {
            return new d.b.h0.a.t.e.b(202, "code is required");
        }
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-HandleException", "code: " + optString + "msg: " + jSONObject.optString("msg"));
        }
        char c2 = 65535;
        int hashCode = optString.hashCode();
        if (hashCode != 48) {
            if (hashCode == 49 && optString.equals("1")) {
                c2 = 1;
            }
        } else if (optString.equals("0")) {
            c2 = 0;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                return new d.b.h0.a.t.e.b(202, "unsupported code");
            }
            return q(jSONObject);
        }
        return s(jSONObject);
    }

    public final d.b.h0.a.t.e.b s(JSONObject jSONObject) {
        String optString = jSONObject.optString("data");
        if (TextUtils.isEmpty(optString)) {
            return new d.b.h0.a.t.e.b(202, "data is required");
        }
        try {
            String optString2 = new JSONObject(optString).optString("path");
            if (TextUtils.isEmpty(optString2)) {
                return new d.b.h0.a.t.e.b(202, "path is required");
            }
            if (k0.F(optString2) && k0.E()) {
                d.b.h0.a.e0.f.k("skeleton", "5秒内未触发骨架屏移除");
            } else if (d.b.h0.a.t.b.d.f46650c) {
                Log.d("Api-HandleException", "path is not first page: " + optString2);
            }
            return new d.b.h0.a.t.e.b(0);
        } catch (JSONException e2) {
            if (d.b.h0.a.t.b.d.f46650c) {
                e2.printStackTrace();
            }
            return new d.b.h0.a.t.e.b(202, "invalid json data: " + optString);
        }
    }
}
