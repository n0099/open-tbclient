package d.b.h0.b;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f49689b;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, a> f49690a = new HashMap<>();

    public b() {
        HashMap<String, a> d2 = d();
        this.f49690a.clear();
        this.f49690a.putAll(d2);
    }

    public static b e() {
        if (f49689b == null) {
            synchronized (b.class) {
                if (f49689b == null) {
                    f49689b = new b();
                }
            }
        }
        return f49689b;
    }

    public static String f() {
        return "pref_name_abtest_" + TbadkCoreApplication.getCurrentAccount();
    }

    public static SharedPreferences g() {
        return TbadkCoreApplication.getInst().getSharedPreferences(f(), 0);
    }

    public static boolean h(String str) {
        return "a".equalsIgnoreCase(e().b(str, ""));
    }

    public final void a() {
        try {
            synchronized (this.f49690a) {
                this.f49690a.clear();
            }
            SharedPreferences.Editor edit = g().edit();
            edit.clear();
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String b(String str, String str2) {
        a c2 = c(str);
        return (c2 == null || TextUtils.isEmpty(c2.f49688a)) ? str2 : c2.f49688a;
    }

    public synchronized a c(String str) {
        return this.f49690a.get(str);
    }

    public final HashMap<String, a> d() {
        HashMap<String, a> hashMap = new HashMap<>();
        try {
            JSONArray jSONArray = new JSONArray(g().getString("pref_key_abtest_switchs", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("name");
                    hashMap.put(optString, new a(optString, jSONObject.optString("branch"), jSONObject.optString(TbConfig.TMP_LOG_DIR_NAME)));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hashMap;
    }

    public void i(JSONArray jSONArray) {
        try {
            if (jSONArray == null) {
                a();
                return;
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("name");
                    hashMap.put(optString, new a(optString, jSONObject.optString("branch"), jSONObject.optString(TbConfig.TMP_LOG_DIR_NAME)));
                }
            }
            synchronized (this.f49690a) {
                this.f49690a.clear();
                this.f49690a.putAll(hashMap);
            }
            EditorHelper.putString(g(), "pref_key_abtest_switchs", jSONArray.toString());
            d.b.h0.r.d0.b.i().u("perf_start_open", h("performance_start_small_flow") ? 1 : 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
