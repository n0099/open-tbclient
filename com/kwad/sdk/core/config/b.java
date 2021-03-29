package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, com.kwad.sdk.core.config.item.a> f33436a = new ConcurrentHashMap();

    public static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            for (String str : f33436a.keySet()) {
                f33436a.get(str).a(editor);
            }
        }
    }

    public static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            for (String str : f33436a.keySet()) {
                f33436a.get(str).a(sharedPreferences);
            }
        }
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.a<T> aVar) {
        f33436a.put(aVar.a(), aVar);
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : f33436a.keySet()) {
            f33436a.get(str).a(jSONObject);
        }
    }

    @WorkerThread
    public static synchronized boolean a(Context context) {
        synchronized (b.class) {
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
