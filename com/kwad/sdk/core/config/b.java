package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, com.kwad.sdk.core.config.item.a> f9344a = new ConcurrentHashMap();

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            for (String str : f9344a.keySet()) {
                f9344a.get(str).a(editor);
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            for (String str : f9344a.keySet()) {
                f9344a.get(str).a(sharedPreferences);
            }
        }
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.a<T> aVar) {
        f9344a.put(aVar.a(), aVar);
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : f9344a.keySet()) {
            f9344a.get(str).a(jSONObject);
        }
    }

    @WorkerThread
    public static synchronized boolean a(Context context) {
        boolean z = false;
        synchronized (b.class) {
            if (context != null) {
                SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_config", 0).edit();
                a(edit);
                z = edit.commit();
            }
        }
        return z;
    }

    @WorkerThread
    public static synchronized void b(Context context) {
        synchronized (b.class) {
            if (context != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_config", 0);
                if (sharedPreferences != null) {
                    a(sharedPreferences);
                }
            }
        }
    }
}
