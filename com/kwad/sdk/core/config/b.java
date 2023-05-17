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
/* loaded from: classes9.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> To = new ConcurrentHashMap();
    public static SharedPreferences Tp = null;

    public static void a(Context context, com.kwad.sdk.core.config.item.b bVar) {
        SharedPreferences aS;
        if (bVar == null || (aS = aS(context)) == null) {
            return;
        }
        try {
            bVar.a(aS);
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            for (String str : To.keySet()) {
                Set<com.kwad.sdk.core.config.item.b> set = To.get(str);
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.b(editor);
                        }
                    }
                }
            }
        }
    }

    public static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            for (String str : To.keySet()) {
                Set<com.kwad.sdk.core.config.item.b> set = To.get(str);
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e) {
                                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                            }
                        }
                    }
                }
            }
        }
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> bs = bs(key);
        if (bs == null) {
            bs = new CopyOnWriteArraySet<>();
            To.put(key, bs);
        }
        bs.add(bVar);
    }

    public static SharedPreferences aS(Context context) {
        if (Tp == null && context != null) {
            Tp = context.getSharedPreferences("ksadsdk_config", 0);
        }
        return Tp;
    }

    @WorkerThread
    public static synchronized boolean aT(Context context) {
        synchronized (b.class) {
            SharedPreferences aS = aS(context);
            if (aS != null) {
                SharedPreferences.Editor edit = aS.edit();
                a(edit);
                return edit.commit();
            }
            return false;
        }
    }

    @WorkerThread
    public static synchronized void aU(Context context) {
        synchronized (b.class) {
            SharedPreferences aS = aS(context);
            if (aS != null) {
                a(aS);
            }
        }
    }

    @Nullable
    public static Set<com.kwad.sdk.core.config.item.b> bs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return To.get(str);
    }

    public static void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : To.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = To.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.e(jSONObject);
                    }
                }
            }
        }
    }
}
