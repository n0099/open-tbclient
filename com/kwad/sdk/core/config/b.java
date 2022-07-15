package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> a = new ConcurrentHashMap();
    public static SharedPreferences b = null;

    @Nullable
    public static Set<com.kwad.sdk.core.config.item.b> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a.get(str);
    }

    public static void a(Context context, com.kwad.sdk.core.config.item.b bVar) {
        SharedPreferences c;
        if (bVar == null || (c = c(context)) == null) {
            return;
        }
        try {
            bVar.a(c);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            for (String str : a.keySet()) {
                Set<com.kwad.sdk.core.config.item.b> set = a.get(str);
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.a(editor);
                        }
                    }
                }
            }
        }
    }

    public static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            for (String str : a.keySet()) {
                Set<com.kwad.sdk.core.config.item.b> set = a.get(str);
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e) {
                                com.kwad.sdk.core.d.b.b(e);
                            }
                        }
                    }
                }
            }
        }
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        String a2 = bVar.a();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> a3 = a(a2);
        if (a3 == null) {
            a3 = new CopyOnWriteArraySet<>();
            a.put(a2, a3);
        }
        a3.add(bVar);
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : a.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = a.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.a(jSONObject);
                    }
                }
            }
        }
    }

    @WorkerThread
    public static synchronized boolean a(Context context) {
        synchronized (b.class) {
            SharedPreferences c = c(context);
            if (c != null) {
                SharedPreferences.Editor edit = c.edit();
                a(edit);
                return edit.commit();
            }
            return false;
        }
    }

    @WorkerThread
    public static synchronized void b(Context context) {
        synchronized (b.class) {
            SharedPreferences c = c(context);
            if (c != null) {
                a(c);
            }
        }
    }

    public static SharedPreferences c(Context context) {
        if (b == null && context != null) {
            b = context.getSharedPreferences("ksadsdk_config", 0);
        }
        return b;
    }
}
