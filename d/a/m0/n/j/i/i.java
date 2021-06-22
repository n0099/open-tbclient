package d.a.m0.n.j.i;

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
    public static String f51927c = "PageTipsManager";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f51928d = d.a.m0.n.c.f51766a;

    /* renamed from: a  reason: collision with root package name */
    public c f51929a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f51930b;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final i f51931a = new i();
    }

    /* loaded from: classes3.dex */
    public static class c extends d.a.m0.t.j {
        public c() {
            super("updatecore_node_page_tips");
        }
    }

    public static i b() {
        return b.f51931a;
    }

    @NonNull
    public static JSONObject f(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            if (f51928d) {
                Log.w(f51927c, "JSONObject parsed error!!", e2);
            }
            return new JSONObject();
        }
    }

    public final void a() {
        Map<String, String> map = this.f51930b;
        if (map == null) {
            return;
        }
        map.clear();
        this.f51930b = null;
    }

    public Map<String, String> c() {
        Map<String, String> map = this.f51930b;
        if (map == null || map.size() < 1) {
            h();
        }
        return this.f51930b;
    }

    public String d() {
        return this.f51929a.getString("version", "0");
    }

    public final void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f51930b = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("tips");
                Map<String, String> map = this.f51930b;
                map.put(next + "_tips", optString);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("button");
                if (optJSONObject2 != null) {
                    String optString2 = optJSONObject2.optString("cmd");
                    if (!TextUtils.isEmpty(optString2)) {
                        Map<String, String> map2 = this.f51930b;
                        map2.put(next + "_btn_cmd", optString2);
                    }
                    String optString3 = optJSONObject2.optString("text");
                    if (!TextUtils.isEmpty(optString3)) {
                        Map<String, String> map3 = this.f51930b;
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
        JSONObject f2 = f(this.f51929a.getString("page_error_tips", ""));
        a();
        e(f2);
    }

    public void i(String str, String str2) {
        if (str == null || str.isEmpty() || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = this.f51929a.edit();
        edit.clear();
        edit.putString("version", str2);
        edit.putString("page_error_tips", str);
        edit.apply();
        if (f51928d) {
            Log.d(f51927c, "write success");
        }
    }

    public i() {
        this.f51929a = new c();
    }
}
