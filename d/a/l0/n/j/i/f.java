package d.a.l0.n.j.i;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: d  reason: collision with root package name */
    public static f f51812d;

    /* renamed from: a  reason: collision with root package name */
    public a f51813a = new a();

    /* renamed from: b  reason: collision with root package name */
    public String f51814b = AppRuntime.getAppContext().getString(d.a.l0.n.e.swan_launch_failed_default_dialog_msg);

    /* renamed from: c  reason: collision with root package name */
    public String f51815c = AppRuntime.getAppContext().getString(d.a.l0.n.e.swan_launch_failed_default_toast_msg);

    /* loaded from: classes3.dex */
    public static class a extends d.a.l0.t.j {
        public a() {
            super("updatecore_node_tipmsgs");
        }
    }

    public static f b() {
        if (f51812d == null) {
            synchronized (f.class) {
                if (f51812d == null) {
                    f51812d = new f();
                }
            }
        }
        return f51812d;
    }

    public String a(long j) {
        return this.f51813a.getString(String.format("%04d", Long.valueOf(j)), this.f51814b);
    }

    public String c(long j) {
        return this.f51813a.getString(String.format("%04d", Long.valueOf(j)), this.f51815c);
    }

    public String d() {
        return this.f51813a.getString("tips_config_version", "0");
    }

    public void e(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>(optJSONArray.length());
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            hashMap.put(optJSONObject.optString("tipno"), optJSONObject.optString("tipmsg"));
        }
        f(hashMap, optString);
    }

    public void f(HashMap<String, String> hashMap, String str) {
        if (hashMap == null || hashMap.isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = this.f51813a.edit();
        edit.clear();
        edit.putString("tips_config_version", str);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue());
        }
        edit.apply();
    }
}
