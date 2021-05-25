package d.b.d.b.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.internal.ETAG;
import d.b.d.b.l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f65887a;

    public a() {
        this.f65887a = new JSONObject();
    }

    public static a c(long j, Context context, @Nullable Thread thread, @NonNull Throwable th) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        a aVar = new a();
        aVar.k("isJava", 1);
        aVar.k("event_type", "java_crash");
        aVar.k("timestamp", Long.valueOf(System.currentTimeMillis()));
        aVar.k("data", l.n.a(th));
        aVar.k("isOOM", Boolean.valueOf(l.n.h(th)));
        aVar.k("crash_time", Long.valueOf(j));
        aVar.k("process_name", l.b.k(context));
        if (!l.b.i(context)) {
            aVar.k("remote_process", 1);
        }
        l.b.d(context, aVar.j());
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            aVar.k("crash_thread_name", name);
        }
        aVar.k("all_thread_stacks", l.n.d(name));
        return aVar;
    }

    public a a(int i2, String str) {
        try {
            this.f65887a.put("miniapp_id", i2);
            this.f65887a.put("miniapp_version", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this;
    }

    public a b(long j) {
        try {
            k("start_time", Long.valueOf(j));
            k("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this;
    }

    public a d(b bVar) {
        k("header", bVar.b());
        return this;
    }

    public a e(d.b.d.b.h.a.b bVar) {
        k("activity_trace", bVar.d());
        k("running_tasks", bVar.i());
        return this;
    }

    public a f(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            k(ETAG.KEY_STATISTICS_SEESIONID, str);
        }
        return this;
    }

    public a g(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                jSONArray.put(str);
            }
            k("patch_info", jSONArray);
            return this;
        }
        k("patch_info", jSONArray);
        return this;
    }

    public a h(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        if (map == null) {
            this.f65887a.put("plugin_info", jSONArray);
            return this;
        }
        for (String str : map.keySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("package_name", str);
            jSONObject.put("version_code", map.get(str));
            jSONArray.put(jSONObject);
        }
        this.f65887a.put("plugin_info", jSONArray);
        return this;
    }

    public a i(JSONObject jSONObject) {
        k("storage", jSONObject);
        return this;
    }

    public JSONObject j() {
        return this.f65887a;
    }

    public void k(@NonNull String str, @Nullable Object obj) {
        try {
            this.f65887a.put(str, obj);
        } catch (Exception e2) {
            l.k.c(e2);
        }
    }

    public a l(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        k("logcat", jSONArray);
        return this;
    }

    public a m(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e2) {
                    l.k.c(e2);
                }
            }
            try {
                this.f65887a.put("sdk_info", jSONObject);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return this;
    }

    public a n(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            k("filters", jSONObject);
        }
        return this;
    }

    public a(JSONObject jSONObject) {
        this.f65887a = jSONObject;
    }
}
