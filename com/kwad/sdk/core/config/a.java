package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static final Map<String, com.kwad.sdk.core.config.item.b> a = new ConcurrentHashMap();

    public static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            for (String str : a.keySet()) {
                a.get(str).a(editor);
            }
        }
    }

    public static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            for (String str : a.keySet()) {
                try {
                    a.get(str).a(sharedPreferences);
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
        }
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        a.put(bVar.b(), bVar);
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : a.keySet()) {
            com.kwad.sdk.core.config.item.b bVar = a.get(str);
            if (jSONObject.has(str)) {
                bVar.a(jSONObject);
            }
        }
    }

    @WorkerThread
    public static synchronized boolean a(Context context) {
        synchronized (a.class) {
            if (context != null) {
                SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_config", 0).edit();
                a(edit);
                return edit.commit();
            }
            return false;
        }
    }

    @WorkerThread
    public static synchronized void b(Context context) {
        synchronized (a.class) {
            if (context != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_config", 0);
                if (sharedPreferences != null) {
                    a(sharedPreferences);
                }
            }
        }
    }
}
