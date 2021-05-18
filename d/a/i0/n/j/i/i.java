package d.a.i0.n.j.i;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public static String f47969c = "PageTipsManager";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f47970d = d.a.i0.n.c.f47808a;

    /* renamed from: a  reason: collision with root package name */
    public c f47971a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f47972b;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final i f47973a = new i();
    }

    /* loaded from: classes3.dex */
    public static class c extends d.a.i0.t.j {
        public c() {
            super("updatecore_node_page_tips");
        }
    }

    public static i b() {
        return b.f47973a;
    }

    @NonNull
    public static JSONObject f(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            if (f47970d) {
                Log.w(f47969c, "JSONObject parsed error!!", e2);
            }
            return new JSONObject();
        }
    }

    public final void a() {
        Map<String, String> map = this.f47972b;
        if (map == null) {
            return;
        }
        map.clear();
        this.f47972b = null;
    }

    public Map<String, String> c() {
        Map<String, String> map = this.f47972b;
        if (map == null || map.size() < 1) {
            h();
        }
        return this.f47972b;
    }

    public String d() {
        return this.f47971a.getString("version", "0");
    }

    public final void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f47972b = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("tips");
                Map<String, String> map = this.f47972b;
                map.put(next + "_tips", optString);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("button");
                if (optJSONObject2 != null) {
                    String optString2 = optJSONObject2.optString("cmd");
                    if (!TextUtils.isEmpty(optString2)) {
                        Map<String, String> map2 = this.f47972b;
                        map2.put(next + "_btn_cmd", optString2);
                    }
                    String optString3 = optJSONObject2.optString("text");
                    if (!TextUtils.isEmpty(optString3)) {
                        Map<String, String> map3 = this.f47972b;
                        map3.put(next + "_btn_text", optString3);
                    }
                }
            }
        }
    }

    public void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a();
        e(optJSONObject);
        i(optJSONObject.toString(), optString);
    }

    public void h() {
        JSONObject f2 = f(this.f47971a.getString("page_error_tips", ""));
        a();
        e(f2);
    }

    public void i(String str, String str2) {
        if (str == null || str.isEmpty() || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = this.f47971a.edit();
        edit.clear();
        edit.putString("version", str2);
        edit.putString("page_error_tips", str);
        edit.apply();
        if (f47970d) {
            Log.d(f47969c, "write success");
        }
    }

    public i() {
        this.f47971a = new c();
    }
}
