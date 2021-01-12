package com.bytedance.tea.crash.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ar.pose.PoseAR;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.g.m;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected JSONObject f7626a;

    public a() {
        this.f7626a = new JSONObject();
    }

    public a(JSONObject jSONObject) {
        this.f7626a = jSONObject;
    }

    public static a a(long j, Context context, @Nullable Thread thread, @NonNull Throwable th) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        a aVar = new a();
        aVar.a("isJava", 1);
        aVar.a(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "java_crash");
        aVar.a("timestamp", Long.valueOf(System.currentTimeMillis()));
        aVar.a("data", m.a(th));
        aVar.a("isOOM", Boolean.valueOf(m.b(th)));
        aVar.a("crash_time", Long.valueOf(j));
        aVar.a("process_name", com.bytedance.tea.crash.g.a.d(context));
        if (!com.bytedance.tea.crash.g.a.b(context)) {
            aVar.a("remote_process", 1);
        }
        com.bytedance.tea.crash.g.a.a(context, aVar.a());
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            aVar.a("crash_thread_name", name);
        }
        aVar.a("all_thread_stacks", m.a(name));
        return aVar;
    }

    public JSONObject a() {
        return this.f7626a;
    }

    public a a(b bVar) {
        a(WebSocketRequest.PARAM_KEY_HEADER, bVar.a());
        return this;
    }

    public a iv(long j) {
        try {
            a("start_time", Long.valueOf(j));
            a("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public a XQ(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            a("session_id", str);
        }
        return this;
    }

    public a a(com.bytedance.tea.crash.e.a.b bVar) {
        a("activity_trace", bVar.a());
        a("running_tasks", bVar.b());
        return this;
    }

    public a J(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            if (map == null) {
                this.f7626a.put("plugin_info", jSONArray);
            } else {
                for (String str : map.keySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("package_name", str);
                    jSONObject.put("version_code", map.get(str));
                    jSONArray.put(jSONObject);
                }
                this.f7626a.put("plugin_info", jSONArray);
            }
        } catch (Exception e) {
        }
        return this;
    }

    public a K(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    j.b(e);
                }
            }
            try {
                this.f7626a.put("sdk_info", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    public a cb(int i, String str) {
        try {
            this.f7626a.put("miniapp_id", i);
            this.f7626a.put("miniapp_version", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public a gI(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            a("patch_info", jSONArray);
        } else {
            for (String str : list) {
                jSONArray.put(str);
            }
            a("patch_info", jSONArray);
        }
        return this;
    }

    public a eS(JSONObject jSONObject) {
        a("storage", jSONObject);
        return this;
    }

    public a gJ(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        a("logcat", jSONArray);
        return this;
    }

    public a L(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            a("filters", jSONObject);
        }
        return this;
    }

    public void a(@NonNull String str, @Nullable Object obj) {
        try {
            this.f7626a.put(str, obj);
        } catch (Exception e) {
            j.b(e);
        }
    }
}
