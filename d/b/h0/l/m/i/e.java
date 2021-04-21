package d.b.h0.l.m.i;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.p.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static e f49750d;

    /* renamed from: a  reason: collision with root package name */
    public a f49751a = new a();

    /* renamed from: b  reason: collision with root package name */
    public String f49752b = AppRuntime.getAppContext().getString(d.b.h0.l.g.swan_launch_failed_default_dialog_msg);

    /* renamed from: c  reason: collision with root package name */
    public String f49753c = AppRuntime.getAppContext().getString(d.b.h0.l.g.swan_launch_failed_default_toast_msg);

    /* loaded from: classes3.dex */
    public static class a extends i {
        public a() {
            super("updatecore_node_tipmsgs");
        }
    }

    public static e b() {
        if (f49750d == null) {
            synchronized (e.class) {
                if (f49750d == null) {
                    f49750d = new e();
                }
            }
        }
        return f49750d;
    }

    public String a(long j) {
        return this.f49751a.getString(String.format("%04d", Long.valueOf(j)), this.f49752b);
    }

    public String c(long j) {
        return this.f49751a.getString(String.format("%04d", Long.valueOf(j)), this.f49753c);
    }

    public String d() {
        return this.f49751a.getString("tips_config_version", "0");
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
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            hashMap.put(optJSONObject.optString("tipno"), optJSONObject.optString("tipmsg"));
        }
        f(hashMap, optString);
    }

    public void f(HashMap<String, String> hashMap, String str) {
        if (hashMap == null || hashMap.isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = this.f49751a.edit();
        edit.clear();
        edit.putString("tips_config_version", str);
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue());
        }
        edit.apply();
    }
}
